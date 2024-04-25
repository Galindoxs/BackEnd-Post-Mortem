package hn.unah.lenguajes.demo.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "clientes")
@Data

public class Cliente {

    @Id // Es para saber que es PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Esta linea genera automaticamente numero de id empezando desde 1
    @Column(name = "id")
    private Long id;  

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "identidad")
    private String identidad;

    @Column(name = "correo")
    private String correo;

    @Column(name = "contrasenia")
    private String contrasenia;

}
