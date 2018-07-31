package com.neuedu.test;

import com.neuedu.dao.CategoryDao;
import com.neuedu.entity.Category;
import com.neuedu.entity.PageModel;
import com.neuedu.mybatis.MybatisCategoryDaoImpl;
import org.junit.Test;

import java.util.List;

public class CategroyTest {
    CategoryDao cDao=new MybatisCategoryDaoImpl();

    @Test
    public void testFindCategroyAll(){

        List<Category> list=cDao.findAll();
        System.out.println(list);
    }

    @Test
    public void addCategory(){
        Category category=new Category(2,"水果",2,2);
        boolean result=cDao.addCategory(category);
        System.out.println("test添加类别成功："+result);
    }

    @Test
    public void FindCategroyById(){
        Category category=cDao.findById(13);
        System.out.println("test查询单个类别成功："+category);
    }

    @Test
    public void updateCategroyById(){

        Category category=new Category(2,"水果",2,2);
        category.setId(13);
        /**
         * idea中的  构造函数会自动给属性生成一个键名
         *          set函数也会自动给属性生成一个键名
         * */
        boolean result=cDao.updateCategory(category);
        System.out.println("test修改类别成功："+result);
    }

    @Test
    public void deleteCategroyById(){
        boolean result=cDao.deleteCategory(15);
        System.out.println("test删除单个类别成功："+result);
    }

    @Test
    public void findCategoryByPage(){
        PageModel<Category> PModel=cDao.findEmpByPage(1,3);
        System.out.println("test分页查询成功："+PModel);
    }
}
