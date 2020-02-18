package org.student.servlet;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Student;
import org.student.service.StudentServiceImpl;
import org.student.service.impl.IStudentService;

//表示层后台
public class AddStudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 增加
		request.setCharacterEncoding("utf-8");
		int no = Integer.parseInt(request.getParameter("sno"));
		String name = request.getParameter("sname");
		int age = Integer.parseInt(request.getParameter("sage"));
		String address = request.getParameter("saddress");
		// 封装成类---> 实现类
		Student student = new Student(no, name, age, address);
		// 传到业务逻辑层
//		StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
		// 接口 x = new 实现类
		IStudentService service = new StudentServiceImpl();

		boolean result = service.addStudent(student);
		// 响应编码
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");

//		PrintWriter out = response.getWriter();// out对象
//		if (result) {
//			out.println("增加成功！");
//			// 增加成功，重新查询
////			response.sendRedirect("QueryAllStudentsServlet");
//		} else {
//			out.println("增加失败！");
//		}

		if (!result) {// 如果增加失败，给request放入error数据
			request.setAttribute("error", "addError");
		} else {
			request.setAttribute("error", "noAddError");
		}
		// 重定向
//		response.sendRedirect("QueryAllStudentsServlet");
		// 转发
		request.getRequestDispatcher("QueryAllStudentsServlet").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
