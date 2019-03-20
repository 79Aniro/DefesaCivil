-- MySQL Script generated by MySQL Workbench
-- Mon Oct 22 18:55:11 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema defesacivil
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `defesacivil` ;

-- -----------------------------------------------------
-- Schema defesacivil
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `defesacivil` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `defesacivil` ;

-- -----------------------------------------------------
-- Table `defesacivil`.`departamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `defesacivil`.`departamento` ;

CREATE TABLE IF NOT EXISTS `defesacivil`.`departamento` (
  `departamento_id` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `nome` VARCHAR(255) NULL DEFAULT NULL,
  `numero_residencia` INT(11) NULL DEFAULT NULL,
  `telefone` VARCHAR(255) NULL DEFAULT NULL,
  `endereco_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`departamento_id`),
  INDEX `FK3sj9ofh6sqh8nvpkimi59qsoj` (`endereco_id` ASC) VISIBLE)
ENGINE = MyISAM
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `defesacivil`.`endereco`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `defesacivil`.`endereco` ;

CREATE TABLE IF NOT EXISTS `defesacivil`.`endereco` (
  `endereco_id` INT(11) NOT NULL AUTO_INCREMENT,
  `bairro` VARCHAR(255) NULL DEFAULT NULL,
  `cep` VARCHAR(255) NULL DEFAULT NULL,
  `nome` VARCHAR(255) NULL DEFAULT NULL,
  `regiao` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`endereco_id`))
ENGINE = MyISAM
AUTO_INCREMENT = 6034
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `defesacivil`.`funcionario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `defesacivil`.`funcionario` ;

CREATE TABLE IF NOT EXISTS `defesacivil`.`funcionario` (
  `funcionario_id` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `nome` VARCHAR(255) NULL DEFAULT NULL,
  `senha` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`funcionario_id`))
ENGINE = MyISAM
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `defesacivil`.`ocorrencia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `defesacivil`.`ocorrencia` ;

CREATE TABLE IF NOT EXISTS `defesacivil`.`ocorrencia` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `data_abertura` DATETIME NULL DEFAULT NULL,
  `data_atendimento` DATETIME NULL DEFAULT NULL,
  `data_conclusao` DATETIME NULL DEFAULT NULL,
  `historico_inicial` VARCHAR(300) NULL DEFAULT NULL,
  `numero_local` INT(11) NULL DEFAULT NULL,
  `status` VARCHAR(255) NULL DEFAULT NULL,
  `endereco_id` INT(11) NULL DEFAULT NULL,
  `funcionario_id` INT(11) NULL DEFAULT NULL,
  `origem_ocorrencia_id` INT(11) NULL DEFAULT NULL,
  `solicitante_id` INT(11) NULL DEFAULT NULL,
  `tipo_ocorrencia_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKa3decuiy3pmf71p91hnlh86l2` (`endereco_id` ASC) VISIBLE,
  INDEX `FK2m8py0juaapy3j7b73pb6a2b8` (`funcionario_id` ASC) VISIBLE,
  INDEX `FKmup88a086af8xqmto1pu33gnk` (`origem_ocorrencia_id` ASC) VISIBLE,
  INDEX `FKlxyslyy1dlu315rh6afh71p4l` (`solicitante_id` ASC) VISIBLE,
  INDEX `FKeu4trbnjoct8fsfvuhgckop1x` (`tipo_ocorrencia_id` ASC) VISIBLE)
ENGINE = MyISAM
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `defesacivil`.`origem_ocorrencia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `defesacivil`.`origem_ocorrencia` ;

CREATE TABLE IF NOT EXISTS `defesacivil`.`origem_ocorrencia` (
  `origem_ocorrencia_id` INT(11) NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`origem_ocorrencia_id`))
ENGINE = MyISAM
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `defesacivil`.`perfis`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `defesacivil`.`perfis` ;

CREATE TABLE IF NOT EXISTS `defesacivil`.`perfis` (
  `funcionario_funcionario_id` INT(11) NOT NULL,
  `perfis` INT(11) NULL DEFAULT NULL,
  INDEX `FKopfnsccxcmy53uevbbgspd725` (`funcionario_funcionario_id` ASC) VISIBLE)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `defesacivil`.`relatorio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `defesacivil`.`relatorio` ;

