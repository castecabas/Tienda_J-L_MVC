package com.proyecto.Tienda_ropa_JL.Models.Entities;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="sale")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer valor_costo;
    private Integer valor_venta;
    private Integer impuesto;
    private String descripcion_imp;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE) // Indica que solo se almacenará la fecha sin la hora
    @DateTimeFormat(pattern = "dd/MM/yyyy") // Especifica el formato de entrada y salida
    private Date creacion;

    @PrePersist
    public void set_creacion(){
        this.creacion= Date.valueOf(LocalDate.now());
    }
}
