package com.forohub.foro.domain.topico;

import com.forohub.foro.domain.curso.CursoRepository;
import com.forohub.foro.domain.topico.valicadaciones.ValidacionesTopico;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private List<ValidacionesTopico> validacionesTopicos;


    public Topico createTopico(DatosRegistroTopico datos) {
        validacionesTopicos.forEach(v-> v.validar(datos));
        Topico saveTopico = new Topico();
        saveTopico.setTitulo(datos.titulo());
        saveTopico.setStatusTopico(StatusTopico.EN_ESPERA);
        saveTopico.setAutor(datos.autor());
        saveTopico.setCurso(cursoRepository.getReferenceById(datos.idCurso()));
        saveTopico.setMensaje(datos.mensaje());
        saveTopico.setFechaDeCreacion(LocalDateTime.now());

        return topicoRepository.save(saveTopico);
    }

    @Transactional
    public Topico udpateTopico(DatosActualizaTopico datos) {
        if (datos.id()==null) {
            throw new RuntimeException("El id del topico no puede ser nulo");
        }
        Topico updateTopico= topicoRepository.getReferenceById(datos.idCurso());
        updateTopico.setTitulo(datos.titulo());
        updateTopico.setAutor(datos.autor());
        updateTopico.setCurso(cursoRepository.getReferenceById(datos.idCurso()));
        updateTopico.setMensaje(datos.mensaje());
        updateTopico.setFechaDeModificacion(LocalDateTime.now());
        return topicoRepository.save(updateTopico);
    }

    @Transactional
    public Topico updateStatus(Long id) {
        if (id==null) {
            throw new RuntimeException("El id del topico no puede ser nulo");
        }

        if (topicoRepository.existsById(id)) {
            Topico updateTopico= topicoRepository.getReferenceById(id);
            updateTopico.setStatusTopico(StatusTopico.ELIMINADO);
            updateTopico.setFechaDeModificacion(LocalDateTime.now());
            return topicoRepository.save(updateTopico);
        }
        throw new RuntimeException("No existe un regitro con este id");

    }

    public Page<DatosDetalleTopico> listarTopicos(Pageable paginacion) {
        return topicoRepository.listarTopicos(paginacion,StatusTopico.ELIMINADO);
    }
}
