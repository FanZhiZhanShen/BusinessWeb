package com.neuedu.service;

import com.neuedu.entity.Account;

public interface ILoginService {
	
    //µÇÂ½º¯Êý
	public Account  doLogin(String username, String password);
	
	//Ìí¼Ótoken
	public void addToken(String token, Account acc);
	
	public String findTokenByAcctountid(int acctountid);
	
	//×¢²á
	public boolean addAccount(Account account);
}
