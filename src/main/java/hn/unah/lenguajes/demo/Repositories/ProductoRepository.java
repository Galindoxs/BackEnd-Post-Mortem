package hn.unah.lenguajes.demo.Repositories;

import org.springframework.data.repository.CrudRepository;

import hn.unah.lenguajes.demo.Entities.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long>{

    Producto findByNombre(String nombre);
}
