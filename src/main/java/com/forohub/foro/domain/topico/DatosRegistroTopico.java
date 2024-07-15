package com.forohub.foro.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DatosRegistroTopico(
        Long id,
        @NotNull
        Long idUsuario,
        @NotBlank
        String mensaje,
        @NotBlank
        String titulo,
        LocalDateTime fechaCreacion
) {
}
