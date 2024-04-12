
insert into Product (nombre,precio,talla,marca,stock,descuento,urlimage) values ('Camisa Roja Cuadrados ','46000','S','Versage',16,10,'https://http2.mlstatic.com/D_NQ_NP_950608-CBT71464103499_092023-O.webp');
insert into Product (nombre,precio,talla,marca,stock,descuento,urlimage) values ('Camiseta Verde Rayado','40000','L','Versage',13,0,'https://i.pinimg.com/564x/81/4f/d4/814fd4e5948990aca5fe91e33b8853e8.jpg');
insert into Product (nombre,precio,talla,marca,stock,descuento,urlimage) values ('Medias negras','12000','36','Momus', 4, 5,'https://www.gef.co/dx/api/dam/custom/reemplazar/2022/gef/hombres/medias/momus/566x715/medias-hombre-momus-negro-7047-r-frente-gef.jpg');
insert into Product (nombre,precio,talla,marca,stock,descuento,urlimage) values ('Vestido Azul','120000','M','Zaful', 16, 20,'https://cdn-images.farfetch-contents.com/18/33/61/99/18336199_40153943_1000.jpg');
INSERT INTO Product (nombre, precio, talla, marca, stock, descuento, urlimage) values ('Camiseta Blanca', '45000', 'S', 'Nike', 25, 10, 'https://monarca.com.co/wp-content/uploads/2023/10/016445DELWHITE.jpg');
INSERT INTO Product (nombre, precio, talla, marca, stock, descuento, urlimage) values ('Pantalón Negro', '75000', 'M', 'Adidas', 30, 15, 'https://assets.adidas.com/images/w_600,f_auto,q_auto/049db17a74454beeb735ac360103c076_9366/Pantalon_Adicolor_SST_Negro_GN8453_01_laydown.jpg');
INSERT INTO Product (nombre, precio, talla, marca, stock, descuento, urlimage) values ('Zapatos de Cuero', '180000', 'L', 'Gucci', 10, 5, 'https://http2.mlstatic.com/D_NQ_NP_615429-MCO74647593554_022024-O.webp');
INSERT INTO Product (nombre, precio, talla, marca, stock, descuento, urlimage) values ('Chaqueta de Jean', '95000', 'XL', 'Levi´s', 20, 0, 'https://http2.mlstatic.com/D_NQ_NP_703858-MCO51953511646_102022-O.webp');
INSERT INTO Product (nombre, precio, talla, marca, stock, descuento, urlimage) values ('Gorra Roja', '35000', 'Unico', 'New Era', 40, 8, 'https://neweraco.vtexassets.com/arquivos/ids/163426/11591122_1.png?v=638121818266030000');
INSERT INTO Product (nombre, precio, talla, marca, stock, descuento, urlimage) values ('Bufanda de Lana', '55000', 'M', 'Burberry', 15, 12, 'https://assets.burberry.com/is/image/Burberryltd/47B9244E-EB2A-4145-BCDE-C3A29A3CA0E9?$BBY_V3_SL_1$&wid=1501&hei=1500');
INSERT INTO Product (nombre, precio, talla, marca, stock, descuento, urlimage) values ('Reloj Plateado', '220000', 'Unico', 'Rolex', 5, 0, 'https://luxurytime.com.co/wp-content/uploads/2020/06/rolex179174.jpg');
INSERT INTO Product (nombre, precio, talla, marca, stock, descuento, urlimage) values ('Vestido Floral', '135000', 'L', 'Dior', 12, 18, 'https://cdn-images.farfetch-contents.com/20/14/74/86/20147486_50144636_1000.jpg');
INSERT INTO Product (nombre, precio, talla, marca, stock, descuento, urlimage) values ('Cartera de Cuero', '98000', 'Unico', 'Prada', 8, 10, 'https://cdn-images.farfetch-contents.com/13/32/12/66/13321266_15191720_600.jpg');
INSERT INTO Product (nombre, precio, talla, marca, stock, descuento, urlimage) values ('Suéter de Algodón', '68000', 'XL', 'H&M', 18, 20, 'https://images.fashiola.es/product-list/300x450/h-y-m/617871243/jersey-en-punto-fino-de-algodon-slim-fit-gris.webp');


insert into client (nombre,apellido,telefono,correo,contrasena,rol,conectado) values ('Carlos','Cardenas','318333111','cardenas@gmail.com','admin','Admin',false);
insert into client (nombre,apellido,telefono,correo,contrasena,rol,conectado) values ('Sarah','Mikhail','316345111','SaraM@gmail.com','hijkl','Empleado',false);
insert into client (nombre,apellido,telefono,correo,contrasena,rol,conectado) values ('Daniel','Millan','316542113','DaniM@gmail.com','abcde','Cliente',false);

insert into sale (valor_costo,valor_venta,creacion) values (2000,3500,now());
insert into sale (valor_costo,valor_venta,creacion) values (5000,7000,now());
insert into sale (impuesto,descripcion_IMP,creacion) values (55000,'Factura de Luz',now());

