package com.neuedu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.Cart;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.service.CartService;

import com.neuedu.service.ProductService;
import com.neuedu.service.impl.CartServiceImpl;
import com.neuedu.service.impl.ProductServiceImpl;

@WebServlet("/view/cartView/CartController")
public class CartController extends HttpServlet {
	CartService cartService = new CartServiceImpl();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ProductService pService = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String operation = request.getParameter("operation");// operation判断是否执行增删改
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
	 * 添加商品
	 * 
	 * @throws IOException
	 * @throws ServletException
	 */

	/**
	 * 添加购物车
	 * 
	 * @throws IOException
	 * @throws ServletException
	 **/
	public void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService productService = new ProductServiceImpl();
		Cart cart = new Cart();
		Product productid = productService.findProductById(Integer.parseInt(request.getParameter("productid")));
		int productnum = Integer.parseInt(request.getParameter("productnum"));
		cart.setProductId(productid);
		cart.setProductNum(productnum);
		boolean result = cartService.addCart(cart);
		if (result) {
			System.out.println("添加成功");
			findEmByPage(request, response);
		} else {
			System.out.println("添加失败");
		}
	}

	public boolean addCart(Cart cart) {

		return cartService.addCart(cart);
	}

	/**
	 * 删除
	 * 
	 * @throws IOException
	 * @throws ServletException
	 */
	public void deleteCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		boolean result = cartService.deleteCart(id);
		if (result) {
			System.out.println("删除成功");
			findEmByPage(request, response);
		} else {
			System.out.println("删除失败");
		}
	}

	/**
	 * 修改购物车 3
	 * 
	 * @throws IOException
	 * @throws ServletException
	 */
	public void updateCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Product product=pService.findProductById(Integer.parseInt(request.getParameter("productid")));
		System.out.println(product.getId());
		int productnum = Integer.parseInt(request.getParameter("productnum"));
		Cart cart = new Cart(id,product, productnum);
		boolean result = cartService.updataeCart(cart);
		if (result) {
			System.out.println("修改成功");
			findEmByPage(request, response);
		} else {
			System.out.println("修改失败");
		}
	}

	/**
	 * 查询购物车
	 */
	public List<Cart> findAllCart() {
		return cartService.findAllCart();
	}

	/**
	 * 根据id查询购物车 4
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void findCartById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Cart cart = cartService.findCartById(id);
		request.setAttribute("cart", cart);
		
		request.getRequestDispatcher("updateCart.jsp").forward(request, response);
	}

	/**
	 * 获取购物车中商品数量
	 */
	public int getCartNum() {
		return cartService.getCartNum();
	};

	/**
	 * 修改购物车商品数量
	 * 
	 * @param id
	 *            要修改的购物车的Id
	 * @param num
	 *            修改后的数量
	 */
	public boolean updateCart(int id, int num) {
		return cartService.updateCart(id, num);
	};

	/**
	 * 分页查询购物车
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
		CartService cartservice = new CartServiceImpl();
		System.out.println();
		PageModel<Cart> pageModel = cartservice.findEmByPage(Integer.parseInt(pageNo), 3);
		request.setAttribute("pageModel", pageModel);
		request.getRequestDispatcher("showCartByPage.jsp").forward(request, response);
	}

}
