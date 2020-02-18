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

public class QueryInPageStudentsBySageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	int AGE;
	int PAGESIZE;
	int pSizeFlg;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 根据年龄查询学生

		/*
		 * age 作为年龄判断是否相等的变量先定义 根据后续条件赋值 1-第一次查询（age从前端获取sage字段的值成功） 另外全局变量AGE接受age (AGE
		 * 全局变量在函数外定义，在函数内赋值————第一次查询时) 2-翻页之后 age不存在 则从全局变量中获取（age=AGE）
		 * 
		 */
		int age;// 不先赋值 只先定义 有助于条件赋值

		if (request.getParameter("sage") != null) {
			age = Integer.parseInt(request.getParameter("sage"));
			AGE = age;
		} else {
			age = AGE;
		}

		
		/*
		 * currentPage为当前页数 默认为1（首页） 1-第一次查询获取不到 -(cPage == null)（默认1） 2-第二次 (cPage !=
		 * null ==1) （页操作 下一页-上一页-首页-尾页） currentPage 数值变化
		 * 
		 * pageSize 页面大小 默认5; 1-第一次查询获取不到 -(pSize == null)（默认5） 进入页之后
		 * 可以通过select-option-的name="pageSize" 获取value 3-翻页时 页面容量保持不变
		 * a-全局变量PAGESIZE在函数外定义， pageSize能获取到时在函数内赋值 （PAGESIZE=pageSize） b-第二次（页操作
		 * 下一页-上一页-首页-尾页） pageSize = PAGESIZE;
		 * 
		 */

		request.setCharacterEncoding("utf-8");
		IStudentService studentService = new StudentServiceImpl();

		String pSizeJSP = request.getParameter("pageSizeJSP");

		String cPage = request.getParameter("currentPage");
//		String pSize = request.getParameter("pageSize");
		int pageSize;
		
		int currentPage;
		// 查询符合条件（age=xxx）的数据条数

		int count = studentService.getSageCount(age);// 总数

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

		List<Student> students = studentService.queryInPageStudentsBySage(age, currentPage, pageSize);// 分页查询

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
		// requset 有数据，需要请求转发 （重定向丢失request域）***注意路径
		request.getRequestDispatcher("studentInfoQueryInPage/studentInfoQueryInPageBySage.jsp").forward(request,
				response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
