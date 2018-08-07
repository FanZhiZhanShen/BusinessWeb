package com.neuedu.mybatis;

import com.neuedu.Utiles.FactorySession;
import com.neuedu.dao.ProductDao;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MybatisProductDaoImpl implements ProductDao {

    @Autowired
    SqlSession session;
    @Override
    public boolean addProduct(Product product) {

        int result =session.insert("com.neuedu.entity.Product.addProduct",product);
        System.out.println("addProduct成功返回insert（）："+result);

        return true;
    }

    @Override
    public List<Product> findAll() {


        List<Product> listProduct =session.selectList("com.neuedu.entity.Product.findProductAll");

        System.out.println("Product的查询所有的语句返回的结果长度是："+listProduct.size());


        return listProduct;
    }

    @Override
    public boolean updateProduct(Product product) {

        int result=session.insert("com.neuedu.entity.Product.updateProduct",product);
        System.out.println("Product的修改语句返回的结果是："+result);

        return true;
    }

    @Override
    public boolean deleteProduct(int id) {

        int result=session.delete("com.neuedu.entity.Product.deleteProductById",id);
        System.out.println("Product的删除语句返回的结果是："+result);

        return true;
    }

    @Override
    public Product findById(int id) {

        Product product=session.selectOne("com.neuedu.entity.Product.findProductById",id);
        System.out.println("Product的查询单个的语句返回的结果是："+product);

        return product;
    }

    @Override
    public PageModel<Product> findEmpByPage(int pageNo, int pageSize) {
        /***
         * pageNo:当前页
         * pageSize：一页有几条记录
         * */

        List<Product> listProduct =session.selectList("com.neuedu.entity.Product.findProductAll");
        int totalPage=listProduct.size()%pageSize==0?listProduct.size()/pageSize:listProduct.size()/pageSize+1;
        Map<String,Integer> map=new HashMap<String,Integer>();
        map.put("pageNo",(pageNo - 1) * pageSize);
        map.put("pageSize",pageSize);
        List<Product> listProductLimit=session.selectList("com.neuedu.entity.Product.findProductLimit",map);

        PageModel<Product> PModel=new PageModel(listProductLimit,totalPage,pageNo);
        System.out.println("Product："+PModel);

        return PModel;
    }
}
