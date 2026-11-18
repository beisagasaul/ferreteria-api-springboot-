package com.ferreteria.Ferreteria.service;

import com.ferreteria.Ferreteria.model.Producto;
import com.ferreteria.Ferreteria.repository.dto.IProductoRepository;
import org.springframework.data.annotation.Id;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {


    private  final IProductoRepository prodRepo;

    public ProductoService(IProductoRepository prodRepo) {
        this.prodRepo = prodRepo;
    }

    @Override
    public List<Producto> traerProductos() {
        return prodRepo.findAll();//encotrartodo
    }

    @Override
    public Producto buscarProducto(Long codProd) {
        return prodRepo.findById(codProd).orElse(null);
    }

    @Override
    public Producto crearProducto(Producto prod) {

        if(prod==null){
            return null;
        }
   //EL id se genera automativamente en la BD Y con esto la devolvemos junto con el producto
        return prodRepo.save(prod);
    }

    @Override
    public Producto editarProducto(Long codProd, Producto prod) {

        //BUscar si existe

        Producto prodExiste=buscarProducto(codProd);
        //validar
        if(prodExiste==null){
            return null;
        }
        prodExiste.setCategoria(prod.getCategoria());
        prodExiste.setDescripcion(prod.getDescripcion());
        prodExiste.setMarca(prod.getMarca());
        prodExiste.setStock(prod.getStock());
        prodExiste.setPrecio(prod.getPrecio());
        prodExiste.setNombre(prod.getNombre());
        return prodRepo.save(prodExiste);
    }

    @Override
    public boolean eliminarProducto(Long codProd) {
        Producto prodExiste=buscarProducto(codProd);
        if(prodExiste==null){
            return false;
        }
        prodRepo.delete(prodExiste);

        return true;
    }
}
