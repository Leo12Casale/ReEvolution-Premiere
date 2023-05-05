-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';


-- -----------------------------------------------------
-- Schema reevolutionpremiere
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `reevolutionpremiere` ;
CREATE SCHEMA IF NOT EXISTS `reevolutionpremiere` DEFAULT CHARACTER SET utf8 ;
USE `reevolutionpremiere`;

-- -----------------------------------------------------
-- Table `reevolutionpremiere`.`emisor_facturas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reevolutionpremiere`.`emisor_facturas` (
  `nombre` VARCHAR(60) NOT NULL,
  `telefono` VARCHAR(60) NOT NULL,
  `email` VARCHAR(60) NOT NULL,
  `direccion` VARCHAR(60) NOT NULL,
  `localidad` VARCHAR(45) NOT NULL,
  `provincia` VARCHAR(45) NOT NULL,
  `codigo_postal` INT NOT NULL,
  `cuit` VARCHAR(13) NOT NULL,
  `condicion_iva` VARCHAR(45) NOT NULL,
  `inicio_actividades` DATE NOT NULL,
  `ingresos_brutos` VARCHAR(45) NOT NULL,
  `fecha_actualizacion_datos` DATE NOT NULL,
  PRIMARY KEY (`nombre`))
ENGINE = InnoDB;

USE `reevolutionpremiere` ;

