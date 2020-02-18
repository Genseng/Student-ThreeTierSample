package org.student.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.student.dao.impl.IStudentDao;
import org.student.entity.Student;
import org.student.util.DBUtil;

//数据访问层 原子性的增删改查
public class StudentDaoImpl implements IStudentDao {// 把接口实现// Dao依赖于数据库
//
//	private final String URL = "jdbc:mysql://localhost:3306/JDBC";
//	private final String USERNAME = "root";
//	private final String PWD = "root";

	// 根据学号 查学生
	public Student queryStudentBySno(int sno) {
		Student student = null;
//		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from student where sno=? order by sno asc ";
			Object[] params = { sno };

			rs = DBUtil.executeQuery(sql, params);
			if (rs.next()) {
				int no = rs.getInt("sno");
				String name = rs.getString("sname");
				int age = rs.getInt("sage");
				String address = rs.getString("saddress");
				student = new Student(no, name, age, address);

			}
			return student;
		}
		/**
		 * catch (ClassNotFoundException e) { e.printStackTrace(); return student; }
		 **/
		catch (SQLException e) {
			e.printStackTrace();
			return student;
		} catch (

		Exception e) {
			e.printStackTrace();
			return student;
		} finally {
			DBUtil.clossAll(rs, pstmt, DBUtil.connection);
//			try {
//				if (rs != null)
//					rs.close();
//				if (pstmt != null)
//					pstmt.close();
//				if (DBUil.connection != null)
//					DBUil.connection.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
		}
	}

	// 查询全部学生
	public List<Student> queryAllStudent() {

		List<Student> students = new ArrayList<>();
		Student student = null;
//		Connection connection = null; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from student order by sno asc";

			rs = DBUtil.executeQuery(sql, null);
//			rs = pstmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt("sno");
				String name = rs.getString("sname");
				int age = rs.getInt("sage");
				String address = rs.getString("saddress");
				student = new Student(no, name, age, address);
				// 增加到集合
				students.add(student);
			}
			return students;
		}
		/**
		 * catch (ClassNotFoundException e) { e.printStackTrace(); return student; }
		 **/
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.clossAll(rs, pstmt, DBUtil.connection);
//			try {
//				if (rs != null)
//					rs.close();
//				if (pstmt != null)
//					pstmt.close();
//				if (DBUil.connection != null)
//					DBUil.connection.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
		}
	}

	// 根据姓名查学生
	public List<Student> queryStudentBySname(String sname) {
		List<Student> students = new ArrayList<>();
		Student student = null;
		// Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from student where sname like ? order by sno asc";
			Object[] params = { sname };

			rs = DBUtil.executeQuery(sql, params);

			while (rs.next()) {
				int no = rs.getInt("sno");
				String name = rs.getString("sname");
				int age = rs.getInt("sage");
				String address = rs.getString("saddress");
				student = new Student(no, name, age, address);
				// 增加到集合
				students.add(student);
			}
			return students;
		}
		/**
		 * catch (ClassNotFoundException e) { e.printStackTrace(); return student; }
		 **/
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.clossAll(rs, pstmt, DBUtil.connection);
//			try {
//				if (rs != null)
//					rs.close();
//				if (pstmt != null)
//					pstmt.close();
//				if (DBUil.connection != null)
//					DBUil.connection.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
		}
	}

	// 根据地址模糊查学生
	public List<Student> queryStudentsBySaddress(String saddress) {
		List<Student> students = new ArrayList<>();
		Student student = null;
		// Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from student where saddress like ? order by sno asc";
			Object[] params = { saddress };

			rs = DBUtil.executeQuery(sql, params);

			while (rs.next()) {
				int no = rs.getInt("sno");
				String name = rs.getString("sname");
				int age = rs.getInt("sage");
				String address = rs.getString("saddress");
				student = new Student(no, name, age, address);
				// 增加到集合
				students.add(student);
			}
			return students;
		}
		/**
		 * catch (ClassNotFoundException e) { e.printStackTrace(); return student; }
		 **/
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.clossAll(rs, pstmt, DBUtil.connection);
//			try {
//				if (rs != null)
//					rs.close();
//				if (pstmt != null)
//					pstmt.close();
//				if (DBUil.connection != null)
//					DBUil.connection.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
		}
	}

	// 根据年龄查学生
	public List<Student> queryStudentBySage(int sage) {
		List<Student> students = new ArrayList<>();
		Student student = null;
		// Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from student where sage=? order by sno asc";
			Object[] params = { sage };

			rs = DBUtil.executeQuery(sql, params);
			while (rs.next()) {
				int no = rs.getInt("sno");
				String name = rs.getString("sname");
				int age = rs.getInt("sage");
				String address = rs.getString("saddress");
				student = new Student(no, name, age, address);
				// 增加到集合
				students.add(student);
			}
			return students;
		}
		/**
		 * catch (ClassNotFoundException e) { e.printStackTrace(); return student; }
		 **/
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.clossAll(rs, pstmt, DBUtil.connection);
//			try {
//				if (rs != null)
//					rs.close();
//				if (pstmt != null)
//					pstmt.close();
//				if (DBUil.connection != null)
//					DBUil.connection.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
		}
	}

	// 根据学号查询学生是否存在
	public boolean isExistBySno(int sno) {
		return queryStudentBySno(sno) == null ? false : true;
	}

	// 增加学生
	public boolean addStudent(Student student) {
		String sql = "insert into student(sno,sname,sage,saddress) values(?,?,?,?)";
		Object[] params = { student.getSno(), student.getSname(), student.getSage(), student.getSaddress() };
		return DBUtil.executeUpdate(sql, params);
	}

	// 根据学号删除学生
	public boolean deleteStudentBySno(int sno) {
		String sql = "delete from student where sno=?";
		Object[] params = { sno };
		return DBUtil.executeUpdate(sql, params);
	}

	// 根据学号修改学生信息：根据sno找到待修改的人，把这个人修改成student
	public boolean updateStudentBySno(int sno, Student student) {
		String sql = "update student set sname=?,sage=?,saddress=? where sno=?";
		Object[] params = { student.getSname(), student.getSage(), student.getSaddress(), sno };
		return DBUtil.executeUpdate(sql, params);
	}

	public int getAllCount() {
		// TODO Auto-generated method stub
		String sql = "select count(1) from student";

		return DBUtil.getTotalCount(sql, null);
	}

	public int getSnameCount(String sname) {
		// TODO Auto-generated method stub
		String sql = "select count(1) from student where sname like ? order by sno asc";
		Object[] params = { sname };

		return DBUtil.getTotalCount(sql, params);
	}

	public int getSageCount(int sage) {
		// TODO Auto-generated method stub
		String sql = "select count(1) from student where sage=? order by sno asc";
		Object[] params = { sage };

		return DBUtil.getTotalCount(sql, params);
	}

	public int getSaddressCount(String saddress) {
		// TODO Auto-generated method stub
		String sql = "select count(1) from student where saddress like ? order by sno asc";
		Object[] params = { saddress };

		return DBUtil.getTotalCount(sql, params);
	}

	public List<Student> queryInPageAllStudents(int currentPage, int pageSize) {
		// currentPage:当前页面(页码) pageSize:页面大小(每页显示的数据条数)

		List<Student> students = new ArrayList<>();
		Student student = null;
//		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from student  order by sno asc limit ?,?;";
		Object[] params = { (currentPage - 1) * pageSize, pageSize };

		rs = DBUtil.queryInPage(sql, params);

		try {
			while (rs.next()) {
				int no = rs.getInt("sno");
				String name = rs.getString("sname");
				int age = rs.getInt("sage");
				String address = rs.getString("saddress");
				student = new Student(no, name, age, address);
				// 增加到集合
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.clossAll(rs, pstmt, null);

		}

		return students;

	}

	
	public List<Student> queryInPageStudentsBySname(String sname, int currentPage, int pageSize) {
		// currentPage:当前页面(页码) pageSize:页面大小(每页显示的数据条数)

		List<Student> students = new ArrayList<>();
		Student student = null;
//		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from student where sname like ? order by sno asc limit ?,?";
		Object[] params = { sname, (currentPage - 1) * pageSize, pageSize };

		rs = DBUtil.queryInPage(sql, params);

		try {
			while (rs.next()) {
				int no = rs.getInt("sno");
				String name = rs.getString("sname");
				int age = rs.getInt("sage");
				String address = rs.getString("saddress");
				student = new Student(no, name, age, address);
				// 增加到集合
				students.add(student);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.clossAll(rs, pstmt, null);

		}

		return students;

	}

	public List<Student> queryInPageStudentsBySage(int sage, int currentPage, int pageSize) {
		// currentPage:当前页面(页码) pageSize:页面大小(每页显示的数据条数)

		List<Student> students = new ArrayList<>();
		Student student = null;
//		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from student  where sage=? order by sno asc  limit ?,?;";
		Object[] params = { sage, (currentPage - 1) * pageSize, pageSize };

		rs = DBUtil.queryInPage(sql, params);

		try {
			while (rs.next()) {
				int no = rs.getInt("sno");
				String name = rs.getString("sname");
				int age = rs.getInt("sage");
				String address = rs.getString("saddress");
				student = new Student(no, name, age, address);
				// 增加到集合
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.clossAll(rs, pstmt, null);

		}

		return students;

	}

	public List<Student> queryInPageStudentsBySaddress(String saddress, int currentPage, int pageSize) {
		// currentPage:当前页面(页码) pageSize:页面大小(每页显示的数据条数)

		List<Student> students = new ArrayList<>();
		Student student = null;
//		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from student where saddress like ? order by sno asc  limit ?,?;";
		Object[] params = { saddress, (currentPage - 1) * pageSize, pageSize };

		rs = DBUtil.queryInPage(sql, params);

		try {
			while (rs.next()) {
				int no = rs.getInt("sno");
				String name = rs.getString("sname");
				int age = rs.getInt("sage");
				String address = rs.getString("saddress");
				student = new Student(no, name, age, address);
				// 增加到集合
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.clossAll(rs, pstmt, null);

		}

		return students;

	}
}
