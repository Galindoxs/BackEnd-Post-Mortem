package hn.unah.lenguajes.demo.Services;

import java.util.List;

import hn.unah.lenguajes.demo.Entities.Factura;

public interface FacturaService {
    
    public Factura crearFactura(List<Long> idordenes);

    public Factura mostrarFactura(long idfactura);
}
