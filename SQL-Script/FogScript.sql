-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema fogdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema fogdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fogdb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `fogdb` ;

-- -----------------------------------------------------
-- Table `fogdb`.`requests`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fogdb`.`requests` (
  `request_id` INT(11) NOT NULL AUTO_INCREMENT,
  `customer_id` INT(11) NOT NULL,
  PRIMARY KEY (`request_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fogdb`.`carports`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fogdb`.`carports` (
  `carport_id` INT(11) NOT NULL AUTO_INCREMENT,
  `request_id` INT(11) NOT NULL,
  `length` INT(11) NOT NULL,
  `width` INT(11) NOT NULL,
  `rooftype` VARCHAR(45) NULL DEFAULT NULL,
  `inclination` INT(11) NOT NULL,
  PRIMARY KEY (`carport_id`),
  INDEX `request_id` (`request_id` ASC) VISIBLE,
  CONSTRAINT `carports_ibfk_1`
    FOREIGN KEY (`request_id`)
    REFERENCES `fogdb`.`requests` (`request_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fogdb`.`customers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fogdb`.`customers` (
  `customer_id` INT(11) NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `phone` INT(8) NOT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`customer_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fogdb`.`material_lists`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fogdb`.`material_lists` (
  `request_id` INT(11) NOT NULL,
  `wood_amount` INT(11) NOT NULL,
  `screw_amount` INT(11) NOT NULL,
  `bracket_amount` INT(11) NOT NULL,
  INDEX `request_id` (`request_id` ASC) VISIBLE,
  CONSTRAINT `material_lists_ibfk_1`
    FOREIGN KEY (`request_id`)
    REFERENCES `fogdb`.`requests` (`request_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fogdb`.`shipping_addresses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fogdb`.`shipping_addresses` (
  `request_id` INT(11) NOT NULL,
  `street` VARCHAR(45) NOT NULL,
  `zip` INT(11) NOT NULL,
  `city` VARCHAR(45) NULL DEFAULT NULL,
  `firstname` VARCHAR(45) NULL DEFAULT NULL,
  `lastname` VARCHAR(45) NULL DEFAULT NULL,
  INDEX `request_id` (`request_id` ASC) VISIBLE,
  CONSTRAINT `shipping_addresses_ibfk_1`
    FOREIGN KEY (`request_id`)
    REFERENCES `fogdb`.`requests` (`request_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
