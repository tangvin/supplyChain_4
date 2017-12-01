package cn.com.edzleft.controller.procurement.homepage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ASUS on 2017/11/15.
 */
@Controller
@RequestMapping(value="procurementMain")
public class MainControllers {

    /**
     * 认证资料
     * @return
     */
    @RequestMapping(value = "zlrz")
    public String zlrz(){
        return "procurement/information/attestation";
    }

    /**
     * 资料编辑
     * @return
     */
    @RequestMapping(value = "updateInformation")
    public String updateInformation(){
        return "procurement/information/updateInformation";
    }

    /**
     * 账户安全
     * @return
     */
    @RequestMapping(value = "messages")
    public ModelAndView messages(){
        ModelAndView modelAndView = new ModelAndView("/procurement/information/information");
        modelAndView.addObject("messages", "profile");
        return modelAndView;
    }

    /**
     * 基本资料
     * @return
     */
    @RequestMapping(value = "ziliao")
    public ModelAndView ziliao(){
        ModelAndView modelAndView = new ModelAndView("/procurement/information/information");
        modelAndView.addObject("messages", "home");
        return modelAndView;
    }
    /**
     * 资金账户
     * @return
     */
    @RequestMapping(value = "zijin")
    public ModelAndView zijin(){
        ModelAndView modelAndView = new ModelAndView("/procurement/information/information");
        modelAndView.addObject("messages", "settings");
        return modelAndView;
    }

    /**
     * 我的设置
     * @return
     */
    @RequestMapping(value = "setting")
    public String setting(){
        return "/procurement/setting/setting";
    }
    /**
     * ukey 证书
     * @return
     */
    @RequestMapping(value = "ukeyZs")
    public String ukeyZs(){
        return "/procurement/certificate/certificate";
    }

    /**
     * 添加发票
     * @return
     */
    @RequestMapping(value = "tjfp")
    public String tjfp(){
        return "/procurement/invoice/insert";
    }

    /**
     * 发票管理
     * @return
     */
    @RequestMapping(value = "fpgl")
    public String fpgl(){
        return "/procurement/invoice/invoice";
    }

    /**
     * 财务管理
     * @return
     */
    @RequestMapping(value = "cwgl")
    public String cwgl(){
        return "/procurement/financing/financing";
    }

    /**
     * 订单管理
     * @return
     */
    @RequestMapping(value = "ddgl")
    public String ddgl(){
        return "/procurement/order/order";
    }

    /**
     * 新增合同
     * @return
     */
    @RequestMapping(value = "xzht")
    public String xzht(){
        return "/procurement/contract/insert";
    }
    @RequestMapping(value = "xzht1")
    public String xzht1(){
        return "/procurement/contract/inserts";
    }

    /**
     * 编辑合同
     * @return
     */
    @RequestMapping(value = "htbj")
    public String htbj(){
        return "/procurement/contract/update";
    }
    /**
     * 合同详情
     * @return
     */
    @RequestMapping(value = "htxq")
    public String htxq(){
        return "/procurement/contract/particulars";
    }

    /**
     * 采购方合同签约
     * @return
     */
    @RequestMapping(value = "htqy")
    public String htqy(){
        return "/procurement/contract/contract";
    }

    /**
     * 采购方授用信管理
     * @return
     */
    @RequestMapping(value = "syxgl")
    public String management(){
        return "/procurement/management/management";
    }

    /**
     * 采购方系统首页
     * @return
     */
    @RequestMapping(value="/xtsy")
    public String mains(){
        return "/procurement/mains";
    }

    /**
     * 采购方首页
     * @return
     */
    @RequestMapping(value = "procurementMain")
    public String procurementMain(){
        return "procurement/main";
    }

    /**
     * 采购方资料维护
     * @return
     */
    @RequestMapping(value = "/zhxx")
    public String information(){
        return "/procurement/information/information";
    }


}
