-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.0.33 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para biblioteca_2
CREATE DATABASE IF NOT EXISTS `biblioteca` /*!40100 DEFAULT CHARACTER SET utf16 COLLATE utf16_spanish_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `biblioteca`;

-- Volcando estructura para tabla biblioteca_2.bibliotecario
CREATE TABLE IF NOT EXISTS `bibliotecario` (
  `idBibliotecario` int NOT NULL AUTO_INCREMENT,
  `horario` varchar(30) COLLATE utf16_spanish_ci NOT NULL,
  `sueldo` int NOT NULL,
  `telefono` varchar(9) COLLATE utf16_spanish_ci NOT NULL,
  `Usuario_dni` varchar(10) COLLATE utf16_spanish_ci NOT NULL,
  PRIMARY KEY (`idBibliotecario`),
  KEY `fk_Bibliotecario_Usuario1_idx` (`Usuario_dni`),
  CONSTRAINT `fk_Bibliotecario_Usuario1` FOREIGN KEY (`Usuario_dni`) REFERENCES `usuario` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf16 COLLATE=utf16_spanish_ci;

-- Volcando datos para la tabla biblioteca_2.bibliotecario: ~2 rows (aproximadamente)
DELETE FROM `bibliotecario`;
/*!40000 ALTER TABLE `bibliotecario` DISABLE KEYS */;
INSERT INTO `bibliotecario` (`idBibliotecario`, `horario`, `sueldo`, `telefono`, `Usuario_dni`) VALUES
	(1, '9:00 a 14:00', 1750, '605000001', '11111111A'),
	(2, '17:00 a 21:00', 150, '607000002', '22222222B');
/*!40000 ALTER TABLE `bibliotecario` ENABLE KEYS */;

-- Volcando estructura para tabla biblioteca_2.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `idCliente` int NOT NULL AUTO_INCREMENT,
  `telefono` varchar(9) COLLATE utf16_spanish_ci NOT NULL,
  `Usuario_dni` varchar(10) COLLATE utf16_spanish_ci NOT NULL,
  PRIMARY KEY (`idCliente`),
  KEY `fk_Cliente_Usuario_idx` (`Usuario_dni`),
  CONSTRAINT `fk_Cliente_Usuario` FOREIGN KEY (`Usuario_dni`) REFERENCES `usuario` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf16 COLLATE=utf16_spanish_ci;

-- Volcando datos para la tabla biblioteca_2.cliente: ~2 rows (aproximadamente)
DELETE FROM `cliente`;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`idCliente`, `telefono`, `Usuario_dni`) VALUES
	(1, '867000005', '33333333C'),
	(2, '754000006', '44444444D'),
	(3, '645000108', '55555555E');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;

