package com.forohub.foro.controller;


import com.forohub.foro.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoService service;

    @PostMapping
    public ResponseEntity<DatosDetalleTopico> addTopico(@RequestBody @Valid DatosRegistroTopico datos,                                    UriComponentsBuilder uriBuilder) {
        Topico topico = service.createTopico(datos);
        URI url= uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(new DatosDetalleTopico(topico));
    }
    @PutMapping
    public ResponseEntity<DatosDetalleTopico> updateTopico(@RequestBody @Valid DatosActualizaTopico datos) {
        Topico topico = service.udpateTopico(datos);
        return ResponseEntity.ok().body(new DatosDetalleTopico(topico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DatosDetalleTopico> updateTopicoStatus(@PathVariable Long id) {
        Topico topico = service.updateStatus(id);
        return ResponseEntity.ok().body(new DatosDetalleTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DatosDetalleTopico>> listadoMedicos(@PageableDefault(size = 2) Pageable paginacion){
        return ResponseEntity.ok(service.listarTopicos(paginacion));
    }

}
