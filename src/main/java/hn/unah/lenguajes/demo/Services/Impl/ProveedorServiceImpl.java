package hn.unah.lenguajes.demo.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.demo.Entities.Proveedor;
import hn.unah.lenguajes.demo.Repositories.ProveedorRepository;
import hn.unah.lenguajes.demo.Services.ProveedorService;

@Service
public class ProveedorServiceImpl implements ProveedorService{
    
    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public Proveedor crearProveedor(Proveedor proveedor) {
       return this.proveedorRepository.save(proveedor);
    }

}
