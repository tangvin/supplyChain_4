package cn.com.edzleft.service.trade.order;

import cn.com.edzleft.entity.Order;
import cn.com.edzleft.util.page.PageUtil;

import java.util.List;

/**
 * Created by ibmtech on 2017/11/28.
 */
public interface TradeOrderService {

    /**
     * 分页查询，展示所有
     */
    public PageUtil<Order> queryAllOrder(PageUtil<Order> pageUtil);


    /**
     * 根据合同id查询订单详情
     */
    public Order queryOrderById(Integer id);

    /**
     * 设置订单状态
     * @param order
     */
    public void setOrderStatus(Integer id,Integer flag,Order order);

    /**
     * 0.待确认状态
     */
    public void setOrderStatus0(Integer id);

    /**
     * 1.待付款状态
     */
    public void setOrderStatus1(Integer id);

    /**
     * 2.待发货状态
     */
    public void setOrderStatus2(Integer id);

    /**
     *3.待收货状态
     * @param id
     */
    public void setOrderStatus3(Integer id);

    /**
     * 4.已完成状态
     * @param id
     */
    public void setOrderStatus4(Integer id);

    /**
     * 5.已关闭状态
     * @param id
     */
    public void setOrderStatus5(Integer id);

    /**
     * 6.已驳回状态
     * @param id
     */
    public void setOrderStatus6(Integer id);

    /**
     * 7.历史状态
     * @param id
     */
    public void setOrderStatus7(Integer id);




}
