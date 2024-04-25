package hn.unah.lenguajes.demo.Services;

import java.util.List;

import hn.unah.lenguajes.demo.Entities.Inventario;
import hn.unah.lenguajes.demo.Entities.Producto;

public interface InventarioService {
    
    public Inventario crearInventario(String nombreProducto,long idadministrador);

    public void RevisarInvetario(List<Producto> producto);
}
