package hn.unah.lenguajes.demo.Repositories;

import org.springframework.data.repository.CrudRepository;

import hn.unah.lenguajes.demo.Entities.Administrador;

public interface AdministradorRepository extends CrudRepository<Administrador, Long>{

    Administrador findByCorreo(String correo);
}
