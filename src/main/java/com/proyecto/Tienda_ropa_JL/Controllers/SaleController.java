package com.proyecto.Tienda_ropa_JL.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.proyecto.Tienda_ropa_JL.Models.Entities.Sale;
import com.proyecto.Tienda_ropa_JL.Models.Repositories.SaleRepository;

@Controller
@RequestMapping("/Tienda")
public class SaleController {
    /*
     * aqui se colocaran todas las funciones que debe tener las ventas o costos y
     * calcularse
     */
    // ============================================================= RESPOSITORIOS
    @Autowired
    private SaleRepository R_Sale;

    // ============================================================= METODOS

    @PostMapping("/crearVenta")
    public String crearVenta(@ModelAttribute Sale sale) {
        R_Sale.save(sale);
        return "redirect:/Tienda/Administracion";
    }

    @PostMapping("/eliminarVenta/{id}")
    public String eliminarVenta(@PathVariable Long id) {
        R_Sale.deleteById(id);
        return "redirect:/Tienda/Administracion";
    }

    @PostMapping("/EditadoVenta")
    public String editarVenta(@RequestParam("id") String id, @ModelAttribute Sale sale) {
        Long ID = Long.parseLong(id);
        Sale old_venta = R_Sale.findById(ID).orElse(null);

        if (old_venta != null) {
            old_venta.setValor_costo(sale.getValor_costo());
            old_venta.setValor_venta(sale.getValor_venta());
            old_venta.setImpuesto(sale.getImpuesto());
            old_venta.setDescripcion_imp(sale.getDescripcion_imp());

            R_Sale.save(old_venta);

            return "redirect:/Tienda/Administracion";
        } else {
            return "redirect:/Tienda/Administracion?error=venta_no_encontrado";
        }
    }

}
