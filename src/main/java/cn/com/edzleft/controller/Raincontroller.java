package cn.com.edzleft.controller;

import cn.com.edzleft.service.Rainservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import cn.com.edzleft.entity.Rain;
import javax.servlet.http.HttpServletRequest;
/**
 * Created by ASUS on 2017/10/30.
 */
@Controller
@RequestMapping("/user")
public class Raincontroller {

    @Autowired
    private Rainservice rainservice;

    /**
     * 添加用户
     * @param user
     * @param request
     * @return
     */
    @RequestMapping(value="/addUser.action")
    public String addUser(Rain user,HttpServletRequest request){
        System.out.println("aaa");
        return "rain";
    }

}
