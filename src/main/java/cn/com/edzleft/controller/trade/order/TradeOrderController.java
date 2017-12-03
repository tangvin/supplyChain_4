package cn.com.edzleft.controller.trade.order;

import cn.com.edzleft.entity.Freight;
import cn.com.edzleft.entity.Order;
import cn.com.edzleft.service.trade.freight.FreightService;
import cn.com.edzleft.service.trade.order.TradeOrderService;
import cn.com.edzleft.util.ReturnJson;
import cn.com.edzleft.util.page.DataGridJson;
import cn.com.edzleft.util.page.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.HashMap;

/**
 * Created by ibmtech on 2017/11/28.
 */
@Controller
@RequestMapping("/tradeOrder")
@SessionAttributes(value={"order"})
public class TradeOrderController {

    @Autowired
    private TradeOrderService tradeOrderService;

    @Autowired
    private FreightService freightService;

    /**
     * 订单查询
     * @param pageNumber
     * @param pageSize
     * @param orderStatus
     * @param orderCreatTime
     * @param orderCreator
     * @param principalOrder
     * @return
     */
    @RequestMapping(value = "/orderSelect" ,method = RequestMethod.POST)
    @ResponseBody
    public DataGridJson queryByPage(Integer pageNumber,Integer pageSize ,String orderStatus,String orderCreatTime,String orderCreator,String principalOrder){
        PageUtil<Order> pageUtil = new PageUtil<Order>();
        HashMap<String,Object> whereMaps =new HashMap<>();
        whereMaps.put("orderStatus",orderStatus);
        whereMaps.put("orderCreatTime",orderCreatTime);
        whereMaps.put("orderCreator",orderCreator);
        whereMaps.put("principalOrder",principalOrder);

        DataGridJson dgj = new DataGridJson();
        pageUtil.setCpage(pageNumber);
        pageUtil.setPageSize(pageSize);
        pageUtil.setWhereMap(whereMaps);
        pageUtil=tradeOrderService.queryAllOrder(pageUtil);
        dgj.setTotal(pageUtil.getTotalCount());
        dgj.setRows(pageUtil.getList());
        return dgj;
    }

    /**
     * 根据id查询订单详情
     *
     */
    @RequestMapping("/getOrderById")
    public Order orderDetail(Integer id, ModelMap modelMap){
        Order order = tradeOrderService.queryOrderById(id);
        //利用@sessionAttribute注解将order存到session中
        modelMap.addAttribute("order", order);
        return order;
    }

    /**
     * （修改订单状态）
     */
    @RequestMapping(value = "/takeOrder",method = RequestMethod.POST)
    @ResponseBody
    public ReturnJson takeOrder(Integer id, Integer flag, Order order){
        ReturnJson rj = new ReturnJson();
        System.out.println("订单状态查询开始");
        System.out.println(id+"   "+flag);
        //根据页面返回的id查询出当前订单
        Order orderById = tradeOrderService.queryOrderById(id);
        //获取当前订单的状态
        Integer status = orderById.getOrderStatus();
        System.out.println(status);
        //调用业务层设置订单状态
        boolean a = tradeOrderService.setOrderStatus(id,flag,order);
        if(a){
            rj.setMsg("修改成功");
            rj.setSuccess(true);
        }
        return rj;
    }

    /**
     * 配置发货
     */
    @RequestMapping("/shipping")
    public void shipping(Freight freight){
        freightService.addFreight(freight);
    }
}
