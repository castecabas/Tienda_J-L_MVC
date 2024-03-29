package com.proyecto.Tienda_ropa_JL.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.proyecto.Tienda_ropa_JL.Models.Entities.Product;
import com.proyecto.Tienda_ropa_JL.Models.Repositories.ProductRepository;

@Controller
@RequestMapping("/Tienda")
public class ProductController {

    // ============================================================= RESPOSITORIOS
    @Autowired
    private ProductRepository R_Product;

    // ============================================================= METODOS
    @PostMapping("/crearProducto")
    public String crearProducto(@RequestParam("Urlimage") String urlImagen, @ModelAttribute Product product) {
        product.setUrlimage(urlImagen);
        R_Product.save(product);
        return "redirect:/Tienda/Administracion";
    }

    @PostMapping("/eliminar/{id}")
    public String EliminarProducto(@PathVariable Long id) {
        R_Product.deleteById(id);
        return "redirect:/Tienda/Administracion";
    }

    @PostMapping("/editar")
    public String EditarProducto(@RequestParam("id") String id, @ModelAttribute Product producto)
    {
        Long ID= Long.parseLong(id);
        Product old_product= R_Product.findById(ID).orElse(null);
        if(producto!=null)
        {
            old_product.setNombre(producto.getNombre());
            old_product.setPrecio(producto.getPrecio());
            old_product.setTalla(producto.getTalla());
            old_product.setMarca(producto.getMarca());
            old_product.setStock(producto.getStock());
            old_product.setDescuento(producto.getDescuento());
            old_product.setUrlimage(producto.getUrlimage());
            R_Product.save(old_product);
            return "redirect:/Tienda/Administracion";
        }
        return "redirect:/Tienda/Administracion?error=producto_no_encontrado";
    }
}
