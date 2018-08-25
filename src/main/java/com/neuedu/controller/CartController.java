package com.neuedu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.neuedu.entity.Cart;
import com.neuedu.entity.PageModel;

import com.neuedu.service.CartService;

import com.neuedu.service.ProductService;
import com.neuedu.service.impl.CartServiceImpl;
import com.neuedu.service.impl.LoginServiceImpl;
import com.neuedu.service.impl.ProductServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

@WebServlet("/view/cartView/CartController")
public class CartController extends HttpServlet {

	@Autowired
	CartService cartService ;

	@Override
	public void init(){
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,this.getServletContext());
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ProductService pService = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String operation = request.getParameter("operation");// operation�ж��Ƿ�ִ����ɾ��
        System.out.println("=================");
        System.out.println(operation);
		if (operation != null && !operation.equals("")) {
			if (operation.equals("1")) {
				addCart(request, response);
			} else if (operation.equals("2")) {
				// findAll(request,response);
			} else if (operation.equals("3")) {
				 updateCart(request, response);;
			} else if (operation.equals("4")) {
				findCartById(request, response);
			} else if (operation.equals("5")) {
				deleteCart(request, response);
			} else if (operation.equals("6")) {
				findEmByPage(request, response);
			}
		} else {

		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
	}

	/**
	 * �����Ʒ
	 * 
	 * @throws IOException
	 * @throws ServletException
	 */

	/**
	 * ��ӹ��ﳵ
	 * 
	 * @throws IOException
	 * @throws ServletException
	 **/
	public void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService productService = new ProductServiceImpl();
		Cart cart = new Cart();
		int productid=Integer.parseInt(request.getParameter("productid"));
		int productnum = Integer.parseInt(request.getParameter("productnum"));
		cart.setProductid(productid);
		cart.setProductNum(productnum);
		boolean result = cartService.addCart(cart);
		if (result) {
			System.out.println("��ӳɹ�");
			findEmByPage(request, response);
		} else {
			System.out.println("���ʧ��");
		}
	}

	public boolean addCart(Cart cart) {

		return cartService.addCart(cart);
	}

	/**
	 * ɾ��
	 * 
	 * @throws IOException
	 * @throws ServletException
	 */
	public void deleteCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
		boolean result = cartService.deleteCart(id);
		System.out.println(result);
		if (result) {
			System.out.println("ɾ���ɹ�");

			findEmByPage(request, response);
		} else {
			System.out.println("ɾ��ʧ��");
		}
	}

	/**
	 * �޸Ĺ��ﳵ 3
	 * 
	 * @throws IOException
	 * @throws ServletException
	 */
	public void updateCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int productid=Integer.parseInt(request.getParameter("productid"));

		int productnum = Integer.parseInt(request.getParameter("productnum"));
		Cart cart = new Cart(id,productid, productnum);
		System.out.println(cart);
		boolean result = cartService.updataeCart(cart);
		if (result) {
			System.out.println("�޸ĳɹ�");
			findEmByPage(request, response);
		} else {
			System.out.println("�޸�ʧ��");
		}
	}

	/**
	 * ��ѯ���ﳵ
	 */
	public List<Cart> findAllCart() {
		return cartService.findAllCart();
	}

	/**
	 * ����id��ѯ���ﳵ 4
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void findCartById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid=request.getParameter("id");
		String ptid=request.getParameter("productid");

		int id =0;
		int productId=0;
		if(sid==null&&ptid!=null){
			try {
				productId=Integer.parseInt(ptid);
			}catch (NumberFormatException e){
				e.printStackTrace();
			}
			boolean result=cartService.findCartByProductId(productId);
			System.out.println("55555555"+result);
			if (result){
				System.out.println("���ﳵ�Ѵ������Ʒ������Ҫ�����");
				request.getRequestDispatcher("addCart1.jsp").forward(request, response);
				return;
			}else{

				request.setAttribute("productid", productId);
				request.getRequestDispatcher("addCart.jsp").forward(request, response);
			}
		}

		try {
			id=Integer.parseInt(sid);
			productId=Integer.parseInt(ptid);
		}catch (NumberFormatException e){
			e.printStackTrace();
		}

		Cart cart = cartService.findCartById(id);
		request.setAttribute("cart", cart);
		request.getRequestDispatcher("updateCart.jsp").forward(request, response);
	}

	/**
	 * ��ȡ���ﳵ����Ʒ����
	 */
	public int getCartNum() {
		return cartService.getCartNum();
	};

	/**
	 * �޸Ĺ��ﳵ��Ʒ����
	 * 
	 * @param id
	 *            Ҫ�޸ĵĹ��ﳵ��Id
	 * @param num
	 *            �޸ĺ������
	 */
	public boolean updateCart(int id, int num) {
		return cartService.updateCart(id, num);
	};

	/**
	 * ��ҳ��ѯ���ﳵ
	 * 
	 * @throws IOException
	 * @throws ServletException
	 */
	public void findEmByPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pageNo = request.getParameter("pageNo");
		if (pageNo == null) {
			pageNo = "1";
		}
		System.out.println();
		PageModel<Cart> pageModel = cartService.findEmByPage(Integer.parseInt(pageNo), 3);

        //�������ķ���
		String callback=request.getParameter("callback");

		String jsonSt=JSONArray.toJSONString(pageModel);
		PrintWriter printWriter = response.getWriter();
		printWriter.write(callback+"("+jsonSt+")");

//		request.setAttribute("pageModel", pageModel);
//		request.getRequestDispatcher("showCartByPage.jsp").forward(request, response);
	}

}
