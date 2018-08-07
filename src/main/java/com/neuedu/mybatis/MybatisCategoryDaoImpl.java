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
        System.out.println("addCategory�ɹ�����insert������"+result);


        return true;
    }

    @Override
    public List<Category> findAll() {

        List<Category> listCategory =session.selectList("com.neuedu.entity.Category.findCategoryAll");
        /**
         * com.neuedu.entity.Category����ӳ���ļ��� maper��ǩ����namespace��ֵ
         * selectList��ѯ��䲻��Ҫ�ύ���񣬼����ݿ�����Զ��ύ
         * �봿maven����jdbc��������
         *   session.selectList�����ú���ֱ�ӷ��ؼ��϶����ǽ����������Ҫ����������ٷ��ڼ�����
         * session.commit();
         * */
        System.out.println("Category�Ĳ�ѯ���е���䷵�صĽ�������ǣ�"+listCategory.size());

        return listCategory;
    }

    @Override
    public Category findById(int id) {

        Category category=session.selectOne("com.neuedu.entity.Category.findCategoryById",id);
        /**
         * com.neuedu.entity.Category����ӳ���ļ��� maper��ǩ����namespace��ֵ
         * selectList��ѯ��䲻��Ҫ�ύ���񣬼����ݿ�����Զ��ύ
         * �봿maven����jdbc��������
         *      session.selectList�����ú���ֱ�ӷ��ؼ��϶����ǽ����������Ҫ����������ٷ��ڼ�����
         * session.commit();
         * */
        System.out.println("Category�Ĳ�ѯ��������䷵�صĽ���ǣ�"+category.getId());

        return category;
    }

    @Override
    public boolean updateCategory(Category category) {

        int result=session.insert("com.neuedu.entity.Category.updateCategory",category);
        System.out.println("Category���޸���䷵�صĽ���ǣ�"+result);

        return true;
    }

    @Override
    public boolean deleteCategory(int id) {

        int result=session.delete("com.neuedu.entity.Category.deleteCategoryById",id);
        System.out.println("Category��ɾ����䷵�صĽ���ǣ�"+result);

        return true;
    }

    @Override
    public PageModel<Category> findEmpByPage(int pageNo, int pageSize) {
        /***
         * pageNo:��ǰҳ
         * pageSize��һҳ�м�����¼
         * */

        List<Category> listCategory =session.selectList("com.neuedu.entity.Category.findCategoryAll");
        int totalPage=listCategory.size()%pageSize==0?listCategory.size()/pageSize:listCategory.size()/pageSize+1;

        Map<String,Integer> map=new HashMap<String,Integer>();
        map.put("pageNo",(pageNo - 1) * pageSize);
        map.put("pageSize",pageSize);
        List<Category> listCategoryLimit=session.selectList("com.neuedu.entity.Category.findCategoryLimit",map);

        PageModel<Category> PModel=new PageModel(listCategoryLimit,totalPage,pageNo);
        System.out.println("Category�ķ�ҳ��ѯ���صĽ���ǣ�"+PModel);

        return PModel;
    }
}
