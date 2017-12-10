package cn.com.edzleft.controller.trade.homepage;


import cn.com.edzleft.entity.*;
import cn.com.edzleft.service.trade.account.AccountService;
import cn.com.edzleft.service.trade.bankAccount.BankAccountService;
import cn.com.edzleft.service.trade.contractSigning.ContractSigningService;
import cn.com.edzleft.service.trade.freight.FreightService;
import cn.com.edzleft.service.trade.information.TradeInformationService;
import cn.com.edzleft.service.trade.order.TradeOrderService;
import cn.com.edzleft.service.trade.receivingAddress.ReceivingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by ASUS on 2017/11/15.
 */
@Controller
@RequestMapping(value="/tradeMain")
public class MainsController {

    @Autowired
    private TradeInformationService tradeInformationService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private TradeOrderService tradeOrderService;
    @Autowired
    private FreightService freightService;
    @Autowired
    private ReceivingAddressService receivingAddressService;
    @Autowired
    private ContractSigningService contractSigningService;
    @Autowired
    private BankAccountService bankAccountService;


    /**
     * 货运管理
     */
    @RequestMapping(value ="/hygl")
    public ModelAndView hygl(HttpSession sessionInfo){
        ModelAndView modelAndView = new ModelAndView("/trade/information/information");
        SessionInfo session = (SessionInfo) sessionInfo.getAttribute("sessionInfo");
        Integer userId = session.getAdmin().getUserId();
        Information information = tradeInformationService.queryBaseInformation(userId);
        modelAndView.addObject("information", information);
        modelAndView.addObject("messages", "settings1");
        return modelAndView;
    }

    /**
     * 银行账户
     */
    @RequestMapping(value = "/yhzh")
    public ModelAndView yhzh(HttpSession sessionInfo){
        ModelAndView modelAndView = new ModelAndView("/trade/information/information");
        SessionInfo session = (SessionInfo) sessionInfo.getAttribute("sessionInfo");
        Integer userId = session.getAdmin().getUserId();
        Information information = tradeInformationService.queryBaseInformation(userId);
        modelAndView.addObject("information", information);
        modelAndView.addObject("messages", "messages");
        return modelAndView;
    }

