package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.Category;
import com.neuedu.entity.PageModel;


public interface CategoryService {
	/**添加商品*/
    public  boolean addCategory(Category category);	
    /**查询商品*/
    public  List<Category> findAll();
    /**修改商品*/
    public  boolean  updateCategory(Category category);
    /**删除商品*/
    public  boolean deleteCategory(int id);
    /**根据id查询商品信息*/
    public  Category  findCategoryById(int id);
    /**分页获取*/
    public PageModel<Category> findEmByPage(Integer pageNo, Integer pageSize);
}
