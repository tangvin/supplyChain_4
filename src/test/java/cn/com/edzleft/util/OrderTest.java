package cn.com.edzleft.util;

import cn.com.edzleft.dao.trade.order.OrderMapper;
import cn.com.edzleft.entity.Order;
import cn.com.edzleft.util.page.PageUtil;
import org.junit.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by ibmtech on 2017/11/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:config/applicationContext.xml")
public class OrderTest {

    @Autowired
    private OrderMapper orderMapper;


    @Test
    public void orderSelect(){
        Order order = orderMapper.selectOrderById(2);
        System.out.println(order);
        System.out.println("修改成功");
    }

    /**
     * PageUtil<Contract> util = new PageUtil<>();
     Integer totalCount = contractSigningMapper.selectTotalCount(util);
     System.out.println(totalCount);

     util.setStart(1);
     util.setPageSize(3);
     util.setTotalCount(totalCount);
     List<Contract> list = contractSigningMapper.selectContractByPage(util);
     util.setList(list);
     for (Contract contract : list) {
     System.out.println(contract);
     }
     */
    @Test
    public void orderSelectAll(){
        PageUtil<Order> util = new PageUtil<Order>();
        Integer totalCount = orderMapper.selectTotalOrderCount(util);
        System.out.println(totalCount);
        util.setStart(2);
        util.setPageSize(4);
        util.setTotalCount(totalCount);
        List<Order> list = orderMapper.selectOrderByPage(util);
        util.setList(list);
        for (Order order : list) {
            System.out.println(order);
        }
    }

    /**
     * 测试添加发货信息
     */
    @Test
    public void testFreight(){
        Order order = new Order();
        order.setOrderId(7);
        order.setFreightUnit("班的");
        order.setFreightNumberId(10101001);
        orderMapper.updateStatus(order);
        System.out.println("添加成");
    }

    /**
     * 根据id 查询订单详细信息
     */
    @Test
    public void selectOne(){
        Order order = orderMapper.selectOrderById(1);
        System.out.println(order);
    }

}
