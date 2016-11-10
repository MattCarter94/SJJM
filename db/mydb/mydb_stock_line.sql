-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mydb
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.16-MariaDB

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
-- Table structure for table `stock_line`
--

DROP TABLE IF EXISTS `stock_line`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stock_line` (
  `Product_Product_ID` int(11) NOT NULL,
  `Stock_Order_ID` int(11) NOT NULL,
  `Quantity` int(11) DEFAULT NULL,
  `Price` double DEFAULT NULL,
  PRIMARY KEY (`Product_Product_ID`,`Stock_Order_ID`),
  KEY `fk_Product_has_Stock_Order_Stock_Order1_idx` (`Stock_Order_ID`),
  KEY `fk_Product_has_Stock_Order_Product1_idx` (`Product_Product_ID`),
  CONSTRAINT `fk_Product_has_Stock_Order_Product1` FOREIGN KEY (`Product_Product_ID`) REFERENCES `product` (`Product_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Product_has_Stock_Order_Stock_Order1` FOREIGN KEY (`Stock_Order_ID`) REFERENCES `stock_order` (`Stock_Order_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_line`
--

LOCK TABLES `stock_line` WRITE;
/*!40000 ALTER TABLE `stock_line` DISABLE KEYS */;
INSERT INTO `stock_line` VALUES (1,1,300,1500),(2,1,500,5000),(3,1,200,400),(4,2,20,100),(5,2,50,250),(6,3,50,500),(7,4,200,400000);
/*!40000 ALTER TABLE `stock_line` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-10 14:58:05
