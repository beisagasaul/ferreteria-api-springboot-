package com.ferreteria.Ferreteria.controller;

import com.ferreteria.Ferreteria.model.Producto;
import com.ferreteria.Ferreteria.service.IProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productos")
public class ProductoWebController {
    private final IProductoService prodServ;

    public ProductoWebController(IProductoService prodServ) {
        this.prodServ = prodServ;
    }
    //TRAER PRODUCTOS
    @GetMapping
    public String traerProductos(Model model){
        model.addAttribute(
                "productos",
                prodServ.traerProductos()
        );
        return  "productos/lista";

    }
 //TRAER LA PAGIAN DEL FORMULARIO
    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model){
        model.addAttribute("producto",new Producto());
        model.addAttribute("titulo","Registrar producto");

        return "productos/formulario";
    }


    //PARA GUARDAR EL FORMULARIO

    @PostMapping("/crear")
    public  String crearProducto(@ModelAttribute Producto producto,Model model){
        Producto resultado;
        //VALIDACIONES
        //codigo
        if(producto.getCodProducto()==null){
            resultado=prodServ.crearProducto(producto);
        }else{
            resultado=prodServ.editarProducto(
                    producto.getCodProducto(),
                    producto
            );
        }
        if(resultado==null){
            model.addAttribute("producto",producto);
            model.addAttribute(
                    "titulo",
                    producto.getCodProducto()==null
                    ?"Registrar producto"
                            :"Editar producto"
            );
            model.addAttribute(
                    "error",
                    "Revisa datos Nombre marca....."
            );
            return "productos/formulario";
        }
        return "redirect:/productos";

    }


    //EDITAR

    @GetMapping("/editar/{id}")
    public  String mostrarFormularioEditar(
            @PathVariable Long id,
            Model model
    ){
        Producto producto=prodServ.buscarProducto(id);
                if(producto==null){
                    return "redirect:/productos";
                }
                model.addAttribute("producto",producto);
                model.addAttribute("titulo","Editar producto");
                return  "productos/formulario";
    }
    @PostMapping("eliminar/{id}")
    public String eliminarproducto(@PathVariable Long id){
        prodServ.eliminarProducto(id);
        return "redirect:/productos";
    }



}
