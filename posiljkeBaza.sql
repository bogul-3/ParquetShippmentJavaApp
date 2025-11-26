/*
SQLyog Community v13.3.0 (64 bit)
MySQL - 10.4.32-MariaDB : Database - posiljkeparketa
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`posiljkeparketa` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `posiljkeparketa`;

/*Table structure for table `mesto` */

DROP TABLE IF EXISTS `mesto`;

CREATE TABLE `mesto` (
  `idMesto` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(40) NOT NULL,
  `brojProdavnica` int(11) NOT NULL,
  PRIMARY KEY (`idMesto`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `mesto` */

insert  into `mesto`(`idMesto`,`naziv`,`brojProdavnica`) values 
(1,'Beograd',2),
(2,'Vranje',1),
(3,'Krusevac',0);

/*Table structure for table `parket` */

DROP TABLE IF EXISTS `parket`;

CREATE TABLE `parket` (
  `idParket` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `dimenzije` char(6) NOT NULL,
  `drvo` varchar(20) NOT NULL,
  PRIMARY KEY (`idParket`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `parket` */

insert  into `parket`(`idParket`,`dimenzije`,`drvo`) values 
(1,'300:42','HRAST'),
(2,'350:42','HRAST'),
(3,'350:52','HRAST'),
(4,'350:62','HRAST'),
(5,'300:42','BUKVA'),
(6,'350:62','JASEN');

/*Table structure for table `posiljalac` */

DROP TABLE IF EXISTS `posiljalac`;

CREATE TABLE `posiljalac` (
  `idPosiljalac` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ime` varchar(30) NOT NULL,
  `prezime` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `sifra` varchar(20) NOT NULL,
  `datumRodjenja` date NOT NULL,
  PRIMARY KEY (`idPosiljalac`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `posiljalac` */

insert  into `posiljalac`(`idPosiljalac`,`ime`,`prezime`,`email`,`sifra`,`datumRodjenja`) values 
(1,'Mile','Dizna','mile@gmail.com','mile123','1989-11-08'),
(2,'Cane','Kurbla','canecane@gmail.com','cane123','1999-09-27');

/*Table structure for table `posskl` */

DROP TABLE IF EXISTS `posskl`;

CREATE TABLE `posskl` (
  `idPosiljalac` int(10) unsigned NOT NULL,
  `idSkladiste` int(10) unsigned NOT NULL,
  `datum` date NOT NULL,
  `vremeOd` char(5) NOT NULL,
  `vremeDo` char(5) NOT NULL,
  `brojSati` int(11) NOT NULL,
  PRIMARY KEY (`idPosiljalac`,`idSkladiste`,`datum`),
  KEY `idSkladiste` (`idSkladiste`),
  CONSTRAINT `posskl_ibfk_1` FOREIGN KEY (`idPosiljalac`) REFERENCES `posiljalac` (`idPosiljalac`),
  CONSTRAINT `posskl_ibfk_2` FOREIGN KEY (`idSkladiste`) REFERENCES `skladiste` (`idSkladiste`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `posskl` */

insert  into `posskl`(`idPosiljalac`,`idSkladiste`,`datum`,`vremeOd`,`vremeDo`,`brojSati`) values 
(1,1,'2024-12-06','08:00','16:00',8),
(2,4,'2024-12-05','8:30','15:30',7);

/*Table structure for table `potvrda` */

DROP TABLE IF EXISTS `potvrda`;

CREATE TABLE `potvrda` (
  `idPotvrda` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `datum` date NOT NULL,
  `prosecnaKolicina` double NOT NULL,
  `idPosiljalac` int(10) unsigned NOT NULL,
  `idProdavnica` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idPotvrda`),
  KEY `idPosiljalac` (`idPosiljalac`),
  KEY `idProdavnica` (`idProdavnica`),
  CONSTRAINT `potvrda_ibfk_1` FOREIGN KEY (`idPosiljalac`) REFERENCES `posiljalac` (`idPosiljalac`) ON UPDATE CASCADE,
  CONSTRAINT `potvrda_ibfk_2` FOREIGN KEY (`idProdavnica`) REFERENCES `prodavnica` (`idProdavnica`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `potvrda` */

insert  into `potvrda`(`idPotvrda`,`datum`,`prosecnaKolicina`,`idPosiljalac`,`idProdavnica`) values 
(1,'2024-12-06',58.39,1,1),
(2,'2024-12-05',51.05,2,3),
(3,'2024-12-06',39.3,1,3),
(4,'2024-12-06',39.72,1,2),
(5,'2025-09-25',36.465,1,1),
(6,'2025-12-31',54.72,1,3),
(7,'2025-11-27',49.33,1,2);

/*Table structure for table `prodavnica` */

DROP TABLE IF EXISTS `prodavnica`;

CREATE TABLE `prodavnica` (
  `idProdavnica` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) NOT NULL,
  `adresa` varchar(40) NOT NULL,
  `idMesto` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idProdavnica`),
  KEY `idMesto` (`idMesto`),
  CONSTRAINT `prodavnica_ibfk_1` FOREIGN KEY (`idMesto`) REFERENCES `mesto` (`idMesto`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `prodavnica` */

insert  into `prodavnica`(`idProdavnica`,`naziv`,`adresa`,`idMesto`) values 
(1,'Parket Market','Tosin Bunar',1),
(2,'Parket Mika','Glavna Ulica',2),
(3,'Parket Git','Hajduk Veljkova',3);

/*Table structure for table `skladiste` */

DROP TABLE IF EXISTS `skladiste`;

CREATE TABLE `skladiste` (
  `idSkladiste` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(30) NOT NULL,
  `adresa` varchar(50) NOT NULL,
  PRIMARY KEY (`idSkladiste`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `skladiste` */

insert  into `skladiste`(`idSkladiste`,`naziv`,`adresa`) values 
(1,'Hrast 1','Jove Ilica'),
(2,'Hrast 2','Cvijiceva'),
(3,'Hrast-Bukva','Glavna Zemun'),
(4,'Hrast-Jasen','Dzona Kenedija'),
(5,'Hrast Belin','Marije Bursac');

/*Table structure for table `stavkapotvrde` */

DROP TABLE IF EXISTS `stavkapotvrde`;

CREATE TABLE `stavkapotvrde` (
  `idPotvrda` int(10) unsigned NOT NULL,
  `idStavka` int(10) unsigned NOT NULL,
  `kolicina` double NOT NULL,
  `idParket` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idPotvrda`,`idStavka`),
  KEY `idStavka` (`idStavka`),
  KEY `idParket` (`idParket`),
  CONSTRAINT `stavkapotvrde_ibfk_1` FOREIGN KEY (`idParket`) REFERENCES `parket` (`idParket`) ON UPDATE CASCADE,
  CONSTRAINT `stavkapotvrde_ibfk_2` FOREIGN KEY (`idPotvrda`) REFERENCES `potvrda` (`idPotvrda`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `stavkapotvrde` */

insert  into `stavkapotvrde`(`idPotvrda`,`idStavka`,`kolicina`,`idParket`) values 
(1,1,60.54,2),
(1,2,56.24,3),
(2,1,48.52,2),
(2,2,72.32,4),
(2,3,32.32,6),
(3,1,54.04,4),
(3,2,24.56,1),
(4,1,55.2,1),
(4,2,24.24,5),
(5,1,26.62,1),
(5,2,46.31,1),
(6,1,55.88,1),
(6,2,44,2),
(6,3,79,5),
(6,4,40,6),
(7,1,52,1),
(7,2,46.66,6);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
