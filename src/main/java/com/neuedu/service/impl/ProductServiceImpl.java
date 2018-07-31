package com.neuedu.service.impl;

import java.util.List;

import com.neuedu.dao.ProductDao;
import com.neuedu.dao.impl.jdbc.ProductDaoImpl;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.mybatis.MybatisProductDaoImpl;
import com.neuedu.service.ProductService;

public class ProductServiceImpl implements ProductService {

	
	ProductDao productDao=new MybatisProductDaoImpl();
	
	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		
		return productDao.addProduct(product);
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.updateProduct(product);
	}

	@Override
	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		return productDao.deleteProduct(id);
	}

	@Override
	public Product findProductById(int id) {
		// TODO Auto-generated method stub
		return productDao.findById(id);
	}

	@Override
	public PageModel<Product> findEmByPage(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		return productDao.findEmpByPage(pageNo, pageSize);
	}

	
}
