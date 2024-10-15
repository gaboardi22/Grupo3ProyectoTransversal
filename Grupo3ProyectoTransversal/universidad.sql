-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-10-2024 a las 17:49:40
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `universidad`
--
CREATE DATABASE IF NOT EXISTS `universidad` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `universidad`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `idAlumno` int(11) NOT NULL,
  `dni` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `fechaNac` date NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`idAlumno`, `dni`, `nombre`, `apellido`, `fechaNac`, `estado`) VALUES
(1, 45070640, 'Ezequiel', 'Aravena', '2003-08-09', 1),
(2, 12345678, 'Pablo', 'Gaboardi', '2000-04-26', 1),
(3, 23456789, 'Maira', 'Lorenzoni', '2001-10-03', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscripcion`
--

CREATE TABLE `inscripcion` (
  `idInscripcion` int(11) NOT NULL,
  `idAlumno` int(11) DEFAULT NULL,
  `idMateria` int(11) DEFAULT NULL,
  `nota` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materia`
--

CREATE TABLE `materia` (
  `idMateria` int(11) NOT NULL,
  `nombre` varchar(30) DEFAULT NULL,
  `anio` int(11) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `materia`
--

INSERT INTO `materia` (`idMateria`, `nombre`, `anio`, `estado`) VALUES
(1, 'Lengua y literatura', 1, 1),
(2, 'Matematica', 1, 0),
(3, 'Lengua 2', 2, 1),
(4, 'Matematica 2', 2, 1),
(5, 'Carpinteria', 1, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`idAlumno`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  ADD PRIMARY KEY (`idInscripcion`),
  ADD UNIQUE KEY `idAlumno` (`idAlumno`,`idMateria`),
  ADD UNIQUE KEY `uc_inscripcion` (`idAlumno`,`idMateria`),
  ADD KEY `idMateria` (`idMateria`);

--
-- Indices de la tabla `materia`
--
ALTER TABLE `materia`
  ADD PRIMARY KEY (`idMateria`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  MODIFY `idAlumno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  MODIFY `idInscripcion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `materia`
--
ALTER TABLE `materia`
  MODIFY `idMateria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  ADD CONSTRAINT `inscripcion_ibfk_1` FOREIGN KEY (`idAlumno`) REFERENCES `alumnos` (`idAlumno`),
  ADD CONSTRAINT `inscripcion_ibfk_2` FOREIGN KEY (`idMateria`) REFERENCES `materia` (`idMateria`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
