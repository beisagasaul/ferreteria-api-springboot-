package com.ferreteria.Ferreteria.controller;

import com.ferreteria.Ferreteria.model.Producto;
import com.ferreteria.Ferreteria.service.IProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/productos")
public class ProductoRestController {
    private final IProductoService prodServ;

    public ProductoRestController(IProductoService prodServ) {
        this.prodServ = prodServ;
    }
    //READ
    @GetMapping
    public List<Producto> traerProductos(){
        return prodServ.traerProductos();
    }

    //READ DE PRODUCTO ESPECIFICO
    @GetMapping("/{codProd}")
    public ResponseEntity<?> buscarProdcto(@PathVariable Long codProd){
        Producto prod=prodServ.buscarProducto(codProd);
        if(prod==null){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body("NO se encontro con ese codigo");
        }
        return ResponseEntity.ok(prod);
    }

    //CREATE
    @PostMapping
    public ResponseEntity<?> crearProducto(@RequestBody Producto prod){
        Producto productoCreado=prodServ.crearProducto(prod);
        if(productoCreado==null){
            return  ResponseEntity.badRequest()
                    .body("los datos del producto no son validos");
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productoCreado);
    }

    //UPDATE
    @PutMapping("/{codProd}")
    public ResponseEntity<?> editarPrdducto(@PathVariable Long codProd,
                                              @RequestBody Producto prodAModificar){
        Producto prodEditado=prodServ.editarProducto(codProd,prodAModificar);
        if(prodEditado==null){
            return ResponseEntity.badRequest()
                    .body("No fue posible editar el prducto");
        }
        return ResponseEntity.ok(prodEditado);
    }

    //DELETE
    @DeleteMapping("/{codProd}")
    public ResponseEntity<String> eliminarProducto(@PathVariable Long codProd){
        boolean eliminado=prodServ.eliminarProducto(codProd);
        if(eliminado==false){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("NO se encontro el producto");

        }
        return  ResponseEntity.ok("Producto eliminado correctamente");
    }









}
