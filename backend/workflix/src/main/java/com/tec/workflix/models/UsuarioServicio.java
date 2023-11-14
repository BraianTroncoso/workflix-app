package com.tec.workflix.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Usuario_Servicio")
public class UsuarioServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;

}