package cn.com.edzleft.controller.captial.homepage;

import cn.com.edzleft.entity.Account;
import cn.com.edzleft.entity.Information;
import cn.com.edzleft.entity.SessionInfo;
import cn.com.edzleft.service.captial.homepage.CaptialHomePageService;
import cn.com.edzleft.service.trade.account.AccountService;
import cn.com.edzleft.util.ConfigUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by ASUS on 2017/11/15.
 */
@Controller
@RequestMapping(value="captialMain")
public class mainController {

    @Autowired
    private CaptialHomePageService captialHomePageService;
    @Autowired
    private AccountService accountService;

   /* *//**
     * 注册页面下一步
     * @return
     *//*
    @RequestMapping(value = "registerTwo")
    public String registerTwo(){
        return "/registerTwo";
    }*/

    /**
     * 注册页面
     * @return
     */
    @RequestMapping(value = "register")
    public String register(){
        return "/register";
    }
    
    
    /*@RequestMapping(value = "/registerOne",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> first(Account account,String checkCode, HttpSession session, HttpServletRequest request) {
		Map<String,Object> map=new HashMap<>();
		//Account account=new Account();
		SessionInfo sessionInfo = new SessionInfo();
//		account.setAccountType(Integer.parseInt(accountType));
//		account.setUserLinkman(userLinkman);
//		account.setUserPhone(userPhone);
		sessionInfo.setAdmin(account);
		request.getSession().setAttribute(ConfigUtil.getSessionInfoName(),sessionInfo);
		String sendCode=(String) session.getAttribute("sendCodes");
		map.put("success", true);
		if (sendCode.equals(checkCode)) {
			map.put("success", true);
		}else {
			map.put("success", false);
		}

		return map;
	}*/

    /**
     * 认证资料
     * @return
     */
    @RequestMapping(value = "zlrz")
    public String zlrz(){
        return "capital/information/attestation";
    }

    /**
     * 资料编辑
     * @return
     */
    @RequestMapping(value = "updateInformation")
    public ModelAndView updateInformation(HttpSession sessionInfo){
        ModelAndView mv = new ModelAndView("capital/information/updateInformation");
        SessionInfo session = (SessionInfo) sessionInfo.getAttribute("sessionInfo");
        Integer userId = session.getAdmin().getUserId();
        Information information = captialHomePageService.homePageSelect(userId);
        mv.addObject("information",information);
        return mv;
    }

    /**
     * 账户安全
     * @return
     */
    @RequestMapping(value = "messages")
    public ModelAndView messages(HttpSession sessionInfo){
        ModelAndView modelAndView = new ModelAndView("/capital/information/information");
        SessionInfo session = (SessionInfo) sessionInfo.getAttribute("sessionInfo");
        Integer userId = session.getAdmin().getUserId();
        Information information = captialHomePageService.homePageSelect(userId);
        modelAndView.addObject("information",information);
        modelAndView.addObject("messages", "profile");
        return modelAndView;
    }

    /**
     * 基本资料
     * @return
     */
    @RequestMapping(value = "/ziliao")
    public ModelAndView ziliao(HttpSession sessionInfo){
        ModelAndView mv = new ModelAndView("/capital/information/information");
        SessionInfo session = (SessionInfo) sessionInfo.getAttribute("sessionInfo");
        Integer userId = session.getAdmin().getUserId();
        Information information = captialHomePageService.homePageSelect(userId);
        mv.addObject("information",information);
        mv.addObject("messages", "home");
        return mv;
    }
    /**
     * 资金账户
     * @return
     */
    @RequestMapping(value = "zijin")
    public ModelAndView zijin(HttpSession sessionInfo){
        ModelAndView modelAndView = new ModelAndView("/capital/information/information");
        SessionInfo session = (SessionInfo) sessionInfo.getAttribute("sessionInfo");
        Integer userId = session.getAdmin().getUserId();
        Information information = captialHomePageService.homePageSelect(userId);
        modelAndView.addObject("information",information);
        modelAndView.addObject("messages", "settings");
        return modelAndView;
    }


    /**
     * 还款管理
     * @return
     */
    @RequestMapping(value = "hkgl")
    public String hkgl(){
        return "/capital/refund/refund";
    }

    /**
     * 贷款管理
     * @return
     */
    @RequestMapping(value = "dkgl")
    public String dkgl(){
        return "/capital/loans/loans";
    }

    /**
     * 我的设置
     * @return
     */
    @RequestMapping(value = "setting")
    public String setting(){
        return "/capital/setting/setting";
    }
    /**
     * ukey 证书
     * @return
     */
    @RequestMapping(value = "ukeyZs")
    public String ukeyZs(){
        return "/capital/certificate/certificate";
    }

    /**
     * 财务管理
     * @return
     */
    @RequestMapping(value = "cwgl")
    public String cwgl(){
        return "/capital/financing/financing";
    }


    /**
     * 采购方授用信管理
     * @return
     */
    @RequestMapping(value = "syxgl")
    public String management(){
        return "/capital/management/management";
    }

    /**
     * 采购方系统首页
     * @return
     */
    @RequestMapping(value="/xtsy")
    public ModelAndView mains(HttpSession sessionInfo){
        ModelAndView mv = new ModelAndView("/capital/mains");
        SessionInfo session = (SessionInfo) sessionInfo.getAttribute("sessionInfo");
        Integer userId = session.getAdmin().getUserId();
        Information information = captialHomePageService.homePageSelect(userId);
        mv.addObject("information",information);
        return mv;
    }
    /**
     * 采购方首页
     * @return
     */
    @RequestMapping(value = "captialMain")
    public ModelAndView procurementMain(HttpSession sessionInfo){
        ModelAndView mv = new ModelAndView("capital/main");
        SessionInfo session = (SessionInfo) sessionInfo.getAttribute("sessionInfo");
        Integer userId = session.getAdmin().getUserId();
        String userName = session.getAdmin().getUserName();
        Information information = captialHomePageService.homePageSelect(userId);
        Account account = accountService.queryAccountByName(userName);
        mv.addObject("information",information);
        mv.addObject("account",account);
        return mv;
    }

    /**
     * 采购方资料维护
     * @return
     */
    @RequestMapping(value = "/zhxx")
    public ModelAndView information(HttpSession sessionInfo){
        ModelAndView mv = new ModelAndView("/capital/information/information");
        SessionInfo session = (SessionInfo) sessionInfo.getAttribute("sessionInfo");
        Integer userId = session.getAdmin().getUserId();
        Information information = captialHomePageService.homePageSelect(userId);
        mv.addObject("information",information);
        return mv;
    }


    @RequestMapping(value = "login")
    public String login (){
        return "login";
    }

}
