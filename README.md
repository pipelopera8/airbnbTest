# airbnbTest
Proyecto para ofrecer casas en arriendo

Se debe correr el siguiente script para la creación de la base de datos

CREATE DATABASE `prueba` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `tfps_ubicaciones` (
  `cdubicacion` int NOT NULL AUTO_INCREMENT,
  `dsubicacion` varchar(45) NOT NULL,
  `vrminimo_alquiler` double NOT NULL,
  `snobligatorio` varchar(1) NOT NULL,
  PRIMARY KEY (`cdubicacion`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tfps_casas` (
  `cdcasa` int NOT NULL AUTO_INCREMENT,
  `dscasa` varchar(45) NOT NULL,
  `cdubicacion` int NOT NULL,
  `cddisponibilidad` int NOT NULL,
  `dsurl_casa` varchar(450) NOT NULL,
  `vrprecio` double NOT NULL,
  PRIMARY KEY (`cdcasa`),
  KEY `fk_casa_ubicaciones_idx` (`cdubicacion`),
  CONSTRAINT `fk_casa_ubicaciones` FOREIGN KEY (`cdubicacion`) REFERENCES `tfps_ubicaciones` (`cdubicacion`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO `prueba`.`tfps_ubicaciones` (`cdubicacion`, `dsubicacion`, `vrminimo_alquiler`, `snobligatorio`) VALUES ('1', 'Medellon', '1000000', 'Y');
INSERT INTO `prueba`.`tfps_ubicaciones` (`cdubicacion`, `dsubicacion`, `vrminimo_alquiler`, `snobligatorio`) VALUES ('2', 'Bogota', '2000001', 'Y');
INSERT INTO `prueba`.`tfps_ubicaciones` (`cdubicacion`, `dsubicacion`, `vrminimo_alquiler`, `snobligatorio`) VALUES ('3', 'Cali', '2000001', 'Y');
INSERT INTO `prueba`.`tfps_ubicaciones` (`cdubicacion`, `dsubicacion`, `vrminimo_alquiler`, `snobligatorio`) VALUES ('4', 'Cartagea', '1000000', 'Y');
INSERT INTO `prueba`.`tfps_ubicaciones` (`cdubicacion`, `dsubicacion`, `vrminimo_alquiler`, `snobligatorio`) VALUES ('5', 'Barraquilla', '20000', 'N');



Para probar la creación de una casa nueva se hace como ejemplo 

curl --location 'localhost:8181/api/v1/houses' \
--header 'Content-Type: application/json' \
--data '{
    "name": "casa linda 4",
    "location": {
        "id":4
    },
    "status": 1,
    "image": "fasdfasdf",
    "amount": 1000000
}'

para probar la consulta de las casas 
curl --location 'localhost:8181/api/v1/houses?minAmount=10000&maxAmount=100000'




