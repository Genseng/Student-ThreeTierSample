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

public class UpdateStudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 修改 根据学号
		request.setCharacterEncoding("utf-8");
		// 获取待修改人的学号
		int no = Integer.parseInt(request.getParameter("sno"));
		// 获取修改后的内容
		String name = request.getParameter("sname");
		int age = Integer.parseInt(request.getParameter("sage"));
		String address = request.getParameter("saddress");
		// 封装成类
		Student student = new Student(name, age, address);
		// 传到业务逻辑层
//		StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
		// 接口 x = new 实现类
		IStudentService service = new StudentServiceImpl();

		boolean result = service.updateStudentBySno(no, student);
		// 响应编码
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");

// PrintWriter out = response.getWriter();// out对象
//		if (result) {
//			out.println("修改成功！");
//			response.sendRedirect("QueryAllStudentsServlet");// 修改之后再次重新查询所有的信学生并显示
//		} else {
//			out.println("修改失败！");
//		}

		if (!result) {// 如果更新失败，给request放入error数据
			request.setAttribute("error", "updateError");
		} else {
			request.setAttribute("error", "noUpdateError");
		}
		// 重定向
//		response.sendRedirect("QueryAllStudentsServlet");
		// 转发
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
