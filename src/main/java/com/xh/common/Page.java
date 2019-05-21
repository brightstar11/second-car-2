package com.xh.common;

import java.util.List;

public class Page<T> {
	//数据
	private List<T> dataList;
	//总页数
	private int pagetotal;
	//总数
	private int total;
	//当前页
	private int pageNo = 1;
	//每页数量
	private int pageSise = 10;
	//实体
	private T obj;
	public List<T> getDataList() {
		return dataList;
	}
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	public int getPagetotal() {
		return pagetotal;
	}
	public void setPagetotal(int pagetotal) {
		this.pagetotal = pagetotal;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSise() {
		return pageSise;
	}
	public void setPageSise(int pageSise) {
		this.pageSise = pageSise;
	}
	public T getObj() {
		return obj;
	}
	public void setObj(T obj) {
		this.obj = obj;
	}
	
	
}
