package com.neuedu.test;

import com.neuedu.dao.ILoginDao;
import com.neuedu.mybatis.MybatisLoginDaoImpl;
import org.junit.Test;

public class Usertest {

    @Test
    public void testLogin(){
        ILoginDao iLoginDao=new MybatisLoginDaoImpl();
        System.out.println("1");
        iLoginDao.doLogin("admin","21232f297a57a5a743894a0e4a801fc3");
    }

}