    /**
     * 添加银行卡三步走
     * @return
     */
    @RequestMapping(value = "/bankTwo",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> bankTwo(HttpSession session, BankAccount bankAccount){
        //获取当前用户填写的银行卡类型(开户行)
        String bankAccountDepositBank = bankAccount.getBankAccountDepositBank();
        //获取输入的账号查询银行卡信息（获取手机号）
        String bankAccountNumber = bankAccount.getBankAccountNumber();
        BankAccount ba = bankAccountService.queryBankAccountByNumber(bankAccountNumber);
        if(ba!=null){
            Integer userId = ba.getUserId();
            Account account = accountService.queryAcountById(userId);
            String userPhone = account.getUserPhone();
            Map<String,Object> map = new HashMap<>();
            map.put("userPhone",userPhone);
            map.put("bankAccountDepositBank",bankAccountDepositBank);
            return map;
        }else {
            return null;
        }
    }

    /**
     * 添加银行卡第一步
     * @return
     */
    @RequestMapping("bankOne")
    public String bankOne(){
        return "/trade/information/bankOne";
    }

    /**
     * 订单查看
     * @return
     */
    @RequestMapping(value = "ddck")
    public ModelAndView ddck(String value){
        Order order = tradeOrderService.queryOrderByNumber(value);
        //获取货运管理表id
        Integer logisticsUnitId = order.getLogisticsUnitId();
        //查询出货运单位信息
        Freight freight = freightService.queryFreightById(logisticsUnitId);
        //获取收货地址的id
        Integer addressId = order.getReceivingAddressId();
        //查询出地址信息
        ReceivingAddress receivingAddress = receivingAddressService.queryReceivingAddress(addressId);
        //获取合同id
        Integer principalOrderId = order.getPrincipalOrderId();
        //查询出合同信息
        Contract contract = contractSigningService.queryContractById(principalOrderId);
        ModelAndView modelAndView = new ModelAndView("/trade/order/viewOrder");
        modelAndView.addObject("order",order);
        modelAndView.addObject("freight",freight);
        modelAndView.addObject("receivingAddress",receivingAddress);
        modelAndView.addObject("contract",contract);
        return modelAndView;
    }

    /**
     * 认证资料
     * @return
     */
    @RequestMapping(value = "zlrz")
    public String zlrz(){
        return "trade/information/attestation";
    }

    /**
     * 资料编辑
     * @return
     */
    @RequestMapping(value = "updateInformation")
    public ModelAndView updateInformation(HttpSession sessionInfo){
        ModelAndView modelAndView = new ModelAndView("trade/information/updateInformation");
        SessionInfo session = (SessionInfo) sessionInfo.getAttribute("sessionInfo");
        Integer userId = session.getAdmin().getUserId();
        Information information = tradeInformationService.queryBaseInformation(userId);
        modelAndView.addObject("information", information);
        return modelAndView;
    }


    /**
     * 账户安全
     * @return
     */
    @RequestMapping(value = "messages")
    public ModelAndView messages(HttpSession sessionInfo){
        ModelAndView modelAndView = new ModelAndView("/trade/information/information");
        SessionInfo session = (SessionInfo) sessionInfo.getAttribute("sessionInfo");
        Integer userId = session.getAdmin().getUserId();
        Information information = tradeInformationService.queryBaseInformation(userId);
        modelAndView.addObject("information",information);
        modelAndView.addObject("messages", "profile");
        return modelAndView;
    }


    /**
     * 基本资料
     * @return
     */
    @RequestMapping(value = "ziliao")
    public ModelAndView ziliao(HttpSession sessionInfo){
        ModelAndView modelAndView = new ModelAndView("/trade/information/information");
        SessionInfo session = (SessionInfo) sessionInfo.getAttribute("sessionInfo");
        Integer userId = session.getAdmin().getUserId();
        String userName=session.getAdmin().getUserName();
        //根据用户id查询出当前的企业信息
        Information information = tradeInformationService.queryBaseInformation(userId);
        //根据用户名查询出当前用户
        Account account = accountService.queryAccountByName(userName);
        modelAndView.addObject("information", information);
        modelAndView.addObject("messages", "home");
        return modelAndView;
    }

    /**
     * 资金账户
     * @return
     */
    @RequestMapping(value = "zijin")
    public ModelAndView zijin(HttpSession sessionInfo){
        ModelAndView modelAndView = new ModelAndView("/trade/information/information");
        SessionInfo session = (SessionInfo) sessionInfo.getAttribute("sessionInfo");
        Integer userId = session.getAdmin().getUserId();
        Information information = tradeInformationService.queryBaseInformation(userId);
        modelAndView.addObject("information",information);
        modelAndView.addObject("messages", "settings");
        return modelAndView;
    }

    /**
     * 我的设置
     * @return
     */
    @RequestMapping(value = "setting")
    public String setting(){
        return "/trade/setting/setting";
    }
    /**
     * ukey 证书
     * @return
     */
    @RequestMapping(value = "ukeyZs")
    public String ukeyZs(){
        return "/trade/certificate/certificate";
    }

    /**
     * 添加发票
     * @return
     */
    @RequestMapping(value = "tjfp")
    public String tjfp(){
        return "/trade/invoice/insert";
    }

    /**
     * 发票管理
     * @return
     */
    @RequestMapping(value = "fpgl")
    public String fpgl(){
        return "/trade/invoice/invoice";
    }

    /**
     * 财务管理
     * @return
     */
    @RequestMapping(value = "cwgl")
    public String cwgl(){
        return "/trade/financing/financing";
    }

    /**
     * 订单管理
     * @return
     */
    @RequestMapping(value = "ddgl")
    public ModelAndView ddgl(HttpSession sessionInfo){
        ModelAndView modelAndView = new ModelAndView("/trade/order/order");
        SessionInfo session = (SessionInfo) sessionInfo.getAttribute("sessionInfo");
        Integer userId = session.getAdmin().getUserId();

        return modelAndView;
    }



    /**
     * 新增合同
     * @return
     */
    @RequestMapping(value = "xzht")
    public String xzht(){
        return "/trade/contract/insert";
    }
    @RequestMapping(value = "xzht1")
    public String xzht1(){
        return "/trade/contract/inserts";
    }

    /**
     * 编辑合同
     * @return
     */
    @RequestMapping(value = "htbj")
    public String htbj(){
        return "/trade/contract/update";
    }
    /**
     * 合同详情
     * @return
     */
    @RequestMapping(value = "htxq")
    public String htxq(){
        return "/trade/contract/particulars";
    }

    /**
     * 贸易方合同签约
     * @return
     */
    @RequestMapping(value = "htqy")
    public String htqy(){
        return "/trade/contract/contract";
    }

    /**
     * 贸易方授用信管理
     * @return
     */
    @RequestMapping(value = "syxgl")
    public String management(){
        return "/trade/management/management";
    }

    /**
     * 贸易方系统首页
     * @return
     */
    @RequestMapping(value="/xtsy")
    public  ModelAndView mains(HttpSession sessionInfo){
        ModelAndView mv = new ModelAndView("/trade/mains");
        SessionInfo session = (SessionInfo) sessionInfo.getAttribute("sessionInfo");
        Integer userId = session.getAdmin().getUserId();
        String userName = session.getAdmin().getUserName();
        Information information = tradeInformationService.queryBaseInformation(userId);
        Account account = accountService.queryAccountByName(userName);
        mv.addObject("information",information);
        mv.addObject("account",account);
        return mv;
    }

    /**
     * 贸易方首页(+企业详细信息)
     * @return
     */
    @RequestMapping(value = "/tradeMain")
    public ModelAndView tradeMain(HttpSession sessionInfo){
        ModelAndView mv = new ModelAndView("/trade/main");
        SessionInfo session = (SessionInfo) sessionInfo.getAttribute("sessionInfo");
        Integer userId = session.getAdmin().getUserId();
        String userName = session.getAdmin().getUserName();
        Information information = tradeInformationService.queryBaseInformation(userId);
        Account account = accountService.queryAccountByName(userName);
        mv.addObject("information",information);
        mv.addObject("account",account);
        return mv;
    }

    /**
     * 贸易方资料维护
     * @return
     */
    @RequestMapping(value = "/zhxx")
    public ModelAndView information(HttpSession sessionInfo){
        ModelAndView mv = new ModelAndView("/trade/information/information");
        SessionInfo session = (SessionInfo) sessionInfo.getAttribute("sessionInfo");
        Integer userId = session.getAdmin().getUserId();
        Information information = tradeInformationService.queryBaseInformation(userId);
        mv.addObject("information",information);
        return mv;
    }


}
