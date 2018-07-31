package com.neuedu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONArray;
import com.neuedu.entity.Account;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.entity.UserOrder;
import com.neuedu.service.OrderService;
import com.neuedu.service.ProductService;
import com.neuedu.service.UserOrderService;
import com.neuedu.service.impl.OrderServiceImpl;
import com.neuedu.service.impl.ProductServiceImpl;
import com.neuedu.service.impl.UserOrderServiceImpl;
import org.apache.ibatis.jdbc.Null;


@WebServlet("/view/userOrderView/OrderController")
public class OrderController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	UserOrderService orderServic=new UserOrderServiceImpl();
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("---------执行到doGet-------");
		String operation=request.getParameter("operation");
        System.out.println(operation);
		if (operation.equals("1")){
			findUserOrderByPage(request,response);
		}else if(operation.equals("2")){
            System.out.println("---------operation.equals(das)-------");
            addUserOrder(request,response);

        }else if(operation.equals("3")){
		    deleteUserOrder(request,response);

        }else if(operation.equals("4")){
			emptyUserOrder(request,response);
		}
	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
	}

	/**
	 * 查询已买商品
	 */
	public  void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<UserOrder> serOrder= orderServic.findAll();
		request.setAttribute("product", serOrder);
		request.getRequestDispatcher("showprocute.jsp").forward(request, response);
	}


	/**
	 * 分页查询已买商品
	 */
	public  void findUserOrderByPage(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String pageNo=request.getParameter("pageNo");
		if(pageNo==null) {
			pageNo="1";
		}

		System.out.println();
		PageModel<UserOrder> pageModel=orderServic.findEmByPage(Integer.parseInt(pageNo),3);

		System.out.println(pageModel);
		request.setAttribute("pageModel", pageModel);
		request.getRequestDispatcher("showUserOrderByPage.jsp").forward(request, response);

		//??json
		String jsonPageModel= JSONArray.toJSONString(pageModel);
		PrintWriter jsonWrite=response.getWriter();
		jsonWrite.println(jsonPageModel);
		System.out.println(jsonPageModel);
	}


	/**
	 * 创建订单
	 */
	public  void addUserOrder(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		ProductService productService=new ProductServiceImpl();

		UserOrder userO= null;
		boolean result=false;
		int productid=0;
		int productNum=0;
		try{
			productid=Integer.parseInt(request.getParameter("productid"));
			Product product=productService.findProductById(productid);
			productNum=Integer.parseInt(request.getParameter("productNum"));

			HttpSession session=request.getSession();//获取回话

			Object accobject= session.getAttribute("acc");
			Account acc=(Account)accobject;
            long order_no=new Date().getTime();
            int user_id=acc.accountId;
            int shipping_id=1;
			int payment_type=1;
			int postage=10;
			int status=1;
			double payment=product.getPrice()*productNum+postage;
			userO=new UserOrder(order_no,user_id,shipping_id,payment,payment_type,postage,status);
			result=orderServic.addUserOrder(userO);
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		if (result){
			System.out.println("购买成功");
			findUserOrderByPage(request,response);
		}else{
			System.out.println("购买失败");
		}
	}

    public  void deleteUserOrder(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int id=0;
        boolean result=false;
        try {
            id=Integer.parseInt(request.getParameter("id")) ;
           result=orderServic.deleteUserOrder(id);
        }catch(NumberFormatException e) {
            e.printStackTrace();
        }
        if(result) {
            System.out.println("成功");
            findUserOrderByPage(request, response);
        }else {
            System.out.println("失败");
        }
    }

	public  void emptyUserOrder(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		boolean result=orderServic.emptUserOrder();
		if(result) {
			System.out.println("成功");
			findUserOrderByPage(request, response);
		}else {
			System.out.println("失败");
		}
	}
	
}
