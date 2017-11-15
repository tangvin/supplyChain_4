package cn.com.edzleft.controller.captial.homepage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ASUS on 2017/11/15.
 */
@Controller
@RequestMapping(value="main")
public class mainController {

    /**
     * 授用信管理
     * @return
     */
    @RequestMapping(value = "tradeSyxgls")
    public String tradeSyxgls(){
        return "/trade/management/management";
    }

    /**
     * 贸易方系统首页
     * @return
     */
    @RequestMapping(value = "tradeXtsy")
    public String tradeXtsy(){
        return "/trade/mains";
    }

    /**
     * 贸易方资料维护
     * @return
     */
    @RequestMapping(value = "tradeZhxx")
    public String tradeZhxx(){
        return "/trade/information/information";
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
     * 采购方资料维护
     * @return
     */
    @RequestMapping(value = "/zhxx")
    public String information(){
        return "/procurement/information/information";
    }

    /**
     * 进入首页
     * @return
     */
    @RequestMapping(value="/signingInfo")
    public String signingInfo(){
        System.out.println("==================================");
        return "trade/main";
    }

    /**
     * 进入登录页面
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }
}
