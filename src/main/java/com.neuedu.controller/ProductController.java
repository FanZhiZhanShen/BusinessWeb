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
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.service.ProductService;
import com.neuedu.service.impl.ProductServiceImpl;

@WebServlet("/view/productView/product")
public class ProductController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ProductService  pService=new ProductServiceImpl();
			
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String operation=request.getParameter("operation");//operation�ж��Ƿ�ִ����ɾ��
		if(operation!=null&&!operation.equals("")) {
			if(operation.equals("1")) {
				addProduct(request,response);
			}else if(operation.equals("2")) {
				findAll(request,response);
			}else if(operation.equals("3")) {
				updateProduct(request, response);
			}else if(operation.equals("4")) {
				findProductById(request, response);
			}else if(operation.equals("5")) {
				deleteProduct(request, response);
			}else if(operation.equals("6")) {
				findEmpByPage(request, response);
			}
		}else {
			
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
	}
	
	/**�����Ʒ
	 * @throws IOException 
	 * @throws ServletException */
	public  void addProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    	Product product=new Product();
    	String name=request.getParameter("pname");
    	String desc=request.getParameter("pdesc");
    	String image=request.getParameter("pimage");
    	String rule=request.getParameter("prule");
    	double price=0.0;
    	int stock=0;
    	boolean result=false;
    	try {
    		price=Double.parseDouble(request.getParameter("price"));
    		stock=Integer.parseInt(request.getParameter("pstock")); 
        	product.setName(name);
        	product.setDesc(desc);
        	product.setPrice(price);
        	product.setImage(image);
        	product.setRule(rule);
        	product.setStock(stock);
        	result=addProduct(product);
    	}catch(NumberFormatException e) {
    		e.printStackTrace();	
    	}
		if(result) {
			System.out.println("��Ʒ��ӳɹ�");
			findEmpByPage(request, response);
		}else {
			System.out.println("��Ʒ���ʧ��");
		}
    }
	public  boolean addProduct(Product product) {
    	return pService.addProduct(product);
    }	
    /**��ѯ������Ʒ
     * @throws IOException 
     * @throws ServletException */
    public  void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{	
    	List<Product> products= pService.findAll();
    	request.setAttribute("product", products);
    	request.getRequestDispatcher("showprocute.jsp").forward(request, response);
    }
    
    /**����id��ѯ��Ʒ  4
     * @throws IOException 
     * @throws ServletException */
    public void findProductById(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    	int id=0;
    	try {
    		id=Integer.parseInt(request.getParameter("id")) ; 
    		Product products=findProductById(id);
    		System.out.println(products.getName());
        	request.setAttribute("produc", products);
        	request.getRequestDispatcher("update.jsp").forward(request, response);
    	}catch(NumberFormatException e) {
    		e.printStackTrace();
    	}
    }
    public Product findProductById(int id) {
    	return pService.findProductById(id);	
    }
    
    /**�޸���Ʒ  3
     * @throws IOException 
     * @throws ServletException */
    public  void  updateProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    	int id=0;
    	try {
    		id=Integer.parseInt(request.getParameter("id")) ; 
    		Product products=findProductById(id);
        	String name=request.getParameter("pname");
        	String desc=request.getParameter("pdesc");
        	String image=request.getParameter("pimage");
        	String rule=request.getParameter("prule");
        	double price=0.0;
        	int stock=0;
        	boolean result=false;
        	try {
        		price=Double.parseDouble(request.getParameter("price"));
        		stock=Integer.parseInt(request.getParameter("pstock")); 
            	products.setName(name);
            	products.setDesc(desc);
            	products.setPrice(price);
            	products.setImage(image);
            	products.setRule(rule);
            	products.setStock(stock);
            	result=pService.updateProduct(products);
        	}catch(NumberFormatException e) {
        		e.printStackTrace();	
        	}
    		if(result) {
    			System.out.println("��Ʒ�޸ĳɹ�");
    			findEmpByPage(request, response);

    		}else {
    			System.out.println("��Ʒ�޸�ʧ��");
    			
    		}
    		
    	}catch(NumberFormatException e) {
    		e.printStackTrace();
    	}
    	
    }
//    public  boolean  updateProduct(Product product) {//�����ݿ��в�������
//    	return pService.updateProduct(product);
//    }
    /**ɾ����Ʒ
     * @throws IOException 
     * @throws ServletException */
    public  void deleteProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    	int id=0;
    	boolean result=false;
    	try {
    		id=Integer.parseInt(request.getParameter("id")) ; 
    		result=deleteProduct(id);
    	}catch(NumberFormatException e) {
    		e.printStackTrace();
    	}
    	if(result) {
			System.out.println("��Ʒɾ���ɹ�");
			findEmpByPage(request, response);
		}else {
			System.out.println("��Ʒɾ��ʧ��");
		}
    }
    public  boolean deleteProduct(int id) {
    	return pService.deleteProduct(id);
    }
    
    /**��ҳ��ʾ
     * @throws IOException 
     * @throws ServletException */
     public  void findEmpByPage(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
    	 String pageNo=request.getParameter("pageNo");
 		if(pageNo==null) {
 			pageNo="1";	
 		}
 		ProductService prductservice=new ProductServiceImpl();
 		System.out.println();
 		PageModel<Product> pageModel=prductservice.findEmByPage(Integer.parseInt(pageNo),3);
 		
 		request.setAttribute("pageModel", pageModel);
 		request.getRequestDispatcher("showprocutePages.jsp").forward(request, response);
 		
 		//תΪjson
 		String jsonPageModel=JSONArray.toJSONString(pageModel);
 		PrintWriter jsonWrite=response.getWriter();
 		jsonWrite.println(jsonPageModel);
 		System.out.println(jsonPageModel);
     }
	
}
