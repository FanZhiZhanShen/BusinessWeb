package com.neuedu.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.entity.Account;
import com.neuedu.service.ILoginService;
import com.neuedu.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * Servlet Filter implementation class CheckLoginFilter
 */
@WebFilter("/111view/*")
public class CheckLoginFilter implements Filter {
	@Autowired
	ILoginService loginService;
    /**
     * Default constructor. 
     */
    public CheckLoginFilter() {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }


	public void init(FilterConfig fConfig) throws ServletException {

	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest _request=(HttpServletRequest)request;
		HttpServletResponse _response=(HttpServletResponse)response;
		
		HttpSession session=_request.getSession();//获取回话
		Object object= session.getAttribute("token");
		Object accobject= session.getAttribute("acc");
		if(object!=null&&accobject!=null) {
			String token=(String)object;
			Account acc=(Account)accobject;
			ILoginService loginService=new LoginServiceImpl();
			String result_token= loginService.findTokenByAcctountid(acc.getAccountId());
		    if(result_token!=null) {
		    	if(token.equals(result_token)) {
		    		//有效的token
					request.getRequestDispatcher("kuangjia.jsp").forward(request, response);
					return;
		    	}
		    }
		}
		
		//重定向
		_response.sendRedirect("http://localhost:8080/BusinessWeb/log.jsp");
	}



}
