package cn.com.edzleft.controller.trade.information;

import cn.com.edzleft.entity.Information;
import cn.com.edzleft.service.trade.information.InformationService;
import org.jboss.logging.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by ibmtech on 2017/11/21.
 */
@Controller
@RequestMapping(value = "/information")
public class InformationController {

    @Autowired
    private InformationService informationService;

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
