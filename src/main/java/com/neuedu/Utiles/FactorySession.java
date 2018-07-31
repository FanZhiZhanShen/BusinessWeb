package com.neuedu.Utiles;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public  class FactorySession {
    static final String  resource = "mybatis-config.xml";
    static  public  SqlSession FSession(){

        Reader reader= null;
        SqlSession session = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            //将放着连接数据库的jdbc配置文件用流（Resources）读出来

            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
            //利用读出来的流作为实参  生成一个SqlSessionFactory 对象

            session = sqlMapper.openSession(true);
           /***
            * -使用SqlSessionFactory对象获取  SqlSession的对象
            * -SqlSession的对象 可以操做   实体类映射文件的方法
            *SqlSessionFactory对象.openSession()可以有实参：   true：表提交数据库的dml语句
            *                                               false：默认值：表不提交数据库dml语句
            * -默认不提交数据库dml语句，所以需要调用session一个函数来提交dml语句session.commit()
            *
            */
            return session;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    static public void close( SqlSession session){
        session.close();
    }


}



