package com.tec.workflix.models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "Usuario")
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String correo;
    @Column
    private String telefono;
    @Column
    private String clave;
    @Column
    private String direccion;
    @Column
    private String ciudad;
    @Column
    private String provincia;
    @Column
    private String descripcion;
    @Column
    private String foto;
    @Column
    private String profesion;
    @Column(columnDefinition = "boolean default false")
    private boolean is_admin;

    public Usuario() {
        is_admin = false; // Establecer el valor predeterminado a false en el constructor
    }


}
