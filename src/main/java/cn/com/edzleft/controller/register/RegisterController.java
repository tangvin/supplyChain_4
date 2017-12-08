package cn.com.edzleft.controller.register;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.edzleft.entity.Account;
import cn.com.edzleft.entity.SessionInfo;
import cn.com.edzleft.service.register.RegisterService;
import cn.com.edzleft.util.ConfigUtil;
import cn.com.edzleft.util.page.DataGridJson;

@Controller
@RequestMapping("/register2")
public class RegisterController {
	@Autowired
	private RegisterService registerService;
	
	/*@RequestMapping(value = "/first",method = RequestMethod.POST)
    @ResponseBody
	public Map first(String accountType,String userLinkman,String phone,String checkCode,HttpSession session,HttpServletRequest request) {
		Map map=new HashMap<>();
		Account account=new Account();
		SessionInfo sessionInfo = new SessionInfo();
		account.setAccountType(Integer.parseInt(accountType));
		account.setUserLinkman(userLinkman);
		account.setUserPhone(phone);
		 sessionInfo.setAdmin(account);
		 request.getSession().setAttribute(ConfigUtil.getSessionInfoName(),sessionInfo);
		 String sendCode=(String) session.getAttribute("sendCodes");
		 if (sendCode.equals(checkCode)) {
			map.put("success", true);
		}else {
			map.put("success", false);
		}
		 
		return map;
		}  */
	@RequestMapping(value = "/first")
    @ResponseBody
	public String first() {
		/*Map<String,Object> map=new HashMap<>();
		
		 map.put("data", "111");*/
		return "true";
	}  
}

		



