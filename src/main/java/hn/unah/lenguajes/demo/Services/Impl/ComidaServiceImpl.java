package hn.unah.lenguajes.demo.Services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.demo.Entities.Comida;
import hn.unah.lenguajes.demo.Entities.Producto;
import hn.unah.lenguajes.demo.Repositories.ComidaRepositorio;
import hn.unah.lenguajes.demo.Repositories.ProductoRepository;
import hn.unah.lenguajes.demo.Services.ComidaService;

@Service
public class ComidaServiceImpl implements ComidaService{

    @Autowired
    private ComidaRepositorio comidaRepositorio;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductoServiceImpl productoServiceImpl;

    @Override
    public Comida agregarComida(Comida comida) {

        if(comida.getProducto()!=null){
            List<Producto> productos = comida.getProducto();

        
            for (Producto producto : productos) {
                productoServiceImpl.crearProducto(producto);
            }
        }

        return this.comidaRepositorio.save(comida);
        
    }

    @Override
    public List<Comida> mostrarComida() {
       return (List<Comida>) this.comidaRepositorio.findAll();
    }

    @Override
    public Comida eliminarComida(long idcomida) {
       if(comidaRepositorio.existsById(idcomida)){
        Comida comida = comidaRepositorio.findById(idcomida).get();
            comidaRepositorio.deleteById(idcomida);
            return comida;
       }else{
        return null;
       }
      
    }

    @Override
    public Comida agregarIngredientes(long idcomida, List<Long> idproductos) {
        if(this.comidaRepositorio.existsById(idcomida)){
            Comida comida = this.comidaRepositorio.findById(idcomida).get();
           List<Producto> productos = (List<Producto>) this.productoRepository.findAllById(idproductos);
           
            comida.getProducto().addAll(productos);

            return this.comidaRepositorio.save(comida);
        }
            return null;
    }
    
}
