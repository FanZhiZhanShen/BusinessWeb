package com.neuedu.controller.front;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.neuedu.entity.Cart;

import com.neuedu.service.CartService;
import com.neuedu.service.impl.CartServiceImpl;


/**
 * Servlet implementation class FrontCartController
 */
@WebServlet("/FrontCartController")
public class FrontCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CartService cService=new CartServiceImpl();
		String method=request.getParameter("method");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
 		List<Cart> cartList=cService.findAllCart();
 		
 		System.out.println();
		Gson gson=new Gson();
		String json=gson.toJson(cartList);//将Java中的集合转为json字符串

		System.out.println(json);
		
		PrintWriter write=response.getWriter();//获取了输出流
		write.println(method+"("+json+")");//将字符串打印到html中出去，
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
