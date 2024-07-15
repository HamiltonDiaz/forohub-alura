package com.forohub.foro.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    @Query("""
           select t from Topico t
           where t.statusTopico!=:status
        """)
    Page<DatosDetalleTopico> listarTopicos(Pageable paginacion, StatusTopico status);
}
