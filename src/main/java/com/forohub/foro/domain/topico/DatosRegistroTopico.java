package com.forohub.foro.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DatosRegistroTopico(
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
