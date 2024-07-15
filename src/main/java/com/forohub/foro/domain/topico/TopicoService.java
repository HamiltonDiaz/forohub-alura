package com.forohub.foro.domain.topico;

import com.forohub.foro.domain.Curso.CursoRepository;
import com.forohub.foro.domain.topico.valicadaciones.ValidacionesTopico;
import org.springframework.beans.factory.annotation.Autowired;
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
}
