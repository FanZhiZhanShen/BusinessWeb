package com.neuedu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.entity.Account;

import com.neuedu.service.ILoginService;
import com.neuedu.service.impl.LoginServiceImpl;
import com.neuedu.utils.MD5Utils;


/**
 * ��������û��û���������
 * */
@WebServlet("/login.do")
public class LoginController extends HttpServlet {

	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ILoginService  loginService=new LoginServiceImpl();
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String operation=request.getParameter("operation");
		if(operation.equals("1")) {
			doLogin(request, response);
		}else if(operation.equals("2")) {
			addAccount(request, response);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
	}
	
	//��½������ͨ��username��password��ѯ�û��Ƿ����
	public  void   doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username= request.getParameter("username");
		String password= request.getParameter("password");
		System.out.println("111111111111"+username);
		Account acc= loginService.doLogin(username, MD5Utils.GetMD5Code(password) );
		System.out.println("111111111111"+acc);
		if(acc!=null) {
			//��½�ɹ�
			//����Ӧ�˴���coolie���������Ӧ��
			Cookie user_cookie=new Cookie("username",username);
			user_cookie.setMaxAge(-1);
			response.addCookie(user_cookie);//
			Cookie pwd_cookie=new Cookie("password",MD5Utils.GetMD5Code(password));
			pwd_cookie.setMaxAge(-1);
			response.addCookie(pwd_cookie);
			
			//����token���浽������
			
			long time=System.currentTimeMillis();//��ȡʱ���
			String token=MD5Utils.GetMD5Code(username+password+time);
			loginService.addToken(token,acc);
			
			//�ŵ��ػ�����
			HttpSession session= request.getSession();//�����Ự
			session.setAttribute("token", token);
			session.setAttribute("acc", acc);
			session.setMaxInactiveInterval(7*24*60*60);
			request.getRequestDispatcher("kuangjia.jsp").forward(request, response);

		}else {
			//��½ʧ��
			request.getRequestDispatcher("view/fail.jsp").forward(request, response);
		}
	}
	
	
	//ע���û�
	public  void addAccount(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		Account account=new Account();
    	String username=request.getParameter("username");
    	String password=request.getParameter("password");
    	String ip=request.getParameter("ip");
    	String sex=request.getParameter("sex");	
    	boolean result=false;
    	try {   		
    		account.setUsername(username);
    		account.setPassword(MD5Utils.GetMD5Code(password));
    		account.setIp(ip);
    		account.setSex(sex);       	
        	result=loginService.addAccount(account);
    	}catch(NumberFormatException e) {
    		e.printStackTrace();	
    	}
		if(result) {
			System.out.println("ע��ɹ�");
			request.getRequestDispatcher("log.jsp").forward(request, response);
		}else {
			System.out.println("ע��ʧ��");
		}
    }
	
}
