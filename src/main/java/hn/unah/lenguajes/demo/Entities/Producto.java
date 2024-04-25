package hn.unah.lenguajes.demo.Entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "producto")
@Data
public class Producto {
    
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproducto")
    private long idproducto;

    private String nombre;

    private String descripcion;

    private double precio;

    private String categoria;

   
}
