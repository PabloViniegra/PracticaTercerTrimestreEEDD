-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-05-2020 a las 01:13:57
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyectoeedd3ºt`
--
CREATE DATABASE IF NOT EXISTS `proyectoeedd3ºt` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE `proyectoeedd3ºt`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `artistas`
--

CREATE TABLE `artistas` (
  `IdArtista` int(11) NOT NULL,
  `NombreArt` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `AñoCreacion` int(11) NOT NULL,
  `NumIntegrantes` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- RELACIONES PARA LA TABLA `artistas`:
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `canciones`
--

CREATE TABLE `canciones` (
  `IdCancion` int(11) NOT NULL,
  `IdArtista` int(11) NOT NULL,
  `IdDisco` int(11) NOT NULL,
  `NombreCan` varchar(250) COLLATE utf8_spanish_ci NOT NULL,
  `Duracion` int(11) NOT NULL,
  `Genero` varchar(60) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- RELACIONES PARA LA TABLA `canciones`:
--   `IdArtista`
--       `artistas` -> `IdArtista`
--   `IdDisco`
--       `discos` -> `IdDisco`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `discos`
--

CREATE TABLE `discos` (
  `IdDisco` int(11) NOT NULL,
  `ImgPortada` varchar(350) COLLATE utf8_spanish_ci NOT NULL,
  `Precio` float NOT NULL,
  `NombreDisco` varchar(100) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- RELACIONES PARA LA TABLA `discos`:
--

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `artistas`
--
ALTER TABLE `artistas`
  ADD PRIMARY KEY (`IdArtista`);

--
-- Indices de la tabla `canciones`
--
ALTER TABLE `canciones`
  ADD PRIMARY KEY (`IdCancion`),
  ADD KEY `fk_artista` (`IdArtista`),
  ADD KEY `fk_disco` (`IdDisco`);

--
-- Indices de la tabla `discos`
--
ALTER TABLE `discos`
  ADD PRIMARY KEY (`IdDisco`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `artistas`
--
ALTER TABLE `artistas`
  MODIFY `IdArtista` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `canciones`
--
ALTER TABLE `canciones`
  MODIFY `IdCancion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `discos`
--
ALTER TABLE `discos`
  MODIFY `IdDisco` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `canciones`
--
ALTER TABLE `canciones`
  ADD CONSTRAINT `fk_artista` FOREIGN KEY (`IdArtista`) REFERENCES `artistas` (`IdArtista`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_disco` FOREIGN KEY (`IdDisco`) REFERENCES `discos` (`IdDisco`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
