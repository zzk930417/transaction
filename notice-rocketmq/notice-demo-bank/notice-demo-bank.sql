/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.6.47-log : Database - bank1
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bank1` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bank1`;

/*Table structure for table `account_info` */

DROP TABLE IF EXISTS `account_info`;

CREATE TABLE `account_info` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `account_name` VARCHAR(100) DEFAULT NULL,
  `account_no` VARCHAR(100) DEFAULT NULL,
  `account_balance` DOUBLE DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE de_duplication (
   tx_no VARCHAR(64) NOT NULL COMMENT '事务id',
   create_time DATETIME,
   PRIMARY KEY (`tx_no`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `account_info` */

INSERT  INTO `account_info`(`id`,`account_name`,`account_no`,`account_balance`) VALUES (1,'张三的账号','1',100);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
