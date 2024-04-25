package hn.unah.lenguajes.demo.Services;

import hn.unah.lenguajes.demo.Entities.Cliente;

public interface ClienteService {

    public Cliente crearCliente(Cliente cliente);  // PARA REGISTRAR EL CLIENTE

    public Cliente autenticarCliente(String correo, String contrasenia); // PARA REGISTRAR EL CLIENTE DEL

}
