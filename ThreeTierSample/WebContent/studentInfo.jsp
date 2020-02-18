<%@page import="org.student.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>学生信息详情以及更改</title>
</head>
<body>
	<%
		
	//获取request中数据
		Student student = (Student) request.getAttribute("student");
	%>
	<form action="UpdateStudentServlet" method="post">
		学号：<input type="text" name="sno" value="<%=student.getSno()%>" readonly="readonly" /><br /> 
		姓名：<input type="text" name="sname" value="<%=student.getSname()%>" /><br /> 
		年龄：<input type="text" name="sage" value="<%=student.getSage()%>" /><br /> 
		地址：<input type="text" name="saddress" value="<%=student.getSaddress()%>" /><br />
		<input type="submit" value="修改" />
		<a href="add.jsp">新增</a>
		<a href="QueryAllStudentsServlet">返回</a>
		<br />

	</form>
</body>
</html>