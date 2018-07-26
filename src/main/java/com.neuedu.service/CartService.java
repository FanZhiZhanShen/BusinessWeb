package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.Cart;
import com.neuedu.entity.PageModel;

public interface CartService {

	/**
	 * 添加购物车
	 **/
	boolean  addCart(Cart cart);
	/**
	 * 删除
	 * */
	boolean  deleteCart(int id);
	/**
	 * 修改购物车
	 * */
	boolean  updataeCart(Cart cart);
	/**
	 * 查询购物车
	 * */
	List<Cart> findAllCart();
	
	
	/**
	 * 根据id查询购物车
	 * */
	public Cart findCartById(int id);
	
	/**
	 * 获取购物车中商品数量
	 * */
	int  getCartNum();
	/**修改购物车商品数量
	 * @param  id  要修改的购物车的Id
	 * @param  num 修改后的数量
	 * */
	boolean  updateCart(int id, int num);
	
	/**
	 * 分页查询购物车
	 * */
	 public PageModel<Cart> findEmByPage(Integer pageNo, Integer pageSize);
	
}
