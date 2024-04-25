package hn.unah.lenguajes.demo.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.demo.Entities.Administrador;
import hn.unah.lenguajes.demo.Repositories.AdministradorRepository;
import hn.unah.lenguajes.demo.Services.AdministradorService;

@Service
public class AdministradorServiceImpl implements AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    @Override
    public Administrador crearAdmnistrador(Administrador admnistrador) {
        return this.administradorRepository.save(admnistrador); 
    }

    @Override
    public Administrador autenticarAdmin(String correo, String contrasenia) {
        Administrador admin = administradorRepository.findByCorreo(correo);
        if(admin != null && admin.getContrasenia() == contrasenia){
            return admin;
        }else {
            return null;
        }
    }

}
