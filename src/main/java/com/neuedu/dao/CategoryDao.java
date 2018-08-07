package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Category;
import com.neuedu.entity.PageModel;


public interface CategoryDao {
	/**
	  * �����Ʒ
	  * */
	boolean  addCategory(Category category);
	/**
	 * �鿴��Ʒ
	 * */
	List<Category> findAll();
	
	/**����id��ѯ��Ʒ*/
	Category  findById(int id);
	/**
	 * �޸���Ʒ
	 * */
	boolean  updateCategory(Category category);
	/**
	 * ɾ����Ʒ
	 * */
	boolean  deleteCategory(int id);
	
	
	
	/**
	 * ��ҳ��ȡ����
	 * pageNo��ȡ�ڼ�ҳ
	 * pageSizeÿҳ�ж�������
	 * 
	 * */
	public PageModel<Category> findEmpByPage(int pageNo, int pageSize);

}
