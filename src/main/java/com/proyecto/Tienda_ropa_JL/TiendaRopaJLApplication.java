package com.proyecto.Tienda_ropa_JL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TiendaRopaJLApplication {

	public static void main(String[] args) {
        SpringApplication.run(TiendaRopaJLApplication.class, args);

		String serverPort = System.getenv("server.port");
        if(serverPort == null || serverPort.isEmpty()) {
            serverPort = "9090";
        }

        System.out.println("\n\n##### Tu aplicación está funcionando correctamente #####");
        System.out.println("Accede a tu aplicación web aquí: http://localhost:" + serverPort + "/Tienda\n");
	}

}
