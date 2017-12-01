package cn.com.edzleft.controller.procurement.shouye;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



import cn.com.edzleft.service.procurement.shouye.UserService;
@RequestMapping("/password")
@Controller
public class ChangePwdController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="changePwd")
	@ResponseBody
	public Object changePassword(HttpSession session,String oldpwd,String newpwd,String confirm ) throws Exception{
		//得到当前session中的登陆用户
		cn.com.edzleft.entity.SessionInfo sessionInfo=(cn.com.edzleft.entity.SessionInfo) session.getAttribute("sessionInfo");
		String msg = "";
		msg = userService.updataPwd(sessionInfo.getAdmin().getUserId(),oldpwd,newpwd,confirm);
		return msg;
		
	}
}
