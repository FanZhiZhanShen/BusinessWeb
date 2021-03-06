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
import com.neuedu.service.impl.CategoryServiceImpl;
import com.neuedu.service.impl.OrderServiceImpl;
import com.neuedu.service.impl.ProductServiceImpl;
import com.neuedu.service.impl.UserOrderServiceImpl;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;


@WebServlet("/view/userOrderView/OrderController")
public class OrderController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Autowired
	UserOrderService orderServic;

	@Autowired
	ProductService productService;

	String callback=null;
	PrintWriter jsonWrite=null;

	@Override
	public void init(){
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,this.getServletContext());
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		callback=request.getParameter("callback");

		jsonWrite=response.getWriter();



		String operation=request.getParameter("operation");
        System.out.println(operation);
		if (operation.equals("1")){
			findUserOrderByPage(request,response);
		}else if(operation.equals("2")){
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
//		request.setAttribute("pageModel", pageModel);
//		request.getRequestDispatcher("showUserOrderByPage.jsp").forward(request, response);

		String jsonPageModel= JSONArray.toJSONString(pageModel);
		jsonWrite.write(callback+"("+jsonPageModel+")");
		System.out.println(jsonPageModel);
	}


	/**
	 * 创建订单
	 */
	public  void addUserOrder(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {


		UserOrder userO= null;
		boolean result=false;
		int productid=0;
		int productNum=0;
		try{
			productid=Integer.parseInt(request.getParameter("productid"));
			Product product=productService.findProductById(productid);

			productNum=Integer.parseInt(request.getParameter("productNum"));

			if (product.getStock()>=productNum){
				product.setStock(product.getStock()-productNum);
				productService.updateProduct(product);
			}else{
				System.out.println("商品库存不够,请下次再来买");
				return;
			}
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

			jsonWrite.write(callback+"()");
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
		boolean result = orderServic.emptUserOrder();
		if (result) {
			System.out.println("成功");
			findUserOrderByPage(request, response);
		} else {
			System.out.println("失败");
		}
	}
}
