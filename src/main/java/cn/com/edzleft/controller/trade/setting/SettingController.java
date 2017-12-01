package cn.com.edzleft.controller.trade.setting;

import java.util.HashMap;
import java.util.Map;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.edzleft.entity.Account;
import cn.com.edzleft.entity.SessionInfo;
import cn.com.edzleft.entity.Settings;
import cn.com.edzleft.service.trade.setting.SettingService;
/**
 * 我的设置
 * @author yhs
 * @日期 2017年11月24日
 */
@Controller
@RequestMapping("/setting")
public class SettingController {
	@Autowired
	private SettingService settingService;
	/**
	 * 进入我的设置页
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/settingByUserId", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getSettingByUserId(HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute("sessionInfo");
		Account sessionAccount=sessionInfo.getAdmin();
		//System.out.println(session_account.getUserId());
		Settings setting = settingService.querySettingByUserId(sessionAccount.getUserId());
		map.put("setting", setting);
		return map;
	}
	/**
	 * 保存我的设置
	 * @param shortMessage
	 * @param email
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/update", method =RequestMethod.POST )
	@ResponseBody
	public Object update(Integer shortMessage,Integer email,HttpSession session) {
		
		Settings setting=new Settings();
		setting.setShortMessage(shortMessage);
		setting.setEmail(email);
		//获取session中userId
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute("sessionInfo");
		Account sessionAccount=sessionInfo.getAdmin();
		Integer userId=sessionAccount.getUserId();
		//存入setting
		setting.setUserId(userId);
		setting.setShortMessage(shortMessage);
		setting.setEmail(email);
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		Integer res=settingService.update(setting);
		if (res>0) {
			jsonMap.put("success", true);
		}else {
			jsonMap.put("success", false);
		}
		return jsonMap;
	}
}
