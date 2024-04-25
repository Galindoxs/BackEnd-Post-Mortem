package hn.unah.lenguajes.demo.Controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.demo.Entities.Administrador;
import hn.unah.lenguajes.demo.Services.Impl.AdministradorServiceImpl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
public class AdministradorController {

    @Autowired
    private AdministradorServiceImpl administradorServiceImpl;

    @PostMapping("/admin/crear")
    public Administrador crearAdmnistrador(@RequestBody Administrador administrador) {
        return this.administradorServiceImpl.crearAdmnistrador(administrador);
    }
    
    @PostMapping("/admin/login")
    //ResponseEntity es una clase de Spring que maneja y devuelve respuestas HTTP desde la aplicacion Web (FrontEnd)
    public ResponseEntity<?> autenticarAdmin(@RequestBody Map<String, String> body) {
    //ResponseEntity se parametriza con ? para que devuelva cualquier tipo de objeto    
        String correo = body.get("correo");
        String contrasenia = body.get("contrasenia");

        Administrador administrador = this.administradorServiceImpl.autenticarAdmin(correo, contrasenia);
        if(administrador != null){
            return ResponseEntity.ok(administrador);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Correo o Contraseña incorrectos");
           //return ResponseEntity.notFound().build(); //Retorno de un objeto del mismo tipo, solo con el codigo de estatus
        }
    }
    


}
