package hn.unah.lenguajes.demo.Entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "comida")
@Data
public class Comida {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcomida")
    private long idcomida;

    private String nombre;

    private String descripcion;

    private double precio;

    private int tipo;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Producto> producto = new ArrayList<>();
}
