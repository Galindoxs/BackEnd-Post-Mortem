package hn.unah.lenguajes.demo.Entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "orden")
@Data
public class Orden {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idorden")
    private long idorden;

    @OneToOne
    @JoinColumn(name = "id")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "idcomida")
    private Comida comida;

    private LocalDate fecha;

    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "idfactura", columnDefinition = "int")
    private Factura factura;
}
