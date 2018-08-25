package com.neuedu.mybatis;


import com.neuedu.dao.LogAspectjDao;
import com.neuedu.entity.LogAspectJ;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisLogAspectjDaoImpl implements LogAspectjDao{



    @Autowired
    SqlSession sqlSession;


    @Override
    public boolean add(LogAspectJ logAspectJ) {
        LogAspectjDao logAspectjDao=sqlSession.getMapper(LogAspectjDao.class);
        logAspectjDao.add(logAspectJ);
        return true;
    }
}
