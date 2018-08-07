package com.neuedu.mybatis;

import com.neuedu.Utiles.FactorySession;
import com.neuedu.dao.CartDao;
import com.neuedu.dao.ProductDao;
import com.neuedu.entity.Cart;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MybatisCartDaoImpl implements CartDao {

    @Autowired
    SqlSession session;

    @Autowired
    ProductDao pd;
    @Override
    public List<Cart> findAllCart() {

        List<Cart> listCart=session.selectList("Cart.findCartAll");
        System.out.println("Product的查询所有的语句返回的结果长度是："+listCart.size());

        return listCart;
    }

    @Override
    public Cart findCartById(int id) {

        Cart cart=session.selectOne("Cart.findCartById",id);
        System.out.println("Cart的查询单个的语句返回的结果是："+cart);

        return cart;
    }

    @Override
    public boolean findCartByProductId(int productId) {

        List<Cart> list=session.selectList("Cart.findCartByproductId",productId);
        if (list.size()==0){
            return false;
        }
        System.out.println("Cart的查询单个的语句返回的结果是："+list);

        return true;
    }

    @Override
    public PageModel<Cart> findEmpByPage(int pageNo, int pageSize) {


        List<Cart> listCart =session.selectList("Cart.findCartAll");
        System.out.println(listCart.size());
        int totalPage=listCart.size()%pageSize==0?listCart.size()/pageSize:listCart.size()/pageSize+1;
        int dijihang=(pageNo - 1) * pageSize;
        Map<String,Integer> map=new HashMap<String,Integer>();
        map.put("dijihang",dijihang);
        map.put("pageSize",pageSize);
        List<Cart> listCartLimit=session.selectList("Cart.findCartLimit",map);

        PageModel<Cart> PModel=new PageModel(listCartLimit,totalPage,pageNo);
        System.out.println("Cart："+PModel);


        return PModel;

    }

    @Override
    public boolean addCart(Cart cart) {


        Product product=  pd.findById(cart.getProductid());
        if(product==null){
            return false;
        }
        int result=session.insert("Cart.addCart",cart);
        System.out.println("Cart的添加语句返回的结果是："+result);
        return true;
    }



    @Override
    public boolean deleteCart(int id) {

        int result=session.delete("Cart.deleteCartById",id);
        System.out.println("Cart的删除语句返回的结果是："+result);

        return true;
    }

    @Override
    public boolean updataeCart(Cart cart) {

        int result=session.update("Cart.updateCartById",cart);
        System.out.println("Cart的修改语句返回的结果是："+result);

        return true;
    }

    @Override
    public int getCartNum() {
        return 0;
    }

    @Override
    public boolean updateCart(int id, int num) {
        return false;
    }

    @Override
    public void clearCart() {

    }


}
