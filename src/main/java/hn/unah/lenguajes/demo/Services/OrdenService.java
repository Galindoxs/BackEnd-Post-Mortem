package hn.unah.lenguajes.demo.Services;

import java.util.List;

import hn.unah.lenguajes.demo.Entities.Comida;
import hn.unah.lenguajes.demo.Entities.Factura;
import hn.unah.lenguajes.demo.Entities.Orden;

public interface OrdenService {
    
    public Factura crearOrden(Long idCliente, List<Comida> comidas);

    public Orden crearOrden(Long idCliente, Long idComida);

    public List<Orden> mostrarOrdenes(long idCliente);

    public void eliminaOrden(long idorden);

}
