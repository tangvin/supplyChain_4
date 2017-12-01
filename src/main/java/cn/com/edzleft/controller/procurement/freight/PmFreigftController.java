package cn.com.edzleft.controller.procurement.freight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.edzleft.entity.Freight;
import cn.com.edzleft.service.procurement.freight.PmFreightService;
@RequestMapping("/Addfreigft")
@Controller
public class PmFreigftController {
	
	@Autowired
	private PmFreightService pmfreightservice;
	/**
	 * 添加货运单位
	 */
	@ResponseBody
	@RequestMapping(value="Addfreigft")
	public boolean getAddFreigft(Freight fr){
		int i = pmfreightservice.insert(fr);
		return i>0?true:false;
	}

}
