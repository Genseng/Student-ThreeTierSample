<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">

	function check()//onsubmit  return true：表单正常提交 false：表单中止提交 
	{
		var sno = $("#sno").val();
		var sname = $("#sname").val();
		var sage = $("#sage").val();
		var saddress = $("#saddress").val();
		if(!(sno>0 && sno<101)){
			alert("学号有误！必须是1-100")
			return false;
		}
		if(!(sname.length>1 && sname.length<7)){
			alert("姓名长度有误！必须是2-6位")
			return false;
		}
		if(!(sage>0 && sage<201)){
			alert("年龄有误！必须是1-200")
			return false;
		}
		if(!(saddress.length>1 && saddress.length<101)){
			alert("地址长度有误！必须是2-100")
			return false;
		}
		return true;
	}
	
	
	$(document).ready(function() {

});
</script>

<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="AddStudentServlet" method="post" onsubmit="return check()">
		学号：<input type="text" name="sno" id="sno" /><br /> 
		姓名：<input type="text"	name="sname" id="sname"/><br />
		年龄：<input type="text" name="sage" id="sage"/><br />
		地址：<input type="text" name="saddress" id="saddress"/><br />
		 <input type="submit" value="新增" />
		
		<a href="QueryAllStudentsServlet">返回</a>
		<br />
	</form>
</body>
</html>