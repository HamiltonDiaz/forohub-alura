package com.forohub.foro.domain.topico.valicadaciones;

import com.forohub.foro.domain.Curso.CursoRepository;
import com.forohub.foro.domain.topico.DatosRegistroTopico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidaCurso implements ValidacionesTopico{
    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public void validar(DatosRegistroTopico datos) {
        if (datos.idCurso()==null)
            return;
        if (!cursoRepository.existsById(datos.idCurso())){
            throw new RuntimeException("Curso no encontrado");
        }
    }
}
