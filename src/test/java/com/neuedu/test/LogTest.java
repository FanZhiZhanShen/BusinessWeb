package com.neuedu.test;

import com.neuedu.dao.LogAspectjDao;
import com.neuedu.entity.LogAspectJ;
import com.neuedu.mybatis.MybatisLogAspectjDaoImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;


public class LogTest {


    LogAspectjDao logAspectjDao;
    @Before
    public void start(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        logAspectjDao=(MybatisLogAspectjDaoImpl)applicationContext.getBean("mybatisLogAspectjDaoImpl");
    }

    @Test
    public void add(){
        LogAspectJ logAspectJ=new LogAspectJ(5, new Date(),"asdas");
        logAspectjDao.add(logAspectJ);
    }
}