CREATE TABLE IF NOT EXISTS `defesacivil`.`relatorio` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `numero_local` INT(11) NULL DEFAULT NULL,
  `observacao` VARCHAR(1200) NULL DEFAULT NULL,
  `vistoria` VARCHAR(1200) NULL DEFAULT NULL,
  `endereco_id` INT(11) NULL DEFAULT NULL,
  `funcionario_id` INT(11) NULL DEFAULT NULL,
  `ocorrencia_id` INT(11) NULL,
  `tramitacao_id` INT(11) NULL DEFAULT NULL,
  INDEX `FK85lildukfk4q65hlpqq72b045` (`endereco_id` ASC) VISIBLE,
  INDEX `FK8qgd6idmt1dugwhymdwlmbkcg` (`funcionario_id` ASC) VISIBLE,
  INDEX `FKlwmf5d5wkguvfk4fe2m1e0hs4` (`ocorrencia_id` ASC) VISIBLE,
  INDEX `FKcht0dgky2oj1t2pg1n2hxj0ek` (`tramitacao_id` ASC) VISIBLE)
ENGINE = MyISAM
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `defesacivil`.`solicitante`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `defesacivil`.`solicitante` ;

CREATE TABLE IF NOT EXISTS `defesacivil`.`solicitante` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `nome` VARCHAR(255) NULL DEFAULT NULL,
  `numero_residencia` INT(11) NULL DEFAULT NULL,
  `endereco_id` INT(11) NULL DEFAULT NULL,
  `tipo_solicitante_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK3sn2p9x3tk826aibu452wlqb5` (`endereco_id` ASC) VISIBLE,
  INDEX `FK87qmp35hce36ai9om4r33nb2c` (`tipo_solicitante_id` ASC) VISIBLE)
ENGINE = MyISAM
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `defesacivil`.`telefone`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `defesacivil`.`telefone` ;

CREATE TABLE IF NOT EXISTS `defesacivil`.`telefone` (
  `solicitante_id` INT(11) NOT NULL,
  `telefones` VARCHAR(255) NULL DEFAULT NULL,
  INDEX `FK1fkpgmyvlkfm3mt3avxi7vx9r` (`solicitante_id` ASC) VISIBLE)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `defesacivil`.`tipo_ocorrencia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `defesacivil`.`tipo_ocorrencia` ;

CREATE TABLE IF NOT EXISTS `defesacivil`.`tipo_ocorrencia` (
  `tipo_ocorrencia_id` INT(11) NOT NULL AUTO_INCREMENT,
  `codigo` VARCHAR(255) NULL DEFAULT NULL,
  `descricao` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`tipo_ocorrencia_id`))
ENGINE = MyISAM
AUTO_INCREMENT = 26
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `defesacivil`.`tipo_solicitante`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `defesacivil`.`tipo_solicitante` ;

CREATE TABLE IF NOT EXISTS `defesacivil`.`tipo_solicitante` (
  `tipo_solicitante_id` INT(11) NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`tipo_solicitante_id`))
ENGINE = MyISAM
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `defesacivil`.`tramitacao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `defesacivil`.`tramitacao` ;

CREATE TABLE IF NOT EXISTS `defesacivil`.`tramitacao` (
  `tramitacao_id` INT(11) NOT NULL AUTO_INCREMENT,
  `cod` INT(11) NULL DEFAULT NULL,
  `descricao` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`tramitacao_id`))
ENGINE = MyISAM
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `defesacivil`.`url_foto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `defesacivil`.`url_foto` ;

CREATE TABLE IF NOT EXISTS `defesacivil`.`url_foto` (
  `relatorio_id` INT(11) NOT NULL,
  `url_foto` LONGTEXT NULL DEFAULT NULL,
  INDEX `FK732ckxcn2v4orktufmqrxvatv` (`relatorio_id` ASC) VISIBLE)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
