package cn.com.edzleft.controller.trade.homepage;


import cn.com.edzleft.entity.Account;
import cn.com.edzleft.entity.Information;
import cn.com.edzleft.entity.SessionInfo;
import cn.com.edzleft.service.trade.account.AccountService;
import cn.com.edzleft.service.trade.information.TradeInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by ASUS on 2017/11/15.
 */
@Controller
@RequestMapping(value="tradeMain")
public class MainsController {

        @Autowired
        private TradeInformationService tradeInformationService;
        @Autowired
        private AccountService accountService;

    /**
     * 账户安全
     * @return
     */
    @RequestMapping(value = "messages")
    public ModelAndView messages(){
        ModelAndView modelAndView = new ModelAndView("/trade/information/information");
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
        Information information = tradeInformationService.queryBaseInformation(userId);
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
    public ModelAndView zijin(){
        ModelAndView modelAndView = new ModelAndView("/trade/information/information");
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
    public String ddgl(){
        return "/trade/order/order";
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
        Information information = tradeInformationService.queryBaseInformation(userId);
        System.out.println(information);
        mv.addObject("information",information);
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
