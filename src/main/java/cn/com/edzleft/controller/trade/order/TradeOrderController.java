package cn.com.edzleft.controller.trade.order;

import cn.com.edzleft.entity.*;
import cn.com.edzleft.service.trade.freight.FreightService;
import cn.com.edzleft.service.trade.invoice.TraAttService;
import cn.com.edzleft.service.trade.invoice.TraInvoiceService;
import cn.com.edzleft.service.trade.order.TradeOrderService;
import cn.com.edzleft.service.trade.receivingAddress.ReceivingAddressService;
import cn.com.edzleft.service.trade.reject.RejectService;
import cn.com.edzleft.util.page.DataGridJson;
import cn.com.edzleft.util.page.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * Created by ibmtech on 2017/11/28.
 */
@Controller
@RequestMapping("/tradeOrder")
public class TradeOrderController {

    /**
     * 订单
     */
    @Autowired
    private TradeOrderService tradeOrderService;

    /**
     * 货运管理
     */
    @Autowired
    private FreightService freightService;

    //收货地址
    @Autowired
    private ReceivingAddressService receivingAddressService;

    //驳回表
    @Autowired
    private RejectService rejectService;

    //发票
    @Autowired
    private TraInvoiceService traInvoiceService;

    //附件
    @Autowired
    private TraAttService traAttService;
    /**
     * 订单查询
     * @param pageNumber
     * @param pageSize
     * @param orderStatus
     * @param orderCreatTime
     * @param
     * @return
     */
    @RequestMapping(value = "/orderSelect" ,method = RequestMethod.POST)
    @ResponseBody
    public DataGridJson queryByPage(Integer pageNumber, Integer pageSize , String orderStatus, String orderCreatTime, String orderConfirmationTime, String procurementEntName,String contractName, String custom,HttpSession session){
        PageUtil<Order> pageUtil = new PageUtil<Order>();
        HashMap<String,Object> whereMaps =new HashMap<>();

        whereMaps.put("orderStatus",orderStatus);
        whereMaps.put("orderCreatTime",orderCreatTime);
        whereMaps.put("orderConfirmationTime",orderConfirmationTime);
        whereMaps.put("procurementEntName",procurementEntName);
        whereMaps.put("contractName",contractName);
        whereMaps.put("custom",custom);
        SessionInfo sessionInfo = (SessionInfo) session.getAttribute("sessionInfo");
        Account sessionAccount=sessionInfo.getAdmin();
        Integer informationId = sessionAccount.getInformationId();

        whereMaps.put("informationId",informationId);
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
     * 根据编号查询订单详情（回显）
     *
     */
    @RequestMapping(value = "/getOrderById",method = RequestMethod.POST)
    @ResponseBody
    public DataGridJson orderDetail(String orderNumber,String freightNumber,HttpSession session){
        DataGridJson dgj = new DataGridJson();
        HashMap<Object, Object> hashMap = new HashMap<>();
        Order order = tradeOrderService.queryOrderByNumber(orderNumber);
        Integer orderId = order.getOrderId();
        //根据货运单位名称查询出货运单位
        Freight freight = freightService.queryFreightByName(freightNumber);
        //根据订单中的收货地址获取收货地址id
        Integer addressId = order.getReceivingAddressId();
        //根据收货地址id获取收货信息
        ReceivingAddress receivingAddress =receivingAddressService.queryReceivingAddress(addressId);

        //将查询到的信息存到map集合中
        hashMap.put("order",order);
        hashMap.put("freight",freight);
        hashMap.put("receivingAddress",receivingAddress);
        dgj.setHashMap(hashMap);
        return dgj;
    }





    /**
     * 领取订单
     *
     */
    @RequestMapping(value = "/lqdd",method = RequestMethod.POST)
    @ResponseBody
    public Order lqdd(Integer id,Integer flag, HttpSession session){
        Order order = tradeOrderService.setOrderStatus(id,flag,session);
        return order;
    }


    /**
     *
     * 驳回订单
     */
    @RequestMapping(value = "/bohui",method = RequestMethod.POST)
    @ResponseBody
    public List<Reject> rejectReason(Integer id,Integer flag,HttpSession session){
        Order order = tradeOrderService.setOrderStatus(id,flag, session);
     //   rejectService.addRejectReason("");
        List<Reject> rejectList = rejectService.queryRejectByOrderId(id);
        return rejectList;
    }



    /**
     * 配置发货  （表单提交） 成功后（修改订单状态）
     */
    @RequestMapping(value = "/pzfh",method = RequestMethod.POST)
    @ResponseBody
    public String takeOrder(Integer id, Integer flag,String freightUnit,String freightNumber,String invoiceNo,HttpSession sessionInfo) throws IOException {
        //根据id获取当前的订单对象
        Order order = tradeOrderService.queryOrderById(id);
        Integer orderId = order.getOrderId();//需存到发票表
        //获取订单所对应的合同
        Integer principalOrderId = order.getPrincipalOrderId();
        //第一步：将附件（图片）存入表中
        Attachment attachment = new Attachment();
        attachment.setAttachmentName("附件名字");
        attachment.setAttachmentSource("附件来源--发票");
        attachment.setAttachmentUrl("https://8080/supply");
        //合同id
        attachment.setAttachmentCreditId(principalOrderId);
        //将图片存到附件表中
        Integer integer = traAttService.addAttachment(attachment);
        //插入附件数据后获取当前id, 作为外键存到发票表
        Integer attachmentId = attachment.getAttachmentId();


        //第二步：将发票信息存到发票表
        InvoiceRecord invoiceRecord = new InvoiceRecord();
        //将附件id存到发票表中
        invoiceRecord.setInvoiceFileAttachment(attachmentId);
        invoiceRecord.setOrderId(orderId);
        invoiceRecord.setCreateTime(new Date());


        //设置发票号
        invoiceRecord.setInvoiceNo(invoiceNo);
        //设置开票人(贸易方企业名字)
        SessionInfo session = (SessionInfo) sessionInfo.getAttribute("sessionInfo");
        Integer userId = session.getAdmin().getUserId();
        invoiceRecord.setInvoiceUserId(userId);
        //调用业务层方法添加发票
        Integer r = traInvoiceService.addInvoiceRecord(invoiceRecord, sessionInfo);
        //获取当前插入发票的id,作为外键存入订单表
        Integer n = invoiceRecord.getId();


        //第三步：添加订单

        //获取订单编号
        String orderNumber = order.getOrderNumber();
        //获取订单金额
        Double orderAmount = order.getOrderAmount();
        //收集参数--货运单位名称--根据货运单位名称选择对应的货运地址（一个订单只有一个货运地址）
        order.setFreightUnit(freightUnit);
        //选择某一地址时，可以对该地址进行管理，修改
        Freight freight = freightService.queryFreightByName(freightUnit);
        //收集参数--货运编号--存入订单表（注：只存订单表）
        order.setFreightUnit(freightNumber);
        //收集参数--发票号--存入订单表（不存发票表）
        order.setInvoiceNum(invoiceNo);
        //更新数据库订单表信息
        tradeOrderService.updateOrder(order);
        //设置订单状态
        tradeOrderService.setOrderStatus(id,flag,sessionInfo);
        System.out.println("表单提交成功");
        System.out.println("设置订单状态结束");
        return "1";
    }

}
