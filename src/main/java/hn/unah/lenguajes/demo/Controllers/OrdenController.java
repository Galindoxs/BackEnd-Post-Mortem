package hn.unah.lenguajes.demo.Controllers;

import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.demo.Entities.Orden;
import hn.unah.lenguajes.demo.Services.Impl.OrdenServiceImpl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;




//Controller del cliente
@RestController
@RequestMapping("api")

public class OrdenController {

    @Autowired
    private OrdenServiceImpl ordenServiceImpl;
    
   
    @PostMapping("/orden/crear")
    public ResponseEntity<?> crearOrden(@RequestParam Long idCliente, @RequestParam Long idcomida) {

        Orden orden = this.ordenServiceImpl.crearOrden(idCliente, idcomida);

        if (orden != null) {
            return ResponseEntity.ok(orden); // Cliente autenticado
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Orden no registrada");
        }
    }

    @GetMapping("/orden/carrito")
    public ResponseEntity<?> mostrarOrdenes(@RequestParam long idCliente) {
         List<Orden> ordenes = this.ordenServiceImpl.mostrarOrdenes(idCliente);
         
         return ResponseEntity.ok(ordenes);
    }
    
    @DeleteMapping("/orden/eliminar")
    public ResponseEntity<?> eliminarOrden(@RequestParam long idorden) {
        this.ordenServiceImpl.eliminaOrden(idorden);
        return ResponseEntity.ok("Borrado");
    }
    
}
