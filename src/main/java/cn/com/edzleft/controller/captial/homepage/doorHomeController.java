package cn.com.edzleft.controller.captial.homepage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ASUS on 2017/12/14.
 */
@Controller
public class doorHomeController {


    /**
     * 注册页面
     * @return
     */
    @RequestMapping(value = "register")
    public String register(){
        return "/register";
    }

    /**
     * 登录
     * @return
     */
    @RequestMapping(value = "login")
    public String login (){
        return "login";
    }

    /**
     * 门户首页
     * @return
     */
    @RequestMapping("homeDoor")
    public String homeDoor(){
        return "door/home";
    }

    /**
     * 门户产品中心
     * @return
     */
    @RequestMapping("productCentre")
    public String productCentre(){
        return "door/productCentre";
    }

    /**
     * 门户合作伙伴
     * @return
     */
    @RequestMapping("solution")
    public String solution(){
        return "door/solution";
    }

    /**
     * 门户合作伙伴
     * @return
     */
    @RequestMapping("partner")
    public String partner(){
        return "door/partner";
    }

    /**
     * 门户关于我们
     * @return
     */
    @RequestMapping("about")
    public String about(){
        return "door/about";
    }


    @RequestMapping(value = "homeIndex")
    public String homeIndex(){
        return "../../index";
    }

}
