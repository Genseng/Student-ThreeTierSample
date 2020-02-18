<%@ page import="org.student.entity.Student"%>
<%@ page import="org.student.entity.Page"%>
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
<title>学生信息列表-分页显示</title>
</head>
<body>
	<%
		/*
		分页显示，前端jsp需要的数：
				当前页：currentPage
				页面大小：pageSize
				当前页的数据集合：Students
				查询出的总数据：getXxxCount
				总页数：totalPage
		——>新建Page类，用来封装五个字段
		*/

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
				<th>地址</th>
				<th>操作</th>
			</tr>

			<%
				//获取request中数据
				Page p = (Page) request.getAttribute("page");
				for (Student student : p.getStudents()) {
			%>
			<tr>
				<td><a
					href="QueryStudentBySnoServlet?sno=<%=student.getSno()%>"><%=student.getSno()%></a></td>
				<td><a
					href="QueryInPageStudentsBySnameServlet?sname=<%=student.getSname()%>"><%=student.getSname()%></a></td>
				<td><a
					href="QueryInPageStudentsBySageServlet?sage=<%=student.getSage()%>"><%=student.getSage()%></a></td>
				<td><%=student.getSaddress()%></td>
				<td><a href=" DeleteStudentServlet?sno=<%=student.getSno()%>">删除</a></td>
			</tr>
			<%
				}
			%>

		</table>
		<a href="add.jsp">新增</a> <a href="QueryInPageAllStudentsServlet">返回</a><br />
		<br />
		<%
			if (p.getCurrentPage() == 1) {//首页
				if (p.getTotalPage() > 1) {
		%>
		<a>首页</a> <a>上一页</a> <a
			href="QueryInPageStudentsBySnameServlet?currentPage=<%=p.getCurrentPage() + 1%>">下一页</a>
		<a
			href="QueryInPageStudentsBySnameServlet?currentPage=<%=p.getTotalPage()%>">尾页</a>
		<%
			} else {
		%>
		<a>首页</a> <a>上一页</a> <a>下一页</a> <a>尾页</a>

		<%
			}
		%>


		<%
			} else if (p.getCurrentPage() == p.getTotalPage()) {//尾页
		%>
		<a href="QueryInPageStudentsBySnameServlet?currentPage=1">首页</a> <a
			href="QueryInPageStudentsBySnameServlet?currentPage=<%=p.getCurrentPage() - 1%>">上一页</a>
		<a>下一页</a> <a>尾页</a>
		<%
			} else {//中间页
		%>
		<a href="QueryInPageStudentsBySnameServlet?currentPage=<%=1%>">首页</a>
		<a
			href="QueryInPageStudentsBySnameServlet?currentPage=<%=p.getCurrentPage() - 1%>">上一页</a>
		<a
			href="QueryInPageStudentsBySnameServlet?currentPage=<%=p.getCurrentPage() + 1%>">下一页</a>
		<a
			href="QueryInPageStudentsBySnameServlet?currentPage=<%=p.getTotalPage()%>">尾页</a>
		<%
			}
		%><br /> <a>共查询到<%=p.getCount()%>条数据
		</a>|| <a>当前第<%=p.getCurrentPage()%>页
		</a>/ <a>共<%=p.getTotalPage()%>页
		</a><br />
		每页显示<select name="pageSizeJSP">
			<option disabled selected hidden=>---</option>
			<option value="3">3</option>
			<option value="5">5</option>
			<option value="10">10</option>
			<option value="15">15</option>

		</select>条 <input type="submit" value="提交">


	</form>
</body>
</html>


