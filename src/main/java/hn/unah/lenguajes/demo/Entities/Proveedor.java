package hn.unah.lenguajes.demo.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "proveedor")
@Data
public class Proveedor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproveedor")
    private long idproveedor;

    private String nombre;

    private int telefono;

    private String email;

    @OneToOne
    @JoinColumn(name = "idadministrador",columnDefinition = "int")
    private Administrador administrador;

}
