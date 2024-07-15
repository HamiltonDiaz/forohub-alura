package com.forohub.foro.domain.topico;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DatosDetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion
) {
}
