package com.neuedu.service;

import com.neuedu.entity.PageModel;
import com.neuedu.entity.UserOrder;

import java.util.List;

public interface UserOrderService {

    public List<UserOrder> findAll();

    public PageModel<UserOrder> findEmByPage(Integer pageNo, Integer pageSize);

    boolean  addUserOrder(UserOrder userOrder);

    boolean  deleteUserOrder(int id);

    /***
     * 清空所有已购买的商品
     *
     * */
    boolean  emptUserOrder();
}
