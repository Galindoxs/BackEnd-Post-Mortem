package hn.unah.lenguajes.demo.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.demo.Entities.Producto;
import hn.unah.lenguajes.demo.Repositories.ProductoRepository;
import hn.unah.lenguajes.demo.Services.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto crearProducto(Producto producto) {
        if(producto.getCategoria().equals("Alcochol")){
            Producto productoNuevo = producto;
            productoNuevo.setPrecio(productoNuevo.getPrecio()+(productoNuevo.getPrecio()*0.18));
            return this.productoRepository.save(productoNuevo);
        }else{
            return this.productoRepository.save(producto);
        }
    }

    @Override
    public Producto eliminaProducto(String nombre) {
        return this.productoRepository.findByNombre(nombre);
    }

    @Override
    public void RevisarProducto(long idproducto) {

    }

    @Override
    public List<Producto> mostrarProducto() {
        return (List<Producto>)this.productoRepository.findAll();
    }
    
}
