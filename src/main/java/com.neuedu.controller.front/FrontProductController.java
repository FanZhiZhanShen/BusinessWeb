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
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.service.ProductService;
import com.neuedu.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class FrontProductController
 */
@WebServlet("/FrontProductController")
public class FrontProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductService pService=new ProductServiceImpl();
		String method=request.getParameter("method");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		 String pageNo=request.getParameter("pageNo");
	 		if(pageNo==null) {
	 			pageNo="1";	
	 		}
		int _pageNo=Integer.parseInt(pageNo);
	
 		System.out.println(_pageNo);
 		PageModel<Product> pageModel=pService.findEmByPage(_pageNo,3);
 		List<Product> products= pageModel.getData();
 		
//		List<Product> products= pService.findAll();
		Gson gson=new Gson();
		String json=gson.toJson(products);//将Java中的集合转为json字符串
		String json1=gson.toJson(pageModel);//将Java中的对象转为json字符串
		
		System.out.println(json);
		System.out.println(json1);
		PrintWriter write=response.getWriter();//获取了输出流
		write.println(method+"("+json+","+json1+")");//将字符串打印到html中出去，
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
