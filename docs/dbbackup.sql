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
drop database if EXISTS onlineteach;
create database onlineteach;
use onlineteach;

/*Table structure for table `t_answerhistory` */

DROP TABLE IF EXISTS `t_answerhistory`;

CREATE TABLE `t_answerhistory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `esId` int(11) NOT NULL,
  `tId` int(11) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_answerhistory` */

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
  `crName` varchar(255) DEFAULT NULL,
  `crType` int(11) NOT NULL,
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `t_completionexercise` */

insert  into `t_completionexercise`(`id`,`fullTopic`,`stdAnswer`,`stdScore`) values (1,'你是我的@space@，你是我的@space@，你是我的@space@，是我的@space@','\"玫瑰\",\"花\",\"爱人\",\"牵挂\"',5),(2,'我是一只@space@，想要@space@呀@space@，却飞也飞不高～～','\"小小小小鸟\",\"飞\",\"飞\"',5),(3,'羞答答的玫瑰静@space@开，慢慢地绽放她留给我的@space@，春天的手吖翻阅他的@space@，我在暗暗思量该不该将它@space@摘。','\"悄悄地\",\"情怀\",\"等待\",\"轻轻地\"',5),(4,'如果没有@space@，我将会是@space@，日子过的@space@，人生是否@space@','\"遇见你\",\"在那里\",\"怎么样\",\"要珍惜\"',5),(5,'今天早上我没有吃@space@。','早饭',1),(6,'你是我的@space@，你是我的@space@，你是我的@space@,是我的@space@','玫瑰,花,爱人,牵挂',5);

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
  `courseDesc` varchar(255) DEFAULT NULL,
  `courseName` varchar(255) DEFAULT NULL,
  `priority` int(11) NOT NULL,
  `roomType` int(11) NOT NULL,
  PRIMARY KEY (`courseID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `t_course` */

insert  into `t_course`(`courseID`,`courseDesc`,`courseName`,`priority`,`roomType`) values (1,'大学英语','大学英语',100,2),(2,'C++程序设计','C++程序设计',100,1),(3,'Java程序设计','Java程序设计',100,1),(4,'思科网络','思科网络',100,1),(5,'计算机专业英语','计算机专业英语',100,2),(6,'数据结构','数据结构',100,2),(7,'计算机应用','计算机应用',100,1),(8,'大学物理学','大学物理',100,2),(9,'高等数学学','高等数学',100,2),(10,'大学体育','大学体育',100,3),(11,'发动机原理','发动机原理',100,2),(12,'汽车美容','汽车美容',100,2),(13,'汽车检测与维修','汽车检测与维修',100,2),(14,'初级会计实务','初级会计实务',100,2),(15,'会计基础','会计基础',100,2),(16,'会计的专业英语','会计专业英语',100,2),(17,'会计数钱技能','数钱技能',100,2);

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
  `cpParagraph` int(11) DEFAULT NULL,
  `cpState` int(11) DEFAULT NULL,
  `crID` int(11) DEFAULT NULL,
  `courseID` int(11) DEFAULT NULL,
  `scID` int(11) DEFAULT NULL,
  `teacID` int(11) DEFAULT NULL,
  PRIMARY KEY (`cpID`),
  KEY `FKCF89D602B47F4B6E` (`scID`),
  KEY `FKCF89D6026C76CD92` (`courseID`),
  KEY `FKCF89D602C1E7D59C` (`crID`),
  KEY `FKCF89D6027CB97AF` (`teacID`),
  CONSTRAINT `FKCF89D6027CB97AF` FOREIGN KEY (`teacID`) REFERENCES `t_teacher` (`teacID`),
  CONSTRAINT `FKCF89D6026C76CD92` FOREIGN KEY (`courseID`) REFERENCES `t_course` (`courseID`),
  CONSTRAINT `FKCF89D602B47F4B6E` FOREIGN KEY (`scID`) REFERENCES `t_schoolclass` (`scID`),
  CONSTRAINT `FKCF89D602C1E7D59C` FOREIGN KEY (`crID`) REFERENCES `t_classroom` (`crID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_courseplanitem` */

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_exerciseset` */

insert  into `t_exerciseset`(`id`,`createDate`,`teacId`,`stuId`) values (1,'2013-07-01 14:17:20',19,1),(2,'2013-07-01 16:17:28',1,1),(3,'2013-07-01 16:19:56',2,1),(4,'2013-09-07 12:51:53',1,1);

/*Table structure for table `t_exerciseset_t_completionexercise` */

DROP TABLE IF EXISTS `t_exerciseset_t_completionexercise`;

CREATE TABLE `t_exerciseset_t_completionexercise` (
  `stuAnswer` varchar(255) DEFAULT NULL,
  `stuScore` double DEFAULT NULL,
  `teacherComment` varchar(255) DEFAULT NULL,
  `esID` int(11) NOT NULL,
  `ceID` int(11) NOT NULL,
  PRIMARY KEY (`esID`,`ceID`),
  KEY `FKFFCD9F5F3564679E` (`esID`),
  KEY `FKFFCD9F5F6FA5DA86` (`ceID`),
  CONSTRAINT `FKFFCD9F5F6FA5DA86` FOREIGN KEY (`ceID`) REFERENCES `t_completionexercise` (`id`),
  CONSTRAINT `FKFFCD9F5F3564679E` FOREIGN KEY (`esID`) REFERENCES `t_exerciseset` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_exerciseset_t_completionexercise` */

insert  into `t_exerciseset_t_completionexercise`(`stuAnswer`,`stuScore`,`teacherComment`,`esID`,`ceID`) values (NULL,NULL,NULL,1,1),(NULL,NULL,NULL,1,2),(NULL,NULL,NULL,1,3),(NULL,NULL,NULL,1,4),(NULL,NULL,NULL,2,1),(NULL,NULL,NULL,2,2),(NULL,NULL,NULL,2,3),(NULL,NULL,NULL,3,1),(NULL,NULL,NULL,3,2),(NULL,NULL,NULL,3,5);

/*Table structure for table `t_exerciseset_t_judgeexercise` */

DROP TABLE IF EXISTS `t_exerciseset_t_judgeexercise`;

CREATE TABLE `t_exerciseset_t_judgeexercise` (
  `stuAnswerIsRight` tinyint(1) DEFAULT NULL,
  `stuScore` double DEFAULT NULL,
  `teacherComment` varchar(255) DEFAULT NULL,
  `jeID` int(11) NOT NULL,
  `esID` int(11) NOT NULL,
  PRIMARY KEY (`jeID`,`esID`),
  KEY `FK48C7F564CFB89383` (`esID`),
  KEY `FK48C7F5643564679E` (`esID`),
  KEY `FK48C7F564CFBAA4D0` (`jeID`),
  CONSTRAINT `FK48C7F564CFBAA4D0` FOREIGN KEY (`jeID`) REFERENCES `t_judgeexercise` (`id`),
  CONSTRAINT `FK48C7F5643564679E` FOREIGN KEY (`esID`) REFERENCES `t_exerciseset` (`id`),
  CONSTRAINT `FK48C7F564CFB89383` FOREIGN KEY (`esID`) REFERENCES `t_judgeexercise` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_exerciseset_t_judgeexercise` */

insert  into `t_exerciseset_t_judgeexercise`(`stuAnswerIsRight`,`stuScore`,`teacherComment`,`jeID`,`esID`) values (NULL,NULL,NULL,1,1),(NULL,NULL,NULL,2,1),(NULL,NULL,NULL,2,2),(NULL,NULL,NULL,3,1),(NULL,NULL,NULL,3,2),(NULL,NULL,NULL,4,1),(NULL,NULL,NULL,4,2),(NULL,NULL,NULL,5,2);

/*Table structure for table `t_exerciseset_t_questionexercise` */

DROP TABLE IF EXISTS `t_exerciseset_t_questionexercise`;

CREATE TABLE `t_exerciseset_t_questionexercise` (
  `stuAnswer` varchar(255) DEFAULT NULL,
  `stuScore` double DEFAULT NULL,
  `teacherComment` varchar(255) DEFAULT NULL,
  `qeID` int(11) NOT NULL,
  `esID` int(11) NOT NULL,
  PRIMARY KEY (`qeID`,`esID`),
  KEY `FK48C5BC295B4F0F1C` (`esID`),
  KEY `FK48C5BC293564679E` (`esID`),
  KEY `FK48C5BC295B544F02` (`qeID`),
  CONSTRAINT `FK48C5BC295B544F02` FOREIGN KEY (`qeID`) REFERENCES `t_questionexercise` (`id`),
  CONSTRAINT `FK48C5BC293564679E` FOREIGN KEY (`esID`) REFERENCES `t_exerciseset` (`id`),
  CONSTRAINT `FK48C5BC295B4F0F1C` FOREIGN KEY (`esID`) REFERENCES `t_questionexercise` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_exerciseset_t_questionexercise` */

insert  into `t_exerciseset_t_questionexercise`(`stuAnswer`,`stuScore`,`teacherComment`,`qeID`,`esID`) values (NULL,NULL,NULL,1,1),(NULL,NULL,NULL,2,1);

/*Table structure for table `t_exerciseset_t_selectionexercise` */

DROP TABLE IF EXISTS `t_exerciseset_t_selectionexercise`;

CREATE TABLE `t_exerciseset_t_selectionexercise` (
  `stuAnswer` varchar(1) DEFAULT NULL,
  `stuScore` double DEFAULT NULL,
  `teacherComment` varchar(255) DEFAULT NULL,
  `seID` int(11) NOT NULL,
  `esID` int(11) NOT NULL,
  PRIMARY KEY (`seID`,`esID`),
  KEY `FKC04BF05985BFC378` (`esID`),
  KEY `FKC04BF0593564679E` (`esID`),
  KEY `FKC04BF05985C5EC1C` (`seID`),
  CONSTRAINT `FKC04BF05985C5EC1C` FOREIGN KEY (`seID`) REFERENCES `t_selectionexercise` (`id`),
  CONSTRAINT `FKC04BF0593564679E` FOREIGN KEY (`esID`) REFERENCES `t_exerciseset` (`id`),
  CONSTRAINT `FKC04BF05985BFC378` FOREIGN KEY (`esID`) REFERENCES `t_selectionexercise` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_exerciseset_t_selectionexercise` */

insert  into `t_exerciseset_t_selectionexercise`(`stuAnswer`,`stuScore`,`teacherComment`,`seID`,`esID`) values (NULL,NULL,NULL,1,1),(NULL,NULL,NULL,1,4),(NULL,NULL,NULL,2,1),(NULL,NULL,NULL,2,4),(NULL,NULL,NULL,3,1),(NULL,NULL,NULL,4,1);

/*Table structure for table `t_file` */

DROP TABLE IF EXISTS `t_file`;

CREATE TABLE `t_file` (
  `fileID` int(11) NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) DEFAULT NULL,
  `downloadCount` int(11) NOT NULL,
  `filePaths` varchar(255) DEFAULT NULL,
  `generateFileName` varchar(255) DEFAULT NULL,
  `originalFileName` varchar(255) DEFAULT NULL,
  `uploadDateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`fileID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_file` */

/*Table structure for table `t_judgeexercise` */

DROP TABLE IF EXISTS `t_judgeexercise`;

CREATE TABLE `t_judgeexercise` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fullTopic` longtext,
  `stdAnswerIsRight` tinyint(1) NOT NULL,
  `stdScore` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_judgeexercise` */

insert  into `t_judgeexercise`(`id`,`fullTopic`,`stdAnswerIsRight`,`stdScore`) values (1,'海绵宝宝是泥巴做的？',0,2),(2,'派大星是男的？',0,2),(3,'你有1块钱吗？',0,2),(4,'你是未成年？',0,2),(5,'1+1=2',0,5);

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
  `majorName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`majorID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_major` */

insert  into `t_major`(`majorID`,`majorName`) values (1,'软件技术'),(2,'计算机应用'),(3,'汽车检测与维修'),(4,'会计');

/*Table structure for table `t_majorscourse` */

DROP TABLE IF EXISTS `t_majorscourse`;

CREATE TABLE `t_majorscourse` (
  `paragraph` int(11) DEFAULT NULL,
  `majorID` int(11) NOT NULL,
  `courseID` int(11) NOT NULL,
  PRIMARY KEY (`majorID`,`courseID`),
  KEY `FKB1745C606C76CD92` (`courseID`),
  KEY `FKB1745C601D8C6F2C` (`majorID`),
  CONSTRAINT `FKB1745C601D8C6F2C` FOREIGN KEY (`majorID`) REFERENCES `t_major` (`majorID`),
  CONSTRAINT `FKB1745C606C76CD92` FOREIGN KEY (`courseID`) REFERENCES `t_course` (`courseID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_majorscourse` */

insert  into `t_majorscourse`(`paragraph`,`majorID`,`courseID`) values (2,1,1),(4,1,2),(4,1,3),(2,1,5),(2,1,6),(2,1,9),(1,1,10),(2,2,1),(4,2,4),(2,2,5),(4,2,7),(2,2,9),(1,2,10),(2,3,7),(2,3,8),(2,3,9),(1,3,10),(2,3,11),(2,3,12),(4,3,13),(2,4,7),(1,4,10),(2,4,14),(4,4,15),(2,4,16),(2,4,17);

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
  `pgName` varchar(255) DEFAULT NULL,
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
  PRIMARY KEY (`projID`,`pgID`),
  KEY `FK1261A53CA6D0D279` (`pgID`),
  KEY `FK1261A53C45145D70` (`projID`),
  KEY `FK1424955CA6D0D279` (`pgID`),
  KEY `FK1424955C45145D70` (`projID`),
  CONSTRAINT `FK1424955C45145D70` FOREIGN KEY (`projID`) REFERENCES `t_project` (`projID`),
  CONSTRAINT `FK1261A53C45145D70` FOREIGN KEY (`projID`) REFERENCES `t_project` (`projID`),
  CONSTRAINT `FK1261A53CA6D0D279` FOREIGN KEY (`pgID`) REFERENCES `t_projectgroup` (`pgID`),
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_questionexercise` */

insert  into `t_questionexercise`(`id`,`fullTopic`,`stdKeyword`,`stdScore`) values (1,'请，默写 林俊杰-《不潮不用花钱》','Hey greedy,don’t fret@br@What you see is what you get@br@You name it,I have it@br@What you see is what you get@br@@br@左左 左左 偏左 就用左手@br@生活 就不用 想太多@br@怦怦 怦怦 心动 张开眼睛@br@就记得当下的 强烈@br@@br@@br@有时灵光一闪而过@br@牛顿也吃苹果@br@我的念头不太罗嗦@br@@br@限时间能入座@br@@br@请你 不要到处叩叩@br@潮流需要抠抠 不小心就没抠抠@br@用力到处扣扣 花掉所有抠抠@br@钱买不到绝活@br@@br@你说 听说 听说 你听谁说@br@跟着 乱走 闹哄哄@br@通通 通通 普通 普通@br@如果不懂 不要 随便 拒绝@br@@br@有时灵光一闪而过@br@牛顿也吃苹果@br@我的念头不太罗嗦@br@限时间能入座@br@@br@请你 不要到处叩叩@br@潮流需要抠抠 不小心就没抠抠@br@用力到处扣扣 花掉所有抠抠@br@钱买不到绝活@br@@br@Little chick having chips on my sofa@br@Bearbricxs take a shit on my sofa@br@Smudge babies lying on my sofa@br@Neighborhxxds and kiks singing “so-fa”@br@@br@Little chick having chips on my sofa@br@Bearbricxs take a shit on my sofa@br@Smudge babies lying on my sofa@br@@br@Hey greedy,don’t fret@br@What you see is what you get@br@You name it,I have it@br@What you see is what you get@br@@br@请你 不要到处叩叩@br@潮流需要抠抠 不小心就没抠抠@br@用力到处扣扣 花掉所有抠抠@br@钱买不到绝活@br@@br@Hey greedy,don’t fret(叩叩)@br@What you see is what you get(叩叩)@br@You name it,I have it(不要到处叩叩)@br@What you see is what you get@br@@br@Hey greedy,don’t fret(不要到处叩叩)@br@What you see is what you get(叩叩)@br@You name it,I have it(叩叩)@br@What you see is what you get@br@@br@叩叩... 叩叩 ...',10),(2,'《天上掉下个猪八戒》 是一本书吗？','不',10);

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
  `scName` varchar(255) DEFAULT NULL,
  `majorID` int(11) DEFAULT NULL,
  PRIMARY KEY (`scID`),
  KEY `FK3DA2A7391D8C6F2C` (`majorID`),
  CONSTRAINT `FK3DA2A7391D8C6F2C` FOREIGN KEY (`majorID`) REFERENCES `t_major` (`majorID`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

/*Data for the table `t_schoolclass` */

insert  into `t_schoolclass`(`scID`,`scName`,`majorID`) values (1,'113-1',1),(2,'113-2',1),(3,'113-1',2),(4,'113-2',2),(5,'113-1',3),(6,'113-2',3),(7,'113-1',4),(8,'113-2',4),(9,'113-3',4),(10,'113-5',4),(11,'113-3',1),(12,'113-3',2),(13,'113-3',3),(14,'113-6',4),(15,'113-4',1),(16,'113-5',1),(17,'113-4',2),(18,'113-5',2),(19,'113-4',3),(20,'113-5',3),(21,'113-7',4),(22,'113-8',4),(23,'113-9',4),(24,'113-11',4),(25,'113-12',4),(26,'113-13',4),(27,'113-14',4),(28,'113-15',4);

/*Table structure for table `t_selectionexercise` */

DROP TABLE IF EXISTS `t_selectionexercise`;

CREATE TABLE `t_selectionexercise` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fullTopic` longtext,
  `stdAnswer` char(1) NOT NULL,
  `stdScore` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_selectionexercise` */

insert  into `t_selectionexercise`(`id`,`fullTopic`,`stdAnswer`,`stdScore`) values (1,'请选择最酷毙的职业：@hr@A.理发师@br@B.园丁@br@C.码农@br@D.糕帅富','D',5),(2,'请选择最苦逼的职业：@hr@A.理发师@br@B.园丁@br@C.程序员@br@D.糕帅富','C',5),(3,'请选择最高尚的职业：@hr@A.理发师@br@B.园丁@br@C.码农@br@D.糕帅富','B',5),(4,'请选择最有型的职业：@hr@A.理发师@br@B.园丁@br@C.码农@br@D.糕帅富','A',5);

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
  `password` varchar(255) DEFAULT NULL,
  `stuName` varchar(255) DEFAULT NULL,
  `pgID` int(11) DEFAULT NULL,
  `scID` int(11) DEFAULT NULL,
  PRIMARY KEY (`stuID`),
  KEY `FK4B907570B47F4B6E` (`scID`),
  KEY `FK4B907570A6D0D279` (`pgID`),
  CONSTRAINT `FK4B907570A6D0D279` FOREIGN KEY (`pgID`) REFERENCES `t_projectgroup` (`pgID`),
  CONSTRAINT `FK4B907570B47F4B6E` FOREIGN KEY (`scID`) REFERENCES `t_schoolclass` (`scID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_student` */

insert  into `t_student`(`stuID`,`password`,`stuName`,`pgID`,`scID`) values (1,'password','陈建',1,3);

/*Table structure for table `t_teacher` */

DROP TABLE IF EXISTS `t_teacher`;

CREATE TABLE `t_teacher` (
  `teacID` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `teacName` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`teacID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `t_teacher` */

insert  into `t_teacher`(`teacID`,`password`,`teacName`,`username`) values (1,'password','李灵黛','teachera'),(2,'password','冷文卿','teacherb'),(3,'password','韩千叶','teacherc'),(4,'password','苏普','teacherd'),(5,'password','袁冠南','teachere'),(6,'password','顾莫言','teacherf'),(7,'password','董依依','teacherg'),(8,'password','杨若涵','teacherh'),(9,'password','滕绍武','teacheri'),(10,'password','李芊墨',NULL),(11,'password','刘苏曼',NULL),(12,'password','张盼会',NULL),(13,'password','赵盼盼',NULL),(14,'password','老师1',NULL),(15,'password','老师1',NULL),(16,'password','老师1',NULL),(17,'password','老师1',NULL),(18,'',NULL,NULL),(19,NULL,'老师1',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
