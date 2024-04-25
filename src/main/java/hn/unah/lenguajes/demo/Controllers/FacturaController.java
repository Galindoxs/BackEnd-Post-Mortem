package hn.unah.lenguajes.demo.Controllers;

import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.demo.Entities.Factura;
import hn.unah.lenguajes.demo.Services.Impl.FacturaServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("api")
public class FacturaController {
    
    @Autowired
    private FacturaServiceImpl facturaServiceImpl;

    @PostMapping("/factura/crear")
    public ResponseEntity<?> crearFactura(@RequestBody List<Long> orden) {
        
        Factura factura = this.facturaServiceImpl.crearFactura(orden);

        return ResponseEntity.ok(factura);
    }
    
    @GetMapping("/factura/mostrar")
    public Factura mostrarFactura(@RequestParam long idfactura) {
        return this.facturaServiceImpl.mostrarFactura(idfactura);
    }
    
}
