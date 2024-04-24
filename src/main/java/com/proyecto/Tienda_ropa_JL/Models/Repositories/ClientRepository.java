package com.proyecto.Tienda_ropa_JL.Models.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.Tienda_ropa_JL.Models.Entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByCorreoAndContrasena(String correo, String contrasena);
    
    Client findByCorreo(String correo);

    List<Client> findByRol(String rol);
}