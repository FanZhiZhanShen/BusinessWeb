package com.neuedu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.Category;
import com.neuedu.entity.PageModel;

import com.neuedu.service.CategoryService;
import com.neuedu.service.impl.CategoryServiceImpl;


/**
 * Servlet implementation class CategoryController
 */
@WebServlet("/view/CategoryView/CategoryController")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryService cService = new CategoryServiceImpl();// service层的对象

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoryController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String operation = request.getParameter("operation");// operation判断是否执行增删改
		if (operation != null && !operation.equals("")) {
			if (operation.equals("1")) {
				addCategory(request, response);
			} else if (operation.equals("2")) {
				findallCategory(request, response);
			} else if (operation.equals("3")) {
				 updateCategory(request, response);
			} else if (operation.equals("4")) {
				findCategoryById(request, response);
			} else if (operation.equals("5")) {
				deleteCategory(request, response);
			}
			else if (operation.equals("6")) {
				findCategoryByPage(request, response);
			}
		} else {

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * 添加类别
	 */
	public void addCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Category category = new Category();
		int parent_id = 0;
		String name = request.getParameter("name");
		int status = 0;
		int sort_order = 0;
		
		boolean result = false;
		try {
			sort_order = Integer.parseInt(request.getParameter("sort_order"));
			status = Integer.parseInt(request.getParameter("status"));
			parent_id = Integer.parseInt(request.getParameter("parent_id"));
			category.setParent_id(parent_id);
			category.setName(name);
			category.setStatus(status);
			category.setSort_order(sort_order);
			
			
			result = addCategory(category);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		if (result) {
			System.out.println("商品添加成功");
			findCategoryByPage(request, response);
		} else {
			System.out.println("商品添加失败");
		}
	}

	public boolean addCategory(Category category) {
		return cService.addCategory(category);
	}

	/**
	 * 显示所有类别
	 */
	public void findallCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Category> categorys = cService.findAll();
		request.setAttribute("category", categorys);
		request.getRequestDispatcher("showcategory.jsp").forward(request, response);
	}

	/**
	 * 根据id显示类别  4
	 */
	public void findCategoryById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			
			Category category = findCategoryById(id);
			if(category!=null) {
				request.setAttribute("category", category);
				request.getRequestDispatcher("updatecategory.jsp").forward(request, response);
			}else {
				
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	public Category findCategoryById(int id) {
		return cService.findCategoryById(id);
	}

	/**
	 * 修改类别  3
	 */
	public void updateCategory(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		Category category=new Category();
		int id=0;
		int parent_id = 0;
		
		int status = 0;
		int sort_order = 0;
		
		boolean result = false;
		try {		
			id=Integer.parseInt(request.getParameter("id")) ;	
			parent_id = Integer.parseInt(request.getParameter("parent_id"));
			String name = request.getParameter("name");
			status = Integer.parseInt(request.getParameter("status"));
			sort_order = Integer.parseInt(request.getParameter("sort_order"));
			String create_time = request.getParameter("create_time");
			String update_time = request.getParameter("update_time");
			System.out.println(update_time+"22222");
			category.setId(id);
			category.setParent_id(parent_id);
			category.setName(name);
			category.setStatus(status);
			category.setSort_order(sort_order);
			category.setCreate_time(create_time);
			category.setUpdate_time(update_time);
			System.out.println(category.getUpdate_time()+"11111");
			result = cService.updateCategory(category);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		if (result) {
			System.out.println("商品修改成功");
			findCategoryByPage(request, response);
		} else {
			System.out.println("商品修改失败");

		}
	}

	/**
	 * 根据id删除类别   5
	 */
	public void deleteCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = 0;
		boolean result = false;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			result = deleteProduct(id);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		if (result) {
			System.out.println("商品删除成功");
			findCategoryByPage(request, response);
		} else {
			System.out.println("商品删除失败");
		}
	}

	public boolean deleteProduct(int id) {
		return cService.deleteCategory(id);
	}
	
	
	/**
	 * 分页查询    6
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void findCategoryByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    String pageNo=request.getParameter("pageNo");
	 		if(pageNo==null) {
	 			pageNo="1";	
	 		}
	 		CategoryService categoryservice=new CategoryServiceImpl();
	 		System.out.println();
	 		PageModel<Category> pageModel=categoryservice.findEmByPage(Integer.parseInt(pageNo),3);
	 		request.setAttribute("pageModel", pageModel);
	 		request.getRequestDispatcher("showCategoryByPage.jsp").forward(request, response);
	}
}
