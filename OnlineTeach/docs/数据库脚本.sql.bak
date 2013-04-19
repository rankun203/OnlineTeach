/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2013/4/18 21:24:53                           */
/*==============================================================*/


drop table if exists t_checkAttendance;

drop table if exists t_classRoom;

drop table if exists t_compositeCheck;

drop table if exists t_course;

drop table if exists t_coursePlanItem;

drop table if exists t_courseWare;

drop table if exists t_courseWork;

drop table if exists t_file;

drop table if exists t_major;

drop table if exists t_project;

drop table if exists t_projectDiv;

drop table if exists t_projectGroup;

drop table if exists t_projectReply;

drop table if exists t_schoolclass;

drop table if exists t_student;

drop table if exists t_teachPlan;

drop table if exists t_teacher;

drop table if exists t_workstate;

/*==============================================================*/
/* Table: t_checkAttendance                                     */
/*==============================================================*/
create table t_checkAttendance
(
   cpID                 int not null,
   tpCourseTime         datetime not null,
   stuID                int not null,
   caAttendance         int,
   primary key (cpID, tpCourseTime, stuID)
);

/*==============================================================*/
/* Table: t_classRoom                                           */
/*==============================================================*/
create table t_classRoom
(
   crID                 int not null,
   cpID                 int,
   crName               varchar(20),
   crType               int,
   primary key (crID)
);

/*==============================================================*/
/* Table: t_compositeCheck                                      */
/*==============================================================*/
create table t_compositeCheck
(
   stuID                int not null,
   courseID             int not null,
   ccGrade              float,
   ccState              int comment '通没通过',
   primary key (stuID, courseID)
);

/*==============================================================*/
/* Table: t_course                                              */
/*==============================================================*/
create table t_course
(
   courseID             int not null,
   cpID                 int,
   courseName           varchar(50),
   courseDesc           varchar(200),
   primary key (courseID)
);

/*==============================================================*/
/* Table: t_coursePlanItem                                      */
/*==============================================================*/
create table t_coursePlanItem
(
   cpID                 int not null,
   teacID               int not null,
   scID                 int not null,
   courseID             int not null,
   crID                 int not null,
   cpparagraph          int,
   cpstate              int,
   primary key (cpID)
);

alter table t_coursePlanItem comment '课程表原子';

/*==============================================================*/
/* Table: t_courseWare                                          */
/*==============================================================*/
create table t_courseWare
(
   cwareID              int not null,
   cpID                 int not null,
   tpCourseTime         datetime not null,
   cwareName            varchar(50),
   cwareDesc            varchar(255),
   primary key (cwareID)
);

/*==============================================================*/
/* Table: t_courseWork                                          */
/*==============================================================*/
create table t_courseWork
(
   cpID                 int not null,
   tpCourseTime         datetime not null,
   cwTitle              varchar(100),
   cwDesc               varchar(500),
   cwType               int,
   cwState              varchar(8),
   primary key (cpID, tpCourseTime)
);

/*==============================================================*/
/* Table: t_file                                                */
/*==============================================================*/
create table t_file
(
   fileID               int not null,
   cwareID              int,
   filePaths            text,
   originalFileName     varchar(100),
   generatedFileName    varchar(100),
   uploadDateTime       datetime,
   downloadCount        int,
   primary key (fileID)
);

/*==============================================================*/
/* Table: t_major                                               */
/*==============================================================*/
create table t_major
(
   majorID              int not null,
   majorName            varchar(20),
   primary key (majorID)
);

/*==============================================================*/
/* Table: t_project                                             */
/*==============================================================*/
create table t_project
(
   projID               int not null,
   projTitle            varchar(255),
   projDesc             varchar(1024),
   primary key (projID)
);

/*==============================================================*/
/* Table: t_projectDiv                                          */
/*==============================================================*/
create table t_projectDiv
(
   stuID                int not null,
   projID               int not null,
   pdWorkDesc           varchar(255),
   pdGrade              float,
   primary key (stuID, projID)
);

/*==============================================================*/
/* Table: t_projectGroup                                        */
/*==============================================================*/
create table t_projectGroup
(
   pgID                 int not null,
   pgName               varchar(20),
   pgSlogan             varchar(255),
   primary key (pgID)
);

/*==============================================================*/
/* Table: t_projectReply                                        */
/*==============================================================*/
create table t_projectReply
(
   pgID                 int not null,
   projID               int not null,
   prGrade              float,
   prState              int,
   prDate               datetime,
   primary key (pgID, projID)
);

/*==============================================================*/
/* Table: t_schoolclass                                         */
/*==============================================================*/
create table t_schoolclass
(
   scID                 int not null,
   majorID              int,
   scName               varchar(20),
   primary key (scID)
);

/*==============================================================*/
/* Table: t_student                                             */
/*==============================================================*/
create table t_student
(
   stuID                int not null,
   pgID                 int,
   scID                 int,
   stuName              varchar(20),
   primary key (stuID)
);

