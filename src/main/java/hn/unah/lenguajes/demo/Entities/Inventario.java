package hn.unah.lenguajes.demo.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "inventario")
@Data
public class Inventario {
    
    @Id
    @Column(name = "idinventario")
    private long idinventario;

    @ManyToOne
    @JoinColumn(name = "idproducto")
    private Producto producto;

    @OneToOne
    @JoinColumn(name = "idadministrador", columnDefinition = "int")
    private Administrador administrador;

    private int cantidad;
}
