package com.neuedu.test;

import com.neuedu.dao.ILoginDao;
import com.neuedu.entity.Account;
import com.neuedu.mybatis.MybatisLoginDaoImpl;
import com.neuedu.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class QUsertest {
    ApplicationContext applicationContext=null;
    AccountService accountService=null;
  ILoginDao iLoginDao=null;
    @Before
    public void before(){
        applicationContext= new ClassPathXmlApplicationContext("spring-config.xml");
        accountService=applicationContext.getBean(AccountService.class);
        iLoginDao=applicationContext.getBean(ILoginDao.class);
    }

    @Test
    public void testLogin(){
        System.out.println("1");
        System.out.println(accountService);

        Account A= iLoginDao.doLogin("admin","21232f297a57a5a743894a0e4a801fc3");

    }

    @Test
    public void update(){
        System.out.println(accountService);
        accountService.transfer(12,17,200);
        System.out.println("ÐÞ¸Ä³É¹¦");
    }
}
