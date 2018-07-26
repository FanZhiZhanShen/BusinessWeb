package com.neuedu.service;

import com.neuedu.entity.Account;

public interface ILoginService {
	
    //��½����
	public Account  doLogin(String username, String password);
	
	//���token
	public void addToken(String token, Account acc);
	
	public String findTokenByAcctountid(int acctountid);
	
	//ע��
	public boolean addAccount(Account account);
}
