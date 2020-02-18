package org.student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Student;
import org.student.entity.Page;
import org.student.service.StudentServiceImpl;
import org.student.service.impl.IStudentService;

/**
 * Servlet implementation class QueryInPageAllStudentsServlet
 */
public class QueryInPageAllStudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QueryInPageAllStudentsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	int PAGESIZE;
	int pSizeFlg;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		IStudentService studentService = new StudentServiceImpl();

		String pSizeJSP = request.getParameter("pageSizeJSP");

		String cPage = request.getParameter("currentPage");
//		String pSize = request.getParameter("pageSize");
		int pageSize;
		int currentPage;

		int count = studentService.getAllCount();// 总数

		if (pSizeJSP == null) {// 如果不能接收到 前端下拉框中pageSizeJSP(pSizeJSP空)

			if (pSizeFlg != 1) {// 没设置过页面大小--第一次进入———>设置首页和默认页面大小
				currentPage = 1;
				pageSize = 5;
				PAGESIZE = pageSize;
				pSizeFlg = 1;
			} else {// 设置过页面大小

				if (cPage == null) {// 真正的第一次访问
					currentPage = 1;

				} else {// 操作 首页 上一页...
					currentPage = Integer.parseInt(request.getParameter("currentPage"));

				}
				pageSize = PAGESIZE;
				pSizeFlg = 1;
//				currentPage = Integer.parseInt(request.getParameter("currentPage"));

				PAGESIZE = pageSize;
				pSizeFlg = 1;
			}
		} else {// (pSizeJSP != null)

			currentPage = 1;
			pageSize = Integer.parseInt(request.getParameter("pageSizeJSP"));
			PAGESIZE = pageSize;
			pSizeFlg = 1;// pSizeJSP通过前端设置过页面大小
			System.out.println("能接收到pageSizeJSP=" + Integer.parseInt(request.getParameter("pageSizeJSP")));
			System.out.println("================");
//			pSizeJSP = request.getParameter("pageSizeJSP");

		}

		List<Student> students = studentService.queryInPageAllStudents(currentPage, pageSize);// 分页查询

		Page page = new Page();
		// 只需要组装四个
		page.setCount(count);
		page.setCurrentPage(currentPage);
		page.setStudents(students);
		page.setPageSize(pageSize);// 最后组装 总页数page自动计算

		System.out.println("当前页数:" + currentPage);
		System.out.println("当前页面大小:" + pageSize);
		System.out.println(students);
		System.out.println("查询结果条数:" + count);

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
