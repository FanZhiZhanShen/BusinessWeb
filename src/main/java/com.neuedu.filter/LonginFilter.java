package com.neuedu.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


import com.neuedu.entity.Account;
import com.neuedu.service.ILoginService;
import com.neuedu.service.impl.LoginServiceImpl;

/**
 * Servlet Filter implementation class LonginFilter
 */
@WebFilter("/log.jsp")
public class LonginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LonginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("ִ�е�LonginFilter");
		String username=null;
		String password=null;
		
		//��������л�ȡCookie���������
		HttpServletRequest _request=(HttpServletRequest)request;
		
		Cookie[] cookis=_request.getCookies();
		System.out.println(cookis!=null);
		if(cookis!=null) {
			for(Cookie c:cookis) {
				System.out.println(c.getName().equals("username")+"11111");
				if(c.getName().equals("username")) {
					username=c.getValue();
					System.out.println("username="+username+"    "+c.getMaxAge());
				}
				if(c.getName().equals("password")) {
					password=c.getValue();
					System.out.println("password="+password+"    "+c.getMaxAge());
				}
			}
		}
		
		if(username!=null&&!username.equals("")&&password!=null&&!password.equals("")) {
			ILoginService loginService=new LoginServiceImpl();
			Account acc= loginService.doLogin(username, password);
			if(acc!=null) {
				System.out.println("ִ�е�view/home.jsp");
				request.getRequestDispatcher("kuangjia.jsp").forward(request, response);
				return;//��������
			}else {
				//��½ʧ��
				
				chain.doFilter(request, response);//ͨ���ù�����
			}
		}else {
			//��½ʧ��
			chain.doFilter(request, response);//ͨ���ù�����
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
