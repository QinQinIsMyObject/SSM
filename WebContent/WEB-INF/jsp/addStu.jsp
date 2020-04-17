<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加学生</title>
</head>
<body>
	<form action="doAddStu.do" method="post">
		姓名：<input type="text" name="sname" value=""><br />
		性别：<input type="text" name="sex" value=""><br />
		年龄：<input type="text" name="age" value=""><br />
		年级：<input type="text" name="gid" value=""><br />
		电话：<input type="text" name="phone" value=""><br />
		地址：<input type="text" name="address" value=""><br />
		<input type="submit" value="增加"><br />
	</form>
</body>
</html>