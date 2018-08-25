package com.neuedu.service.impl;

import com.neuedu.dao.ILoginDao;
import com.neuedu.service.AccountService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class AccountServiceImpl implements AccountService{

        @Resource(name = "mybatisLoginDaoImpl")
        ILoginDao loginDao;
        @Transactional
        @Override
        public void transfer(int fromusername, int tousername, double money) {
            loginDao.updataAccount(fromusername,300-money);
//            int y=1/0;
            loginDao.updataAccount(tousername,400+money);
        }
}
