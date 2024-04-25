package hn.unah.lenguajes.demo.Services.Impl;

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
        return this.productoRepository.save(producto);
    }

    @Override
    public Producto eliminaProducto(String nombre) {
        return this.productoRepository.findByNombre(nombre);
    }

    @Override
    public void RevisarProducto(long idproducto) {
    

    }
    
}
