package com.neuedu.mybatis;

import com.neuedu.Utiles.FactorySession;
import com.neuedu.dao.CategoryDao;
import com.neuedu.entity.Category;
import com.neuedu.entity.PageModel;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MybatisCategoryDaoImpl implements CategoryDao {
    @Autowired
    SqlSession session;

    @Override
    public boolean addCategory(Category category) {


        int result =session.insert("com.neuedu.entity.Category.addCategory",category);
        System.out.println("addCategory成功返回insert（）："+result);


        return true;
    }

    @Override
    public List<Category> findAll() {

        List<Category> listCategory =session.selectList("com.neuedu.entity.Category.findCategoryAll");
        /**
         * com.neuedu.entity.Category：是映射文件中 maper标签属性namespace的值
         * selectList查询语句不需要提交事务，即数据库语句自动提交
         * 与纯maven（或纯jdbc）的区别：
         *   session.selectList（）该函数直接返回集合而不是结果集，不需要遍历结果集再放在集合中
         * session.commit();
         * */
        System.out.println("Category的查询所有的语句返回的结果长度是："+listCategory.size());

        return listCategory;
    }

    @Override
    public Category findById(int id) {

        Category category=session.selectOne("com.neuedu.entity.Category.findCategoryById",id);
        /**
         * com.neuedu.entity.Category：是映射文件中 maper标签属性namespace的值
         * selectList查询语句不需要提交事务，即数据库语句自动提交
         * 与纯maven（或纯jdbc）的区别：
         *      session.selectList（）该函数直接返回集合而不是结果集，不需要遍历结果集再放在集合中
         * session.commit();
         * */
        System.out.println("Category的查询单个的语句返回的结果是："+category.getId());

        return category;
    }

    @Override
    public boolean updateCategory(Category category) {

        int result=session.insert("com.neuedu.entity.Category.updateCategory",category);
        System.out.println("Category的修改语句返回的结果是："+result);

        return true;
    }

    @Override
    public boolean deleteCategory(int id) {

        int result=session.delete("com.neuedu.entity.Category.deleteCategoryById",id);
        System.out.println("Category的删除语句返回的结果是："+result);

        return true;
    }

    @Override
    public PageModel<Category> findEmpByPage(int pageNo, int pageSize) {
        /***
         * pageNo:当前页
         * pageSize：一页有几条记录
         * */

        List<Category> listCategory =session.selectList("com.neuedu.entity.Category.findCategoryAll");
        int totalPage=listCategory.size()%pageSize==0?listCategory.size()/pageSize:listCategory.size()/pageSize+1;

        Map<String,Integer> map=new HashMap<String,Integer>();
        map.put("pageNo",(pageNo - 1) * pageSize);
        map.put("pageSize",pageSize);
        List<Category> listCategoryLimit=session.selectList("com.neuedu.entity.Category.findCategoryLimit",map);

        PageModel<Category> PModel=new PageModel(listCategoryLimit,totalPage,pageNo);
        System.out.println("Category的分页查询返回的结果是："+PModel);

        return PModel;
    }
}
