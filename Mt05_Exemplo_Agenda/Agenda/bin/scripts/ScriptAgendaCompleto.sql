CREATE DATABASE `agenda` /*!40100 DEFAULT CHARACTER SET utf8 */;

DROP TABLE IF EXISTS `agenda`.`pfisicas`;
CREATE TABLE  `agenda`.`pfisicas` (
  `cpf` varchar(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `dataNascimento` varchar(10) DEFAULT NULL,
  `rua` varchar(100) DEFAULT NULL,
  `numero` varchar(5) DEFAULT NULL,
  `complemento` varchar(45) DEFAULT NULL,
  `bairro` varchar(70) DEFAULT NULL,
  `cidade` varchar(100) DEFAULT NULL,
  `cep` varchar(10) DEFAULT NULL,
  `estado` varchar(3) DEFAULT NULL,
  `ddi` varchar(4) DEFAULT NULL,
  `ddd` varchar(4) DEFAULT NULL,
  `numeroTel` varchar(12) DEFAULT NULL,
  `tipo` varchar(20) DEFAULT NULL,
  `operadora` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `agenda`.`pjuridicas`;
CREATE TABLE  `agenda`.`pjuridicas` (
  `cnpj` varchar(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `razaoSocial` varchar(100) DEFAULT NULL,
  `rua` varchar(100) DEFAULT NULL,
  `numero` varchar(5) DEFAULT NULL,
  `complemento` varchar(45) DEFAULT NULL,
  `bairro` varchar(70) DEFAULT NULL,
  `cidade` varchar(100) DEFAULT NULL,
  `cep` varchar(10) DEFAULT NULL,
  `estado` varchar(3) DEFAULT NULL,
  `ddi` varchar(4) DEFAULT NULL,
  `ddd` varchar(4) DEFAULT NULL,
  `numeroTel` varchar(12) DEFAULT NULL,
  `tipo` varchar(20) DEFAULT NULL,
  `operadora` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cnpj`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;