package cn.com.edzleft.controller.trade.homepage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ASUS on 2017/11/15.
 */
@Controller
@RequestMapping(value="tradeMain")
public class MainsController {



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
    public ModelAndView ziliao(){
        ModelAndView modelAndView = new ModelAndView("/trade/information/information");
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
     * 采购方合同签约
     * @return
     */
    @RequestMapping(value = "htqy")
    public String htqy(){
        return "/trade/contract/contract";
    }

    /**
     * 采购方授用信管理
     * @return
     */
    @RequestMapping(value = "syxgl")
    public String management(){
        return "/trade/management/management";
    }

    /**
     * 采购方系统首页
     * @return
     */
    @RequestMapping(value="/xtsy")
    public String mains(){
        return "/trade/mains";
    }

    /**
     * 采购方首页
     * @return
     */
    @RequestMapping(value = "tradeMain")
    public String procurementMain(){
        return "trade/main";
    }

    /**
     * 采购方资料维护
     * @return
     */
    @RequestMapping(value = "/zhxx")
    public String information(){
        return "/trade/information/information";
    }


}
