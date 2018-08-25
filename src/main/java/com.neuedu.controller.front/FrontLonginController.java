package com.neuedu.controller.front;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.neuedu.entity.Account;
import com.neuedu.service.ILoginService;
import com.neuedu.service.impl.LoginServiceImpl;
import com.neuedu.utils.MD5Utils;

/**
 * Servlet implementation class FrontLonginController
 */
@WebServlet("/FrontLonginController")
public class FrontLonginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ILoginService loginService = new LoginServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontLonginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username= request.getParameter("username");
		String password= request.getParameter("password");
		String method=request.getParameter("method");
		Account acc= loginService.doLogin(username, MD5Utils.GetMD5Code(password) );
		if(acc!=null) {

			//gson.jar----google开发
			//jackson.jar---阿里巴巴开发：将Java对象之间转为字符串
			Gson gson=new Gson();
			String json=gson.toJson(acc);//将java对象转为json字符串
			
			
//			gson.fromJson(json, 类名1.class);//将json字符穿转为 类1的对象
//			                                  json表示的是一个json格式的字符串
//			                                                                                                      该函数的返回值就是类1的对象
			
            PrintWriter write=response.getWriter();//获取打印流
			
			//调用js的success方法
			write.println(method+"("+json+")");//将字符串打印出去

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

}
