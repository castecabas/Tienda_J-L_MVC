package com.proyecto.Tienda_ropa_JL.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.proyecto.Tienda_ropa_JL.Models.Entities.Client;
import com.proyecto.Tienda_ropa_JL.Models.Repositories.ClientRepository;

@Controller
@RequestMapping("/Tienda")
public class ClientController {
    /* aqui se colocaran todas las funciones que deben tener los CLIENTES o EMPLEADOS */

    // ============================================================= RESPOSITORIOS
    @Autowired
    private ClientRepository R_Client;

    // ============================================================= METODOS
    

    @PostMapping("/crearCliente")
    public String crearcliente(@ModelAttribute Client Newclient) {
    R_Client.save(Newclient);
        return "redirect:/Tienda/InicioSesion";
    }

    @PostMapping("/Empleados/eliminar/{id}")
    public String eliminarEmpleado(@PathVariable Long id){
        R_Client.deleteById(id);
        return "redirect:/Tienda/Empleados";
    }

    @PostMapping("/Perfil/editar")
    public String EditarPerfil(@RequestParam("id") String id, @ModelAttribute Client client) {
        Long ID = Long.parseLong(id);
        Client oldClient = R_Client.findById(ID).orElse(null);

        if (oldClient != null && client != null) {
            oldClient.setNombre(client.getNombre());
            oldClient.setApellido(client.getApellido());
            oldClient.setTelefono(client.getTelefono());
            oldClient.setRol(client.getRol());
            R_Client.save(oldClient);
            return "redirect:/Tienda/store";
        }
        return "redirect:/Tienda/store?error=empleado_no_encontrado"; 
    }

    @PostMapping("/Empleado/editar")
    public String EditarEmpleado(@RequestParam("id") String id, @ModelAttribute Client client) {
    Long ID = Long.parseLong(id);
    Client oldClient = R_Client.findById(ID).orElse(null);

    if (oldClient != null && client != null) {
        oldClient.setNombre(client.getNombre());
        oldClient.setApellido(client.getApellido());
        oldClient.setTelefono(client.getTelefono());
        oldClient.setRol(client.getRol());
        oldClient.setCorreo(client.getCorreo());
        oldClient.setContrasena(client.getContrasena());
        R_Client.save(oldClient);
        return "redirect:/Tienda/Empleados"; 
    }
    

    return "redirect:/Tienda/Empleados?error=empleado_no_encontrado"; 
}

    //rutas

    @GetMapping("/registrar")
    public String Route_Register()
    {
        return "Register";
    }

}
