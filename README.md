# 项目说明

## 1、主要功能
    使用分页插件---PageHelper进行分页。
## 2、主要知识点
mysql分页关键字是limit。
mybatis的一个分页插件---PageHelper
分页原理和mysql分页类似，只是它把底层的一些东西进行了封装，使用起来很简单。
### 分页概述
	是一个开源的Mybatis分页插件，GitHub地址：https://github.com/pagehelper/Mybatis-PageHelper
	核心原理：通过ThreadLocal来存放分页信息。
	原理总结：PageHelper首先将前台传递的参数保存到page对象中，然后将page的副本存放入ThreadLocal，这样保证分页的时候，参数互不影响，最后利用了mybatis提供的拦截器，得到ThreadLocal的值，重新拼装分页SQL，完成分页。
### MyBatis分页插件的步骤
#### （1）在pom.xml文件中导入依赖
	mybatis、mybatis-spring、spring-webmvc、spring-jdbc、mysql、log4j、jstl(页面进行展示)、bonecp数据源、PageHelper
#### （2）编写配置文件
	mybatis-config.xml、spring-config.xml、springmvc-config.xml、log4j.properties
##### mybatis-config.xml
	日志记录工具、批量取别名、批量加载映射文件、配置分页插件
##### spring-config.xml
	数据源、SQLSessionFactory、映射器、扫描支持注解的Bean、事务管理器、基于注解事务
##### springmvc-config.xml
	组件扫描(controller)、注解驱动、视图解析器、文件上传等
#### （3）定义项目结构和代码
	com.ssm.entity、dao、service、service.impl、controller
#### （4）配置web.xml
	加载spring-config.xml、springmvc-config.xml、中文乱码
#### （5）测试功能
## 3、说明
### jsp页面中出现，下面警告：
	Multiple annotations found at this line:
	- Attribute (cellspacing) is obsolete. Its use is discouraged in HTML5 
	 documents.
	- Attribute (cellpadding) is obsolete. Its use is discouraged in HTML5 
	 documents.
	- Attribute (align) is obsolete. Its use is discouraged in HTML5 documents.
### 解决办法：这种警告主要是因为这些属性在HTML5中过时了，并不影响代码运行
将程序的顶部的这句：
```javascript
<!DOCTYPE>
```
修改为：
```javascript
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
```
### 出现：The superclass "javax.servlet.http.HttpServlet" was not found on the Java Build Path

###解决方式：Buildpath---service。

## 4、报错

### pom.xml中加入PageHelper分页插件出现：
	Multiple annotations found at this line:
	- The string "--" is not permitted within comments.
	- Project build error: Non-parseable POM E:\Workspace\Spring Tool Suite\SSM\pom.xml: in 
	 comment after two dashes (--) next character must be > not - (position: END_TAG seen ...</
	 dependency>\r\n\r\n\t\t<!-- mybatis\u5206\u9875\u63d2\u4ef6---... @55:22)
### 解决办法：
    （1）删除本地储存库中的PageHelper目录，重新启动编译器再次更新Maven项目。
    （2）可以从中央储存库下载此文件（不推荐）：https://repo1.maven.org/maven2/com/github/pagehelper/pagehelper/5.1.11/
### 运行list.do出错： <h3>):[c]和[/WEB-INF/jsp/index.jsp]的TagLibraryValidator的验证错误消息</h3><p>109: Illegal text inside "c:choose" tag: "  ...".</p>
### 解决办法：有多余的符号(例空格)。
## 5、附加
### JDK8API
    https://docs.oracle.com/javase/8/docs/api/
### Mybatis分页插件PageHelper可以在这儿寻找依赖
	https://search.maven.org/
```
<!-- mybatis分页插件---PageHelper -->
<dependency>
	<groupId>com.github.pagehelper</groupId>
	<artifactId>pagehelper</artifactId>
	<version>5.1.11</version>
</dependency>
```
### 依赖
	https://mvnrepository.com/
```
<!-- mybatis分页插件---PageHelper -->
<!-- https://mvnrepository.com/artifact/com.github.pagehelper/pagehelper -->
<dependency>
	<groupId>com.github.pagehelper</groupId>
	<artifactId>pagehelper</artifactId>
	<version>5.1.11</version>
</dependency>
```
### 中央储存库：https://repo1.maven.org/maven2/
	PageHelper中央储存库：https://repo1.maven.org/maven2/com/github/pagehelper