package cn.com.edzleft.dao.trade.order;

import cn.com.edzleft.entity.Order;
import cn.com.edzleft.util.page.PageUtil;

import java.util.List;

/**
 * Created by ibmtech on 2017/11/24.
 */
public interface OrderMapper {

    /**
     * 查询出订单总条数
     * @param pageUtil
     * @return
     */
    public Integer selectTotalOrderCount(PageUtil<Order> pageUtil);

    /**
     * 条件查询+分页
     * @param pageUtil
     * @return
     */
    public List<Order> selectOrderByPage(PageUtil<Order> pageUtil);


    /**
     * 根据id查询出订单详细信息
     * @param id
     * @return
     */
    public Order selectOrderById(Integer id);

    /**
     * 设置订单状态
     */
    public void updateStatus(Order order);

    /**
     * 添加订单
     */
    public void insertOrder(Order order);



}
