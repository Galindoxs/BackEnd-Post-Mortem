package hn.unah.lenguajes.demo.Services;

import hn.unah.lenguajes.demo.Entities.Administrador;

public interface AdministradorService {

    public Administrador crearAdmnistrador(Administrador admnistrador);

    public Administrador autenticarAdmin(String correo, String contrasenia);

}
