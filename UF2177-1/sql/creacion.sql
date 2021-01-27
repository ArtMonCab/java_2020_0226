-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema UF2177-1
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema UF2177-1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `UF2177-1` DEFAULT CHARACTER SET utf8mb4 ;
USE `UF2177-1` ;

-- -----------------------------------------------------
-- Table `UF2177-1`.`medicamentos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `UF2177-1`.`medicamentos` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `referencia` CHAR(12) NOT NULL,
  `nombre` VARCHAR(50) NOT NULL,
  `precio` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
