package org.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.service.StudentServiceImpl;
import org.student.service.impl.IStudentService;

public class DeleteStudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 删除 根据学号
		request.setCharacterEncoding("utf-8");
		// 接收前端传来学号
		int no = Integer.parseInt(request.getParameter("sno"));

		// 传到业务逻辑层
//		StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
		// 接口 x = new 实现类
		IStudentService service = new StudentServiceImpl();

		boolean result = service.deleteStudentBySno(no);

		// 响应编码
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");

//		PrintWriter out = response.getWriter();// out对象
//		if (result) {
//			out.println("删除成功！");
//			response.sendRedirect("QueryAllStudentsServlet");//index.jsp
//		} else {
//			out.println("删除失败！");
//		}
//		
		if (!result) {// 如果删除失败，给request放入error数据
			request.setAttribute("error", "deleteError");
		} else {
			request.setAttribute("error", "noDeleteError");
		}
		// 重定向
//		response.sendRedirect("QueryAllStudentsServlet");
		// 转发
		request.getRequestDispatcher("QueryAllStudentsServlet").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
