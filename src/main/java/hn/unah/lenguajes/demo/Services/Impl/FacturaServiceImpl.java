package hn.unah.lenguajes.demo.Services.Impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.demo.Entities.Factura;
import hn.unah.lenguajes.demo.Entities.Orden;
import hn.unah.lenguajes.demo.Repositories.FacturaRepository;
import hn.unah.lenguajes.demo.Repositories.OrdenRepository;
import hn.unah.lenguajes.demo.Services.FacturaService;

@Service
public class FacturaServiceImpl implements FacturaService{

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private OrdenRepository ordenRepository;

    @Override
    public Factura crearFactura(List<Long> idordenes) {

        Factura factura = new Factura();
        this.facturaRepository.save(factura);
        List<Orden> ordenes =(List<Orden>)this.ordenRepository.findAllById(idordenes);

        List<Orden> ord = new ArrayList<>();
        double total = 0;

        factura.setEstado("Pendiente");
        factura.setFecha(LocalDate.now());
       
        for (Orden orden : ordenes) {
            total += orden.getComida().getPrecio();
            orden.setFactura(factura);
            ord.add(this.ordenRepository.save(orden));
        }
        factura.setTotal(total);
        factura.setOrden(ord);
        
        return this.facturaRepository.save(factura);
    }

    @Override
    public Factura mostrarFactura(long idfactura) {

        return this.facturaRepository.findById(idfactura).get();
    }

    
    
}
