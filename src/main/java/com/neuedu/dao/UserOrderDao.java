package com.neuedu.dao;


import com.neuedu.entity.PageModel;
import com.neuedu.entity.UserOrder;

import java.util.List;

public interface UserOrderDao {

    List<UserOrder> findAll();
    public PageModel<UserOrder> findEmpByPage(int pageNo, int pageSize);

    boolean  addUserOrder(UserOrder userOrder);

    boolean  deleteUserOrder(int id);

    /***
     * 清空所有已购买的商品
     *
     * */
    boolean  emptUserOrder();
}
