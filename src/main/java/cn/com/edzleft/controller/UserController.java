package cn.com.edzleft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.com.edzleft.entity.Rain;
import javax.servlet.http.HttpServletRequest;

import cn.com.edzleft.service.Rainservice;
/**
 * Created by UPC on 2017/6/20.
 */
@Controller
@RequestMapping(value="/web/user/")
public class UserController extends BaseController{

    @Autowired
    private Rainservice rainservice;

    /**
     * 添加用户
     * @param user
     * @param request
     * @return
     */
    @RequestMapping(value="/addUser")
    public String addUser(Rain user,HttpServletRequest request){
        System.out.println("aaa++++++++++++++++++++++++++++++");
        return "rain";
    }
}
