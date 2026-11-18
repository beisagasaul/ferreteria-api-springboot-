package com.ferreteria.Ferreteria.service;

import com.ferreteria.Ferreteria.model.Producto;

import java.util.List;

public interface IProductoService {

    //Metodos sin implementar CRUD
//READ
List<Producto> traerProductos();
Producto buscarProducto(Long codProd);
//CREATE
Producto crearProducto(Producto prod);

//UPDATE
Producto editarProducto(Long codProd,Producto prod);

//DELETE
    boolean eliminarProducto (Long codProd);
}
