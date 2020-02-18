<%@page import="java.util.List"%>
<%@page import="org.student.entity.Student"%>
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
<title>学生信息列表</title>
</head>
<body>
	<%
		//error adderror 失败
		//否则: 1确实执行了增加  2直接访问查询全部页面
		String error = (String) request.getAttribute("error");
		if (error != null) {
			if (error == "addError") {
				out.print("增加失败！");
			}
			if (error == "noAddError") {
				out.print("增加成功！");
			}

			if (error == "deleteError") {
				out.print("删除失败！");
			}
			if (error == "noDeleteError") {
				out.print("删除成功！");
			}

			if (error == "updateError") {
				out.print("更新失败！");
			}
			if (error == "noUpdateError") {
				out.print("更新成功！");
			}
		} else {

		}
	%>
	<form method="post">
		<table border="1">
			<tr>
				<th>学号</th>
				<th>姓名</th>
				<th>年龄</th>
				<!-- 				<th>地址</th> -->
				<th>操作</th>
			</tr>

			<%
				//获取request中数据
				/**
				*因为使用了jdk1.5或者1.6的泛型， 
				*request.getAttribute("list");
				*	得到的是一个没有类型的List，
				*	当把他们转成List<Student>时，
				*	编译器认为有可能会出错，所以提示这个类型安全
				*	如果确认没有问题，可以不予理会
				*	如果不想报错，可以在那行上加上一句话
				*		@SuppressWarnings("unchecked")
				*/

				@SuppressWarnings("unchecked")
				List<Student> students = (List<Student>) request.getAttribute("students");
				for (Student student : students) {
			%>
			<tr>
				<td><a
					href="QueryStudentBySnoServlet?sno=<%=student.getSno()%>"><%=student.getSno()%></a></td>
				<td><a
					href="QueryStudentsBySnameServlet?sname=<%=student.getSname()%>"><%=student.getSname()%></a></td>
				<td><a
					href="QueryStudentsBySageServlet?sage=<%=student.getSage()%>"><%=student.getSage()%></a></td>
				<%-- 				<td><%=student.getSaddress()%></td> --%>
				<td><a href=" DeleteStudentServlet?sno=<%=student.getSno()%>">删除</a></td>
			</tr>
			<%
				}
			%>

		</table>
		<a href="add.jsp">新增</a> <a href="QueryAllStudentsServlet">返回</a>
	</form>
</body>
</html>