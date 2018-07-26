package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.Category;
import com.neuedu.entity.PageModel;


public interface CategoryService {
	/**�����Ʒ*/
    public  boolean addCategory(Category category);	
    /**��ѯ��Ʒ*/
    public  List<Category> findAll();
    /**�޸���Ʒ*/
    public  boolean  updateCategory(Category category);
    /**ɾ����Ʒ*/
    public  boolean deleteCategory(int id);
    /**����id��ѯ��Ʒ��Ϣ*/
    public  Category  findCategoryById(int id);
    /**��ҳ��ȡ*/
    public PageModel<Category> findEmByPage(Integer pageNo, Integer pageSize);
}
