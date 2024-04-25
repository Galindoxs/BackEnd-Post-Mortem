package hn.unah.lenguajes.demo.Services;

import java.util.List;

import hn.unah.lenguajes.demo.Entities.Comida;

public interface ComidaService {
    
    public Comida agregarComida(Comida comida);

    public List<Comida> mostrarComida();

    public Comida eliminarComida(long idcomida);

    public Comida agregarIngredientes(long idcomida, List<Long> idproducto);
}
