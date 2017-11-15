package cn.com.edzleft.controller.captial.homepage;

import cn.com.edzleft.service.captial.homepage.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ASUS on 2017/11/2.
 */
@Controller
@RequestMapping("page")
public class HomePageController {

    @Autowired
    private HomePageService homePageService;




}
