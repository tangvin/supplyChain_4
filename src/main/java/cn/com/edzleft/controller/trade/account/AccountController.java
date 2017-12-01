package cn.com.edzleft.controller.trade.account;

import cn.com.edzleft.entity.Account;
import cn.com.edzleft.entity.Information;
import cn.com.edzleft.entity.SessionInfo;
import cn.com.edzleft.service.trade.account.AccountService;
import cn.com.edzleft.service.trade.information.TradeInformationService;
import cn.com.edzleft.util.ConfigUtil;
import cn.com.edzleft.util.MD5;
import cn.com.edzleft.util.ResultBean;
import cn.com.edzleft.util.ReturnJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by ibmtech on 2017/11/16.
 */
@Controller
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    private AccountService accountService;
    private TradeInformationService tradeInformationService;



    /**
     * 跳转至采购方页面
     * accountType==0
     */
    @RequestMapping("/loginProcurement")
    public String loginProcurement(){
        return "procurement/main";
    }

    /**
     * 跳转至贸易商页面
     * accountType==1
     */
    @RequestMapping("/loginTrade")
    public String loginView(){
        return "trade/main";
    }



    /**
     * 跳转至资方页面
     * accountType==2
     */
    @RequestMapping("/loginCapital")
    public String loginCapital(){
        return "capital/main";
    }


    /**
     * 登录
     */
    @RequestMapping(value="/login",method = RequestMethod.POST)
    @ResponseBody
    public ReturnJson login(String userName, String userPwd, String imageCode, HttpSession session, HttpServletRequest request) {
        SessionInfo sessionInfo = new SessionInfo();
        ReturnJson rj = new ReturnJson();
        Account account = accountService.queryAccountByName(userName);
       // System.out.println(account);
        //从页面获取验证码
        String code = (String)session.getAttribute("imageCode");
        if (account != null && code!=null) {
            //加密后的密码
           // String encrypt_pwd = MD5.sign(account.getUserPwd());
            //数据库查询出来的密码
            String queryPwds=account.getUserPwd();
                if (queryPwds.equals(userPwd)) {
                    if(imageCode.equalsIgnoreCase(code)) {
                        //所有判断均通过，将当前用户存到session
                        sessionInfo.setAdmin(account);
                        //session.setAttribute("account", "account");
                        request.getSession().setAttribute(ConfigUtil.getSessionInfoName(),sessionInfo);
                        if (account.getAccountType() == 0) {
                          rj.setSuccess(true);
                          rj.setMsg("对");
                          rj.setType(0);
                        } else if (account.getAccountType() == 1) {
                           /*
                            Integer userId = sessionInfo.getAccount().getUserId();
                            Information information = tradeInformationService.queryBaseInformation(userId);
                            sessionInfo.setInformation(information);
                            request.getSession().setAttribute(ConfigUtil.getSessionInfoName(),sessionInfo);
                            */
                            rj.setSuccess(true);
                            rj.setType(1);
                        } else if (account.getAccountType() == 2) {
                            rj.setSuccess(true);
                            rj.setType(2);
                        }
                    }else {
                        rj.setSuccess(false);
                        rj.setMsg("验证码错误");
                    }
                }else {
                    if(account.getUserPwd()!=userPwd){
                        rj.setSuccess(false);
                        rj.setMsg("密码错误");
                        return rj;
                    }


                }
        }else{
            rj.setSuccess(false);
            rj.setMsg("用户名不存在");
        }
                    return rj;
    }





/*
    //注册
    public String register(Account a,ModelMap modelMap) {

        if (a.getUserName() == "" || a.getUserPwd() == "") {
            String str = "输入有误!";
            modelMap.addAttribute("error", str);
            return "forward:/regist.jsp";
        } else {
            accountService.addAccount(a);
            if (a.getAccountType() == 0) {
                return "/procurement/main";
            } else if (a.getAccountType() == 1) {
                return "/trade/main";
            } else if (a.getAccountType() == 2) {
                return "/capital/main";
            }
            return "login";
        }
    }

    */



    /**
     * 修改账户密码
      * @return
     */
    @RequestMapping("/updatePwd")
    @ResponseBody
    public String modiflyPassword(HttpSession session,String oldPwd,String newPwd,String confirmPwd){
        ResultBean resultBean = accountService.updatePassword(session, oldPwd, newPwd, confirmPwd);
        return resultBean.toString();
        }



}

