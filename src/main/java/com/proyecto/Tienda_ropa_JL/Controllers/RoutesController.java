package com.proyecto.Tienda_ropa_JL.Controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.proyecto.Tienda_ropa_JL.Models.Entities.Client;
import com.proyecto.Tienda_ropa_JL.Models.Entities.Product;
import com.proyecto.Tienda_ropa_JL.Models.Entities.Sale;
import com.proyecto.Tienda_ropa_JL.Models.Repositories.ClientRepository;
import com.proyecto.Tienda_ropa_JL.Models.Repositories.ProductRepository;
import com.proyecto.Tienda_ropa_JL.Models.Repositories.SaleRepository;

@Controller
@RequestMapping("/Tienda")
public class RoutesController {
    /* Aqui se pondran todo las rutas entre paginas */

    // ============================================================= RESPOSITORIOS
    @Autowired
    private ProductRepository R_Product;

    @Autowired
    private ClientRepository R_Client;

    @Autowired
    private SaleRepository R_Sale;

    private Client cliente;
    private List<Product> products;
    private List<Sale> sales;

    // ============================================================= RUTAS
    // --- pagina login
    @GetMapping({ "/InicioSesion", "/", "/home", "" })
    public String mostrar_InicioSesion(Model model) {
        return "Login";
    }

    // --- Accion Logear
    @GetMapping("/Logear")
    public String Ingresar(@ModelAttribute Client Newclient, Model model) {

        cliente = R_Client.findByCorreoAndContrasena(Newclient.getCorreo(), Newclient.getContrasena());

        products = R_Product.findAll();

        if (cliente != null) {
            cliente.setConectado(true);
            R_Client.save(cliente);
            model.addAttribute("product", products);
            model.addAttribute("cliente", cliente);
            return "Index";
        } else {
            return "redirect:/Tienda/InicioSesion";
        }

    }

    // --- pagina Tienda y verifica logeado o no
    @GetMapping("/store")
    public String Logeado(Model model) {

        if (cliente.getConectado() == true) {
            products = R_Product.findAll();
            cliente = R_Client.findByCorreoAndContrasena(cliente.getCorreo(), cliente.getContrasena());
            model.addAttribute("product", products);
            model.addAttribute("cliente", cliente);
            return "Index";
        } else {
            return "redirect:/Tienda";
        }
    }

    @GetMapping("/Logout")
    public String CerrarSesion() {
        cliente.setConectado(false);
        R_Client.save(cliente);
        return "redirect:/Tienda";
    }

    @GetMapping("/Administracion")
    public String administrar(Model model) {
        products = R_Product.findAll();
        sales = R_Sale.findAll();

        if (sales != null && !sales.isEmpty()) {
            // Totales
            int TotalCosto = sales.stream().filter(sale -> sale.getValor_costo() != null).mapToInt(Sale::getValor_costo)
                    .sum();
            int TotalVenta = sales.stream().filter(sale -> sale.getValor_venta() != null).mapToInt(Sale::getValor_venta)
                    .sum();
            int TotalImpuesto = sales.stream().filter(sale -> sale.getImpuesto() != null).mapToInt(Sale::getImpuesto)
                    .sum();

            int Ganancia = TotalVenta - TotalCosto;

            model.addAttribute("TCosto", TotalCosto);
            model.addAttribute("TVenta", TotalVenta);
            model.addAttribute("TImpuesto", TotalImpuesto);
            model.addAttribute("Ganancia", Ganancia);
        } else {
            // Si no hay ventas, establece los totales en 0
            model.addAttribute("TCosto", 0);
            model.addAttribute("TVenta", 0);
            model.addAttribute("TImpuesto", 0);
            model.addAttribute("Ganancia", 0);
        }

        model.addAttribute("product", products);
        model.addAttribute("sale", sales);

        return "Manage";
    }

    @GetMapping("/Empleados")
    public String Empleados(Model model) {

        List<Client> Empleados = R_Client.findByRol("Empleado");
        List<Client> Clientes = R_Client.findByRol("Cliente");
        model.addAttribute("Employees", Empleados);
        model.addAttribute("Clients", Clientes);
        return "Employees";
    }

    @GetMapping("/Perfil")
    public String Perfil(Model model) {

        model.addAttribute("current_User", cliente);
        return "Profile";
    }

    // --- pagina registrar producto
    @GetMapping("/formularioProducto")
    public String mostrarFormulario(Model model) {
        model.addAttribute("producto", new Product());
        products = R_Product.findAll();
        return "Product";
    }

    // --- pagina editar producto
    @GetMapping("/editarProducto/{id}")
    public String editarProducto(Model model, @PathVariable Long id) {
        Optional<Product> edit_producto = R_Product.findById(id);

        if (edit_producto.isPresent()) {

            model.addAttribute("currentProduct", edit_producto.get());

            return "Product_edit";
        } else {
            return "redirect:/Tienda/administracion";
        }
    }

    // --- pagina editar empleado
    @GetMapping("/editarEmpleado/{id}")
    public String editarEmpleado(Model model, @PathVariable Long id) {
        Optional<Client> empleado = R_Client.findById(id);

        if (empleado.isPresent()) {
            model.addAttribute("currentEmployee", empleado.get());
            return "Employee_edit";
        } else {
            return "redirect:/Tienda/Empleados";
        }

    }

    // --- pagina crear venta
    @GetMapping("/Venta")
    public String registrarVenta(Model model) {
        return "Sale";
    }

    // --- pagina editar venta
    @GetMapping("/editarVenta/{id}")
    public String editarVenta(Model model, @PathVariable Long id) {
        Optional<Sale> venta = R_Sale.findById(id);

        if (venta.isPresent()) {
            model.addAttribute("currentSale", venta.get());
            return "Sale_edit";
        } else {
            return "redirect:/Tienda/Administracion";
        }
    }
}
