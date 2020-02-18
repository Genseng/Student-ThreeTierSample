package org.student.entity;

import java.util.List;

//用来帮助分类
public class Page {
//	当前页：currentPage
	private int currentPage;
//	页面大小：PageSize
	private int pageSize;

//	查询出的总数据：getXxxCount
	private int count;

//	总页数：totalPage
	private int totalPage;

// 当前页的数据集合：Students
	private List<Student> Students;

	public Page() {

	}

	public Page(int currentPage, int pageSize, int count, int totalPage, List<Student> students) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.count = count;
		this.totalPage = totalPage;
		Students = students;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	/*
	 * 自动算出总页数totalPage=总数数据数count%页面大小pageSize==0
	 * ?总数数据数count/页面大小pageSize:总数数据数count/页面大小pageSize+1;
	 * 
	 * if(pageSize>count){ totalPage=1; }
	 * 
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		
		if (this.pageSize > this.count |  this.pageSize > this.count ) {
			this.totalPage = 1;
		}else {
			this.totalPage = this.count % this.pageSize == 0 ? this.count / this.pageSize : this.count / this.pageSize + 1;

		}

	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<Student> getStudents() {
		return Students;
	}

	public void setStudents(List<Student> students) {
		Students = students;
	}

}