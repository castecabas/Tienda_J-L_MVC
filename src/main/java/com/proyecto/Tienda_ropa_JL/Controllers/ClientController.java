package com.proyecto.Tienda_ropa_JL.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.proyecto.Tienda_ropa_JL.Models.Entities.Client;
import com.proyecto.Tienda_ropa_JL.Models.Repositories.ClientRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Controller
@RequestMapping("/Tienda")
public class ClientController {
    /*
     * aqui se colocaran todas las funciones que deben tener los CLIENTES o
     * EMPLEADOS
     */

    // ============================================================= RESPOSITORIOS
    @Autowired
    private ClientRepository R_Client;

    @Autowired
    private JavaMailSender javaMailSender;
    // ============================================================= METODOS

    @PostMapping("/crearCliente")
    public String crearcliente(@ModelAttribute Client Newclient) {
        


        R_Client.save(Newclient);
        enviarCorreo(Newclient.getCorreo(),Newclient.getNombre(),Newclient.getApellido());
        return "redirect:/Tienda/InicioSesion";
    }

    private void enviarCorreo(String destinatario,String NombreUser, String ApellidoUser) {
        MimeMessage msg = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(msg, true);
            helper.setFrom("cardenas20220113@gmail.com");
            helper.setTo(destinatario);
            helper.setSubject("Bienvenido a nuestra tienda");
            helper.setText("<img src='https://i.postimg.cc/dt84bCch/Logo-With-Backgorund.png' style='width:100px;height:100px;'><br>"+"Se ha creado el USUARIO: <h3>"+NombreUser+" "+ ApellidoUser+"</h3> Con el CORREO: <h3>"+destinatario+"</h3><br>"
                    +" Gracias por registrarte en nuestra tienda !! , te damos la bienvenida y puedas otorgar apoyo en nuestra pagina"
                            + "<br><img src='https://www.ampsico.es/wp-content/uploads/2018/05/1.png'>",
                    true);

            javaMailSender.send(msg);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/Empleados/eliminar/{id}")
    public String eliminarEmpleado(@PathVariable Long id) {
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

    // rutas

    @GetMapping("/registrar")
    public String Route_Register() {
        return "Register";
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Client>> VerTodos() {
        List<Client> clients = R_Client.findAll();
        if (clients.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }
}
