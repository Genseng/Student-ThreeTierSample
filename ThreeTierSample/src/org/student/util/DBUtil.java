package org.student.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//import org.student.entity.Student;

//通用数据库操作方法
public class DBUtil {

	private static final String URL = "jdbc:mysql://localhost:3306/JDBC";
	private static final String USERNAME = "root";
	private static final String PWD = "root";

	public static Connection connection = null;
	public static PreparedStatement pstmt = null;
	public static ResultSet rs = null;

	/**
	 * Object[] params = {name,age,.....x}//实体某些参数 setXxx()方法个数==?个数==数组params个数
	 * 
	 * getConnection()获取与数据库连接 createPreparedStatement()获取参数 执行sql
	 * 
	 */

	// 连接数据库
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		// 调用的时候有捕获，在此简单抛出
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(URL, USERNAME, PWD);

	}

	// 执行sql
	public static PreparedStatement createPreparedStatement(String sql, Object[] params)
			throws ClassNotFoundException, SQLException {
		pstmt = getConnection().prepareStatement(sql);
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
		}
		return pstmt;
	}

	// 关闭流
	public static void clossAll(ResultSet rs, Statement stmt, Connection connection) {

		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 通用增删改
	public static boolean executeUpdate(String sql, Object[] params) {// object[] obs={name,age,...x} params? 参数值
		try {
			// 获取连接对象
			pstmt = createPreparedStatement(sql, params);

			int count = pstmt.executeUpdate();
			if (count > 0)
				return true;
			else
				return false;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			clossAll(null, pstmt, connection);
		}
	}

	// 通用查--集合
	public static ResultSet executeQuery(String sql, Object[] params) {// params? 参数值
//			List<Student> students = new ArrayList<>();
//			Student student = null;
//			Connection connection = null;
//			PreparedStatement pstmt = null;
//			ResultSet rs = null;
		try {
//				
			pstmt = createPreparedStatement(sql, params);

			rs = pstmt.executeQuery();
			return rs;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			// 如果关闭，则不能获取

		}
	}

	// 通用 统计个数（sql查询）
	public static int getTotalCount(String sql, Object[] params) {// select count(*) from studnet;
		int count = -1;

		try {
			pstmt = createPreparedStatement(sql, params);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			clossAll(rs, pstmt, connection);
		}
		return count;
	}

	// 通用 分页
	public static ResultSet queryInPage(String sql, Object[] params) {
		// params currentPage:当前页面(页码) pageSize:页面大小(每页显示的数据条数)
		
		try {
			pstmt = createPreparedStatement(sql, params);
			rs = pstmt.executeQuery();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rs;
	}

}