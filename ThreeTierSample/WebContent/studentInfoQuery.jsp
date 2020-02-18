<%@page import="org.student.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("tr:odd").css("background-color", "lightgray");

	});
</script>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>符合要求的学生信息</title>
</head>
<body>
	<form action="UpdateStudentServlet" method="post">
		<table border="1">
			<tr>
				<th>学号</th>
				<th>姓名</th>
				<th>年龄</th>
				<th>地址</th>
				<th>操作</th>
			</tr>

			<%
				//获取request中数据
				@SuppressWarnings("unchecked")
				List<Student> students = (List<Student>) request.getAttribute("students");
				for (Student student : students) {
			%>
			<tr>
				<td><a
					href="QueryStudentBySnoServlet?sno=<%=student.getSno()%>"><%=student.getSno()%></a></td>
				<td><%=student.getSname()%></td>
				<td><%=student.getSage()%></td>
				<td><%=student.getSaddress()%></td>
				<td><a href=" DeleteStudentServlet?sno=<%=student.getSno()%>">删除</a></td>
			</tr>
			<%
				}
			%>

		</table>
		<a href="QueryAllStudentsServlet">返回</a>
	</form>
</body>
</html>