-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: youthhairs
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accounts` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Username` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES (1,'admin','admin'),(2,'staff','staff');
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `CreateDate` date NOT NULL,
  `TotalPrice` float NOT NULL,
  `TotalTime` varchar(45) NOT NULL,
  `Time` time DEFAULT NULL,
  `Note` varchar(455) DEFAULT NULL,
  `StylistId` int NOT NULL,
  `StatusId` varchar(5) NOT NULL,
  `CustormerId` int NOT NULL,
  `VotingId` int DEFAULT NULL,
  `VoucherDetailsID` int DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK_booking_statusbooking_idx` (`StatusId`),
  KEY `FK_booking_customer_idx` (`CustormerId`),
  KEY `FK_booking_voting_idx` (`VotingId`),
  KEY `FK_booking_voucher_idx` (`VoucherDetailsID`),
  KEY `FK_booking_stylist_idx` (`StylistId`),
  CONSTRAINT `FK_booking_customer` FOREIGN KEY (`CustormerId`) REFERENCES `customers` (`Id`),
  CONSTRAINT `FK_booking_statusbooking` FOREIGN KEY (`StatusId`) REFERENCES `statusbooking` (`Id`),
  CONSTRAINT `FK_booking_stylist` FOREIGN KEY (`StylistId`) REFERENCES `employees` (`Id`),
  CONSTRAINT `FK_booking_voting` FOREIGN KEY (`VotingId`) REFERENCES `voting` (`Id`),
  CONSTRAINT `FK_booking_voucher` FOREIGN KEY (`VoucherDetailsID`) REFERENCES `voucherdetail` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (1,'2021-11-11',500000,'00:40:00',NULL,'A',1,'CAN',1,3,NULL),(2,'2021-11-11',50000,'00:40:00',NULL,'BV',2,'CPM',2,3,NULL),(3,'2021-11-11',500000,'00:40:00',NULL,'C',3,'IAT',3,3,NULL),(4,'2021-11-11',500000,'00:40:00',NULL,'D',1,'UCF',1,3,NULL),(5,'2021-11-11',500000,'00:40:00',NULL,'F',2,'WFC',2,3,NULL),(6,'2021-11-11',500000,'00:40:00',NULL,'G',3,'WFP',3,3,NULL);
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookingdetails`
--

DROP TABLE IF EXISTS `bookingdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookingdetails` (
  `BookingId` int NOT NULL AUTO_INCREMENT,
  `ServiceId` int NOT NULL,
  `Price` float NOT NULL,
  `Time` time NOT NULL,
  PRIMARY KEY (`BookingId`,`ServiceId`),
  KEY `FK_BookingDetai_Service_idx` (`ServiceId`),
  CONSTRAINT `FK_BookingDetai_Booking` FOREIGN KEY (`BookingId`) REFERENCES `booking` (`Id`),
  CONSTRAINT `FK_BookingDetai_Service` FOREIGN KEY (`ServiceId`) REFERENCES `services` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookingdetails`
--

LOCK TABLES `bookingdetails` WRITE;
/*!40000 ALTER TABLE `bookingdetails` DISABLE KEYS */;
INSERT INTO `bookingdetails` VALUES (1,1,100000,'00:30:00'),(1,2,30000,'00:10:00'),(2,1,100000,'00:30:00'),(3,2,30000,'00:10:00');
/*!40000 ALTER TABLE `bookingdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contacts`
--

DROP TABLE IF EXISTS `contacts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contacts` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `FullName` varchar(45) NOT NULL,
  `Phone` varchar(11) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Status` tinyint NOT NULL,
  `CreateDate` date NOT NULL,
  `Note` varchar(455) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contacts`
--

LOCK TABLES `contacts` WRITE;
/*!40000 ALTER TABLE `contacts` DISABLE KEYS */;
INSERT INTO `contacts` VALUES (3,'Nam','0123456789','nam@gmail.com',1,'2021-11-21','Ồ'),(4,'Thành','0987678912','thanh@gmail.com',0,'2021-11-21','thanh nek'),(5,'Thanh Phong','0123321123','phongdt@gmail.com',0,'2021-11-21','p'),(6,'danh','0999999998','da@gmail.com',1,'2021-11-20','da'),(7,'huyenpt','0987678987','hpt@gmail.com',1,'2021-11-12','h'),(8,'dương lê','0123456543','dlx@gmail.com',1,'2021-11-19','dl'),(10,'Test','0987654321','test@gmail.com',0,'2021-11-21','test note'),(13,'test3','0987654323','test3@gmail.com',0,'2021-11-21','notest3'),(15,'test2','0987654322','test2@gmail.com',0,'2021-11-21','notest23'),(17,'test4','0987654324','test4@gmail.com',0,'2021-11-21','notest4');
/*!40000 ALTER TABLE `contacts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `FullName` varchar(45) NOT NULL,
  `Email` varchar(145) NOT NULL,
  `Phone` varchar(11) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,'Ngô Văn Hải','Hai@gmail.com','0966028059'),(2,'Huyen Phan','Huyen@gmail.com','0987654321'),(3,'Ph DAnh','danh@gmail.com','0987654322'),(4,'Phong Thanh Đặng','phongdt@gmail.com','0987654323'),(5,'Thành Nam','namnt@gmail.com','0987654324'),(6,'Dương Lê','duongle@gmail.com','0987654325'),(7,'Thành Nguyễn','thanh@gmail.com','0987654326'),(8,'test','test@gmail.com','0987654321'),(9,'test2','test2@gmail.com','0987654322'),(10,'test3','test3@gmail.com','0987654323'),(11,'test4','test4@gmail.com','0987654324');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `FullName` varchar(45) NOT NULL,
  `Gender` tinyint NOT NULL,
  `Image` varchar(145) NOT NULL,
  `Phone` varchar(11) NOT NULL,
  `Address` varchar(45) NOT NULL,
  `Salary` int NOT NULL,
  `StartDate` date NOT NULL,
  `StatusWork` tinyint NOT NULL,
  `RolesId` int NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK_Emloyee_Role_idx` (`RolesId`),
  CONSTRAINT `FK_Emloyee_Role` FOREIGN KEY (`RolesId`) REFERENCES `roles` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'Hai1',1,'1.png','0987654321','Hai@gmail.com',987654321,'2021-11-11',1,2),(2,'Hai2',1,'1.png','0987654321','Hai@gmail.com',987654321,'2021-11-11',0,2),(3,'Hai3',1,'1.png','0987654321','Hai@gmail.com',987654321,'2021-11-11',1,2),(4,'Hai4',0,'1.png','0987654321','Hai@gmail.com',987654321,'2021-11-11',0,3),(5,'Hai5',0,'1.png','0987654321','Hai@gmail.com',987654321,'2021-11-11',1,4),(6,'Hai6',0,'1.png','0987654321','Hai@gmail.com',987654321,'2021-11-11',0,1);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'Quản lý'),(2,'Thợ cắt tóc'),(3,'Lễ tân'),(4,'Nhân viên massage'),(5,'Bảo vệ');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `services`
--

DROP TABLE IF EXISTS `services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `services` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `ServiceName` varchar(45) NOT NULL,
  `Price` float NOT NULL,
  `Time` time NOT NULL,
  `Status` tinyint NOT NULL,
  `Image` varchar(145) NOT NULL,
  `Note` varchar(455) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `services`
