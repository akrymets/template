-- MySQL dump 10.13  Distrib 5.7.35, for Linux (x86_64)
--
-- Host: localhost    Database: template
-- ------------------------------------------------------
-- Server version       5.7.35


--
-- Table structure for table `hibernate_sequence`
--

USE template;

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
INSERT INTO `hibernate_sequence` VALUES (6);
UNLOCK TABLES;

--
-- Table structure for table `tutorials`
--

DROP TABLE IF EXISTS `tutorials`;
CREATE TABLE `tutorials` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `published` bit(1) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tutorials`
--

LOCK TABLES `tutorials` WRITE;
INSERT INTO `tutorials` VALUES (1,'description',1,'title4'),(2,'description',1,'title4'),(3,'description',1,'title4'),(4,'description',1,'title4'),(5,'description',1,'title4');
UNLOCK TABLES;

