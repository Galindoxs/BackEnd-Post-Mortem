package hn.unah.lenguajes.demo.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.demo.Entities.Cliente;
import hn.unah.lenguajes.demo.Repositories.ClienteRepository;
import hn.unah.lenguajes.demo.Services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente crearCliente(Cliente cliente) {
       return this.clienteRepository.save(cliente);
    }

    @Override
    public Cliente autenticarCliente(String correo, String contrasenia) {
        // Buscar al cliente por su correo en la base de datos
        Cliente cliente = clienteRepository.findByCorreo(correo);
        // Verificar si el cliente existe y la contraseña es correcta
        if (cliente != null && contrasenia.equals(cliente.getContrasenia())) {
            return cliente; // Si el cliente existe y la contraseña es correcta, retorna el cliente autenticado
        } else {
            return null; // Si el cliente no existe o la contraseña es incorrecta, retorna null
        }
    }

}
