package com.neuedu.service.impl;

import java.util.List;

import com.neuedu.dao.CartDao;
import com.neuedu.entity.Cart;
import com.neuedu.entity.PageModel;
import com.neuedu.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    @Qualifier("mybatisCartDaoImpl")
	private CartDao cartDao;


	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}

	public CartDao getCartDao() {
		return cartDao;
	}

	@Override
	public boolean addCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartDao.addCart(cart);
	}

	@Override
	public boolean deleteCart(int id) {
		// TODO Auto-generated method stub
		return cartDao.deleteCart(id);
	}

	@Override
	public boolean updataeCart(Cart cart) {
		
		return cartDao.updataeCart(cart);
	}

	@Override
	public List<Cart> findAllCart() {
		// TODO Auto-generated method stub
		return cartDao.findAllCart();
	}
	
	@Override
	public Cart findCartById(int id) {
		// TODO Auto-generated method stub
		return cartDao.findCartById(id);
	}

	@Override
	public boolean findCartByProductId(int productId) {
		return cartDao.findCartByProductId(productId);
	}

	@Override
	public int getCartNum() {
		// TODO Auto-generated method stub
		return cartDao.getCartNum();
	}

	@Override
	public boolean updateCart(int id, int num) {
		// TODO Auto-generated method stub
		return cartDao.updateCart(id, num);
	}

	@Override
	public PageModel<Cart> findEmByPage(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		System.out.println(cartDao);
		return cartDao.findEmpByPage(pageNo, pageSize);
	}

	

}
