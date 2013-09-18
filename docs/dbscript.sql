/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2013/6/5 15:26:26                            */
/*==============================================================*/
CREATE DATABASE onlineteach;
USE onlineteach;

DROP TABLE IF EXISTS t_checkAttendance;

DROP TABLE IF EXISTS t_classRoom;

DROP TABLE IF EXISTS t_compositeCheck;

DROP TABLE IF EXISTS t_course;

DROP TABLE IF EXISTS t_courseAndTeacher;

DROP TABLE IF EXISTS t_coursePlanItem;

DROP TABLE IF EXISTS t_courseWare;

DROP TABLE IF EXISTS t_courseWork;

DROP TABLE IF EXISTS t_file;

DROP TABLE IF EXISTS t_major;

DROP TABLE IF EXISTS t_majorsCourse;

DROP TABLE IF EXISTS t_project;

DROP TABLE IF EXISTS t_projectDiv;

DROP TABLE IF EXISTS t_projectGroup;

DROP TABLE IF EXISTS t_projectReply;

DROP TABLE IF EXISTS t_schoolclass;

DROP TABLE IF EXISTS t_student;

DROP TABLE IF EXISTS t_teachPlan;

DROP TABLE IF EXISTS t_teacher;

DROP TABLE IF EXISTS t_workstate;

/*==============================================================*/
/* Table: t_checkAttendance                                     */
/*==============================================================*/
CREATE TABLE t_checkAttendance
(
   cpID                 INT NOT NULL,
   tpCourseTime         DATETIME NOT NULL,
   stuID                INT NOT NULL,
   caAttendance         INT,
   PRIMARY KEY (cpID, tpCourseTime, stuID)
);

/*==============================================================*/
/* Table: t_classRoom                                           */
/*==============================================================*/
CREATE TABLE t_classRoom
(
   crID                 INT NOT NULL AUTO_INCREMENT,
   crName               VARCHAR(20),
   crType               INT,
   PRIMARY KEY (crID)
);

/*==============================================================*/
/* Table: t_compositeCheck                                      */
/*==============================================================*/
CREATE TABLE t_compositeCheck
(
   stuID                INT NOT NULL,
   courseID             INT NOT NULL,
   ccID                 INT,
   ccGrade              FLOAT,
   ccState              INT COMMENT '通没通过',
   PRIMARY KEY (stuID, courseID)
);

/*==============================================================*/
/* Table: t_course                                              */
/*==============================================================*/
CREATE TABLE t_course
(
   courseID             INT NOT NULL AUTO_INCREMENT,
   courseName           VARCHAR(50),
   courseDesc           VARCHAR(200),
   priority             INT,
   roomType             INT,
   PRIMARY KEY (courseID)
);

/*==============================================================*/
/* Table: t_courseAndTeacher                                    */
/*==============================================================*/
CREATE TABLE t_courseAndTeacher
(
   courseID             INT NOT NULL,
   teacID               INT NOT NULL,
   PRIMARY KEY (courseID, teacID)
);
INSERT  INTO `t_courseandteacher`(`courseID`,`teacID`) VALUES (1,1),(1,2),(1,3),(2,4),(2,5),(2,6),(3,7),(3,8),(3,9),(4,10),(4,11),(4,12),(5,1),(5,2),(5,13),(6,3),(6,4),(6,5),(7,6),(7,7),(7,8),(8,9),(8,10),(8,11),(9,1),(9,12),(9,13),(10,2),(10,3),(10,4),(11,5),(11,6),(11,7),(12,8),(12,9),(12,10),(13,11),(13,12),(13,13),(14,1),(14,2),(14,3),(15,4),(15,5),(15,6),(16,7),(16,8),(16,9),(17,10),(17,11),(17,12);
/*==============================================================*/
/* Table: t_coursePlanItem                                      */
/*==============================================================*/
CREATE TABLE t_coursePlanItem
(
   cpID                 INT NOT NULL AUTO_INCREMENT,
   teacID               INT NOT NULL,
   scID                 INT NOT NULL,
   courseID             INT NOT NULL,
   crID                 INT NOT NULL,
   cpparagraph          INT,
   cpstate              INT,
   PRIMARY KEY (cpID)
);

ALTER TABLE t_coursePlanItem COMMENT '课程表原子';

/*==============================================================*/
/* Table: t_courseWare                                          */
/*==============================================================*/
CREATE TABLE t_courseWare
(
   cwareID              INT NOT NULL AUTO_INCREMENT,
   cpID                 INT NOT NULL,
   tpCourseTime         DATETIME NOT NULL,
   cwareName            VARCHAR(50),
   cwareDesc            VARCHAR(255),
   PRIMARY KEY (cwareID)
);