-- -----------------------------------------------------
-- Table `reevolutionpremiere`.`garante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reevolutionpremiere`.`garante` (
  `dni` INT NOT NULL,
  `nombre` VARCHAR(60) NOT NULL DEFAULT '',
  `telefono` VARCHAR(45) NOT NULL DEFAULT '',
  `email` VARCHAR(60) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NOT NULL DEFAULT '',
  `direccion` VARCHAR(60) NOT NULL DEFAULT '',
  `localidad` VARCHAR(45) NOT NULL DEFAULT '',
  `provincia` VARCHAR(45) NOT NULL DEFAULT '',
  `codigo_postal` INT NULL DEFAULT NULL,
  `borrado` BIT(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`dni`),
  UNIQUE INDEX `dni_UNIQUE` (`dni` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `reevolutionpremiere`.`cliente_asociado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reevolutionpremiere`.`cliente_asociado` (
  `codigo_usuario` INT NOT NULL,
  `dni` INT NOT NULL,
  `nombre` VARCHAR(60) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL DEFAULT '',
  `email` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NOT NULL DEFAULT '',
  `direccion` VARCHAR(45) NOT NULL DEFAULT '',
  `localidad` VARCHAR(45) NOT NULL DEFAULT '',
  `provincia` VARCHAR(45) NOT NULL DEFAULT '',
  `codigo_postal` INT NULL DEFAULT NULL,
  `observaciones` VARCHAR(45) NOT NULL DEFAULT '',
  `sueldo` FLOAT NOT NULL DEFAULT 0,
  `limite_de_credito` FLOAT NULL DEFAULT NULL,
  `limite_por_compra` FLOAT NULL,
  `saldo_anterior` FLOAT NOT NULL DEFAULT '0',
  `saldo_mes_anterior` FLOAT NOT NULL DEFAULT 0,
  `recargos_mora` FLOAT NOT NULL DEFAULT 0,
  `consumo` FLOAT NOT NULL DEFAULT '0',
  `dni_garante` INT NULL DEFAULT NULL,
  `borrado` BIT(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`codigo_usuario`),
  UNIQUE INDEX `ID_UNIQUE` (`codigo_usuario` ASC) VISIBLE,
  INDEX `USUARIO_FK_Garante_idx` (`dni_garante` ASC) VISIBLE,
  CONSTRAINT `cliente_asociado_FK_Garante`
    FOREIGN KEY (`dni_garante`)
    REFERENCES `reevolutionpremiere`.`garante` (`dni`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `reevolutionpremiere`.`adicional`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reevolutionpremiere`.`adicional` (
  `dni` INT NOT NULL,
  `nombre` VARCHAR(50) NOT NULL DEFAULT '',
  `telefono` VARCHAR(45) NOT NULL DEFAULT '',
  `email` VARCHAR(60) NOT NULL DEFAULT '',
  `direccion` VARCHAR(60) NOT NULL DEFAULT '',
  `localidad` VARCHAR(45) NOT NULL DEFAULT '',
  `provincia` VARCHAR(45) NOT NULL DEFAULT '',
  `codigo_postal` INT NULL DEFAULT NULL,
  `codigo_cliente_asociado_titular` INT NOT NULL,
  `borrado` BIT(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`dni`),
  INDEX `adicional_FK_usuario_idx` (`codigo_cliente_asociado_titular` ASC) VISIBLE,
  CONSTRAINT `adicional_FK_usuario`
    FOREIGN KEY (`codigo_cliente_asociado_titular`)
    REFERENCES `reevolutionpremiere`.`cliente_asociado` (`codigo_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `reevolutionpremiere`.`cierrecaja`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reevolutionpremiere`.`cierrecaja` (
  `fecha_cierre` DATE NOT NULL,
  `importe_efectivo` FLOAT NOT NULL,
  `importe_tarjeta` FLOAT NOT NULL,
  PRIMARY KEY (`fecha_cierre`),
  UNIQUE INDEX `fecha_UNIQUE` (`fecha_cierre` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `reevolutionpremiere`.`comercio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reevolutionpremiere`.`comercio` (
  `codigo_comercio` INT NOT NULL,
  `razon_social` VARCHAR(60) NOT NULL,
  `nombre_fantasia` VARCHAR(60) NOT NULL DEFAULT '',
  `cuit` VARCHAR(13) NOT NULL,
  `condicion_iva` VARCHAR(30) NOT NULL,
  `importe_consumos` FLOAT NOT NULL DEFAULT 0,
  `importe_comisiones` FLOAT NOT NULL DEFAULT 0,
  `dia_cobro` INT NOT NULL DEFAULT '10',
  `telefono` VARCHAR(25) NOT NULL DEFAULT '',
  `nombre_duenio` VARCHAR(60) NOT NULL DEFAULT '',
  `email` VARCHAR(60) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NOT NULL DEFAULT '',
  `direccion` VARCHAR(60) NOT NULL DEFAULT '',
  `localidad` VARCHAR(45) NOT NULL DEFAULT '',
  `provincia` VARCHAR(45) NOT NULL DEFAULT '',
  `codigo_postal` INT NULL DEFAULT NULL,
  `observaciones` VARCHAR(100) NOT NULL DEFAULT '',
  `borrado` BIT(1) NOT NULL DEFAULT b'0',
  `comisiones_por_cuota` JSON NOT NULL,
  PRIMARY KEY (`codigo_comercio`),
  UNIQUE INDEX `ID_UNIQUE` (`codigo_comercio` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `reevolutionpremiere`.`cupon`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reevolutionpremiere`.`cupon` (
  `numero` INT NOT NULL,
  `codigo_cliente_asociado` INT NOT NULL,
  `dni_adicional` INT NULL DEFAULT NULL,
  `codigo_comercio` INT NOT NULL,
  `fecha_cupon` DATE NOT NULL,
  `fecha_carga` DATE NULL,
  `importe_total` FLOAT NOT NULL,
  `cant_cuotas` INT NOT NULL,
  `num_cuota_vigente` INT NOT NULL DEFAULT 1,
  `cancelado` BIT(1) NOT NULL DEFAULT b'0',
  `anulado` BIT(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`numero`),
  UNIQUE INDEX `UNIQUE` (`numero` ASC) VISIBLE,
  INDEX `FK_cupones_usuarios` (`codigo_cliente_asociado` ASC) VISIBLE,
  INDEX `FK_cupones_comercios` (`codigo_comercio` ASC) VISIBLE,
  INDEX `cupones_adicional_FK_idx` (`dni_adicional` ASC) VISIBLE,
  CONSTRAINT `cupones_IDComercios_FK`
    FOREIGN KEY (`codigo_comercio`)
    REFERENCES `reevolutionpremiere`.`comercio` (`codigo_comercio`),
  CONSTRAINT `cupones_IDUsuarios_FK`
    FOREIGN KEY (`codigo_cliente_asociado`)
    REFERENCES `reevolutionpremiere`.`cliente_asociado` (`codigo_usuario`),
  CONSTRAINT `cupones_adicional_FK`
    FOREIGN KEY (`dni_adicional`)
    REFERENCES `reevolutionpremiere`.`adicional` (`dni`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `reevolutionpremiere`.`factura_cliente_asociado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reevolutionpremiere`.`factura_cliente_asociado` (
  `numero_factura` INT NOT NULL,
  `tipo_factura` CHAR(1) NOT NULL DEFAULT 'B',
  `codigo_tipo_factura` VARCHAR(3) NOT NULL DEFAULT '006',
  `cae` VARCHAR(14) NOT NULL,
  `vencimiento_cae` DATE NOT NULL,
  `fecha_emision` DATE NOT NULL,
  `fecha_vencimiento_factura` DATE NOT NULL,
  `fecha_periodo_desde` DATE NOT NULL,
  `fecha_periodo_hasta` DATE NOT NULL,
  `saldo_anterior` FLOAT NOT NULL,
  `saldo_mes_anterior` FLOAT NOT NULL,
  `pagos_mes_anterior` FLOAT NOT NULL,
  `compras_del_mes` FLOAT NOT NULL,
  `recargos_por_mora` FLOAT NOT NULL,
  `sellado` FLOAT NOT NULL,
  `gastos_administrativos` FLOAT NOT NULL,
  `contingencia_seguro` FLOAT NOT NULL,
  `iva` FLOAT NOT NULL,
  `importe_total` FLOAT NOT NULL,
  `codigo_cliente_asociado` INT NOT NULL,
  PRIMARY KEY (`numero_factura`),
  UNIQUE INDEX `numero_UNIQUE` (`numero_factura` ASC) VISIBLE,
  INDEX `fk_factura_usuario_idx` (`codigo_cliente_asociado` ASC) VISIBLE,
  CONSTRAINT `fk_facturausuario_clienteasociado`
    FOREIGN KEY (`codigo_cliente_asociado`)
    REFERENCES `reevolutionpremiere`.`cliente_asociado` (`codigo_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `reevolutionpremiere`.`factura_comercio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reevolutionpremiere`.`factura_comercio` (
  `numero_factura` INT NOT NULL,
  `tipo_factura` CHAR(1) NOT NULL,
  `codigo_tipo_factura` VARCHAR(3) NOT NULL,
  `cae` VARCHAR(14) NOT NULL,
  `vencimiento_cae` DATE NOT NULL,
  `fecha_emision` DATE NOT NULL,
  `fecha_vencimiento_factura` DATE NOT NULL,
  `fecha_periodo_desde` DATE NOT NULL,
  `fecha_periodo_hasta` DATE NOT NULL,
  `total_cupones` FLOAT NOT NULL,
  `total_comisiones` FLOAT NOT NULL,
  `iva` FLOAT NOT NULL,
  `importe_a_liquidar` FLOAT NOT NULL,
  `pagada` BIT(1) NULL DEFAULT b'0',
  `id_comercio` INT NOT NULL,
  PRIMARY KEY (`numero_factura`),
  UNIQUE INDEX `numero_UNIQUE` (`numero_factura` ASC) VISIBLE,
  INDEX `fk_facturac_comercio_idx` (`id_comercio` ASC) VISIBLE,
  CONSTRAINT `fk_facturacomercio_comercio1`
    FOREIGN KEY (`id_comercio`)
    REFERENCES `reevolutionpremiere`.`comercio` (`codigo_comercio`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `reevolutionpremiere`.`cuota`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reevolutionpremiere`.`cuota` (
  `id_cuota` INT NOT NULL AUTO_INCREMENT,
  `numero_cuota` INT NOT NULL,
  `importe` FLOAT NOT NULL,
  `es_de_comercio` BIT(1) NOT NULL DEFAULT b'0',
  `numero_factura_cliente_asociado` INT NULL DEFAULT NULL,
  `numero_factura_comercio` INT NULL,
  `id_cupon` INT NOT NULL,
  `borrada` BIT(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id_cuota`),
  UNIQUE INDEX `id_cuota_UNIQUE` (`id_cuota` ASC) VISIBLE,
  INDEX `cuotas_fk_IDCupon_idx` (`id_cupon` ASC) VISIBLE,
  INDEX `fk_cuota_facturausuario1_idx` (`numero_factura_cliente_asociado` ASC) VISIBLE,
  INDEX `cuota_fk_facturacomercio_idx` (`numero_factura_comercio` ASC) VISIBLE,
  CONSTRAINT `cuota_fk_IDCupon`
    FOREIGN KEY (`id_cupon`)
    REFERENCES `reevolutionpremiere`.`cupon` (`numero`),
  CONSTRAINT `cuota_fk_facturaclienteadicional`
    FOREIGN KEY (`numero_factura_cliente_asociado`)
    REFERENCES `reevolutionpremiere`.`factura_cliente_asociado` (`numero_factura`),
  CONSTRAINT `cuota_fk_facturacomercio`
    FOREIGN KEY (`numero_factura_comercio`)
    REFERENCES `reevolutionpremiere`.`factura_comercio` (`numero_factura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1049
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `reevolutionpremiere`.`movimiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reevolutionpremiere`.`movimiento` (
  `id_movimiento` INT NOT NULL AUTO_INCREMENT,
  `concepto` VARCHAR(30) NULL DEFAULT 'Varios',
  `modo_pago` VARCHAR(15) NOT NULL,
  `monto` FLOAT NOT NULL,
  `fecha` DATE NOT NULL,
  `observaciones` VARCHAR(75) NULL DEFAULT NULL,
  `anulado` BIT(1) NOT NULL DEFAULT b'0',
  `codigo_usuario` INT NULL DEFAULT NULL,
  `numero_factura_comercio` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id_movimiento`),
  UNIQUE INDEX `ID_UNIQUE` (`id_movimiento` ASC) VISIBLE,
  INDEX `movimiento_FK_codigo_usuario` (`codigo_usuario` ASC) VISIBLE,
  INDEX `movimiento_FK_factura_comercio` (`numero_factura_comercio` ASC) VISIBLE,
  CONSTRAINT `movimiento_FK_codigo_usuario`
    FOREIGN KEY (`codigo_usuario`)
    REFERENCES `reevolutionpremiere`.`cliente_asociado` (`codigo_usuario`),
  CONSTRAINT `movimiento_FK_factura_comercio`
    FOREIGN KEY (`numero_factura_comercio`)
    REFERENCES `reevolutionpremiere`.`factura_comercio` (`numero_factura`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
