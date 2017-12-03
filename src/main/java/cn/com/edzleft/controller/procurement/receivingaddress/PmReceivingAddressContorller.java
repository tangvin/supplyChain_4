package cn.com.edzleft.controller.procurement.receivingaddress;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.edzleft.entity.ReceivingAddress;
import cn.com.edzleft.entity.SessionInfo;
import cn.com.edzleft.service.procurement.receivingaddress.PmReceivingAddressService;

@Controller
@RequestMapping("/PmReceivingAddress")
public class PmReceivingAddressContorller {

	@Autowired
	private PmReceivingAddressService pmreceivingAddressservice;
	/**
	 * 添加收货地址
	 * @param ra
	 */
	@ResponseBody
	@RequestMapping(value="getaddress")
	public boolean getAddress(ReceivingAddress ra,HttpSession sessionInfo){
		SessionInfo session = (SessionInfo) sessionInfo.getAttribute("sessionInfo");
        Integer userId = session.getAdmin().getUserId();
        ra.setUnionID(userId);
		int i = pmreceivingAddressservice.insert(ra);
		return i>0?true:false;
	}
}
