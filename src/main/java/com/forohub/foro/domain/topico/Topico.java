package com.forohub.foro.domain.topico;


import com.forohub.foro.domain.curso.Curso;
import com.forohub.foro.domain.base.Base;
import com.forohub.foro.domain.respuesta.Respuesta;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "topicos")
@Entity(name = "Topico")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico extends Base {
    private String titulo;
    private String mensaje;
    @Enumerated(EnumType.STRING)
    private StatusTopico statusTopico;
    private String autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL)
    private List<Respuesta> respuesta;


}
