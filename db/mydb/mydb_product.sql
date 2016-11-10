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
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `Product_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(45) NOT NULL,
  `Price` double NOT NULL,
  `Description` varchar(455) NOT NULL,
  `Category` varchar(45) DEFAULT NULL,
  `Image` varchar(45) DEFAULT NULL,
  `Tags` varchar(45) DEFAULT NULL,
  `Status` varchar(45) DEFAULT NULL,
  `Stock` int(11) NOT NULL,
  `Max_Stock` int(11) NOT NULL,
  PRIMARY KEY (`Product_ID`),
  UNIQUE KEY `Product_ID_UNIQUE` (`Product_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Standard Clive',9.99,'Your household clive, fun for all the family. But watch out he bites!','GNOME','standardclive.jpg','standard, clive, cheap, red, red hat, green','ACTIVE',200,400),(2,'Rocket Clive',19.99,'A high explosive firework used for sending your favourite Clive to space!','GNOMEACCESSORY','rocketclive.jpg','rocket, missile, clive, launcher','ACTIVE',40,40),(3,'Replacement Clive Hat',199.95,'Hand crafted, high-quality ceramic replacement hat, suitable for any Clive range model, should not be injested','GNOMEACCESSORY','clivehat.jpg','hat, clive, replacement, red, red hat','ACTIVE',200,260),(4,'Premium Clive',250,'This premium model is hand-crafted with the finest quality ceramic material. Its coated with a high quality PVA Gl.. no \'porusware\' coating preventing extreme weather damage such as; acid rain, golf ball sized hail and meteor strikes','GNOME','premiumclive.jpg','premium, clive, porusware, porousware, red, r','ACTIVE',399,400),(5,'Divine Clive',699.95,'This radient model comes with a polishing kit, its divine aura is scientifically proven to increase sense of wellbeing. social standing and in some rare circumstances allow basic levitation','GNOME','divineclive.jpg','diving, clive, porusware, porousware','ACTIVE',20,20),(6,'Gnome Polishing Kit',18.95,'This will make any ceramic sparkle and shine, extended use with \'Divine Clives\' may cause partial if not complete blindness.','GNOMEACCESSORY','gpk.jpg','clean, cleaning, polish, manage, look after, ','ACTIVE',400,550),(7,'Garden Fountain',2995.99,'Did you know NB Gardens also sold fountains!? Well we didn\'t either so here\'s our standard garden fountain, installation not included','GARDENFOUNTAIN','fountain.jpg','water, feature, standard','ACTIVE',30,30),(8,'Premium Fountain',6999.99,'This garden fountain will really show off how much you love your garden. Comes with four gnome-holders for easy installation of gnomes in each of the four corners','GARDENFOUNTAIN','premiumfountain.jpg','water, garden, feature, expensive','ACTIVE',50,51),(9,'Extravagant Fountain',18000,'Oh boy now this is a big fountain, it\'s 20m^2 and contains eight gnome holders, perfect for a selection of Clive based products. Water is provided and directly shipped from Evian\'s processing factory for high quality mountain water. Comes with sticker pack to customise your fountain as desired.','GARDENFOUNTAIN','extrafountain.jpg','water, garden, feature, expensive','ACTIVE',20,20),(10,'Clive Miniture',15,'Missing Clive since you\'re not in your garden? We have the perfect solution, take this miniture wherever you go, or leave him around in your house','GNOME','miniclive.jpg','mini, clive, portable, cheap','ACTIVE',4000,5560),(11,'Gnome Hat Stand',100,'Got too many gnome hats? This will cover you personalisation needs with a handy storage option for our high quality ceramic hats. Out patented technology uses plutonium-based alloys to create this fantastic feature that kills insects BEFORE they touch your hats ','GNOMEACCESSORY','hatstand.jpg','hats, stand, stands, repel, bugs','ACTIVE',300,330);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-10 14:58:04
