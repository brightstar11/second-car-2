package com.xh.web.model;


public class PageModel {
	private Integer pageNum=1;
	private Integer pageSize=2;
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public String toString() {
		return "PageModel [pageNum=" + pageNum + ", pageSize=" + pageSize + "]";
	}
	
}
