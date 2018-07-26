package com.neuedu.service.impl;



import com.neuedu.dao.ILoginDao;
import com.neuedu.dao.impl.jdbc.LoginDaoImpl;
import com.neuedu.entity.Account;
import com.neuedu.service.ILoginService;


public class LoginServiceImpl implements ILoginService{

	ILoginDao loginDao=new LoginDaoImpl();
	
	public Account  doLogin(String  username,String password) {
		//���е�¼��ҵ���߼�����
		 //LoginDao loginDao=new LoginDao(); 
		//LoginDaoMysql loginDao=new LoginDaoMysql();
		
		return loginDao.doLogin(username,password);
		
		
	}

	@Override
	public void addToken(String token,Account acc) {
		
		loginDao.addToken(token, acc);
		
		
		
	}

	@Override
	public String findTokenByAcctountid(int acctountid) {
		// TODO Auto-generated method stub
		return loginDao.findTokenByAcctountid(acctountid);
	}

	@Override
	public boolean addAccount(Account account) {
		// TODO Auto-generated method stub
		return loginDao.addAccount(account);
	}

	
	
}
