package cn.com.edzleft.service.trade.order;

import cn.com.edzleft.dao.trade.order.OrderMapper;
import cn.com.edzleft.entity.Order;
import cn.com.edzleft.entity.SessionInfo;
import cn.com.edzleft.util.page.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by ibmtech on 2017/11/28.
 */
@Service
@Transactional
public class TradeOrderServiceImpl  implements TradeOrderService{

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public PageUtil<Order> queryAllOrder(PageUtil<Order> pageUtil) {
       //查询所有的总条数
        Integer orderCount = orderMapper.selectAllOrderCountLast(pageUtil);
        //条件查询+分页显示
        List<Order> orders = orderMapper.selectAllOrderLast(pageUtil);
        pageUtil.setTotalCount(orderCount);
        pageUtil.setList(orders);
        return pageUtil;
    }

    /**
     * 根据id查询订单详细信息
     * @param orderNumber
     * @return
     */
    @Override
    public Order queryOrderByNumber(String orderNumber) {
        Order order = orderMapper.selectOrderByNumber(orderNumber);
        return order;
    }

    /**
     * 根据订单编号查询
     */
    public Order queryOrderById(Integer id){
        Order order = orderMapper.selectOrderById(id);
        return  order;
    }

    /**
     * 设置订单状态
     * @param id
     */
    @Override
    public Order setOrderStatus(Integer id, Integer flag, HttpSession session) {
        //根据id查询当前的订单
        Order order = orderMapper.selectOrderById(id);
        //将用户表中的information_id存到订单表
        SessionInfo s = (SessionInfo) session.getAttribute("sessionInfo");
        Integer informationId = s.getAdmin().getInformationId();
        order.setOrderCreatorTradeId(informationId);
        if(flag==1) {   //待确认--领取订单
           //领取订单（0---1）
           order.setOrderId(id);
           order.setOrderStatus(1);
           //将当前时间存到订单表(订单领取时间)
           order.setOrderConfirmationTime(new Date());
       } else if (flag == 2) { //待确认--驳回
           //驳回（0--6）
            order.setOrderId(id);
            order.setOrderStatus(6);
            //订单驳回时间
            order.setOrderConfirmationTime(new Date());
        }else if(flag==4){  //待付款 2 --3配置发货
            order.setOrderId(id);
            order.setOrderStatus(3);
            //订单配置发货时间
            order.setOrderConfirmationTime(new Date());
        }
        orderMapper.updateStatus(order);
        System.out.println("订单状态修改完毕");
        return order;
    }
    /**
     * 添加货运订单
     * @param order
     */
        public void updateOrder(Order order){

            orderMapper.updateStatus(order);
        }



}
