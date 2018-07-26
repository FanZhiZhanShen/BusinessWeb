package com.neuedu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.Product;
import com.neuedu.service.ProductService;
import com.neuedu.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class UserOrderController
 */
@WebServlet("/UserOrderController")
public class UserOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserOrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService pService=new ProductServiceImpl();
		int productid=0;
		int id=0;
		int productNum=0;
		int payment_type=0;
		try {
			productid=Integer.parseInt(request.getParameter("productid")) ;
			id=Integer.parseInt(request.getParameter("id")) ;
			productNum=Integer.parseInt(request.getParameter("productNum")) ;
			
			Product product=pService.findProductById(productid);
			
			
			int order_no=id;
			int user_id=0;
			int shipping_id=product.getId();
			double  payment=product.getPrice()*productNum;	
					
		    
    	}catch(NumberFormatException e) {
    		e.printStackTrace();	
    	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
