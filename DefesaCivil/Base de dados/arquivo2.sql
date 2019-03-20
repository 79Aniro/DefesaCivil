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
-- Table `defesacivil`.`Endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `defesacivil`.`Endereco` (
  `endereco_id` INT(11) NOT NULL AUTO_INCREMENT,
  `bairro` VARCHAR(60) NOT NULL,
  `nome` VARCHAR(60) NOT NULL,
  `cep` VARCHAR(15) NOT NULL,
  `regiao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`endereco_id`));



-- -----------------------------------------------------
-- Table `defesacivil`.`Departamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `defesacivil`.`Departamento` (
  `departamento_id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `telefone` VARCHAR(45) NULL DEFAULT NULL,
  `numeroResidencia` INT(11) NULL DEFAULT NULL,
  `endereco_id` INT(11) NOT NULL,
  PRIMARY KEY (`departamento_id`),
  CONSTRAINT `fk_Departamento_Endereco1`
    FOREIGN KEY (`endereco_id`)
    REFERENCES `defesacivil`.`Endereco` (`endereco_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



-- -----------------------------------------------------
-- Table `defesacivil`.`Funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `defesacivil`.`Funcionario` (
  `funcionario_id` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(60) NOT NULL,
  `nome` VARCHAR(60) NOT NULL,
  `senha` VARCHAR(90) NOT NULL,
  PRIMARY KEY (`funcionario_id`));



-- -----------------------------------------------------
-- Table `defesacivil`.`Origem_Ocorrencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `defesacivil`.`Origem_Ocorrencia` (
  `origem_ocorrencia_id` INT(11) NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`origem_ocorrencia_id`));



-- -----------------------------------------------------
-- Table `defesacivil`.`Tipo_Ocorrencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `defesacivil`.`Tipo_Ocorrencia` (
  `tipo_ocorrencia_id` INT(11) NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`tipo_ocorrencia_id`));



-- -----------------------------------------------------
-- Table `defesacivil`.`Ocorrencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `defesacivil`.`Ocorrencia` (
  `ocorrencia_id` INT(11) NOT NULL AUTO_INCREMENT,
  `endereco_id` INT(11) NOT NULL,
  `funcionario_id` INT(11) NOT NULL,
  `tipo_ocorrencia_id` INT(11) NOT NULL,
  `origem_ocorrencia_id` INT(11) NOT NULL,
  `data_abertura` DATE NOT NULL,
  `data_atendimento` DATE NULL DEFAULT NULL,
  `data_conclusao` DATE NULL DEFAULT NULL,
  `status` VARCHAR(45) NULL DEFAULT NULL,
  `tipoOcorrencia` VARCHAR(45) NOT NULL,
  `historicoInicial` VARCHAR(300) NULL DEFAULT NULL,
  `origemOcorrencia` INT(11) NOT NULL,
  `numeroLocal` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ocorrencia_id`),
  CONSTRAINT `endereco_ocorrencia_fk`
    FOREIGN KEY (`endereco_id`)
    REFERENCES `defesacivil`.`Endereco` (`endereco_id`),
  CONSTRAINT `funcionario_ocorrencia_fk`
    FOREIGN KEY (`funcionario_id`)
    REFERENCES `defesacivil`.`Funcionario` (`funcionario_id`),
  CONSTRAINT `origemocorrencia_ocorrencia_fk`
    FOREIGN KEY (`origem_ocorrencia_id`)
    REFERENCES `defesacivil`.`Origem_Ocorrencia` (`origem_ocorrencia_id`),
  CONSTRAINT `tipoocorrencia_ocorrencia_fk`
    FOREIGN KEY (`tipo_ocorrencia_id`)
    REFERENCES `defesacivil`.`Tipo_Ocorrencia` (`tipo_ocorrencia_id`));



-- -----------------------------------------------------
-- Table `defesacivil`.`Perfil`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `defesacivil`.`Perfil` (
  `perfil_id` INT(11) NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`perfil_id`));



