package com.neuedu.entity;

public class Category {
	private int id;//'Ψһ��id'
	private int parent_id;//'Ա�������enpno��mgr����mgr=parent_id,Ҳ�������',
	private String name;//'���������'
	private int status;//'���״̬1����ʱ�����2�������á���֮ͬ��'
	private int sort_order;//'�����ţ�ͬ��չʾ˳����ֵ�������Ȼ����'
	private String create_time;//'����ʱ��'
	private String update_time;//'����ʱ��'

	public Category() {
		super();
	}
	
	public Category(int id, int parent_id, String name, int status, int sort_order, String create_time, String update_time) {
		super();
		this.id = id;
		this.parent_id = parent_id;
		this.name = name;
		this.status = status;
		this.sort_order = sort_order;
		this.create_time = create_time;
		this.update_time = update_time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getSort_order() {
		return sort_order;
	}
	public void setSort_order(int sort_order) {
		this.sort_order = sort_order;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	
	
	

}
