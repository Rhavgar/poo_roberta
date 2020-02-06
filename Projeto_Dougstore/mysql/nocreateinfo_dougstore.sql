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
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES ('12345678901','Claudio','1930-12-01'),('23456789012','Barbara','1940-11-08'),('34567890123','Gisele','1950-09-19'),('45678901234','Daniel','1960-05-14'),('56789012345','Maria','1970-08-22'),('67890123456','Ana','1980-04-07'),('78901234567','Tiago','1990-06-30'),('89012345678','Wilson','2000-04-27');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `estoque`
--

LOCK TABLES `estoque` WRITE;
/*!40000 ALTER TABLE `estoque` DISABLE KEYS */;
INSERT INTO `estoque` VALUES (1,100,17.75,4.12,'2019-08-01','2021-08-01',1),(2,100,17.75,4.12,'2019-09-01','2021-09-01',1),(3,50,65.82,33.32,'2019-11-01','2021-11-01',2),(4,100,5.25,3.54,'2019-05-01','2021-05-01',3),(5,100,1.78,0.86,'2019-07-01','2021-07-01',4),(6,100,3.59,1.52,'2019-03-01','2021-04-01',5),(7,100,3.47,1.15,'2019-07-01','2021-08-01',6),(8,100,31.45,19.77,'2019-01-01','2021-02-01',7),(9,50,19.99,9.98,'2019-08-01','2021-09-01',8),(10,50,16.9,7.88,'2019-05-01','2021-05-01',9),(11,50,7.77,3.33,'2018-08-01','2022-11-01',10),(12,30,11.36,4.36,'2019-07-01','2020-07-01',11),(13,30,1.87,0.53,'2019-05-01','2020-10-01',12),(14,30,9.9,4.9,'2019-03-01','2020-09-01',13);
/*!40000 ALTER TABLE `estoque` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `fornecedor`
--

LOCK TABLES `fornecedor` WRITE;
/*!40000 ALTER TABLE `fornecedor` DISABLE KEYS */;
INSERT INTO `fornecedor` VALUES ('01002003/000405','head&shoulders','+5533988887777'),('04837596/728945','24/7','24/7_app'),('12345678/123456','remedium','remedium@fornecimento.com');
/*!40000 ALTER TABLE `fornecedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `funcao`
--

LOCK TABLES `funcao` WRITE;
/*!40000 ALTER TABLE `funcao` DISABLE KEYS */;
INSERT INTO `funcao` VALUES (1,'supervisor',4000),(2,'farmaceutico',2700),(3,'estoquista',1315),(4,'atendente',1495);
/*!40000 ALTER TABLE `funcao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES ('11111111111','Cintia Horta','1995-09-22','11122233344',2),('11122233344','Sidney Mathias','1993-10-26','11122233344',1),('22222222222','Astrobaldo','1999-11-11','11122233344',3),('33333333333','Ana','1995-12-22','11122233344',4),('55555555555','Geraldo','1993-05-07','11122233344',4);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `item_venda`
--

LOCK TABLES `item_venda` WRITE;
/*!40000 ALTER TABLE `item_venda` DISABLE KEYS */;
INSERT INTO `item_venda` VALUES (1,2,131.64,1,3),(2,3,23.31,2,11),(3,1,11.36,2,12),(4,1,5.25,3,4),(5,1,3.59,3,6),(6,1,31.45,3,8);
/*!40000 ALTER TABLE `item_venda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (1,'carbamazepina','carbamazepina','remedio','vermelha','12345678/123456'),(2,'tegretol','carbamazepina','remedio','vermelha','12345678/123456'),(3,'belmirax','mebendazol','remedio','vermelha','12345678/123456'),(4,'albendazol','albendazol','remedio','vermelha','12345678/123456'),(5,'alprazolam','alprazolam','remedio','preta','12345678/123456'),(6,'neosaldina','dipirona sodica','remedio','sem_tarja','12345678/123456'),(7,'gerovital','panax ginseng','remedio','sem tarja','12345678/123456'),(8,'natu hair',NULL,'perfumaria',NULL,'01002003/000405'),(9,'dove men+care',NULL,'perfumaria',NULL,'01002003/000405'),(10,'algodão apolo',NULL,'higiene',NULL,'01002003/000405'),(11,'doritos',NULL,'comestivel',NULL,'04837596/728945'),(12,'mentos',NULL,'comestivel',NULL,'04837596/728945'),(13,'mountain dew',NULL,'bebivel',NULL,'04837596/728945');
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `venda`
--

LOCK TABLES `venda` WRITE;
/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
INSERT INTO `venda` VALUES (1,'2020-01-26 13:15:37',131.64,'dinheiro','33333333333','78901234567'),(2,'2020-01-26 13:15:37',34.67,'credito','11111111111','34567890123'),(3,'2020-01-26 13:15:38',40.29,'ticket','22222222222','56789012345');
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-26 13:22:01
