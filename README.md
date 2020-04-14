# 项目说明
## 1、主要功能
    基于SSM整合查询单个和所有功能
## 2、主要知识点
### 整合的概述
#### 各自承担的功能
	Spring：发展对象的创建、维护、管理---IOC及对象依赖资源的注入---DI；
	SpringMVC：发展请求的处理，相当于Servlet；
	MyBatis：负责与数据库进行交互---DRM。
#### 整合的步骤
##### （1）在pom.xml文件中导入依赖
	mybatis、mybatis-spring、spring-webmvc、spring-jdbc、mysql、log4j、jstl(页面进行展示)、bonecp数据源
##### （2）编写配置文件
	mybatis-config.xml、spring-config.xml、springmvc-config.xml、log4j.properties
###### mybatis-config.xml
	日志记录工具、批量取别名、批量加载映射文件
###### spring-config.xml
	数据源、SQLSessionFactory、映射器、扫描支持注解的Bean、事务管理器、基于注解事务
###### springmvc-config.xml
	组件扫描(controller)、注解驱动、视图解析器、文件上传等
##### （3）定义项目结构和代码
	com.ssm.entity、dao、service、service.impl、controller
##### （4）配置web.xml
	加载spring-config.xml、springmvc-config.xml、中文乱码
##### （5）测试功能
## 3、说明
### Log4j版本低出现的一个漏洞：CVE-2019-17571
	**脆弱版本：** > = 1.2，<= 1.2.27
	**修补版本：** *无修复*
	Log4j 1.2中包含一个SocketServer类，该类很容易对不可信数据进行反序列化，当侦听日志数据的不可信网络流量时，与反序列化小工具结合使用时，可以利用该类远程执行任意代码。这会影响Log4j版本1.2到1.2.17。
### 解决Log4j问题，采用高版本Log4j/2。
```
<!-- Log4J/2依赖 -->
<!-- https://logging.apache.org/log4j/2.x/maven-artifacts.html -->
<dependency>
	<groupId>org.apache.logging.log4j</groupId>
	<artifactId>log4j-api</artifactId>
	<version>2.13.1</version>
</dependency>
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>2.13.1</version>
</dependency>
```
## 4、报错
	出现“严重: Servlet.service() for servlet [ssm] in context with path [/SSM] threw exception [Request processing failed; nested exception is java.lang.NullPointerException] with root cause java.lang.NullPointerException”
	解决办法：a.导包不对或者未导入相应的包；b.单词写错。
	运行Tomcat出现“Server Tomcat v7.0 Server at localhost was unable to start within 45 seconds. If the server requires more time, try increasing the timeout in the server editor.”
	解决方法：找到Tomcat中serve.xml中的timeouts，将其调大。
## 5、附加
### JDK8API
    https://docs.oracle.com/javase/8/docs/api/