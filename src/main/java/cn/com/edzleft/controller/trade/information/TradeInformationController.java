package cn.com.edzleft.controller.trade.information;

import cn.com.edzleft.entity.Information;
import cn.com.edzleft.service.trade.information.TradeInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ibmtech on 2017/11/21.
 */
@Controller
@RequestMapping(value = "/information")
public class TradeInformationController {

    @Autowired
    private TradeInformationService informationService;

    /**
     * 基本资料展示
     */
    @RequestMapping(value = "/baseInformation",method = RequestMethod.POST)
    @ResponseBody
    public Information queryBaseInformation(){
        Information queryBaseInformation = informationService.queryBaseInformation();
        return queryBaseInformation;
    }


    /**
     * 修改基本信息
     */
    public void updateInformation(Information info){
        informationService.modiflyInformation(info);
    }





}
