package com.proyecto.Tienda_ropa_JL.Models.Entities;


import java.math.BigDecimal;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="product")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    private BigDecimal precio;
    private String talla;
    private String marca;
    private Integer stock;
    private Integer descuento;
    private String urlimage;
}
