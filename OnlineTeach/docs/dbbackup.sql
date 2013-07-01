/*
SQLyog Ultimate v9.62 
MySQL - 5.5.27 : Database - onlineteach
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`onlineteach` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `onlineteach`;

/*Table structure for table `t_checkattendance` */

DROP TABLE IF EXISTS `t_checkattendance`;

CREATE TABLE `t_checkattendance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `caAttendance` int(11) DEFAULT NULL,
  `stuID` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK84210C26287455A9` (`stuID`),
  CONSTRAINT `FK84210C26287455A9` FOREIGN KEY (`stuID`) REFERENCES `t_student` (`stuID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_checkattendance` */

/*Table structure for table `t_classroom` */

DROP TABLE IF EXISTS `t_classroom`;

CREATE TABLE `t_classroom` (
  `crID` int(11) NOT NULL AUTO_INCREMENT,
  `crName` varchar(20) DEFAULT NULL,
  `crType` int(11) DEFAULT NULL,
  PRIMARY KEY (`crID`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

/*Data for the table `t_classroom` */

insert  into `t_classroom`(`crID`,`crName`,`crType`) values (1,'801',1),(2,'802',1),(3,'803',1),(4,'804',1),(5,'B101',2),(6,'B102',2),(7,'A101',2),(8,'A102',2),(9,'A103',2),(10,'A104',2),(11,'A105',2),(12,'运动场1',3),(13,'运动场2',3),(14,'运动场3',3),(15,'701',1),(16,'702',1),(17,'703',1),(18,'704',1),(19,'705',1),(20,'706',1),(21,'B103',2),(22,'B104',2),(23,'B105',2),(24,'A201',2),(25,'A202',2),(26,'A203',2),(27,'A204',2),(28,'A205',2),(29,'B201',2),(30,'B202',2),(31,'B203',2),(32,'B204',2),(33,'B205',2);

/*Table structure for table `t_completionexercise` */

DROP TABLE IF EXISTS `t_completionexercise`;

CREATE TABLE `t_completionexercise` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fullTopic` longtext,
  `stdAnswer` varchar(255) DEFAULT NULL,
  `stdScore` double NOT NULL,
  `stuAnswer` varchar(255) DEFAULT NULL,
  `stuScore` double NOT NULL,
  `teacherComment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_completionexercise` */

insert  into `t_completionexercise`(`id`,`fullTopic`,`stdAnswer`,`stdScore`) values (1,'你是我的@space@，你是我的@space@，你是我的@space@，是我的@space@','\"玫瑰\",\"花\",\"爱人\",\"牵挂\"',5,NULL,0,NULL),(2,'我是一只@space@，想要@space@呀@space@，却飞也飞不高～～','\"小小小小鸟\",\"飞\",\"飞\"',5,NULL,0,NULL),(3,'羞答答的玫瑰静@space@开，慢慢地绽放她留给我的@space@，春天的手吖翻阅他的@space@，我在暗暗思量该不该将它@space@摘。','\"悄悄地\",\"情怀\",\"等待\",\"轻轻地\"',5,NULL,0,NULL),(4,'如果没有@space@，我将会是@space@，日子过的@space@，人生是否@space@','\"遇见你\",\"在那里\",\"怎么样\",\"要珍惜\"',5,NULL,0,NULL);

/*Table structure for table `t_completionexercise_t_file` */

DROP TABLE IF EXISTS `t_completionexercise_t_file`;

CREATE TABLE `t_completionexercise_t_file` (
  `t_completionexercise_id` int(11) NOT NULL,
  `topicAttachments_fileID` int(11) NOT NULL,
  `answerAttachments_fileID` int(11) NOT NULL,
  UNIQUE KEY `answerAttachments_fileID` (`answerAttachments_fileID`),
  UNIQUE KEY `topicAttachments_fileID` (`topicAttachments_fileID`),
  KEY `FK8C626747F47198FC` (`answerAttachments_fileID`),
  KEY `FK8C62674724A85F84` (`t_completionexercise_id`),
  KEY `FK8C626747544A0C2D` (`topicAttachments_fileID`),
  CONSTRAINT `FK8C626747544A0C2D` FOREIGN KEY (`topicAttachments_fileID`) REFERENCES `t_file` (`fileID`),
  CONSTRAINT `FK8C62674724A85F84` FOREIGN KEY (`t_completionexercise_id`) REFERENCES `t_completionexercise` (`id`),
  CONSTRAINT `FK8C626747F47198FC` FOREIGN KEY (`answerAttachments_fileID`) REFERENCES `t_file` (`fileID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_completionexercise_t_file` */

/*Table structure for table `t_compositecheck` */

DROP TABLE IF EXISTS `t_compositecheck`;

CREATE TABLE `t_compositecheck` (
  `stuID` int(11) NOT NULL,
  `courseID` int(11) NOT NULL,
  PRIMARY KEY (`stuID`,`courseID`),
  KEY `FK890CE60C287455A9` (`stuID`),
  KEY `FK890CE60C6C76CD92` (`courseID`),
  CONSTRAINT `FK890CE60C6C76CD92` FOREIGN KEY (`courseID`) REFERENCES `t_course` (`courseID`),
  CONSTRAINT `FK890CE60C287455A9` FOREIGN KEY (`stuID`) REFERENCES `t_student` (`stuID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_compositecheck` */

/*Table structure for table `t_course` */

DROP TABLE IF EXISTS `t_course`;

CREATE TABLE `t_course` (
  `courseID` int(11) NOT NULL AUTO_INCREMENT,
  `courseName` varchar(50) DEFAULT NULL,
  `courseDesc` varchar(200) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `roomType` int(11) DEFAULT NULL,
  PRIMARY KEY (`courseID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `t_course` */

insert  into `t_course`(`courseID`,`courseName`,`courseDesc`,`priority`,`roomType`) values (1,'大学英语','大学英语',100,2),(2,'C++程序设计','C++程序设计',100,1),(3,'Java程序设计','Java程序设计',100,1),(4,'思科网络','思科网络',100,1),(5,'计算机专业英语','计算机专业英语',100,2),(6,'数据结构','数据结构',100,2),(7,'计算机应用','计算机应用',100,1),(8,'大学物理','大学物理学',100,2),(9,'高等数学','高等数学学',100,2),(10,'大学体育','大学体育',100,3),(11,'发动机原理','发动机原理',100,2),(12,'汽车美容','汽车美容',100,2),(13,'汽车检测与维修','汽车检测与维修',100,2),(14,'初级会计实务','初级会计实务',100,2),(15,'会计基础','会计基础',100,2),(16,'会计专业英语','会计的专业英语',100,2),(17,'数钱技能','会计数钱技能',100,2);

/*Table structure for table `t_courseandteacher` */

DROP TABLE IF EXISTS `t_courseandteacher`;

CREATE TABLE `t_courseandteacher` (
  `courseID` int(11) NOT NULL,
  `teacID` int(11) NOT NULL,
  PRIMARY KEY (`courseID`,`teacID`),
  KEY `FK59D074F16C76CD92` (`courseID`),
  KEY `FK59D074F17CB97AF` (`teacID`),
  CONSTRAINT `FK59D074F17CB97AF` FOREIGN KEY (`teacID`) REFERENCES `t_teacher` (`teacID`),
  CONSTRAINT `FK59D074F16C76CD92` FOREIGN KEY (`courseID`) REFERENCES `t_course` (`courseID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_courseandteacher` */

insert  into `t_courseandteacher`(`courseID`,`teacID`) values (1,1),(1,2),(1,3),(2,4),(2,5),(2,6),(3,7),(3,8),(3,9),(4,10),(4,11),(4,12),(5,1),(5,2),(5,13),(6,3),(6,4),(6,5),(7,6),(7,7),(7,8),(8,9),(8,10),(8,11),(9,1),(9,12),(9,13),(10,2),(10,3),(10,4),(11,5),(11,6),(11,7),(12,8),(12,9),(12,10),(13,11),(13,12),(13,13),(14,1),(14,2),(14,3),(15,4),(15,5),(15,6),(16,7),(16,8),(16,9),(17,10),(17,11),(17,12);

/*Table structure for table `t_courseplanitem` */

DROP TABLE IF EXISTS `t_courseplanitem`;

CREATE TABLE `t_courseplanitem` (
  `cpID` int(11) NOT NULL AUTO_INCREMENT,
  `teacID` int(11) NOT NULL,
  `scID` int(11) NOT NULL,
  `courseID` int(11) NOT NULL,
  `crID` int(11) NOT NULL,
  `cpparagraph` int(11) DEFAULT NULL,
  `cpstate` int(11) DEFAULT NULL,
  PRIMARY KEY (`cpID`),
  KEY `FKCF89D602B47F4B6E` (`scID`),
  KEY `FKCF89D6026C76CD92` (`courseID`),
  KEY `FKCF89D602C1E7D59C` (`crID`),
  KEY `FKCF89D6027CB97AF` (`teacID`),
  CONSTRAINT `FK_courseBelongToClass` FOREIGN KEY (`scID`) REFERENCES `t_schoolclass` (`scID`),
  CONSTRAINT `FK_CourseItemRelateCourseInfo` FOREIGN KEY (`courseID`) REFERENCES `t_course` (`courseID`),
  CONSTRAINT `FK_coursePlanItemRelateTeacher` FOREIGN KEY (`teacID`) REFERENCES `t_teacher` (`teacID`),
  CONSTRAINT `FK_courseRelateClassroom` FOREIGN KEY (`crID`) REFERENCES `t_classroom` (`crID`)
) ENGINE=InnoDB AUTO_INCREMENT=405 DEFAULT CHARSET=utf8 COMMENT='课程表原子';

/*Data for the table `t_courseplanitem` */

insert  into `t_courseplanitem`(`cpID`,`teacID`,`scID`,`courseID`,`crID`,`cpparagraph`,`cpstate`) values (1,1,1,1,26,1,0),(2,13,1,5,26,2,0),(3,1,1,1,26,3,0),(4,2,1,10,13,4,0),(5,5,1,2,2,5,0),(6,13,1,5,26,6,0),(7,12,1,9,26,7,0),(8,4,1,6,26,8,0),(9,4,1,6,26,9,0),(10,7,1,3,2,10,0),(11,5,1,2,2,11,0),(12,12,1,9,26,12,0),(13,7,1,3,2,13,0),(14,5,1,2,2,14,0),(15,7,1,3,2,15,0),(16,5,1,2,2,16,0),(17,7,1,3,2,17,0),(18,2,14,10,13,1,0),(19,5,14,15,31,2,0),(20,2,14,14,31,3,0),(21,2,14,14,31,4,0),(22,10,14,17,26,5,0),(23,10,14,17,26,10,0),(24,9,14,16,26,11,0),(25,5,14,15,31,12,0),(26,5,14,15,31,13,0),(27,9,14,16,26,14,0),(28,8,14,7,1,15,0),(29,5,14,15,31,16,0),(30,8,14,7,1,17,0),(31,10,21,17,31,1,0),(32,10,21,17,31,5,0),(33,1,21,14,31,6,0),(34,1,21,14,31,7,0),(35,5,21,15,31,8,0),(36,5,21,15,31,9,0),(37,9,21,16,31,10,0),(38,7,21,7,1,11,0),(39,5,21,15,31,14,0),(40,7,21,7,1,16,0),(41,5,21,15,31,17,0),(42,9,21,16,31,18,0),(43,3,21,10,13,19,0),(44,11,25,17,7,1,0),(45,11,25,17,7,2,0),(46,5,25,15,7,3,0),(47,9,25,16,26,4,0),(48,9,25,16,26,13,0),(49,7,25,7,1,14,0),(50,7,25,7,1,18,0),(51,5,25,15,7,19,0),(52,5,25,15,7,20,0),(53,3,25,14,26,21,0),(54,3,25,10,13,22,0),(55,3,25,14,26,23,0),(56,5,25,15,7,24,0),(57,7,18,7,2,1,0),(58,1,18,1,9,2,0),(59,13,18,9,9,3,0),(60,1,18,1,9,4,0),(61,11,18,4,1,5,0),(62,2,18,5,7,6,0),(63,2,18,10,13,7,0),(64,2,18,5,7,8,0),(65,7,18,7,2,9,0),(66,7,18,7,2,12,0),(67,7,18,7,2,18,0),(68,13,18,9,9,19,0),(69,11,18,4,1,20,0),(70,11,18,4,1,21,0),(71,11,18,4,1,22,0),(72,13,15,9,9,1,0),(73,2,15,10,13,2,0),(74,6,15,2,2,3,0),(75,7,15,3,2,4,0),(76,1,15,1,7,5,0),(77,1,15,1,7,7,0),(78,13,15,9,9,8,0),(79,6,15,2,2,19,0),(80,3,15,6,26,20,0),(81,6,15,2,2,21,0),(82,7,15,3,2,22,0),(83,6,15,2,2,23,0),(84,3,15,6,26,24,0),(85,7,15,3,2,25,0),(86,7,15,3,2,26,0),(87,13,15,5,26,27,0),(88,13,15,5,26,28,0),(89,3,28,10,14,1,0),(90,6,28,15,22,2,0),(91,7,28,7,1,3,0),(92,10,28,17,7,4,0),(93,9,28,16,9,5,0),(94,9,28,16,9,6,0),(95,7,28,7,1,7,0),(96,1,28,14,22,8,0),(97,6,28,15,22,9,0),(98,10,28,17,7,10,0),(99,6,28,15,22,11,0),(100,6,28,15,22,12,0),(101,1,28,14,22,13,0),(102,4,23,10,12,1,0),(103,10,23,17,27,2,0),(104,8,23,7,19,3,0),(105,8,23,16,22,4,0),(106,8,23,7,19,5,0),(107,8,23,16,22,6,0),(108,3,23,14,9,7,0),(109,3,23,14,9,9,0),(110,5,23,15,9,10,0),(111,10,23,17,27,11,0),(112,5,23,15,9,12,0),(113,5,23,15,9,13,0),(114,5,23,15,9,14,0),(115,9,22,16,22,1,0),(116,4,22,15,23,2,0),(117,6,22,7,17,3,0),(118,4,22,15,23,4,0),(119,4,22,15,23,5,0),(120,10,22,17,27,6,0),(121,6,22,7,17,7,0),(122,10,22,17,27,8,0),(123,2,22,10,13,9,0),(124,4,22,15,23,10,0),(125,9,22,16,22,14,0),(126,1,22,14,26,15,0),(127,1,22,14,26,16,0),(128,3,6,10,14,2,0),(129,1,6,9,22,3,0),(130,13,6,13,27,4,0),(131,11,6,8,23,6,0),(132,10,6,12,22,7,0),(133,7,6,11,23,8,0),(134,13,6,13,27,9,0),(135,8,6,7,1,10,0),(136,11,6,8,23,11,0),(137,7,6,11,23,12,0),(138,8,6,7,1,13,0),(139,10,6,12,22,15,0),(140,1,6,9,22,16,0),(141,13,6,13,27,17,0),(142,13,6,13,27,18,0),(143,7,24,16,27,1,0),(144,7,24,7,2,2,0),(145,3,24,14,27,3,0),(146,3,24,14,27,5,0),(147,7,24,7,2,6,0),(148,4,24,10,14,7,0),(149,11,24,17,30,8,0),(150,11,24,17,30,9,0),(151,6,24,15,22,10,0),(152,7,24,16,27,12,0),(153,6,24,15,22,17,0),(154,6,24,15,22,18,0),(155,6,24,15,22,19,0),(156,5,13,11,23,1,0),(157,8,13,7,1,2,0),(158,4,13,10,13,3,0),(159,11,13,8,30,4,0),(160,8,13,7,1,6,0),(161,13,13,13,27,7,0),(162,9,13,12,5,8,0),(163,5,13,11,23,9,0),(164,13,13,9,27,10,0),(165,13,13,9,27,13,0),(166,9,13,12,5,14,0),(167,13,13,13,27,15,0),(168,11,13,8,30,16,0),(169,13,13,13,27,19,0),(170,13,13,13,27,20,0),(171,7,20,11,30,1,0),(172,6,20,7,19,2,0),(173,6,20,7,19,4,0),(174,9,20,8,30,6,0),(175,9,20,12,23,7,0),(176,3,20,10,13,8,0),(177,1,20,9,7,9,0),(178,1,20,9,7,11,0),(179,9,20,8,30,12,0),(180,11,20,13,7,13,0),(181,7,20,11,30,14,0),(182,9,20,12,23,15,0),(183,11,20,13,7,16,0),(184,11,20,13,7,17,0),(185,11,20,13,7,18,0),(186,4,7,10,12,2,0),(187,5,7,15,5,4,0),(188,2,7,14,22,5,0),(189,12,7,17,5,6,0),(190,8,7,7,2,7,0),(191,2,7,14,22,20,0),(192,8,7,7,2,24,0),(193,12,7,17,5,25,0),(194,5,7,15,5,26,0),(195,9,7,16,31,27,0),(196,9,7,16,31,28,0),(197,5,7,15,5,29,0),(198,5,7,15,5,30,0),(199,8,3,7,1,1,0),(200,11,3,4,17,2,0),(201,2,3,5,23,3,0),(202,2,3,5,23,13,0),(203,11,3,4,17,14,0),(204,1,3,9,31,15,0),(205,2,3,10,13,16,0),(206,1,3,1,26,17,0),(207,8,3,7,1,19,0),(208,8,3,7,1,23,0),(209,11,3,4,17,24,0),(210,8,3,7,1,25,0),(211,1,3,1,26,26,0),(212,1,3,9,31,29,0),(213,11,3,4,17,30,0),(214,12,26,17,5,1,0),(215,3,26,10,14,4,0),(216,7,26,7,17,5,0),(217,7,26,7,17,6,0),(218,7,26,16,30,7,0),(219,7,26,16,30,10,0),(220,4,26,15,31,11,0),(221,12,26,17,5,12,0),(222,3,26,14,30,13,0),(223,3,26,14,30,15,0),(224,4,26,15,31,19,0),(225,4,26,15,31,20,0),(226,4,26,15,31,21,0),(227,6,4,7,19,1,0),(228,12,4,4,4,2,0),(229,4,4,10,12,4,0),(230,6,4,7,19,6,0),(231,6,4,7,19,7,0),(232,2,4,5,25,8,0),(233,2,4,5,25,9,0),(234,6,4,7,19,10,0),(235,13,4,9,9,11,0),(236,12,4,4,4,12,0),(237,1,4,1,7,14,0),(238,12,4,4,4,15,0),(239,13,4,9,9,16,0),(240,12,4,4,4,17,0),(241,1,4,1,7,21,0),(242,3,16,6,25,1,0),(243,2,16,1,25,4,0),(244,13,16,9,30,5,0),(245,3,16,10,13,6,0),(246,8,16,3,4,7,0),(247,6,16,2,2,8,0),(248,2,16,1,25,10,0),(249,8,16,3,4,11,0),(250,8,16,3,4,13,0),(251,13,16,5,27,14,0),(252,13,16,9,30,17,0),(253,6,16,2,2,20,0),(254,6,16,2,2,27,0),(255,8,16,3,4,28,0),(256,13,16,5,27,29,0),(257,6,16,2,2,30,0),(258,3,16,6,25,2,0),(259,8,5,7,4,5,0),(260,4,5,10,14,6,0),(261,11,5,8,5,7,0),(262,7,5,11,5,13,0),(263,8,5,7,4,14,0),(264,1,5,9,27,16,0),(265,11,5,8,5,17,0),(266,7,5,11,5,18,0),(267,10,5,12,26,19,0),(268,11,5,13,9,20,0),(269,11,5,13,9,21,0),(270,1,5,9,27,22,0),(271,10,5,12,26,25,0),(272,11,5,13,9,26,0),(273,11,5,13,9,27,0),(274,3,10,10,13,5,0),(275,3,10,14,32,8,0),(276,9,10,16,5,9,0),(277,11,10,17,5,10,0),(278,3,10,14,32,11,0),(279,4,10,15,7,12,0),(280,6,10,7,19,13,0),(281,9,10,16,5,15,0),(282,6,10,7,19,16,0),(283,11,10,17,5,19,0),(284,4,10,15,7,22,0),(285,4,10,15,7,23,0),(286,4,10,15,7,25,0),(287,1,2,9,32,1,0),(288,1,2,5,32,4,0),(289,1,2,5,32,5,0),(290,7,2,3,1,8,0),(291,4,2,2,1,9,0),(292,3,2,10,13,10,0),(293,1,2,9,32,12,0),(294,2,2,1,23,14,0),(295,2,2,1,23,16,0),(296,7,2,3,1,24,0),(297,5,2,6,31,25,0),(298,5,2,6,31,26,0),(299,4,2,2,1,27,0),(300,4,2,2,1,28,0),(301,4,2,2,1,29,0),(302,7,2,3,1,30,0),(303,7,2,3,1,31,0),(304,2,17,5,11,1,0),(305,6,17,7,3,5,0),(306,2,17,5,11,6,0),(307,1,17,9,25,7,0),(308,1,17,9,25,11,0),(309,2,17,1,25,12,0),(310,2,17,1,25,13,0),(311,3,17,10,13,14,0),(312,11,17,4,19,15,0),(313,11,17,4,19,17,0),(314,6,17,7,3,18,0),(315,6,17,7,3,19,0),(316,6,17,7,3,20,0),(317,11,17,4,19,21,0),(318,11,17,4,19,22,0),(319,3,12,1,11,4,0),(320,12,12,4,20,5,0),(321,12,12,9,32,7,0),(322,12,12,9,32,9,0),(323,3,12,1,11,10,0),(324,6,12,7,19,11,0),(325,6,12,7,19,12,0),(326,6,12,7,19,14,0),(327,6,12,7,19,18,0),(328,12,12,4,20,19,0),(329,3,12,10,13,20,0),(330,12,12,4,20,21,0),(331,12,12,4,20,22,0),(332,13,12,5,31,23,0),(333,13,12,5,31,24,0),(334,9,27,16,30,2,0),(335,8,27,7,19,8,0),(336,9,27,16,30,11,0),(337,4,27,15,32,13,0),(338,4,27,10,14,14,0),(339,2,27,14,7,15,0),(340,4,27,15,32,16,0),(341,2,27,14,7,26,0),(342,8,27,7,19,27,0),(343,4,27,15,32,28,0),(344,10,27,17,26,29,0),(345,4,27,15,32,30,0),(346,10,27,17,26,18,0),(347,2,11,5,24,4,0),(348,4,11,10,14,5,0),(349,2,11,5,24,6,0),(350,5,11,6,11,7,0),(351,5,11,6,11,8,0),(352,7,11,3,19,9,0),(353,1,11,1,32,10,0),(354,5,11,2,17,15,0),(355,5,11,2,17,16,0),(356,5,11,2,17,17,0),(357,5,11,2,17,18,0),(358,7,11,3,19,19,0),(359,1,11,9,23,20,0),(360,1,11,1,32,21,0),(361,1,11,9,23,22,0),(362,7,11,3,19,23,0),(363,7,11,3,19,24,0),(364,8,19,12,5,2,0),(365,10,19,8,30,3,0),(366,8,19,12,5,5,0),(367,10,19,8,30,18,0),(368,6,19,11,23,19,0),(369,12,19,13,30,20,0),(370,13,19,9,22,21,0),(371,8,19,7,17,22,0),(372,13,19,9,22,23,0),(373,12,19,13,30,24,0),(374,2,19,10,13,25,0),(375,8,19,7,17,26,0),(376,12,19,13,30,27,0),(377,12,19,13,30,28,0),(378,6,19,11,23,29,0),(379,7,9,16,32,2,0),(380,6,9,7,17,8,0),(381,3,9,10,14,9,0),(382,4,9,15,24,10,0),(383,7,9,16,32,14,0),(384,3,9,14,9,15,0),(385,3,9,14,9,17,0),(386,4,9,15,24,18,0),(387,4,9,15,24,19,0),(388,4,9,15,24,20,0),(389,10,9,17,27,21,0),(390,6,9,7,17,23,0),(391,10,9,17,27,24,0),(392,4,8,10,14,8,0),(393,8,8,16,11,9,0),(394,2,8,14,28,10,0),(395,2,8,14,28,11,0),(396,8,8,7,1,12,0),(397,6,8,15,25,15,0),(398,10,8,17,5,16,0),(399,8,8,16,11,17,0),(400,6,8,15,25,18,0),(401,8,8,7,1,26,0),(402,6,8,15,25,27,0),(403,10,8,17,5,28,0),(404,6,8,15,25,29,0);

/*Table structure for table `t_courseware` */

DROP TABLE IF EXISTS `t_courseware`;

CREATE TABLE `t_courseware` (
  `cwareID` int(11) NOT NULL AUTO_INCREMENT,
  `cpID` int(11) NOT NULL,
  `tpCourseTime` datetime NOT NULL,
  `cwareName` varchar(50) DEFAULT NULL,
  `cwareDesc` varchar(255) DEFAULT NULL,
  `coursePlanItem` int(11) DEFAULT NULL,
  PRIMARY KEY (`cwareID`),
  KEY `FK_courseWareBelongtoTeachPlan` (`cpID`,`tpCourseTime`),
  CONSTRAINT `FK_courseWareBelongtoTeachPlan` FOREIGN KEY (`cpID`, `tpCourseTime`) REFERENCES `t_teachplan` (`cpID`, `tpCourseTime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_courseware` */

/*Table structure for table `t_coursework` */

DROP TABLE IF EXISTS `t_coursework`;

CREATE TABLE `t_coursework` (
  `cworkID` int(11) NOT NULL AUTO_INCREMENT,
  `cpID` int(11) NOT NULL,
  `tpCourseTime` datetime NOT NULL,
  `cworkTitle` varchar(100) DEFAULT NULL,
  `cworkDesc` varchar(500) DEFAULT NULL,
  `cworkType` int(11) DEFAULT NULL,
  `cworkState` varchar(8) DEFAULT NULL,
  `coursePlanItem` int(11) DEFAULT NULL,
  PRIMARY KEY (`cworkID`),
  KEY `FK_teachPlanIncludeCourseWork` (`cpID`,`tpCourseTime`),
  CONSTRAINT `FK_teachPlanIncludeCourseWork` FOREIGN KEY (`cpID`, `tpCourseTime`) REFERENCES `t_teachplan` (`cpID`, `tpCourseTime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_coursework` */

/*Table structure for table `t_exerciseset` */

DROP TABLE IF EXISTS `t_exerciseset`;

CREATE TABLE `t_exerciseset` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createDate` datetime DEFAULT NULL,
  `teacId` int(11) DEFAULT NULL,
  `stuId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1EF29C3F287455A9` (`stuId`),
  KEY `FK1EF29C3F7CB97AF` (`teacId`),
  CONSTRAINT `FK1EF29C3F7CB97AF` FOREIGN KEY (`teacId`) REFERENCES `t_teacher` (`teacID`),
  CONSTRAINT `FK1EF29C3F287455A9` FOREIGN KEY (`stuId`) REFERENCES `t_student` (`stuID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_exerciseset` */

insert  into `t_exerciseset`(`id`,`createDate`,`teacId`,`stuId`) values (1,'2013-07-01 11:07:23',17,NULL);

/*Table structure for table `t_exerciseset_t_completionexercise` */

DROP TABLE IF EXISTS `t_exerciseset_t_completionexercise`;

CREATE TABLE `t_exerciseset_t_completionexercise` (
  `t_exerciseset_id` int(11) NOT NULL,
  `completionExercise_id` int(11) NOT NULL,
  KEY `FKFFCD9F5FA00ABA70` (`t_exerciseset_id`),
  KEY `FKFFCD9F5F9A8EAD0F` (`completionExercise_id`),
  CONSTRAINT `FKFFCD9F5F9A8EAD0F` FOREIGN KEY (`completionExercise_id`) REFERENCES `t_completionexercise` (`id`),
  CONSTRAINT `FKFFCD9F5FA00ABA70` FOREIGN KEY (`t_exerciseset_id`) REFERENCES `t_exerciseset` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_exerciseset_t_completionexercise` */

insert  into `t_exerciseset_t_completionexercise`(`t_exerciseset_id`,`completionExercise_id`) values (1,1),(1,2),(1,3),(1,4);

/*Table structure for table `t_exerciseset_t_judgeexercise` */

DROP TABLE IF EXISTS `t_exerciseset_t_judgeexercise`;

CREATE TABLE `t_exerciseset_t_judgeexercise` (
  `t_exerciseset_id` int(11) NOT NULL,
  `judgeExercise_id` int(11) NOT NULL,
  KEY `FK48C7F564A00ABA70` (`t_exerciseset_id`),
  KEY `FK48C7F564B24DFAA5` (`judgeExercise_id`),
  CONSTRAINT `FK48C7F564B24DFAA5` FOREIGN KEY (`judgeExercise_id`) REFERENCES `t_judgeexercise` (`id`),
  CONSTRAINT `FK48C7F564A00ABA70` FOREIGN KEY (`t_exerciseset_id`) REFERENCES `t_exerciseset` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_exerciseset_t_judgeexercise` */

insert  into `t_exerciseset_t_judgeexercise`(`t_exerciseset_id`,`judgeExercise_id`) values (1,1),(1,2),(1,3),(1,4);

/*Table structure for table `t_exerciseset_t_questionexercise` */

DROP TABLE IF EXISTS `t_exerciseset_t_questionexercise`;

CREATE TABLE `t_exerciseset_t_questionexercise` (
  `t_exerciseset_id` int(11) NOT NULL,
  `questionExercise_id` int(11) NOT NULL,
  KEY `FK48C5BC29A00ABA70` (`t_exerciseset_id`),
  KEY `FK48C5BC2966BBE20F` (`questionExercise_id`),
  CONSTRAINT `FK48C5BC2966BBE20F` FOREIGN KEY (`questionExercise_id`) REFERENCES `t_questionexercise` (`id`),
  CONSTRAINT `FK48C5BC29A00ABA70` FOREIGN KEY (`t_exerciseset_id`) REFERENCES `t_exerciseset` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_exerciseset_t_questionexercise` */

insert  into `t_exerciseset_t_questionexercise`(`t_exerciseset_id`,`questionExercise_id`) values (1,1),(1,2);

/*Table structure for table `t_exerciseset_t_selectionexercise` */

DROP TABLE IF EXISTS `t_exerciseset_t_selectionexercise`;

CREATE TABLE `t_exerciseset_t_selectionexercise` (
  `t_exerciseset_id` int(11) NOT NULL,
  `selectionExercise_id` int(11) NOT NULL,
  KEY `FKC04BF059A00ABA70` (`t_exerciseset_id`),
  KEY `FKC04BF059F8A47D05` (`selectionExercise_id`),
  CONSTRAINT `FKC04BF059F8A47D05` FOREIGN KEY (`selectionExercise_id`) REFERENCES `t_selectionexercise` (`id`),
  CONSTRAINT `FKC04BF059A00ABA70` FOREIGN KEY (`t_exerciseset_id`) REFERENCES `t_exerciseset` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_exerciseset_t_selectionexercise` */

insert  into `t_exerciseset_t_selectionexercise`(`t_exerciseset_id`,`selectionExercise_id`) values (1,1),(1,2),(1,3),(1,4);

/*Table structure for table `t_file` */

DROP TABLE IF EXISTS `t_file`;

CREATE TABLE `t_file` (
  `fileID` int(11) NOT NULL AUTO_INCREMENT,
  `cwareID` int(11) DEFAULT NULL,
  `filePaths` text,
  `originalFileName` varchar(100) DEFAULT NULL,
  `generatedFileName` varchar(100) DEFAULT NULL,
  `uploadDateTime` datetime DEFAULT NULL,
  `downloadCount` int(11) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `generateFileName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`fileID`),
  KEY `FK_courseWareIncludeFile` (`cwareID`),
  CONSTRAINT `FK_courseWareIncludeFile` FOREIGN KEY (`cwareID`) REFERENCES `t_courseware` (`cwareID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_file` */

/*Table structure for table `t_judgeexercise` */

DROP TABLE IF EXISTS `t_judgeexercise`;

CREATE TABLE `t_judgeexercise` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fullTopic` longtext,
  `stdAnswerIsRight` tinyint(1) NOT NULL,
  `stdScore` double NOT NULL,
  `stuAnswerIsRight` tinyint(1) NOT NULL,
  `stuScore` double NOT NULL,
  `teacherComment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_judgeexercise` */

insert  into `t_judgeexercise`(`id`,`fullTopic`,`stdAnswerIsRight`,`stdScore`,`stuAnswerIsRight`,`stuScore`,`teacherComment`) values (1,'海绵宝宝是泥巴做的？',0,2,0,0,NULL),(2,'派大星是男的？',0,2,1,0,NULL),(3,'你有1块钱吗？',0,2,1,0,NULL),(4,'你是未成年？',0,2,1,0,NULL);

/*Table structure for table `t_judgeexercise_t_file` */

DROP TABLE IF EXISTS `t_judgeexercise_t_file`;

CREATE TABLE `t_judgeexercise_t_file` (
  `t_judgeexercise_id` int(11) NOT NULL,
  `topicAttachments_fileID` int(11) NOT NULL,
  UNIQUE KEY `topicAttachments_fileID` (`topicAttachments_fileID`),
  KEY `FK6964D9A2544A0C2D` (`topicAttachments_fileID`),
  KEY `FK6964D9A2B371D310` (`t_judgeexercise_id`),
  CONSTRAINT `FK6964D9A2B371D310` FOREIGN KEY (`t_judgeexercise_id`) REFERENCES `t_judgeexercise` (`id`),
  CONSTRAINT `FK6964D9A2544A0C2D` FOREIGN KEY (`topicAttachments_fileID`) REFERENCES `t_file` (`fileID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_judgeexercise_t_file` */

/*Table structure for table `t_major` */

DROP TABLE IF EXISTS `t_major`;

CREATE TABLE `t_major` (
  `majorID` int(11) NOT NULL AUTO_INCREMENT,
  `majorName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`majorID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_major` */

insert  into `t_major`(`majorID`,`majorName`) values (1,'软件技术'),(2,'计算机应用'),(3,'汽车检测与维修'),(4,'会计');

/*Table structure for table `t_majorscourse` */

DROP TABLE IF EXISTS `t_majorscourse`;

CREATE TABLE `t_majorscourse` (
  `majorID` int(11) NOT NULL,
  `courseID` int(11) NOT NULL,
  `paragraph` int(11) DEFAULT NULL,
  PRIMARY KEY (`majorID`,`courseID`),
  KEY `FKB1745C606C76CD92` (`courseID`),
  KEY `FKB1745C601D8C6F2C` (`majorID`),
  CONSTRAINT `FKB1745C601D8C6F2C` FOREIGN KEY (`majorID`) REFERENCES `t_major` (`majorID`),
  CONSTRAINT `FKB1745C606C76CD92` FOREIGN KEY (`courseID`) REFERENCES `t_course` (`courseID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_majorscourse` */

insert  into `t_majorscourse`(`majorID`,`courseID`,`paragraph`) values (1,1,2),(1,2,4),(1,3,4),(1,5,2),(1,6,2),(1,9,2),(1,10,1),(2,1,2),(2,4,4),(2,5,2),(2,7,4),(2,9,2),(2,10,1),(3,7,2),(3,8,2),(3,9,2),(3,10,1),(3,11,2),(3,12,2),(3,13,4),(4,7,2),(4,10,1),(4,14,2),(4,15,4),(4,16,2),(4,17,2);

/*Table structure for table `t_project` */

DROP TABLE IF EXISTS `t_project`;

CREATE TABLE `t_project` (
  `projID` int(11) NOT NULL AUTO_INCREMENT,
  `projDesc` varchar(255) DEFAULT NULL,
  `projTitle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`projID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_project` */

/*Table structure for table `t_projectdiv` */

DROP TABLE IF EXISTS `t_projectdiv`;

CREATE TABLE `t_projectdiv` (
  `pdID` int(11) NOT NULL,
  `pdGrade` float NOT NULL,
  `pdWorkDesc` varchar(255) DEFAULT NULL,
  `projID` int(11) NOT NULL DEFAULT '0',
  `stuID` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`projID`,`stuID`),
  KEY `FK47F1FB83287455A9` (`stuID`),
  KEY `FK47F1FB8345145D70` (`projID`),
  CONSTRAINT `FK47F1FB8345145D70` FOREIGN KEY (`projID`) REFERENCES `t_project` (`projID`),
  CONSTRAINT `FK47F1FB83287455A9` FOREIGN KEY (`stuID`) REFERENCES `t_student` (`stuID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_projectdiv` */

/*Table structure for table `t_projectgroup` */

DROP TABLE IF EXISTS `t_projectgroup`;

CREATE TABLE `t_projectgroup` (
  `pgID` int(11) NOT NULL AUTO_INCREMENT,
  `pgName` varchar(20) DEFAULT NULL,
  `pgSlogan` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pgID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_projectgroup` */

insert  into `t_projectgroup`(`pgID`,`pgName`,`pgSlogan`) values (1,'冲锋1号','冲啊');

/*Table structure for table `t_projectreply` */

DROP TABLE IF EXISTS `t_projectreply`;

CREATE TABLE `t_projectreply` (
  `projID` int(11) NOT NULL,
  `pgID` int(11) NOT NULL,
  `prID` int(11) NOT NULL,
  `prDate` datetime DEFAULT NULL,
  `prGrade` float NOT NULL,
  `prState` int(11) NOT NULL,
  PRIMARY KEY (`projID`,`pgID`),
  KEY `FK1261A53CA6D0D279` (`pgID`),
  KEY `FK1261A53C45145D70` (`projID`),
  KEY `FK1424955CA6D0D279` (`pgID`),
  KEY `FK1424955C45145D70` (`projID`),
  CONSTRAINT `FK1261A53C45145D70` FOREIGN KEY (`projID`) REFERENCES `t_project` (`projID`),
  CONSTRAINT `FK1261A53CA6D0D279` FOREIGN KEY (`pgID`) REFERENCES `t_projectgroup` (`pgID`),
  CONSTRAINT `FK1424955C45145D70` FOREIGN KEY (`projID`) REFERENCES `t_project` (`projID`),
  CONSTRAINT `FK1424955CA6D0D279` FOREIGN KEY (`pgID`) REFERENCES `t_projectgroup` (`pgID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_projectreply` */

/*Table structure for table `t_questionexercise` */

DROP TABLE IF EXISTS `t_questionexercise`;

CREATE TABLE `t_questionexercise` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fullTopic` longtext,
  `stdKeyword` longtext,
  `stdScore` double NOT NULL,
  `stuAnswer` varchar(255) DEFAULT NULL,
  `stuScore` double NOT NULL,
  `teacherComment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_questionexercise` */

insert  into `t_questionexercise`(`id`,`fullTopic`,`stdKeyword`,`stdScore`,`stuAnswer`,`stuScore`,`teacherComment`) values (1,'请，默写 林俊杰-《不潮不用花钱》','Hey greedy,don’t fret@br@What you see is what you get@br@You name it,I have it@br@What you see is what you get@br@@br@左左 左左 偏左 就用左手@br@生活 就不用 想太多@br@怦怦 怦怦 心动 张开眼睛@br@就记得当下的 强烈@br@@br@@br@有时灵光一闪而过@br@牛顿也吃苹果@br@我的念头不太罗嗦@br@@br@限时间能入座@br@@br@请你 不要到处叩叩@br@潮流需要抠抠 不小心就没抠抠@br@用力到处扣扣 花掉所有抠抠@br@钱买不到绝活@br@@br@你说 听说 听说 你听谁说@br@跟着 乱走 闹哄哄@br@通通 通通 普通 普通@br@如果不懂 不要 随便 拒绝@br@@br@有时灵光一闪而过@br@牛顿也吃苹果@br@我的念头不太罗嗦@br@限时间能入座@br@@br@请你 不要到处叩叩@br@潮流需要抠抠 不小心就没抠抠@br@用力到处扣扣 花掉所有抠抠@br@钱买不到绝活@br@@br@Little chick having chips on my sofa@br@Bearbricxs take a shit on my sofa@br@Smudge babies lying on my sofa@br@Neighborhxxds and kiks singing “so-fa”@br@@br@Little chick having chips on my sofa@br@Bearbricxs take a shit on my sofa@br@Smudge babies lying on my sofa@br@@br@Hey greedy,don’t fret@br@What you see is what you get@br@You name it,I have it@br@What you see is what you get@br@@br@请你 不要到处叩叩@br@潮流需要抠抠 不小心就没抠抠@br@用力到处扣扣 花掉所有抠抠@br@钱买不到绝活@br@@br@Hey greedy,don’t fret(叩叩)@br@What you see is what you get(叩叩)@br@You name it,I have it(不要到处叩叩)@br@What you see is what you get@br@@br@Hey greedy,don’t fret(不要到处叩叩)@br@What you see is what you get(叩叩)@br@You name it,I have it(叩叩)@br@What you see is what you get@br@@br@叩叩... 叩叩 ...',10,NULL,0,NULL),(2,'《天上掉下个猪八戒》 是一本书吗？','不',10,NULL,0,NULL);

/*Table structure for table `t_questionexercise_t_file` */

DROP TABLE IF EXISTS `t_questionexercise_t_file`;

CREATE TABLE `t_questionexercise_t_file` (
  `t_questionexercise_id` int(11) NOT NULL,
  `topicAttachments_fileID` int(11) NOT NULL,
  UNIQUE KEY `topicAttachments_fileID` (`topicAttachments_fileID`),
  KEY `FK72B333D544A0C2D` (`topicAttachments_fileID`),
  KEY `FK72B333D1119ADC4` (`t_questionexercise_id`),
  CONSTRAINT `FK72B333D1119ADC4` FOREIGN KEY (`t_questionexercise_id`) REFERENCES `t_questionexercise` (`id`),
  CONSTRAINT `FK72B333D544A0C2D` FOREIGN KEY (`topicAttachments_fileID`) REFERENCES `t_file` (`fileID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_questionexercise_t_file` */

/*Table structure for table `t_schoolclass` */

DROP TABLE IF EXISTS `t_schoolclass`;

CREATE TABLE `t_schoolclass` (
  `scID` int(11) NOT NULL AUTO_INCREMENT,
  `majorID` int(11) DEFAULT NULL,
  `scName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`scID`),
  KEY `FK3DA2A7391D8C6F2C` (`majorID`),
  CONSTRAINT `FK_classBelongToMajor` FOREIGN KEY (`majorID`) REFERENCES `t_major` (`majorID`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

/*Data for the table `t_schoolclass` */

insert  into `t_schoolclass`(`scID`,`majorID`,`scName`) values (1,1,'113-1'),(2,1,'113-2'),(3,2,'113-1'),(4,2,'113-2'),(5,3,'113-1'),(6,3,'113-2'),(7,4,'113-1'),(8,4,'113-2'),(9,4,'113-3'),(10,4,'113-5'),(11,1,'113-3'),(12,2,'113-3'),(13,3,'113-3'),(14,4,'113-6'),(15,1,'113-4'),(16,1,'113-5'),(17,2,'113-4'),(18,2,'113-5'),(19,3,'113-4'),(20,3,'113-5'),(21,4,'113-7'),(22,4,'113-8'),(23,4,'113-9'),(24,4,'113-11'),(25,4,'113-12'),(26,4,'113-13'),(27,4,'113-14'),(28,4,'113-15');

/*Table structure for table `t_selectionexercise` */

DROP TABLE IF EXISTS `t_selectionexercise`;

CREATE TABLE `t_selectionexercise` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fullTopic` longtext,
  `stdAnswer` char(1) NOT NULL,
  `stdScore` double NOT NULL,
  `stuAnswer` char(1) NOT NULL,
  `stuScore` double NOT NULL,
  `teacherComment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_selectionexercise` */

insert  into `t_selectionexercise`(`id`,`fullTopic`,`stdAnswer`,`stdScore`,`stuAnswer`,`stuScore`,`teacherComment`) values (1,'请选择最酷毙的职业：@hr@A.理发师@br@B.园丁@br@C.码农@br@D.糕帅富','D',5,'\0',0,NULL),(2,'请选择最苦逼的职业：@hr@A.理发师@br@B.园丁@br@C.程序员@br@D.糕帅富','C',5,'\0',0,NULL),(3,'请选择最高尚的职业：@hr@A.理发师@br@B.园丁@br@C.码农@br@D.糕帅富','B',5,'\0',0,NULL),(4,'请选择最有型的职业：@hr@A.理发师@br@B.园丁@br@C.码农@br@D.糕帅富','A',5,'\0',0,NULL);

/*Table structure for table `t_selectionexercise_t_file` */

DROP TABLE IF EXISTS `t_selectionexercise_t_file`;

CREATE TABLE `t_selectionexercise_t_file` (
  `t_selectionexercise_id` int(11) NOT NULL,
  `topicAttachments_fileID` int(11) NOT NULL,
  UNIQUE KEY `topicAttachments_fileID` (`topicAttachments_fileID`),
  KEY `FK6A9910D9A0027F0` (`t_selectionexercise_id`),
  KEY `FK6A9910D544A0C2D` (`topicAttachments_fileID`),
  CONSTRAINT `FK6A9910D544A0C2D` FOREIGN KEY (`topicAttachments_fileID`) REFERENCES `t_file` (`fileID`),
  CONSTRAINT `FK6A9910D9A0027F0` FOREIGN KEY (`t_selectionexercise_id`) REFERENCES `t_selectionexercise` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_selectionexercise_t_file` */

/*Table structure for table `t_student` */

DROP TABLE IF EXISTS `t_student`;

CREATE TABLE `t_student` (
  `stuID` int(11) NOT NULL AUTO_INCREMENT,
  `pgID` int(11) DEFAULT NULL,
  `scID` int(11) DEFAULT NULL,
  `stuName` varchar(20) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`stuID`),
  KEY `FK4B907570B47F4B6E` (`scID`),
  KEY `FK4B907570A6D0D279` (`pgID`),
  CONSTRAINT `FK_projectGroupIncludeStudent` FOREIGN KEY (`pgID`) REFERENCES `t_projectgroup` (`pgID`),
  CONSTRAINT `FK_studentBelongsToClass` FOREIGN KEY (`scID`) REFERENCES `t_schoolclass` (`scID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_student` */

insert  into `t_student`(`stuID`,`pgID`,`scID`,`stuName`,`password`) values (1,1,3,'陈建','password');

/*Table structure for table `t_teacher` */

DROP TABLE IF EXISTS `t_teacher`;

CREATE TABLE `t_teacher` (
  `teacID` int(11) NOT NULL AUTO_INCREMENT,
  `teacName` varchar(20) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`teacID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `t_teacher` */

insert  into `t_teacher`(`teacID`,`teacName`,`password`,`username`) values (1,'李灵黛','password','teachera'),(2,'冷文卿','password','teacherb'),(3,'韩千叶','password','teacherc'),(4,'苏普',NULL,NULL),(5,'袁冠南',NULL,NULL),(6,'顾莫言',NULL,NULL),(7,'董依依',NULL,NULL),(8,'杨若涵',NULL,NULL),(9,'滕绍武',NULL,NULL),(10,'李芊墨',NULL,NULL),(11,'刘苏曼',NULL,NULL),(12,'张盼会',NULL,NULL),(13,'赵盼盼',NULL,NULL),(14,'老师1',NULL,NULL),(15,'老师1',NULL,NULL),(16,'老师1',NULL,NULL),(17,'老师1',NULL,NULL);

/*Table structure for table `t_teachplan` */

DROP TABLE IF EXISTS `t_teachplan`;

CREATE TABLE `t_teachplan` (
  `cpID` int(11) NOT NULL,
  `tpCourseTime` datetime NOT NULL,
  `tpTeachMethod` varchar(255) DEFAULT NULL,
  `tpTeachContent` text,
  `tpTeachGoal` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`cpID`,`tpCourseTime`),
  CONSTRAINT `FK_coursePlanItemRelateTeachPlan` FOREIGN KEY (`cpID`) REFERENCES `t_courseplanitem` (`cpID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_teachplan` */

/*Table structure for table `t_workstate` */

DROP TABLE IF EXISTS `t_workstate`;

CREATE TABLE `t_workstate` (
  `cworkID` int(11) NOT NULL,
  `stuID` int(11) NOT NULL,
  `fileID` int(11) NOT NULL,
  `wsID` int(11) NOT NULL,
  `wsGrade` float DEFAULT NULL,
  `wsTeacherComment` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`cworkID`,`stuID`,`fileID`),
  KEY `FK_t_workstate2` (`stuID`),
  KEY `FK_t_workstate3` (`fileID`),
  CONSTRAINT `FK_t_workstate` FOREIGN KEY (`cworkID`) REFERENCES `t_coursework` (`cworkID`),
  CONSTRAINT `FK_t_workstate2` FOREIGN KEY (`stuID`) REFERENCES `t_student` (`stuID`),
  CONSTRAINT `FK_t_workstate3` FOREIGN KEY (`fileID`) REFERENCES `t_file` (`fileID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_workstate` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
