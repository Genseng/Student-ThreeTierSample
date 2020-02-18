package org.student.dao.impl;

import java.util.List;

import org.student.entity.Student;

public interface IStudentDao {

	public Student queryStudentBySno(int sno);

	public List<Student> queryAllStudent();

	public List<Student> queryStudentBySname(String sname);

	public List<Student> queryStudentBySage(int sage);

	public List<Student> queryStudentsBySaddress(String saddress);

	// 根据学号查询学生是否存在
	public boolean isExistBySno(int sno);

	public boolean addStudent(Student student);

	public boolean deleteStudentBySno(int sno);

	public boolean updateStudentBySno(int sno, Student student);

	// 统计全部学生人数
	public int getAllCount();

	// 统计姓名一致的学生人数
	public int getSnameCount(String sname);
	
	public int getSaddressCount(String saddress);

	// 统计年龄相同的学生人数
	public int getSageCount(int sage);

	//分页 : currentPage:当前页面(页码) pageSize:页面大小(每页显示的数据条数)
	public List<Student> queryInPageAllStudents(int currentPage, int pageSize);

	public List<Student> queryInPageStudentsBySname(String sname,int currentPage, int pageSize);

	public List<Student> queryInPageStudentsBySage(int sage,int currentPage, int pageSize);

	public List<Student> queryInPageStudentsBySaddress(String saddress,int currentPage, int pageSize);

	
}
