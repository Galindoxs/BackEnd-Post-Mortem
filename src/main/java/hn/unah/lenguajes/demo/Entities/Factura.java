package hn.unah.lenguajes.demo.Entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Table(name = "factura")
@Data
public class Factura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfactura")
    private long idfactura;

    private LocalDate fecha;

    private double total;

    private String estado;

    @JsonManagedReference
    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    private List<Orden> orden;
}
