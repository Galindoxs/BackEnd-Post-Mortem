package hn.unah.lenguajes.demo.Repositories;

import org.springframework.data.repository.CrudRepository;

import hn.unah.lenguajes.demo.Entities.Cliente;
import hn.unah.lenguajes.demo.Entities.Orden;
import java.util.List;




public interface OrdenRepository extends CrudRepository<Orden, Long>{
    List<Orden> findByCliente(Cliente cliente);
}