/*==============================================================*/
/* Table: t_teachPlan                                           */
/*==============================================================*/
create table t_teachPlan
(
   cpID                 int not null,
   tpCourseTime         datetime not null,
   tpTeachMethod        varchar(255),
   tpTeachContent       text,
   tpTeachGoal          varchar(1024),
   primary key (cpID, tpCourseTime)
);

/*==============================================================*/
/* Table: t_teacher                                             */
/*==============================================================*/
create table t_teacher
(
   teacID               int not null,
   teacName             varchar(20),
   primary key (teacID)
);

/*==============================================================*/
/* Table: t_workstate                                           */
/*==============================================================*/
create table t_workstate
(
   cpID                 int not null,
   tpCourseTime         datetime not null,
   stuID                int not null,
   fileID               int not null,
   wsID                 int not null,
   wsGrade              float,
   wsTeacherComment     varchar(1024),
   primary key (cpID, tpCourseTime, stuID, fileID)
);

alter table t_checkAttendance add constraint FK_attendanceIncludeStudent foreign key (stuID)
      references t_student (stuID) on delete restrict on update restrict;

alter table t_checkAttendance add constraint FK_teachPlanIncludeCheckAttendance foreign key (cpID, tpCourseTime)
      references t_teachPlan (cpID, tpCourseTime) on delete restrict on update restrict;

alter table t_classRoom add constraint FK_courseRelateClassroom2 foreign key (cpID)
      references t_coursePlanItem (cpID) on delete restrict on update restrict;

alter table t_compositeCheck add constraint FK_compositeCheckBelongtoStudent foreign key (stuID)
      references t_student (stuID) on delete restrict on update restrict;

alter table t_compositeCheck add constraint FK_compositeCheckRelateCourseInfo foreign key (courseID)
      references t_course (courseID) on delete restrict on update restrict;

alter table t_course add constraint FK_CourseItemRelateCourseInfo2 foreign key (cpID)
      references t_coursePlanItem (cpID) on delete restrict on update restrict;

alter table t_coursePlanItem add constraint FK_CourseItemRelateCourseInfo foreign key (courseID)
      references t_course (courseID) on delete restrict on update restrict;

alter table t_coursePlanItem add constraint FK_courseBelongToClass foreign key (scID)
      references t_schoolclass (scID) on delete restrict on update restrict;

alter table t_coursePlanItem add constraint FK_coursePlanItemRelateTeacher foreign key (teacID)
      references t_teacher (teacID) on delete restrict on update restrict;

alter table t_coursePlanItem add constraint FK_courseRelateClassroom foreign key (crID)
      references t_classRoom (crID) on delete restrict on update restrict;

alter table t_courseWare add constraint FK_courseWareBelongtoTeachPlan foreign key (cpID, tpCourseTime)
      references t_teachPlan (cpID, tpCourseTime) on delete restrict on update restrict;

alter table t_courseWork add constraint FK_teachPlanIncludeCourseWork foreign key (cpID, tpCourseTime)
      references t_teachPlan (cpID, tpCourseTime) on delete restrict on update restrict;

alter table t_file add constraint FK_courseWareIncludeFile foreign key (cwareID)
      references t_courseWare (cwareID) on delete restrict on update restrict;

alter table t_projectDiv add constraint FK_projectDivRelateProject foreign key (projID)
      references t_project (projID) on delete restrict on update restrict;

alter table t_projectDiv add constraint FK_studentRelateProjectDiv foreign key (stuID)
      references t_student (stuID) on delete restrict on update restrict;

alter table t_projectReply add constraint FK_t_projectReply foreign key (pgID)
      references t_projectGroup (pgID) on delete restrict on update restrict;

alter table t_projectReply add constraint FK_t_projectReply2 foreign key (projID)
      references t_project (projID) on delete restrict on update restrict;

alter table t_schoolclass add constraint FK_classBelongToMajor foreign key (majorID)
      references t_major (majorID) on delete restrict on update restrict;

alter table t_student add constraint FK_projectGroupIncludeStudent foreign key (pgID)
      references t_projectGroup (pgID) on delete restrict on update restrict;

alter table t_student add constraint FK_studentBelongsToClass foreign key (scID)
      references t_schoolclass (scID) on delete restrict on update restrict;

alter table t_teachPlan add constraint FK_coursePlanItemRelateTeachPlan foreign key (cpID)
      references t_coursePlanItem (cpID) on delete restrict on update restrict;

alter table t_workstate add constraint FK_t_workstate foreign key (cpID, tpCourseTime)
      references t_courseWork (cpID, tpCourseTime) on delete restrict on update restrict;

alter table t_workstate add constraint FK_t_workstate2 foreign key (stuID)
      references t_student (stuID) on delete restrict on update restrict;

alter table t_workstate add constraint FK_t_workstate3 foreign key (fileID)
      references t_file (fileID) on delete restrict on update restrict;

