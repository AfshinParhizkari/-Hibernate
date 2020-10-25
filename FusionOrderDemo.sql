CREATE DATABASE  IF NOT EXISTS `FusionOrderDemo` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `FusionOrderDemo`;
-- MySQL dump 10.17  Distrib 10.3.22-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: FusionOrderDemo
-- ------------------------------------------------------
-- Server version	10.3.22-MariaDB-1:10.3.22+maria~bionic

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
-- Table structure for table `ADDRESSES`
--

DROP TABLE IF EXISTS `ADDRESSES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ADDRESSES` (
  `ADDRESS_ID` int(15) NOT NULL,
  `ADDRESS1` varchar(40) NOT NULL,
  `ADDRESS2` varchar(40) DEFAULT NULL,
  `CITY` varchar(40) NOT NULL,
  `POSTAL_CODE` varchar(12) DEFAULT NULL,
  `STATE_PROVINCE` varchar(40) NOT NULL,
  `COUNTRY_ID` char(2) NOT NULL,
  `LONGITUDE` int(11) DEFAULT NULL,
  `LATITUDE` int(11) DEFAULT NULL,
  `CREATED_BY` varchar(60) NOT NULL,
  `CREATION_DATE` date NOT NULL,
  `LAST_UPDATED_BY` varchar(60) NOT NULL,
  `LAST_UPDATE_DATE` date NOT NULL,
  `OBJECT_VERSION_ID` int(15) NOT NULL,
  PRIMARY KEY (`ADDRESS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='The shared address table that is used to hold customer addresses, shipping addresses, warehouse addresses and so on. ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ADDRESSES`
--

LOCK TABLES `ADDRESSES` WRITE;
/*!40000 ALTER TABLE `ADDRESSES` DISABLE KEYS */;
INSERT INTO `ADDRESSES` VALUES (1,'514 W Superior St',NULL,'Kokomo','46901','IN','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(2,'615 N Sherman Ave',NULL,'Madison','53704','WI','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(3,'100 N Peach St',NULL,'Philadelphia','19139','PA','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(4,'Via Frenzy 6903',NULL,'Tellaro','361230','Tellaro','IT',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(5,'Kreuzstr 32',NULL,'Zurich','8032','ZH','CH',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(6,'2627 Hudson St',NULL,'Baltimore','21224','MD','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(7,'3393 Peachtree Rd',NULL,'Atlanta','30326','GA','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(8,'800 Boylston St',NULL,'Boston','02199','MA','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(9,'6400 BOULEVARD DCARIE',NULL,'MONTRAL','H3X 2K2','QC','CA',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(10,'1405 11 Street SW',NULL,'Calgary','T2R 1G7','AB','CA',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(11,'631 San Felipe Road',NULL,'Hollister','95023-2803','CA','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(12,'Gubener Str. 46',NULL,'Berlin','10243','Berlin','DE',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(13,'25 Millbank',NULL,'London','SW1P 4QP','London','GB',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(14,'56-59 The Strand',NULL,'London','WC2N 5LR','London','GB',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(15,'2703 T P White Dr',NULL,'Jacksonville','72076','AR','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(16,'222 E Nepessing St',NULL,'Lapeer','48446','MI','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(17,'1409 Potomac Ave',NULL,'Pittsburgh','15216','PA','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(18,'675 Merrimon Ave',NULL,'Asheville','28804','NC','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(19,'21996 Highway 6',NULL,'Keystone','80435','CO','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(20,'2100 S Casino Dr',NULL,'Laughlin','89029','NV','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(21,'5415 W 11th St',NULL,'Greeley','80634','CO','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(22,'1101 S 119th St',NULL,'Omaha','68144','NE','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(23,'1621 N 48th St',NULL,'Lincoln','68504','NE','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(24,'32 Spring St',NULL,'New York','10012','NY','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(25,'260 W 44th St',NULL,'New York','10036','NY','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(26,'176 Perry St',NULL,'New York','10014','NY','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(27,'9081 Snowden River Pkwy',NULL,'Columbia','21046','MD','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(28,'12151 S Apopka Vineland Rd',NULL,'Orlando','32836','FL','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(29,'863 Washington Ave',NULL,'Miami Beach','33139','FL','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(30,'501 College Ave',NULL,'Clemson','29631','SC','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(31,'330 Mills Ave',NULL,'Greenville','29605','SC','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(32,'1028 E 6th St',NULL,'Tucson','85719','AZ','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(33,'4654 E Speedway Blvd',NULL,'Tucson','85712','AZ','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(34,'249 E 400 S',NULL,'Salt Lake City','84111','UT','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(35,'712 Paseo Del Pueblo Norte',NULL,'Taos','87571','NM','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(36,'1500 Barton Springs Rd',NULL,'Austin','78704','TX','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(37,'3500 Guadalupe St',NULL,'Austin','78705','TX','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(38,'1209 Red River St',NULL,'Austin','78701','TX','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(39,'5610 E Mockingbird Ln',NULL,'Dallas','75206','TX','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(40,'2104 Greenville Ave',NULL,'Dallas','75206','TX','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(41,'3501 McKinney Ave',NULL,'Dallas','75204','TX','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(42,'2111 Norfolk St',NULL,'Houston','77098','TX','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(43,'2920 Hillcroft St',NULL,'Houston','77057','TX','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(44,'7007 Friars Rd',NULL,'San Diego','92108','CA','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(45,'770 4th Ave',NULL,'San Diego','92101','CA','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(46,'11677 San Vicente Blvd',NULL,'Los Angeles','90049','CA','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(47,'735 S Figueroa St',NULL,'Los Angeles','90017','CA','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(48,'1001 Broxton Ave',NULL,'Los Angeles','90024','CA','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(49,'531 Cowper St',NULL,'Palo Alto','94301','CA','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(50,'5801 College Ave',NULL,'Oakland','94618','CA','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(51,'25613 Dollar St',NULL,'Hayward','94544','CA','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(52,'1401 E Madison St',NULL,'Seattle','98122','WA','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(53,'4918 Rainier Ave S',NULL,'Seattle','98118','WA','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(54,'226 NW Davis St',NULL,'Portland','97209','OR','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(55,'1935 SE Hawthorne Blvd',NULL,'Portland','97214','OR','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(56,'1812 Hayes St',NULL,'Nashville','37203','TN','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(57,'15 Arcade',NULL,'Nashville','37219','TN','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(58,'334 Massachusetts Ave',NULL,'Indianapolis','46204','IN','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(59,'1508 W 86th St',NULL,'Indianapolis','46260','IN','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(60,'56 E Superior St',NULL,'Chicago','60611','IL','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(61,'619 N Wabash Ave',NULL,'Chicago','60611','IL','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(62,'4479 Forest Park Ave',NULL,'St Louis','63108','MO','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(63,'1107 Olive St',NULL,'St Louis','63101','MO','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(64,'730 W Idaho St',NULL,'Boise','83702','ID','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(65,'4320 W State St',NULL,'Boise','83703','ID','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(66,'1835 NW Topeka Blvd',NULL,'Topeka','66608','KS','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(67,'5300 SW 17th St',NULL,'Topeka','66604','KS','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(68,'265 W 11th Ave',NULL,'Columbus','43201','OH','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(69,'1749 W 5th Ave',NULL,'Columbus','43212','OH','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(70,'14527 Madison Ave',NULL,'Cleveland','44107','OH','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(71,'538 Superior Ave E',NULL,'Cleveland','44114','OH','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(72,'4812 Rising Sun Ave',NULL,'Philadelphia','19120','PA','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(73,'4812 Rising Sun Ave',NULL,'Philadelphia','19120','PA','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(74,'Rumfordstrae 34',NULL,'Mnchen','80469','Mnchen','DE',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(75,'Sendlinger Str. 54',NULL,'Mnchen','80331','Mnchen','DE',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(76,'Eiendorfer Str. 161 A',NULL,'Hamburg','21073','Hamburg','DE',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(77,'Dorotheenstr. 140',NULL,'Hamburg','22301','Hamburg','DE',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(78,'Brunckstr. 8',NULL,'Speyer','67346','Speyer','DE',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(79,'Wittelsbacherallee 70',NULL,'Frankfurt','60385','Frankfurt','DE',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(80,'Liebigstr. 12',NULL,'Frankfurt','60323','Frankfurt','DE',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(81,'Kesselsdorfer Str. 62',NULL,'Dresden','01159','Dresden','DE',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(82,'7, r Canettes',NULL,'Paris','75006','Paris','FR',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(83,'2, Rue Lucien Sampaix',NULL,'Paris','75010','Paris','FR',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(84,'26, r Beaujolais',NULL,'Paris','75001','Paris','FR',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(85,'12, r Trachel',NULL,'Nice','06000','Nice','FR',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(86,'11, r Lpante',NULL,'Nice','06000','Nice','FR',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(87,'Rda. Universitat 37',NULL,'Barcelona','08007','Barcelona','ES',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(88,'Mallorca 12',NULL,'Barcelona','08014','Barcelona','ES',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(89,'Via Di S. Cosimato, 14',NULL,'Roma','00153','Roma','IT',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(90,'Via Flaminia, 119',NULL,'Roma','00196','Roma','IT',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(91,'Damstraat 24',NULL,'Amsterdam','1012 JM','Amsterdam','NL',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(92,'Singel 426',NULL,'Amsterdam','1017 AV','Amsterdam','NL',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(93,'9837 113 Street NW',NULL,'Edmonton','T5K 1N3','AB','CA',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(94,'10827 Jasper Avenue NW',NULL,'Edmonton','T5J 5G9','AB','CA',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(95,'13499 Cambie Street',NULL,'Vancouver','V5Z 2W7','BC','CA',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(96,'3838 Oak Street',NULL,'Vancouver','V6H 2M5','BC','CA',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(97,'2549 Yonge Street',NULL,'Toronto','M4P 2H9','ON','CA',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(98,'796 Mount Pleasant Road',NULL,'Toronto','M4P 2L2','ON','CA',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(99,'2617 W Broad St',NULL,'Richmond','23220','VA','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(100,'3910 Colley Ave',NULL,'Norfolk','23508','VA','US',NULL,NULL,'0','2020-10-25','0','2020-10-25',0),(101,'1717 Harrison St',NULL,'San Francisco','94103','CA','US',-122,38,'0','2020-10-25','0','2020-10-25',0),(102,'2675 Geary Blvd',NULL,'San Francisco','94118','CA','US',-122,38,'0','2020-10-25','0','2020-10-25',0),(103,'200 Colma Blvd',NULL,'Colma','94014','CA','US',-122,38,'0','2020-10-25','0','2020-10-25',0),(104,'3700 Mandela Pkwy',NULL,'Oakland','94608','CA','US',-122,38,'0','2020-10-25','0','2020-10-25',0),(105,'180 Donahue St',NULL,'Sausalito','94965','CA','US',-123,38,'0','2020-10-25','0','2020-10-25',0),(106,'700 Du Bois St',NULL,'San Rafael','94901','CA','US',-123,38,'0','2020-10-25','0','2020-10-25',0),(107,'457 120th Ave NE',NULL,'Bellevue','98005','Washington','US',-122,48,'0','2020-10-25','0','2020-10-25',0),(108,'63455 North Highway 97',NULL,'Bend','97701','Oregon','US',-121,44,'0','2020-10-25','0','2020-10-25',0),(109,'8363 W Franklin Rd',NULL,'Boise','83709','Idaho','US',-116,44,'0','2020-10-25','0','2020-10-25',0),(110,'4080 Stevens Creek Blvd',NULL,'San Jose','95129','California','US',-122,37,'0','2020-10-25','0','2020-10-25',0),(111,'2955 Mountain City Hwy',NULL,'Elko','89801','Nevada','US',-116,41,'0','2020-10-25','0','2020-10-25',0),(112,'100 E 400 St S',NULL,'Richfield','84701','Utah','US',-112,39,'0','2020-10-25','0','2020-10-25',0),(113,'12645 N 48th St',NULL,'Phoenix','85032','Arizona','US',-112,34,'0','2020-10-25','0','2020-10-25',0),(114,'1801 E Custer Avenue',NULL,'Helena','59602','Montana','US',-112,47,'0','2020-10-25','0','2020-10-25',0),(115,'1105 E Boxelder Road',NULL,'Gillette','82718','Wyoming','US',-105,44,'0','2020-10-25','0','2020-10-25',0),(116,'7120 N Academy Blvd',NULL,'Colorado Springs','80920','Colorado','US',-105,39,'0','2020-10-25','0','2020-10-25',0),(117,'2350 N Main',NULL,'Roswell','88202','New Mexico','US',-105,33,'0','2020-10-25','0','2020-10-25',0);
/*!40000 ALTER TABLE `ADDRESSES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ADDRESS_SEQ`
--

DROP TABLE IF EXISTS `ADDRESS_SEQ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ADDRESS_SEQ` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) unsigned NOT NULL,
  `cycle_option` tinyint(1) unsigned NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB SEQUENCE=1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ADDRESS_SEQ`
--

LOCK TABLES `ADDRESS_SEQ` WRITE;
/*!40000 ALTER TABLE `ADDRESS_SEQ` DISABLE KEYS */;
INSERT INTO `ADDRESS_SEQ` VALUES (300,1,9223372036854775806,300,1,1000,0,0);
/*!40000 ALTER TABLE `ADDRESS_SEQ` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ADDRESS_USAGES`
--

DROP TABLE IF EXISTS `ADDRESS_USAGES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ADDRESS_USAGES` (
  `ADDRESS_USAGES_ID` int(11) NOT NULL,
  `ASSOCIATED_OWNER_ID` int(15) NOT NULL,
  `OWNER_TYPE_CODE` varchar(30) NOT NULL,
  `ADDRESS_ID` int(15) NOT NULL,
  `USAGE_TYPE_CODE` varchar(30) NOT NULL,
  `EXPIRED_FLAG` varchar(1) NOT NULL DEFAULT 'N',
  `CREATED_BY` varchar(60) NOT NULL,
  `CREATION_DATE` date NOT NULL,
  `LAST_UPDATED_BY` varchar(60) NOT NULL,
  `LAST_UPDATE_DATE` date NOT NULL,
  `OBJECT_VERSION_ID` int(15) NOT NULL,
  PRIMARY KEY (`ADDRESS_USAGES_ID`),
  KEY `ADDRESS_USAGES_ADDRESSES_FK` (`ADDRESS_ID`),
  KEY `ADDRESS_USAGES_PERSONS_FK` (`ASSOCIATED_OWNER_ID`),
  CONSTRAINT `ADDRESS_USAGES_ADDRESSES_FK` FOREIGN KEY (`ADDRESS_ID`) REFERENCES `ADDRESSES` (`ADDRESS_ID`),
  CONSTRAINT `ADDRESS_USAGES_PERSONS_FK` FOREIGN KEY (`ASSOCIATED_OWNER_ID`) REFERENCES `PERSONS` (`PERSON_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Intersection entity that maps addresses to customers, suppliers etc. Any entity that can have multiple addresses will map them through this table. Certain address references such as a Customer''s primary address are also de-normalised into the relevant table. Where a consumer has one and only one address it will have a direct reference to the address table and will not have an entry here (for example Warehouse)';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ADDRESS_USAGES`
--

LOCK TABLES `ADDRESS_USAGES` WRITE;
/*!40000 ALTER TABLE `ADDRESS_USAGES` DISABLE KEYS */;
INSERT INTO `ADDRESS_USAGES` VALUES (1,106,'CUST',1,'SH','N','0','2020-10-25','0','2020-10-25',0),(2,107,'CUST',2,'SH','N','0','2020-10-25','0','2020-10-25',0),(3,108,'CUST',3,'SH','N','0','2020-10-25','0','2020-10-25',0),(4,109,'CUST',4,'SH','N','0','2020-10-25','0','2020-10-25',0),(5,110,'CUST',5,'SH','N','0','2020-10-25','0','2020-10-25',0),(6,110,'CUST',6,'SH','N','0','2020-10-25','0','2020-10-25',0),(7,111,'CUST',7,'SH','N','0','2020-10-25','0','2020-10-25',0),(8,111,'CUST',8,'SH','N','0','2020-10-25','0','2020-10-25',0),(9,110,'CUST',9,'SH','N','0','2020-10-25','0','2020-10-25',0),(10,110,'CUST',9,'IN','N','0','2020-10-25','0','2020-10-25',0),(11,111,'CUST',10,'IN','N','0','2020-10-25','0','2020-10-25',0),(12,111,'CUST',10,'SH','N','0','2020-10-25','0','2020-10-25',0),(13,112,'CUST',11,'SH','N','0','2020-10-25','0','2020-10-25',0),(14,112,'CUST',11,'IN','N','0','2020-10-25','0','2020-10-25',0),(15,113,'CUST',12,'IN','N','0','2020-10-25','0','2020-10-25',0),(16,113,'CUST',13,'SH','N','0','2020-10-25','0','2020-10-25',0),(17,114,'CUST',14,'SH','N','0','2020-10-25','0','2020-10-25',0),(18,114,'CUST',15,'IN','N','0','2020-10-25','0','2020-10-25',0),(19,115,'CUST',16,'IN','N','0','2020-10-25','0','2020-10-25',0),(20,115,'CUST',16,'SH','N','0','2020-10-25','0','2020-10-25',0),(21,116,'CUST',17,'SH','N','0','2020-10-25','0','2020-10-25',0),(22,117,'CUST',18,'SH','N','0','2020-10-25','0','2020-10-25',0),(23,118,'CUST',19,'SH','N','0','2020-10-25','0','2020-10-25',0),(24,119,'CUST',20,'SH','N','0','2020-10-25','0','2020-10-25',0),(25,120,'CUST',21,'SH','N','0','2020-10-25','0','2020-10-25',0),(26,121,'CUST',22,'SH','N','0','2020-10-25','0','2020-10-25',0),(27,122,'CUST',23,'SH','N','0','2020-10-25','0','2020-10-25',0),(28,123,'CUST',24,'SH','N','0','2020-10-25','0','2020-10-25',0),(29,123,'CUST',25,'SH','N','0','2020-10-25','0','2020-10-25',0),(30,124,'CUST',26,'SH','N','0','2020-10-25','0','2020-10-25',0),(31,125,'CUST',27,'SH','N','0','2020-10-25','0','2020-10-25',0),(32,125,'CUST',27,'IN','N','0','2020-10-25','0','2020-10-25',0),(33,126,'CUST',28,'IN','N','0','2020-10-25','0','2020-10-25',0),(34,126,'CUST',28,'SH','N','0','2020-10-25','0','2020-10-25',0),(37,108,'CUST',3,'IN','N','0','2020-10-25','0','2020-10-25',0),(38,109,'CUST',4,'IN','N','0','2020-10-25','0','2020-10-25',0),(39,110,'CUST',5,'IN','N','0','2020-10-25','0','2020-10-25',0),(40,108,'CUST',20,'SH','N','0','2020-10-25','0','2020-10-25',0),(41,108,'CUST',21,'SH','N','0','2020-10-25','0','2020-10-25',0),(42,109,'CUST',22,'SH','N','0','2020-10-25','0','2020-10-25',0),(43,109,'CUST',23,'SH','N','0','2020-10-25','0','2020-10-25',0),(44,110,'CUST',24,'SH','N','0','2020-10-25','0','2020-10-25',0),(45,110,'CUST',25,'SH','N','0','2020-10-25','0','2020-10-25',0),(46,118,'CUST',26,'SH','N','0','2020-10-25','0','2020-10-25',0),(47,118,'CUST',27,'SH','N','0','2020-10-25','0','2020-10-25',0),(48,118,'CUST',28,'SH','N','0','2020-10-25','0','2020-10-25',0),(49,118,'CUST',1,'IN','N','0','2020-10-25','0','2020-10-25',0),(50,114,'CUST',2,'IN','N','0','2020-10-25','0','2020-10-25',0),(51,114,'CUST',2,'SH','N','0','2020-10-25','0','2020-10-25',0),(52,114,'CUST',29,'SH','N','0','2020-10-25','0','2020-10-25',0),(53,114,'CUST',30,'SH','N','0','2020-10-25','0','2020-10-25',0),(54,114,'CUST',31,'SH','N','0','2020-10-25','0','2020-10-25',0),(55,108,'CUST',97,'SH','N','0','2020-10-25','0','2020-10-25',0),(56,109,'CUST',54,'SH','N','0','2020-10-25','0','2020-10-25',0),(57,110,'CUST',37,'SH','N','0','2020-10-25','0','2020-10-25',0),(58,111,'CUST',42,'SH','N','0','2020-10-25','0','2020-10-25',0),(59,112,'CUST',55,'SH','N','0','2020-10-25','0','2020-10-25',0),(60,113,'CUST',14,'SH','N','0','2020-10-25','0','2020-10-25',0),(61,114,'CUST',22,'SH','N','0','2020-10-25','0','2020-10-25',0),(62,115,'CUST',63,'SH','N','0','2020-10-25','0','2020-10-25',0),(63,116,'CUST',74,'SH','N','0','2020-10-25','0','2020-10-25',0),(64,117,'CUST',15,'SH','N','0','2020-10-25','0','2020-10-25',0),(65,118,'CUST',24,'SH','N','0','2020-10-25','0','2020-10-25',0),(66,119,'CUST',28,'SH','N','0','2020-10-25','0','2020-10-25',0),(67,120,'CUST',69,'SH','N','0','2020-10-25','0','2020-10-25',0),(68,121,'CUST',73,'SH','N','0','2020-10-25','0','2020-10-25',0),(69,122,'CUST',45,'SH','N','0','2020-10-25','0','2020-10-25',0),(70,123,'CUST',47,'SH','N','0','2020-10-25','0','2020-10-25',0),(71,124,'CUST',32,'SH','N','0','2020-10-25','0','2020-10-25',0),(72,125,'CUST',83,'SH','N','0','2020-10-25','0','2020-10-25',0),(73,126,'CUST',91,'SH','N','0','2020-10-25','0','2020-10-25',0),(74,127,'CUST',75,'SH','N','0','2020-10-25','0','2020-10-25',0),(75,128,'CUST',10,'SH','N','0','2020-10-25','0','2020-10-25',0),(76,129,'CUST',58,'SH','N','0','2020-10-25','0','2020-10-25',0),(77,100,'STAFF',33,'IN','N','0','2020-10-25','0','2020-10-25',0),(78,101,'STAFF',34,'IN','N','0','2020-10-25','0','2020-10-25',0),(79,102,'STAFF',35,'SH','N','0','2020-10-25','0','2020-10-25',0),(80,103,'STAFF',36,'IN','N','0','2020-10-25','0','2020-10-25',0),(81,104,'STAFF',38,'SH','N','0','2020-10-25','0','2020-10-25',0),(82,105,'STAFF',39,'SH','N','0','2020-10-25','0','2020-10-25',0),(83,106,'STAFF',40,'IN','N','0','2020-10-25','0','2020-10-25',0),(84,107,'STAFF',41,'SH','N','0','2020-10-25','0','2020-10-25',0),(85,200,'SUPP',43,'IN','N','0','2020-10-25','0','2020-10-25',0),(86,201,'SUPP',44,'IN','N','0','2020-10-25','0','2020-10-25',0),(87,202,'SUPP',46,'SH','N','0','2020-10-25','0','2020-10-25',0),(88,203,'SUPP',48,'IN','N','0','2020-10-25','0','2020-10-25',0),(89,204,'SUPP',49,'SH','N','0','2020-10-25','0','2020-10-25',0),(90,205,'SUPP',50,'SH','N','0','2020-10-25','0','2020-10-25',0),(91,206,'SUPP',51,'SH','N','0','2020-10-25','0','2020-10-25',0),(92,207,'SUPP',52,'SH','N','0','2020-10-25','0','2020-10-25',0),(93,208,'SUPP',53,'SH','N','0','2020-10-25','0','2020-10-25',0),(94,209,'SUPP',56,'SH','N','0','2020-10-25','0','2020-10-25',0),(95,210,'SUPP',57,'SH','N','0','2020-10-25','0','2020-10-25',0),(96,211,'SUPP',59,'SH','N','0','2020-10-25','0','2020-10-25',0),(97,212,'SUPP',60,'SH','N','0','2020-10-25','0','2020-10-25',0),(98,213,'SUPP',61,'SH','N','0','2020-10-25','0','2020-10-25',0),(99,214,'SUPP',62,'SH','N','0','2020-10-25','0','2020-10-25',0),(100,215,'SUPP',64,'SH','N','0','2020-10-25','0','2020-10-25',0),(101,216,'SUPP',65,'SH','N','0','2020-10-25','0','2020-10-25',0),(102,217,'SUPP',66,'SH','N','0','2020-10-25','0','2020-10-25',0),(103,218,'SUPP',67,'SH','N','0','2020-10-25','0','2020-10-25',0),(104,219,'SUPP',68,'SH','N','0','2020-10-25','0','2020-10-25',0),(105,220,'SUPP',70,'SH','N','0','2020-10-25','0','2020-10-25',0);
/*!40000 ALTER TABLE `ADDRESS_USAGES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ADDRESS_USAGES_SEQ`
--

DROP TABLE IF EXISTS `ADDRESS_USAGES_SEQ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ADDRESS_USAGES_SEQ` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) unsigned NOT NULL,
  `cycle_option` tinyint(1) unsigned NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB SEQUENCE=1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ADDRESS_USAGES_SEQ`
--

LOCK TABLES `ADDRESS_USAGES_SEQ` WRITE;
/*!40000 ALTER TABLE `ADDRESS_USAGES_SEQ` DISABLE KEYS */;
INSERT INTO `ADDRESS_USAGES_SEQ` VALUES (300,1,9223372036854775806,300,1,1000,0,0);
/*!40000 ALTER TABLE `ADDRESS_USAGES_SEQ` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `AVAILABLE_LANGUAGES`
--

DROP TABLE IF EXISTS `AVAILABLE_LANGUAGES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `AVAILABLE_LANGUAGES` (
  `LANGUAGE` varchar(30) NOT NULL,
  `DEFAULT_FLAG` varchar(1) NOT NULL DEFAULT 'N',
  `CREATED_BY` varchar(60) NOT NULL,
  `CREATION_DATE` date NOT NULL,
  `LAST_UPDATED_BY` varchar(60) NOT NULL,
  `LAST_UPDATE_DATE` date NOT NULL,
  `OBJECT_VERSION_ID` int(15) NOT NULL,
  PRIMARY KEY (`LANGUAGE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='AVAILABLE_LANGUAGES lists all of the translations that are available in the system. Any translation table will be fully populated with one instance per available language. The entry itself may not yet be translated, in which case, the SOURCE_LANGUAGE column in the translation table will hold the language that the entry is currently in. When a value has been translated SOURCE_LANGUAGE and LANGUAGE will be the same. Only one row in this table will have the DEFAULT_FLAG set to Y ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AVAILABLE_LANGUAGES`
--

LOCK TABLES `AVAILABLE_LANGUAGES` WRITE;
/*!40000 ALTER TABLE `AVAILABLE_LANGUAGES` DISABLE KEYS */;
INSERT INTO `AVAILABLE_LANGUAGES` VALUES ('DE','N','0','2020-10-25','0','2020-10-25',1),('EL','N','0','2020-10-25','0','2020-10-25',1),('EN','Y','0','2020-10-25','0','2020-10-25',1),('FR','N','0','2020-10-25','0','2020-10-25',1),('JA','N','0','2020-10-25','0','2020-10-25',1);
/*!40000 ALTER TABLE `AVAILABLE_LANGUAGES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CATEGORY_SEQ`
--

DROP TABLE IF EXISTS `CATEGORY_SEQ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CATEGORY_SEQ` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) unsigned NOT NULL,
  `cycle_option` tinyint(1) unsigned NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB SEQUENCE=1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CATEGORY_SEQ`
--

LOCK TABLES `CATEGORY_SEQ` WRITE;
/*!40000 ALTER TABLE `CATEGORY_SEQ` DISABLE KEYS */;
INSERT INTO `CATEGORY_SEQ` VALUES (15,1,9223372036854775806,15,1,1000,0,0);
/*!40000 ALTER TABLE `CATEGORY_SEQ` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CATEGORY_TRANSLATIONS`
--

DROP TABLE IF EXISTS `CATEGORY_TRANSLATIONS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CATEGORY_TRANSLATIONS` (
  `CATEGORY_ID` int(15) NOT NULL,
  `CATEGORY_NAME` varchar(50) NOT NULL,
  `CATEGORY_DESCRIPTION` varchar(1000) DEFAULT NULL,
  `LANGUAGE` varchar(30) NOT NULL,
  `SOURCE_LANG` varchar(30) DEFAULT NULL,
  `CREATED_BY` varchar(60) NOT NULL,
  `CREATION_DATE` date NOT NULL,
  `LAST_UPDATED_BY` varchar(60) NOT NULL,
  `LAST_UPDATE_DATE` date NOT NULL,
  `OBJECT_VERSION_ID` int(15) NOT NULL,
  PRIMARY KEY (`CATEGORY_ID`,`LANGUAGE`),
  CONSTRAINT `CATEGORY_TRANSLATIONS_FK` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `PRODUCT_CATEGORIES_BASE` (`CATEGORY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Holds one translation for the  category text for each lanuage supported by the system.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CATEGORY_TRANSLATIONS`
--

LOCK TABLES `CATEGORY_TRANSLATIONS` WRITE;
/*!40000 ALTER TABLE `CATEGORY_TRANSLATIONS` DISABLE KEYS */;
INSERT INTO `CATEGORY_TRANSLATIONS` VALUES (1,'Media','Books, Music, and Movies','DE','EN','0','2020-10-25','0','2020-10-25',0),(1,'Media','Books, Music, and Movies','EL','EN','0','2020-10-25','0','2020-10-25',0),(1,'Media','Books, Music, and Movies','EN','EN','0','2020-10-25','0','2020-10-25',1),(1,'Media','Books, Music, and Movies','FR','EN','0','2020-10-25','0','2020-10-25',0),(1,'Media','Books, Music, and Movies','JA','EN','0','2020-10-25','0','2020-10-25',0),(2,'Office','Office Supplies','DE','EN','0','2020-10-25','0','2020-10-25',0),(2,'Office','Office Supplies','EL','EN','0','2020-10-25','0','2020-10-25',0),(2,'Office','Office Supplies','EN','EN','0','2020-10-25','0','2020-10-25',1),(2,'Office','Office Supplies','FR','EN','0','2020-10-25','0','2020-10-25',0),(2,'Office','Office Supplies','JA','EN','0','2020-10-25','0','2020-10-25',0),(3,'Electronics','Consumer Electronics','DE','EN','0','2020-10-25','0','2020-10-25',0),(3,'Electronics','Consumer Electronics','EL','EN','0','2020-10-25','0','2020-10-25',0),(3,'Electronics','Consumer Electronics','EN','EN','0','2020-10-25','0','2020-10-25',1),(3,'Electronics','Consumer Electronics','FR','EN','0','2020-10-25','0','2020-10-25',0),(3,'Electronics','Consumer Electronics','JA','EN','0','2020-10-25','0','2020-10-25',0),(4,'Audio and Video','Audio and Video','DE','EN','0','2020-10-25','0','2020-10-25',0),(4,'Audio and Video','Audio and Video','EL','EN','0','2020-10-25','0','2020-10-25',0),(4,'Audio and Video','Audio and Video','EN','EN','0','2020-10-25','0','2020-10-25',1),(4,'Audio and Video','Audio and Video','FR','EN','0','2020-10-25','0','2020-10-25',0),(4,'Audio and Video','Audio and Video','JA','EN','0','2020-10-25','0','2020-10-25',0),(5,'Camera and Photo','Camera and Photo','DE','EN','0','2020-10-25','0','2020-10-25',0),(5,'Camera and Photo','Camera and Photo','EL','EN','0','2020-10-25','0','2020-10-25',0),(5,'Camera and Photo','Camera and Photo','EN','EN','0','2020-10-25','0','2020-10-25',1),(5,'Camera and Photo','Camera and Photo','FR','EN','0','2020-10-25','0','2020-10-25',0),(5,'Camera and Photo','Camera and Photo','JA','EN','0','2020-10-25','0','2020-10-25',0),(6,'Cell Phones','Cell Phones and Service','DE','EN','0','2020-10-25','0','2020-10-25',0),(6,'Cell Phones','Cell Phones and Service','EL','EN','0','2020-10-25','0','2020-10-25',0),(6,'Cell Phones','Cell Phones and Service','EN','EN','0','2020-10-25','0','2020-10-25',1),(6,'Cell Phones','Cell Phones and Service','FR','EN','0','2020-10-25','0','2020-10-25',0),(6,'Cell Phones','Cell Phones and Service','JA','EN','0','2020-10-25','0','2020-10-25',0),(7,'Games','Computer and Video Games','DE','EN','0','2020-10-25','0','2020-10-25',0),(7,'Games','Computer and Video Games','EL','EN','0','2020-10-25','0','2020-10-25',0),(7,'Games','Computer and Video Games','EN','EN','0','2020-10-25','0','2020-10-25',1),(7,'Games','Computer and Video Games','FR','EN','0','2020-10-25','0','2020-10-25',0),(7,'Games','Computer and Video Games','JA','EN','0','2020-10-25','0','2020-10-25',0),(8,'Books','Books','DE','EN','0','2020-10-25','0','2020-10-25',0),(8,'Books','Books','EL','EN','0','2020-10-25','0','2020-10-25',0),(8,'Books','Books','EN','EN','0','2020-10-25','0','2020-10-25',1),(8,'Books','Books','FR','EN','0','2020-10-25','0','2020-10-25',0),(8,'Books','Books','JA','EN','0','2020-10-25','0','2020-10-25',0),(9,'DVDs','DVDs','DE','EN','0','2020-10-25','0','2020-10-25',0),(9,'DVDs','DVDs','EL','EN','0','2020-10-25','0','2020-10-25',0),(9,'DVDs','DVDs','EN','EN','0','2020-10-25','0','2020-10-25',1),(9,'DVDs','DVDs','FR','EN','0','2020-10-25','0','2020-10-25',0),(9,'DVDs','DVDs','JA','EN','0','2020-10-25','0','2020-10-25',0),(10,'Periodicals','Magazines and Newspapers','DE','EN','0','2020-10-25','0','2020-10-25',0),(10,'Periodicals','Magazines and Newspapers','EL','EN','0','2020-10-25','0','2020-10-25',0),(10,'Periodicals','Magazines and Newspapers','EN','EN','0','2020-10-25','0','2020-10-25',1),(10,'Periodicals','Magazines and Newspapers','FR','EN','0','2020-10-25','0','2020-10-25',0),(10,'Periodicals','Magazines and Newspapers','JA','EN','0','2020-10-25','0','2020-10-25',0),(11,'Music','CDs','DE','EN','0','2020-10-25','0','2020-10-25',0),(11,'Music','CDs','EL','EN','0','2020-10-25','0','2020-10-25',0),(11,'Music','CDs','EN','EN','0','2020-10-25','0','2020-10-25',1),(11,'Music','CDs','FR','EN','0','2020-10-25','0','2020-10-25',0),(11,'Music','CDs','JA','EN','0','2020-10-25','0','2020-10-25',0),(12,'Hardware','Computers','DE','EN','0','2020-10-25','0','2020-10-25',0),(12,'Hardware','Computers','EL','EN','0','2020-10-25','0','2020-10-25',0),(12,'Hardware','Computers','EN','EN','0','2020-10-25','0','2020-10-25',1),(12,'Hardware','Computers','FR','EN','0','2020-10-25','0','2020-10-25',0),(12,'Hardware','Computers','JA','EN','0','2020-10-25','0','2020-10-25',0),(13,'Supplies','Office Supplies','DE','EN','0','2020-10-25','0','2020-10-25',0),(13,'Supplies','Office Supplies','EL','EN','0','2020-10-25','0','2020-10-25',0),(13,'Supplies','Office Supplies','EN','EN','0','2020-10-25','0','2020-10-25',1),(13,'Supplies','Office Supplies','FR','EN','0','2020-10-25','0','2020-10-25',0),(13,'Supplies','Office Supplies','JA','EN','0','2020-10-25','0','2020-10-25',0),(14,'Software','Software','DE','EN','0','2020-10-25','0','2020-10-25',0),(14,'Software','Software','EL','EN','0','2020-10-25','0','2020-10-25',0),(14,'Software','Software','EN','EN','0','2020-10-25','0','2020-10-25',1),(14,'Software','Software','FR','EN','0','2020-10-25','0','2020-10-25',0),(14,'Software','Software','JA','EN','0','2020-10-25','0','2020-10-25',0);
/*!40000 ALTER TABLE `CATEGORY_TRANSLATIONS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `COUNTRY_CODES`
--

DROP TABLE IF EXISTS `COUNTRY_CODES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `COUNTRY_CODES` (
  `ISO_COUNTRY_CODE` varchar(2) NOT NULL,
  `COUNTRY_NAME` varchar(100) DEFAULT NULL,
  `LANGUAGE` varchar(30) NOT NULL,
  `SOURCE_LANG` varchar(30) DEFAULT NULL,
  `CREATED_BY` varchar(60) NOT NULL,
  `CREATION_DATE` date NOT NULL,
  `LAST_UPDATED_BY` varchar(60) NOT NULL,
  `LAST_UPDATE_DATE` date NOT NULL,
  `OBJECT_VERSION_ID` int(15) NOT NULL,
  PRIMARY KEY (`ISO_COUNTRY_CODE`,`LANGUAGE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='List of ISO Country codes and the name of the relevant country. This contains the translations for each country name as well. So each country code will be repeated for each supported language';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `COUNTRY_CODES`
--

LOCK TABLES `COUNTRY_CODES` WRITE;
/*!40000 ALTER TABLE `COUNTRY_CODES` DISABLE KEYS */;
INSERT INTO `COUNTRY_CODES` VALUES ('AD','ANDORRA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('AE','UNITED ARAB EMIRATES','&&1','EN','0','2020-10-25','0','2020-10-25',1),('AG','ANTIGUA AND BARBUDA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('AI','ANGUILLA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('AL','ALBANIA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('AM','ARMENIA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('AN','NETHERLANDS ANTILLES','&&1','EN','0','2020-10-25','0','2020-10-25',1),('AO','ANGOLA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('AQ','ANTARCTICA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('AR','ARGENTINA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('AS','AMERICAN SAMOA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('AT','AUSTRIA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('AU','AUSTRALIA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('AW','ARUBA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('AX','LAND ISLANDS','&&1','EN','0','2020-10-25','0','2020-10-25',1),('AZ','AZERBAIJAN','&&1','EN','0','2020-10-25','0','2020-10-25',1),('BA','BOSNIA AND HERZEGOVINA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('BB','BARBADOS','&&1','EN','0','2020-10-25','0','2020-10-25',1),('BD','BANGLADESH','&&1','EN','0','2020-10-25','0','2020-10-25',1),('BE','BELGIUM','&&1','EN','0','2020-10-25','0','2020-10-25',1),('BF','BURKINA FASO','&&1','EN','0','2020-10-25','0','2020-10-25',1),('BG','BULGARIA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('BH','BAHRAIN','&&1','EN','0','2020-10-25','0','2020-10-25',1),('BI','BURUNDI','&&1','EN','0','2020-10-25','0','2020-10-25',1),('BJ','BENIN','&&1','EN','0','2020-10-25','0','2020-10-25',1),('BM','BERMUDA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('BN','BRUNEI DARUSSALAM','&&1','EN','0','2020-10-25','0','2020-10-25',1),('BO','BOLIVIA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('BR','BRAZIL','&&1','EN','0','2020-10-25','0','2020-10-25',1),('BS','BAHAMAS','&&1','EN','0','2020-10-25','0','2020-10-25',1),('BT','BHUTAN','&&1','EN','0','2020-10-25','0','2020-10-25',1),('BV','BOUVET ISLAND','&&1','EN','0','2020-10-25','0','2020-10-25',1),('BW','BOTSWANA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('BY','BELARUS','&&1','EN','0','2020-10-25','0','2020-10-25',1),('BZ','BELIZE','&&1','EN','0','2020-10-25','0','2020-10-25',1),('CA','CANADA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('CC','COCOS (KEELING) ISLANDS','&&1','EN','0','2020-10-25','0','2020-10-25',1),('CD','CONGO, THE DEMOCRATIC REPUBLIC OF THE','&&1','EN','0','2020-10-25','0','2020-10-25',1),('CF','CENTRAL AFRICAN REPUBLIC','&&1','EN','0','2020-10-25','0','2020-10-25',1),('CG','CONGO','&&1','EN','0','2020-10-25','0','2020-10-25',1),('CH','SWITZERLAND','&&1','EN','0','2020-10-25','0','2020-10-25',1),('CI','COTE D\'IVOIRE','&&1','EN','0','2020-10-25','0','2020-10-25',1),('CK','COOK ISLANDS','&&1','EN','0','2020-10-25','0','2020-10-25',1),('CL','CHILE','&&1','EN','0','2020-10-25','0','2020-10-25',1),('CM','CAMEROON','&&1','EN','0','2020-10-25','0','2020-10-25',1),('CN','CHINA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('CO','COLOMBIA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('CR','COSTA RICA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('CU','CUBA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('CV','CAPE VERDE','&&1','EN','0','2020-10-25','0','2020-10-25',1),('CX','CHRISTMAS ISLAND','&&1','EN','0','2020-10-25','0','2020-10-25',1),('CY','CYPRUS','&&1','EN','0','2020-10-25','0','2020-10-25',1),('CZ','CZECH REPUBLIC','&&1','EN','0','2020-10-25','0','2020-10-25',1),('DE','GERMANY','&&1','EN','0','2020-10-25','0','2020-10-25',1),('DJ','DJIBOUTI','&&1','EN','0','2020-10-25','0','2020-10-25',1),('DK','DENMARK','&&1','EN','0','2020-10-25','0','2020-10-25',1),('DM','DOMINICA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('DO','DOMINICAN REPUBLIC','&&1','EN','0','2020-10-25','0','2020-10-25',1),('DZ','ALGERIA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('EC','ECUADOR','&&1','EN','0','2020-10-25','0','2020-10-25',1),('EE','ESTONIA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('EG','EGYPT','&&1','EN','0','2020-10-25','0','2020-10-25',1),('EH','WESTERN SAHARA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('ER','ERITREA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('ES','SPAIN','&&1','EN','0','2020-10-25','0','2020-10-25',1),('ET','ETHIOPIA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('FI','FINLAND','&&1','EN','0','2020-10-25','0','2020-10-25',1),('FJ','FIJI','&&1','EN','0','2020-10-25','0','2020-10-25',1),('FK','FALKLAND ISLANDS (MALVINAS)','&&1','EN','0','2020-10-25','0','2020-10-25',1),('FM','MICRONESIA, FEDERATED STATES OF','&&1','EN','0','2020-10-25','0','2020-10-25',1),('FO','FAROE ISLANDS','&&1','EN','0','2020-10-25','0','2020-10-25',1),('FR','FRANCE','&&1','EN','0','2020-10-25','0','2020-10-25',1),('GA','GABON','&&1','EN','0','2020-10-25','0','2020-10-25',1),('GB','UNITED KINGDOM','&&1','EN','0','2020-10-25','0','2020-10-25',1),('GD','GRENADA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('GE','GEORGIA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('GF','FRENCH GUIANA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('GG','GUERNSEY','&&1','EN','0','2020-10-25','0','2020-10-25',1),('GH','GHANA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('GI','GIBRALTAR','&&1','EN','0','2020-10-25','0','2020-10-25',1),('GL','GREENLAND','&&1','EN','0','2020-10-25','0','2020-10-25',1),('GM','GAMBIA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('GN','GUINEA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('GP','GUADELOUPE','&&1','EN','0','2020-10-25','0','2020-10-25',1),('GQ','EQUATORIAL GUINEA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('GR','GREECE','&&1','EN','0','2020-10-25','0','2020-10-25',1),('GS','SOUTH GEORGIA AND THE SOUTH SANDWICH ISLANDS','&&1','EN','0','2020-10-25','0','2020-10-25',1),('GT','GUATEMALA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('GU','GUAM','&&1','EN','0','2020-10-25','0','2020-10-25',1),('GW','GUINEA-BISSAU','&&1','EN','0','2020-10-25','0','2020-10-25',1),('GY','GUYANA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('HK','HONG KONG','&&1','EN','0','2020-10-25','0','2020-10-25',1),('HM','HEARD ISLAND AND MCDONALD ISLANDS','&&1','EN','0','2020-10-25','0','2020-10-25',1),('HN','HONDURAS','&&1','EN','0','2020-10-25','0','2020-10-25',1),('HR','CROATIA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('HT','HAITI','&&1','EN','0','2020-10-25','0','2020-10-25',1),('HU','HUNGARY','&&1','EN','0','2020-10-25','0','2020-10-25',1),('ID','INDONESIA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('IE','IRELAND','&&1','EN','0','2020-10-25','0','2020-10-25',1),('IL','ISRAEL','&&1','EN','0','2020-10-25','0','2020-10-25',1),('IM','ISLE OF MAN','&&1','EN','0','2020-10-25','0','2020-10-25',1),('IN','INDIA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('IO','BRITISH INDIAN OCEAN TERRITORY','&&1','EN','0','2020-10-25','0','2020-10-25',1),('IQ','IRAQ','&&1','EN','0','2020-10-25','0','2020-10-25',1),('IR','IRAN, ISLAMIC REPUBLIC OF','&&1','EN','0','2020-10-25','0','2020-10-25',1),('IS','ICELAND','&&1','EN','0','2020-10-25','0','2020-10-25',1),('IT','ITALY','&&1','EN','0','2020-10-25','0','2020-10-25',1),('JE','JERSEY','&&1','EN','0','2020-10-25','0','2020-10-25',1),('JM','JAMAICA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('JO','JORDAN','&&1','EN','0','2020-10-25','0','2020-10-25',1),('JP','JAPAN','&&1','EN','0','2020-10-25','0','2020-10-25',1),('KE','KENYA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('KG','KYRGYZSTAN','&&1','EN','0','2020-10-25','0','2020-10-25',1),('KH','CAMBODIA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('KI','KIRIBATI','&&1','EN','0','2020-10-25','0','2020-10-25',1),('KM','COMOROS','&&1','EN','0','2020-10-25','0','2020-10-25',1),('KN','SAINT KITTS AND NEVIS','&&1','EN','0','2020-10-25','0','2020-10-25',1),('KP','KOREA, DEMOCRATIC PEOPLE\'S REPUBLIC OF','&&1','EN','0','2020-10-25','0','2020-10-25',1),('KR','KOREA, REPUBLIC OF','&&1','EN','0','2020-10-25','0','2020-10-25',1),('KW','KUWAIT','&&1','EN','0','2020-10-25','0','2020-10-25',1),('KY','CAYMAN ISLANDS','&&1','EN','0','2020-10-25','0','2020-10-25',1),('KZ','KAZAKHSTAN','&&1','EN','0','2020-10-25','0','2020-10-25',1),('LA','LAO PEOPLE\'S DEMOCRATIC REPUBLIC','&&1','EN','0','2020-10-25','0','2020-10-25',1),('LB','LEBANON','&&1','EN','0','2020-10-25','0','2020-10-25',1),('LC','SAINT LUCIA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('LI','LIECHTENSTEIN','&&1','EN','0','2020-10-25','0','2020-10-25',1),('LK','SRI LANKA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('LR','LIBERIA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('LS','LESOTHO','&&1','EN','0','2020-10-25','0','2020-10-25',1),('LT','LITHUANIA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('LU','LUXEMBOURG','&&1','EN','0','2020-10-25','0','2020-10-25',1),('LV','LATVIA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('LY','LIBYAN ARAB JAMAHIRIYA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('MA','MOROCCO','&&1','EN','0','2020-10-25','0','2020-10-25',1),('MC','MONACO','&&1','EN','0','2020-10-25','0','2020-10-25',1),('MD','MOLDOVA, REPUBLIC OF','&&1','EN','0','2020-10-25','0','2020-10-25',1),('ME','MONTENEGRO','&&1','EN','0','2020-10-25','0','2020-10-25',1),('MG','MADAGASCAR','&&1','EN','0','2020-10-25','0','2020-10-25',1),('MH','MARSHALL ISLANDS','&&1','EN','0','2020-10-25','0','2020-10-25',1),('MK','MACEDONIA, THE FORMER YUGOSLAV REPUBLIC OF','&&1','EN','0','2020-10-25','0','2020-10-25',1),('ML','MALI','&&1','EN','0','2020-10-25','0','2020-10-25',1),('MM','MYANMAR','&&1','EN','0','2020-10-25','0','2020-10-25',1),('MN','MONGOLIA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('MO','MACAO','&&1','EN','0','2020-10-25','0','2020-10-25',1),('MP','NORTHERN MARIANA ISLANDS','&&1','EN','0','2020-10-25','0','2020-10-25',1),('MQ','MARTINIQUE','&&1','EN','0','2020-10-25','0','2020-10-25',1),('MR','MAURITANIA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('MS','MONTSERRAT','&&1','EN','0','2020-10-25','0','2020-10-25',1),('MT','MALTA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('MU','MAURITIUS','&&1','EN','0','2020-10-25','0','2020-10-25',1),('MV','MALDIVES','&&1','EN','0','2020-10-25','0','2020-10-25',1),('MW','MALAWI','&&1','EN','0','2020-10-25','0','2020-10-25',1),('MX','MEXICO','&&1','EN','0','2020-10-25','0','2020-10-25',1),('MY','MALAYSIA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('MZ','MOZAMBIQUE','&&1','EN','0','2020-10-25','0','2020-10-25',1),('NA','NAMIBIA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('NC','NEW CALEDONIA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('NE','NIGER','&&1','EN','0','2020-10-25','0','2020-10-25',1),('NF','NORFOLK ISLAND','&&1','EN','0','2020-10-25','0','2020-10-25',1),('NG','NIGERIA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('NI','NICARAGUA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('NL','NETHERLANDS','&&1','EN','0','2020-10-25','0','2020-10-25',1),('NO','NORWAY','&&1','EN','0','2020-10-25','0','2020-10-25',1),('NP','NEPAL','&&1','EN','0','2020-10-25','0','2020-10-25',1),('NR','NAURU','&&1','EN','0','2020-10-25','0','2020-10-25',1),('NU','NIUE','&&1','EN','0','2020-10-25','0','2020-10-25',1),('NZ','NEW ZEALAND','&&1','EN','0','2020-10-25','0','2020-10-25',1),('OM','OMAN','&&1','EN','0','2020-10-25','0','2020-10-25',1),('PA','PANAMA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('PE','PERU','&&1','EN','0','2020-10-25','0','2020-10-25',1),('PF','FRENCH POLYNESIA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('PG','PAPUA NEW GUINEA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('PH','PHILIPPINES','&&1','EN','0','2020-10-25','0','2020-10-25',1),('PK','PAKISTAN','&&1','EN','0','2020-10-25','0','2020-10-25',1),('PL','POLAND','&&1','EN','0','2020-10-25','0','2020-10-25',1),('PM','SAINT PIERRE AND MIQUELON','&&1','EN','0','2020-10-25','0','2020-10-25',1),('PN','PITCAIRN','&&1','EN','0','2020-10-25','0','2020-10-25',1),('PR','PUERTO RICO','&&1','EN','0','2020-10-25','0','2020-10-25',1),('PS','PALESTINIAN TERRITORY, OCCUPIED','&&1','EN','0','2020-10-25','0','2020-10-25',1),('PT','PORTUGAL','&&1','EN','0','2020-10-25','0','2020-10-25',1),('PW','PALAU','&&1','EN','0','2020-10-25','0','2020-10-25',1),('PY','PARAGUAY','&&1','EN','0','2020-10-25','0','2020-10-25',1),('QA','QATAR','&&1','EN','0','2020-10-25','0','2020-10-25',1),('RO','ROMANIA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('RS','SERBIA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('RU','RUSSIAN FEDERATION','&&1','EN','0','2020-10-25','0','2020-10-25',1),('RW','RWANDA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('SA','SAUDI ARABIA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('SB','SOLOMON ISLANDS','&&1','EN','0','2020-10-25','0','2020-10-25',1),('SC','SEYCHELLES','&&1','EN','0','2020-10-25','0','2020-10-25',1),('SD','SUDAN','&&1','EN','0','2020-10-25','0','2020-10-25',1),('SE','SWEDEN','&&1','EN','0','2020-10-25','0','2020-10-25',1),('SG','SINGAPORE','&&1','EN','0','2020-10-25','0','2020-10-25',1),('SH','SAINT HELENA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('SI','SLOVENIA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('SJ','SVALBARD AND JAN MAYEN','&&1','EN','0','2020-10-25','0','2020-10-25',1),('SK','SLOVAKIA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('SL','SIERRA LEONE','&&1','EN','0','2020-10-25','0','2020-10-25',1),('SM','SAN MARINO','&&1','EN','0','2020-10-25','0','2020-10-25',1),('SN','SENEGAL','&&1','EN','0','2020-10-25','0','2020-10-25',1),('SO','SOMALIA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('SR','SURINAME','&&1','EN','0','2020-10-25','0','2020-10-25',1),('ST','SAO TOME AND PRINCIPE','&&1','EN','0','2020-10-25','0','2020-10-25',1),('SV','EL SALVADOR','&&1','EN','0','2020-10-25','0','2020-10-25',1),('SY','SYRIAN ARAB REPUBLIC','&&1','EN','0','2020-10-25','0','2020-10-25',1),('SZ','SWAZILAND','&&1','EN','0','2020-10-25','0','2020-10-25',1),('TC','TURKS AND CAICOS ISLANDS','&&1','EN','0','2020-10-25','0','2020-10-25',1),('TD','CHAD','&&1','EN','0','2020-10-25','0','2020-10-25',1),('TF','FRENCH SOUTHERN TERRITORIES','&&1','EN','0','2020-10-25','0','2020-10-25',1),('TG','TOGO','&&1','EN','0','2020-10-25','0','2020-10-25',1),('TH','THAILAND','&&1','EN','0','2020-10-25','0','2020-10-25',1),('TJ','TAJIKISTAN','&&1','EN','0','2020-10-25','0','2020-10-25',1),('TK','TOKELAU','&&1','EN','0','2020-10-25','0','2020-10-25',1),('TL','TIMOR-LESTE','&&1','EN','0','2020-10-25','0','2020-10-25',1),('TM','TURKMENISTAN','&&1','EN','0','2020-10-25','0','2020-10-25',1),('TN','TUNISIA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('TO','TONGA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('TR','TURKEY','&&1','EN','0','2020-10-25','0','2020-10-25',1),('TT','TRINIDAD AND TOBAGO','&&1','EN','0','2020-10-25','0','2020-10-25',1),('TV','TUVALU','&&1','EN','0','2020-10-25','0','2020-10-25',1),('TW','TAIWAN, PROVINCE OF CHINA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('TZ','TANZANIA, UNITED REPUBLIC OF','&&1','EN','0','2020-10-25','0','2020-10-25',1),('UA','UKRAINE','&&1','EN','0','2020-10-25','0','2020-10-25',1),('UG','UGANDA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('UM','UNITED STATES MINOR OUTLYING ISLANDS','&&1','EN','0','2020-10-25','0','2020-10-25',1),('US','UNITED STATES','&&1','EN','0','2020-10-25','0','2020-10-25',1),('UY','URUGUAY','&&1','EN','0','2020-10-25','0','2020-10-25',1),('UZ','UZBEKISTAN','&&1','EN','0','2020-10-25','0','2020-10-25',1),('VA','HOLY SEE (VATICAN CITY STATE)','&&1','EN','0','2020-10-25','0','2020-10-25',1),('VC','SAINT VINCENT AND THE GRENADINES','&&1','EN','0','2020-10-25','0','2020-10-25',1),('VE','VENEZUELA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('VG','VIRGIN ISLANDS, BRITISH','&&1','EN','0','2020-10-25','0','2020-10-25',1),('VI','VIRGIN ISLANDS, U.S.','&&1','EN','0','2020-10-25','0','2020-10-25',1),('VN','VIET NAM','&&1','EN','0','2020-10-25','0','2020-10-25',1),('VU','VANUATU','&&1','EN','0','2020-10-25','0','2020-10-25',1),('WF','WALLIS AND FUTUNA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('WS','SAMOA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('YE','YEMEN','&&1','EN','0','2020-10-25','0','2020-10-25',1),('YT','MAYOTTE','&&1','EN','0','2020-10-25','0','2020-10-25',1),('ZA','SOUTH AFRICA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('ZM','ZAMBIA','&&1','EN','0','2020-10-25','0','2020-10-25',1),('ZW','ZIMBABWE','&&1','EN','0','2020-10-25','0','2020-10-25',1);
/*!40000 ALTER TABLE `COUNTRY_CODES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `COUPON_USAGES`
--

DROP TABLE IF EXISTS `COUPON_USAGES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `COUPON_USAGES` (
  `CUSTOMER_ID` int(15) NOT NULL,
  `DISCOUNT_ID` int(15) NOT NULL,
  `APPLIED_DATE` date NOT NULL,
  `ORDER_ID` int(15) NOT NULL,
  `CREATED_BY` varchar(60) NOT NULL,
  `CREATION_DATE` date NOT NULL,
  `LAST_UPDATED_BY` varchar(60) NOT NULL,
  `LAST_UPDATE_DATE` date NOT NULL,
  `OBJECT_VERSION_ID` int(15) NOT NULL,
  PRIMARY KEY (`CUSTOMER_ID`,`DISCOUNT_ID`),
  KEY `COUPON_USAGES_DISCOUNTS_FK` (`DISCOUNT_ID`),
  KEY `COUPON_USAGES_ORDERS_FK` (`ORDER_ID`),
  CONSTRAINT `COUPON_USAGES_DISCOUNTS_FK` FOREIGN KEY (`DISCOUNT_ID`) REFERENCES `DISCOUNTS_BASE` (`DISCOUNT_ID`),
  CONSTRAINT `COUPON_USAGES_ORDERS_FK` FOREIGN KEY (`ORDER_ID`) REFERENCES `ORDERS` (`ORDER_ID`),
  CONSTRAINT `COUPON_USAGES_PERSONS_FK` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `PERSONS` (`PERSON_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Associates the use of One-time discounts (coupons) with a particular customer.  When the customer attempts to apply a coupon to a transaction, this table will be checked to see if they have already used this coupon.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `COUPON_USAGES`
--

LOCK TABLES `COUPON_USAGES` WRITE;
/*!40000 ALTER TABLE `COUPON_USAGES` DISABLE KEYS */;
INSERT INTO `COUPON_USAGES` VALUES (108,1,'2020-10-25',1001,'0','2020-10-25','0','2020-10-25',0),(109,2,'2020-10-25',1009,'0','2020-10-25','0','2020-10-25',0);
/*!40000 ALTER TABLE `COUPON_USAGES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CUSTOMER_IDENTIFICATIONS`
--

DROP TABLE IF EXISTS `CUSTOMER_IDENTIFICATIONS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CUSTOMER_IDENTIFICATIONS` (
  `CUSTOMER_ID` int(15) NOT NULL,
  `ID_TYPE_CODE` varchar(30) NOT NULL,
  `ID_DETAIL` varchar(20) NOT NULL,
  `ADDITIONAL_INFORMATION` varchar(1000) DEFAULT NULL,
  `VERIFIED_FLAG` varchar(1) NOT NULL DEFAULT 'N',
  `VERIFIED_DATE` date DEFAULT NULL,
  `VERIFIED_BY` int(15) DEFAULT NULL,
  `VERIFICATION_METHOD_CODE` varchar(30) DEFAULT NULL,
  `CREATED_BY` varchar(60) NOT NULL,
  `CREATION_DATE` date NOT NULL,
  `LAST_UPDATED_BY` varchar(60) NOT NULL,
  `LAST_UPDATE_DATE` date NOT NULL,
  `OBJECT_VERSION_ID` int(15) NOT NULL,
  PRIMARY KEY (`CUSTOMER_ID`),
  KEY `CUSTOMER_IDENTIFICATIONS__FK1` (`VERIFIED_BY`),
  CONSTRAINT `CUSTOMER_IDENTIFICATIONS_FK` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `PERSONS` (`PERSON_ID`),
  CONSTRAINT `CUSTOMER_IDENTIFICATIONS__FK1` FOREIGN KEY (`VERIFIED_BY`) REFERENCES `PERSONS` (`PERSON_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Various forms of identification provided by a customer. Confirmed identity will be used to configure the rules used during the order process, allowing higer spending and less manual verification';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CUSTOMER_IDENTIFICATIONS`
--

LOCK TABLES `CUSTOMER_IDENTIFICATIONS` WRITE;
/*!40000 ALTER TABLE `CUSTOMER_IDENTIFICATIONS` DISABLE KEYS */;
INSERT INTO `CUSTOMER_IDENTIFICATIONS` VALUES (106,'SSN','999-99-9999','Birth Certificate','Y','2020-10-25',100,'COPY','0','2020-10-25','2020-10-25 21:36:52','2020-10-25',0),(107,'ITIN','999999999','Pending verification of SSN Card','N','2020-10-25',101,'BUR','0','2020-10-25','2020-10-25 21:36:52','2020-10-25',0),(108,'PASS','1293459439','Passport','Y','2020-10-25',103,'BUR','0','2020-10-25','2020-10-25 21:36:52','2020-10-25',0),(109,'DL','S-4574-34344','Drivers License','Y','2020-10-25',104,'BUR','0','2020-10-25','2020-10-25 21:36:52','2020-10-25',0),(110,'DL','C-D344-21224','License','Y','2020-10-25',105,'BUR','0','2020-10-25','2020-10-25 21:36:52','2020-10-25',0),(111,'DL','CD-D564-SE224','License','Y','2020-10-25',101,'BUR','0','2020-10-25','2020-10-25 21:36:52','2020-10-25',0),(112,'DL','AA-2364-29224','License','Y','2020-10-25',101,'BUR','0','2020-10-25','2020-10-25 21:36:52','2020-10-25',0),(113,'DL','ZZ-2XC64-2WEQ24','License','Y','2020-10-25',102,'BUR','0','2020-10-25','2020-10-25 21:36:52','2020-10-25',0),(114,'SSN','231-45-2321','SSN','Y','2020-10-25',103,'BUR','0','2020-10-25','2020-10-25 21:36:52','2020-10-25',0),(115,'SSN','121-12-2321','SSN','Y','2020-10-25',104,'BUR','0','2020-10-25','2020-10-25 21:36:52','2020-10-25',0),(116,'PASS','8989889EW','Passport','Y','2020-10-25',104,'BUR','0','2020-10-25','2020-10-25 21:36:52','2020-10-25',0),(117,'PASS','QWE8980','Passport','Y','2020-10-25',105,'BUR','0','2020-10-25','2020-10-25 21:36:52','2020-10-25',0),(118,'PASS','9232057387577748','Passport','Y','2020-10-25',100,'BUR','0','2020-10-25','2020-10-25 21:36:52','2020-10-25',0),(119,'PASS','ZGHGHA87577748','Passport','Y','2020-10-25',101,'BUR','0','2020-10-25','2020-10-25 21:36:52','2020-10-25',0),(120,'SSN','908-23-3444','SSN','Y','2020-10-25',102,'BUR','0','2020-10-25','2020-10-25 21:36:52','2020-10-25',0),(121,'SSN','908-23-3444','SSN','Y','2020-10-25',103,'BUR','0','2020-10-25','2020-10-25 21:36:52','2020-10-25',0),(122,'SSN','234-23-1244','SSN','Y','2020-10-25',104,'BUR','0','2020-10-25','2020-10-25 21:36:52','2020-10-25',0),(123,'DL','234-AS-SDHJS23','DL','Y','2020-10-25',104,'BUR','0','2020-10-25','2020-10-25 21:36:52','2020-10-25',0),(124,'DL','536353-SDHJS23','DL','Y','2020-10-25',104,'BUR','0','2020-10-25','2020-10-25 21:36:52','2020-10-25',0),(125,'PASS','89980SDHJS23','Passport','Y','2020-10-25',104,'BUR','0','2020-10-25','2020-10-25 21:36:52','2020-10-25',0),(126,'PASS','1233SDHJS23','Passport','Y','2020-10-25',105,'BUR','0','2020-10-25','2020-10-25 21:36:52','2020-10-25',0),(127,'PASS','AD45SDHJS23','Passport','Y','2020-10-25',105,'COPY','0','2020-10-25','2020-10-25 21:36:52','2020-10-25',0),(128,'PASS','783792ASD18919','Passport','Y','2020-10-25',105,'COPY','0','2020-10-25','2020-10-25 21:36:52','2020-10-25',0);
/*!40000 ALTER TABLE `CUSTOMER_IDENTIFICATIONS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CUSTOMER_INTERESTS`
--

DROP TABLE IF EXISTS `CUSTOMER_INTERESTS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CUSTOMER_INTERESTS` (
  `CUSTOMER_ID` int(15) NOT NULL,
  `CUSTOMER_INTERESTS_ID` int(15) NOT NULL,
  `CATEGORY_ID` int(15) NOT NULL,
  `CREATED_BY` varchar(60) NOT NULL,
  `CREATION_DATE` date NOT NULL,
  `LAST_UPDATED_BY` varchar(60) NOT NULL,
  `LAST_UPDATE_DATE` date NOT NULL,
  `OBJECT_VERSION_ID` int(15) NOT NULL,
  PRIMARY KEY (`CUSTOMER_INTERESTS_ID`),
  UNIQUE KEY `CUSTOMER_CATEGORY_ID_UNIQUE` (`CUSTOMER_ID`,`CATEGORY_ID`),
  KEY `CUSTOMER_INTERESTS_FK1` (`CATEGORY_ID`),
  CONSTRAINT `CUSTOMER_INTERESTS_FK1` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `PRODUCT_CATEGORIES_BASE` (`CATEGORY_ID`),
  CONSTRAINT `CUSTOMER_INTERESTS_PERSON_FK1` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `PERSONS` (`PERSON_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='The table is used to record the product categories that are of interest to the customer. This information is used to generate the recomendations list on the home page';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CUSTOMER_INTERESTS`
--

LOCK TABLES `CUSTOMER_INTERESTS` WRITE;
/*!40000 ALTER TABLE `CUSTOMER_INTERESTS` DISABLE KEYS */;
INSERT INTO `CUSTOMER_INTERESTS` VALUES (108,1,5,'0','2020-10-25','0','2020-10-25',0),(109,2,8,'0','2020-10-25','0','2020-10-25',0),(110,3,4,'0','2020-10-25','0','2020-10-25',0),(111,4,1,'0','2020-10-25','0','2020-10-25',0),(112,5,8,'0','2020-10-25','0','2020-10-25',0),(113,6,14,'0','2020-10-25','0','2020-10-25',0),(114,7,5,'0','2020-10-25','0','2020-10-25',0),(115,8,7,'0','2020-10-25','0','2020-10-25',0),(116,9,3,'0','2020-10-25','0','2020-10-25',0),(117,10,6,'0','2020-10-25','0','2020-10-25',0),(118,11,10,'0','2020-10-25','0','2020-10-25',0),(119,12,13,'0','2020-10-25','0','2020-10-25',0),(120,13,9,'0','2020-10-25','0','2020-10-25',0),(121,14,11,'0','2020-10-25','0','2020-10-25',0),(122,15,9,'0','2020-10-25','0','2020-10-25',0),(123,16,11,'0','2020-10-25','0','2020-10-25',0),(124,17,13,'0','2020-10-25','0','2020-10-25',0),(125,18,14,'0','2020-10-25','0','2020-10-25',0),(126,19,12,'0','2020-10-25','0','2020-10-25',0),(127,20,9,'0','2020-10-25','0','2020-10-25',0),(128,21,6,'0','2020-10-25','0','2020-10-25',0),(129,22,4,'0','2020-10-25','0','2020-10-25',0);
/*!40000 ALTER TABLE `CUSTOMER_INTERESTS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CUSTOMER_INTERESTS_SEQ`
--

DROP TABLE IF EXISTS `CUSTOMER_INTERESTS_SEQ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CUSTOMER_INTERESTS_SEQ` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) unsigned NOT NULL,
  `cycle_option` tinyint(1) unsigned NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB SEQUENCE=1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CUSTOMER_INTERESTS_SEQ`
--

LOCK TABLES `CUSTOMER_INTERESTS_SEQ` WRITE;
/*!40000 ALTER TABLE `CUSTOMER_INTERESTS_SEQ` DISABLE KEYS */;
INSERT INTO `CUSTOMER_INTERESTS_SEQ` VALUES (200,1,9223372036854775806,200,1,1000,0,0);
/*!40000 ALTER TABLE `CUSTOMER_INTERESTS_SEQ` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DEMO_OPTIONS`
--

DROP TABLE IF EXISTS `DEMO_OPTIONS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DEMO_OPTIONS` (
  `KEY1` varchar(40) NOT NULL,
  `VALUE` varchar(120) DEFAULT NULL,
  `JAVA_DATA_TYPE` varchar(120) NOT NULL DEFAULT 'java.lang.String',
  `DESCRIPTION` varchar(4000) NOT NULL,
  PRIMARY KEY (`KEY1`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Demo Settings defines the various options within the demo which are switched on. It also caches general configuration information such as email addresses and phone INTs to use as overrides in a demo scenario (where emails etc. may be fake)';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DEMO_OPTIONS`
--

LOCK TABLES `DEMO_OPTIONS` WRITE;
/*!40000 ALTER TABLE `DEMO_OPTIONS` DISABLE KEYS */;
INSERT INTO `DEMO_OPTIONS` VALUES ('infrastructure.smtp.server','&&2','java.lang.String','Mail Server for the system to use'),('option.bpel.installed','false','java.lang.Boolean','Is a BPEL engine available?'),('option.sip.installed','false','java.lang.Boolean','Is SIP (click to call) integration available?'),('override.customer.email','&&1','java.lang.String','Override email for use when the system sends an email to any customer. If this value is empty then the actual value in the customer table will be used');
/*!40000 ALTER TABLE `DEMO_OPTIONS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `DISCOUNTS`
--

DROP TABLE IF EXISTS `DISCOUNTS`;
/*!50001 DROP VIEW IF EXISTS `DISCOUNTS`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `DISCOUNTS` (
  `DISCOUNT_ID` tinyint NOT NULL,
  `DESCRIPTION` tinyint NOT NULL,
  `DISCOUNT_TYPE_CODE` tinyint NOT NULL,
  `DISCOUNT_AMOUNT` tinyint NOT NULL,
  `APPLY_AS_PERCENTAGE_FLAG` tinyint NOT NULL,
  `EASY_CODE` tinyint NOT NULL,
  `ADD_FREE_SHIPPING_FLAG` tinyint NOT NULL,
  `ONETIME_DISCOUNT_FLAG` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `DISCOUNTS_BASE`
--

DROP TABLE IF EXISTS `DISCOUNTS_BASE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DISCOUNTS_BASE` (
  `DISCOUNT_ID` int(15) NOT NULL,
  `DISCOUNT_TYPE_CODE` varchar(30) NOT NULL,
  `DISCOUNT_AMOUNT` int(11) NOT NULL,
  `APPLY_AS_PERCENTAGE_FLAG` varchar(1) NOT NULL DEFAULT 'N',
  `EASY_CODE` varchar(20) DEFAULT NULL,
  `ADD_FREE_SHIPPING_FLAG` varchar(1) NOT NULL DEFAULT 'N',
  `ONETIME_DISCOUNT_FLAG` varchar(1) NOT NULL DEFAULT 'Y',
  `CREATED_BY` varchar(60) NOT NULL,
  `CREATION_DATE` date NOT NULL,
  `LAST_UPDATED_BY` varchar(60) NOT NULL,
  `LAST_UPDATE_DATE` date NOT NULL,
  `OBJECT_VERSION_ID` int(15) NOT NULL,
  PRIMARY KEY (`DISCOUNT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='DISCOUNTS provides modifiers to an order. A particular order may have up to two discounts applied. The base discount resulting from customer membership  enrollment and a coupon discount for one-time savings';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DISCOUNTS_BASE`
--

LOCK TABLES `DISCOUNTS_BASE` WRITE;
/*!40000 ALTER TABLE `DISCOUNTS_BASE` DISABLE KEYS */;
INSERT INTO `DISCOUNTS_BASE` VALUES (1,'COUP',10,'N','TENOFF','N','Y','0','2020-10-25','0','2020-10-25',0),(2,'COUP',10,'N','TENOFFPLUS','Y','Y','0','2020-10-25','0','2020-10-25',0),(3,'MEMB',0,'N','FREESHIP','Y','Y','0','2020-10-25','0','2020-10-25',0),(4,'SLVR',5,'N','FREESHIPSLVR','Y','Y','0','2020-10-25','0','2020-10-25',0),(5,'GOLD',10,'N','FREESHIPGLD','Y','Y','0','2020-10-25','0','2020-10-25',0),(6,'CORP',12,'Y','CORP1DISC','N','Y','0','2020-10-25','0','2020-10-25',0),(7,'PART',15,'Y','PART1DISC','N','Y','0','2020-10-25','0','2020-10-25',0);
/*!40000 ALTER TABLE `DISCOUNTS_BASE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DISCOUNT_SEQ`
--

DROP TABLE IF EXISTS `DISCOUNT_SEQ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DISCOUNT_SEQ` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) unsigned NOT NULL,
  `cycle_option` tinyint(1) unsigned NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB SEQUENCE=1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DISCOUNT_SEQ`
--

LOCK TABLES `DISCOUNT_SEQ` WRITE;
/*!40000 ALTER TABLE `DISCOUNT_SEQ` DISABLE KEYS */;
INSERT INTO `DISCOUNT_SEQ` VALUES (8,1,9223372036854775806,8,1,1000,0,0);
/*!40000 ALTER TABLE `DISCOUNT_SEQ` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DISCOUNT_TRANSLATIONS`
--

DROP TABLE IF EXISTS `DISCOUNT_TRANSLATIONS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DISCOUNT_TRANSLATIONS` (
  `DISCOUNT_TRANSLATIONS_ID` int(15) NOT NULL,
  `DISCOUNT_ID` int(15) NOT NULL,
  `DESCRIPTION` varchar(4000) NOT NULL,
  `LANGUAGE` varchar(30) NOT NULL,
  `SOURCE_LANGUAGE` varchar(15) NOT NULL,
  `CREATED_BY` varchar(60) NOT NULL,
  `CREATION_DATE` date NOT NULL,
  `LAST_UPDATED_BY` varchar(60) NOT NULL,
  `LAST_UPDATE_DATE` date NOT NULL,
  `OBJECT_VERSION_ID` int(15) NOT NULL,
  PRIMARY KEY (`DISCOUNT_TRANSLATIONS_ID`),
  KEY `DISCOUNT_TRANSLATIONS_FK` (`DISCOUNT_ID`),
  CONSTRAINT `DISCOUNT_TRANSLATIONS_FK` FOREIGN KEY (`DISCOUNT_ID`) REFERENCES `DISCOUNTS_BASE` (`DISCOUNT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Holds translations of the discount description text';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DISCOUNT_TRANSLATIONS`
--

LOCK TABLES `DISCOUNT_TRANSLATIONS` WRITE;
/*!40000 ALTER TABLE `DISCOUNT_TRANSLATIONS` DISABLE KEYS */;
INSERT INTO `DISCOUNT_TRANSLATIONS` VALUES (1,1,'$10 Dollars off any item.','EN','EN','0','2020-10-25','0','2020-10-25',0),(2,2,'$10 Dollars off any item, plus free shipping.','EN','EN','0','2020-10-25','0','2020-10-25',0),(3,3,'Value shipping for members.','EN','EN','0','2020-10-25','0','2020-10-25',0),(4,4,'Silver membership discount.','EN','EN','0','2020-10-25','0','2020-10-25',0),(5,5,'Gold membership discount.','EN','EN','0','2020-10-25','0','2020-10-25',0),(6,6,'Basic corporate discount.','EN','EN','0','2020-10-25','0','2020-10-25',0),(7,7,'Basic partner discount.','EN','EN','0','2020-10-25','0','2020-10-25',0);
/*!40000 ALTER TABLE `DISCOUNT_TRANSLATIONS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DISCOUNT_TRANSLATIONS_SEQ`
--

DROP TABLE IF EXISTS `DISCOUNT_TRANSLATIONS_SEQ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DISCOUNT_TRANSLATIONS_SEQ` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) unsigned NOT NULL,
  `cycle_option` tinyint(1) unsigned NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB SEQUENCE=1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DISCOUNT_TRANSLATIONS_SEQ`
--

LOCK TABLES `DISCOUNT_TRANSLATIONS_SEQ` WRITE;
/*!40000 ALTER TABLE `DISCOUNT_TRANSLATIONS_SEQ` DISABLE KEYS */;
INSERT INTO `DISCOUNT_TRANSLATIONS_SEQ` VALUES (8,1,9223372036854775806,8,1,1000,0,0);
/*!40000 ALTER TABLE `DISCOUNT_TRANSLATIONS_SEQ` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ELIGIBLE_DISCOUNTS`
--

DROP TABLE IF EXISTS `ELIGIBLE_DISCOUNTS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ELIGIBLE_DISCOUNTS` (
  `MEMBERSHIP_ID` int(15) NOT NULL,
  `DISCOUNT_ID` int(15) NOT NULL,
  `VALID_FROM_DATE` date DEFAULT NULL,
  `VALID_TO_DATE` date DEFAULT NULL,
  `CREATED_BY` varchar(60) NOT NULL,
  `CREATION_DATE` date NOT NULL,
  `LAST_UPDATED_BY` varchar(60) NOT NULL,
  `LAST_UPDATE_DATE` date NOT NULL,
  `OBJECT_VERSION_ID` int(15) NOT NULL,
  PRIMARY KEY (`DISCOUNT_ID`,`MEMBERSHIP_ID`),
  KEY `ELIGIBLE_DISCOUNTS_FK` (`MEMBERSHIP_ID`),
  CONSTRAINT `ELIGIBLE_DISCOUNTS_FK` FOREIGN KEY (`MEMBERSHIP_ID`) REFERENCES `MEMBERSHIPS_BASE` (`MEMBERSHIP_ID`),
  CONSTRAINT `ELIGIBLE_DISCOUNTS_FK1` FOREIGN KEY (`DISCOUNT_ID`) REFERENCES `DISCOUNTS_BASE` (`DISCOUNT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Maps the available discounts to a particular membership. Note that One-Time discounts (Coupons) cannot be allocated to memberships in this way.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ELIGIBLE_DISCOUNTS`
--

LOCK TABLES `ELIGIBLE_DISCOUNTS` WRITE;
/*!40000 ALTER TABLE `ELIGIBLE_DISCOUNTS` DISABLE KEYS */;
INSERT INTO `ELIGIBLE_DISCOUNTS` VALUES (1,3,'2020-10-25','2021-04-25','0','2020-10-25','0','2020-10-25',0),(5,3,'2020-10-25','2021-04-25','0','2020-10-25','0','2020-10-25',0),(9,4,'2020-10-25','2021-10-25','0','2020-10-25','0','2020-10-25',0),(12,4,'2020-10-25','2021-10-25','0','2020-10-25','0','2020-10-25',0),(2,5,'2020-10-25','2022-04-25','0','2020-10-25','0','2020-10-25',0),(7,5,'2020-10-25','2022-04-25','0','2020-10-25','0','2020-10-25',0),(8,5,'2020-10-25','2022-04-25','0','2020-10-25','0','2020-10-25',0),(3,6,'2020-10-25','2023-04-25','0','2020-10-25','0','2020-10-25',0),(6,6,'2020-10-25','2023-04-25','0','2020-10-25','0','2020-10-25',0),(10,6,'2020-10-25','2023-04-25','0','2020-10-25','0','2020-10-25',0),(11,6,'2020-10-25','2023-04-25','0','2020-10-25','0','2020-10-25',0),(4,7,'2020-10-25','2022-11-25','0','2020-10-25','0','2020-10-25',0),(13,7,'2020-10-25','2022-11-25','0','2020-10-25','0','2020-10-25',0),(14,7,'2020-10-25','2022-11-25','0','2020-10-25','0','2020-10-25',0);
/*!40000 ALTER TABLE `ELIGIBLE_DISCOUNTS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `HELP_TRANSLATIONS`
--

DROP TABLE IF EXISTS `HELP_TRANSLATIONS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `HELP_TRANSLATIONS` (
  `HELP_TRANSLATIONS_ID` int(15) NOT NULL,
  `HELP_ID` int(15) NOT NULL,
  `HELP_USAGE` varchar(200) NOT NULL,
  `HELP_TEXT` varchar(2000) NOT NULL,
  `LANGUAGE` varchar(30) NOT NULL,
  `SOURCE_LANGUAGE` varchar(15) NOT NULL,
  `CREATED_BY` varchar(60) NOT NULL,
  `CREATION_DATE` date NOT NULL,
  `LAST_UPDATED_BY` varchar(60) NOT NULL,
  `LAST_UPDATE_DATE` date NOT NULL,
  `OBJECT_VERSION_ID` int(15) NOT NULL,
  PRIMARY KEY (`HELP_TRANSLATIONS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Holds translations of the application help text';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `HELP_TRANSLATIONS`
--

LOCK TABLES `HELP_TRANSLATIONS` WRITE;
/*!40000 ALTER TABLE `HELP_TRANSLATIONS` DISABLE KEYS */;
INSERT INTO `HELP_TRANSLATIONS` VALUES (101,101,'CREATE_PROFILE','Provide your personal information, including how you\'d like to be contacted in the rare case that there is a problem with your order. <p>We never share your information.</p>','EN','EN','0','2020-10-25','0','2020-10-25',0),(102,102,'CREATE_ADDRESS','Add a billing address and optionally, one or more shipping addresses. <p>Sorry, we don\'t ship to P.O. Boxes.</p>','EN','EN','0','2020-10-25','0','2020-10-25',0),(103,103,'CREATE_PAYMENT_OPTIONS','Provide your Payment Information.\n<p>If you choose to pay by credit card, you must enter a valid credit card number.\nFor this demo application, valid sample credit card numbers include: </p>\nVisa: <b>4012888888881881</b><br>\nMC: <b>5105105105105100</b><br>\nAMEX: <b>343434343434343</b>\n<p>If you choose to pay by direct debit, you must enter a valid routing number.\nFor this demo application, valid routing numbers include:</p>\n<b>9874321</b> and <b>789456124</b>','EN','EN','0','2020-10-25','0','2020-10-25',0),(104,104,'CONFIRM_REGISTRATION','Confirm your registration information and edit if necessary.','EN','EN','0','2020-10-25','0','2020-10-25',0);
/*!40000 ALTER TABLE `HELP_TRANSLATIONS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `HELP_TRANSLATIONS_SEQ`
--

DROP TABLE IF EXISTS `HELP_TRANSLATIONS_SEQ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `HELP_TRANSLATIONS_SEQ` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) unsigned NOT NULL,
  `cycle_option` tinyint(1) unsigned NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB SEQUENCE=1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `HELP_TRANSLATIONS_SEQ`
--

LOCK TABLES `HELP_TRANSLATIONS_SEQ` WRITE;
/*!40000 ALTER TABLE `HELP_TRANSLATIONS_SEQ` DISABLE KEYS */;
INSERT INTO `HELP_TRANSLATIONS_SEQ` VALUES (104,1,9223372036854775806,104,1,1000,0,0);
/*!40000 ALTER TABLE `HELP_TRANSLATIONS_SEQ` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LOOKUP_CODES`
--

DROP TABLE IF EXISTS `LOOKUP_CODES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `LOOKUP_CODES` (
  `LOOKUP_TYPE` varchar(30) NOT NULL,
  `LOOKUP_CODE` varchar(30) NOT NULL,
  `MEANING` varchar(80) NOT NULL,
  `DESCRIPTION` varchar(240) DEFAULT NULL,
  `LANGUAGE` varchar(30) NOT NULL,
  `SOURCE_LANG` varchar(30) NOT NULL,
  `CREATED_BY` varchar(60) NOT NULL,
  `CREATION_DATE` date NOT NULL,
  `LAST_UPDATED_BY` varchar(60) NOT NULL,
  `LAST_UPDATE_DATE` date NOT NULL,
  `OBJECT_VERSION_ID` int(15) NOT NULL,
  PRIMARY KEY (`LOOKUP_TYPE`,`LOOKUP_CODE`,`LANGUAGE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Codes used throughout the system following the standard pattern of code Domains specifying to what a code is used for. ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LOOKUP_CODES`
--

LOCK TABLES `LOOKUP_CODES` WRITE;
/*!40000 ALTER TABLE `LOOKUP_CODES` DISABLE KEYS */;
INSERT INTO `LOOKUP_CODES` VALUES ('CARD_TYPE_CODE','AMEX','American Express','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('CARD_TYPE_CODE','DINC','Diners Club','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('CARD_TYPE_CODE','MSTR','MasterCard','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('CARD_TYPE_CODE','VISA','Visa','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('CONTACT_METHOD_CODE','EMAIL','Electronic Mail','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('CONTACT_METHOD_CODE','NONE','No Contact Except for Account Purposes','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('CONTACT_METHOD_CODE','POST','Mail via Post','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('CONTACT_METHOD_CODE','TEL','Telephone','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('DISCOUNT_TYPE_CODE','CORP','Corporate Member','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('DISCOUNT_TYPE_CODE','COUP','Coupon','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('DISCOUNT_TYPE_CODE','GOLD','Gold Member','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('DISCOUNT_TYPE_CODE','MEMB','Member','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('DISCOUNT_TYPE_CODE','PART','Partner','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('DISCOUNT_TYPE_CODE','SLVR','Silver Member','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('GENDER_CODE','F','Female','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('GENDER_CODE','M','Male','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('ID_TYPE_CODE','DL','Drivers License','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('ID_TYPE_CODE','ITIN','Individual Taxpayer Identity Number','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('ID_TYPE_CODE','PASS','Passport Number','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('ID_TYPE_CODE','SSN','Social Security Number','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('MARITAL_STATUS_CODE','COHB','Cohabitating','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('MARITAL_STATUS_CODE','DIV','Divorced','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('MARITAL_STATUS_CODE','MARR','Married','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('MARITAL_STATUS_CODE','PERS','Decline to Answer','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('MARITAL_STATUS_CODE','SING','Single','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('MEMBERSHIP_TYPE_CODE','CORP','Corporate Membership','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('MEMBERSHIP_TYPE_CODE','GROUP','Group Membership','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('MEMBERSHIP_TYPE_CODE','PART','Partner Program','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('MEMBERSHIP_TYPE_CODE','PERS','Personal Membership','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('ORDER_STATUS_CODE','CANCEL','Order was cancelled','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('ORDER_STATUS_CODE','CART','Order is in the shopping cart','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('ORDER_STATUS_CODE','COMPLETE','Order complete','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('ORDER_STATUS_CODE','PEND','Order has been submitted','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('ORDER_STATUS_CODE','PICK','Order is being picked','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('ORDER_STATUS_CODE','SHIP','Order is being shipped','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('ORDER_STATUS_CODE','STOCK','Order awaiting stock','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('OWNER_TYPE_CODE','CUST','Customer','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('OWNER_TYPE_CODE','STAFF','Staff','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('OWNER_TYPE_CODE','SUPP','Supplier','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('PAYMENT_TYPE_CODE','CC','Credit Card','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('PAYMENT_TYPE_CODE','DD','Direct Debit','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('PAYMENT_TYPE_CODE','IN','Invoice','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('PAYMENT_TYPE_CODE','PP','PayPal','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('PERSON_TITLE_CODE','DR','Dr.','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('PERSON_TITLE_CODE','MISS','Miss','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('PERSON_TITLE_CODE','MR','Mr.','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('PERSON_TITLE_CODE','MRS','Mrs.','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('PERSON_TITLE_CODE','MS','Ms.','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('PERSON_TYPE_CODE','CUST','Customer','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('PERSON_TYPE_CODE','STAFF','Staff','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('PERSON_TYPE_CODE','SUPP','Supplier','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('PRODUCT_STATUS_CODE','AVAILABLE','Available product','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('PRODUCT_STATUS_CODE','DISCONTINUED','Discontinued product','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('PRODUCT_STATUS_CODE','NEW','New product, not yet exposed on site','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('SHIPPING_CLASS_CODE','CLASS1','Small Item','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('SHIPPING_CLASS_CODE','CLASS2','Medium-sized item','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('SHIPPING_CLASS_CODE','CLASS3','Bulky Item / Special Handling','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('SUPPLIER_STATUS_CODE','ACTIVE','Approved supplier','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('SUPPLIER_STATUS_CODE','NEW','New unapproved supplier','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('SUPPLIER_STATUS_CODE','SUSPENDED','Suspended supplier','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('USAGE_TYPE_CODE','IN','Invoice Address','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('USAGE_TYPE_CODE','SH','Shipping Address','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('VERIFICATION_METHOD_CODE','BUR','Bureau Verfied','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('VERIFICATION_METHOD_CODE','COPY','Copy or Fax of Document Received','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('VERIFICATION_METHOD_CODE','CUST','Customer Verified','','&&1','EN','0','2020-10-25','0','2020-10-25',0),('VERIFICATION_METHOD_CODE','DOC','Document Presented','','&&1','EN','0','2020-10-25','0','2020-10-25',0);
/*!40000 ALTER TABLE `LOOKUP_CODES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `MEMBERSHIPS`
--

DROP TABLE IF EXISTS `MEMBERSHIPS`;
/*!50001 DROP VIEW IF EXISTS `MEMBERSHIPS`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `MEMBERSHIPS` (
  `MEMBERSHIP_ID` tinyint NOT NULL,
  `MEMBERSHIP_TYPE_CODE` tinyint NOT NULL,
  `MEMBERSHIP_NAME` tinyint NOT NULL,
  `DESCRIPTION` tinyint NOT NULL,
  `CONTACT_ID` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `MEMBERSHIPS_BASE`
--

DROP TABLE IF EXISTS `MEMBERSHIPS_BASE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MEMBERSHIPS_BASE` (
  `MEMBERSHIP_ID` int(15) NOT NULL,
  `MEMBERSHIP_TYPE_CODE` varchar(30) NOT NULL,
  `CONTACT_ID` int(15) NOT NULL,
  `CREATED_BY` varchar(60) NOT NULL,
  `CREATION_DATE` date NOT NULL,
  `LAST_UPDATED_BY` varchar(60) NOT NULL,
  `LAST_UPDATE_DATE` date NOT NULL,
  `OBJECT_VERSION_ID` int(15) NOT NULL,
  PRIMARY KEY (`MEMBERSHIP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='The memberships table holds information about corporate and group membership programs. Particular discounts (see ELIGIBLE_DISCOUNTS) are associated with a membership.  Memberships may be personal,  group, coroprate or partner Note that this table is not translated.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MEMBERSHIPS_BASE`
--

LOCK TABLES `MEMBERSHIPS_BASE` WRITE;
/*!40000 ALTER TABLE `MEMBERSHIPS_BASE` DISABLE KEYS */;
INSERT INTO `MEMBERSHIPS_BASE` VALUES (1,'PERS',110,'0','2020-10-25','0','2020-10-25',0),(2,'GROUP',111,'0','2020-10-25','0','2020-10-25',0),(3,'CORP',112,'0','2020-10-25','0','2020-10-25',0),(4,'PART',113,'0','2020-10-25','0','2020-10-25',0),(5,'PERS',114,'0','2020-10-25','0','2020-10-25',0),(6,'CORP',115,'0','2020-10-25','0','2020-10-25',0),(7,'GROUP',116,'0','2020-10-25','0','2020-10-25',0),(8,'GROUP',117,'0','2020-10-25','0','2020-10-25',0),(9,'GROUP',118,'0','2020-10-25','0','2020-10-25',0),(10,'CORP',119,'0','2020-10-25','0','2020-10-25',0),(11,'CORP',120,'0','2020-10-25','0','2020-10-25',0),(12,'GROUP',121,'0','2020-10-25','0','2020-10-25',0),(13,'PART',122,'0','2020-10-25','0','2020-10-25',0),(14,'PART',123,'0','2020-10-25','0','2020-10-25',0);
/*!40000 ALTER TABLE `MEMBERSHIPS_BASE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MEMBERSHIP_TRANSLATIONS`
--

DROP TABLE IF EXISTS `MEMBERSHIP_TRANSLATIONS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MEMBERSHIP_TRANSLATIONS` (
  `MEMBERSHIP_TRANSLATIONS_ID` int(15) NOT NULL,
  `MEMBERSHIP_ID` int(15) NOT NULL,
  `MEMBERSHIP_NAME` varchar(120) NOT NULL,
  `DESCRIPTION` varchar(2000) DEFAULT NULL,
  `LANGUAGE` varchar(30) NOT NULL,
  `SOURCE_LANGUAGE` varchar(15) NOT NULL,
  `CREATED_BY` varchar(60) NOT NULL,
  `CREATION_DATE` date NOT NULL,
  `LAST_UPDATED_BY` varchar(60) NOT NULL,
  `LAST_UPDATE_DATE` date NOT NULL,
  `OBJECT_VERSION_ID` int(15) NOT NULL,
  PRIMARY KEY (`MEMBERSHIP_TRANSLATIONS_ID`),
  KEY `MEMBERSHIP_TRANSLATIONS_FK` (`MEMBERSHIP_ID`),
  CONSTRAINT `MEMBERSHIP_TRANSLATIONS_FK` FOREIGN KEY (`MEMBERSHIP_ID`) REFERENCES `MEMBERSHIPS_BASE` (`MEMBERSHIP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MEMBERSHIP_TRANSLATIONS`
--

LOCK TABLES `MEMBERSHIP_TRANSLATIONS` WRITE;
/*!40000 ALTER TABLE `MEMBERSHIP_TRANSLATIONS` DISABLE KEYS */;
INSERT INTO `MEMBERSHIP_TRANSLATIONS` VALUES (1,1,'Frugal Personal Membership','Personal Membership.','EN','EN','0','2020-10-25','0','2020-10-25',0),(2,2,'Save the Habitat','Group discount.','EN','EN','0','2020-10-25','0','2020-10-25',0),(3,3,'Lasoraz Inc.','Corp discount.','EN','EN','0','2020-10-25','0','2020-10-25',0),(4,4,'Hendrix Intl.','Partner discount.','EN','EN','0','2020-10-25','0','2020-10-25',0),(5,5,'Saver Personal Membership','Personal Membership.','EN','EN','0','2020-10-25','0','2020-10-25',0),(6,6,'Marcus Mitchell LLC.','Corp Membership.','EN','EN','0','2020-10-25','0','2020-10-25',0),(7,7,'Silicon Valley Product Management Assoc.','Group Membership.','EN','EN','0','2020-10-25','0','2020-10-25',0);
/*!40000 ALTER TABLE `MEMBERSHIP_TRANSLATIONS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MEMBER_SEQ`
--

DROP TABLE IF EXISTS `MEMBER_SEQ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MEMBER_SEQ` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) unsigned NOT NULL,
  `cycle_option` tinyint(1) unsigned NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB SEQUENCE=1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MEMBER_SEQ`
--

LOCK TABLES `MEMBER_SEQ` WRITE;
/*!40000 ALTER TABLE `MEMBER_SEQ` DISABLE KEYS */;
INSERT INTO `MEMBER_SEQ` VALUES (15,1,9223372036854775806,15,1,1000,0,0);
/*!40000 ALTER TABLE `MEMBER_SEQ` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MEMBER_TRANSLATIONS_SEQ`
--

DROP TABLE IF EXISTS `MEMBER_TRANSLATIONS_SEQ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MEMBER_TRANSLATIONS_SEQ` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) unsigned NOT NULL,
  `cycle_option` tinyint(1) unsigned NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB SEQUENCE=1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MEMBER_TRANSLATIONS_SEQ`
--

LOCK TABLES `MEMBER_TRANSLATIONS_SEQ` WRITE;
/*!40000 ALTER TABLE `MEMBER_TRANSLATIONS_SEQ` DISABLE KEYS */;
INSERT INTO `MEMBER_TRANSLATIONS_SEQ` VALUES (8,1,9223372036854775806,8,1,1000,0,0);
/*!40000 ALTER TABLE `MEMBER_TRANSLATIONS_SEQ` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ORDERS`
--

DROP TABLE IF EXISTS `ORDERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ORDERS` (
  `ORDER_ID` int(15) NOT NULL,
  `ORDER_DATE` date NOT NULL,
  `ORDER_SHIPPED_DATE` date DEFAULT NULL,
  `ORDER_STATUS_CODE` varchar(30) NOT NULL,
  `ORDER_TOTAL` float(8,2) NOT NULL,
  `CUSTOMER_ID` int(15) NOT NULL,
  `SHIP_TO_NAME` varchar(120) DEFAULT NULL,
  `SHIP_TO_ADDRESS_ID` int(15) NOT NULL,
  `SHIP_TO_PHONE_NUMBER` varchar(20) DEFAULT NULL,
  `SHIPPING_OPTION_ID` int(15) NOT NULL,
  `PAYMENT_OPTION_ID` int(16) DEFAULT NULL,
  `DISCOUNT_ID` int(15) DEFAULT NULL,
  `COUPON_ID` int(15) DEFAULT NULL,
  `FREE_SHIPPING_FLAG` varchar(1) NOT NULL DEFAULT 'N',
  `CUSTOMER_COLLECT_FLAG` varchar(1) NOT NULL DEFAULT 'N',
  `COLLECTION_WAREHOUSE_ID` int(15) DEFAULT NULL,
  `GIFTWRAP_FLAG` varchar(1) NOT NULL DEFAULT 'N',
  `GIFTWRAP_MESSAGE` varchar(2000) DEFAULT NULL,
  `CREATED_BY` varchar(60) NOT NULL,
  `CREATION_DATE` date NOT NULL,
  `LAST_UPDATED_BY` varchar(60) NOT NULL,
  `LAST_UPDATE_DATE` date NOT NULL,
  `OBJECT_VERSION_ID` int(15) NOT NULL,
  PRIMARY KEY (`ORDER_ID`),
  KEY `ORDERS_PAYMENT_OPTIONS_FK` (`PAYMENT_OPTION_ID`),
  KEY `ORDERS_SHIPPING_OPTIONS_FK` (`SHIPPING_OPTION_ID`),
  KEY `ORDERS_DISCOUNTS_FK` (`DISCOUNT_ID`),
  KEY `ORDERS_DISCOUNTS_FK1` (`COUPON_ID`),
  KEY `ORDERS_WAREHOUSES_FK` (`COLLECTION_WAREHOUSE_ID`),
  KEY `ORDERS_ADDRESSES_FK` (`SHIP_TO_ADDRESS_ID`),
  KEY `ORDERS_PERSONS_FK` (`CUSTOMER_ID`),
  CONSTRAINT `ORDERS_ADDRESSES_FK` FOREIGN KEY (`SHIP_TO_ADDRESS_ID`) REFERENCES `ADDRESSES` (`ADDRESS_ID`),
  CONSTRAINT `ORDERS_DISCOUNTS_FK` FOREIGN KEY (`DISCOUNT_ID`) REFERENCES `DISCOUNTS_BASE` (`DISCOUNT_ID`),
  CONSTRAINT `ORDERS_DISCOUNTS_FK1` FOREIGN KEY (`COUPON_ID`) REFERENCES `DISCOUNTS_BASE` (`DISCOUNT_ID`),
  CONSTRAINT `ORDERS_PAYMENT_OPTIONS_FK` FOREIGN KEY (`PAYMENT_OPTION_ID`) REFERENCES `PAYMENT_OPTIONS` (`PAYMENT_OPTION_ID`),
  CONSTRAINT `ORDERS_PERSONS_FK` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `PERSONS` (`PERSON_ID`),
  CONSTRAINT `ORDERS_SHIPPING_OPTIONS_FK` FOREIGN KEY (`SHIPPING_OPTION_ID`) REFERENCES `SHIPPING_OPTIONS_BASE` (`SHIPPING_OPTION_ID`),
  CONSTRAINT `ORDERS_WAREHOUSES_FK` FOREIGN KEY (`COLLECTION_WAREHOUSE_ID`) REFERENCES `WAREHOUSES` (`WAREHOUSE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Orders holds the core order information';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ORDERS`
--

LOCK TABLES `ORDERS` WRITE;
/*!40000 ALTER TABLE `ORDERS` DISABLE KEYS */;
INSERT INTO `ORDERS` VALUES (1001,'2020-10-25','2020-10-25','COMPLETE',50.97,108,NULL,3,NULL,1,1002,NULL,1,'N','N',NULL,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1002,'2020-10-25',NULL,'PICK',1249.91,108,NULL,97,NULL,3,1001,NULL,NULL,'Y','Y',103,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1003,'2020-10-25',NULL,'STOCK',5000.00,120,'My friend Craig',69,'3033471691',2,1015,6,NULL,'N','N',NULL,'Y','Congratulations!','0','2020-10-25','0','2020-10-25',0),(1004,'2020-10-25',NULL,'CANCEL',879.98,115,NULL,16,NULL,1,1010,6,NULL,'N','N',NULL,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1005,'2020-10-25','2020-10-25','COMPLETE',2225.98,118,NULL,19,NULL,1,1013,3,NULL,'Y','Y',101,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1006,'2020-10-25',NULL,'STOCK',551.86,112,NULL,11,NULL,2,1007,6,NULL,'N','N',NULL,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1007,'2020-10-25','2020-10-25','COMPLETE',3295.94,119,'The Weiss Family',20,'6501241214',3,1014,6,NULL,'N','N',NULL,'Y','Happy Holidays!','0','2020-10-25','0','2020-10-25',0),(1008,'2020-10-25',NULL,'PENDING',100.97,113,NULL,13,NULL,3,1008,7,NULL,'N','N',NULL,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1009,'2020-10-25',NULL,'PICK',12.99,109,NULL,4,NULL,1,1004,NULL,2,'N','N',NULL,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1010,'2020-10-25',NULL,'PENDING',1259.98,120,NULL,21,NULL,2,1015,6,NULL,'N','N',NULL,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1011,'2020-10-25',NULL,'SHIP',99.99,110,NULL,9,NULL,2,1005,5,NULL,'N','N',NULL,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1012,'2020-10-25',NULL,'PICK',1299.96,115,'Mom',16,'6082913792',2,1010,6,NULL,'N','N',NULL,'Y','Happy Birthday!','0','2020-10-25','0','2020-10-25',0),(1013,'2020-10-25',NULL,'PICK',89.99,114,NULL,14,NULL,2,1009,4,NULL,'Y','Y',105,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1014,'2020-10-25','2020-10-25','COMPLETE',1499.50,116,NULL,17,NULL,1,1011,1,NULL,'N','N',NULL,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1015,'2020-10-25',NULL,'PENDING',53.97,109,NULL,4,NULL,1,1004,NULL,NULL,'Y','N',NULL,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1016,'2020-10-25',NULL,'PENDING',160.94,117,NULL,18,NULL,1,1012,3,NULL,'Y','N',NULL,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1017,'2020-10-25',NULL,'STOCK',1649.92,111,NULL,8,NULL,2,1006,3,NULL,'Y','Y',102,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1018,'2020-10-25',NULL,'PENDING',195.99,112,NULL,11,NULL,3,1007,6,NULL,'N','N',NULL,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1019,'2020-10-25','2020-10-25','COMPLETE',2179.99,114,NULL,14,NULL,1,1009,2,NULL,'Y','Y',103,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1020,'2020-10-25','2020-10-25','COMPLETE',2451.97,118,NULL,27,NULL,1,1013,3,NULL,'Y','Y',101,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1021,'2020-10-25','2020-10-25','COMPLETE',2677.96,118,NULL,26,NULL,1,1013,3,NULL,'Y','Y',101,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1022,'2020-10-25','2020-10-25','COMPLETE',2225.98,118,NULL,28,NULL,1,1013,3,NULL,'Y','Y',101,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1023,'2020-10-25','2020-10-25','COMPLETE',2451.97,114,NULL,29,NULL,1,1019,3,NULL,'Y','Y',101,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1024,'2020-10-25','2020-10-25','COMPLETE',2677.96,114,NULL,30,NULL,1,1019,3,NULL,'Y','Y',101,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1025,'2020-10-25','2020-10-25','COMPLETE',2225.98,114,NULL,2,NULL,1,1019,3,NULL,'Y','Y',101,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1026,'2020-10-25','2020-10-25','COMPLETE',2451.97,110,NULL,24,NULL,1,1018,3,NULL,'Y','Y',101,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1027,'2020-10-25','2020-10-25','COMPLETE',2677.96,110,NULL,25,NULL,1,1018,3,NULL,'Y','Y',101,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1028,'2020-10-25','2020-10-25','COMPLETE',2225.98,110,NULL,6,NULL,1,1018,3,NULL,'Y','Y',101,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1029,'2020-10-25','2020-10-25','COMPLETE',2451.97,109,NULL,4,NULL,1,1017,3,NULL,'Y','Y',101,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1030,'2020-10-25','2020-10-25','COMPLETE',2677.96,109,NULL,23,NULL,1,1017,3,NULL,'Y','Y',101,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1031,'2020-10-25','2020-10-25','COMPLETE',2225.98,109,NULL,22,NULL,1,1017,3,NULL,'Y','Y',101,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1032,'2020-10-25','2020-10-25','COMPLETE',2451.97,108,NULL,3,NULL,1,1016,3,NULL,'Y','Y',101,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1033,'2020-10-25','2020-10-25','COMPLETE',2677.96,108,NULL,20,NULL,1,1016,3,NULL,'Y','Y',101,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1034,'2020-10-25','2020-10-25','COMPLETE',2225.98,108,NULL,21,NULL,1,1016,3,NULL,'Y','Y',101,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1040,'2020-10-25','2020-10-25','COMPLETE',2451.97,118,NULL,27,NULL,1,1013,3,NULL,'Y','Y',101,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1041,'2020-10-25','2020-10-25','COMPLETE',2677.96,118,NULL,26,NULL,1,1013,3,NULL,'Y','Y',101,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1042,'2020-10-25','2020-10-25','COMPLETE',2225.98,118,NULL,28,NULL,1,1013,3,NULL,'Y','Y',101,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1043,'2020-10-25','2020-10-25','COMPLETE',2451.97,114,NULL,29,NULL,1,1019,3,NULL,'Y','Y',101,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1044,'2020-10-25','2020-10-25','COMPLETE',2677.96,114,NULL,30,NULL,1,1019,3,NULL,'Y','Y',101,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1045,'2020-10-25','2020-10-25','COMPLETE',2225.98,114,NULL,2,NULL,1,1019,3,NULL,'Y','Y',101,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1046,'2020-10-25','2020-10-25','COMPLETE',2451.97,110,NULL,24,NULL,1,1018,3,NULL,'Y','Y',101,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1047,'2020-10-25','2020-10-25','COMPLETE',2677.96,110,NULL,25,NULL,1,1018,3,NULL,'Y','Y',101,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1048,'2020-10-25','2020-10-25','COMPLETE',2225.98,110,NULL,6,NULL,1,1018,3,NULL,'Y','Y',101,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1049,'2020-10-25','2020-10-25','COMPLETE',2451.97,109,NULL,4,NULL,1,1017,3,NULL,'Y','Y',101,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1050,'2020-10-25','2020-10-25','COMPLETE',2677.96,109,NULL,23,NULL,1,1017,3,NULL,'Y','Y',101,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1051,'2020-10-25','2020-10-25','COMPLETE',2225.98,109,NULL,22,NULL,1,1017,3,NULL,'Y','Y',101,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1052,'2020-10-25','2020-10-25','COMPLETE',2451.97,108,NULL,3,NULL,1,1016,3,NULL,'Y','Y',101,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1053,'2020-10-25','2020-10-25','COMPLETE',2677.96,108,NULL,20,NULL,1,1016,3,NULL,'Y','Y',101,'N',NULL,'0','2020-10-25','0','2020-10-25',0),(1054,'2020-10-25','2020-10-25','COMPLETE',2225.98,108,NULL,21,NULL,1,1016,3,NULL,'Y','Y',101,'N',NULL,'0','2020-10-25','0','2020-10-25',0);
/*!40000 ALTER TABLE `ORDERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ORDER_ITEMS`
--

DROP TABLE IF EXISTS `ORDER_ITEMS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ORDER_ITEMS` (
  `ORDER_ID` int(15) NOT NULL,
  `LINE_ITEM_ID` int(15) NOT NULL,
  `PRODUCT_ID` int(15) NOT NULL,
  `QUANTITY` float(6,0) NOT NULL DEFAULT 1,
  `UNIT_PRICE` float(8,2) NOT NULL,
  `CREATED_BY` varchar(60) NOT NULL,
  `CREATION_DATE` date NOT NULL,
  `LAST_UPDATED_BY` varchar(60) NOT NULL,
  `LAST_UPDATE_DATE` date NOT NULL,
  `OBJECT_VERSION_ID` int(15) NOT NULL,
  PRIMARY KEY (`ORDER_ID`,`LINE_ITEM_ID`),
  KEY `ORDER_ITEMS_PRODUCTS_FK` (`PRODUCT_ID`),
  CONSTRAINT `ORDER_ITEMS_ORDERS_FK` FOREIGN KEY (`ORDER_ID`) REFERENCES `ORDERS` (`ORDER_ID`),
  CONSTRAINT `ORDER_ITEMS_PRODUCTS_FK` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `PRODUCTS_BASE` (`PRODUCT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Holds the order lines';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ORDER_ITEMS`
--

LOCK TABLES `ORDER_ITEMS` WRITE;
/*!40000 ALTER TABLE `ORDER_ITEMS` DISABLE KEYS */;
INSERT INTO `ORDER_ITEMS` VALUES (1001,1,40,1,24.99,'0','2020-10-25','0','2020-10-25',0),(1001,2,63,2,12.99,'0','2020-10-25','0','2020-10-25',0),(1002,1,29,1,899.99,'0','2020-10-25','0','2020-10-25',0),(1002,2,14,3,49.99,'0','2020-10-25','0','2020-10-25',0),(1002,3,2,1,199.95,'0','2020-10-25','0','2020-10-25',0),(1003,1,49,1,5000.00,'0','2020-10-25','0','2020-10-25',0),(1004,1,32,2,439.99,'0','2020-10-25','0','2020-10-25',0),(1005,1,10,1,225.99,'0','2020-10-25','0','2020-10-25',0),(1005,2,1,1,1999.99,'0','2020-10-25','0','2020-10-25',0),(1006,1,63,4,12.99,'0','2020-10-25','0','2020-10-25',0),(1006,2,23,2,249.95,'0','2020-10-25','0','2020-10-25',0),(1007,1,25,1,2499.99,'0','2020-10-25','0','2020-10-25',0),(1007,2,58,3,99.99,'0','2020-10-25','0','2020-10-25',0),(1007,3,5,1,195.99,'0','2020-10-25','0','2020-10-25',0),(1007,4,7,1,299.99,'0','2020-10-25','0','2020-10-25',0),(1008,1,56,1,28.99,'0','2020-10-25','0','2020-10-25',0),(1008,2,60,2,35.99,'0','2020-10-25','0','2020-10-25',0),(1009,1,65,1,12.99,'0','2020-10-25','0','2020-10-25',0),(1010,1,31,2,629.99,'0','2020-10-25','0','2020-10-25',0),(1011,1,18,1,99.99,'0','2020-10-25','0','2020-10-25',0),(1012,1,3,3,299.99,'0','2020-10-25','0','2020-10-25',0),(1012,2,20,1,399.99,'0','2020-10-25','0','2020-10-25',0),(1013,1,15,1,89.99,'0','2020-10-25','0','2020-10-25',0),(1014,1,21,10,149.95,'0','2020-10-25','0','2020-10-25',0),(1015,1,45,3,17.99,'0','2020-10-25','0','2020-10-25',0),(1016,1,13,1,19.99,'0','2020-10-25','0','2020-10-25',0),(1016,2,40,1,24.99,'0','2020-10-25','0','2020-10-25',0),(1016,3,39,3,35.99,'0','2020-10-25','0','2020-10-25',0),(1016,4,54,1,7.99,'0','2020-10-25','0','2020-10-25',0),(1017,1,22,1,199.95,'0','2020-10-25','0','2020-10-25',0),(1017,2,9,1,129.99,'0','2020-10-25','0','2020-10-25',0),(1017,3,36,2,659.99,'0','2020-10-25','0','2020-10-25',0),(1018,1,5,1,195.99,'0','2020-10-25','0','2020-10-25',0),(1019,1,48,3,60.00,'0','2020-10-25','0','2020-10-25',0),(1019,2,1,1,1999.99,'0','2020-10-25','0','2020-10-25',0),(1020,1,10,3,225.99,'0','2020-10-25','0','2020-10-25',0),(1020,2,1,1,1999.99,'0','2020-10-25','0','2020-10-25',0),(1021,1,10,1,225.99,'0','2020-10-25','0','2020-10-25',0),(1021,2,1,1,1999.99,'0','2020-10-25','0','2020-10-25',0),(1022,1,10,2,225.99,'0','2020-10-25','0','2020-10-25',0),(1022,2,1,1,1999.99,'0','2020-10-25','0','2020-10-25',0),(1023,1,10,2,225.99,'0','2020-10-25','0','2020-10-25',0),(1023,2,1,1,1999.99,'0','2020-10-25','0','2020-10-25',0),(1024,1,10,3,225.99,'0','2020-10-25','0','2020-10-25',0),(1024,2,1,1,1999.99,'0','2020-10-25','0','2020-10-25',0),(1025,1,10,1,225.99,'0','2020-10-25','0','2020-10-25',0),(1025,2,1,1,1999.99,'0','2020-10-25','0','2020-10-25',0),(1026,1,10,2,225.99,'0','2020-10-25','0','2020-10-25',0),(1026,2,1,1,1999.99,'0','2020-10-25','0','2020-10-25',0),(1027,1,10,3,225.99,'0','2020-10-25','0','2020-10-25',0),(1027,2,1,1,1999.99,'0','2020-10-25','0','2020-10-25',0),(1028,1,10,1,225.99,'0','2020-10-25','0','2020-10-25',0),(1028,2,1,1,1999.99,'0','2020-10-25','0','2020-10-25',0),(1029,1,10,2,225.99,'0','2020-10-25','0','2020-10-25',0),(1029,2,1,1,1999.99,'0','2020-10-25','0','2020-10-25',0),(1030,1,10,3,225.99,'0','2020-10-25','0','2020-10-25',0),(1030,2,1,1,1999.99,'0','2020-10-25','0','2020-10-25',0),(1031,1,10,1,225.99,'0','2020-10-25','0','2020-10-25',0),(1031,2,1,1,1999.99,'0','2020-10-25','0','2020-10-25',0),(1032,1,10,2,225.99,'0','2020-10-25','0','2020-10-25',0),(1032,2,1,1,1999.99,'0','2020-10-25','0','2020-10-25',0),(1033,1,10,3,225.99,'0','2020-10-25','0','2020-10-25',0),(1033,2,1,1,1999.99,'0','2020-10-25','0','2020-10-25',0),(1034,1,10,1,225.99,'0','2020-10-25','0','2020-10-25',0),(1034,2,15,1,1999.99,'0','2020-10-25','0','2020-10-25',0),(1040,1,14,3,225.99,'0','2020-10-25','0','2020-10-25',0),(1040,2,15,1,1999.99,'0','2020-10-25','0','2020-10-25',0),(1041,1,14,1,225.99,'0','2020-10-25','0','2020-10-25',0),(1041,2,15,1,1999.99,'0','2020-10-25','0','2020-10-25',0),(1042,1,14,2,225.99,'0','2020-10-25','0','2020-10-25',0),(1042,2,15,1,1999.99,'0','2020-10-25','0','2020-10-25',0),(1043,1,14,2,225.99,'0','2020-10-25','0','2020-10-25',0),(1043,2,15,1,1999.99,'0','2020-10-25','0','2020-10-25',0),(1044,1,14,3,225.99,'0','2020-10-25','0','2020-10-25',0),(1044,2,15,1,1999.99,'0','2020-10-25','0','2020-10-25',0),(1045,1,14,1,225.99,'0','2020-10-25','0','2020-10-25',0),(1045,2,15,1,1999.99,'0','2020-10-25','0','2020-10-25',0),(1046,1,14,2,225.99,'0','2020-10-25','0','2020-10-25',0),(1046,2,15,1,1999.99,'0','2020-10-25','0','2020-10-25',0),(1047,1,14,3,225.99,'0','2020-10-25','0','2020-10-25',0),(1047,2,15,1,1999.99,'0','2020-10-25','0','2020-10-25',0),(1048,1,14,1,225.99,'0','2020-10-25','0','2020-10-25',0),(1048,2,15,1,1999.99,'0','2020-10-25','0','2020-10-25',0),(1049,1,14,2,225.99,'0','2020-10-25','0','2020-10-25',0),(1049,2,15,1,1999.99,'0','2020-10-25','0','2020-10-25',0),(1050,1,14,3,225.99,'0','2020-10-25','0','2020-10-25',0),(1050,2,15,1,1999.99,'0','2020-10-25','0','2020-10-25',0),(1051,1,14,1,225.99,'0','2020-10-25','0','2020-10-25',0),(1051,2,15,1,1999.99,'0','2020-10-25','0','2020-10-25',0),(1052,1,14,2,225.99,'0','2020-10-25','0','2020-10-25',0),(1052,2,15,1,1999.99,'0','2020-10-25','0','2020-10-25',0),(1053,1,14,3,225.99,'0','2020-10-25','0','2020-10-25',0),(1053,2,15,1,1999.99,'0','2020-10-25','0','2020-10-25',0),(1054,1,14,1,225.99,'0','2020-10-25','0','2020-10-25',0),(1054,2,15,1,1999.99,'0','2020-10-25','0','2020-10-25',0);
/*!40000 ALTER TABLE `ORDER_ITEMS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ORDER_ITEMS_SEQ`
--

DROP TABLE IF EXISTS `ORDER_ITEMS_SEQ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ORDER_ITEMS_SEQ` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) unsigned NOT NULL,
  `cycle_option` tinyint(1) unsigned NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB SEQUENCE=1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ORDER_ITEMS_SEQ`
--

LOCK TABLES `ORDER_ITEMS_SEQ` WRITE;
/*!40000 ALTER TABLE `ORDER_ITEMS_SEQ` DISABLE KEYS */;
INSERT INTO `ORDER_ITEMS_SEQ` VALUES (101,1,9223372036854775806,101,1,1000,0,0);
/*!40000 ALTER TABLE `ORDER_ITEMS_SEQ` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ORDER_SEQ`
--

DROP TABLE IF EXISTS `ORDER_SEQ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ORDER_SEQ` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) unsigned NOT NULL,
  `cycle_option` tinyint(1) unsigned NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB SEQUENCE=1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ORDER_SEQ`
--

LOCK TABLES `ORDER_SEQ` WRITE;
/*!40000 ALTER TABLE `ORDER_SEQ` DISABLE KEYS */;
INSERT INTO `ORDER_SEQ` VALUES (1100,1,9223372036854775806,1100,1,10,0,0);
/*!40000 ALTER TABLE `ORDER_SEQ` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PAYMENT_OPTIONS`
--

DROP TABLE IF EXISTS `PAYMENT_OPTIONS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PAYMENT_OPTIONS` (
  `PAYMENT_OPTION_ID` int(16) NOT NULL,
  `CUSTOMER_ID` int(15) NOT NULL,
  `PAYMENT_TYPE_CODE` varchar(30) NOT NULL,
  `BILLING_ADDRESS_ID` int(11) DEFAULT NULL,
  `ACCOUNT_NUMBER` int(19) NOT NULL,
  `CARD_TYPE_CODE` varchar(30) DEFAULT NULL,
  `EXPIRE_DATE` date DEFAULT NULL,
  `CHECK_DIGITS` int(4) DEFAULT NULL,
  `ROUTING_IDENTIFIER` varchar(15) DEFAULT NULL,
  `INSTITUTION_NAME` varchar(120) DEFAULT NULL,
  `VALID_FROM_DATE` date DEFAULT NULL,
  `VALID_TO_DATE` date DEFAULT NULL,
  `CREATED_BY` varchar(60) NOT NULL,
  `CREATION_DATE` date NOT NULL,
  `LAST_UPDATED_BY` varchar(60) NOT NULL,
  `LAST_UPDATE_DATE` date NOT NULL,
  `OBJECT_VERSION_ID` int(15) NOT NULL,
  PRIMARY KEY (`PAYMENT_OPTION_ID`),
  KEY `PAYMENT_OPTIONS_PERSONS_FK` (`CUSTOMER_ID`),
  CONSTRAINT `PAYMENT_OPTIONS_PERSONS_FK` FOREIGN KEY (`CUSTOMER_ID`) REFERENCES `PERSONS` (`PERSON_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='The list of payment types defined for this particular customer';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PAYMENT_OPTIONS`
--

LOCK TABLES `PAYMENT_OPTIONS` WRITE;
/*!40000 ALTER TABLE `PAYMENT_OPTIONS` DISABLE KEYS */;
INSERT INTO `PAYMENT_OPTIONS` VALUES (1001,108,'CC',3,411111111,'VISA','2023-04-25',333,NULL,NULL,'2020-10-25','2023-04-30','0','2020-10-25','0','2020-10-25',0),(1002,108,'CC',3,37828205,'AMEX','2022-08-25',333,NULL,NULL,'2020-10-25','2023-04-30','0','2020-10-25','0','2020-10-25',0),(1003,108,'DD',3,123456732,NULL,NULL,NULL,'789456124','Western States Bank','2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1004,109,'CC',4,40128881,'VISA','2021-10-25',333,NULL,NULL,'2020-10-25','2023-04-30','0','2020-10-25','0','2020-10-25',0),(1005,110,'DD',5,98765496,NULL,NULL,NULL,'9874321','Eastern Credit Union','2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1006,111,'CC',7,55555511,'MSTR','2022-11-25',333,NULL,NULL,'2020-10-25','2023-04-30','0','2020-10-25','0','2020-10-25',0),(1007,112,'PP',11,65432287,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1008,113,'CC',12,55000004,'MSTR','2021-12-25',333,NULL,NULL,'2020-10-25','2023-04-30','0','2020-10-25','0','2020-10-25',0),(1009,114,'CC',15,5105110,'MSTR','2022-02-25',333,NULL,NULL,'2020-10-25','2023-04-30','0','2020-10-25','0','2020-10-25',0),(1010,115,'PP',16,3498763,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1011,116,'CC',17,343433,'AMEX','2022-07-25',333,NULL,NULL,'2020-10-25','2023-04-30','0','2020-10-25','0','2020-10-25',0),(1012,117,'DD',18,44080414,'','2023-04-25',333,NULL,NULL,'2020-10-25','2023-04-30','0','2020-10-25','0','2020-10-25',0),(1013,118,'IN',1,95317936,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1014,119,'DD',20,76420532,NULL,NULL,NULL,'43275983','First Southern Bank','2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1015,120,'CC',21,55555555,'MSTR','2023-01-25',333,NULL,NULL,'2020-10-25','2023-04-30','0','2020-10-25','0','2020-10-25',0),(1016,108,'IN',3,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1017,109,'IN',4,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1018,110,'IN',5,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1019,114,'IN',2,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1020,100,'IN',2,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1021,101,'IN',2,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1022,102,'IN',2,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1023,103,'IN',2,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1024,104,'IN',2,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1025,105,'IN',2,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1026,106,'IN',2,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1027,107,'IN',2,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1028,121,'IN',2,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1029,122,'IN',2,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1030,123,'IN',2,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1031,124,'IN',2,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1032,125,'IN',2,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1033,126,'IN',2,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1034,127,'IN',2,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1035,128,'IN',2,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1036,129,'IN',2,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1037,200,'IN',2,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1038,201,'IN',2,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1039,202,'IN',2,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1040,203,'IN',2,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1041,204,'IN',2,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1042,205,'IN',2,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1043,206,'IN',2,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1044,207,'IN',2,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1045,208,'IN',2,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1046,209,'IN',2,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1047,210,'IN',2,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1048,211,'IN',2,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1049,212,'IN',2,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1050,213,'IN',2,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1051,214,'IN',2,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1052,215,'IN',2,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1053,216,'IN',2,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1054,217,'IN',2,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1055,218,'IN',2,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1056,219,'IN',2,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0),(1057,220,'IN',2,95317931,NULL,NULL,NULL,NULL,NULL,'2020-10-25',NULL,'0','2020-10-25','0','2020-10-25',0);
/*!40000 ALTER TABLE `PAYMENT_OPTIONS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PAYMENT_OPTION_SEQ`
--

DROP TABLE IF EXISTS `PAYMENT_OPTION_SEQ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PAYMENT_OPTION_SEQ` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) unsigned NOT NULL,
  `cycle_option` tinyint(1) unsigned NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB SEQUENCE=1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PAYMENT_OPTION_SEQ`
--

LOCK TABLES `PAYMENT_OPTION_SEQ` WRITE;
/*!40000 ALTER TABLE `PAYMENT_OPTION_SEQ` DISABLE KEYS */;
INSERT INTO `PAYMENT_OPTION_SEQ` VALUES (1058,1,9223372036854775806,1058,1,1000,0,0);
/*!40000 ALTER TABLE `PAYMENT_OPTION_SEQ` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PERSONS`
--

DROP TABLE IF EXISTS `PERSONS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PERSONS` (
  `PERSON_ID` int(15) NOT NULL,
  `PRINCIPAL_NAME` varchar(60) NOT NULL,
  `TITLE` varchar(12) DEFAULT NULL,
  `FIRST_NAME` varchar(30) DEFAULT NULL,
  `LAST_NAME` varchar(30) DEFAULT NULL,
  `PERSON_TYPE_CODE` varchar(30) NOT NULL,
  `SUPPLIER_ID` int(15) DEFAULT NULL,
  `PROVISIONED_FLAG` varchar(1) DEFAULT 'N',
  `PRIMARY_ADDRESS_ID` int(15) DEFAULT NULL,
  `REGISTERED_DATE` date DEFAULT NULL,
  `MEMBERSHIP_ID` int(15) DEFAULT NULL,
  `EMAIL` varchar(25) NOT NULL,
  `CONFIRMED_EMAIL` varchar(25) DEFAULT NULL,
  `PHONE_INT` varchar(20) DEFAULT NULL,
  `MOBILE_PHONE_INT` varchar(20) DEFAULT NULL,
  `CREDIT_LIMIT` float(9,2) DEFAULT NULL,
  `DATE_OF_BIRTH` date DEFAULT NULL,
  `MARITAL_STATUS_CODE` varchar(30) NOT NULL,
  `GENDER` varchar(1) NOT NULL,
  `CHILDREN_UNDER_18` int(2) DEFAULT NULL,
  `APPROXIMATE_INCOME` int(15) DEFAULT NULL,
  `CONTACT_METHOD_CODE` varchar(30) DEFAULT NULL,
  `CONTACTABLE_FLAG` varchar(1) NOT NULL DEFAULT 'Y',
  `CONTACT_BY_AFFILLIATES_FLAG` varchar(1) NOT NULL DEFAULT 'Y',
  `CREATED_BY` varchar(60) NOT NULL,
  `CREATION_DATE` date NOT NULL,
  `LAST_UPDATED_BY` varchar(60) NOT NULL,
  `LAST_UPDATE_DATE` date NOT NULL,
  `OBJECT_VERSION_ID` int(15) NOT NULL,
  PRIMARY KEY (`PERSON_ID`),
  KEY `PERSONS_ADDRESSES_FK` (`PRIMARY_ADDRESS_ID`),
  KEY `PERSONS_MEMBERSHIPS_BASE_FK` (`MEMBERSHIP_ID`),
  KEY `PERSON_SUPPLIER_FK` (`SUPPLIER_ID`),
  CONSTRAINT `PERSONS_ADDRESSES_FK` FOREIGN KEY (`PRIMARY_ADDRESS_ID`) REFERENCES `ADDRESSES` (`ADDRESS_ID`),
  CONSTRAINT `PERSONS_MEMBERSHIPS_BASE_FK` FOREIGN KEY (`MEMBERSHIP_ID`) REFERENCES `MEMBERSHIPS_BASE` (`MEMBERSHIP_ID`),
  CONSTRAINT `PERSON_SUPPLIER_FK` FOREIGN KEY (`SUPPLIER_ID`) REFERENCES `SUPPLIERS` (`SUPPLIER_ID`),
  CONSTRAINT `PERSONS_GENDER_CHK` CHECK (`GENDER` in ('M','F','D'))
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='The core person information table';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PERSONS`
--

LOCK TABLES `PERSONS` WRITE;
/*!40000 ALTER TABLE `PERSONS` DISABLE KEYS */;
INSERT INTO `PERSONS` VALUES (100,'SKING',NULL,'Steven','King','STAFF',NULL,'Y',33,NULL,NULL,'SKING','SKING','920.555.0137',NULL,NULL,'1957-06-17','PERS','M',NULL,NULL,NULL,'Y','Y','0','2020-10-25','0','2020-10-25',1),(101,'NKOCHHAR',NULL,'Neena','Kochhar','STAFF',NULL,'Y',34,NULL,NULL,'NKOCHHAR','NKOCHHAR','248.555.0186',NULL,NULL,'1959-09-21','SING','F',NULL,NULL,NULL,'Y','Y','0','2020-10-25','0','2020-10-25',1),(102,'LDEHAAN',NULL,'Lex','De Haan','STAFF',NULL,'Y',35,NULL,NULL,'LDEHAAN','LDEHAAN','317.555.0152',NULL,NULL,'1963-01-13','MARR','M',NULL,NULL,NULL,'Y','Y','0','2020-10-25','0','2020-10-25',1),(103,'AHUNOLD',NULL,'Alexander','Hunold','STAFF',NULL,'Y',36,NULL,NULL,'AHUNOLD','AHUNOLD','590.555.0192',NULL,NULL,'1960-01-03','MARR','M',NULL,NULL,NULL,'Y','Y','0','2020-10-25','0','2020-10-25',1),(104,'BERNST',NULL,'Bruce','Ernst','STAFF',NULL,'Y',38,NULL,NULL,'BERNST','BERNST','970.555.0162',NULL,NULL,'1961-05-21','COHB','M',NULL,NULL,NULL,'Y','Y','0','2020-10-25','0','2020-10-25',1),(105,'DAUSTIN',NULL,'David','Austin','STAFF',NULL,'Y',39,NULL,NULL,'DAUSTIN','DAUSTIN','401.555.0129',NULL,NULL,'1967-06-25','MARR','M',NULL,NULL,NULL,'Y','Y','0','2020-10-25','0','2020-10-25',1),(106,'VPATABAL',NULL,'Valli','Pataballa','STAFF',NULL,'Y',40,NULL,NULL,'VPATABAL','VPATABAL','256.555.0130',NULL,NULL,'1978-02-05','MARR','F',NULL,NULL,NULL,'Y','Y','0','2020-10-25','0','2020-10-25',1),(107,'DLORENTZ',NULL,'Diana','Lorentz','STAFF',NULL,'Y',41,NULL,NULL,'DLORENTZ','DLORENTZ','530.555.0150',NULL,NULL,'1969-02-07','SING','F',NULL,NULL,NULL,'Y','Y','0','2020-10-25','0','2020-10-25',1),(108,'NGREENBE',NULL,'Nancy','Greenberg','CUST',NULL,'N',97,NULL,NULL,'NGREENBE','NGREENBE','865.555.0102',NULL,NULL,'1974-08-17','MARR','F',NULL,NULL,NULL,'Y','Y','0','2020-10-25','0','2020-10-25',1),(109,'DFAVIET',NULL,'Daniel','Faviet','CUST',NULL,'N',54,NULL,NULL,'DFAVIET','DFAVIET','331.555.0124',NULL,NULL,'1964-08-16','MARR','M',NULL,NULL,NULL,'Y','Y','0','2020-10-25','0','2020-10-25',1),(110,'JCHEN',NULL,'John','Chen','CUST',NULL,'N',37,NULL,1,'JCHEN','JCHEN','706.555.0103',NULL,NULL,'1967-09-28','MARR','M',NULL,NULL,NULL,'Y','Y','0','2020-10-25','0','2020-10-25',1),(111,'ISCIARRA',NULL,'Ismael','Sciarra','CUST',NULL,'N',42,NULL,2,'ISCIARRA','ISCIARRA','228.555.0126',NULL,NULL,'1971-09-30','SING','M',NULL,NULL,NULL,'Y','Y','0','2020-10-25','0','2020-10-25',1),(112,'JMURMAN',NULL,'Jose Manuel','Urman','CUST',NULL,'N',55,NULL,3,'JMURMAN','JMURMAN','519.555.0121',NULL,NULL,'1966-03-07','SING','M',NULL,NULL,NULL,'Y','Y','0','2020-10-25','0','2020-10-25',1),(113,'LPOPP',NULL,'Luis','Popp','CUST',NULL,'N',14,NULL,4,'LPOPP','LPOPP','484.555.0141',NULL,NULL,'1969-12-07','DIV','M',NULL,NULL,NULL,'Y','Y','0','2020-10-25','0','2020-10-25',1),(114,'DRAPHEAL',NULL,'Den','Raphaely','CUST',NULL,'N',22,NULL,5,'DRAPHEAL','DRAPHEAL','910.555.0109',NULL,NULL,'1974-12-07','PERS','M',NULL,NULL,NULL,'Y','Y','0','2020-10-25','0','2020-10-25',1),(115,'AKHOO',NULL,'Alexander','Khoo','CUST',NULL,'N',63,NULL,6,'AKHOO','AKHOO','385.555.0125',NULL,NULL,'1965-05-18','SING','M',NULL,NULL,NULL,'Y','Y','0','2020-10-25','0','2020-10-25',1),(116,'SBAIDA',NULL,'Shelli','Baida','CUST',NULL,'N',74,NULL,7,'SBAIDA','SBAIDA','740.555.0184',NULL,NULL,'1967-12-24','MARR','F',NULL,NULL,NULL,'Y','Y','0','2020-10-25','0','2020-10-25',1),(117,'STOBIAS',NULL,'Sigal','Tobias','CUST',NULL,'N',15,NULL,8,'STOBIAS','STOBIAS','719.555.0113',NULL,NULL,'1967-07-24','MARR','M',NULL,NULL,NULL,'Y','Y','0','2020-10-25','0','2020-10-25',1),(118,'GHIMURO',NULL,'Guy','Himuro','CUST',NULL,'N',24,NULL,9,'GHIMURO','GHIMURO','808.555.0167',NULL,NULL,'1968-11-15','MARR','M',NULL,NULL,NULL,'Y','Y','0','2020-10-25','0','2020-10-25',1),(119,'KCOLMENA',NULL,'Karen','Colmenares','CUST',NULL,'N',28,NULL,10,'KCOLMENA','KCOLMENA','848.555.0134',NULL,NULL,'1969-08-10','PERS','F',NULL,NULL,NULL,'Y','Y','0','2020-10-25','0','2020-10-25',1),(120,'MWEISS',NULL,'Matthew','Weiss','CUST',NULL,'N',69,NULL,11,'MWEISS','MWEISS','502.555.0182',NULL,NULL,'1966-07-18','SING','M',NULL,NULL,NULL,'Y','Y','0','2020-10-25','0','2020-10-25',1),(121,'AFRIPP',NULL,'Adam','Fripp','CUST',NULL,'N',73,NULL,12,'AFRIPP','AFRIPP','330.555.0119',NULL,NULL,'1977-04-10','PERS','M',NULL,NULL,NULL,'Y','Y','0','2020-10-25','0','2020-10-25',1),(122,'PKAUFLIN',NULL,'Payam','Kaufling','CUST',NULL,'N',45,NULL,13,'PKAUFLIN','PKAUFLIN','650.555.0178',NULL,NULL,'1975-05-01','COHB','M',NULL,NULL,NULL,'Y','Y','0','2020-10-25','0','2020-10-25',1),(123,'SVOLLMAN',NULL,'Shanta','Vollman','CUST',NULL,'N',47,NULL,14,'SVOLLMAN','SVOLLMAN','434.555.0139',NULL,NULL,'1967-10-10','DIV','F',NULL,NULL,NULL,'Y','Y','0','2020-10-25','0','2020-10-25',1),(124,'KMOURGOS',NULL,'Kevin','Mourgos','CUST',NULL,'N',32,NULL,6,'KMOURGOS','KMOURGOS','907.555.0101',NULL,NULL,'1969-11-16','MARR','M',NULL,NULL,NULL,'Y','Y','0','2020-10-25','0','2020-10-25',1),(125,'JNAYER',NULL,'Julia','Nayer','CUST',NULL,'N',83,NULL,12,'JNAYER','JNAYER','424.555.0196',NULL,NULL,'1977-07-16','MARR','F',NULL,NULL,NULL,'Y','Y','0','2020-10-25','0','2020-10-25',1),(126,'IMIKKILI',NULL,'Irene','Mikkilineni','CUST',NULL,'N',91,NULL,2,'IMIKKILI','IMIKKILI','240.555.0159',NULL,NULL,'1958-09-28','MARR','F',NULL,NULL,NULL,'Y','Y','0','2020-10-25','0','2020-10-25',1),(127,'JLANDRY',NULL,'James','Landry','CUST',NULL,'N',75,NULL,3,'JLANDRY','JLANDRY','518.555.0166',NULL,NULL,'1959-01-14','SING','M',NULL,NULL,NULL,'Y','Y','0','2020-10-25','0','2020-10-25',1),(128,'SMARKLE',NULL,'Steven','Markle','CUST',NULL,'N',10,NULL,7,'SMARKLE','SMARKLE','862.555.0180',NULL,NULL,'1961-03-08','SING','M',NULL,NULL,NULL,'Y','Y','0','2020-10-25','0','2020-10-25',1),(129,'LBISSOT',NULL,'Laura','Bissot','CUST',NULL,'N',58,NULL,NULL,'LBISSOT','LBISSOT','340.555.0114',NULL,NULL,'1963-08-20','COHB','F',NULL,NULL,NULL,'Y','Y','0','2020-10-25','0','2020-10-25',1),(200,'PBROWN',NULL,'Patrick','Brown','SUPP',100,'Y',43,NULL,NULL,'PBROWN','PBROWN','425.555.0143',NULL,NULL,'1957-06-17','PERS','M',NULL,NULL,NULL,'N','N','0','2020-10-25','0','2020-10-25',1),(201,'TBRALICK',NULL,'Terra','Bralick','SUPP',101,'Y',44,NULL,NULL,'TBRALICK','TBRALICK','512.555.0148',NULL,NULL,'1957-06-17','PERS','F',NULL,NULL,NULL,'N','N','0','2020-10-25','0','2020-10-25',1),(202,'JBOYLE',NULL,'John','Boyle','SUPP',102,'Y',46,NULL,NULL,'JBOYLE','JBOYLE','651.555.0107',NULL,NULL,'1957-06-17','PERS','M',NULL,NULL,NULL,'N','N','0','2020-10-25','0','2020-10-25',1),(203,'RBERMAN',NULL,'Rachel','Berman','SUPP',103,'Y',48,NULL,NULL,'RBERMAN','RBERMAN','337.555.0161',NULL,NULL,'1957-06-17','PERS','F',NULL,NULL,NULL,'N','N','0','2020-10-25','0','2020-10-25',1),(204,'CBENGHIAT',NULL,'Claudia','Benghiat','SUPP',104,'Y',49,NULL,NULL,'CBENGHIAT','CBENGHIAT','563.555.0127',NULL,NULL,'1957-06-17','PERS','F',NULL,NULL,NULL,'N','N','0','2020-10-25','0','2020-10-25',1),(205,'DSUDEEP',NULL,'Damian','Sudeep','SUPP',105,'Y',50,NULL,NULL,'DSUDEEP','DSUDEEP','281.555.0198',NULL,NULL,'1957-06-17','PERS','M',NULL,NULL,NULL,'N','N','0','2020-10-25','0','2020-10-25',1),(206,'SHEMANT',NULL,'Sharon','Hemant','SUPP',106,'Y',51,NULL,NULL,'SHEMANT','SHEMANT','514.555.0199',NULL,NULL,'1957-06-17','PERS','F',NULL,NULL,NULL,'N','N','0','2020-10-25','0','2020-10-25',1),(207,'JARMSTRONG',NULL,'Jose','Armstrong','SUPP',107,'Y',52,NULL,NULL,'JARMSTRONG','JARMSTRONG','818.555.0116',NULL,NULL,'1957-06-17','PERS','M',NULL,NULL,NULL,'N','N','0','2020-10-25','0','2020-10-25',1),(208,'SROYA',NULL,'Steven','Roya','SUPP',108,'Y',53,NULL,NULL,'SROYA','SROYA','660.555.0145',NULL,NULL,'1957-06-17','PERS','M',NULL,NULL,NULL,'N','N','0','2020-10-25','0','2020-10-25',1),(209,'ACHEN',NULL,'Alison','Chen','SUPP',109,'Y',56,NULL,NULL,'ACHEN','ACHEN','340.555.0135',NULL,NULL,'1957-06-17','PERS','F',NULL,NULL,NULL,'N','N','0','2020-10-25','0','2020-10-25',1),(210,'ADUCKERS',NULL,'Alex','Duckers','SUPP',110,'Y',57,NULL,NULL,'ADUCKERS','ADUCKERS','662.555.0106',NULL,NULL,'1957-06-17','PERS','F',NULL,NULL,NULL,'N','N','0','2020-10-25','0','2020-10-25',1),(211,'ADEE',NULL,'Anand','Dee','SUPP',111,'Y',59,NULL,NULL,'ADEE','ADEE','219.555.0144',NULL,NULL,'1957-06-17','PERS','M',NULL,NULL,NULL,'N','N','0','2020-10-25','0','2020-10-25',1),(212,'CROUSE',NULL,'Christopher','Rouse','SUPP',112,'Y',60,NULL,NULL,'CROUSE','CROUSE','815.555.0188',NULL,NULL,'1957-06-17','PERS','M',NULL,NULL,NULL,'N','N','0','2020-10-25','0','2020-10-25',1),(213,'KDODD',NULL,'Kyle','Dodd','SUPP',113,'Y',61,NULL,NULL,'KDODD','KDODD','602.555.0155',NULL,NULL,'1957-06-17','PERS','M',NULL,NULL,NULL,'N','N','0','2020-10-25','0','2020-10-25',1),(214,'RCOLLINS',NULL,'Rob','Collins','SUPP',114,'Y',62,NULL,NULL,'RCOLLINS','RCOLLINS','225.555.0179',NULL,NULL,'1957-06-17','PERS','M',NULL,NULL,NULL,'N','N','0','2020-10-25','0','2020-10-25',1),(215,'BSATYANARAYANA',NULL,'Bhaskar','Satyanarayana','SUPP',115,'Y',64,NULL,NULL,'BSATYANARAYANA','BSATYANARAYANA','864.555.0100',NULL,NULL,'1957-06-17','PERS','M',NULL,NULL,NULL,'N','N','0','2020-10-25','0','2020-10-25',1),(216,'SGRAFF',NULL,'Scott','Graff','SUPP',116,'Y',65,NULL,NULL,'SGRAFF','SGRAFF','732.555.0110',NULL,NULL,'1957-06-17','PERS','M',NULL,NULL,NULL,'N','N','0','2020-10-25','0','2020-10-25',1),(217,'FHALVERSON',NULL,'Frank','Halverson','SUPP',117,'Y',66,NULL,NULL,'FHALVERSON','FHALVERSON','307.555.0176',NULL,NULL,'1957-06-17','PERS','M',NULL,NULL,NULL,'N','N','0','2020-10-25','0','2020-10-25',1),(218,'KHAN',NULL,'Katrina','Han','SUPP',118,'Y',67,NULL,NULL,'KHAN','KHAN','475.555.0147',NULL,NULL,'1957-06-17','PERS','F',NULL,NULL,NULL,'N','N','0','2020-10-25','0','2020-10-25',1),(219,'FSCOTT',NULL,'Frank','Scott','SUPP',119,'Y',68,NULL,NULL,'FSCOTT','FSCOTT','804.555.0187',NULL,NULL,'1957-06-17','PERS','M',NULL,NULL,NULL,'N','N','0','2020-10-25','0','2020-10-25',1),(220,'MGUJAR',NULL,'Mukul','Gujar','SUPP',120,'Y',70,NULL,NULL,'MGUJAR','MGUJAR','214.555.0191',NULL,NULL,'1957-06-17','PERS','M',NULL,NULL,NULL,'N','N','0','2020-10-25','0','2020-10-25',1);
/*!40000 ALTER TABLE `PERSONS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `PERSON_INFORMATION`
--

DROP TABLE IF EXISTS `PERSON_INFORMATION`;
/*!50001 DROP VIEW IF EXISTS `PERSON_INFORMATION`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `PERSON_INFORMATION` (
  `CUSTOMER_ID` tinyint NOT NULL,
  `PRINCIPAL_NAME` tinyint NOT NULL,
  `TITLE` tinyint NOT NULL,
  `FIRST_NAME` tinyint NOT NULL,
  `LAST_NAME` tinyint NOT NULL,
  `ADDRESS1` tinyint NOT NULL,
  `ADDRESS2` tinyint NOT NULL,
  `CITY` tinyint NOT NULL,
  `POSTAL_CODE` tinyint NOT NULL,
  `STATE_PROVINCE` tinyint NOT NULL,
  `COUNTRY_ID` tinyint NOT NULL,
  `LONGITUDE` tinyint NOT NULL,
  `LATITUDE` tinyint NOT NULL,
  `CONFIRMED_EMAIL` tinyint NOT NULL,
  `PHONE_INT` tinyint NOT NULL,
  `MOBILE_PHONE_INT` tinyint NOT NULL,
  `REGISTERED_DATE` tinyint NOT NULL,
  `MEMBERSHIP_ID` tinyint NOT NULL,
  `CREDIT_LIMIT` tinyint NOT NULL,
  `DATE_OF_BIRTH` tinyint NOT NULL,
  `MARITAL_STATUS_CODE` tinyint NOT NULL,
  `GENDER` tinyint NOT NULL,
  `CHILDREN_UNDER_18` tinyint NOT NULL,
  `APPROXIMATE_INCOME` tinyint NOT NULL,
  `CONTACT_METHOD_CODE` tinyint NOT NULL,
  `CONTACTABLE_FLAG` tinyint NOT NULL,
  `CONTACT_BY_AFFILLIATES_FLAG` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `PERSON_SEQ`
--

DROP TABLE IF EXISTS `PERSON_SEQ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PERSON_SEQ` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) unsigned NOT NULL,
  `cycle_option` tinyint(1) unsigned NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB SEQUENCE=1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PERSON_SEQ`
--

LOCK TABLES `PERSON_SEQ` WRITE;
/*!40000 ALTER TABLE `PERSON_SEQ` DISABLE KEYS */;
INSERT INTO `PERSON_SEQ` VALUES (300,1,9223372036854775806,300,1,10,0,0);
/*!40000 ALTER TABLE `PERSON_SEQ` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `PRODUCTS`
--

DROP TABLE IF EXISTS `PRODUCTS`;
/*!50001 DROP VIEW IF EXISTS `PRODUCTS`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `PRODUCTS` (
  `DESCRIPTION` tinyint NOT NULL,
  `ADDITIONAL_INFO` tinyint NOT NULL,
  `COST_PRICE` tinyint NOT NULL,
  `SUPPLIER_ID` tinyint NOT NULL,
  `PRODUCT_NAME` tinyint NOT NULL,
  `LIST_PRICE` tinyint NOT NULL,
  `PRODUCT_ID` tinyint NOT NULL,
  `CATEGORY_ID` tinyint NOT NULL,
  `MIN_PRICE` tinyint NOT NULL,
  `WARRANTY_PERIOD_MONTHS` tinyint NOT NULL,
  `SHIPPING_CLASS_CODE` tinyint NOT NULL,
  `EXTERNAL_URL` tinyint NOT NULL,
  `ATTRIBUTE_CATEGORY` tinyint NOT NULL,
  `ATTRIBUTE15` tinyint NOT NULL,
  `ATTRIBUTE1` tinyint NOT NULL,
  `ATTRIBUTE2` tinyint NOT NULL,
  `ATTRIBUTE3` tinyint NOT NULL,
  `ATTRIBUTE4` tinyint NOT NULL,
  `ATTRIBUTE5` tinyint NOT NULL,
  `ATTRIBUTE6` tinyint NOT NULL,
  `ATTRIBUTE7` tinyint NOT NULL,
  `ATTRIBUTE8` tinyint NOT NULL,
  `ATTRIBUTE9` tinyint NOT NULL,
  `ATTRIBUTE10` tinyint NOT NULL,
  `ATTRIBUTE11` tinyint NOT NULL,
  `ATTRIBUTE12` tinyint NOT NULL,
  `ATTRIBUTE13` tinyint NOT NULL,
  `ATTRIBUTE14` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `PRODUCTS_BASE`
--

DROP TABLE IF EXISTS `PRODUCTS_BASE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PRODUCTS_BASE` (
  `PRODUCT_ID` int(15) NOT NULL,
  `SUPPLIER_ID` int(15) NOT NULL,
  `PARENT_CATEGORY_ID` int(15) DEFAULT NULL,
  `CATEGORY_ID` int(15) DEFAULT NULL,
  `PRODUCT_NAME` varchar(50) NOT NULL,
  `PRODUCT_STATUS` varchar(30) NOT NULL,
  `COST_PRICE` float(8,2) DEFAULT NULL,
  `LIST_PRICE` float(8,2) NOT NULL,
  `MIN_PRICE` float(8,2) NOT NULL,
  `WARRANTY_PERIOD_MONTHS` float(2,0) DEFAULT NULL,
  `SHIPPING_CLASS_CODE` varchar(30) NOT NULL,
  `EXTERNAL_URL` varchar(200) DEFAULT NULL,
  `ATTRIBUTE_CATEGORY` varchar(30) DEFAULT NULL,
  `ATTRIBUTE1` varchar(150) DEFAULT NULL,
  `ATTRIBUTE2` varchar(150) DEFAULT NULL,
  `ATTRIBUTE3` varchar(150) DEFAULT NULL,
  `ATTRIBUTE4` varchar(150) DEFAULT NULL,
  `ATTRIBUTE5` varchar(150) DEFAULT NULL,
  `ATTRIBUTE6` varchar(150) DEFAULT NULL,
  `ATTRIBUTE7` varchar(150) DEFAULT NULL,
  `ATTRIBUTE8` varchar(150) DEFAULT NULL,
  `ATTRIBUTE9` varchar(150) DEFAULT NULL,
  `ATTRIBUTE10` varchar(150) DEFAULT NULL,
  `ATTRIBUTE11` varchar(150) DEFAULT NULL,
  `ATTRIBUTE12` varchar(150) DEFAULT NULL,
  `ATTRIBUTE13` varchar(150) DEFAULT NULL,
  `ATTRIBUTE14` varchar(150) DEFAULT NULL,
  `ATTRIBUTE15` varchar(150) DEFAULT NULL,
  `CREATED_BY` varchar(60) NOT NULL,
  `CREATION_DATE` date NOT NULL,
  `LAST_UPDATED_BY` varchar(60) NOT NULL,
  `LAST_UPDATE_DATE` date NOT NULL,
  `OBJECT_VERSION_ID` int(15) NOT NULL,
  PRIMARY KEY (`PRODUCT_ID`),
  KEY `PRODUCTS_SUPPLIERS_FK` (`SUPPLIER_ID`),
  KEY `PRODUCTS_PRODUCT_CATEGORIES_FK` (`CATEGORY_ID`),
  CONSTRAINT `PRODUCTS_PRODUCT_CATEGORIES_FK` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `PRODUCT_CATEGORIES_BASE` (`CATEGORY_ID`),
  CONSTRAINT `PRODUCTS_SUPPLIERS_FK` FOREIGN KEY (`SUPPLIER_ID`) REFERENCES `SUPPLIERS` (`SUPPLIER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='The products that are sold';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PRODUCTS_BASE`
--

LOCK TABLES `PRODUCTS_BASE` WRITE;
/*!40000 ALTER TABLE `PRODUCTS_BASE` DISABLE KEYS */;
INSERT INTO `PRODUCTS_BASE` VALUES (1,112,3,4,'Plasma HD Television','AVAILABLE',1499.99,1999.99,1599.99,6,'CLASS3','/home/afshin/Images/1.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(2,119,3,7,'PlayStation 2 Video Game','AVAILABLE',85.00,199.95,101.99,2,'CLASS2','/home/afshin/Images/2.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(3,102,3,6,'Treo 650 Phone/PDA','AVAILABLE',200.00,299.99,259.99,6,'CLASS2','/home/afshin/Images/3.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(4,106,3,6,'Treo 700w Phone/PDA','AVAILABLE',300.00,399.99,359.99,6,'CLASS2','/home/afshin/Images/4.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(5,106,3,4,'Tungsten E PDA','AVAILABLE',100.00,195.99,175.99,3,'CLASS1','/home/afshin/Images/5.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(6,105,3,7,'XBox Video Game System','AVAILABLE',75.00,159.99,135.99,3,'CLASS2','/home/afshin/Images/6.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(7,105,3,7,'XBox 360 Video Game System','AVAILABLE',150.00,299.99,229.99,3,'CLASS2','/home/afshin/Images/7.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(8,119,3,7,'Playstation Portable','AVAILABLE',100.00,199.99,129.99,3,'CLASS2','/home/afshin/Images/8.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(9,105,3,7,'Nintendo DS','AVAILABLE',55.00,129.99,76.99,3,'CLASS2','/home/afshin/Images/9.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(10,123,3,4,'Zune 30Gb','AVAILABLE',100.00,225.99,169.99,3,'CLASS2','/home/afshin/Images/10.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(11,112,3,6,'RAZR Cellular Phone','AVAILABLE',140.00,259.99,209.99,3,'CLASS1','/home/afshin/Images/11.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(12,123,3,4,'Muvo Personal MP3 Player','AVAILABLE',64.00,99.99,78.99,3,'CLASS1','/home/afshin/Images/12.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(13,101,3,6,'Bluetooth Adaptor','AVAILABLE',5.00,19.99,6.99,0,'CLASS1','/home/afshin/Images/13.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(14,112,3,6,'Bluetooth Phone Headset','AVAILABLE',20.00,49.99,24.99,0,'CLASS1','/home/afshin/Images/14.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(15,106,3,4,'Ipod Speakers','AVAILABLE',35.00,89.99,55.99,6,'CLASS2','/home/afshin/Images/15.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(16,106,3,4,'Creative Zen Vision W 60 GB','AVAILABLE',290.00,389.99,329.99,6,'CLASS2','/home/afshin/Images/16.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(17,126,3,4,'Ipod Video 80Gb','AVAILABLE',200.00,339.99,299.95,6,'CLASS2','/home/afshin/Images/17.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(18,123,3,4,'Ipod Shuffle 1Gb','AVAILABLE',45.00,99.99,69.95,6,'CLASS2','/home/afshin/Images/18.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(19,114,3,4,'Ipod Video 30Gb','AVAILABLE',125.00,249.99,227.95,6,'CLASS2','/home/afshin/Images/19.gif',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(20,112,3,4,'Ipod Video 60Gb','AVAILABLE',175.00,399.99,279.99,6,'CLASS2','/home/afshin/Images/20.gif',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(21,123,3,4,'Ipod Nano 1Gb','AVAILABLE',90.00,149.95,119.99,6,'CLASS2','/home/afshin/Images/21.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(22,126,3,4,'Ipod Nano 2Gb','AVAILABLE',100.00,199.95,129.99,6,'CLASS2','/home/afshin/Images/22.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(23,106,3,4,'Ipod Nano 4Gb','AVAILABLE',150.00,249.95,199.95,6,'CLASS2','/home/afshin/Images/23.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(24,103,2,12,'17-Inch iMac','AVAILABLE',400.00,899.99,699.99,6,'CLASS3','/home/afshin/Images/24.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(25,101,2,12,'20-Inch iMac','AVAILABLE',1000.00,2499.99,1499.99,12,'CLASS3','/home/afshin/Images/25.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(26,103,2,12,'Mini Mac Computer','AVAILABLE',400.00,799.99,599.99,12,'CLASS3','/home/afshin/Images/26.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(27,107,2,12,'17-Inch Powerbook','AVAILABLE',2500.00,3499.99,3099.99,12,'CLASS3','/home/afshin/Images/27.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(28,102,2,12,'15-Inch MacBook Pro','AVAILABLE',1000.00,1999.99,1499.99,12,'CLASS3','/home/afshin/Images/28.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(29,106,3,4,'LCD HD Television','AVAILABLE',600.00,899.99,699.99,12,'CLASS3','/home/afshin/Images/29.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(30,123,3,5,'MPEG4 Camcorder','AVAILABLE',200.00,499.99,239.99,3,'CLASS2','/home/afshin/Images/30.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(31,106,3,5,'7 Megapixel Digital Camera','AVAILABLE',300.00,629.99,399.99,3,'CLASS2','/home/afshin/Images/31.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(32,114,3,5,'Internet Camera','AVAILABLE',200.00,439.99,239.99,3,'CLASS2','/home/afshin/Images/32.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(33,106,3,6,'Chocolate Phone','AVAILABLE',300.00,499.99,399.99,6,'CLASS1','/home/afshin/Images/33.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(34,114,3,5,'6 Megapixel Digital Camera','AVAILABLE',200.00,299.99,249.99,6,'CLASS2','/home/afshin/Images/34.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(35,123,3,6,'Blackberry 8100c','AVAILABLE',300.00,499.99,399.99,6,'CLASS1','/home/afshin/Images/35.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(36,105,3,7,'Nintendo Wii','AVAILABLE',470.00,659.99,559.99,12,'CLASS2','/home/afshin/Images/36.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(37,119,3,7,'Wii Remote','AVAILABLE',60.00,71.99,69.99,3,'CLASS1','/home/afshin/Images/37.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(38,104,1,8,'Beginning EJB Application Development','AVAILABLE',15.00,29.99,25.99,0,'CLASS2','/home/afshin/Images/38.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(39,113,1,8,'Pro EJB 3: Java Persistence API','AVAILABLE',15.00,35.99,25.99,0,'CLASS2','/home/afshin/Images/39.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(40,104,1,8,'The Oracle of Oracle','AVAILABLE',5.00,24.99,10.99,0,'CLASS2','/home/afshin/Images/40.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(41,113,1,8,'EJB3 In Action','AVAILABLE',9.00,29.99,15.99,0,'CLASS2','/home/afshin/Images/41.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(42,103,1,11,'Essential Bach','AVAILABLE',4.00,15.99,6.99,0,'CLASS1','/home/afshin/Images/42.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(43,121,1,11,'Beethoven Symphonies Collection','AVAILABLE',6.00,18.99,12.99,0,'CLASS1','/home/afshin/Images/43.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(44,109,1,11,'Essential Mozart','AVAILABLE',6.00,15.99,6.99,0,'CLASS1','/home/afshin/Images/44.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(45,107,1,11,'Chopin: Favorite Piano Works','AVAILABLE',7.00,17.99,10.99,0,'CLASS1','/home/afshin/Images/45.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(46,117,1,11,'Tchaikovsky\'s Ballet','AVAILABLE',9.00,16.99,11.99,0,'CLASS1','/home/afshin/Images/46.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(47,110,1,11,'Dvorak\'s Great Symphonies','AVAILABLE',7.00,16.99,10.99,0,'CLASS1','/home/afshin/Images/47.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(48,100,2,14,'Oracle Collaboration Suite (User Perpetual)','AVAILABLE',60.00,60.00,60.00,12,'CLASS1','/home/afshin/Images/48.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(49,102,2,14,'Oracle Application Server (Processor Perpetual)','AVAILABLE',5000.00,5000.00,5000.00,12,'CLASS1','/home/afshin/Images/49.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(50,108,2,14,'Oracle Database SE (Processor Perpetual)','AVAILABLE',4995.00,4995.00,4995.00,12,'CLASS1','/home/afshin/Images/50.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(51,101,2,14,'Oracle Database EE (Processor Perpetual)','AVAILABLE',40000.00,40000.00,40000.00,12,'CLASS1','/home/afshin/Images/51.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(52,103,2,14,'Oracle JDeveloper','AVAILABLE',0.00,0.00,0.00,12,'CLASS1','/home/afshin/Images/52.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(53,104,2,14,'Oracle Linux Premier Support','AVAILABLE',1999.00,1999.00,1999.00,12,'CLASS1','/home/afshin/Images/53.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(54,107,2,13,'Stapler','AVAILABLE',4.00,7.99,6.99,0,'CLASS2','/home/afshin/Images/54.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(55,103,2,13,'Red Swingline Stapler','AVAILABLE',15.00,32.99,26.99,12,'CLASS2','/home/afshin/Images/55.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(56,108,2,13,'7 port USB Hub','AVAILABLE',20.00,28.99,24.99,6,'CLASS2','/home/afshin/Images/56.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(57,101,2,13,'Multi-purpose Scissors','AVAILABLE',10.00,19.99,14.99,0,'CLASS1','/home/afshin/Images/57.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(58,109,2,13,'Roller Carrying Case','AVAILABLE',50.00,99.99,64.99,6,'CLASS3','/home/afshin/Images/58.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(59,103,2,13,'Contour Carrying Case','AVAILABLE',40.00,59.99,44.99,6,'CLASS2','/home/afshin/Images/59.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(60,104,1,8,'JavaServer Faces: The Complete Reference','AVAILABLE',18.00,35.99,24.99,0,'CLASS2','/home/afshin/Images/60.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(61,113,1,8,'Oracle JDeveloper for Forms and PL/SQL Developers','AVAILABLE',20.00,35.99,24.99,0,'CLASS2','/home/afshin/Images/61.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(62,103,1,9,'Rin Tin Tin Double Feature, Vol. 1 (1947)','AVAILABLE',3.00,12.99,8.99,3,'CLASS1','/home/afshin/Images/62.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(63,107,1,9,'Rin Tin Tin Double Feature, Vol. 2 (1947)','AVAILABLE',3.00,12.99,8.99,3,'CLASS1','/home/afshin/Images/63.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(64,101,1,9,'Sky King:Vol 1 TV Series (1958)','AVAILABLE',3.00,12.99,8.99,3,'CLASS1','/home/afshin/Images/64.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(65,104,1,9,'Cheyenne - The Complete First Season (1955)','AVAILABLE',3.00,12.99,8.99,3,'CLASS1','/home/afshin/Images/65.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(66,110,1,9,'Rawhide - The Complete First Season (1959)','AVAILABLE',3.00,12.99,8.99,3,'CLASS1','/home/afshin/Images/66.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1),(67,102,1,9,'Colt .45 / Tall Man Riding / Fort Worth (1950)','AVAILABLE',3.00,12.99,8.99,3,'CLASS1','/home/afshin/Images/67.jpg',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0','2020-10-25','0','2020-10-25',1);
/*!40000 ALTER TABLE `PRODUCTS_BASE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `PRODUCT_CATEGORIES`
--

DROP TABLE IF EXISTS `PRODUCT_CATEGORIES`;
/*!50001 DROP VIEW IF EXISTS `PRODUCT_CATEGORIES`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `PRODUCT_CATEGORIES` (
  `CATEGORY_NAME` tinyint NOT NULL,
  `CATEGORY_DESCRIPTION` tinyint NOT NULL,
  `CATEGORY_ID` tinyint NOT NULL,
  `PARENT_CATEGORY_ID` tinyint NOT NULL,
  `CATEGORY_LOCKED_FLAG` tinyint NOT NULL,
  `IMAGE` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `PRODUCT_CATEGORIES_BASE`
--

DROP TABLE IF EXISTS `PRODUCT_CATEGORIES_BASE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PRODUCT_CATEGORIES_BASE` (
  `CATEGORY_ID` int(15) NOT NULL,
  `PARENT_CATEGORY_ID` int(15) DEFAULT NULL,
  `CATEGORY_LOCKED_FLAG` varchar(1) NOT NULL DEFAULT 'N',
  `REPRESENTATIVE_PRODUCT_ID` int(15) DEFAULT NULL,
  `CREATED_BY` varchar(60) NOT NULL,
  `CREATION_DATE` date NOT NULL,
  `LAST_UPDATED_BY` varchar(60) NOT NULL,
  `LAST_UPDATE_DATE` date NOT NULL,
  `OBJECT_VERSION_ID` int(15) NOT NULL,
  PRIMARY KEY (`CATEGORY_ID`),
  KEY `PRODUCT_CATEGORIES_FK` (`PARENT_CATEGORY_ID`),
  KEY `REPRESENTATIVE_PRODUCT_FK` (`REPRESENTATIVE_PRODUCT_ID`),
  CONSTRAINT `PRODUCT_CATEGORIES_FK` FOREIGN KEY (`PARENT_CATEGORY_ID`) REFERENCES `PRODUCT_CATEGORIES_BASE` (`CATEGORY_ID`),
  CONSTRAINT `REPRESENTATIVE_PRODUCT_FK` FOREIGN KEY (`REPRESENTATIVE_PRODUCT_ID`) REFERENCES `PRODUCTS_BASE` (`PRODUCT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='The classification hierachy for a particular product. Categories can be nested and then a product is assigned to a particular category.  The actual names and descriptions for the categories are held in the separate CATEGORY_TRANSLATIONS table.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PRODUCT_CATEGORIES_BASE`
--

LOCK TABLES `PRODUCT_CATEGORIES_BASE` WRITE;
/*!40000 ALTER TABLE `PRODUCT_CATEGORIES_BASE` DISABLE KEYS */;
INSERT INTO `PRODUCT_CATEGORIES_BASE` VALUES (1,NULL,'N',NULL,'0','2020-10-25','0','2020-10-25',1),(2,NULL,'N',NULL,'0','2020-10-25','0','2020-10-25',1),(3,NULL,'N',NULL,'0','2020-10-25','0','2020-10-25',1),(4,3,'N',NULL,'0','2020-10-25','0','2020-10-25',1),(5,3,'N',NULL,'0','2020-10-25','0','2020-10-25',1),(6,3,'N',NULL,'0','2020-10-25','0','2020-10-25',1),(7,3,'N',NULL,'0','2020-10-25','0','2020-10-25',1),(8,1,'N',NULL,'0','2020-10-25','0','2020-10-25',1),(9,1,'N',NULL,'0','2020-10-25','0','2020-10-25',1),(10,1,'N',NULL,'0','2020-10-25','0','2020-10-25',1),(11,1,'N',NULL,'0','2020-10-25','0','2020-10-25',1),(12,2,'N',NULL,'0','2020-10-25','0','2020-10-25',1),(13,2,'N',NULL,'0','2020-10-25','0','2020-10-25',1),(14,2,'N',NULL,'0','2020-10-25','0','2020-10-25',1);
/*!40000 ALTER TABLE `PRODUCT_CATEGORIES_BASE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PRODUCT_IMAGES`
--

DROP TABLE IF EXISTS `PRODUCT_IMAGES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PRODUCT_IMAGES` (
  `PRODUCT_IMAGE_ID` int(15) NOT NULL,
  `PRODUCT_ID` int(15) NOT NULL,
  `DEFAULT_VIEW_FLAG` varchar(1) NOT NULL DEFAULT 'N',
  `DETAIL_IMAGE_ID` int(15) DEFAULT NULL,
  `IMAGE` blob NOT NULL,
  `CREATED_BY` varchar(60) NOT NULL,
  `CREATION_DATE` date NOT NULL,
  `LAST_UPDATED_BY` varchar(60) NOT NULL,
  `LAST_UPDATE_DATE` date NOT NULL,
  `OBJECT_VERSION_ID` int(15) NOT NULL,
  PRIMARY KEY (`PRODUCT_IMAGE_ID`),
  KEY `PRODUCT_IMAGES_FK` (`DETAIL_IMAGE_ID`),
  KEY `PRODUCT_IMAGES_PRODUCTS_FK` (`PRODUCT_ID`),
  CONSTRAINT `PRODUCT_IMAGES_FK` FOREIGN KEY (`DETAIL_IMAGE_ID`) REFERENCES `PRODUCT_IMAGES` (`PRODUCT_IMAGE_ID`),
  CONSTRAINT `PRODUCT_IMAGES_PRODUCTS_FK` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `PRODUCTS_BASE` (`PRODUCT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Images of each product. A product many have several images available, only one of which will be marked as primary. Imgaes may also be thumbnails in which case the detailed version is pointed to by the DETAIL_IMAGE_ID';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PRODUCT_IMAGES`
--

LOCK TABLES `PRODUCT_IMAGES` WRITE;
/*!40000 ALTER TABLE `PRODUCT_IMAGES` DISABLE KEYS */;
/*!40000 ALTER TABLE `PRODUCT_IMAGES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PRODUCT_IMAGE_SEQ`
--

DROP TABLE IF EXISTS `PRODUCT_IMAGE_SEQ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PRODUCT_IMAGE_SEQ` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) unsigned NOT NULL,
  `cycle_option` tinyint(1) unsigned NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB SEQUENCE=1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PRODUCT_IMAGE_SEQ`
--

LOCK TABLES `PRODUCT_IMAGE_SEQ` WRITE;
/*!40000 ALTER TABLE `PRODUCT_IMAGE_SEQ` DISABLE KEYS */;
INSERT INTO `PRODUCT_IMAGE_SEQ` VALUES (68,1,9223372036854775806,68,1,1000,0,0);
/*!40000 ALTER TABLE `PRODUCT_IMAGE_SEQ` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PRODUCT_SEQ`
--

DROP TABLE IF EXISTS `PRODUCT_SEQ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PRODUCT_SEQ` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) unsigned NOT NULL,
  `cycle_option` tinyint(1) unsigned NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB SEQUENCE=1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PRODUCT_SEQ`
--

LOCK TABLES `PRODUCT_SEQ` WRITE;
/*!40000 ALTER TABLE `PRODUCT_SEQ` DISABLE KEYS */;
INSERT INTO `PRODUCT_SEQ` VALUES (100,1,9223372036854775806,100,1,1000,0,0);
/*!40000 ALTER TABLE `PRODUCT_SEQ` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PRODUCT_TRANSLATIONS`
--

DROP TABLE IF EXISTS `PRODUCT_TRANSLATIONS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PRODUCT_TRANSLATIONS` (
  `PRODUCT_ID` int(15) NOT NULL,
  `LANGUAGE` varchar(30) NOT NULL,
  `SOURCE_LANG` varchar(30) DEFAULT NULL,
  `DESCRIPTION` varchar(4000) NOT NULL,
  `ADDITIONAL_INFO` varchar(4000) DEFAULT NULL,
  `CREATED_BY` varchar(60) NOT NULL,
  `CREATION_DATE` date NOT NULL,
  `LAST_UPDATED_BY` varchar(60) NOT NULL,
  `LAST_UPDATE_DATE` date NOT NULL,
  `OBJECT_VERSION_ID` int(15) NOT NULL,
  PRIMARY KEY (`PRODUCT_ID`,`LANGUAGE`),
  CONSTRAINT `PRODUCT_TRANSLATIONS_FK` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `PRODUCTS_BASE` (`PRODUCT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Holds the translated names and descriptions of the product. One translation row will exist for each language supported by the system and each product';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PRODUCT_TRANSLATIONS`
--

LOCK TABLES `PRODUCT_TRANSLATIONS` WRITE;
/*!40000 ALTER TABLE `PRODUCT_TRANSLATIONS` DISABLE KEYS */;
INSERT INTO `PRODUCT_TRANSLATIONS` VALUES (1,'EN','EN','The TH-42PX60U 42-inch Diagonal Plasma HDTV gives you deep blacks, bright whites and 29 billion colors -- it\'s an image so close to real life, you\'ll swear you were in your favorite programs instead of just watching them. Enjoy crisp, lifelike details with the up to 10,0001 contrast ratio. \n    Deep blacks provide excellent shadow detail during dark scenes, while brilliant whites render bright scenes with vivid realism. Receive and view local over-the-air broadcasts in stunning HDT, using the built-in HDTV tuner. You can even share your JPEG photos taken with the built-in SD card slot. \n    Features a width-to-height ratio similar to movie theater screens, providing a theater-like experience at home. View HDTV broadcasts and widescreen DVDs the way they were meant to be seen. Native Resolution - 1366 x 768 Contrast Ratio - Up to 10,000 - 1 Progressive Scan Video Noise Reduction Digital Comb Filter Color Purity Optimizer (3D Color Management) \n    Two 20-watt, 8 ohm speakers -- 70Hz - 17kHz, 10% THD Surround Sound Motion Pattern Noise Reduction BBE ViVA HD3D Sound Standard NTSC tuner ATSC/QAM (SDTV and HDTV broadcasts) SD Card Slot and Photo Viewer HDMI-HDCP Interface - 2, in rear Analog Audio Input (for HDMI) - 1 rear Composite Video Input - 3 (2 rear, 1 front) S-Video Inputs - 3 (2 rear, 1 front) \n    Audio Input (for Video) - 3 (2 rear, 1 front) Rear Inputs/Outputs - 2 Component Video (YPbPr), 2 Component Audio out, 1 Composite and Audio out On-screen display languages - English/Spanish/French Timers - Sleep/On/Off Built-in closed-caption decoder Video Input Labeling V-Chip Program Lockout Includes remote control and pedestal stand Unit Dimensions(HxWxD) - 27.8 x 40.2 x 3.7 Unit Weight - 65 lbs','HDMI (High-Definition Multimedia Interface) is a lossless, uncompressed, all-digital audio/video interface to link any AV source with an audio and/or video monitor, such as a digital television (DTV). HDMI supports standard-definition (SD), enhanced definition (ED), or high-definition (HD) video, plus multi-channel digital audio--all using a single cable. \n    If a component doesn\'t have an HDMI connection, you\'ll also get great picture reproduction using the three-jack component video (Y/Pb/Pr) input, which provides separate connections for luminance (Y), blue color difference (PB) and red color difference (PR). This results in increased bandwidth for color information, resulting in a more accurate picture with clearer color reproduction and less bleeding than you would get with S-Video or composite (RCA yellow video plug) connections. \n    Component video output is available only for DVD playback.','0','2020-10-25','0','2020-10-25',0),(2,'EN','EN','Whether you\'re a die-hard PlayStation 2 fan or a new player, this totally redesigned PlayStation 2 console will meet the demands of your game playing. The internal design architecture has been completely overhauled. Internal volume has been reduced by 75 percent, the system\'s overall weight and thickness has been reduced incredibly. \n    The smaller, sleeker design makes it easy to carry around and enjoy games any time, anywhere. It keeps the PS2\'s powerful 300MHz processor, for enhanced clarity and mesmerizing graphics. Also comes with one standard PS2 controller.','MODEL- 97064 VENDOR- SONY PLAYSTATION FEATURES- PlayStation 2 Compact System- Charcoal Black Smaller, Slimmer and Network Ready PlayStation 2! While inheriting the basic functions and design philosophy of the current PlayStation 2 (SCPH-50000), \n    the internal design architecture of the new redesigned PlayStation 2 computer entertainment system (SCPH-70000 CB) model has been completely overhauled, resulting in a slimmer and more lightweight form. \n    Internal volume has been reduced by 75 percent, overall weight has been halved, and thickness trimmed down to 2.8 cm (thickness of current model is 7.8cm). Its size is almost as small as a hardcover book, making it easier to carry around. \n    Equipped with an integrated Ethernet port for network gaming, the PlayStation 2 sets new standards in the fusion of design and functionality. Approximately 40 percent of North American PlayStation 2 online gamers use dial-up connections and to satisfy this base, the North American model is equipped with both Ethernet and modem ports. \n    Includes PlayStation 2 console, Analog Controller (DUALSHOCK 2), AV Cable (integrated audio/video), AC Adaptor (AC power cord included). -- SPECIFICATIONs -- CPU - CPU : 128-bit CPU System Clock Frequency : 294.912 MHz Cache Memory : Instruction: 16KB, Data: 8KB + 16 K (ScrP) Main Memory : Direct Rambus (Direct RDRAM) Memory Size : 32MB Memory Bus Bandw','0','2020-10-25','0','2020-10-25',0),(3,'EN','EN','The unlocked PalmOne Treo 650 boasts all the legendary features of the venerable Treo 600, plus a whole lot more. Now with Bluetooth, a higher resolution screen, a removable battery, and an improved keyboard, the Treo 650 is once again on the cutting edge of Smartphone technology. \n    It offers all the functionality of a high-end Palm OS-powered PDA, a cell phone and a VGA camera. Simply put, it\'s the ultimate mobile office companion.','Get All You Need, All In One Treo 650 PDA Unlocked GSM Phone The Treos 650 smartphone from palmOne makes it easier than ever to stay connected. It simplifies your life by combining a compact mobile phone with email, an organizer, messaging, and web access. \n    Theress also Bluetooths technology so you can connect wirelessly to other Bluetooth devices. Not to mention an MP3 player, a digital camera that captures video, and a vibrant color screen that brings everything to life s all in a device thatss still small enough to fit in your pocket. Seems like Treo smartphones just keep getting smarter. \n    The Treo 650 smartphone looks and feels just like a phone, but itss so much more. Carry thousands of business and personal phone numbers with you, and dial any of them by name from your contacts list. Or enter a name or number on the QWERTY keyboard. \n    Theress even an on-screen dial pad. Speakerphone, speed dial, conference calling, call history, and caller ID make managing all your calls that much easier. \n    Available as a dual-band digital CDMA phone, and as a GSM quad-band world phone. The included VersaMails email client makes it easy to access and manage your email on the go s whether you use a popular desktop email client, IMAP or POP3. View photos, HTML, and even native Microsoft Word, Excel, and PowerPoint attachments. \n    Synchronize your corporate Microsoft Exchange email and calendar with built-in Microsoft Exchange ActiveSyncs','0','2020-10-25','0','2020-10-25',0),(4,'EN','EN','The Palms Treos 700w smartphone delivers everything you need without compromise. It combines a smarter phone with broadband-like speeds2 and rich-media capabilities, all in onesbringing Palm\'s world-class ease of use to the Windows Mobiles platform. Connect with people in multiple wayssby voice, email, SMS, or MMS3. Your contacts are always reachable, from any application. Access email, the web, and corporate networks on one of the fastest networks available in the U.S.2, 3 Or relax and play your favorite music and videos right on your device. With this easy-to-use productivity device in hand, you can stay connected3 on your terms.',NULL,'0','2020-10-25','0','2020-10-25',0),(5,'EN','EN','The sleek and powerful Palm Tungsten E handheld comes packed for business and priced for value.Access your calendar, contacts and important information anywhere. Create and edit Word, Excel and PowerPoint-compatible files on the run. Synchronize with Outlook\'s calendar, contacts, tasks, notes and email right out of the box. Stay productive using updated features to Palm\'s award winning organization software. Listen to MP3s, watch video clips and view photos wherever you go.A powerful ARM processor lets you listen to MP3s while looking up an address or scheduling an appointment. Watch the latest movie trailer or a new sales video. Carry digital photo albums of friends and family, students and co-workers, even the latest real estate listings. Plus it\'s expandable, and with 32MB of memory there\'s plenty of room to customize from more than 18,000 applications (sold separately).',NULL,'0','2020-10-25','0','2020-10-25',0),(6,'EN','EN','This is the original XBOX Microsoft video game system, delivering the most powerful games experiences ever. Xbox empowers game artists by giving them the technology to fulfill their creative visions as never before, creating games that blur the lines between fantasy and reality. The Xbox video game system and controller are designed to capture the power and performance that Xbox will deliver and are based on the input of more than 5,000 gamers and games creators from around the world. Sleek and powerful in its look, in a rich shade of black, the Xbox video game system is emblazoned with a large \"X\" and a signature green Xbox \"jewel\" positioned in its center. Four game controller ports that allow easy multiplayer gaming and enable other peripherals, ranging from game pads to voice-activated headsets. A front-loading DVD tray. A multisignal audio-video connector that allows for easy hookup to televisions and home theater systems. \n    An Ethernet port for rich, fast-action online gaming via a broadband connection. An NVIDIA graphics processing unit (GPU), delivering superior graphic performance. An Intel 733MHz processor, the most powerful CPU of any console. An internal hard drive, for massive storage of game information - a first in the console gaming industry.',NULL,'0','2020-10-25','0','2020-10-25',0),(7,'EN','EN','Xbox 360 sets a new pace for digital entertainment. More than just a cutting-edge game system, Xbox 360 also integrates high-definition video, DVD movie playback, digital music, photos, and online connectivity into one sleek, small tower.','Includes: Xbox 360 Console, 1 Wireless Xbox 360 Controller, Hard Drive, Headset, Standard A/V Cable, Faceplate, and Silver Xbox Live.The Xbox 360 System is the way to begin experiencing the ultimate in next-generation gaming. Amazing Digital entertainment experiences, unprecedented in home console entertainment, are waiting for you -- all you have to do is connect the controller to this incredible device and an unsurpassed level of adventure and excitement is yours. \n    Connect up to 4 wireless game controllers Online optimization - The XBox 360 is Wi-Fi ready (802.11a, b and g), has a built-in Ethernet port and has out-of-the-box access to Xbox Live Full digital media support - Plays DVD-Video, DVD-ROM, DVD-R/RW, DVD+R/RW, CD-DA, CD-ROM, CD-R, CD-RW, WMA CD, MP3 CD, JPEG Photo CD Streams media from portable MP3 players or a Windows XP based PC 3 USB 2.0 ports, two memory unit slots Multi-channel Surround sound,\n    Supports 48KHz 16-Bit Audio Stands vertically or horizontally Interchangeable face plates personalize your XBox 360 console Dimensions(HxWxD) - 3.27 x 12.17 x 10.16 (83 x 309 x 258 mm) Weight - 7.7 lbs (3.49 Kg)','0','2020-10-25','0','2020-10-25',0),(8,'EN','EN','The era of no-compromises handheld gaming has arrived. Get ready for immersive, 3D gaming on a console that is poised to change the way we think about portable devices. \n    With wireless internet, video and digital music playback, and incredible data storage and connectivity options, the Sony PSP--or PlayStation Portable--is a complete solution for the mobile digital lifestyle. Sony has hit the mark by combining both horsepower and groundbreaking features into a package that weighs just a hair more than half a pound.','The awe and excitement that has made Sony Playstation so popular as a TV game now lets you take it on the road and do more than you magined. The PSP is more than a portable version of Playstation. It\'s a portable entertainment center with MP3 and MP4 download and play capabilities. \n    This nearly pocketable portable has a built-in, bright, high-resolution 4.3 inch (diagonal) color TFT LCD widescreen (for 16:9 perspective), built-in stereo speakers, and amazing connectivity. With an integrated 802.11b WiFi processor, you can share your online games over wireless networks - where available. \n    In addition to playing exciting games exclusively designed for the PSP on its UMD drive, there are also a number of movies available. UMD is a small, high-capacity optical disc that allows up to 1.8 GB - providing an extremely versatile format for games, music, and video. A built-in USB 2.0 slot enables computer connectivity for downloading music as ATRAC and MP3 files, video as MP4 files, photos as JPEG and online connectivity. Files may also be stored on MemoryStick Duo digital-media cards. \n    Built-in stereo speakers Input / Output Connectivity - 1 audio out, 1 microphone in, 1 control connector, 1 x USB 2.0, 1 Memory Stick Pro Duo slot, IrDA wireless, IR remote (allows simultaneous multiple PSPs to be connected) / Integrated Communications - 802.11b Wi-Fi Sony Proprietary UMD Drive Power - PSP\'s battery is a removable, rechargeable lithium-ion battery. It\'s possible to charge the PSP while using the system Control Buttons - Square, Triangle, X, and Circle face buttons, a digital pad, start, select, an analog thumb stick and two shoulder buttons on the top / Brightness control and Sound mode selectors.\n    Built-in copyright protection system utilizes a combination of a unique disc ID, a 128-bit AES encryption key for media, and individual ID for each PSP unit','0','2020-10-25','0','2020-10-25',0),(9,'EN','EN','Lighter, brighter and just as fun as the original Nintendo DS, the Nintendo DS Lite arrives just in time for hungry gamers. It\'s smaller than the original DS, with brighter screens and adjustable backlighting. The DS Lite sets itself apart from every other hand-held gaming system on the market with a variety of new features. Center microphone Larger stylus for a better grip Easy-to-reach Start and Select buttons Removable cover keeps the Game Boy Advance cartridge slot clear from dust and debris when not in use Color - Polar White',NULL,'0','2020-10-25','0','2020-10-25',0),(10,'EN','EN','Zune is here. Designed around the principles of sharing, discovery and community, Zune will create new ways for people to connect and share entertainment experiences. The Zune experience centers around connection-- connection to your library, connection to friends, connection to community and connection to other devices. Zune starts with a 30GB digital media player and adds a twist. You can wirelessly share selected full-length sample tracks, playlists, pictures or your home-grown tracks directly from Zune to Zune. The Zune has arrived, sporting sharing features that may revolutionize the way we experience music. You can listen to the full-length songs that you receive up to three times in three days, flag the ones you like and easily buy them the next time you sync up. You can discover new music in the Zune Marketplace, and show off your favorite pictures and videos on the big, bright screen. Zune stores up to 7,500 songs, 25,000 pictures or 100 hours of video. You can make playlists on the go and watch a slide show while you\'re listening. Watching video in landscape mode gets the most out of the vivid display. Zune has all that and a built in FM tuner, too. Zune comes in three colors: black, brown and white.','The Digital Media Player reinvented. With the new Microsoft Zune you can wirelessly share selected full-length sample tracks, playlists, pictures or your home-grown tracks directly from Zune to Zune. Listen to those received full-length songs up to three times in three days, with the option to flag the ones you like to easily purchase them the next time you sync up. Browse the Zune Marketplace for access to millions of songs, old and new. Use the bright 3\" LCD screen to watch your favorite videos or browse pictures of your family and friends. 30GB of storage means plenty of space for your music, photos, and videos. Never grow tired of your music with a built-in FM tuner for access to local FM radio broadcasts. Reinvent your digital media experience with the Microsoft Zune! Import unprotected music, photos and videos in WMA, MP3, AAC, JPEG, WMV, MPEG-4, H.264 from iTunes and Windows Media Player Purchase music from the continually updated Zune Marketplace using 79 Microsoft Points to purchase individual songs, or use a Zune Pass subscription for unlimited access to millions of songs for just $14.99 a month (Microsoft Points cards sold separately for purchasing music without a credit card) Optional Zune Car Pack allows you to play your tunes in your car with an FM transmitter with AutoSeek and Car Charger (Sold separately) Easily update your Zune via your PC when updates become available to add more features! Up to 12 hour battery life playing music with WiFi off Dimensions - 4.4 x 2.4 x 0.58 Weight - 5.6 ounces 1 Year limited manufacturer\'s warranty Requires Windows XP with Service Pack 2 and High Speed Internet Connectivity','0','2020-10-25','0','2020-10-25',0),(11,'EN','EN','Thin is definitely in. At just over a half-inch thick, the Motorola RAZR V3 is the perfect combination of sleek design and powerful features. And now you can get it dressed in gorgeous black. This special edition version kicks the style up a notch and demands attention. With long-range Bluetooth, support for video playback, a VGA (640 x 480) camera and a gorgeous color screen, the RAZR V3 is everything you\'re looking for in a stylish mobile companion. Get the most out of your Cingular service with this impressive quad-band phone.','The Moto Razr V3 is expertly crafted to deliver exceptional performance. Inside the ultra-thin design are advanced features like MPEG4 video playback, Bluetooths wireless technology, a digital camera and more. And with the precision-cut keypad, minimalist styling and metal finish, the V3 looks just as beautiful as it performs. The real difference is in the details. See whoss calling, in color, without opening your phone s the large internal display is complemented by an impressive external display. The precision-cut metal keypad reacts to the lightest of touches. And the features you can\'t always see are equally impressive, like quad-band GSM s for global calls where GSM network coverage and roaming agreements are present.','0','2020-10-25','0','2020-10-25',0),(12,'EN','EN','The Creative Nomad MuVos combines cutting-edge, high-capacity 1-inch hard disk drive storage, high-speed loading, and superb sound quality in a remarkably compact, easy-to-use package. Load up to 2,100 songs (based on 3.5 minutes per song, WMA/64 kbps with 4 GB storage) with simple plug-and-play, drag-and-drop functionality. Transfer any music or data files in a flash with super-fast USB 2.0. Enjoy high-fidelity sound with specifications unmatched by other MP3 and WMA players. The Nomad MuVos is a perfect blend of capacity, style, versatility, and ease of use in a tiny player for the active music lover. Grab it, load it, and you\'re all set to go!','The Creative NOMAD MuVo? combines cutting-edge high capacity 1\" hard disk drive storage, high-speed loading and superb sound quality in a remarkably compact, easy to use package. Load up to 2100 songs (based on 3.5 min per song, WMA / 64kbps with 4GB storage) with simple plug-and-play, drag-and-drop functionality. Transfer any music or data files in a flash with super fast USB2.0. Enjoy high fidelity sound with specifications unmatched by other MP3 and WMA players. The NOMAD MuVo? is a perfect blend of capacity, style, versatility and ease of use in a tiny player for the active music lover. Grab it, load it, clip it on your belt and you\'re all set to go!','0','2020-10-25','0','2020-10-25',0),(13,'EN','EN','SyNEt\'s TBW-101UB Bluetooth USB Adapter allows you to make short-range wireless connections between your computer and Bluetooth enabled devices such as Cellular Phone, PDA, and Computer. It is compact and portable, eliminating the need for cables and physical connections between electronic devices. The Bluetooth USB Adapter transmission ensures both protection from interference and secured data transfers. Simply plug the USB Adapter into the USB port and enjoy the freedom and flexibility of Bluetooth wireless technology.',NULL,'0','2020-10-25','0','2020-10-25',0),(14,'EN','EN','Streamlined and sophisticated, the Bluetooth Headset H500 provides wireless connectivity and convenience. Combining an ergonomic design and versatile ear hook, this sleek headset can be worn on either ear. Created to be ultra comfortable, the Motorola H500 is so easy to wear that you\'ll forget you even have it on! But don\'t be fooled by its good looks - this petite powerhouse provides impressive battery power to boot and an omni-directional microphone to clearly pick up your voice. A perfect companion for a variety of Bluetooth compatible 1.2- and 1.1-enabled mobile phones, the Motorola H500 is a must-have accessory for communicating in style. \n    The Motorola H500 works with you to help you communicate on the go - connecting with devices up to 30 feet away. Or give your mobile a rest and connect with your Bluetooth-enabled PC for hands-free Voice over IP VoIP use. Offering improved comfort and sound quality over its predecessor, the Motorola H500 provides a sleek, ergonomic design that fits to your ear, allowing for comfortable wear over extended periods and providing an enhanced seal for outstanding audio performance. Style and comfort are only part of this package - the headset boasts up to 8 hours of talk time or 130 hours of standby time from a single charge, giving you plenty of juice for all of your wireless connections! \n    Whether you are managing the office or party planning on-the-go, the Motorola H500 is perfect for multi-tasking with flair. Equipped with a multifunction button it\'s easy to place, receive or end calls - all from one button! Advanced volume controls include orientation technology to assure that volume controls will always be upright Blue LED light to notify when the headset is in use, or turn off this feature if you choose Bluetooth 1.2 provides quicker pairing, better audio with less dropped calls and reduced interference from other devices Skype certified',NULL,'0','2020-10-25','0','2020-10-25',0),(15,'EN','EN','The Portable Audio System for iPod and iPod Photo allows you to play your iPod through a portable speaker system. Just put your iPod in the dock, then press play. It\'s that easy. The revolutionary MaxxBass technology creates quality bass without a subwoofer, and the built-in docking station provides the same synchronization, data transfer, and recharging options as your iPod dock. The convenient secondary input jack provides for connection with other audio devices, including laptops, older iPods, and other MP3 players. The IM3C fits, syncs, and charges the iPod, iPod photo, iPod mini, and iPod nano players.',NULL,'0','2020-10-25','0','2020-10-25',0),(16,'EN','EN','The Creative Zen Vision W Multimedia Player lets you take all your movies, music and photos in a light, pocket-sized device that is loaded with 30 or 60 GB of memory. At this capacity you can carry tens of thousands of photos, 240 hours of movies (500 Kbps MPEG4-SP), or up to 30,000 songs (WMA encoded at 64 Kbps), all in the palm of your hand. You can also tune in the radio (32 station presets), record your favorite talk show, or make personal voice memos with the built-in microphone. And the big news about the Vision W is that it displays your media in a widescreen, 16:9 format.',NULL,'0','2020-10-25','0','2020-10-25',0),(17,'EN','EN','Apple iPod - Continuing its tradition of hardware and software innovation and design, Apple has released a new iPod that surpasses the last. This update to the 5th generation iPod with video playback features a huge 80GB hard drive - the largest yet! With iTunes 7 ushering in movie and game downloads, there\'s more than enough content to satisfy this beast of a media player. You also get a 2.5\" display that is now 60% brighter, a higher capacity battery for up to 20 hrs. of music and 6.5 hrs. of video, and a set of newly designed iPod earbuds. Ports - dock connector, Stereo minijack, composite video and audio through minijack Connectivity - USB through dock connector, composite video (with A/V cable - sold separately), and audio through headphone jack or line out on the iPod Universal Dock (sold separately) \n    Charge Time - about 4 hrs. (2 hrs. fast charge to 80% capacity) Audio Support - AAC (16 to 320 Kbps), Protected AAC (from iTunes Music Store), MP3 (16 to 320 Kbps), MP3 VBR, Audible (formats 2, 3, and 4), Apple Lossless, WAV, and AIFF Photo Support - syncs iPod-viewable photos in JPEG, BMP, GIF, TIFF, PSD (Mac only), and PNG formats Video Support - H.264 video - up to 768 Kbps, 320 x 240, 30 fps, Baseline Profile up to Level 1.3 with AAC-LC up to 160 Kbps, 48 Khz, stereo audio in. m4v,. mp4 and. mov file formats / MPEG-4 video - up to 2.5 mbps, 480 x 480, 30 fps, Simple Profile with AAC-LC up to 160 Kbps, 48 Khz, stereo audio in. m4v,. mp4 and. mov file formats Backlight Timer Sleep Timer 20 Equalizer Settings Shuffle Songs or Albums Date and Time Unit Dimensions - 4.1 x 2.4 x 0.55 Unit Weight - 5.5 oz.',NULL,'0','2020-10-25','0','2020-10-25',0),(18,'EN','EN','The Apple 1 GB Shuffle is the world\'s smallest digital music player that lets you wear up to 240 songs on your sleeve, or your lapel, or your belt--it\'s so small you can wear it just about anywhere. Clip on iPod Shuffle and wear it as a badge of musical devotion. And with the shuffle\'s anodized aluminum enclosure it is durable and goes with almost any outfit. About the size of a matchbook, the iPod Shuffle measures up nicely. Just clip it and go. It comes with a teeny little docking station. Although the Shuffle comes in a small package, 1.62 inches long and about half an ounce, it still holds a lot of music, and you can count on your Shuffle to keep on rocking for up to 12 continuous hours. \n    Use iTunes to import your CDs, shop for songs on the iTunes Store, and then sync them to your iPod Shuffle. \n    And if you have more than 240 songs in your iTunes library, let iTunes autofill your Shuffle and get a new musical experience every time.',NULL,'0','2020-10-25','0','2020-10-25',0),(19,'EN','EN','Apple iPod - Continuing its tradition of hardware and software innovation and design, Apple has released a new iPod that surpasses the last. This update to the 5th generation iPod with video playback features a huge 80GB hard drive - the largest yet! \n    With iTunes 7 ushering in movie and game downloads, there\'s more than enough content to satisfy this beast of a media player. You also get a 2.5\" display that is now 60% brighter, a higher capacity battery for up to 20 hrs. of music and 6.5 hrs. of video, and a set of newly designed iPod earbuds. Ports - dock connector, Stereo minijack, composite video and audio through minijack Connectivity - USB through dock connector, composite video (with A/V cable - sold separately), and audio through headphone jack or line out on the iPod Universal Dock (sold separately) \n    Charge Time - about 4 hrs. (2 hrs. fast charge to 80% capacity) Audio Support - AAC (16 to 320 Kbps), Protected AAC (from iTunes Music Store), MP3 (16 to 320 Kbps), MP3 VBR, Audible (formats 2, 3, and 4), Apple Lossless, WAV, and AIFF Photo Support - syncs iPod-viewable photos in JPEG, BMP, GIF, TIFF, PSD (Mac only), and PNG formats Video Support - H.264 video - up to 768 Kbps, 320 x 240, 30 fps, Baseline Profile up to Level 1.3 with AAC-LC up to 160 Kbps, 48 Khz, stereo audio in. m4v,. mp4 and. mov file formats / MPEG-4 video - up to 2.5 mbps, 480 x 480, 30 fps, Simple Profile with AAC-LC up to 160 Kbps, 48 Khz, stereo audio in. m4v,. mp4 and. mov file formats Backlight Timer Sleep Timer 20 Equalizer Settings Shuffle Songs or Albums Date and Time Unit Dimensions - 4.1 x 2.4 x 0.55 Unit Weight - 5.5 oz.',NULL,'0','2020-10-25','0','2020-10-25',0),(20,'EN','EN','Apple iPod - Continuing its tradition of hardware and software innovation and design, Apple has released a new iPod that surpasses the last. This update to the 5th generation iPod with video playback features a huge 80GB hard drive - the largest yet! With iTunes 7 ushering in movie and game downloads, there\'s more than enough content to satisfy this beast of a media player. You also get a 2.5\" display that is now 60% brighter, a higher capacity battery for up to 20 hrs. of music and 6.5 hrs. of video, and a set of newly designed iPod earbuds. Ports - dock connector, Stereo minijack, composite video and audio through minijack Connectivity - USB through dock connector, composite video (with A/V cable - sold separately), and audio through headphone jack or line out on the iPod Universal Dock (sold separately) Charge Time - about 4 hrs. (2 hrs. fast charge to 80% capacity) Audio Support - AAC (16 to 320 Kbps), Protected AAC (from iTunes Music Store), MP3 (16 to 320 Kbps), MP3 VBR, Audible (formats 2, 3, and 4), Apple Lossless, WAV, and AIFF Photo Support - syncs iPod-viewable photos in JPEG, BMP, GIF, TIFF, PSD (Mac only), and PNG formats Video Support - H.264 video - up to 768 Kbps, 320 x 240, 30 fps, Baseline Profile up to Level 1.3 with AAC-LC up to 160 Kbps, 48 Khz, stereo audio in. m4v,. mp4 and. mov file formats / MPEG-4 video - up to 2.5 mbps, 480 x 480, 30 fps, Simple Profile with AAC-LC up to 160 Kbps, 48 Khz, stereo audio in. m4v,. mp4 and. mov file formats Backlight Timer Sleep Timer 20 Equalizer Settings Shuffle Songs or Albums Date and Time Unit Dimensions - 4.1 x 2.4 x 0.55 Unit Weight - 5.5 oz.',NULL,'0','2020-10-25','0','2020-10-25',0),(21,'EN','EN','Includes: earbud headphones, USB 2.0 cable, dock adapter, case, iTunes for Windows and Mac, and more. Come one, come all and witness the incredible shrinking iPod! With the nano, Apple introduces the latest member of the highly successful iPod family of digital audio players. The nano is aptly named since it\'s a fraction of the size of its larger iPod cousins. It is the width of a pencil and comes in at a feather-light 1.5 ounces. For Apple\'s next trick, they\'ve taken this new, diminutive iPod and added all of the features of a regular iPod. You get a bright, full-color display, Apple\'s famous Click Wheel, and up to 14 hours of battery life. With that said, take a peek behind the curtain and be amazed at the rest of what the iPod nano has to offer: Connector for optional dock; stereo minijack; charge time: about 3 hours (1.5 hour fast charge to 80% capacity); AAC (16 to 320 Kbps); Protected AAC (from iTunes Music Store); MP3 (16 to 320 Kbps); MP3 VBR; Audible (formats 2, 3, and 4); Apple Lossless; WAV; AIFF; photo support: JPEG/BMP/GIF/TIFF/PSD (Mac only)/PNG; sync and charge via USB cable; adjust audiobook playback speed; create multiple on-the-go playlists; shuffle songs or albums; repeat one or all; 20 equalizer settings; backlight timer; display contrast; alarm; sleep timer; date and time; display time in menu bar; supports Windows 2000 with Service Pack 4 or later, Windows XP Home or Professional with Service Pack 2 or later, Mac OS X v10.3.4 or later; unit dimensions: 3.5 x 1.6 x 0.27; unit weight: 1.5 ounces. ',NULL,'0','2020-10-25','0','2020-10-25',0),(22,'EN','EN','Includes: earbud headphones, USB 2.0 cable, dock adapter, case, iTunes for Windows and Mac, and more. Come one, come all and witness the incredible shrinking iPod! With the nano, Apple introduces the latest member of the highly successful iPod family of digital audio players. The nano is aptly named since it\'s a fraction of the size of its larger iPod cousins. It is the width of a pencil and comes in at a feather-light 1.5 ounces. For Apple\'s next trick, they\'ve taken this new, diminutive iPod and added all of the features of a regular iPod. You get a bright, full-color display, Apple\'s famous Click Wheel, and up to 14 hours of battery life. With that said, take a peek behind the curtain and be amazed at the rest of what the iPod nano has to offer: Connector for optional dock; stereo minijack; charge time: about 3 hours (1.5 hour fast charge to 80% capacity); AAC (16 to 320 Kbps); Protected AAC (from iTunes Music Store); MP3 (16 to 320 Kbps); MP3 VBR; Audible (formats 2, 3, and 4); Apple Lossless; WAV; AIFF; photo support: JPEG/BMP/GIF/TIFF/PSD (Mac only)/PNG; sync and charge via USB cable; adjust audiobook playback speed; create multiple on-the-go playlists; shuffle songs or albums; repeat one or all; 20 equalizer settings; backlight timer; display contrast; alarm; sleep timer; date and time; display time in menu bar; supports Windows 2000 with Service Pack 4 or later, Windows XP Home or Professional with Service Pack 2 or later, Mac OS X v10.3.4 or later; unit dimensions: 3.5 x 1.6 x 0.27; unit weight: 1.5 ounces. ',NULL,'0','2020-10-25','0','2020-10-25',0),(23,'EN','EN','Includes: earbud headphones, USB 2.0 cable, dock adapter, case, iTunes for Windows and Mac, and more. Come one, come all and witness the incredible shrinking iPod! With the nano, Apple introduces the latest member of the highly successful iPod family of digital audio players. The nano is aptly named since it\'s a fraction of the size of its larger iPod cousins. It is the width of a pencil and comes in at a feather-light 1.5 ounces. For Apple\'s next trick, they\'ve taken this new, diminutive iPod and added all of the features of a regular iPod. You get a bright, full-color display, Apple\'s famous Click Wheel, and up to 14 hours of battery life. With that said, take a peek behind the curtain and be amazed at the rest of what the iPod nano has to offer: Connector for optional dock; stereo minijack; charge time: about 3 hours (1.5 hour fast charge to 80% capacity); AAC (16 to 320 Kbps); Protected AAC (from iTunes Music Store); MP3 (16 to 320 Kbps); MP3 VBR; Audible (formats 2, 3, and 4); Apple Lossless; WAV; AIFF; photo support: JPEG/BMP/GIF/TIFF/PSD (Mac only)/PNG; sync and charge via USB cable; adjust audiobook playback speed; create multiple on-the-go playlists; shuffle songs or albums; repeat one or all; 20 equalizer settings; backlight timer; display contrast; alarm; sleep timer; date and time; display time in menu bar; supports Windows 2000 with Service Pack 4 or later, Windows XP Home or Professional with Service Pack 2 or later, Mac OS X v10.3.4 or later; unit dimensions: 3.5 x 1.6 x 0.27; unit weight: 1.5 ounces. ',NULL,'0','2020-10-25','0','2020-10-25',0),(24,'EN','EN','The world\'s best-designed and easiest-to-use desktop just got faster. Now with the Intel Core Duo processor with two execution cores on a single chip--iMac brings a new generation of power to the amazing things it can do.','Includes: Apple Remote, Apple Keyboard, Mighty Mouse, Mac OS X v10.4 Tiger, iLife \'06, Front Row, and Photo Booth. \n    Apple iMac with Intel Core Duo - Never judge a book by it\'s cover. A very appropriate phrase when talking about the new Apple iMac. On the outside it looks identical to the previous iMac desktop computer. The difference now lies at the heart of the latest iteration of the iMac. Powering the new all-in-one desktop is an Intel Core Duo! Dual processors on a single chip that gives you double the speed of the old iMac. With the new iMac you also get unique software applications. iLife \'06 is a suite of applications that will make your everyday life easier to manage than ever before. \n    And Front Row, combined with the included remote, lets you enjoy the media on your iMac from any seat in the house. Slot-loading 8x SuperDrive with 2.4x Dual Layer burning Write Speeds - up to 2.4x Dual Layer DVD+R, 8x DVD+R, 8x DVD-R, 4x DVD+RW, 4x DVD-RW, 24x CD-R, 8x CD-RW Read Speeds - up to 8x DVD-ROM, 24x CD-ROM Built-in 17 widescreen TFT active-matrix LCD Native Resolution - 1440x900 Built-in iSight webcam ATI Radeon X1600 graphics with 128MB of GDDR3 memory Ports - 10/100/1000Base-T Ethernet, 2 Firewire 400, 3 USB 2.0, 2 USB 1.1 (1 on keyboard), mini-DVI, DVI Out, VGA Out, S-Video Out, and Composite Out Built-in AirPort Extreme 802.11g Wi-Fi wireless network adapter Built-in Bluetooth 2.0+EDR Module Unit Weight - approx. 15.5 lbs.','0','2020-10-25','0','2020-10-25',0),(25,'EN','EN','The world\'s best-designed and easiest-to-use desktop just got faster. Now with the Intel Core Duo processor with two execution cores on a single chip--iMac brings a new generation of power to the amazing things it can do.','Includes: Apple Remote, Apple Keyboard, Mighty Mouse, Mac OS X v10.4 Tiger, iLife \'06, Front Row, and Photo Booth. \n    Apple iMac with Intel Core Duo - Never judge a book by it\'s cover. A very appropriate phrase when talking about the new Apple iMac. On the outside it looks identical to the previous iMac desktop computer. The difference now lies at the heart of the latest iteration of the iMac. Powering the new all-in-one desktop is an Intel Core Duo! Dual processors on a single chip that gives you double the speed of the old iMac. With the new iMac you also get unique software applications. iLife \'06 is a suite of applications that will make your everyday life easier to manage than ever before. \n    And Front Row, combined with the included remote, lets you enjoy the media on your iMac from any seat in the house. Slot-loading 8x SuperDrive with 2.4x Dual Layer burning Write Speeds - up to 2.4x Dual Layer DVD+R, 8x DVD+R, 8x DVD-R, 4x DVD+RW, 4x DVD-RW, 24x CD-R, 8x CD-RW Read Speeds - up to 8x DVD-ROM, 24x CD-ROM Built-in 17 widescreen TFT active-matrix LCD Native Resolution - 1440x900 Built-in iSight webcam ATI Radeon X1600 graphics with 128MB of GDDR3 memory Ports - 10/100/1000Base-T Ethernet, 2 Firewire 400, 3 USB 2.0, 2 USB 1.1 (1 on keyboard), mini-DVI, DVI Out, VGA Out, S-Video Out, and Composite Out Built-in AirPort Extreme 802.11g Wi-Fi wireless network adapter Built-in Bluetooth 2.0+EDR Module Unit Weight - approx. 15.5 lbs.','0','2020-10-25','0','2020-10-25',0),(26,'EN','EN','Live the digital life in stylish simplicity--up to five times faster. Just 6.5 inches square and 2 i nches small, Mac mini lets you have more fun with your music, photos and movies, more quickly and mo re easily. Enjoy them up close or far away with the included Apple Remote. The most affordable way t o Intel Core Duo, iLife s06, and Front Row.','Apple MA607LL/A Mac mini Desktop Computer - Apple is known around the world for its innovative computer design, and with the Mac mini they give you a powerful desktop computer in a case that\'s roughly the size of a lunchbox. But this is the best looking lunchbox you\'ve ever seen, with its sleek, anodized aluminum enclosure, slot-loading optical drive and an array of ports on the rear section that makes cable management a breeze. Inside the Mac mini, you\'ll find a powerful Intel Core Duo Processor 1.66GHz, 512MB of PC2-5300 DDR2 SDRAM, a 60GB SATA Hard Drive, and much more. 60GB 5400RPM SATA HDD Slot-Loading DVD-ROM/CD-RW Combo Drive - (write speeds) up to 24x CD-R and 16x CD-RW Slot-Loading DVD-ROM/CD-RW Combo Drive - (read speeds) up to 8x DVD-ROM and 24x CD-ROM Intel GMA 950 graphics processor with 64MB of shared memory (memory is shared with the main system) \n    Ports - 10/100/1000 Gigabit Ethernet, 1 FireWire 400, 4 USB 2.0, 1 DVI Out, 1 VGA Out (w/ included adapter), 1 S-Video and Composite Video Out, combined Optical Digital Audio In/Audio Line In, and Combined Optical Digital Audio Out/Headphone Out Built-in Speakers Built-in AirPort Extreme 802.11g Wi-Fi Wireless Network Adapter Built-in Bluetooth 2.0+EDR (Enhanced Data Rate) module Unit Dimensions - 2 (h) x 6.5 (w) x 6.5 (d) Unit Weight - 2.9 lbs.','0','2020-10-25','0','2020-10-25',0),(27,'EN','EN','Miraculously engineered, the ultralight 17-inch PowerBook G4 is a mere 1-inch thin and only 6.9 pounds, making it one of the planet\'s thinnest, lightest, 17-inch notebooks. The first thing you\'ll notice is the megawide display -- the largest ever in a notebook. This PowerBook\'s stunning display gives you the same viewing area as a 19-inch CRT monitor. And as for the amount of information you can see on the screen at one time, the 17-inch PowerBook supports a resolution of 1440 x 900 pixels -- an eye-popping 1.3 million pixels appearing on the screen simultaneously, with room aplenty for your menus, toolbars and palettes. Thanks to its built-in, dual-link DVI support and 128 MB of graphics memory, you even have the option of connecting your PowerBook to Apple\'s breathtaking flat-panel displays, including the massive 30-inch Apple Cinema HD Display. Featuring a powerful 1.67 GHz PowerPC G4 processor, a standard 5400-rpm 100 GB hard drive, an 8x SuperDrive, up to 2 GB of DDR RAM and AirPort Extreme and Bluetooth 2.0+EDR built right in, the top gun of notebook computers has it all.','Includes: lithium-ion battery, AC adapter, S-Video to Composite adapter, DVI to VGA adapter, iLife, iSync, and more. Apple 17\" PowerBook Computer - This notebook computer comes packed with unique and convenient features that will greatly enhance your mobile computing experience. Built-in AirPort Extreme is a great feature to help keep you connected on the road. Wherever there\'s a Wi-Fi Hot Spot, you can wirelessly surf the Internet and check e-mail. And if there\'s no Wi-Fi around, you can use a Bluetooth-enabled cell phone as a modem, thanks to built-in Bluetooth 2.0 support. With Bluetooth 2.0, you can also use it along with iSync, to keep your contacts and schedules up to date. Not to mention enjoying a cable-free experience with an optional Apple wireless keyboard and mouse! Another really unique feature is the trackpad. Unlike other trackpads, this trackpad lets you easily scroll through web pages and large documents using a unique 2-finger method. ATI Mobility Radeon 9700 with 128MB of DDR SDRAM and dual-link DVI 100GB 5400RPM HDD SuperDrive - up to 8x DVD-R, 4x DVD-RW, 8x DVD+R, 4x DVD+RW, 24x CD-R, 10x CD-RW, 24x CD-ROM, and 8x DVD-ROM Built-in Gigabit Ethernet - 10/100/1000 Built-in 802.11g AirPort Extreme Built-in Bluetooth 2.0+EDR (Enhanced Data Rate) Built-in 56k v.92 Fax Modem Full size illuminated keyboard with ambient light sensor Unit Dimensions - 1 (h) x 15.4 (w) x 10.2 (d) Unit Weight - 6.9 lbs.','0','2020-10-25','0','2020-10-25',0),(28,'EN','EN','Powered by a dual-core Intel engine. Up to four times the speed of the PowerBook G4. Eight times the graphics bandwidth. With built-in iSight for instant video conferencing on the move. And Front Row with Apple Remote to dazzle everyone in the room. Wait no more.','You\'ve seen improvements in notebook performance before - but never on this scale. The Intel Core Duo powering MacBook Pro is actually two processors built into a single chip. This, combined with myriad other engineering leaps, boosts performance up to four times higher than the PowerBook G4. With this awesome power, it\'s a breeze to render complex 3D models, enjoy smooth playback of HD video, or host a four-way video conference.Intel Core Duo is the first chip built using Intel\'s groundbreaking 65-nanometer process - resulting in transistors so small, you could fit a hundred inside a single human cell. With smaller distances for electrons to travel, and two processors designed to share resources and conserve power, Intel Core Duo achieves higher levels of performance as it uses fewer watts. Which is what makes it possible to design a super-powerful MacBook Pro that\'s only one inch thin.When Mac technology makes something easy, it\'s hardly news. So here\'s more non-news for MacBook Pro owners: software just works. If you see the Universal logo on a new application, that means it will run on Intel- and PowerPC-based Mac computers. For most existing applications, you simply do what you\'ve always done: double-click them. Thanks to the Rosetta technology in Mac OS X, they look and feel just like they did before.','0','2020-10-25','0','2020-10-25',0),(29,'EN','EN','The sleekly styled 32-inch Nexus HD-ready monitor features the company\'s latest LCD panel technology--Cinespeed--and an expanded viewing angle of 176 degrees. With no internal tuner (either standard NTSC or digital ATSC), the 32HLC56 requires an optional tuner or cable/satellite set-top box to receive standard- and high-definition television programming. \n    It\'s easy to connect to brilliant imagery with the component and HDMI connections--the latter offering pure digital audio/video performance with no degradation of signal from just one convenient cable. This set also offers Nexus\'s exclusive HD Dynamic Contrast function, which provides a sharper, deeper image with rich colors and a more life-like image.',NULL,'0','2020-10-25','0','2020-10-25',0),(30,'EN','EN','Be prepared to capture that elusive moment anytime, anywhere with the SC-MM10S Ultra Compact MemoryCam. It packs a 10x optical/100x digital zoom and 680K pixel CCD with electronic image stabilization for remarkably clear pictures, viewed in the 2.0-inch LCD display. The 512MB memory can be expanded via the SD/MMC slot. \n    In addition to USB 2.0/PictBridge for printing stills, it offers MP3/webcam/voice recorder and data storage capabilities.',NULL,'0','2020-10-25','0','2020-10-25',0),(31,'EN','EN','The simple to use Kodi EasyShare C743 zoom digital camera provides remarkable features at a reasonable price. You\'ll bring details to life with 7.1-megapixel resolution. And the C743 has a 3x optical zoom lens and a huge 2.4-inch color display, proving that impressive doesn\'t always need to be expensive.','The simple to use Kodak EasyShare C743 zoom digital camera provides remarkable features at a reasonable price. You\'ll bring details to life with 7.1 Megapixel and the C743 has a 3x optical zoom lens, huge 2.5 inch color display. Capture life in motion with continuous VGA video 640x480 at 30 fps, featuring audio capture and playback. Create your perfect picture without a computer, using on-camera cropping. Know your pictures are in focus with the blurry picture alert feature. Restore an unintentionally deleted picture with the undo-delete function. Automatically reduce red-eye during picture capture with digital red-eye reduction. The C743 is part of the Kodak EasyShare system, so printing and sharing your pictures is amazingly simple. Shutter speed - 4-1/1400 seconds, long exposure 4 seconds max 2.5 inch LCD indoor/outdoor color display Optical Real Image Viewfinder Self timer - 2 and 10 seconds, 2 shot and burst Scene modes - auto, portrait, sport, landscape, night portrait, snow, beach, fireworks, self portrait, close up, backlight, children, party Still format - JPEG/EXIF v 2.21 QuickTime MOV MPEG-4 format with audio recording during capture NTSC or PAL I/O interface Tripod mount 1/4 inch standard System requirements - Windows XP, 2000 SP4 or later, 600 MHz processor or greater; Internet Explorer 6.0 or higher, Macintosh OS X 10.3 or higher; Safari 1.1 or higher, 128 MB RAM, 200 MB hard drive disk space available, CD-ROM drive, available USB port, color monitor, 800 x 600 display resolution, 16-bit minimum Unit Dimensions - Width 3.6 x Height 2.3 x Depth 1.3 inch, 92.2 x 65.7 x 32.4 mm Weight without batteries - 145 grams (5.1 ounces)','0','2020-10-25','0','2020-10-25',0),(32,'EN','EN','The Pan/Tilt IP Camera is a full-featured surveillance system that provides high quality video over a wireless network connection. Built-in CPU and Web Server allow the camera to function as a standalone device, allowing users to access the camera anywhere in the world by using a Web browser. Users can also move the camera remotely in almost any direction, scanning sensitive locations for unauthorized intrusion. The IP Camera comes with a CMOS sensor to deliver clear and crisp images, and its powerful IPView software gives users enhanced security options to archive streaming video straight to a computer\'s hard drive. IP View software can also monitor multiple cameras on a single screen, enable motion detection to trigger automatic recording, and send email alert notification.',NULL,'0','2020-10-25','0','2020-10-25',0),(33,'EN','EN','LG\'s newest mobile treat, the VX-8500 Chocolate offers minimalist-inspired style and a silky-smooth slider design. Deluxe features include support for V Cast Music, glowing touch-sensitive navigation keys, a powerful integrated music/video player, a 1.3 megapixel camera/camcorder, stereo Bluetooth capabilities, and a microSD memory slot for extra storage. If you value extreme style mixed with powerful substance, this is the phone for you.','So what makes the Chocolate look so great? The touch sensitive keypad controls? The sliding number pad? Slim design? Beautiful screen? From RandB to Heavy Metal to Easy Listening, the Chocolate lets you download from over 1 million songs on the go with V CAST music.','0','2020-10-25','0','2020-10-25',0),(34,'EN','EN','UIX\'s A6 cameras come with very advanced features, but at a very affordable price. In addition to the true digital still picture color and sharpness you\'d expect from this camera\'s 6-megapixel image sensor, you also have a built-in Power Movie Clip function that lets you choose between 30 or 15 frames per second. And, it\'s easy to double check your recently shot video with highly convenient pause, fast forward, and/or rewind right in the camera. \n    The A6\'s shutter button toggles between capture and playback modes, a great innovation for instant review of the pic you just took. Another one touch button allows you to take charge with manual, aperture priority, and shutter priority modes. Speaking of convenience, there\'s even a built in mirror, so you can see how you look when you take your own picture! Select from six different image sizes from 640 by 480 pixels to 2,816 by 2,112 pixels and from three resolution ranges--superfine, fine, and normal for 18 different resolution/size combinations--a useful memory management tool. \n    For example, you can take a postage stamp size picture from only 1.58 inches away in high resolution for wonderful color printing output, or a large but lower resolution landscape picture for full-screen sharing without choking friends\' e-mail. Samsung\'s in-camera editing capabilities include the ability to crop, rotate, and make numerous color revisions. Included are ArcSoft Photo Impression, Digimax Viewer and Digimax Reader software for editing, storage and USB connection output to your PC or directly to your printer via the included USB cable.',NULL,'0','2020-10-25','0','2020-10-25',0),(35,'EN','EN','You\'ll be amazed at the small, sleek form factor of the BlackBerry Pearl. It\'s like no other BlackBerry. But it\'s more than just a new look. This BlackBerry delivers everything its predecessors delivered and a whole lot more. The BlackBerry Pearl offers new features never before seen in a BlackBerry like, a 1.3 mega pixel camera, voice recognition, and an MP3 player to name a few. Try it for a few hours and you are hooked!',NULL,'0','2020-10-25','0','2020-10-25',0),(36,'EN','EN','Nintendo\'s Wii video game system (pronounced \"we\") is designed to attract people, regardless of their age or video game experience, to sit down and play together--whether they\'re in the same room or on different sides of the globe. The system\'s name reflects this simple idea. It\'s easily pronounced in a variety of languages, and the distinctive spelling suggests two players side by side. The two Wii features Nintendo thinks will create new levels of gaming community are built-in Wi-Fi access, supported by a new online gaming service, and Wii\'s intuitive, wireless, motion-sensitive game controller.','MODEL- WII VENDOR- NINTENDO FEATURES- Wii Console The sleek Wii console, no larger than a stack of several DVD cases, includes Wii Sports, a sensor bar, an AV cable, a Wii stand, a Wii Remote, and a Nunchuk controller for even more exciting game- control possibilities. Featuring a remarkable wireless controller experience, the Nintendo Wii console invites players into game worlds and activities like never before. Whether theyre young or old, expert gamers or beginners, Wii players will express themselves with intuitive motion control using the Wii Remote: a flick of the wrist to swing a baseball bat or tennis racket, a backswing and follow-through to send a golf ball flying over a pristine fairway. Wii Sports, packaged with the Wii console, introduces players to those and many other experiences. Wii also taps into Nintendos unrivaled legacy of great games with the Virtual Console. Connecting via wireless broadband to Nintendo Wi-Fi Connection, Wii owners will be able to spend Virtual Console points to download selected classic games from NES, Super NES and N64 video game consoles. And through WiiConnect24, owners will be able to access even more content. Four-player compatibility as well as the ability to compete with other Wii players over broadband internet means that Wii offers a true social experience. * Design Featuring a compact design that makes it a natural addition to any television setup, the Wii console is white in color and can be displayed either vertically or horizontally. * GameCube Compatibility The Wii is backward-compatible to all Nintendo GameCube games','0','2020-10-25','0','2020-10-25',0),(37,'EN','EN','To make gaming as accessible to people of all ages and all abilities, Nintendo wanted to create a controller that was as inviting as it was sophisticated. The outcome is the Wii Remote controller. Nintendo fused the familiarity of a remote control with the sophistication of motion-sensing technology to come up with an input device for the ages!Sporting the size of a traditional remote control, the wireless Wii Remote controller is a multifunctional device that is limited only by the game designer\'s imagination. In a tennis game, it serves as your racket you swing with your arm. In a driving game, it serves as your steering wheel. For first-person shooters, the remote acts as your weapon that you point at an enemy. The list of potential uses goes on and on.Using Bluetooth technology, the wireless Wii Remote controller sends your actions to the Wii console from as far as 30 feet away. As a pointing device, the controller can send a signal from as far as 15 feet away. Up to four Wii Remote Controllers can be connected at once, making for some great multiplayer fun!',NULL,'0','2020-10-25','0','2020-10-25',0),(38,'EN','EN','EJB 3.0 has made huge advances in ease of development, and its drastically simplified programming model has been widely acclaimed. Targeted at Java and J2EE developers both with and without prior EJB experience, Beginning EJB 3 Application Development takes readers through the details of the EJB 3.0 architecture, and shows how EJB can be used to develop powerful, standards-based backend business logic. With 12 years of combined EJB experience, the authors offer many practical insights into the entire EJB architecture and cover all areas of the EJB 3.0 specification',NULL,'0','2020-10-25','0','2020-10-25',0),(39,'EN','EN','EJB 3.0 sets a new precedent. It has made huge advances in ease of development, and its drastically simplified programming model has been widely acclaimed. This book is the definitive guide to EJB 3.0 persistence technology. The authors provide unparalleled insight and expertise on this topic, fully examining and explaining EJB 3.0 persistence specification. They describe how to use this sophisticated technology to its full potential',NULL,'0','2020-10-25','0','2020-10-25',0),(40,'EN','EN','Get a thorough understanding of Oracle Database 10g from the most comprehensive Oracle database reference on the market, published by Oracle Press. From critical architecture concepts to advanced object-oriented concepts, this powerhouse contains nearly 50 chapters designed to enlighten you. \n    Upgrade from earlier versions, use SQL, SQL Plus, and PL/SQL. Get code examples and access popular documentation PDFs--plus a full electronic copy of the book on the included CD-ROM. \n    Go beyond the basics and learn security, text searches, external tables, using Java in Oracle, and a great deal more',NULL,'0','2020-10-25','0','2020-10-25',0),(41,'EN','EN','EJB 3 in Action tackles EJB 3 and the Java Persistence API head-on, providing practical code samples, real-life scenarios, best practices, design patterns, and performance tuning tips. This book builds on the contributions and strengths of seminal technologies like Spring, Hibernate, and TopLink. EJB 3 is the most important innovation introduced in Java EE 5.0. EJB 3 simplifies enterprise development, abandoning the complex EJB 2.x model in favor of a lightweight POJO framework. \n    The new API represents a fresh perspective on EJB without sacrificing the mission of enabling business application developers to create robust, scalable, standards-based solutions. \n    EJB 3 in Action is a fast-paced tutorial, geared toward helping you learn EJB 3 and the Java Persistence API quickly and easily. For newcomers to EJB, this book provides a solid foundation in EJB. For the developer moving to EJB 3 from EJB 2, this book addresses the changes both in the EJB API and in the way the developer should approach EJB and persistence. ',NULL,'0','2020-10-25','0','2020-10-25',0),(42,'EN','EN','It is not possible to fit 36 Bach masterpieces on two CDs, so what Essential Bach does is present individual movements from across a range of the composer\'s work. The anthology is clearly aimed at the newcomer, and the absence of booklet notes to put the music in context is disappointing. We are only given titles, performers, and what films the extracts have been featured in, from Rollerball to The English Patient. On the plus side, most if not all of the music is instantly recognizable, by melody if not by name. Everything from the Brandenburg Concertos to \"Air on a G String\" to the B Minor Mass and St. Matthew Passion is represented. Performances range from 1960 to 1993, encompassing both early instrument and modern orchestra interpretations by a wide variety of forces, including Sir Neville Marriner with the Academy of St. Martin in the Fields and Raymond Leppard leading the English Chamber Orchestra. Given such diversity the result is unavoidably a patchwork, albeit one made from the finest materials, and as such is perhaps best treated as a sampler to aid exploration of the vast legacy of one of the very greatest composers who ever lived. ',NULL,'0','2020-10-25','0','2020-10-25',0),(43,'EN','EN','These are thoroughly balanced and lovingly conceived performances. They reveal great strength of character, healthy self-control and mature insight. Ferencsik evidently had experienced much, with emotional and spiritual roots that went deep. Consequently he had no need to resort to surface, superficial excitement to compensate for lack of insight. Ferencsik reveals the mature insight that comes only from a life-long contemplation of scores that the conductor knew as well as he knew the date of his own birthday.',NULL,'0','2020-10-25','0','2020-10-25',0),(44,'EN','EN','This 2CDs set is quite a good compilation of arias from Mozart\'s best known operas. The cast is awesome, too. The trouble is Mozart wrote so many wonderful arias that when you try to compile them from many operas, lots of the great ones like \'Non piu di fiori\' and \'Deh per questo istante solo\' from La clemenza di Tito get left out (tho having Teresa Berganza\'s version of \'Parto ma tu ben mio\' makes up for it somewhat). A lot of chorus pieces from Idomeneo but none of Idamante\'s arias, no Elettra\'s famous rage aria, and no \'Traurigkeit\' from \'Die Entfuehrung\'? Bottom line, all the arias included are marvellously sung. I think the line up could have been better, tho. It won\'t fill you up, perhaps, but it will wet your appetite for complete set of the operas included.',NULL,'0','2020-10-25','0','2020-10-25',0),(45,'EN','EN','In this recording we hear one of the great piano performers in Vladimir Ashkenazy playing pieces from one of the greatest piano composers in Fryderyk Chopin; with the utmost quality in recorded sound. And if one needs more convincing, you get two hours of music for the price of one cd. Hard to find a better buy in classical music. Moreover, this cd not only looks good on paper, but it also is one of my favorites to listen to. I usually listen to music to help enrich and exonerate an otherwise mundane (computer) task, and I find myself stopping work several times each listen because I\'m overcome by the beauty of these pieces, and the both spirited and soulful playing of Ashkenazy. For anyone new to Chopin, I cannot think of a better starting point (no, this double cd does not cover all his great compositions!) than this recording.',NULL,'0','2020-10-25','0','2020-10-25',0),(46,'EN','EN','We haven\'t had a disc of Tchaikovsky ballet excerpts from the Vienna Phil., I believe, since Karajan\'s four decades ago (a great recording on Decca in plush remastered sound). Here under James Levine in 1992 the orchestra is even better--more fluid, sparkling and alive than under Karajan. This is well-worn music that every collector already owns, and it\'s easy to overlook Levine as a Tchaikovsky conductor. \n    Here he defies all expectations. True, he doesn\'t take a balletic aproach. Levine\'s tempos in general are too fast to dance to. But in the symphonic vein he has chosen, Levine works miracles. The urgent virtuosity of the playing--aided by excellent recorded sound--is jaw-dropping, and the violin soloist in the long Swan Lake scene (#4) is beyond compare for delicacy and poetry. Karajan\'s only fault in this music wass to blow it up out of proportion; Previn\'s was to apply routine phrasing. \n    Levine makes these suites totally riveting and sensuously luxurious without any trace of pomposity. Highly recommended.',NULL,'0','2020-10-25','0','2020-10-25',0),(47,'EN','EN','CD 1 THE THREE GREAT SYMPHONIES CD 1 Symphony No. 7 in D Minor, Op. 70 q. I. Allegro maestoso 2. Poco adagio 3. Scherzo: Vivance 4. Finale: Allegro Symphony No. 8 in G Mahor, Op. 88 5. Allegro con brio 6. Adagio 7. Allegretto grazioso 8. Allegro, ma non troppo CD 2. Symphony No. 9 in E Minor, Op. 95 1. Adagio; allegro molto 2. Largo 3. Scherzo: Molto vivace 4. Alllegro con fuoco 5. Scherzo capriccioso, Op. 66.',NULL,'0','2020-10-25','0','2020-10-25',0);
/*!40000 ALTER TABLE `PRODUCT_TRANSLATIONS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `SHIPPING_OPTIONS`
--

DROP TABLE IF EXISTS `SHIPPING_OPTIONS`;
/*!50001 DROP VIEW IF EXISTS `SHIPPING_OPTIONS`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `SHIPPING_OPTIONS` (
  `SHIPPING_METHOD` tinyint NOT NULL,
  `SHIPPING_OPTION_ID` tinyint NOT NULL,
  `COUNTRY_CODE` tinyint NOT NULL,
  `COST_PER_CLASS1_ITEM` tinyint NOT NULL,
  `COST_PER_CLASS2_ITEM` tinyint NOT NULL,
  `COST_PER_CLASS3_ITEM` tinyint NOT NULL,
  `FREE_SHIPPING_ALLOWED_FLAG` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `SHIPPING_OPTIONS_BASE`
--

DROP TABLE IF EXISTS `SHIPPING_OPTIONS_BASE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SHIPPING_OPTIONS_BASE` (
  `SHIPPING_OPTION_ID` int(15) NOT NULL,
  `COUNTRY_CODE` varchar(2) DEFAULT NULL,
  `COST_PER_CLASS1_ITEM` float(8,2) NOT NULL,
  `COST_PER_CLASS2_ITEM` float(8,2) NOT NULL,
  `COST_PER_CLASS3_ITEM` float(8,2) NOT NULL,
  `FREE_SHIPPING_ALLOWED_FLAG` varchar(1) DEFAULT 'N',
  `CREATED_BY` varchar(60) NOT NULL,
  `CREATION_DATE` date NOT NULL,
  `LAST_UPDATED_BY` varchar(60) NOT NULL,
  `LAST_UPDATE_DATE` date NOT NULL,
  `OBJECT_VERSION_ID` int(15) NOT NULL,
  PRIMARY KEY (`SHIPPING_OPTION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='This table drives the available shipping options for the order. This list is used by the UI and configured based on the shipping address''s country code. ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SHIPPING_OPTIONS_BASE`
--

LOCK TABLES `SHIPPING_OPTIONS_BASE` WRITE;
/*!40000 ALTER TABLE `SHIPPING_OPTIONS_BASE` DISABLE KEYS */;
INSERT INTO `SHIPPING_OPTIONS_BASE` VALUES (1,'EN',3.15,11.98,27.50,'Y','0','2020-10-25','0','2020-10-25',0),(2,'EN',4.50,12.79,29.85,'Y','0','2020-10-25','0','2020-10-25',0),(3,'EN',4.25,14.99,32.50,'Y','0','2020-10-25','0','2020-10-25',0),(4,'EN',0.00,0.00,0.00,'Y','0','2020-10-25','0','2020-10-25',0);
/*!40000 ALTER TABLE `SHIPPING_OPTIONS_BASE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SHIPPING_OPTION_SEQ`
--

DROP TABLE IF EXISTS `SHIPPING_OPTION_SEQ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SHIPPING_OPTION_SEQ` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) unsigned NOT NULL,
  `cycle_option` tinyint(1) unsigned NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB SEQUENCE=1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SHIPPING_OPTION_SEQ`
--

LOCK TABLES `SHIPPING_OPTION_SEQ` WRITE;
/*!40000 ALTER TABLE `SHIPPING_OPTION_SEQ` DISABLE KEYS */;
INSERT INTO `SHIPPING_OPTION_SEQ` VALUES (5,1,9223372036854775806,5,1,1000,0,0);
/*!40000 ALTER TABLE `SHIPPING_OPTION_SEQ` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SHIPPING_OPTION_TRANSLATIONS`
--

DROP TABLE IF EXISTS `SHIPPING_OPTION_TRANSLATIONS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SHIPPING_OPTION_TRANSLATIONS` (
  `SHIPPING_TRANSLATIONS_ID` int(15) NOT NULL,
  `SHIPPING_OPTION_ID` int(15) NOT NULL,
  `SHIPPING_METHOD` varchar(100) NOT NULL,
  `LANGUAGE` varchar(30) NOT NULL,
  `SOURCE_LANG` varchar(4000) NOT NULL,
  `CREATED_BY` varchar(60) NOT NULL,
  `CREATION_DATE` date NOT NULL,
  `LAST_UPDATED_BY` varchar(60) NOT NULL,
  `LAST_UPDATE_DATE` date NOT NULL,
  `OBJECT_VERSION_ID` int(15) NOT NULL,
  PRIMARY KEY (`SHIPPING_TRANSLATIONS_ID`),
  KEY `SHIPPING_OPTION_TRANSLATION_FK` (`SHIPPING_OPTION_ID`),
  CONSTRAINT `SHIPPING_OPTION_TRANSLATION_FK` FOREIGN KEY (`SHIPPING_OPTION_ID`) REFERENCES `SHIPPING_OPTIONS_BASE` (`SHIPPING_OPTION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Holds the translated shipping option description. One translation will exist for each supported language and shipping option combination';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SHIPPING_OPTION_TRANSLATIONS`
--

LOCK TABLES `SHIPPING_OPTION_TRANSLATIONS` WRITE;
/*!40000 ALTER TABLE `SHIPPING_OPTION_TRANSLATIONS` DISABLE KEYS */;
INSERT INTO `SHIPPING_OPTION_TRANSLATIONS` VALUES (1,1,'Standard Shipping (3-5 business days)','EN','EN','0','2020-10-25','0','2020-10-25',0),(2,2,'Two-Day Shipping','EN','EN','0','2020-10-25','0','2020-10-25',0),(3,3,'One-Day Shipping','EN','EN','0','2020-10-25','0','2020-10-25',0),(4,4,'Pick-up','EN','EN','0','2020-10-25','0','2020-10-25',0);
/*!40000 ALTER TABLE `SHIPPING_OPTION_TRANSLATIONS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SHIPPING_TRANSLATIONS_SEQ`
--

DROP TABLE IF EXISTS `SHIPPING_TRANSLATIONS_SEQ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SHIPPING_TRANSLATIONS_SEQ` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) unsigned NOT NULL,
  `cycle_option` tinyint(1) unsigned NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB SEQUENCE=1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SHIPPING_TRANSLATIONS_SEQ`
--

LOCK TABLES `SHIPPING_TRANSLATIONS_SEQ` WRITE;
/*!40000 ALTER TABLE `SHIPPING_TRANSLATIONS_SEQ` DISABLE KEYS */;
INSERT INTO `SHIPPING_TRANSLATIONS_SEQ` VALUES (5,1,9223372036854775806,5,1,1000,0,0);
/*!40000 ALTER TABLE `SHIPPING_TRANSLATIONS_SEQ` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SUPPLIERS`
--

DROP TABLE IF EXISTS `SUPPLIERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SUPPLIERS` (
  `SUPPLIER_ID` int(15) NOT NULL,
  `SUPPLIER_NAME` varchar(120) NOT NULL,
  `SUPPLIER_STATUS` varchar(30) NOT NULL,
  `PHONE_NUMBER` varchar(20) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `UI_SKIN` varchar(60) DEFAULT NULL,
  `CREATED_BY` varchar(60) NOT NULL,
  `CREATION_DATE` date NOT NULL,
  `LAST_UPDATED_BY` varchar(60) NOT NULL,
  `LAST_UPDATE_DATE` date NOT NULL,
  `OBJECT_VERSION_ID` int(15) NOT NULL,
  PRIMARY KEY (`SUPPLIER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='This table holds a list of product suppliers';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SUPPLIERS`
--

LOCK TABLES `SUPPLIERS` WRITE;
/*!40000 ALTER TABLE `SUPPLIERS` DISABLE KEYS */;
INSERT INTO `SUPPLIERS` VALUES (100,'Stuffz','ACTIVE','402.555.0158','contact@stuffz.example.com',NULL,'0','2020-10-25','0','2020-10-25',1),(101,'Nexus','ACTIVE','608.555.0114','contact@nexus.example.com',NULL,'0','2020-10-25','0','2020-10-25',1),(102,'Gifts-N-More','ACTIVE','225.555.0181','contact@giftsnmore.example.com',NULL,'0','2020-10-25','0','2020-10-25',1),(103,'Emporium','ACTIVE','212.555.0198','contact@emporium.example.com',NULL,'0','2020-10-25','0','2020-10-25',1),(104,'Jeffery And Michael\'s','ACTIVE','419.555.0167','contact@jeffery-michael.example.com',NULL,'0','2020-10-25','0','2020-10-25',1),(105,'Games Galore','ACTIVE','630.555.0127','contact@games_galore.example.com',NULL,'0','2020-10-25','0','2020-10-25',1),(106,'Transistor City','ACTIVE','303.555.0177','contact@transistorcity.example.com',NULL,'0','2020-10-25','0','2020-10-25',1),(107,'Mercury Imports','ACTIVE','862.555.0108','contact@mercury-imports.example.com',NULL,'0','2020-10-25','0','2020-10-25',1),(108,'BigSwamp','ACTIVE','248.555.0154','contact@bigswamp.example.com',NULL,'0','2020-10-25','0','2020-10-25',1),(109,'Z-Mart','ACTIVE','959.555.0120','contact@zmart.example.com',NULL,'0','2020-10-25','0','2020-10-25',1),(110,'Wally\'s Mart','ACTIVE','470.555.0180','contact@wallymart.example.com',NULL,'0','2020-10-25','0','2020-10-25',1),(111,'Ellis','ACTIVE','641.555.0194','contact@ellis.example.com',NULL,'0','2020-10-25','0','2020-10-25',1),(112,'Electronics and More','ACTIVE','413.555.0140','contact@electronics_and_more.example.com',NULL,'0','2020-10-25','0','2020-10-25',1),(113,'Zibbers','ACTIVE','717.555.0162','contact@zibbers.example.com',NULL,'0','2020-10-25','0','2020-10-25',1),(114,'Great Gadgets','ACTIVE','320.555.0155','contact@greatgadgets.example.com',NULL,'0','2020-10-25','0','2020-10-25',1),(115,'Perfect Purchase','ACTIVE','971.555.0128','contact@perfect_purchase.example.com',NULL,'0','2020-10-25','0','2020-10-25',1),(116,'Silicon Super Store','ACTIVE','829.555.0141','contact@siliconsuperstore.example.com',NULL,'0','2020-10-25','0','2020-10-25',1),(117,'Value Valley','ACTIVE','325.555.0134','contact@valuevalley.example.com',NULL,'0','2020-10-25','0','2020-10-25',1),(118,'Super Stuff','ACTIVE','661.555.0186','contact@superstuff.example.com',NULL,'0','2020-10-25','0','2020-10-25',1),(119,'Gifts-to-Go','ACTIVE','308.555.0157','contact@giftstogo.example.com',NULL,'0','2020-10-25','0','2020-10-25',1),(120,'MoreStuffz','ACTIVE','662.555.0125','contact@morestuffz.example.com',NULL,'0','2020-10-25','0','2020-10-25',1),(121,'MoreAndMoreStuffz','ACTIVE','614.555.0121','contact@moreandmorestuffz.example.com',NULL,'0','2020-10-25','0','2020-10-25',1),(122,'MaxStuffz','ACTIVE','570.555.0196','contact@maxstuffz.example.com',NULL,'0','2020-10-25','0','2020-10-25',1),(123,'Geeky Gadgets','ACTIVE','256.555.0152','contact@geekygadgets.example.com',NULL,'0','2020-10-25','0','2020-10-25',1),(124,'Gobs of Goods','ACTIVE','647.555.0166','contact@gobsofgoods.example.com',NULL,'0','2020-10-25','0','2020-10-25',1),(125,'Stock Plus','ACTIVE','563.555.0191','contact@stockplus.example.com',NULL,'0','2020-10-25','0','2020-10-25',1),(126,'Zip City','ACTIVE','985.555.0163','contact@zipcity.example.com',NULL,'0','2020-10-25','0','2020-10-25',1),(127,'Shop-a-lot','ACTIVE','269.555.0175','contact@shopalot.example.com',NULL,'0','2020-10-25','0','2020-10-25',1),(128,'Shopster','ACTIVE','706.555.0109','contact@shopster.example.com',NULL,'0','2020-10-25','0','2020-10-25',1),(129,'Simply Shop','ACTIVE','848.555.0137','contact@simplyshop.example.com',NULL,'0','2020-10-25','0','2020-10-25',1);
/*!40000 ALTER TABLE `SUPPLIERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SUPPLIER_SEQ`
--

DROP TABLE IF EXISTS `SUPPLIER_SEQ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SUPPLIER_SEQ` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) unsigned NOT NULL,
  `cycle_option` tinyint(1) unsigned NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB SEQUENCE=1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SUPPLIER_SEQ`
--

LOCK TABLES `SUPPLIER_SEQ` WRITE;
/*!40000 ALTER TABLE `SUPPLIER_SEQ` DISABLE KEYS */;
INSERT INTO `SUPPLIER_SEQ` VALUES (300,1,9223372036854775806,300,1,10,0,0);
/*!40000 ALTER TABLE `SUPPLIER_SEQ` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `WAREHOUSES`
--

DROP TABLE IF EXISTS `WAREHOUSES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `WAREHOUSES` (
  `WAREHOUSE_ID` int(15) NOT NULL,
  `ADDRESS_ID` int(15) NOT NULL,
  `WAREHOUSE_NAME` varchar(35) NOT NULL,
  `CREATED_BY` varchar(60) NOT NULL,
  `CREATION_DATE` date NOT NULL,
  `LAST_UPDATED_BY` varchar(60) NOT NULL,
  `LAST_UPDATE_DATE` date NOT NULL,
  `OBJECT_VERSION_ID` int(15) NOT NULL,
  PRIMARY KEY (`WAREHOUSE_ID`),
  KEY `WAREHOUSES_ADDRESSES_FK` (`ADDRESS_ID`),
  CONSTRAINT `WAREHOUSES_ADDRESSES_FK` FOREIGN KEY (`ADDRESS_ID`) REFERENCES `ADDRESSES` (`ADDRESS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Warehouses owned by the store''s company (not individual suppliers) ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `WAREHOUSES`
--

LOCK TABLES `WAREHOUSES` WRITE;
/*!40000 ALTER TABLE `WAREHOUSES` DISABLE KEYS */;
INSERT INTO `WAREHOUSES` VALUES (101,1,'Mid-America Warehouse','0','2020-10-25','0','2020-10-25',1),(102,2,'Main Stuffz Warehouse','0','2020-10-25','0','2020-10-25',1),(103,3,'Eastern Seaboard Warehousing','0','2020-10-25','0','2020-10-25',1),(104,4,'Italia Warehouse','0','2020-10-25','0','2020-10-25',1),(105,5,'Zurich Warehouse','0','2020-10-25','0','2020-10-25',1),(106,101,'San Francisco Store','0','2020-10-25','0','2020-10-25',1),(107,102,'Geary Blvd Store','0','2020-10-25','0','2020-10-25',1),(108,103,'Colma Store','0','2020-10-25','0','2020-10-25',1),(109,104,'Emeryville Store','0','2020-10-25','0','2020-10-25',1),(110,105,'Marin City Store','0','2020-10-25','0','2020-10-25',1),(111,106,'San Rafael Store','0','2020-10-25','0','2020-10-25',1),(112,107,'Washington Warehouse','0','2020-10-25','0','2020-10-25',1),(113,108,'Oregon Warehouse','0','2020-10-25','0','2020-10-25',1),(114,109,'Idaho Warehouse','0','2020-10-25','0','2020-10-25',1),(115,110,'California Warehouse','0','2020-10-25','0','2020-10-25',1),(116,111,'Nevada Warehouse','0','2020-10-25','0','2020-10-25',1),(117,112,'Utah Warehouse','0','2020-10-25','0','2020-10-25',1),(118,113,'Arizona Warehouse','0','2020-10-25','0','2020-10-25',1),(119,114,'Montana Warehouse','0','2020-10-25','0','2020-10-25',1),(120,115,'Wyoming Warehouse','0','2020-10-25','0','2020-10-25',1),(121,116,'Colorado Warehouse','0','2020-10-25','0','2020-10-25',1),(122,117,'New Mexico Warehouse','0','2020-10-25','0','2020-10-25',1);
/*!40000 ALTER TABLE `WAREHOUSES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `WAREHOUSE_SEQ`
--

DROP TABLE IF EXISTS `WAREHOUSE_SEQ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `WAREHOUSE_SEQ` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) unsigned NOT NULL,
  `cycle_option` tinyint(1) unsigned NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB SEQUENCE=1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `WAREHOUSE_SEQ`
--

LOCK TABLES `WAREHOUSE_SEQ` WRITE;
/*!40000 ALTER TABLE `WAREHOUSE_SEQ` DISABLE KEYS */;
INSERT INTO `WAREHOUSE_SEQ` VALUES (200,1,9223372036854775806,200,1,1000,0,0);
/*!40000 ALTER TABLE `WAREHOUSE_SEQ` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `WAREHOUSE_STOCK_LEVELS`
--

DROP TABLE IF EXISTS `WAREHOUSE_STOCK_LEVELS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `WAREHOUSE_STOCK_LEVELS` (
  `PRODUCT_ID` int(15) NOT NULL,
  `WAREHOUSE_ID` int(15) NOT NULL,
  `QUANTITY_ON_HAND` int(8) NOT NULL,
  `CREATED_BY` varchar(60) NOT NULL,
  `CREATION_DATE` date NOT NULL,
  `LAST_UPDATED_BY` varchar(60) NOT NULL,
  `LAST_UPDATE_DATE` date NOT NULL,
  `OBJECT_VERSION_ID` int(15) NOT NULL,
  PRIMARY KEY (`PRODUCT_ID`,`WAREHOUSE_ID`),
  KEY `WAREHOUSE_STOCK_LEVELS_FK` (`WAREHOUSE_ID`),
  CONSTRAINT `WAREHOUSE_STOCK_LEVELS_FK` FOREIGN KEY (`WAREHOUSE_ID`) REFERENCES `WAREHOUSES` (`WAREHOUSE_ID`),
  CONSTRAINT `WAREHOUSE_STOCK_LEVELS_FK1` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `PRODUCTS_BASE` (`PRODUCT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Holds information about the stock levels for a particular product in each warehouse.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `WAREHOUSE_STOCK_LEVELS`
--

LOCK TABLES `WAREHOUSE_STOCK_LEVELS` WRITE;
/*!40000 ALTER TABLE `WAREHOUSE_STOCK_LEVELS` DISABLE KEYS */;
INSERT INTO `WAREHOUSE_STOCK_LEVELS` VALUES (1,101,200,'0','2020-10-25','0','2020-10-25',1),(1,102,750,'0','2020-10-25','0','2020-10-25',1),(1,103,1495,'0','2020-10-25','0','2020-10-25',1),(1,104,900,'0','2020-10-25','0','2020-10-25',1),(1,105,1200,'0','2020-10-25','0','2020-10-25',1),(1,106,1300,'0','2020-10-25','0','2020-10-25',1),(1,107,1100,'0','2020-10-25','0','2020-10-25',1),(1,108,900,'0','2020-10-25','0','2020-10-25',1),(1,109,700,'0','2020-10-25','0','2020-10-25',1),(1,110,550,'0','2020-10-25','0','2020-10-25',1),(1,111,350,'0','2020-10-25','0','2020-10-25',1),(2,101,750,'0','2020-10-25','0','2020-10-25',1),(2,102,200,'0','2020-10-25','0','2020-10-25',1),(2,103,990,'0','2020-10-25','0','2020-10-25',1),(2,104,1100,'0','2020-10-25','0','2020-10-25',1),(2,105,800,'0','2020-10-25','0','2020-10-25',1),(2,106,200,'0','2020-10-25','0','2020-10-25',1),(2,107,600,'0','2020-10-25','0','2020-10-25',1),(2,108,1100,'0','2020-10-25','0','2020-10-25',1),(2,109,300,'0','2020-10-25','0','2020-10-25',1),(2,110,1250,'0','2020-10-25','0','2020-10-25',1),(2,111,1350,'0','2020-10-25','0','2020-10-25',1),(3,101,1295,'0','2020-10-25','0','2020-10-25',1),(3,102,965,'0','2020-10-25','0','2020-10-25',1),(3,103,1200,'0','2020-10-25','0','2020-10-25',1),(3,104,200,'0','2020-10-25','0','2020-10-25',1),(3,105,1125,'0','2020-10-25','0','2020-10-25',1),(3,106,675,'0','2020-10-25','0','2020-10-25',1),(3,107,400,'0','2020-10-25','0','2020-10-25',1),(3,108,1300,'0','2020-10-25','0','2020-10-25',1),(3,109,600,'0','2020-10-25','0','2020-10-25',1),(3,110,750,'0','2020-10-25','0','2020-10-25',1),(3,111,550,'0','2020-10-25','0','2020-10-25',1),(4,101,1350,'0','2020-10-25','0','2020-10-25',1),(4,102,780,'0','2020-10-25','0','2020-10-25',1),(4,105,350,'0','2020-10-25','0','2020-10-25',1),(5,102,1470,'0','2020-10-25','0','2020-10-25',1),(6,101,780,'0','2020-10-25','0','2020-10-25',1),(6,102,550,'0','2020-10-25','0','2020-10-25',1),(7,102,1725,'0','2020-10-25','0','2020-10-25',1),(7,103,1350,'0','2020-10-25','0','2020-10-25',1),(7,104,345,'0','2020-10-25','0','2020-10-25',1),(8,101,925,'0','2020-10-25','0','2020-10-25',1),(8,102,245,'0','2020-10-25','0','2020-10-25',1),(8,104,700,'0','2020-10-25','0','2020-10-25',1),(8,105,875,'0','2020-10-25','0','2020-10-25',1),(9,102,1050,'0','2020-10-25','0','2020-10-25',1),(11,101,1020,'0','2020-10-25','0','2020-10-25',1),(11,102,1485,'0','2020-10-25','0','2020-10-25',1),(12,101,300,'0','2020-10-25','0','2020-10-25',1),(12,102,375,'0','2020-10-25','0','2020-10-25',1),(13,102,2100,'0','2020-10-25','0','2020-10-25',1),(13,103,1680,'0','2020-10-25','0','2020-10-25',1),(14,101,250,'0','2020-10-25','0','2020-10-25',1),(14,102,375,'0','2020-10-25','0','2020-10-25',1),(14,103,825,'0','2020-10-25','0','2020-10-25',1),(14,105,750,'0','2020-10-25','0','2020-10-25',1),(15,102,220,'0','2020-10-25','0','2020-10-25',1),(15,104,1260,'0','2020-10-25','0','2020-10-25',1),(16,101,750,'0','2020-10-25','0','2020-10-25',1),(16,102,550,'0','2020-10-25','0','2020-10-25',1),(17,102,240,'0','2020-10-25','0','2020-10-25',1),(17,103,310,'0','2020-10-25','0','2020-10-25',1),(18,102,1500,'0','2020-10-25','0','2020-10-25',1),(19,101,250,'0','2020-10-25','0','2020-10-25',1),(19,102,100,'0','2020-10-25','0','2020-10-25',1),(19,104,650,'0','2020-10-25','0','2020-10-25',1),(20,102,600,'0','2020-10-25','0','2020-10-25',1),(20,103,200,'0','2020-10-25','0','2020-10-25',1),(21,102,700,'0','2020-10-25','0','2020-10-25',1),(21,103,200,'0','2020-10-25','0','2020-10-25',1),(21,104,400,'0','2020-10-25','0','2020-10-25',1),(22,102,1000,'0','2020-10-25','0','2020-10-25',1),(22,104,600,'0','2020-10-25','0','2020-10-25',1),(23,102,1500,'0','2020-10-25','0','2020-10-25',1),(24,102,250,'0','2020-10-25','0','2020-10-25',1),(25,102,100,'0','2020-10-25','0','2020-10-25',1),(25,105,150,'0','2020-10-25','0','2020-10-25',1),(26,102,450,'0','2020-10-25','0','2020-10-25',1),(27,102,500,'0','2020-10-25','0','2020-10-25',1),(27,103,350,'0','2020-10-25','0','2020-10-25',1),(27,104,100,'0','2020-10-25','0','2020-10-25',1),(28,101,750,'0','2020-10-25','0','2020-10-25',1),(28,102,400,'0','2020-10-25','0','2020-10-25',1),(28,104,500,'0','2020-10-25','0','2020-10-25',1),(29,101,350,'0','2020-10-25','0','2020-10-25',1),(29,102,560,'0','2020-10-25','0','2020-10-25',1),(29,103,120,'0','2020-10-25','0','2020-10-25',1),(29,104,400,'0','2020-10-25','0','2020-10-25',1),(29,105,460,'0','2020-10-25','0','2020-10-25',1),(30,101,250,'0','2020-10-25','0','2020-10-25',1),(30,102,160,'0','2020-10-25','0','2020-10-25',1),(30,103,520,'0','2020-10-25','0','2020-10-25',1),(30,104,700,'0','2020-10-25','0','2020-10-25',1),(30,105,160,'0','2020-10-25','0','2020-10-25',1),(31,101,250,'0','2020-10-25','0','2020-10-25',1),(31,102,260,'0','2020-10-25','0','2020-10-25',1),(31,103,220,'0','2020-10-25','0','2020-10-25',1),(31,104,200,'0','2020-10-25','0','2020-10-25',1),(31,105,260,'0','2020-10-25','0','2020-10-25',1),(32,101,150,'0','2020-10-25','0','2020-10-25',1),(32,102,160,'0','2020-10-25','0','2020-10-25',1),(32,103,120,'0','2020-10-25','0','2020-10-25',1),(32,104,100,'0','2020-10-25','0','2020-10-25',1),(32,105,160,'0','2020-10-25','0','2020-10-25',1),(33,101,750,'0','2020-10-25','0','2020-10-25',1),(33,102,760,'0','2020-10-25','0','2020-10-25',1),(33,103,720,'0','2020-10-25','0','2020-10-25',1),(33,104,700,'0','2020-10-25','0','2020-10-25',1),(33,105,760,'0','2020-10-25','0','2020-10-25',1),(34,101,250,'0','2020-10-25','0','2020-10-25',1),(34,102,260,'0','2020-10-25','0','2020-10-25',1),(34,103,220,'0','2020-10-25','0','2020-10-25',1),(34,104,200,'0','2020-10-25','0','2020-10-25',1),(34,105,260,'0','2020-10-25','0','2020-10-25',1),(35,101,450,'0','2020-10-25','0','2020-10-25',1),(35,102,460,'0','2020-10-25','0','2020-10-25',1),(35,103,420,'0','2020-10-25','0','2020-10-25',1),(35,104,400,'0','2020-10-25','0','2020-10-25',1),(35,105,460,'0','2020-10-25','0','2020-10-25',1),(36,102,460,'0','2020-10-25','0','2020-10-25',1),(36,103,420,'0','2020-10-25','0','2020-10-25',1),(36,104,400,'0','2020-10-25','0','2020-10-25',1),(36,105,460,'0','2020-10-25','0','2020-10-25',1),(37,102,160,'0','2020-10-25','0','2020-10-25',1),(37,103,120,'0','2020-10-25','0','2020-10-25',1),(37,104,100,'0','2020-10-25','0','2020-10-25',1),(37,105,160,'0','2020-10-25','0','2020-10-25',1),(38,102,260,'0','2020-10-25','0','2020-10-25',1),(38,103,220,'0','2020-10-25','0','2020-10-25',1),(38,104,200,'0','2020-10-25','0','2020-10-25',1),(38,105,260,'0','2020-10-25','0','2020-10-25',1),(39,102,160,'0','2020-10-25','0','2020-10-25',1),(39,103,120,'0','2020-10-25','0','2020-10-25',1),(39,104,100,'0','2020-10-25','0','2020-10-25',1),(39,105,160,'0','2020-10-25','0','2020-10-25',1),(40,102,60,'0','2020-10-25','0','2020-10-25',1),(40,103,20,'0','2020-10-25','0','2020-10-25',1),(40,104,10,'0','2020-10-25','0','2020-10-25',1),(40,105,60,'0','2020-10-25','0','2020-10-25',1),(41,102,160,'0','2020-10-25','0','2020-10-25',1),(41,104,110,'0','2020-10-25','0','2020-10-25',1),(41,105,160,'0','2020-10-25','0','2020-10-25',1),(42,102,260,'0','2020-10-25','0','2020-10-25',1),(42,104,210,'0','2020-10-25','0','2020-10-25',1),(42,105,260,'0','2020-10-25','0','2020-10-25',1),(43,102,360,'0','2020-10-25','0','2020-10-25',1),(43,104,310,'0','2020-10-25','0','2020-10-25',1),(43,105,260,'0','2020-10-25','0','2020-10-25',1),(44,102,160,'0','2020-10-25','0','2020-10-25',1),(44,104,310,'0','2020-10-25','0','2020-10-25',1),(44,105,260,'0','2020-10-25','0','2020-10-25',1),(45,102,10,'0','2020-10-25','0','2020-10-25',1),(45,104,30,'0','2020-10-25','0','2020-10-25',1),(45,105,20,'0','2020-10-25','0','2020-10-25',1),(46,102,100,'0','2020-10-25','0','2020-10-25',1),(46,105,200,'0','2020-10-25','0','2020-10-25',1),(47,102,200,'0','2020-10-25','0','2020-10-25',1),(47,105,200,'0','2020-10-25','0','2020-10-25',1),(48,102,300,'0','2020-10-25','0','2020-10-25',1),(48,105,300,'0','2020-10-25','0','2020-10-25',1),(49,102,400,'0','2020-10-25','0','2020-10-25',1),(49,105,400,'0','2020-10-25','0','2020-10-25',1),(50,102,500,'0','2020-10-25','0','2020-10-25',1),(50,105,500,'0','2020-10-25','0','2020-10-25',1),(51,101,160,'0','2020-10-25','0','2020-10-25',1),(51,102,250,'0','2020-10-25','0','2020-10-25',1),(51,103,340,'0','2020-10-25','0','2020-10-25',1),(51,104,430,'0','2020-10-25','0','2020-10-25',1),(52,101,260,'0','2020-10-25','0','2020-10-25',1),(52,102,250,'0','2020-10-25','0','2020-10-25',1),(52,103,240,'0','2020-10-25','0','2020-10-25',1),(52,104,230,'0','2020-10-25','0','2020-10-25',1),(53,101,360,'0','2020-10-25','0','2020-10-25',1),(53,102,350,'0','2020-10-25','0','2020-10-25',1),(53,103,340,'0','2020-10-25','0','2020-10-25',1),(53,104,330,'0','2020-10-25','0','2020-10-25',1),(54,101,460,'0','2020-10-25','0','2020-10-25',1),(54,102,450,'0','2020-10-25','0','2020-10-25',1),(54,103,440,'0','2020-10-25','0','2020-10-25',1),(54,104,430,'0','2020-10-25','0','2020-10-25',1),(55,101,560,'0','2020-10-25','0','2020-10-25',1),(55,102,550,'0','2020-10-25','0','2020-10-25',1),(55,103,540,'0','2020-10-25','0','2020-10-25',1),(55,104,530,'0','2020-10-25','0','2020-10-25',1),(56,101,260,'0','2020-10-25','0','2020-10-25',1),(56,102,250,'0','2020-10-25','0','2020-10-25',1),(56,104,230,'0','2020-10-25','0','2020-10-25',1),(56,105,240,'0','2020-10-25','0','2020-10-25',1),(57,101,260,'0','2020-10-25','0','2020-10-25',1),(57,102,250,'0','2020-10-25','0','2020-10-25',1),(57,104,230,'0','2020-10-25','0','2020-10-25',1),(57,105,240,'0','2020-10-25','0','2020-10-25',1),(58,101,160,'0','2020-10-25','0','2020-10-25',1),(58,102,250,'0','2020-10-25','0','2020-10-25',1),(58,104,130,'0','2020-10-25','0','2020-10-25',1),(58,105,140,'0','2020-10-25','0','2020-10-25',1),(59,101,260,'0','2020-10-25','0','2020-10-25',1),(59,102,550,'0','2020-10-25','0','2020-10-25',1),(59,104,130,'0','2020-10-25','0','2020-10-25',1),(59,105,440,'0','2020-10-25','0','2020-10-25',1),(60,101,550,'0','2020-10-25','0','2020-10-25',1),(60,102,550,'0','2020-10-25','0','2020-10-25',1),(60,103,550,'0','2020-10-25','0','2020-10-25',1),(60,105,550,'0','2020-10-25','0','2020-10-25',1),(60,106,81,'0','2020-10-25','0','2020-10-25',1),(60,107,186,'0','2020-10-25','0','2020-10-25',1),(60,108,386,'0','2020-10-25','0','2020-10-25',1),(60,109,106,'0','2020-10-25','0','2020-10-25',1),(60,110,103,'0','2020-10-25','0','2020-10-25',1),(60,111,469,'0','2020-10-25','0','2020-10-25',1),(61,101,550,'0','2020-10-25','0','2020-10-25',1),(61,102,550,'0','2020-10-25','0','2020-10-25',1),(61,103,550,'0','2020-10-25','0','2020-10-25',1),(61,104,550,'0','2020-10-25','0','2020-10-25',1),(61,106,81,'0','2020-10-25','0','2020-10-25',1),(61,107,186,'0','2020-10-25','0','2020-10-25',1),(61,108,386,'0','2020-10-25','0','2020-10-25',1),(61,109,106,'0','2020-10-25','0','2020-10-25',1),(61,110,103,'0','2020-10-25','0','2020-10-25',1),(61,111,469,'0','2020-10-25','0','2020-10-25',1),(62,102,550,'0','2020-10-25','0','2020-10-25',1),(62,106,81,'0','2020-10-25','0','2020-10-25',1),(62,107,186,'0','2020-10-25','0','2020-10-25',1),(62,108,386,'0','2020-10-25','0','2020-10-25',1),(62,109,106,'0','2020-10-25','0','2020-10-25',1),(62,110,103,'0','2020-10-25','0','2020-10-25',1),(62,111,469,'0','2020-10-25','0','2020-10-25',1),(63,102,550,'0','2020-10-25','0','2020-10-25',1),(63,104,550,'0','2020-10-25','0','2020-10-25',1),(63,106,81,'0','2020-10-25','0','2020-10-25',1),(63,107,186,'0','2020-10-25','0','2020-10-25',1),(63,108,386,'0','2020-10-25','0','2020-10-25',1),(63,109,106,'0','2020-10-25','0','2020-10-25',1),(63,110,103,'0','2020-10-25','0','2020-10-25',1),(63,111,469,'0','2020-10-25','0','2020-10-25',1),(64,102,550,'0','2020-10-25','0','2020-10-25',1),(64,105,550,'0','2020-10-25','0','2020-10-25',1),(64,106,81,'0','2020-10-25','0','2020-10-25',1),(64,107,186,'0','2020-10-25','0','2020-10-25',1),(64,108,386,'0','2020-10-25','0','2020-10-25',1),(64,109,106,'0','2020-10-25','0','2020-10-25',1),(64,110,103,'0','2020-10-25','0','2020-10-25',1),(64,111,469,'0','2020-10-25','0','2020-10-25',1),(65,101,550,'0','2020-10-25','0','2020-10-25',1),(65,102,550,'0','2020-10-25','0','2020-10-25',1),(65,105,550,'0','2020-10-25','0','2020-10-25',1),(65,106,81,'0','2020-10-25','0','2020-10-25',1),(65,107,186,'0','2020-10-25','0','2020-10-25',1),(65,108,386,'0','2020-10-25','0','2020-10-25',1),(65,109,106,'0','2020-10-25','0','2020-10-25',1),(65,110,103,'0','2020-10-25','0','2020-10-25',1),(65,111,469,'0','2020-10-25','0','2020-10-25',1),(66,102,550,'0','2020-10-25','0','2020-10-25',1),(66,103,550,'0','2020-10-25','0','2020-10-25',1),(66,106,81,'0','2020-10-25','0','2020-10-25',1),(66,107,186,'0','2020-10-25','0','2020-10-25',1),(66,108,386,'0','2020-10-25','0','2020-10-25',1),(66,109,106,'0','2020-10-25','0','2020-10-25',1),(66,110,103,'0','2020-10-25','0','2020-10-25',1),(66,111,469,'0','2020-10-25','0','2020-10-25',1),(67,102,550,'0','2020-10-25','0','2020-10-25',1),(67,104,550,'0','2020-10-25','0','2020-10-25',1),(67,106,81,'0','2020-10-25','0','2020-10-25',1),(67,107,186,'0','2020-10-25','0','2020-10-25',1),(67,108,386,'0','2020-10-25','0','2020-10-25',1),(67,109,106,'0','2020-10-25','0','2020-10-25',1),(67,110,103,'0','2020-10-25','0','2020-10-25',1),(67,111,469,'0','2020-10-25','0','2020-10-25',1);
/*!40000 ALTER TABLE `WAREHOUSE_STOCK_LEVELS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `DISCOUNTS`
--

/*!50001 DROP TABLE IF EXISTS `DISCOUNTS`*/;
/*!50001 DROP VIEW IF EXISTS `DISCOUNTS`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`admin`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `DISCOUNTS` AS select `DISCOUNT_TRANSLATIONS`.`DISCOUNT_ID` AS `DISCOUNT_ID`,`DISCOUNT_TRANSLATIONS`.`DESCRIPTION` AS `DESCRIPTION`,`DISCOUNTS_BASE`.`DISCOUNT_TYPE_CODE` AS `DISCOUNT_TYPE_CODE`,`DISCOUNTS_BASE`.`DISCOUNT_AMOUNT` AS `DISCOUNT_AMOUNT`,`DISCOUNTS_BASE`.`APPLY_AS_PERCENTAGE_FLAG` AS `APPLY_AS_PERCENTAGE_FLAG`,`DISCOUNTS_BASE`.`EASY_CODE` AS `EASY_CODE`,`DISCOUNTS_BASE`.`ADD_FREE_SHIPPING_FLAG` AS `ADD_FREE_SHIPPING_FLAG`,`DISCOUNTS_BASE`.`ONETIME_DISCOUNT_FLAG` AS `ONETIME_DISCOUNT_FLAG` from (`DISCOUNT_TRANSLATIONS` join `DISCOUNTS_BASE` on(`DISCOUNT_TRANSLATIONS`.`DISCOUNT_ID` = `DISCOUNTS_BASE`.`DISCOUNT_ID`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `MEMBERSHIPS`
--

/*!50001 DROP TABLE IF EXISTS `MEMBERSHIPS`*/;
/*!50001 DROP VIEW IF EXISTS `MEMBERSHIPS`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`admin`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `MEMBERSHIPS` AS select `MEMBERSHIP_TRANSLATIONS`.`MEMBERSHIP_ID` AS `MEMBERSHIP_ID`,`MEMBERSHIPS_BASE`.`MEMBERSHIP_TYPE_CODE` AS `MEMBERSHIP_TYPE_CODE`,`MEMBERSHIP_TRANSLATIONS`.`MEMBERSHIP_NAME` AS `MEMBERSHIP_NAME`,`MEMBERSHIP_TRANSLATIONS`.`DESCRIPTION` AS `DESCRIPTION`,`MEMBERSHIPS_BASE`.`CONTACT_ID` AS `CONTACT_ID` from (`MEMBERSHIP_TRANSLATIONS` join `MEMBERSHIPS_BASE` on(`MEMBERSHIP_TRANSLATIONS`.`MEMBERSHIP_ID` = `MEMBERSHIPS_BASE`.`MEMBERSHIP_ID`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `PERSON_INFORMATION`
--

/*!50001 DROP TABLE IF EXISTS `PERSON_INFORMATION`*/;
/*!50001 DROP VIEW IF EXISTS `PERSON_INFORMATION`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`admin`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `PERSON_INFORMATION` AS select `PERSONS`.`PERSON_ID` AS `CUSTOMER_ID`,`PERSONS`.`PRINCIPAL_NAME` AS `PRINCIPAL_NAME`,`PERSONS`.`TITLE` AS `TITLE`,`PERSONS`.`FIRST_NAME` AS `FIRST_NAME`,`PERSONS`.`LAST_NAME` AS `LAST_NAME`,`ADDRESSES1`.`ADDRESS1` AS `ADDRESS1`,`ADDRESSES1`.`ADDRESS2` AS `ADDRESS2`,`ADDRESSES1`.`CITY` AS `CITY`,`ADDRESSES1`.`POSTAL_CODE` AS `POSTAL_CODE`,`ADDRESSES1`.`STATE_PROVINCE` AS `STATE_PROVINCE`,`ADDRESSES1`.`COUNTRY_ID` AS `COUNTRY_ID`,`ADDRESSES1`.`LONGITUDE` AS `LONGITUDE`,`ADDRESSES1`.`LATITUDE` AS `LATITUDE`,`PERSONS`.`CONFIRMED_EMAIL` AS `CONFIRMED_EMAIL`,`PERSONS`.`PHONE_INT` AS `PHONE_INT`,`PERSONS`.`MOBILE_PHONE_INT` AS `MOBILE_PHONE_INT`,`PERSONS`.`REGISTERED_DATE` AS `REGISTERED_DATE`,`PERSONS`.`MEMBERSHIP_ID` AS `MEMBERSHIP_ID`,`PERSONS`.`CREDIT_LIMIT` AS `CREDIT_LIMIT`,`PERSONS`.`DATE_OF_BIRTH` AS `DATE_OF_BIRTH`,`PERSONS`.`MARITAL_STATUS_CODE` AS `MARITAL_STATUS_CODE`,`PERSONS`.`GENDER` AS `GENDER`,`PERSONS`.`CHILDREN_UNDER_18` AS `CHILDREN_UNDER_18`,`PERSONS`.`APPROXIMATE_INCOME` AS `APPROXIMATE_INCOME`,`PERSONS`.`CONTACT_METHOD_CODE` AS `CONTACT_METHOD_CODE`,`PERSONS`.`CONTACTABLE_FLAG` AS `CONTACTABLE_FLAG`,`PERSONS`.`CONTACT_BY_AFFILLIATES_FLAG` AS `CONTACT_BY_AFFILLIATES_FLAG` from (`PERSONS` join `ADDRESSES` `ADDRESSES1` on(`PERSONS`.`PRIMARY_ADDRESS_ID` = `ADDRESSES1`.`ADDRESS_ID`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `PRODUCTS`
--

/*!50001 DROP TABLE IF EXISTS `PRODUCTS`*/;
/*!50001 DROP VIEW IF EXISTS `PRODUCTS`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`admin`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `PRODUCTS` AS select `PRODUCT_TRANSLATIONS`.`DESCRIPTION` AS `DESCRIPTION`,`PRODUCT_TRANSLATIONS`.`ADDITIONAL_INFO` AS `ADDITIONAL_INFO`,`PRODUCTS_BASE`.`COST_PRICE` AS `COST_PRICE`,`PRODUCTS_BASE`.`SUPPLIER_ID` AS `SUPPLIER_ID`,`PRODUCTS_BASE`.`PRODUCT_NAME` AS `PRODUCT_NAME`,`PRODUCTS_BASE`.`LIST_PRICE` AS `LIST_PRICE`,`PRODUCT_TRANSLATIONS`.`PRODUCT_ID` AS `PRODUCT_ID`,`PRODUCTS_BASE`.`CATEGORY_ID` AS `CATEGORY_ID`,`PRODUCTS_BASE`.`MIN_PRICE` AS `MIN_PRICE`,`PRODUCTS_BASE`.`WARRANTY_PERIOD_MONTHS` AS `WARRANTY_PERIOD_MONTHS`,`PRODUCTS_BASE`.`SHIPPING_CLASS_CODE` AS `SHIPPING_CLASS_CODE`,`PRODUCTS_BASE`.`EXTERNAL_URL` AS `EXTERNAL_URL`,`PRODUCTS_BASE`.`ATTRIBUTE_CATEGORY` AS `ATTRIBUTE_CATEGORY`,`PRODUCTS_BASE`.`ATTRIBUTE15` AS `ATTRIBUTE15`,`PRODUCTS_BASE`.`ATTRIBUTE1` AS `ATTRIBUTE1`,`PRODUCTS_BASE`.`ATTRIBUTE2` AS `ATTRIBUTE2`,`PRODUCTS_BASE`.`ATTRIBUTE3` AS `ATTRIBUTE3`,`PRODUCTS_BASE`.`ATTRIBUTE4` AS `ATTRIBUTE4`,`PRODUCTS_BASE`.`ATTRIBUTE5` AS `ATTRIBUTE5`,`PRODUCTS_BASE`.`ATTRIBUTE6` AS `ATTRIBUTE6`,`PRODUCTS_BASE`.`ATTRIBUTE7` AS `ATTRIBUTE7`,`PRODUCTS_BASE`.`ATTRIBUTE8` AS `ATTRIBUTE8`,`PRODUCTS_BASE`.`ATTRIBUTE9` AS `ATTRIBUTE9`,`PRODUCTS_BASE`.`ATTRIBUTE10` AS `ATTRIBUTE10`,`PRODUCTS_BASE`.`ATTRIBUTE11` AS `ATTRIBUTE11`,`PRODUCTS_BASE`.`ATTRIBUTE12` AS `ATTRIBUTE12`,`PRODUCTS_BASE`.`ATTRIBUTE13` AS `ATTRIBUTE13`,`PRODUCTS_BASE`.`ATTRIBUTE14` AS `ATTRIBUTE14` from (`PRODUCT_TRANSLATIONS` join `PRODUCTS_BASE` on(`PRODUCT_TRANSLATIONS`.`PRODUCT_ID` = `PRODUCTS_BASE`.`PRODUCT_ID`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `PRODUCT_CATEGORIES`
--

/*!50001 DROP TABLE IF EXISTS `PRODUCT_CATEGORIES`*/;
/*!50001 DROP VIEW IF EXISTS `PRODUCT_CATEGORIES`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`admin`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `PRODUCT_CATEGORIES` AS select `CATEGORY_TRANSLATIONS`.`CATEGORY_NAME` AS `CATEGORY_NAME`,`CATEGORY_TRANSLATIONS`.`CATEGORY_DESCRIPTION` AS `CATEGORY_DESCRIPTION`,`CATEGORY_TRANSLATIONS`.`CATEGORY_ID` AS `CATEGORY_ID`,`PRODUCT_CATEGORIES_BASE`.`PARENT_CATEGORY_ID` AS `PARENT_CATEGORY_ID`,`PRODUCT_CATEGORIES_BASE`.`CATEGORY_LOCKED_FLAG` AS `CATEGORY_LOCKED_FLAG`,`PRODUCT_IMAGES`.`IMAGE` AS `IMAGE` from ((`CATEGORY_TRANSLATIONS` join `PRODUCT_CATEGORIES_BASE` on(`CATEGORY_TRANSLATIONS`.`CATEGORY_ID` = `PRODUCT_CATEGORIES_BASE`.`CATEGORY_ID`)) join `PRODUCT_IMAGES`) where `PRODUCT_IMAGES`.`PRODUCT_ID` = `PRODUCT_CATEGORIES_BASE`.`REPRESENTATIVE_PRODUCT_ID` and `PRODUCT_IMAGES`.`DEFAULT_VIEW_FLAG` = 'Y' */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `SHIPPING_OPTIONS`
--

/*!50001 DROP TABLE IF EXISTS `SHIPPING_OPTIONS`*/;
/*!50001 DROP VIEW IF EXISTS `SHIPPING_OPTIONS`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`admin`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `SHIPPING_OPTIONS` AS select `SHIPPING_OPTION_TRANSLATIONS`.`SHIPPING_METHOD` AS `SHIPPING_METHOD`,`SHIPPING_OPTION_TRANSLATIONS`.`SHIPPING_OPTION_ID` AS `SHIPPING_OPTION_ID`,`SHIPPING_OPTIONS_BASE`.`COUNTRY_CODE` AS `COUNTRY_CODE`,`SHIPPING_OPTIONS_BASE`.`COST_PER_CLASS1_ITEM` AS `COST_PER_CLASS1_ITEM`,`SHIPPING_OPTIONS_BASE`.`COST_PER_CLASS2_ITEM` AS `COST_PER_CLASS2_ITEM`,`SHIPPING_OPTIONS_BASE`.`COST_PER_CLASS3_ITEM` AS `COST_PER_CLASS3_ITEM`,`SHIPPING_OPTIONS_BASE`.`FREE_SHIPPING_ALLOWED_FLAG` AS `FREE_SHIPPING_ALLOWED_FLAG` from (`SHIPPING_OPTION_TRANSLATIONS` join `SHIPPING_OPTIONS_BASE` on(`SHIPPING_OPTION_TRANSLATIONS`.`SHIPPING_OPTION_ID` = `SHIPPING_OPTIONS_BASE`.`SHIPPING_OPTION_ID`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-25 22:54:06