/*==============================================================*/
/* Table: t_courseWork                                          */
/*==============================================================*/
CREATE TABLE t_courseWork
(
   cworkID              INT NOT NULL AUTO_INCREMENT,
   cpID                 INT NOT NULL,
   tpCourseTime         DATETIME NOT NULL,
   cworkTitle           VARCHAR(100),
   cworkDesc            VARCHAR(500),
   cworkType            INT,
   cworkState           VARCHAR(8),
   PRIMARY KEY (cworkID)
);

/*==============================================================*/
/* Table: t_file                                                */
/*==============================================================*/
CREATE TABLE t_file
(
   fileID               INT NOT NULL AUTO_INCREMENT,
   cwareID              INT,
   filePaths            TEXT,
   originalFileName     VARCHAR(100),
   generatedFileName    VARCHAR(100),
   uploadDateTime       DATETIME,
   downloadCount        INT,
   PRIMARY KEY (fileID)
);

/*==============================================================*/
/* Table: t_major                                               */
/*==============================================================*/
CREATE TABLE t_major
(
   majorID              INT NOT NULL AUTO_INCREMENT,
   majorName            VARCHAR(20),
   PRIMARY KEY (majorID)
);

/*==============================================================*/
/* Table: t_majorsCourse                                        */
/*==============================================================*/
CREATE TABLE t_majorsCourse
(
   majorID              INT NOT NULL,
   courseID             INT NOT NULL,
   paragraph            INT,
   PRIMARY KEY (majorID, courseID)
);

/*==============================================================*/
/* Table: t_project                                             */
/*==============================================================*/
CREATE TABLE t_project
(
   projID               INT NOT NULL AUTO_INCREMENT,
   projTitle            VARCHAR(255),
   projDesc             VARCHAR(1024),
   PRIMARY KEY (projID)
);

/*==============================================================*/
/* Table: t_projectDiv                                          */
/*==============================================================*/
CREATE TABLE t_projectDiv
(
   stuID                INT NOT NULL,
   projID               INT NOT NULL,
   pdID                 INT,
   pdWorkDesc           VARCHAR(255),
   pdGrade              FLOAT,
   PRIMARY KEY (stuID, projID)
);

/*==============================================================*/
/* Table: t_projectGroup                                        */
/*==============================================================*/
CREATE TABLE t_projectGroup
(
   pgID                 INT NOT NULL AUTO_INCREMENT,
   pgName               VARCHAR(20),
   pgSlogan             VARCHAR(255),
   PRIMARY KEY (pgID)
);

/*==============================================================*/
/* Table: t_projectReply                                        */
/*==============================================================*/
CREATE TABLE t_projectReply
(
   pgID                 INT NOT NULL,
   projID               INT NOT NULL,
   prID                 INT NOT NULL,
   prGrade              FLOAT,
   prState              INT,
   prDate               DATETIME,
   PRIMARY KEY (pgID, projID)
);

/*==============================================================*/
/* Table: t_schoolclass                                         */
/*==============================================================*/
CREATE TABLE t_schoolclass
(
   scID                 INT NOT NULL AUTO_INCREMENT,
   majorID              INT,
   scName               VARCHAR(20),
   PRIMARY KEY (scID)
);

/*==============================================================*/
/* Table: t_student                                             */
/*==============================================================*/
CREATE TABLE t_student
(
   stuID                INT NOT NULL AUTO_INCREMENT,
   pgID                 INT,
   scID                 INT,
   stuName              VARCHAR(20),
   PRIMARY KEY (stuID)
);

/*==============================================================*/
/* Table: t_teachPlan                                           */
/*==============================================================*/
CREATE TABLE t_teachPlan
(
   cpID                 INT NOT NULL,
   tpCourseTime         DATETIME NOT NULL,
   tpTeachMethod        VARCHAR(255),
   tpTeachContent       TEXT,
   tpTeachGoal          VARCHAR(1024),
   PRIMARY KEY (cpID, tpCourseTime)
);

/*==============================================================*/
/* Table: t_teacher                                             */
/*==============================================================*/
CREATE TABLE t_teacher
(
   teacID               INT NOT NULL AUTO_INCREMENT,
   teacName             VARCHAR(20),
   PRIMARY KEY (teacID)
);

/*==============================================================*/
/* Table: t_workstate                                           */
/*==============================================================*/
CREATE TABLE t_workstate
(
   cworkID              INT NOT NULL,
   stuID                INT NOT NULL,
   fileID               INT NOT NULL,
   wsID                 INT NOT NULL,
   wsGrade              FLOAT,
   wsTeacherComment     VARCHAR(1024),
   PRIMARY KEY (cworkID, stuID, fileID)
);

