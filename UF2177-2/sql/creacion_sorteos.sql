-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema uf2177-2
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema uf2177-2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `uf2177-2` DEFAULT CHARACTER SET utf8 ;
USE `uf2177-2` ;

-- -----------------------------------------------------
-- Table `uf2177-2`.`sorteos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `uf2177-2`.`sorteos` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `num1` INT NOT NULL,
  `num2` INT NOT NULL,
  `num3` INT NOT NULL,
  `num4` INT NOT NULL,
  `num5` INT NOT NULL,
  `est1` INT NOT NULL,
  `est2` INT NOT NULL,
  `fecha` DATE NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `fecha_UNIQUE` (`fecha` ASC) VISIBLE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
