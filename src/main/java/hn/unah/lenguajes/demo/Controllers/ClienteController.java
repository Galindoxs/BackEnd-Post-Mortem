package hn.unah.lenguajes.demo.Controllers;

import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.demo.Entities.Cliente;
import hn.unah.lenguajes.demo.Services.Impl.ClienteServiceImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteServiceImpl;

    @PostMapping("/cliente/crear")
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        return this.clienteServiceImpl.crearCliente(cliente);
    }

    @PostMapping("/cliente/login")
    public ResponseEntity<?> autenticarCliente(@RequestBody Map<String, String> body) {
        String correo = body.get("correo");
        String contrasenia = body.get("contrasenia");
    
        Cliente cliente = clienteServiceImpl.autenticarCliente(correo, contrasenia);
        if (cliente != null) {
            return ResponseEntity.ok(cliente); // Cliente autenticado
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Correo o contraseña incorrectos"); // Error de autenticación
        }
    }
}
    