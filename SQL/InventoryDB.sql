/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  tbhung
 * Created: May 29, 2023
 */

CREATE DATABASE  IF NOT EXISTS `inventoryforsports`;
Use `inventoryforsports`;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userID` int NOT NULL,
  `userName` varchar(20) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `accountReg` date NOT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES (202200668,'hung','22hung.tb@vinuni.edu.vn','hung','2023-05-29');
UNLOCK TABLES;


DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `itemID` int NOT NULL,
  `Name` varchar(30) NOT NULL,
  `sportID` int NOT NULL,
  `condition` varchar(20) NOT NULL,
  PRIMARY KEY (`itemID`),
  PRIMARY KEY (`sportID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `item` WRITE;
INSERT INTO `item` VALUES (100, 'bracket', 101, 'available');
UNLOCK TABLES;


DROP TABLE IF EXISTS `sport`;
CREATE TABLE `sport` (
  `sportID` int NOT NULL,
  `Name` varchar(20) NOT NULL,
  PRIMARY KEY (`sportID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `sport` WRITE;
INSERT INTO `sport` VALUES (101, 'badminton'), (102, 'swimming');
UNLOCK TABLES;


DROP TABLE IF EXISTS `booking`;
CREATE TABLE `booking` (
  `userID` int NOT NULL,
  `BorrowDate` date NOT NULL,
  `BorrowReturn` date NOT NULL,
  `itemID` int NOT NULL,
  PRIMARY KEY (`userID`),
  PRIMARY KEY (`itemID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `booking` WRITE;
INSERT INTO `booking` VALUES (202200668, '2023-05-29', '2023-05-31', 101);
UNLOCK TABLES;


DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adminID` int NOT NULL,
  `adminName` varchar(20) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `accountReg` date NOT NULL,
  PRIMARY KEY (`adminID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `admin` WRITE;
INSERT INTO `admin` VALUES (202200795,'john','22anh.nkd@vinuni.edu.vn','john','2023-05-29');
UNLOCK TABLES;