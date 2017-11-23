package cn.com.edzleft.controller.procurement.shouye;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.edzleft.entity.Information;
import cn.com.edzleft.service.procurement.shouye.InformationService;
@RequestMapping()
@Controller
public class InformationController {
	/**
	 * 查询首页基本资料
	 */
	@Autowired
	private InformationService informationService;
	@ResponseBody
	public List<Information> getInformationList(){
		List<Information> InformationList = informationService.getInformationList();
		return InformationList;
	}
}
