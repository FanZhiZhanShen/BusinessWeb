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
        Category category=new Category(2,"ˮ��",2,2);
        boolean result=cDao.addCategory(category);
        System.out.println("test������ɹ���"+result);
    }

    @Test
    public void FindCategroyById(){
        Category category=cDao.findById(13);
        System.out.println("test��ѯ�������ɹ���"+category);
    }

    @Test
    public void updateCategroyById(){

        Category category=new Category(2,"ˮ��",2,2);
        category.setId(13);
        /**
         * idea�е�  ���캯�����Զ�����������һ������
         *          set����Ҳ���Զ�����������һ������
         * */
        boolean result=cDao.updateCategory(category);
        System.out.println("test�޸����ɹ���"+result);
    }

    @Test
    public void deleteCategroyById(){
        boolean result=cDao.deleteCategory(15);
        System.out.println("testɾ���������ɹ���"+result);
    }

    @Test
    public void findCategoryByPage(){
        PageModel<Category> PModel=cDao.findEmpByPage(1,3);
        System.out.println("test��ҳ��ѯ�ɹ���"+PModel);
    }
}
