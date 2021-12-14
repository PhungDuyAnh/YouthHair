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
  `Username` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  PRIMARY KEY (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES ('admin','admin'),('staff','staff');
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authorities` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Username` varchar(45) NOT NULL,
  `RoleId` int NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK_authority_account_idx` (`Username`),
  KEY `FK_authority_role_idx` (`RoleId`),
  CONSTRAINT `FK_authority_account` FOREIGN KEY (`Username`) REFERENCES `accounts` (`Username`),
  CONSTRAINT `FK_authority_role` FOREIGN KEY (`RoleId`) REFERENCES `roles` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` VALUES (1,'admin',1),(2,'staff',3);
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
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
  `TimeBooking` varchar(45) NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (1,'2021-11-11',500000,'00:40:00','A',1,'CAN',1,NULL,NULL),(2,'2021-11-11',50000,'00:40:00','BV',2,'CPM',2,3,NULL),(3,'2021-11-11',100000,'00:40:00','C',3,'WFP',3,1,NULL),(4,'2021-11-11',500000,'00:40:00','D',1,'CPM',1,2,NULL),(5,'2021-11-11',800000,'03:30:00','F',7,'WFC',2,3,NULL),(6,'2021-11-11',500000,'00:40:00','G',3,'CPM',3,2,NULL),(8,'2021-11-21',500000,'00:40:00','TestData',3,'CPM',3,3,NULL),(9,'2021-11-21',1000000,'01:30:00','TestData2',2,'CPM',1,2,NULL),(10,'2021-11-19',100000,'00:30:00','A2',1,'CAN',6,NULL,NULL),(11,'2021-11-25',400000,'02:00:00','aaaaa',3,'IAT',12,NULL,NULL),(12,'2021-11-25',30000,'00:10:00','aaaaa',1,'WFC',16,NULL,NULL),(13,'2021-11-27',330000,'01:40:00',NULL,8,'IAT',22,NULL,NULL),(14,'2021-11-27',400000,'01:30:00','lobo',1,'WFC',23,NULL,NULL),(15,'2021-11-28',300000,'01:30:00',NULL,1,'WFC',26,NULL,NULL),(16,'2021-11-28',330000,'01:40:00','ádfghjkl',7,'IAT',28,NULL,NULL),(17,'2021-11-29',700000,'03:00:00','Cccccc',3,'WFC',25,NULL,NULL),(18,'2021-11-30',30000,'00:00:00',NULL,1,'CAN',29,NULL,NULL),(19,'2021-12-01',330000,'01:40:00',NULL,1,'IAT',30,NULL,NULL),(20,'2021-12-30',100000,'00:30:00',NULL,1,'UCF',30,NULL,NULL),(21,'2021-12-31',130000,'00:40:00',NULL,3,'UCF',31,NULL,NULL),(22,'2021-12-08',100000,'00:30:00',NULL,1,'UCF',32,NULL,NULL),(23,'2021-12-08',100000,'00:30:00',NULL,8,'UCF',33,NULL,NULL),(24,'2021-12-08',100000,'00:30:00',NULL,1,'UCF',34,NULL,NULL),(25,'2021-12-08',100000,'00:30:00',NULL,1,'UCF',35,NULL,NULL),(26,'2021-12-08',130000,'00:40:00',NULL,1,'UCF',36,NULL,NULL);
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookingdetails`
--

DROP TABLE IF EXISTS `bookingdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookingdetails` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `BookingId` int NOT NULL,
  `ServiceId` int NOT NULL,
  `Price` float NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK_BookingDetai_Service_idx` (`ServiceId`),
  KEY `FK_BookingDetai_Booking` (`BookingId`),
  CONSTRAINT `FK_BookingDetai_Booking` FOREIGN KEY (`BookingId`) REFERENCES `booking` (`Id`),
  CONSTRAINT `FK_BookingDetai_Service` FOREIGN KEY (`ServiceId`) REFERENCES `services` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookingdetails`
--

LOCK TABLES `bookingdetails` WRITE;
/*!40000 ALTER TABLE `bookingdetails` DISABLE KEYS */;
INSERT INTO `bookingdetails` VALUES (60,13,2,30000),(61,13,4,300000);
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
INSERT INTO `contacts` VALUES (3,'Nguyễn Doãn Mạnh Toàn','0123456789','nam@gmail.com',1,'2021-11-21','Ồ'),(4,'Nguyễn Văn Dũng','0987678912','thanh@gmail.com',0,'2021-11-21','thanh nek'),(5,'Vương Sỹ Thị Quỳnh','0123321123','phongdt@gmail.com',0,'2021-11-21','p'),(6,'Nguyễn Thị Thùy Trang','0999999998','da@gmail.com',1,'2021-11-20','da'),(7,'Trần Đại Nghĩa','0987678987','hpt@gmail.com',1,'2021-11-12','h'),(8,'Nguyễn Phương Hằng','0123456543','dlx@gmail.com',1,'2021-11-19','dl'),(10,'Đàm Vĩnh Hưng','0987654321','test@gmail.com',0,'2021-11-21','test note'),(13,'Nguyễn Thị Thủy  Tiên','0987654323','test3@gmail.com',0,'2021-11-21','notest3'),(15,'Lê Công Vinh','0987654322','test2@gmail.com',0,'2021-11-21','notest23'),(17,'Lê Thị Linh','0987654324','test4@gmail.com',0,'2021-11-21','notest4');
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
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,'Ngô Văn Hải','Hai@gmail.com','0966028059'),(2,'Phan Thị Huyền','Huyen@gmail.com','0987654321'),(3,'Phùng Duy Anh','danh@gmail.com','0987654322'),(4,'Phong Thanh Đặng','phongdt@gmail.com','0987654323'),(5,'Thành Nam','namnt@gmail.com','0987654324'),(6,'Dương Lê','duongle@gmail.com','0987654325'),(7,'Thành Nguyễn','thanh@gmail.com','0987654326'),(8,'Nguyễn Công Thành','test@gmail.com','0987654321'),(9,'Dương Xuân Pháp','test2@gmail.com','0987654322'),(10,'Dương Lan Hương','test3@gmail.com','0987654323'),(11,'Nguyễn Thị Thùy Trang','test4@gmail.com','0987654324'),(12,'Nguyễn Lê Hoàng','dmNccm@jsdg','0987652122'),(13,'Hoàng Quang Minh','dmNccm@jsdg','0987652123'),(14,'Nguyễn Minh Đức','dmNccm@jsdg','0987652124'),(15,'Viên Văn Thoại','dmNccm@jsdg','0987652125'),(16,'Nguyễn Ngọc Anh','dmuyt@jsdg','0987652126'),(22,'Nguyễn Hồng Gấm','hainvph11578@fpt.edu.vn','0123456'),(23,'Bùi Thị Hoàng','hainvph11578@fpt.edu.vn','05555555555'),(24,'Nguyễn Vũ Hồng Nhung','hai@gmail.com','031321113'),(25,'Trần Thị Hậu','admin@gmail.com','123'),(26,'Nguyễn Văn Đạt','dd@gaiiii','0123'),(27,'Nguyễn Trung kiên','haii123@haaaa','0321654'),(28,'Hoàng Thanh Bình','admin@gmail.com','036987125'),(29,'Nguyễn Thị Phượng','',''),(30,'Nguyễn Thị Mỹ Duyên','kimtinh324@gmail.com','0977116022'),(31,'Lê Thành Hưng','hainv578@gmail.com','0977111111'),(32,'Lê Đắc Tùng','kimtinh324@gmail.com','0911116022'),(33,'Vũ Văn Tuấn','buidao1705@gmail.com','0977116027'),(34,'Phùng Duy Anh','kimtinh324@gmail.com','0977116026'),(35,'Nguyễn Thành Nam','kimtinh324@gmail.com','0977116025'),(36,'Nguyễn Đăng Khoa','kimtinh324@gmail.com','0977116033');
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
  `Nickname` varchar(45) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'Nguyễn Công Thành',NULL,1,'person_1.jpg','0987654321','Hai@gmail.com',5000000,'2021-11-11',1,2),(2,'Nguyễn Thành Nam',NULL,1,'person_2.jpg','0987654321','Hai@gmail.com',5000000,'2021-11-11',0,2),(3,'Phan Thị Huyền',NULL,1,'person_3.jpg','0987654321','Hai@gmail.com',5000000,'2021-11-11',1,2),(4,'Phùng Duy Anh',NULL,0,'person_4.jpg','0987654321','Hai@gmail.com',5000000,'2021-11-11',0,3),(5,'Ngô Văn Hải',NULL,0,'person_5.jpg','0987654321','Hai@gmail.com',5000000,'2021-11-11',1,4),(6,'Lê Xuân Dương',NULL,0,'person_6.jpg','0987654321','Hai@gmail.com',5000000,'2021-11-11',0,1),(7,'Đặng Thanh Phong',NULL,0,'person_6.jpg','031649555','aaaa',5000000,'2021-12-12',1,2),(8,'Nguyễn Thị Thùy Trang',NULL,1,'person_1.jpg','0968585858','viuyt@gmail.coij',5000000,'2021-11-10',1,2),(9,'Nguyễn Văn Đạt',NULL,0,'person_5.jpg','03121221221','cu@gmail.com',5000000,'2021-11-10',1,2);
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
INSERT INTO `services` VALUES (1,'Cắt tóc',100000,1,'1.jpg','A'),(2,'Gội đầu',30000,1,'2.jpg','B'),(3,'Uốn tóc',400000,1,'3.jpg','C'),(4,'Nhuộm tóc',300000,1,'4.jpg','D');
/*!40000 ALTER TABLE `services` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shifts`
--

DROP TABLE IF EXISTS `shifts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shifts` (
  `Id` int NOT NULL,
  `Name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shifts`
--

LOCK TABLES `shifts` WRITE;
/*!40000 ALTER TABLE `shifts` DISABLE KEYS */;
INSERT INTO `shifts` VALUES (1,'AM'),(2,'PM');
/*!40000 ALTER TABLE `shifts` ENABLE KEYS */;
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
INSERT INTO `statusbooking` VALUES ('CAN','Hủy đơn'),('COM','Đã Xác Nhận'),('CPM','Đã thanh toán'),('IAT','Đang cắt'),('UCF','Chưa xác nhận'),('WFC','Chờ cắt'),('WFP','Chờ thanh toán');
/*!40000 ALTER TABLE `statusbooking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timebooking`
--

DROP TABLE IF EXISTS `timebooking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `timebooking` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `shifts_Id` int NOT NULL,
  `Name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `shifts_fk_idx` (`shifts_Id`),
  CONSTRAINT `timebooking_shifts_fk` FOREIGN KEY (`shifts_Id`) REFERENCES `shifts` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timebooking`
--

LOCK TABLES `timebooking` WRITE;
/*!40000 ALTER TABLE `timebooking` DISABLE KEYS */;
INSERT INTO `timebooking` VALUES (1,1,'8h00'),(2,1,'8h30'),(3,1,'9h00'),(4,1,'9h30'),(5,1,'10h00'),(6,1,'10h30'),(7,1,'11h00'),(8,1,'11h30'),(9,1,'13h00'),(10,1,'13h30'),(11,1,'14h00'),(12,1,'14h30'),(13,2,'15h00'),(14,2,'15h30'),(15,2,'16h00'),(16,2,'16h30'),(17,2,'17h00'),(18,2,'17h30'),(19,2,'18h00'),(20,2,'18h30'),(21,2,'19h00'),(22,2,'19h30'),(23,2,'20h00'),(24,2,'20h30');
/*!40000 ALTER TABLE `timebooking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timebookingdetail`
--

DROP TABLE IF EXISTS `timebookingdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `timebookingdetail` (
  `Id` int NOT NULL,
  `BookingId` int NOT NULL,
  `StylistId` int NOT NULL,
  `TimeBookingId` int NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timebookingdetail`
--

LOCK TABLES `timebookingdetail` WRITE;
/*!40000 ALTER TABLE `timebookingdetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `timebookingdetail` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voucherdetail`
--

LOCK TABLES `voucherdetail` WRITE;
/*!40000 ALTER TABLE `voucherdetail` DISABLE KEYS */;
INSERT INTO `voucherdetail` VALUES (1,'HAI',1,0),(2,'HUY',2,0),(3,'NAW',3,0),(4,'HAI1',1,1),(5,'HAI2',1,1),(6,'NAM1',3,1),(7,'NAM2',3,1);
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
INSERT INTO `vouchers` VALUES ('HAI',10000,100000,'A'),('HAI1',10000,100000,'A'),('HAI2',10000,100000,'A'),('HUY',20000,50000,'B'),('NAM1',1000,800000,'H'),('NAM2',50000,10000,'D'),('NAW',30000,100000,'C');
/*!40000 ALTER TABLE `vouchers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workassign`
--

DROP TABLE IF EXISTS `workassign`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `workassign` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `employees_Id` int NOT NULL,
  `shifts_Id` int NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `employees_fk_idx` (`employees_Id`),
  KEY `shifts_fk_idx` (`shifts_Id`),
  CONSTRAINT `workassign_employees_fk` FOREIGN KEY (`employees_Id`) REFERENCES `employees` (`Id`),
  CONSTRAINT `workassign_shifts_fk` FOREIGN KEY (`shifts_Id`) REFERENCES `shifts` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workassign`
--

LOCK TABLES `workassign` WRITE;
/*!40000 ALTER TABLE `workassign` DISABLE KEYS */;
/*!40000 ALTER TABLE `workassign` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-14 14:27:10
