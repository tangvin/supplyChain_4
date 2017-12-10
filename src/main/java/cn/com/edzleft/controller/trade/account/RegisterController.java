package cn.com.edzleft.controller.trade.account;

import cn.com.edzleft.entity.Account;
import cn.com.edzleft.entity.SessionInfo;
import cn.com.edzleft.service.trade.account.AccountService;
import cn.com.edzleft.service.trade.account.RegisterService;
import cn.com.edzleft.util.ConfigUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.net.InetAddress;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value="/register11")
public class RegisterController {
	@Autowired
	private  AccountService accountService;


	@RequestMapping(value = "registerOne",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> first(String userPhone,String userLinkman,String accountType,String checkCode) {
		Map<String,Object> map=new HashMap<>();
		map.put("userPhone", userPhone);
		map.put("userLinkman", userLinkman);
		map.put("accountType", accountType);
		map.put("success", true);
		/*if (sendCode.equals(checkCode)) {
			map.put("success", true);
		}else {
			map.put("success", false);
		}*/

		return map;
	}
	@RequestMapping(value = "registerTwo",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> two(String userName,String userPwd,String userPhone,String userLinkman,String accountType){
		Map<String, Object> map = new HashMap<>();
		//SessionInfo sessionInfo = new SessionInfo();
		Account account=new Account();
		account.setUserName(userName);
		account.setUserPwd(userPwd);
		account.setAccountType(Integer.parseInt(accountType));
		account.setUserPhone(userPhone);
		account.setUserLinkman(userLinkman);
		account.setCreateTime(new Date());
		//InetAddress ia=null;
		//account.setCreatIp(ia.getHostAddress());
		int count = accountService.insert(account);
		if ( count > 0) {
			map.put("success", true);
		}else {
			map.put("success", false);
		}
		
		return map;
	}


//	@RequestMapping(value = "/registerOne",method = RequestMethod.POST)
//    @ResponseBody
//	public Map first(String accountType, String userLinkman, String userPhone, String checkCode, HttpSession session, HttpServletRequest request) {
//		Map map=new HashMap<>();
//		Account account=new Account();
//		SessionInfo sessionInfo = new SessionInfo();
//		account.setAccountType(Integer.parseInt(accountType));
//		account.setUserLinkman(userLinkman);
//		account.setUserPhone(userPhone);
//		 sessionInfo.setAdmin(account);
//		 request.getSession().setAttribute(ConfigUtil.getSessionInfoName(),sessionInfo);
//		 String sendCode=(String) session.getAttribute("sendCodes");
//		 if (sendCode.equals(checkCode)) {
//			map.put("success", true);
//		}else {
//			map.put("success", false);
//		}
//
//		return map;
//		}


//	@RequestMapping(value = "/registerOne")
//    @ResponseBody
//	public Map<String,Object> first() {
//		Map<String,Object> map=new HashMap<>();
//
//		 map.put("data", "111");
//		return map;
//	}
}

		



