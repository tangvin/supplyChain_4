package cn.com.edzleft.controller.trade.information;

import cn.com.edzleft.entity.Account;
import cn.com.edzleft.entity.Information;
import cn.com.edzleft.service.trade.information.TradeInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by ibmtech on 2017/11/21.
 */
@Controller
@RequestMapping(value = "/information")
public class TradeInformationController {

    @Autowired
    private TradeInformationService tradeinformationService;



    /**
     * 修改基本信息
     */
    @RequestMapping("/update")
    public void updateInformation(Information info){
        tradeinformationService.modifyInformation(info);
    }





}
