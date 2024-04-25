package hn.unah.lenguajes.demo.Repositories;

import org.springframework.data.repository.CrudRepository;

import hn.unah.lenguajes.demo.Entities.Comida;

public interface ComidaRepositorio extends CrudRepository<Comida,Long>{

    
}