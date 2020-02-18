package org.student.service;

import java.util.List;

import org.student.dao.StudentDaoImpl;
import org.student.dao.impl.IStudentDao;
import org.student.entity.Student;
import org.student.service.impl.IStudentService;

//业务逻辑层 逻辑性增删改查（增：查+增） 对dao层进行组装
public class StudentServiceImpl implements IStudentService {// 接口实现
//	StudentDaoImpl studentDaoImpl = new StudentDaoImpl();// service依赖于Dao
	IStudentDao studentDao = new StudentDaoImpl();// 多肽

	// 查1 根据学号查询一个人
	public Student queryStudentBySno(int sno) {
		return studentDao.queryStudentBySno(sno);
	}

	// 查2 查全部学生
	public List<Student> queryAllStudents() {
		return studentDao.queryAllStudent();
	}

	// 查3 根据姓名查学生
	public List<Student> queryStudentsBySname(String sname) {
		return studentDao.queryStudentBySname(sname);
	}

	// 查4 根据年龄查学生
	public List<Student> queryStudentsBySage(int sage) {
		return studentDao.queryStudentBySage(sage);
	}

	// 查5 根据地址查学生
	public List<Student> queryStudentsBySaddress(String saddress) {
		return studentDao.queryStudentsBySaddress(saddress);
	}

	// 业务逻辑层修改学生（增：查+增）
	public boolean updateStudentBySno(int sno, Student student) {
		if (studentDao.isExistBySno(sno)) {// 存在
//				studentDao.updateStudentBySno(sno, student);
//				return true;
			return studentDao.updateStudentBySno(sno, student);
		}
		System.out.println("修改失败！");
		return false;

	}

	// 业务逻辑层删除学生（删：查+删除）
	public boolean deleteStudentBySno(int sno) {
		if (studentDao.isExistBySno(sno)) {// 存在
//				studentDao.deleteStudentBySno(sno);
//				//System.out.println("删除成功！");
//				return true;
			return studentDao.deleteStudentBySno(sno);
		} else {
			System.out.println("删除失败！");
			return false;
		}
	}

	// 业务逻辑层增加学生（增：查+增）
	public boolean addStudent(Student student) {
		if (!studentDao.isExistBySno(student.getSno())) {// 不存在
//				studentDao.addStudent(student);
//				return true;

			return studentDao.addStudent(student);

		} else {
			System.out.println("此人已存在！");
			return false;
		}
	}

	public int getAllCount() {
		// TODO Auto-generated method stub
		return studentDao.getAllCount();
	}

	public int getSnameCount(String sname) {
		// TODO Auto-generated method stub
		return studentDao.getSnameCount(sname);
	}

	public int getSageCount(int sage) {
		// TODO Auto-generated method stub
		return studentDao.getSageCount(sage);
	}
	

	public int getSaddressCount(String saddress) {
		// TODO Auto-generated method stub
		return studentDao.getSaddressCount(saddress);
	}
	

	public List<Student> queryInPageAllStudents(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return studentDao.queryInPageAllStudents(currentPage, pageSize);
	}

	public List<Student> queryInPageStudentsBySname(String sname,int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return studentDao.queryInPageStudentsBySname(sname, currentPage, pageSize);
	}

	public List<Student> queryInPageStudentsBySage(int sage,int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return studentDao.queryInPageStudentsBySage(sage, currentPage, pageSize);
	}

	public List<Student> queryInPageStudentsBySaddress(String saddress, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return studentDao.queryInPageStudentsBySaddress(saddress, currentPage, pageSize);
	}

	
	
	
	
	
	

}
