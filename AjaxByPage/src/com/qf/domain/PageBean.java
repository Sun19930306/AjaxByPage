package com.qf.domain;

import java.util.List;

public class PageBean {
	private List<Page> list;
	private int pageNo;
	private int pageSize;
	private double totalPage;//总页数
	public double getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(double totalPage) {
		this.totalPage = totalPage;
	}

	public List<Page> getList() {
		return list;
	}

	public void setList(List<Page> list) {
		this.list = list;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "PageBean [list=" + list + ", pageNo=" + pageNo + ", pageSize=" + pageSize + "]";
	}

}
