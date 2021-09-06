DROP TABLE IF EXISTS detalle_cliente;
CREATE TABLE detalle_cliente (
  id int(11) NOT NULL AUTO_INCREMENT,
  web varchar(128) DEFAULT NULL,
  tfno varchar(128) DEFAULT NULL,
  comentarios varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;