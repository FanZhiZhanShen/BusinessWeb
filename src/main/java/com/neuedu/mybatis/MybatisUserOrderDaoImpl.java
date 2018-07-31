package com.neuedu.mybatis;

import com.neuedu.Utiles.FactorySession;
import com.neuedu.dao.UserOrderDao;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.UserOrder;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisUserOrderDaoImpl implements UserOrderDao {

    @Override
    public List<UserOrder> findAll() {
        SqlSession session= FactorySession.FSession();
        List<UserOrder> listUserOrder =session.selectList("UserOrder.findUserOrderAll");
        System.out.println("UserOrder成功返回："+listUserOrder.size());
        FactorySession.close(session);
        return listUserOrder;
    }

    @Override
    public PageModel<UserOrder> findEmpByPage(int pageNo, int pageSize) {
        SqlSession session= FactorySession.FSession();
        List<UserOrder> listProduct =session.selectList("UserOrder.findUserOrderAll");
        int totalPage=listProduct.size()%pageSize==0?listProduct.size()/pageSize:listProduct.size()/pageSize+1;
        Map<String,Integer> map=new HashMap<String,Integer>();
        map.put("pageNo",(pageNo - 1) * pageSize);
        map.put("pageSize",pageSize);
        List<UserOrder> listUserOrderLimit=session.selectList("UserOrder.findUserOrderLimit",map);

        PageModel<UserOrder> PModel=new PageModel(listUserOrderLimit,totalPage,pageNo);
        System.out.println("UserOrder的分页查询返回的结果是："+PModel);
        FactorySession.close(session);
        return PModel;
    }

    @Override
    public boolean addUserOrder(UserOrder userOrder) {
        SqlSession session= FactorySession.FSession();
        int result =session.insert("UserOrder.addUserOrder",userOrder);
        System.out.println("addUserOrder成功返回insert（）："+result);
        FactorySession.close(session);
        return true;
    }

    @Override
    public boolean deleteUserOrder(int id) {
        SqlSession session= FactorySession.FSession();
        int result=session.delete("UserOrder.deleteOrderById",id);
        System.out.println("Product的删除语句返回的结果是："+result);
        FactorySession.close(session);
        return true;
    }

    @Override
    public boolean emptUserOrder() {
        SqlSession session= FactorySession.FSession();
        int result=session.delete("UserOrder.emptOrderBy");
        System.out.println("Product的删除语句返回的结果是："+result);
        FactorySession.close(session);
        return true;
    }

}
