package hn.unah.lenguajes.demo.Controllers;

import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.demo.Entities.Producto;
import hn.unah.lenguajes.demo.Services.Impl.ProductoServiceImpl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



//Controller  para el Administrador
@RestController
@RequestMapping("api")
public class ProductoController {

    @Autowired
    private ProductoServiceImpl productoServiceImpl;
    
    @PostMapping("/producto/crear")
    public Producto crearProducto(@RequestBody Producto producto) {
        return this.productoServiceImpl.crearProducto(producto);
    }

    @GetMapping("/producto/eliminar")
    public  Producto eliminaProducto(@RequestParam String nombre) {
        return this.productoServiceImpl.eliminaProducto(nombre);
    }
    
    
}