-- Volcando estructura para tabla biblioteca_2.escritor
CREATE TABLE IF NOT EXISTS `escritor` (
  `idEscritor` int NOT NULL AUTO_INCREMENT,
  `idioma` varchar(20) COLLATE utf16_spanish_ci NOT NULL,
  `Usuario_dni` varchar(10) COLLATE utf16_spanish_ci NOT NULL,
  PRIMARY KEY (`idEscritor`),
  KEY `fk_Escritor_Usuario1_idx` (`Usuario_dni`),
  CONSTRAINT `fk_Escritor_Usuario1` FOREIGN KEY (`Usuario_dni`) REFERENCES `usuario` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf16 COLLATE=utf16_spanish_ci;

-- Volcando datos para la tabla biblioteca_2.escritor: ~2 rows (aproximadamente)
DELETE FROM `escritor`;
/*!40000 ALTER TABLE `escritor` DISABLE KEYS */;
INSERT INTO `escritor` (`idEscritor`, `idioma`, `Usuario_dni`) VALUES
	(1, 'ESPAÑOL', '66666666F'),
	(2, 'ESPAÑOL', '77777777G'),
	(3, 'INGLES', '88888888H');
/*!40000 ALTER TABLE `escritor` ENABLE KEYS */;

-- Volcando estructura para tabla biblioteca_2.libro
CREATE TABLE IF NOT EXISTS `libro` (
  `idLibro` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(45) COLLATE utf16_spanish_ci NOT NULL,
  `editorial` varchar(30) COLLATE utf16_spanish_ci NOT NULL,
  `paginas` int NOT NULL,
  `idEscritor` int NOT NULL,
  PRIMARY KEY (`idLibro`),
  KEY `fk_Libro_Escritor1_idx` (`idEscritor`) USING BTREE,
  CONSTRAINT `fk_Libro_Escritor1` FOREIGN KEY (`idEscritor`) REFERENCES `escritor` (`idEscritor`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf16 COLLATE=utf16_spanish_ci;

-- Volcando datos para la tabla biblioteca_2.libro: ~0 rows (aproximadamente)
DELETE FROM `libro`;
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
INSERT INTO `libro` (`idLibro`, `titulo`, `editorial`, `paginas`, `idEscritor`) VALUES
	(1, 'El hermano de las moscas', 'SALTO DE PAGINA', 225, 1),
	(2, 'Bajo el influjo del cometa', 'ANAYA', 256, 1),
	(3, 'El silencio y los crujidos', 'IMPEDIMENTA', 240, 1),
	(4, 'Todo va a mejorar', 'TUSQUETS', 322, 2),
	(5, 'El lector de Julio Verne', 'ANAYA', 188, 2),
	(6, 'Punto ciego', 'PLANETA', 160, 3),
	(7, 'Escrito en el agua', 'PLANETA', 210, 3);
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;

-- Volcando estructura para tabla biblioteca_2.librodigital
CREATE TABLE IF NOT EXISTS `librodigital` (
  `idDigital` int NOT NULL AUTO_INCREMENT,
  `formato` varchar(10) COLLATE utf16_spanish_ci NOT NULL,
  `tamMB` int NOT NULL,
  `idLibro` int NOT NULL,
  PRIMARY KEY (`idDigital`),
  KEY `fk_LibroDigital_Libro1_idx` (`idLibro`) USING BTREE,
  CONSTRAINT `fk_LibroDigital_Libro1` FOREIGN KEY (`idLibro`) REFERENCES `libro` (`idLibro`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf16 COLLATE=utf16_spanish_ci;

-- Volcando datos para la tabla biblioteca_2.librodigital: ~0 rows (aproximadamente)
DELETE FROM `librodigital`;
/*!40000 ALTER TABLE `librodigital` DISABLE KEYS */;
INSERT INTO `librodigital` (`idDigital`, `formato`, `tamMB`, `idLibro`) VALUES
	(1, 'EPUB', 75, 2),
	(2, 'PDF', 60, 1),
	(3, 'AZW', 45, 7),
	(4, 'EPUB', 80, 4);
/*!40000 ALTER TABLE `librodigital` ENABLE KEYS */;

-- Volcando estructura para tabla biblioteca_2.librofisico
CREATE TABLE IF NOT EXISTS `librofisico` (
  `idFisico` int NOT NULL AUTO_INCREMENT,
  `copias` int NOT NULL,
  `tapaDura` tinyint NOT NULL,
  `idLibro` int NOT NULL,
  PRIMARY KEY (`idFisico`),
  KEY `fk_LibroFisico_Libro1_idx` (`idLibro`) USING BTREE,
  CONSTRAINT `fk_LibroFisico_Libro1` FOREIGN KEY (`idLibro`) REFERENCES `libro` (`idLibro`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf16 COLLATE=utf16_spanish_ci;

-- Volcando datos para la tabla biblioteca_2.librofisico: ~0 rows (aproximadamente)
DELETE FROM `librofisico`;
/*!40000 ALTER TABLE `librofisico` DISABLE KEYS */;
INSERT INTO `librofisico` (`idFisico`, `copias`, `tapaDura`, `idLibro`) VALUES
	(1, 2, 0, 1),
	(2, 4, 1, 3),
	(3, 1, 1, 4),
	(4, 2, 0, 5),
	(5, 3, 0, 6),
	(6, 1, 0, 7);
/*!40000 ALTER TABLE `librofisico` ENABLE KEYS */;

-- Volcando estructura para tabla biblioteca_2.prestamo
CREATE TABLE IF NOT EXISTS `prestamo` (
  `fechaPrestamo` date NOT NULL,
  `devuelto` tinyint NOT NULL,
  `idLibro` int NOT NULL,
  `idCliente` int NOT NULL,
  PRIMARY KEY (`idLibro`,`fechaPrestamo`,`idCliente`) USING BTREE,
  KEY `fk_Prestamo_Cliente1_idx` (`idCliente`) USING BTREE,
  CONSTRAINT `fk_Prestamo_Cliente1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`),
  CONSTRAINT `fk_Prestamo_Libro1` FOREIGN KEY (`idLibro`) REFERENCES `libro` (`idLibro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_spanish_ci;

-- Volcando datos para la tabla biblioteca_2.prestamo: ~0 rows (aproximadamente)
DELETE FROM `prestamo`;
/*!40000 ALTER TABLE `prestamo` DISABLE KEYS */;
INSERT INTO `prestamo` (`fechaPrestamo`, `devuelto`, `idLibro`, `idCliente`) VALUES
	('2023-06-02', 0, 1, 3),
	('2023-05-22', 1, 2, 2),
	('2023-05-29', 0, 3, 1),
	('2023-05-14', 1, 4, 3);
/*!40000 ALTER TABLE `prestamo` ENABLE KEYS */;

-- Volcando estructura para tabla biblioteca_2.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `dni` varchar(10) COLLATE utf16_spanish_ci NOT NULL,
  `nombre` varchar(45) COLLATE utf16_spanish_ci NOT NULL,
  `edad` int NOT NULL,
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_spanish_ci;

-- Volcando datos para la tabla biblioteca_2.usuario: ~8 rows (aproximadamente)
DELETE FROM `usuario`;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`dni`, `nombre`, `edad`) VALUES
	('11111111A', 'Cristina', 29),
	('22222222B', 'David', 54),
	('33333333C', 'Eva', 37),
	('44444444D', 'Angel', 22),
	('55555555E', 'Marcos', 64),
	('66666666F', 'Jon Bilbao', 52),
	('77777777G', 'Almudena Grande', 63),
	('88888888H', 'Paula Hawkin', 48);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
