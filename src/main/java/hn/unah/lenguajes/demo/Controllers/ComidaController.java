package hn.unah.lenguajes.demo.Controllers;

import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.demo.Entities.Comida;
import hn.unah.lenguajes.demo.Services.Impl.ComidaServiceImpl;
import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


//Controller para el Administrador
@RestController
@RequestMapping("/api")
public class ComidaController {
    
    @Autowired
    private ComidaServiceImpl comidaServiceImpl;

    @PostMapping("/comida/crear")
    public ResponseEntity<?> agregarComida(@RequestBody Comida comida) {

        Comida responseComida = this.comidaServiceImpl.agregarComida(comida);

        if(responseComida != null){
            return ResponseEntity.ok(responseComida);
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Comida no se ha creado.");
        }
        
    }
    
    //Muestra las comidas del menu, para el cliente.
    @GetMapping("/comida/mostrar")
    public List<Comida> mostrarComida() {
        return this.comidaServiceImpl.mostrarComida();
    }
    
    @Operation(summary = "Agregar ingredientes a una comida")
    @PutMapping("/comida/{idcomida}/producto")
    public ResponseEntity<?> agregarIngredientes(@PathVariable long idcomida, @RequestBody List<Long> productos) {
       
        Comida comida = this.comidaServiceImpl.agregarIngredientes(idcomida, productos);
        if(comida!=null){
            return ResponseEntity.ok(comida);
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ingredientes no se agregaron.");
        }
        
    }

    @DeleteMapping("/comida/eliminar")
    public ResponseEntity<?> eliminarComida(@RequestParam long idcomida) {
        Comida responseComida = this.comidaServiceImpl.eliminarComida(idcomida);
        if(responseComida != null){
            return ResponseEntity.ok(responseComida);
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Comida no se ha creado");
        }
    }
    
}
