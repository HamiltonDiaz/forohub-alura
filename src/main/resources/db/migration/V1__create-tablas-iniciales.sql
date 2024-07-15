create table usuarios(

                        id bigint not null auto_increment,
                        nombre varchar(100) not null,
                        correo_electronico varchar(200) not null unique,
                        clave varchar(100) not null,
                        primary key(id)
);

create table cursos(
                        id bigint not null auto_increment,
                        nombre varchar(100) not null,
                        categoria varchar(100) not null unique,
                        fecha_de_creacion DATE NOT NULL,
                        fecha_de_modificacion DATE,
                        primary key(id)
);
create table topicos(
                        id bigint not null auto_increment,
                        titulo varchar(100) not null,
                        mensaje text(2000) not null unique,
                        status_topico varchar(100) not null,
                        autor varchar(100) not null,
                        curso_id bigint not null,

                        fecha_de_creacion DATE NOT NULL,
                        fecha_de_modificacion DATE,
                        primary key(id),

                        CONSTRAINT fk_cursos FOREIGN KEY (curso_id) REFERENCES cursos(id)
);
create table respuestas(
                        id bigint not null auto_increment,
                        mensaje varchar(100) not null,
                        autor varchar(100) not null,
                        solucion text(2000) not null,
                        topico_id bigint not null,
                        fecha_de_creacion DATE NOT NULL,
                        fecha_de_modificacion DATE,

                        primary key(id),
                        CONSTRAINT fk_topicos FOREIGN KEY (topico_id) REFERENCES topicos(id)
);