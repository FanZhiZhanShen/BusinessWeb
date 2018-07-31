package com.neuedu.entity;

import java.io.Serializable;
import java.util.List;

public class PageModel<T> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//ÿһҳ���ݼ���
	private List<T> data;
	//�ܹ��ж���ҳ
	private int totalPage;
	//��ǰҳ��
	private int currentPage;
	
	
	
	public PageModel() {
		super();
	}
	public PageModel(List<T> data, int totalPage, int currentPage) {
		super();
		this.data = data;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	@Override
	public String toString() {
		return "PageModel{" +
				"data=" + data +
				", totalPage=" + totalPage +
				", currentPage=" + currentPage +
				'}';
	}
}
