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

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
                         `userID` int NOT NULL,
                         `userName` varchar(20) NOT NULL,
                         `fullname` varchar(50) NOT NULL,
                         `email` varchar(50) NOT NULL,
                         `password` varchar(50) NOT NULL,
                         `regDate` date NOT NULL,
                         PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `users` WRITE;
INSERT INTO `users` VALUES (202200668,'hung','Thai Ba Hung','22hung.tb@vinuni.edu.vn','hung','2023-06-01');
UNLOCK TABLES;


DROP TABLE IF EXISTS `items`;
CREATE TABLE `items` (
                         `itemID` int NOT NULL,
                         `name` varchar(30) NOT NULL,
                         `condition` varchar(20) NOT NULL,
                         `quantity` int NOT NULL,
                         PRIMARY KEY (`itemID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `items` WRITE;
INSERT INTO `items` VALUES (100, 'bracket', 'available', 10);
UNLOCK TABLES;

DROP TABLE IF EXISTS `bookings`;
CREATE TABLE `bookings` (
                            `bookingID` int AUTO_INCREMENT,
                            `userID` int NOT NULL,
                            `itemID` int NOT NULL,
                            `quantity` int NOT NULL,
                            `borrowDate` date NOT NULL,
                            `borrowReturn` date NOT NULL,
                            PRIMARY KEY (`bookingid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `bookings` WRITE;
INSERT INTO `bookings` VALUES (0, 202200668, 101, 1, '2023-05-29', '2023-05-31');
UNLOCK TABLES;


DROP TABLE IF EXISTS `admins`;
CREATE TABLE `admins` (
                          `adminID` int NOT NULL AUTO_INCREMENT,
                          `userName` varchar(20) NOT NULL,
                          `fullname` varchar(50) NOT NULL,
                          `email` varchar(50) NOT NULL,
                          `password` varchar(50) NOT NULL,
                          `regDate` date NOT NULL,
                          PRIMARY KEY (`adminID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `admins` WRITE;
INSERT INTO `admins` VALUES (202200795,'jhon','Jhon Nguyen','22anh.nkd@vinuni.edu.vn','john','2023-05-29'),
                            (202100358,'tri','Le Minh Tri','22tri.lm@vinuni.edu.vn','tri','2023-06-01');
UNLOCK TABLES;


DROP TABLE IF EXISTS `sport`;
CREATE TABLE `sport` (
                          `sportID` int NOT NULL AUTO_INCREMENT,
                          `userName` varchar(20) NOT NULL,
                          PRIMARY KEY (`sportID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `sport` WRITE;
INSERT INTO `sport` VALUES (101, 'badminton'), (102, 'swimming');
UNLOCK TABLES;