package cn.com.edzleft.controller.trade.information;

import cn.com.edzleft.entity.Account;
import cn.com.edzleft.entity.Information;
import cn.com.edzleft.entity.SessionInfo;
import cn.com.edzleft.service.trade.account.AccountService;
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

    @Autowired
    private TradeInformationService tradeInformationService;

    @Autowired
    private AccountService accountService;
    /**
     * 修改基本信息
     */
    @RequestMapping(value = "/modifyInformation",method = RequestMethod.POST)
    @ResponseBody
    public String updateInformation(Information info,HttpSession sessionInfo){
        //获取当前登录用户
        SessionInfo session = (SessionInfo) sessionInfo.getAttribute("sessionInfo");
        Integer informationId = session.getAdmin().getInformationId();
        Integer userId = session.getAdmin().getUserId();
        //判断当前用户是否是新用户（是，新增资料     否，编辑资料）
        if(informationId==null){
            int i = tradeinformationService.addInformation(info,sessionInfo);
            if(i>0){
                Information infor = tradeInformationService.selectByCreatorId(userId);
                //再次根据information表中的creatorId查询出information表中的主键
                Integer inforId = infor.getId();
                Account account = new Account();
                account.setInformationId(inforId);
                account.setUserId(userId);

                int m = accountService.updatePassword(account);
                return "添加成功";
            }
            return "新增当前的用户";
        }else {
            int flag = tradeinformationService.modifyInformation(info);
            return "修改";
        }
    }





}
