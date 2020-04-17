<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改页面</title>
</head>
<body>
	<form action="doUpdate.do" method="post">
		<input type="hidden" name="sno" value="${stu.sno }"><br />
		姓名：<input type="text" name="sname" value="${stu.sname }"><br />
		性别：<input type="text" name="sex" value="${stu.sex }"><br />
		电话：<input type="text" name="phone" value="${stu.phone }"><br />
		<input type="submit" value="修改"><br />
	</form>
</body>
</html>