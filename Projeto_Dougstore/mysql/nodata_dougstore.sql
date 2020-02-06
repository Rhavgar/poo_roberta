-- MySQL dump 10.13  Distrib 5.7.27, for Linux (x86_64)
--
-- Host: localhost    Database: dougstore
-- ------------------------------------------------------
-- Server version	5.7.27-0ubuntu0.18.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `cpf` varchar(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `nascimento` date NOT NULL,
  PRIMARY KEY (`cpf`),
  KEY `idx_nome` (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `estoque`
--

DROP TABLE IF EXISTS `estoque`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estoque` (
  `lote` int(11) NOT NULL AUTO_INCREMENT,
  `quantidade` int(11) DEFAULT NULL,
  `preco_venda` double DEFAULT NULL,
  `preco_custo` double DEFAULT NULL,
  `fabricacao` date NOT NULL,
  `validade` date NOT NULL,
  `produto_codigo` int(11) NOT NULL,
  PRIMARY KEY (`lote`),
  KEY `fk_produto` (`produto_codigo`),
  CONSTRAINT `fk_produto` FOREIGN KEY (`produto_codigo`) REFERENCES `produto` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `fornecedor`
--

DROP TABLE IF EXISTS `fornecedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fornecedor` (
  `cnpj` varchar(15) NOT NULL,
  `nome_fantasia` varchar(45) NOT NULL,
  `contato` varchar(30) NOT NULL,
  PRIMARY KEY (`cnpj`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `funcao`
--

DROP TABLE IF EXISTS `funcao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcao` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(75) NOT NULL,
  `salario` double NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `cpf` varchar(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `nascimento` date NOT NULL,
  `supervisor_cpf` varchar(11) NOT NULL,
  `funcao_codigo` int(11) NOT NULL,
  PRIMARY KEY (`cpf`),
  KEY `fk_funcionario` (`supervisor_cpf`),
  KEY `fk_funcao` (`funcao_codigo`),
  CONSTRAINT `fk_funcao` FOREIGN KEY (`funcao_codigo`) REFERENCES `funcao` (`codigo`),
  CONSTRAINT `fk_funcionario` FOREIGN KEY (`supervisor_cpf`) REFERENCES `funcionario` (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `item_venda`
--

DROP TABLE IF EXISTS `item_venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_venda` (
  `id_item` int(11) NOT NULL AUTO_INCREMENT,
  `quantidade` int(11) NOT NULL,
  `valor_total` double DEFAULT NULL,
  `venda_id` int(11) NOT NULL,
  `estoque_lote` int(11) NOT NULL,
  PRIMARY KEY (`id_item`),
  KEY `fk_venda` (`venda_id`),
  KEY `fk_estoque` (`estoque_lote`),
  CONSTRAINT `fk_estoque` FOREIGN KEY (`estoque_lote`) REFERENCES `estoque` (`lote`),
  CONSTRAINT `fk_venda` FOREIGN KEY (`venda_id`) REFERENCES `venda` (`id_venda`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produto` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nome_comercial` varchar(25) NOT NULL,
  `nome_generico` varchar(25) DEFAULT NULL,
  `tipo` varchar(15) NOT NULL,
  `tarja` varchar(15) DEFAULT NULL,
  `fornecedor_cnpj` varchar(15) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `idx_comercial` (`nome_comercial`),
  KEY `idx_generico` (`nome_generico`),
  KEY `idx_tipo` (`tipo`),
  KEY `fk_fornecedor` (`fornecedor_cnpj`),
  CONSTRAINT `fk_fornecedor` FOREIGN KEY (`fornecedor_cnpj`) REFERENCES `fornecedor` (`cnpj`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `venda`
--

DROP TABLE IF EXISTS `venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venda` (
  `id_venda` int(11) NOT NULL AUTO_INCREMENT,
  `data_venda` datetime NOT NULL,
  `valor` double DEFAULT NULL,
  `forma_pag` varchar(15) NOT NULL,
  `funcionario_cpf` varchar(11) NOT NULL,
  `cliente_cpf` varchar(11) NOT NULL,
  PRIMARY KEY (`id_venda`),
  KEY `fk_vendedor` (`funcionario_cpf`),
  KEY `fk_comprador` (`cliente_cpf`),
  CONSTRAINT `fk_comprador` FOREIGN KEY (`cliente_cpf`) REFERENCES `cliente` (`cpf`),
  CONSTRAINT `fk_vendedor` FOREIGN KEY (`funcionario_cpf`) REFERENCES `funcionario` (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-10 17:54:59
