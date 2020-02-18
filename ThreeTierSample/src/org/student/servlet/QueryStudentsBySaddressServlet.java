package org.student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Student;
import org.student.service.StudentServiceImpl;

/**
 * Servlet implementation class QueryStudentBySaddressServlet
 */
public class QueryStudentsBySaddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QueryStudentsBySaddressServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

// 根据地址查询学生---备用
		request.setCharacterEncoding("utf-8");
		String address = (String) (request.getParameter("saddress"));

		// 传到业务逻辑层
		StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
		List<Student> students = studentServiceImpl.queryStudentsBySaddress(address);

		System.out.println(students);
		System.out.println("queryStudentsBySaddressServlet...");
		request.setAttribute("students", students);
		// requset 有数据，需要请求转发 （重定向丢失request域）
		request.getRequestDispatcher("studentInfoQuery.jsp").forward(request, response);

		// // 响应编码
//				response.setContentType("text/html; charset=UTF-8");
//				response.setCharacterEncoding("utf-8");
//				PrintWriter out = response.getWriter();// out对象

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
