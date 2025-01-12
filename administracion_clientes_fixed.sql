-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 10-01-2025 a las 19:30:58
-- Versión del servidor: 9.1.0
-- Versión de PHP: 8.3.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `administracion_clientes`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE IF NOT EXISTS `clientes` (
  `id_cliente` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `email` varchar(191) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `fecha_registro` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `email` (`email`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id_cliente`, `nombre`, `email`, `telefono`, `direccion`, `fecha_registro`) VALUES
(13, 'losfighters', 'figherts99@gmail.com', '966432226', 'the street', '2025-01-09 21:17:23'),
(2, 'María López', 'maria.lopez@email.com', '987654321', 'Avenida Siempre Viva 742', '2025-01-08 20:22:52'),
(3, 'fighters', 'fighters@gmail.con', '987654322', 'calle 6', '2025-01-08 21:44:01'),
(5, 'fighters3', 'fighters3@gmail.con', '987659323', 'calle 7', '2025-01-08 23:50:49'),
(6, 'fighters444', 'fighters4@gmail.con', '987654323', 'calle 7', '2025-01-08 23:51:03'),
(7, 'fighters5', 'fighters45@gmail.con', '987655323', 'calle 7', '2025-01-08 23:52:06'),
(8, 'fighters6', 'fighters46@gmail.con', '987655323', 'calle 7', '2025-01-08 23:55:13'),
(18, 'zelinks', 'zelinks@gmail.com', '966432221', 'zelin ks 123', '2025-01-10 14:30:32'),
(10, 'fighters771', 'fighters771@gmail.con', '987655173', 'calle 117', '2025-01-09 19:42:57'),
(12, 'finalfighters', 'figh@gmail.com', '966432225', 'las orejas', '2025-01-09 21:15:03'),
(15, 'thefighters', 'thefighters@gmail.com', '966432228x', 'calle', '2025-01-09 21:19:20'),
(16, 'potolo1', 'potolo@gmail.com', '966432229', 'las potolos', '2025-01-09 21:27:25'),
(17, 'zelinxxokas', 'zelinnn@gmail.com', '96643239', 'closet 13', '2025-01-10 13:59:42');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perfiles`
--

DROP TABLE IF EXISTS `perfiles`;
CREATE TABLE IF NOT EXISTS `perfiles` (
  `id_perfil` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_perfil`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `perfiles`
--

INSERT INTO `perfiles` (`id_perfil`, `nombre`) VALUES
(1, 'admin'),
(2, 'usuario');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id_usuario` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(191) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(191) DEFAULT NULL,
  `id_perfil` bigint NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`),
  KEY `FK19wi2qritofjhcfgi2h1qpiw7` (`id_perfil`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `username`, `password`, `email`, `id_perfil`) VALUES
(1, 'admin1', 'adminpassword', 'admin1@email.com', 1),
(2, 'user1', 'userpassword', 'user1@email.com', 2),
(3, 'admin2', '$2a$12$gSwM.9PGPw4TXgiN1ZvHbOySDupY0cvDGuSnc4HYmDfHNfctRVOOK', NULL, 1),
(4, 'admin3', '$2a$12$JBGexKMTSwrgYKG2jj40fOv.6vn8Ea0EQnUkc9Wrbt4iGYMHl6wki', NULL, 1),
(5, 'admin4', '$2a$12$JBGexKMTSwrgYKG2jj40fOv.6vn8Ea0EQnUkc9Wrbt4iGYMHl6wki', NULL, 2);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
