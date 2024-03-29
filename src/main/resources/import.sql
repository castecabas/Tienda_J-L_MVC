
insert into Product (nombre,precio,talla,marca,stock,descuento,urlimage) values ('Camisa Roja Cuadrados ','46000','S','Versage',16,10,'https://http2.mlstatic.com/D_NQ_NP_950608-CBT71464103499_092023-O.webp');
insert into Product (nombre,precio,talla,marca,stock,descuento,urlimage) values ('Camiseta Verde Rayado','40000','L','Versage',13,0,'https://i.pinimg.com/564x/81/4f/d4/814fd4e5948990aca5fe91e33b8853e8.jpg');
insert into Product (nombre,precio,talla,marca,stock,descuento,urlimage) values ('Medias negras','12000','36-41','Momus', 4, 5,'https://www.gef.co/dx/api/dam/custom/reemplazar/2022/gef/hombres/medias/momus/566x715/medias-hombre-momus-negro-7047-r-frente-gef.jpg');
insert into Product (nombre,precio,talla,marca,stock,descuento,urlimage) values ('Vestido Azul','120000','M','Zaful', 16, 20,'https://cdn-images.farfetch-contents.com/18/33/61/99/18336199_40153943_1000.jpg');

insert into client (nombre,apellido,telefono,correo,contrasena,rol,conectado) values ('Carlos','Cardenas','318333111','cardenas@gmail.com','admin','Admin',false);
insert into client (nombre,apellido,telefono,correo,contrasena,rol,conectado) values ('Sarah','Mikhail','316345111','SaraM@gmail.com','hijkl','Empleado',false);

insert into sale (valor_costo,valor_venta,creacion) values (2000,3500,now());
insert into sale (valor_costo,valor_venta,creacion) values (5000,7000,now());
insert into sale (impuesto,descripcion_IMP,creacion) values (55000,'Factura de Luz',now());

