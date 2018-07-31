package com.neuedu.utils;

import java.util.Scanner;

import com.neuedu.entity.Cart;
import com.neuedu.entity.UserOrderItem;
import com.neuedu.service.CartService;
import com.neuedu.service.ProductService;
import com.neuedu.service.impl.CartServiceImpl;
import com.neuedu.service.impl.ProductServiceImpl;

/**
 * 
 * ��װͨ�õķ���
 * */
public class Utils {
	
	
	
	/**
	  ���ռ�������
	*/
	public static String  input(String msg){
		@SuppressWarnings("resource")
		Scanner mScanner=new Scanner(System.in);
		System.out.print(msg);
		return mScanner.nextLine();
	}
	
	
	public  static  int  inputInt(String  msg){
		
		@SuppressWarnings("resource")
		Scanner mScanner=new Scanner(System.in);
		System.out.print(msg);
		int operation=mScanner.nextInt();
		return operation;
	}
	
	public  static  double  inputDouble(String  msg){
		
		@SuppressWarnings("resource")
		Scanner mScanner=new Scanner(System.in);
		System.out.print(msg);
		double operation=mScanner.nextDouble();
		return operation;
	}
	
	/**
	 * �����ﳵʵ����ת�ɶ�����ϸʵ����
	 * @param id  ������ϸ�����id
	 * @param order_no  �������
	 * @param  cart ���ﳵ����
	 * */
	public static  UserOrderItem convertToOrderItem(int  id,long  order_no,Cart cart) {
		UserOrderItem orderItem=new UserOrderItem();
		orderItem.setId(id);
		ProductService productService=new ProductServiceImpl();
		orderItem.setOrder_no(order_no);
		orderItem.setProduct_id(productService.findProductById(cart.getProductid()).getId());
		orderItem.setProduct_name(productService.findProductById(cart.getProductid()).getName());
		orderItem.setProduct_image(productService.findProductById(cart.getProductid()).getImage());
		orderItem.setCurrent_unit_price(productService.findProductById(cart.getProductid()).getPrice());
		orderItem.setQuantity(cart.getProductNum());
		orderItem.setTotal_price(productService.findProductById(cart.getProductid()).getPrice()*cart.getProductNum());
		orderItem.setCreate_time(System.currentTimeMillis());
		
		return orderItem;
	}

}
