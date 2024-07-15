package com.forohub.foro.controller;


import com.forohub.foro.domain.topico.DatosDetalleTopico;
import com.forohub.foro.domain.topico.DatosRegistroTopico;
import com.forohub.foro.domain.topico.Topico;
import com.forohub.foro.domain.topico.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoService service;

    @PostMapping
    public ResponseEntity addTopico(@RequestBody @Valid DatosRegistroTopico datos,
                                    UriComponentsBuilder uriBuilder) {
        Topico topico = service.createTopico(datos);
        URI url= uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(new DatosDetalleTopico(topico));

    }
}
