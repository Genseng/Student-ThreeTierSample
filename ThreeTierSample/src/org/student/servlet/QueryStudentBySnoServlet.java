package org.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Student;
import org.student.service.StudentServiceImpl;

/**
 * Servlet implementation class QueryStudentBySnoServlet
 */
public class QueryStudentBySnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QueryStudentBySnoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 根据学号查询单个人
		request.setCharacterEncoding("utf-8");

		int no = Integer.parseInt(request.getParameter("sno"));
		// 传到业务逻辑层
		StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
		Student student = studentServiceImpl.queryStudentBySno(no);
		System.out.println(student);
		//将此人的数据 通过前台studentInfo.jsp显示
		request.setAttribute("student", student);//请求查询到的学生放入request域中
		request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
		
		
		//如果request域没有数据，使用重定向response.setRedirect();
		//如果request域有数据（request.setAttribute()  ）使用请求转发

//		// 响应编码
//		response.setContentType("text/html; charset=UTF-8");
//		response.setCharacterEncoding("utf-8");
//		PrintWriter out = response.getWriter();// out对象

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
