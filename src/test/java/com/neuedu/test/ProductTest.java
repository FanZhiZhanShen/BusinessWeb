package com.neuedu.test;


import com.neuedu.dao.ProductDao;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.mybatis.MybatisProductDaoImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductTest {
    ProductDao cDao=new MybatisProductDaoImpl();
    @Test
    public void testFindProductAll(){
        List<Product> list=cDao.findAll();
        System.out.println(list);
    }

    @Test
    public void findProductById(){
        Product product=cDao.findById(23);
        System.out.println("test查询单个类别成功："+product);
    }

    @Test
    public void addProduct(){
        Product product=new Product(1,"asd","ad",123,"ad","dsd",50);
        boolean result=cDao.addProduct(product);
        System.out.println(result);
    }

    @Test
    public void updateProduct(){
        Product product=new Product(21,"abbb","ad",123,"ad","dsd",50);
        boolean result=cDao.updateProduct(product);
        System.out.println(result);
    }
    @Test
    public void deleteProduct(){
        boolean result=cDao.deleteProduct(21);
        System.out.println("test删除单个商品成功："+result);
    }

    @Test
    public void findProductByPage(){
        PageModel<Product> PModel=cDao.findEmpByPage(1,3);
        List<Product> LO=new ArrayList<>();
        LO=PModel.getData();
        System.out.println("test分页查询成功："+LO.get(1).getStock());
    }
}
