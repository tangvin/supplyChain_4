package cn.com.edzleft.service.trade.order;

import cn.com.edzleft.dao.trade.order.OrderMapper;
import cn.com.edzleft.entity.Order;
import cn.com.edzleft.entity.SessionInfo;
import cn.com.edzleft.util.page.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        Integer orderCount = orderMapper.selectTotalOrderCount(pageUtil);
        //条件查询+分页显示
        List<Order> orders = orderMapper.selectOrderByPage(pageUtil);
        pageUtil.setTotalCount(orderCount);
        pageUtil.setList(orders);
        return pageUtil;
    }

    /**
     * 根据id查询订单详细信息
     * @param id
     * @return
     */
    @Override
    public Order queryOrderById(Integer id) {
        Order order = orderMapper.selectOrderById(id);
        return order;
    }

    /**
     * 设置订单状态
     * @param id
     */
    @Override
    public boolean setOrderStatus(Integer id,Integer flag,Order orders) {
        //根据id查询当前的订单
        Order order = orderMapper.selectOrderById(id);
        Integer orderStatus = order.getOrderStatus();
        if(flag==1) {   //待确认--领取订单
               //领取订单（0---1）
               order.setOrderStatus(1);
               order.setOrderId(id);
               order.setOrderConfirmationTime(new Date());
               SessionInfo sessionInfo = new SessionInfo();
          //     String userName = sessionInfo.getAdmin().getUserName();
          //     order.setOrderCreatorTrade(userName);
           } else if (flag == 2) { //待确认--驳回
               //驳回（0--6）
                order.setOrderId(id);
               order.setOrderStatus(6);
               //order.setOrderState("信息不完整");
            }else if(flag==4){  //待付款 2 --3配置发货
                order.setOrderId(id);
                order.setOrderStatus(3);
            }
            orderMapper.updateStatus(order);
            return true;
        }

    /**
     * 0.待确认状态
     * @param id
     */
    @Override
    public void setOrderStatus0(Integer id) {
        Order order = orderMapper.selectOrderById(id);
        Integer orderStatus = order.getOrderStatus();
       //当前状态为0时
        if(orderStatus==0){
           //设置2种状态
            if(orderStatus==1){

            }
        }
    }

    /**
     * 1.待付款状态
     * @param id
     */
    @Override
    public void setOrderStatus1(Integer id) {

    }

    /**
     *2.待发货状态
     * @param id
     */
    @Override
    public void setOrderStatus2(Integer id) {

    }

    /**
     *3.待收货状态
     * @param id
     */
    @Override
    public void setOrderStatus3(Integer id) {

    }

    /**
     * 4.已完成状态
     * @param id
     */
    @Override
    public void setOrderStatus4(Integer id) {

    }

    /**
     * 5.已关闭状态
     * @param id
     */
    @Override
    public void setOrderStatus5(Integer id) {

    }

    /**
     * 6.已驳回状态
     * @param id
     */
    @Override
    public void setOrderStatus6(Integer id) {

    }

    /**
     * 7.历史状态
     * @param id
     */
    @Override
    public void setOrderStatus7(Integer id) {

    }

}
