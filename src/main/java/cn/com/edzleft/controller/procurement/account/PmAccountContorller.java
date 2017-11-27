package cn.com.edzleft.controller.procurement.account;


import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.com.edzleft.service.procurement.account.Pmaccountservice;
@RequestMapping("/password")
@Controller
public class PmAccountContorller {
	@Autowired
	private Pmaccountservice pmAccountservice;
	
	@RequestMapping(value="changePwd")
	@ResponseBody
	public String changePassword(HttpSession session,String oldpwd,String newpwd,String confirm ) throws Exception{
		//得到当前session中的登陆用户
		cn.com.edzleft.entity.SessionInfo sessionInfo=(cn.com.edzleft.entity.SessionInfo) session.getAttribute("sessionInfo");
		System.out.println(sessionInfo);
		//String msg = "";
		String msg = pmAccountservice.updataPwd(sessionInfo.getAdmin().getUserId(),oldpwd,newpwd,confirm);
		String jsonString = JSON.toJSONString(msg);
		return jsonString;
		
	}
}
