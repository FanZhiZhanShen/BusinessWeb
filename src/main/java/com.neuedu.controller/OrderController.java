package com.neuedu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.service.OrderService;
import com.neuedu.service.impl.OrderServiceImpl;


@WebServlet("/view/cartView/OrderController")
public class OrderController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	OrderService orderService=new OrderServiceImpl();
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
	}
	
	/**
	 * 
	 */
	
	
	public  boolean  createOrder() {
		
		return orderService.createOrder();
		
	}
	
	
}