--

LOCK TABLES `services` WRITE;
/*!40000 ALTER TABLE `services` DISABLE KEYS */;
INSERT INTO `services` VALUES (1,'Cắt tóc',100000,'00:30:00',1,'1.png','A'),(2,'Gội đầu',30000,'00:10:00',1,'1.png','B'),(3,'Uốn tóc',400000,'01:30:00',1,'1.png','C'),(4,'Nhuộm tóc',300000,'01:30:00',1,'1.png','D');
/*!40000 ALTER TABLE `services` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `statusbooking`
--

DROP TABLE IF EXISTS `statusbooking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `statusbooking` (
  `Id` varchar(5) NOT NULL,
  `StatusName` varchar(45) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `statusbooking`
--

LOCK TABLES `statusbooking` WRITE;
/*!40000 ALTER TABLE `statusbooking` DISABLE KEYS */;
INSERT INTO `statusbooking` VALUES ('CAN','Hủy đơn'),('CPM','Đã thanh toán'),('IAT','Đang cắt'),('UCF','Chưa xác nhận'),('WFC','Chờ cắt'),('WFP','Chờ thanh toán');
/*!40000 ALTER TABLE `statusbooking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voting`
--

DROP TABLE IF EXISTS `voting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `voting` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voting`
--

LOCK TABLES `voting` WRITE;
/*!40000 ALTER TABLE `voting` DISABLE KEYS */;
INSERT INTO `voting` VALUES (1,'Không hài lòng'),(2,'Hài lòng'),(3,'Rất hài lòng');
/*!40000 ALTER TABLE `voting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voucherdetail`
--

DROP TABLE IF EXISTS `voucherdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `voucherdetail` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `VoucherId` varchar(5) NOT NULL,
  `CustomerId` int NOT NULL,
  `Status` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`),
  KEY `FK_VoucherDetail_Voucher_idx` (`VoucherId`),
  KEY `FK_VoucherDetail_Customer_idx` (`CustomerId`),
  CONSTRAINT `FK_VoucherDetail_Customer` FOREIGN KEY (`CustomerId`) REFERENCES `customers` (`Id`),
  CONSTRAINT `FK_VoucherDetail_Voucher` FOREIGN KEY (`VoucherId`) REFERENCES `vouchers` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voucherdetail`
--

LOCK TABLES `voucherdetail` WRITE;
/*!40000 ALTER TABLE `voucherdetail` DISABLE KEYS */;
INSERT INTO `voucherdetail` VALUES (1,'HAI',1,0),(2,'HUY',2,0),(3,'NAW',3,1);
/*!40000 ALTER TABLE `voucherdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vouchers`
--

DROP TABLE IF EXISTS `vouchers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vouchers` (
  `Id` varchar(5) NOT NULL,
  `Price` float NOT NULL,
  `Condition` float NOT NULL,
  `Note` varchar(455) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vouchers`
--

LOCK TABLES `vouchers` WRITE;
/*!40000 ALTER TABLE `vouchers` DISABLE KEYS */;
INSERT INTO `vouchers` VALUES ('HAI',10000,100000,'A'),('HUY',20000,100000,'B'),('NAW',30000,100000,'C');
/*!40000 ALTER TABLE `vouchers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-21 22:20:53
