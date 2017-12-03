package cn.com.edzleft.controller.trade.order;

import cn.com.edzleft.entity.Freight;
import cn.com.edzleft.entity.Order;
import cn.com.edzleft.entity.SessionInfo;
import cn.com.edzleft.service.trade.freight.FreightService;
import cn.com.edzleft.service.trade.order.TradeOrderService;
import cn.com.edzleft.util.ConfigUtil;
import cn.com.edzleft.util.page.DataGridJson;
import cn.com.edzleft.util.page.PageUtil;
import com.sun.tools.corba.se.idl.constExpr.Or;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by ibmtech on 2017/11/28.
 */
@Controller
@RequestMapping("/tradeOrder")
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
    public Order orderDetail(Integer id){
        Order order = tradeOrderService.queryOrderById(id);
        return order;
    }





    /**
     * 领取订单
     * 驳回
     */
    @RequestMapping("/lqdd")
    @ResponseBody
    public Order pzfh(Integer id,Integer flag){
        System.out.println("~~~~~~~~~~~");
        Order order = tradeOrderService.setOrderStatus(id,flag);
        System.out.println(order);
        return order;
    }


    /**
     *
     * 配置发货表单提交 成功后（修改订单状态）
     */
    @RequestMapping("/pzfh")
    @ResponseBody
    public Order takeOrder(Integer id, Integer flag,Integer freightNumber,String freightUnit) {
//
//        //获取图片名字
//        String originalFilename=file.getOriginalFilename();
//        //将图片名字唯一
//       String uniqueFilename=UUID.randomUUID()+"."+ FilenameUtils.getExtension(originalFilename);
//       //动态获取服务器路径
//        String realPath=session.getServletContext().getRealPath("/d");
//        //获得文件文件后缀
//        String subfix = FilenameUtils.getExtension(uniqueFilename);
//        //采用时间戳的方式将图片文件名唯一化
//        String prefix = new SimpleDateFormat("yyyyMMddhhssSSS").format(new Date());
//        //拼接图片文件全名
//        String fullName=prefix+"."+subfix;
//        file.transferTo(new File(realPath+File.separator+uniqueFilename));
//
        //根据id获取当前的订单对象
        Order order = tradeOrderService.queryOrderById(id);
        //设置货运编号
        order.setFreightNumberId(freightNumber);
        //设置货运单位
        order.setFreightUnit(freightUnit);
        //调用业务配置发货
        tradeOrderService.updateOrder(order);
        //设置订单状态
        tradeOrderService.setOrderStatus(id,flag);
        System.out.println("设置订单状态结束");
        return order;
    }

}
