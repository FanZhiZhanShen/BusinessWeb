package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Category;
import com.neuedu.entity.PageModel;


public interface CategoryDao {
	/**
	  * 添加商品
	  * */
	boolean  addCategory(Category category);
	/**
	 * 查看商品
	 * */
	List<Category> findAll();
	
	/**根据id查询商品*/
	Category  findById(int id);
	/**
	 * 修改商品
	 * */
	boolean  updateCategory(Category category);
	/**
	 * 删除商品
	 * */
	boolean  deleteCategory(int id);
	
	
	
	/**
	 * 分页获取数据
	 * pageNo获取第几页
	 * pageSize每页有多少数据
	 * 
	 * */
	public PageModel<Category> findEmpByPage(int pageNo, int pageSize);

}
