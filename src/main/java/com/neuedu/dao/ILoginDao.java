package com.neuedu.dao;

import com.neuedu.entity.Account;

//�ӿڸ���ԭ��
public interface ILoginDao {

	//��¼��
	public  Account   doLogin(String _username, String _password);
	//���token	
	public void addToken(String token, Account acc);
	//��ѯtoken
	public String findTokenByAcctountid(int acctountid);
	
	//ע��
	public boolean addAccount(Account account);

	public void updataAccount(int accountid,double money);
}
