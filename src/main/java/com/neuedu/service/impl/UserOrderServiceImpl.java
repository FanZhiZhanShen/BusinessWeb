package com.neuedu.service.impl;

import com.neuedu.dao.UserOrderDao;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.UserOrder;
import com.neuedu.mybatis.MybatisUserOrderDaoImpl;
import com.neuedu.service.UserOrderService;

import java.util.List;

public class UserOrderServiceImpl implements UserOrderService{
    UserOrderDao userOrders=new MybatisUserOrderDaoImpl();

    @Override
    public List<UserOrder> findAll() {
        return userOrders.findAll();
    }

    @Override
    public PageModel<UserOrder> findEmByPage(Integer pageNo, Integer pageSize) {
        return userOrders.findEmpByPage(pageNo,pageSize);
    }

    @Override
    public boolean addUserOrder(UserOrder userOrder) {

        return userOrders.addUserOrder(userOrder);
    }

    @Override
    public boolean deleteUserOrder(int id) {
        return userOrders.deleteUserOrder(id);
    }

    @Override
    public boolean emptUserOrder() {
        return userOrders.emptUserOrder();
    }
}
