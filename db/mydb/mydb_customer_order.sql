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
-- Table structure for table `customer_order`
--

DROP TABLE IF EXISTS `customer_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_order` (
  `Customer_Order_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Customer_Email` varchar(45) NOT NULL,
  `Address_Address_ID` int(11) NOT NULL,
  `Date_Placed` datetime DEFAULT NULL,
  `Date_Delivered` datetime NOT NULL,
  `Status` varchar(45) NOT NULL,
  PRIMARY KEY (`Customer_Order_ID`),
  UNIQUE KEY `Customer_Order_ID_UNIQUE` (`Customer_Order_ID`),
  KEY `fk_Customer_Order_Customer1_idx` (`Customer_Email`),
  KEY `fk_Customer_Order_Address1_idx` (`Address_Address_ID`),
  CONSTRAINT `fk_Customer_Order_Address1` FOREIGN KEY (`Address_Address_ID`) REFERENCES `address` (`Address_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Customer_Order_Customer1` FOREIGN KEY (`Customer_Email`) REFERENCES `customer` (`Email`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_order`
--

LOCK TABLES `customer_order` WRITE;
/*!40000 ALTER TABLE `customer_order` DISABLE KEYS */;
INSERT INTO `customer_order` VALUES (1,'matt',6,'2005-10-10 00:00:00','2006-12-12 00:00:00','DISPATCHED'),(2,'matt',6,'2009-05-05 00:00:00','2009-05-30 00:00:00','DISPATCHED'),(3,'clive',1,'2001-09-20 00:00:00','2008-04-30 00:00:00','DISPATCHED'),(4,'clive',1,'2002-09-20 00:00:00','2003-01-01 00:00:00','DISPATCHED'),(5,'clive',7,'2016-05-05 00:00:00','0000-00-00 00:00:00','INPROGRESS'),(6,'clive',7,'2016-05-04 00:00:00','0000-00-00 00:00:00','INPROGRESS');
/*!40000 ALTER TABLE `customer_order` ENABLE KEYS */;
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