-- -----------------------------------------------------
-- Table `defesacivil`.`Tramitacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `defesacivil`.`Tramitacao` (
  `tramitacao_id` INT(11) NOT NULL,
  `descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`tramitacao_id`));



-- -----------------------------------------------------
-- Table `defesacivil`.`Relatorio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `defesacivil`.`Relatorio` (
  `relatorio_id` INT(11) NOT NULL AUTO_INCREMENT,
  `funcionario_id` INT(11) NOT NULL,
  `ocorrencia_id` INT(11) NOT NULL,
  `endereco_id` INT(11) NOT NULL,
  `numero_local` INT(11) NULL,
  `observacao` VARCHAR(1200) NULL DEFAULT NULL,
  `vistoria` VARCHAR(1200) NOT NULL,
  `tramitacao_id` INT(11) NOT NULL,
  PRIMARY KEY (`relatorio_id`),
  CONSTRAINT `endereco_relatorio_fk`
    FOREIGN KEY (`endereco_id`)
    REFERENCES `defesacivil`.`Endereco` (`endereco_id`),
  CONSTRAINT `funcionario_relatorio_fk`
    FOREIGN KEY (`funcionario_id`)
    REFERENCES `defesacivil`.`Funcionario` (`funcionario_id`),
  CONSTRAINT `ocorrencia_relatorio_fk`
    FOREIGN KEY (`ocorrencia_id` )
    REFERENCES `defesacivil`.`Ocorrencia` (`ocorrencia_id` ),
  CONSTRAINT `fk_Relatorio_Tramitacao1`
    FOREIGN KEY (`tramitacao_id`)
    REFERENCES `defesacivil`.`Tramitacao` (`tramitacao_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



-- -----------------------------------------------------
-- Table `defesacivil`.`Tipo_Solicitante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `defesacivil`.`Tipo_Solicitante` (
  `tipo_solicitante_id` INT(11) NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`tipo_solicitante_id`));



-- -----------------------------------------------------
-- Table `defesacivil`.`Solicitante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `defesacivil`.`Solicitante` (
  `solicitante_id` INT(11) NOT NULL AUTO_INCREMENT,
  `tipo_solicitante_id` INT(11) NOT NULL,
  `email` VARCHAR(60) NULL DEFAULT NULL,
  `nome` VARCHAR(60) NOT NULL,
  `numero_residencia` INT(11) NOT NULL,
  `endereco_id` INT(11) NOT NULL,
  PRIMARY KEY (`solicitante_id`),
  CONSTRAINT `tiposolicitante_solicitante_fk`
    FOREIGN KEY (`tipo_solicitante_id`)
    REFERENCES `defesacivil`.`Tipo_Solicitante` (`tipo_solicitante_id`),
  CONSTRAINT `fk_Solicitante_Endereco1`
    FOREIGN KEY (`endereco_id`)
    REFERENCES `defesacivil`.`Endereco` (`endereco_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



-- -----------------------------------------------------
-- Table `defesacivil`.`Url_Foto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `defesacivil`.`Url_Foto` (
  `url_foto` VARCHAR(60) NOT NULL,
  `relatorio_relatorio_id` INT(11) NOT NULL,
  PRIMARY KEY (`url_foto`),
  CONSTRAINT `fk_url_Foto_relatorio1`
    FOREIGN KEY (`relatorio_relatorio_id`)
    REFERENCES `defesacivil`.`Relatorio` (`relatorio_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



-- -----------------------------------------------------
-- Table `defesacivil`.`Funcionario_has_Perfil`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `defesacivil`.`Funcionario_has_Perfil` (
  `funcionario_id` INT(11) NOT NULL,
  `perfil_id` INT(11) NOT NULL,
  PRIMARY KEY (`funcionario_id`, `perfil_id`),
  CONSTRAINT `fk_Funcionario_has_Perfil_Funcionario1`
    FOREIGN KEY (`funcionario_id`)
    REFERENCES `defesacivil`.`Funcionario` (`funcionario_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Funcionario_has_Perfil_Perfil1`
    FOREIGN KEY (`perfil_id`)
    REFERENCES `defesacivil`.`Perfil` (`perfil_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;