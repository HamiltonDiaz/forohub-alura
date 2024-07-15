package com.forohub.foro.domain.topico;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DatosDetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        StatusTopico status,
        LocalDateTime fechaCreacion
) {
    public DatosDetalleTopico(Topico topico) {
        this(
            topico.getId(),
            topico.getTitulo(),
            topico.getMensaje(),
            topico.getStatusTopico(),
            topico.getFechaDeCreacion()
        );
    }
}
