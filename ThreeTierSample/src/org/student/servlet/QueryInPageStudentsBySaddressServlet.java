package org.student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Page;
import org.student.entity.Student;
import org.student.service.StudentServiceImpl;
import org.student.service.impl.IStudentService;

/**
 * Servlet implementation class QueryInPageStudentsBySaddressServlet
 */
public class QueryInPageStudentsBySaddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QueryInPageStudentsBySaddressServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//备用
		request.setCharacterEncoding("utf-8");
		IStudentService studentService = new StudentServiceImpl();

		String address = (String) (request.getParameter("saddress"));
		int count = studentService.getSaddressCount(address);// 总数

		// 造假
//		int currentPage =2;
//		int pageSize = 5;

		int currentPage = 1;// 默认第一页
		int pageSize = 5;// 页面大小默认为5

		// 不是第一次访问（操作 首页 上一页...）
		String cPage = request.getParameter("currentPage");
		String pSize = request.getParameter("pageSize");

		if (cPage != null)
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		if (pSize != null)
			pageSize = Integer.parseInt(request.getParameter("pageSize"));

		System.out.println("当前页数:" + currentPage);
		System.out.println("当前页面大小:" + pageSize);
		// 传到业务逻辑层
		List<Student> students = studentService.queryInPageStudentsBySaddress(address, currentPage, pageSize);// 分页查询
		System.out.println(students);
		System.out.println("查询结果条数:" + count);
		Page page = new Page();
		// 只需要组装四个
		page.setCount(count);
		page.setCurrentPage(currentPage);
		page.setStudents(students);
		page.setPageSize(pageSize);// 最后组装 总页数page自动计算

		request.setAttribute("page", page);
		// requset 有数据，需要请求转发 （重定向丢失request域）
		request.getRequestDispatcher("showAllInPage.jsp").forward(request, response);

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
