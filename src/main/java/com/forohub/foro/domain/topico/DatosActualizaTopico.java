package com.forohub.foro.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosActualizaTopico(
        @NotNull
        Long id,
        @NotNull
        Long idCurso,
        @NotBlank
        String mensaje,
        @NotBlank
        String titulo,
        @NotBlank
        String autor,
        StatusTopico statusTopico,
        LocalDateTime fechaCreacion
) {
}
