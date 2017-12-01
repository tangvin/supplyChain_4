package cn.com.edzleft.controller.captial.information;

import cn.com.edzleft.entity.Information;
import cn.com.edzleft.service.captial.information.CaptialInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ASUS on 2017/11/29.
 */
@RequestMapping("captialInformation")
@Controller
public class CaptialInformationController {

    @Autowired
    private CaptialInformationService captialInformationService;


    @RequestMapping(value = "updateInformation",method = RequestMethod.POST)
    public String updateInformation(Information information){
        captialInformationService.updateInformation(information);
        return "";
    }

}
