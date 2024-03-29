package com.proyecto.Tienda_ropa_JL.Models.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "client")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    private String apellido;
    private String telefono;
    @Column(nullable = false)
    private String correo;
    @Column(nullable = false)
    private String contrasena;
    private String rol="Cliente";
    private Boolean conectado=false;
}
