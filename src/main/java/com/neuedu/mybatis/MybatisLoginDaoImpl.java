package com.neuedu.mybatis;

import com.neuedu.Utiles.FactorySession;
import com.neuedu.dao.ILoginDao;
import com.neuedu.entity.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class MybatisLoginDaoImpl implements ILoginDao{
    @Override
    public Account doLogin(String _username, String _password) {

        SqlSession session= FactorySession.FSession();

        Map<String,String> map =new HashMap<String, String>();
        map.put("username",_username);
        map.put("password",_password);
        Account accoun = session.selectOne("com.neuedu.entity.Account.findByUserAndPassword",map);
        /**selectOne():��������������Ϊ��ѯ����
         * ��һ������Ϊ��com.neuedu.entity.Account.findByUserAndPassword
         * �ڶ�������Ϊ����һ���������õķ������βεľ���ֵ
         * */
        System.out.println(accoun);
        FactorySession.close(session);
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
}
