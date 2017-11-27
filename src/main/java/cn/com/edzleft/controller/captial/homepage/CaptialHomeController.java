package cn.com.edzleft.controller.captial.homepage;

import cn.com.edzleft.service.captial.homepage.CaptialHomePageService;
import cn.com.edzleft.service.trade.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ASUS on 2017/11/24.
 */
@RequestMapping("captialHome")
@Controller
public class CaptialHomeController {

    @Autowired
    private CaptialHomePageService captialHomePageService;
    @Autowired
    private AccountService accountService;



}
