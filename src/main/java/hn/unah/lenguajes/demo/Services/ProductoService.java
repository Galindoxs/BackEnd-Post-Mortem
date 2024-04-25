package hn.unah.lenguajes.demo.Services;

import hn.unah.lenguajes.demo.Entities.Producto;

public interface ProductoService {
    
    public Producto crearProducto(Producto producto);

    public Producto eliminaProducto(String nombre);

    public void RevisarProducto(long idproducto);
}
