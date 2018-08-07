package com.neuedu.service.impl;



import com.neuedu.dao.ILoginDao;
import com.neuedu.dao.impl.jdbc.LoginDaoImpl;
import com.neuedu.entity.Account;
import com.neuedu.mybatis.MybatisLoginDaoImpl;
import com.neuedu.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements ILoginService{

	@Resource(name = "mybatisLoginDaoImpl")
	ILoginDao loginDao;
	
	public Account  doLogin(String  username,String password) {
		//进行登录的业务逻辑处理
		 //LoginDao loginDao=new LoginDao(); 
		//LoginDaoMysql loginDao=new LoginDaoMysql();
		System.out.println("----"+loginDao);
		return loginDao.doLogin(username,password);
	}

	@Override
	public void addToken(String token,Account acc) {
		
		loginDao.addToken(token, acc);
		
		
		
	}

	@Override
	public String findTokenByAcctountid(int acctountid) {
		ApplicationContext applicationContext= new ClassPathXmlApplicationContext("spring-config.xml");
		loginDao=(MybatisLoginDaoImpl)applicationContext.getBean("mybatisLoginDaoImpl");
		return loginDao.findTokenByAcctountid(acctountid);
	}

	@Override
	public boolean addAccount(Account account) {
		// TODO Auto-generated method stub
		return loginDao.addAccount(account);
	}

	
	
}
