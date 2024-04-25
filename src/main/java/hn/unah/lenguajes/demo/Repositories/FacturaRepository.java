package hn.unah.lenguajes.demo.Repositories;

import org.springframework.data.repository.CrudRepository;

import hn.unah.lenguajes.demo.Entities.Factura;

public interface FacturaRepository extends CrudRepository<Factura, Long> {
    
}
