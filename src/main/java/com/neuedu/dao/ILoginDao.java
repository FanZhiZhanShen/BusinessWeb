package com.neuedu.dao;

import com.neuedu.entity.Account;

//接口隔离原则
public interface ILoginDao {

	//登录：
	public  Account   doLogin(String _username, String _password);
	//添加token	
	public void addToken(String token, Account acc);
	//查询token
	public String findTokenByAcctountid(int acctountid);
	
	//注册
	public boolean addAccount(Account account);

	public void updataAccount(int accountid,double money);
}
