package hn.unah.lenguajes.demo.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.demo.Entities.Inventario;
import hn.unah.lenguajes.demo.Entities.Producto;
import hn.unah.lenguajes.demo.Repositories.AdministradorRepository;
import hn.unah.lenguajes.demo.Repositories.InventarioRepository;
import hn.unah.lenguajes.demo.Repositories.ProductoRepository;
import hn.unah.lenguajes.demo.Services.InventarioService;

@Service
public class InventarioServiceImpl implements InventarioService{

    @Autowired
    private InventarioRepository inventarioRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private AdministradorRepository administradorRepository;

    @Override
    public Inventario crearInventario(String nombreProducto, long idadministrador) {

        if(this.productoRepository.findByNombre(nombreProducto) != null && this.administradorRepository.existsById(idadministrador)){

            Inventario inventario = new Inventario();

            inventario.setAdministrador(this.administradorRepository.findById(idadministrador).get());
            inventario.setProducto(this.productoRepository.findByNombre(nombreProducto));

            return this.inventarioRepository.save(inventario);
        }else{
            return null;
        }
        
    }

    @Override
    public void RevisarInvetario(List<Producto> producto) {
       for (Producto productos : producto) {
        Inventario inventario = this.inventarioRepository.findById(productos.getIdproducto()).get();
        inventario.setCantidad(inventario.getCantidad()-1);

        if(inventario.getCantidad()<10){
            inventario.setCantidad(100);
        }
        this.inventarioRepository.save(inventario);
       }
    }

    
    
}
