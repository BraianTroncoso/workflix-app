package com.tec.workflix.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "Servicio")
@Entity
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    private String nombre;

    public Servicio() {
    }

    public Servicio(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

}
