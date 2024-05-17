-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: user_registration
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
-- Table structure for table `user_data`
--

DROP TABLE IF EXISTS `user_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_data` (
  `user_id` int NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `m_i` varchar(20) NOT NULL,
  `time` varchar(45) DEFAULT NULL,
  `date` date DEFAULT (curdate()),
  `gender` varchar(45) NOT NULL,
  `adress` varchar(45) NOT NULL,
  `number` int NOT NULL,
  `Appointment` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_data`
--

LOCK TABLES `user_data` WRITE;
/*!40000 ALTER TABLE `user_data` DISABLE KEYS */;
INSERT INTO `user_data` VALUES (1234,'adddad','adadda','adada','12:12:12','2024-05-06','','',0,''),(123456,'crodua','john brylle','almedilla','12:12:12','2024-05-06','','',0,''),(12222,'awsa','asdada','ewrsda','15:05:26','2024-05-10','','',0,''),(122,'admin','admin','admin','15:39:12','2024-05-10','','',0,''),(122,'admin','admin','admin','15:40:14','2024-05-10','','',0,''),(122,'admin','admin','admin','15:41:38','2024-05-10','','',0,''),(12333,'crodua','brylle','almedilla','18:50:50','2024-05-13','','',0,''),(1526,'john','brylle','almedilla','16:38:15','2024-05-14','','',0,''),(122,'admin','admin','admin','11:39:12','2024-05-15','M','addres, bohol',978788,''),(12323,'crodua','john','almedilla','12:19:28','2024-05-15','M','address, bohol',98877436,''),(122,'admin','admin','admin','12:40:10','2024-05-15','M','addres, bohol',978788,'dental checkup'),(12233,'jajas','sadd','asdc','13:11:33','2024-05-15','M','asdas',23,'javax.swing.ButtonGroup@9cafa65'),(124325,'example','example','example','13:13:36','2024-05-15','M','asaas',9879586,'javax.swing.ButtonGroup@2f0639e7'),(2382483,'example','example','example','13:22:28','2024-05-15','M','asd',212331,'null'),(127378,'wqqs','asddsas','asdasd','13:24:42','2024-05-15','M','qwd',9288372,'javax.swing.ButtonGroup@5eb99cdd'),(26716,'wljke','ajaksd','asdkjk','13:29:30','2024-05-15','f','wqjejqk',9754384,'Eye Checkup'),(1526168,'kqjqwhqbdb','qlwkknsm','qwqwsaa','13:56:10','2024-05-15','F','as,msaa',96859457,'General Checkup'),(230283873,'lejssha','sajdkhkahd','sladkasj','13:57:26','2024-05-15','M','sjkasasa,sjasd',549853,'Eye Checkup'),(212312,'dsdsf','asdas','asdad','13:59:00','2024-05-15','M','sdsakjd,sajdhd',769076,'General Checkup'),(121837192,'jeqlelqke','kqweqj','wlkqwlekqe','15:27:03','2024-05-15','M','ksahjsh',9127381,'java.util.Vector$1@3f9641d8'),(62178362,'wqwkqk','wqekqwe','wqke','15:28:45','2024-05-15','M','wkeqwe',93974283,'java.util.Vector$1@64427a0d'),(217383182,'kwajksja',',s,m,asd s','laskdjk','15:46:30','2024-05-15','M','kjlskeljqhljkhkja',458347853,'Eye Checkup'),(29389301,'ekalksldald',',smd,ad',',asdmasd','16:32:44','2024-05-15','M','sjdakdak',95408549,'Dental Checkup'),(938487438,'masdkads','sakassdn','dsasdasdasdns','16:36:31','2024-05-15','M','jsakadsdjadjka',945894859,'Eye Checkup'),(2348234,'sekjskdf','kdsfjksdfj','laskdlads','17:03:56','2024-05-15','M','mdakjkdn',929830392,'General Checkup'),(7876856,'lsdalskd','asdlakdlals','lsladklas','17:05:11','2024-05-15','M','weikjsdkj',9530944,'General Checkup'),(12162112,'castillo','mark daniel','cabalang','16:06:44','2024-05-16','m','capitol site cebu city',995953575,'General Checkup'),(123456789,'dantes','mingmong','ambut','16:13:33','2024-05-16','g','palma ctu',325685646,'Eye Checkup');
/*!40000 ALTER TABLE `user_data` ENABLE KEYS */;
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