ALTER TABLE t_checkAttendance ADD CONSTRAINT FK_attendanceIncludeStudent FOREIGN KEY (stuID)
      REFERENCES t_student (stuID) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE t_checkAttendance ADD CONSTRAINT FK_teachPlanIncludeCheckAttendance FOREIGN KEY (cpID, tpCourseTime)
      REFERENCES t_teachPlan (cpID, tpCourseTime) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE t_compositeCheck ADD CONSTRAINT FK_compositeCheckBelongtoStudent FOREIGN KEY (stuID)
      REFERENCES t_student (stuID) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE t_compositeCheck ADD CONSTRAINT FK_compositeCheckRelateCourseInfo FOREIGN KEY (courseID)
      REFERENCES t_course (courseID) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE t_courseAndTeacher ADD CONSTRAINT FK_t_courseAndTeacher FOREIGN KEY (courseID)
      REFERENCES t_course (courseID) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE t_courseAndTeacher ADD CONSTRAINT FK_t_courseAndTeacher2 FOREIGN KEY (teacID)
      REFERENCES t_teacher (teacID) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE t_coursePlanItem ADD CONSTRAINT FK_CourseItemRelateCourseInfo FOREIGN KEY (courseID)
      REFERENCES t_course (courseID) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE t_coursePlanItem ADD CONSTRAINT FK_courseBelongToClass FOREIGN KEY (scID)
      REFERENCES t_schoolclass (scID) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE t_coursePlanItem ADD CONSTRAINT FK_coursePlanItemRelateTeacher FOREIGN KEY (teacID)
      REFERENCES t_teacher (teacID) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE t_coursePlanItem ADD CONSTRAINT FK_courseRelateClassroom FOREIGN KEY (crID)
      REFERENCES t_classRoom (crID) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE t_courseWare ADD CONSTRAINT FK_courseWareBelongtoTeachPlan FOREIGN KEY (cpID, tpCourseTime)
      REFERENCES t_teachPlan (cpID, tpCourseTime) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE t_courseWork ADD CONSTRAINT FK_teachPlanIncludeCourseWork FOREIGN KEY (cpID, tpCourseTime)
      REFERENCES t_teachPlan (cpID, tpCourseTime) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE t_file ADD CONSTRAINT FK_courseWareIncludeFile FOREIGN KEY (cwareID)
      REFERENCES t_courseWare (cwareID) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE t_majorsCourse ADD CONSTRAINT FK_t_majorsCourse FOREIGN KEY (majorID)
      REFERENCES t_major (majorID) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE t_majorsCourse ADD CONSTRAINT FK_t_majorsCourse2 FOREIGN KEY (courseID)
      REFERENCES t_course (courseID) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE t_projectDiv ADD CONSTRAINT FK_projectDivRelateProject FOREIGN KEY (projID)
      REFERENCES t_project (projID) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE t_projectDiv ADD CONSTRAINT FK_studentRelateProjectDiv FOREIGN KEY (stuID)
      REFERENCES t_student (stuID) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE t_projectReply ADD CONSTRAINT FK_t_projectReply FOREIGN KEY (pgID)
      REFERENCES t_projectGroup (pgID) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE t_projectReply ADD CONSTRAINT FK_t_projectReply2 FOREIGN KEY (projID)
      REFERENCES t_project (projID) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE t_schoolclass ADD CONSTRAINT FK_classBelongToMajor FOREIGN KEY (majorID)
      REFERENCES t_major (majorID) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE t_student ADD CONSTRAINT FK_projectGroupIncludeStudent FOREIGN KEY (pgID)
      REFERENCES t_projectGroup (pgID) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE t_student ADD CONSTRAINT FK_studentBelongsToClass FOREIGN KEY (scID)
      REFERENCES t_schoolclass (scID) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE t_teachPlan ADD CONSTRAINT FK_coursePlanItemRelateTeachPlan FOREIGN KEY (cpID)
      REFERENCES t_coursePlanItem (cpID) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE t_workstate ADD CONSTRAINT FK_t_workstate FOREIGN KEY (cworkID)
      REFERENCES t_courseWork (cworkID) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE t_workstate ADD CONSTRAINT FK_t_workstate2 FOREIGN KEY (stuID)
      REFERENCES t_student (stuID) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE t_workstate ADD CONSTRAINT FK_t_workstate3 FOREIGN KEY (fileID)
      REFERENCES t_file (fileID) ON DELETE RESTRICT ON UPDATE RESTRICT;

