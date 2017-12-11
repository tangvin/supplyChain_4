package cn.com.edzleft.controller.procurement.account;


import cn.com.edzleft.entity.Code;
import cn.com.edzleft.service.captial.homepage.CodeService;
import cn.com.edzleft.service.procurement.account.Pmaccountservice;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@RequestMapping("/password")
@Controller
public class PmAccountContorller {
	@Autowired
	private Pmaccountservice pmAccountservice;
	@Autowired
	private CodeService codeService;


	@RequestMapping(value="changePwd")
	@ResponseBody
	public String changePassword(HttpSession session,String newpwd,String confirm ,String senCode) throws Exception{
		//得到当前session中的登陆用户
		cn.com.edzleft.entity.SessionInfo sessionInfo=(cn.com.edzleft.entity.SessionInfo) session.getAttribute("sessionInfo");
		Code codes = codeService.selectCode(sessionInfo.getAdmin().getUserId());
		//String msg = "";
		String msg = pmAccountservice.updataPwd(codes.getUserId(),newpwd,confirm,senCode,codes.getCode(),codes.getCreatTime());
		String jsonString = JSON.toJSONString(msg);
		return jsonString;
		
	}
}
