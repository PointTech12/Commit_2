-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: phonemanagement
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `add_contact`
--

DROP TABLE IF EXISTS `add_contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `add_contact` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  `mobile` varchar(10) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `favourite` varchar(50) DEFAULT NULL,
  `group_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `add_contact`
--

LOCK TABLES `add_contact` WRITE;
/*!40000 ALTER TABLE `add_contact` DISABLE KEYS */;
INSERT INTO `add_contact` VALUES (10,'John','123456790','123455667','john@gamil.com','mumbai','no','friend'),(11,'joshua','1234567890','1234567890','josgy@gmail.com','mumbai','no','friend'),(16,'Ryan','1234567890','1234567890','jobin@gmail.com','goa','no','friend'),(19,'Joshua','1234567890','0987654321','joshua@gmail,com','Mumbai','Yes','Me'),(20,'John','1234567890','0987654321','John@gmail.com','Mumbai','Yes','Friend'),(21,'John','1234567890','0987654321','John@gmail.com','Mumbai','Yes','Friend'),(22,'John','1234567890','0987654321','John@gmail.com','Mumbai','Yes','Friend'),(23,'John','1234567890','0987654321','John@gmail.com','Mumbai','Yes','Friend'),(24,'John','1234567890','0987654321','John@gmail.com','Mumbai','Yes','Friend'),(25,'John','1234567890','0987654321','John@gmail.com','Mumbai','Yes','Friend'),(26,'Ryan','1234567890','0987654321','Ryan@gmail.com','Thane','Yes','Friend'),(27,'Ryan','1234567890','0987654321','Ryan@gmail.com','Thane','Yes','Friend'),(28,'Ryan','1234567890','0987654321','Ryan@gmail.com','Thane','Yes','Friend'),(29,'Ryan','1234567890','0987654321','Ryan@gmail.com','Thane','Yes','Friend'),(30,'Jobin','1234567890','0987654321','Jobin@gmail.com','Home','Yes','Friend'),(31,'Jobin','1234567890','0987654321','Jobin@gmail.com','Home','Yes','Friend'),(32,'Jobin','1234567890','0987654321','Jobin@gmail.com','Home','Yes','Friend'),(33,'Jobin','1234567890','0987654321','Jobin@gmail.com','Home','Yes','Friend'),(34,'Jobin','1234567890','0987654321','Jobin@gmail.com','Home','Yes','Friend');
/*!40000 ALTER TABLE `add_contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `Username` varchar(20) DEFAULT NULL,
  `password` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('admin','admin'),('john','123'),('ryan','123'),('jobin','123'),('','');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-18  9:28:25
