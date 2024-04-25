package hn.unah.lenguajes.demo.Services.Impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.demo.Entities.Cliente;
import hn.unah.lenguajes.demo.Entities.Comida;
import hn.unah.lenguajes.demo.Entities.Factura;
import hn.unah.lenguajes.demo.Entities.Orden;
import hn.unah.lenguajes.demo.Repositories.ClienteRepository;
import hn.unah.lenguajes.demo.Repositories.ComidaRepositorio;
import hn.unah.lenguajes.demo.Repositories.FacturaRepository;
import hn.unah.lenguajes.demo.Repositories.OrdenRepository;
import hn.unah.lenguajes.demo.Services.OrdenService;

@Service
public class OrdenServiceImpl implements OrdenService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ComidaRepositorio comidaRepositorio;

    @Autowired
    private InventarioServiceImpl inventarioServiceImpl;

    @Autowired
    private OrdenRepository ordenRepository;

    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    public Factura crearOrden(Long idCliente, List<Comida> comidas) {
      Cliente cliente = this.clienteRepository.findById(idCliente).get();
      //Lista de ordenes para la factura
      List<Orden> ordenes = new ArrayList<>() ;
      double total = 0; //Total de los precios para la factura

      for(Comida comida: comidas ){
        Orden orden = new Orden();
        orden.setCliente(cliente);
        orden.setComida(comida);
        orden.setFecha(LocalDate.now());
        
        this.inventarioServiceImpl.RevisarInvetario(comida.getProducto());
        ordenes.add(this.ordenRepository.save(orden));
        total += comida.getPrecio();
      }

      Factura factura = new Factura();

      factura.setFecha(LocalDate.now());
      factura.setOrden(ordenes);
      factura.setEstado("UNKNOW");
      factura.setTotal(total);

      return this.facturaRepository.save(factura);

    }

    @Override
    public Orden crearOrden(Long idCliente, Long idComida) {
      Orden orden = new Orden();

      if(this.clienteRepository.existsById(idCliente) && this.comidaRepositorio.existsById(idComida)){
        orden.setCliente(this.clienteRepository.findById(idCliente).get());
        orden.setComida(this.comidaRepositorio.findById(idComida).get());
        orden.setFecha(LocalDate.now());
        orden.setEstado(false);
        return this.ordenRepository.save(orden);
      }
      return null;
    }

    @Override
    public List<Orden> mostrarOrdenes(long id) {
      Cliente cliente = this.clienteRepository.findById(id).get();
      List<Orden> ordenes = (List<Orden>) this.ordenRepository.findByCliente(cliente);
      List<Orden> filtro = new ArrayList<>();
      
      for (Orden orden : ordenes) {

        if(orden.getEstado() == false){
          filtro.add(orden);
        }
      }
      
      return filtro;
    }

    @Override
    public void eliminaOrden(long idorden) {
       this.ordenRepository.deleteById(idorden);
    }
    
}
