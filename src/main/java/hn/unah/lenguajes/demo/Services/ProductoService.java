package hn.unah.lenguajes.demo.Services;

import java.util.List;

import hn.unah.lenguajes.demo.Entities.Producto;

public interface ProductoService {
    
    public Producto crearProducto(Producto producto);

    public Producto eliminaProducto(String nombre);

    public List<Producto> mostrarProducto();

    public void RevisarProducto(long idproducto);
}
