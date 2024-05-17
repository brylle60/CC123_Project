-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: user_schema
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_info` (
  `idUser_Id` int NOT NULL AUTO_INCREMENT,
  `User_name` varchar(45) NOT NULL,
  `User_email` varchar(45) DEFAULT NULL,
  `user_password` varchar(45) NOT NULL,
  `logged_in_users` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idUser_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` VALUES (12,'username','username@gmail.com','password',NULL),(13,'username',NULL,'password',NULL),(14,'username1234',NULL,'password',NULL),(15,'username',NULL,'password',NULL),(16,'username',NULL,'password',NULL),(17,'user_name123',NULL,'password',NULL),(18,'username',NULL,'password',NULL),(19,'username',NULL,'password',NULL),(20,'username',NULL,'password',NULL),(21,'username',NULL,'password',NULL),(22,'123456',NULL,'password',NULL),(23,'username',NULL,'password',NULL),(24,'carlrey',NULL,'carlrey123',NULL),(25,'brylle',NULL,'password',NULL),(26,'username',NULL,'password',1),(27,'username',NULL,'password',1),(28,'crodua',NULL,'brylle',NULL),(29,'brylle123',NULL,'password',1),(30,'crodua12',NULL,'password',1),(32,'username',NULL,'password',1),(33,'username',NULL,'password',1),(34,'johnbrylle',NULL,'crodua',1),(35,'wwwwww',NULL,'password',1),(36,'username','example@email.com','password',1),(37,'john1234','johnbryllecrodua@gmail.com','password',1),(38,'anything','example@email.com','password',1),(39,'johnbrylle12','brylle@gamil.com','brylle',1),(40,'john12345','johnbrylle@gmail.com','brylle',1),(41,'mingmong','mingmong@gmail.com','123abc',1);
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-16 17:45:08
