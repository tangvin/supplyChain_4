package cn.com.edzleft.controller.captial.homepage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ASUS on 2017/11/15.
 */
@Controller
@RequestMapping(value="captialMain")
public class mainController {


    /**
     * 账户安全
     * @return
     */
    @RequestMapping(value = "messages")
    public ModelAndView messages(){
        ModelAndView modelAndView = new ModelAndView("/capital/information/information");
        modelAndView.addObject("messages", "profile");
        return modelAndView;
    }

    /**
     * 基本资料
     * @return
     */
    @RequestMapping(value = "ziliao")
    public ModelAndView ziliao(){
        ModelAndView modelAndView = new ModelAndView("/capital/information/information");
        modelAndView.addObject("messages", "home");
        return modelAndView;
    }
    /**
     * 资金账户
     * @return
     */
    @RequestMapping(value = "zijin")
    public ModelAndView zijin(){
        ModelAndView modelAndView = new ModelAndView("/capital/information/information");
        modelAndView.addObject("messages", "settings");
        return modelAndView;
    }


    /**
     * 还款管理
     * @return
     */
    @RequestMapping(value = "hkgl")
    public String hkgl(){
        return "/capital/refund/refund";
    }

    /**
     * 贷款管理
     * @return
     */
    @RequestMapping(value = "dkgl")
    public String dkgl(){
        return "/capital/loans/loans";
    }

    /**
     * 我的设置
     * @return
     */
    @RequestMapping(value = "setting")
    public String setting(){
        return "/capital/setting/setting";
    }
    /**
     * ukey 证书
     * @return
     */
    @RequestMapping(value = "ukeyZs")
    public String ukeyZs(){
        return "/capital/certificate/certificate";
    }

    /**
     * 财务管理
     * @return
     */
    @RequestMapping(value = "cwgl")
    public String cwgl(){
        return "/capital/financing/financing";
    }


    /**
     * 采购方授用信管理
     * @return
     */
    @RequestMapping(value = "syxgl")
    public String management(){
        return "/capital/management/management";
    }

    /**
     * 采购方系统首页
     * @return
     */
    @RequestMapping(value="/xtsy")
    public String mains(){
        return "/capital/mains";
    }

    /**
     * 采购方首页
     * @return
     */
    @RequestMapping(value = "captialMain")
    public String procurementMain(){
        return "capital/main";
    }

    /**
     * 采购方资料维护
     * @return
     */
    @RequestMapping(value = "/zhxx")
    public String information(){
        return "/capital/information/information";
    }


    @RequestMapping(value = "login")
    public String login (){
        return "login";
    }

}
