<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<script type="text/javascript" src="js/jquery-3.5.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		$(".base:even").css("background-color", "green");//隔行变色
	});
</script>
</head>
<body>
	<div align="center">
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
				<tr class="base">
					<th>${stu.sno }</th>
					<th>${stu.sname }</th>
					<th>${stu.sex }</th>
					<th>${stu.age }</th>
					<th><a href="deleteStu.do?sno=${stu.sno }">删除</a>|<a
						href="toUpdatePage.do?sno=${stu.sno }">修改</a>|<a
						href="selectDetails.do?sno=${stu.sno }">查看详情</a></th>
				</tr>
			</c:forEach>
		</table>
		<a href="toAdd.do">增加</a>
		<h3>
			<span style="color: red">${msg}</span>
		</h3>
	</div>
</body>
</html>