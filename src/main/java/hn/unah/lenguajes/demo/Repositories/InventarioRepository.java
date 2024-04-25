package hn.unah.lenguajes.demo.Repositories;

import org.springframework.data.repository.CrudRepository;

import hn.unah.lenguajes.demo.Entities.Inventario;

public interface InventarioRepository extends CrudRepository<Inventario, Long>{
    
}
