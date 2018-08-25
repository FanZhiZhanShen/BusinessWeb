package com.neuedu.mybatis;

import com.neuedu.Utiles.FactorySession;
import com.neuedu.dao.ILoginDao;
import com.neuedu.entity.Account;
import com.neuedu.service.ILoginService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

@Repository
public class MybatisLoginDaoImpl implements ILoginDao{

    @Autowired
    SqlSession session;



    @Override
    public Account doLogin(String _username, String _password) {

//        Map<String,String> map =new HashMap<String, String>();
//        map.put("username",_username);
//        map.put("password",_password);
        ILoginDao loginService=session.getMapper(ILoginDao.class);
        Account accoun=loginService.doLogin(_username,_password);
//        Account accoun = session.selectOne("com.neuedu.service.ILoginService.doLogin",map);
        System.out.println(accoun);
        /**selectOne():��������������Ϊ��ѯ����
         * ��һ������Ϊ��com.neuedu.entity.Account.findByUserAndPassword
         * �ڶ�������Ϊ����һ���������õķ������βεľ���ֵ
         * */
        System.out.println(accoun);

        return accoun;
    }

    @Override
    public void addToken(String token, Account acc) {

    }

    @Override
    public String findTokenByAcctountid(int acctountid) {
        return null;
    }

    @Override
    public boolean addAccount(Account account) {
        return false;
    }

    @Override
    public void updataAccount(int accountid,double money) {
        Map<Object,Object> map=new HashMap<Object,Object>();
        map.put("accountid",accountid);
        map.put("money", money);
        session.update("com.neuedu.entity.Account.update",map);
    }
}
