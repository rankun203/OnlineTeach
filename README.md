OnlineTeach[![Build Status](https://travis-ci.org/rankun203/OnlineTeach.png)](https://travis-ci.org/rankun203/OnlineTeach)
===========
####软件技术专业教学综合管理平台 在线教学模块

##Installation  
####Linux
#####0.创建相关目录（稍后将在该目录中执行所有操作，如果已经进入到相关目录，请跳到下一步）

    cd ~
    mkdir git
    cd git
#####0.确认已经安装mysql,并且有用户名为gitproject, 密码为gitproject的用户。如果已经满足条件，请跳到第`1`步；如果没有请参照[Installing MySQL on Linux][]；如果您使用Ubuntu相关的系统，运行以下命令：

    sudo apt-get install mysql-server mysql-client
    #弹出的蓝底灰色界面中输入你自己想出来的root用户的密码，请牢记该密码
    mysql -u root -p
    #输入刚刚设置的root用户的密码，下面的命令都运行在mysql>中
    create user gitproject@localhost identified by 'gitproject';
    create database onlineteach;
    grant all on onlineteach.* to gitproject;
    flush privileges;
    exit;
#####1.使用git克隆版本库(如果没有安装git,请访问 [setup git][]，如果是Ubuntu类系统，直接运行`sudo apt-get install git`)

    git clone git@github.com:rankun203/OnlineTeach.git
#####2.使用maven来编译程序（如果没有安装maven，请访问[setup maven][]，如果是Ubuntu类系统，直接运行`sudo apt-get install maven`），这里使用了mvn install周期，因为创建数据库的代码将在install周期之间运行。

    mvn install
    mysql -u gitproject -pgitproject < ./docs/dbbackup.sql
#####3.使用maven运行项目

    mvn tomcat6:run
#####4.使用浏览器打开[http://localhost:8080/OnlineTeach/][]

    ！如果出现没有找到数据库或表的异常，请尝试重新运行 mvn install
####Windows
#####0.创建相关目录（稍后将在该目录中执行所有操作，如果已经进入到相关目录，请跳到下一步）

    #打开资源管理器，在自己的某个工作目录下创建一个名叫git的目录
    #复制该目录（包含/git）名称
    #按键盘上的`Win+R`，输入`CMD`，打开一个控制台窗口
    cd 刚刚复制的目录名
#####0.确认已经安装mysql,并且有用户名为gitproject, 密码为gitproject的用户。如果已经满足条件，请跳到第`1`步；如果没有请参照[Installing MySQL on Linux][]；如果您使用Ubuntu相关的系统，运行以下命令：

    #使用浏览器打开：http://dev.mysql.com/downloads/mysql/#downloads
    #点击大大的Windows Installer for Windows, 下载MySQL的Windows客户端
    #依据你的系统，点击`Windows (x86, 32-bit), MSI Installer`或是`Windows (x86, 32-bit), MSI Installer`后的Download按钮
    #点击底部的`No thanks, just start my download.`
    #安装时注意设置root账户的密码，并且牢记该密码！
    mysql -u root -p
    #输入刚刚设置的root用户的密码，下面的命令都运行在mysql>中
    create user gitproject@localhost identified by 'gitproject';
    create database onlineteach;
    grant all on onlineteach.* to gitproject;
    flush privileges;
    exit;
#####1.使用git克隆版本库(如果没有安装git,请访问 [setup git for windows][])

    git clone git@github.com:rankun203/OnlineTeach.git
#####2.使用maven来编译程序（如果没有安装maven，请访问[setup maven for windows][]），这里使用了mvn install周期，因为创建数据库的代码将在install周期之间运行。

    mvn install
    mysql -u gitproject -pgitproject < ./docs/dbbackup.sql
#####3.使用maven运行项目

    mvn tomcat6:run
#####4.使用浏览器打开[http://localhost:8080/OnlineTeach/][]

    ！如果出现没有找到数据库或表的异常，请尝试重新运行 mvn install


####Dependences
#####Environment：`Tomcat 6.0+ `
#####Compiler：`JDK 6+ `

    Struts2.3.8<br>
    Hibernate4.1.8<br>
    Spring3.2.3<br>
    MySQL connector:5.1.6

[setup git]: https://help.github.com/articles/set-up-git
[Installing MySQL on Linux]: http://dev.mysql.com/doc/refman/5.7/en/linux-installation.html
[setup maven]: http://www.mkyong.com/maven/how-to-install-maven-in-ubuntu/
[http://localhost:8080/OnlineTeach/]: http://localhost:8080/OnlineTeach/
[setup git for windows]: http://www.xbc.me/install-git-on-windows/
[setup maven for windows]: http://hzbook.group.iteye.com/group/wiki/2872-Maven-in-action#3338
