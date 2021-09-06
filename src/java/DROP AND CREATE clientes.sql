DROP TABLE IF EXISTS clientes;
CREATE TABLE clientes (
  Id int(11) NOT NULL AUTO_INCREMENT,
  Nombres varchar(100) NOT NULL,
  Apellidos varchar(100) NOT NULL,
  Direccion varchar(100) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;