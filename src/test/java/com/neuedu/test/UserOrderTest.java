package com.neuedu.test;

import com.neuedu.dao.UserOrderDao;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.UserOrder;
import com.neuedu.mybatis.MybatisUserOrderDaoImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserOrderTest {
    UserOrderDao userOrder=new MybatisUserOrderDaoImpl();

    @Test
    public void findUserOrderAll(){
        List<UserOrder> list=userOrder.findAll();
        System.out.println("test查询单个类别成功："+list);
    }


    @Test
    public void findUserOrderByPage(){
        PageModel<UserOrder> PModel=userOrder.findEmpByPage(1,3);
        List<UserOrder> LO=new ArrayList<>();
        LO=PModel.getData();
        System.out.println("test分页查询成功："+LO.size());
    }

    @Test
    public void addUserOrder(){
        UserOrder userO=new UserOrder(10,2,54,45,4,45,4);
        boolean result=userOrder.addUserOrder(userO);
        System.out.println(result);
    }

    @Test
    public void emptUserOrder() {
        boolean result=userOrder.emptUserOrder();
        System.out.println(result);
    }
}
