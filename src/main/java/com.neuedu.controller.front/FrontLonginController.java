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

			//gson.jar----google����
			//jackson.jar---����ͰͿ�������Java����֮��תΪ�ַ���
			Gson gson=new Gson();
			String json=gson.toJson(acc);//��java����תΪjson�ַ���
			
			
//			gson.fromJson(json, ����1.class);//��json�ַ���תΪ ��1�Ķ���
//			                                  json��ʾ����һ��json��ʽ���ַ���
//			                                                                                                      �ú����ķ���ֵ������1�Ķ���
			
            PrintWriter write=response.getWriter();//��ȡ��ӡ��
			
			//����js��success����
			write.println(method+"("+json+")");//���ַ�����ӡ��ȥ

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
