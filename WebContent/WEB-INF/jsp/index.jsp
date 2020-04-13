<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	<div>
		<table align="center" border="1" cellpaddint="0" cellspacing="0"
			width="50%">
			<tr>
				<th>学号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${stulist }" var="stu">
				<tr>
					<th>${stu.sno }</th>
					<th>${stu.sname }</th>
					<th>${stu.sex }/th>
					<th>${stu.age }</th>
					<th>操作</th>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>