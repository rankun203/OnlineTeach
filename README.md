OnlineTeach[![Build Status](https://travis-ci.org/rankun203/OnlineTeach.png)](https://travis-ci.org/rankun203/OnlineTeach)
===========
####软件技术专业教学综合管理平台 在线教学模块

##Installation  
#####Linux
开始之前  
0.创建相关目录（稍后将在该目录中执行所有操作，如果已经进入到相关目录，可以忽略本步）

    cd ~
    mkdir git
    cd git
0.确认已经安装mysql,并且有用户名为gitproject, 密码为gitproject的用户。  
  如果没有请参照[Installing MySQL on Linux][]  
  如果您使用Ubuntu相关的系统，运行以下命令：

    sudo apt-get install mysql-server mysql-client
    #弹出的蓝底灰色界面中输入你自己想出来的root用户的密码，请牢记该密码
    mysql -u root -p
    #输入刚刚设置的root用户的密码
    mysql> create user gitproject@localhost identified by 'gitproject';
    mysql> create database onlineteach;
    mysql> grant all on onlineteach.* to gitproject;
    mysql> flush privileges;
1.使用git克隆版本库(如果没有安装git,请访问 [setup git][] )

    git clone git@github.com:rankun203/OnlineTeach.git
2.

####Dependences
#####Environment：`Tomcat 6.0+ `
#####Compiler：`JDK 6+ `

    Struts2.3.8<br>
    Hibernate4.1.8<br>
    Spring3.2.3<br>
    MySQL connector:5.1.6

####Dependences Detail:
    antlr-2.7.7.jar
    aopalliance.jar
    asm-3.3.jar
    asm-commons-3.3.jar
    asm-tree-3.3.jar
    commons-dbcp.jar
    commons-fileupload-1.2.2.jar
    commons-io-2.0.1.jar
    commons-lang3-3.1.jar
    commons-logging-1.1.1.jar
    commons-pool.jar
    dom4j-1.6.1.jar
    freemarker-2.3.19.jar
    hibernate-commons-annotations-4.0.1.Final.jar
    hibernate-core-4.1.8.Final.jar
    hibernate-jpa-2.0-api-1.0.1.Final.jar
    javassist-3.11.0.GA.jar
    javassist-3.15.0-GA.jar
    jboss-logging-3.1.0.GA.jar
    jboss-transaction-api_1.1_spec-1.0.0.Final.jar
    json-jre1.6.jar
    mysql-connector-java-5.1.6-bin.jar
    ognl-3.0.6.jar
    spring-aop-3.2.3.RELEASE.jar
    spring-aspects-3.2.3.RELEASE.jar
    spring-beans-3.2.3.RELEASE.jar
    spring-build-src-3.2.3.RELEASE.jar
    spring-context-3.2.3.RELEASE.jar
    spring-context-support-3.2.3.RELEASE.jar
    spring-core-3.2.3.RELEASE.jar
    spring-expression-3.2.3.RELEASE.jar
    spring-instrument-3.2.3.RELEASE.jar
    spring-instrument-tomcat-3.2.3.RELEASE.jar
    spring-jdbc-3.2.3.RELEASE.jar
    spring-jms-3.2.3.RELEASE.jar
    spring-orm-3.2.3.RELEASE.jar
    spring-oxm-3.2.3.RELEASE.jar
    spring-struts-3.2.3.RELEASE.jar
    spring-test-3.2.3.RELEASE.jar
    spring-tx-3.2.3.RELEASE.jar
    spring-web-3.2.3.RELEASE.jar
    spring-webmvc-3.2.3.RELEASE.jar
    spring-webmvc-portlet-3.2.3.RELEASE.jar
    struts2-core-2.3.8.jar
    struts2-spring-plugin-2.3.8.jar
    xwork-core-2.3.8.jar

[setup git]: https://help.github.com/articles/set-up-git
[Installing MySQL on Linux]: http://dev.mysql.com/doc/refman/5.7/en/linux-installation.html
