
insert into Product (nombre,precio,talla,marca,stock,descuento,urlimage) values ('Camisa Roja Cuadrados ','46000','S','Versage',16,10,'https://i.postimg.cc/4yxMr0Bm/A.webp');
insert into Product (nombre,precio,talla,marca,stock,descuento,urlimage) values ('Camiseta Verde Rayado','40000','L','Versage',13,0,'https://i.postimg.cc/m2hJj0Pn/B.jpg');
insert into Product (nombre,precio,talla,marca,stock,descuento,urlimage) values ('Medias negras','12000','36','Momus', 4, 5,'https://i.postimg.cc/PfS0mt5Z/C.webp');
insert into Product (nombre,precio,talla,marca,stock,descuento,urlimage) values ('Vestido Azul','120000','M','Zaful', 16, 20,'https://i.postimg.cc/CxqtTkHH/D.webp');
INSERT INTO Product (nombre, precio, talla, marca, stock, descuento, urlimage) values ('Camiseta Blanca', '45000', 'S', 'Nike', 25, 10, 'https://i.postimg.cc/T2NHKCtJ/E.jpg');
INSERT INTO Product (nombre, precio, talla, marca, stock, descuento, urlimage) values ('Pantalón Negro', '75000', 'M', 'Adidas', 30, 15, 'https://i.postimg.cc/mrWnbkmx/F.avif');
INSERT INTO Product (nombre, precio, talla, marca, stock, descuento, urlimage) values ('Zapatos de Cuero', '180000', 'L', 'Gucci', 10, 5, 'https://i.postimg.cc/4NMMSBtx/G.webp');
INSERT INTO Product (nombre, precio, talla, marca, stock, descuento, urlimage) values ('Chaqueta de Jean', '95000', 'XL', 'Levi´s', 20, 0, 'https://i.postimg.cc/90gSVBn1/H.webp');
INSERT INTO Product (nombre, precio, talla, marca, stock, descuento, urlimage) values ('Gorra Roja', '35000', 'Unico', 'New Era', 40, 8, 'https://i.postimg.cc/PJ7605CR/I.png');
INSERT INTO Product (nombre, precio, talla, marca, stock, descuento, urlimage) values ('Bufanda de Lana', '55000', 'M', 'Burberry', 15, 12, 'https://i.postimg.cc/fT3qmmFn/J.webp');
INSERT INTO Product (nombre, precio, talla, marca, stock, descuento, urlimage) values ('Reloj Plateado', '220000', 'Unico', 'Rolex', 5, 0, 'https://i.postimg.cc/1tJ7cHsP/K.webp');
INSERT INTO Product (nombre, precio, talla, marca, stock, descuento, urlimage) values ('Vestido Floral', '135000', 'L', 'Dior', 12, 18, 'https://i.postimg.cc/3NNSLvxG/L.webp');
INSERT INTO Product (nombre, precio, talla, marca, stock, descuento, urlimage) values ('Cartera de Cuero', '98000', 'Unico', 'Prada', 8, 10, 'https://i.postimg.cc/26zXZJp2/M.jpg');
INSERT INTO Product (nombre, precio, talla, marca, stock, descuento, urlimage) values ('Suéter de Algodón', '68000', 'XL', 'H&M', 18, 20, 'https://i.postimg.cc/DzQMmhNS/N.webp');


insert into client (nombre,apellido,telefono,correo,contrasena,rol,conectado) values ('Carlos','Cardenas','318333111','cardenas@gmail.com','admin','Admin',false);
insert into client (nombre,apellido,telefono,correo,contrasena,rol,conectado) values ('Sarah','Mikhail','316345111','SaraM@gmail.com','hijkl','Empleado',false);
insert into client (nombre,apellido,telefono,correo,contrasena,rol,conectado) values ('Daniel','Millan','316542113','DaniM@gmail.com','abcde','Cliente',false);

insert into sale (valor_costo,valor_venta,creacion) values (2000,3500,now());
insert into sale (valor_costo,valor_venta,creacion) values (5000,7000,now());
insert into sale (impuesto,descripcion_IMP,creacion) values (55000,'Factura de Luz',now());

