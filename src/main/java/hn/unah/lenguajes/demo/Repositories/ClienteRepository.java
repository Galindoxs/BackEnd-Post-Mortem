package hn.unah.lenguajes.demo.Repositories;

import org.springframework.data.repository.CrudRepository;

import hn.unah.lenguajes.demo.Entities.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long>{
    Cliente findByCorreo(String correo);
}
