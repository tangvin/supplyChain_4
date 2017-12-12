package cn.com.edzleft.controller.procurement.receivingaddress;

import cn.com.edzleft.entity.ReceivingAddress;
import cn.com.edzleft.service.procurement.receivingaddress.PmReceivingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

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
		int i = pmreceivingAddressservice.insert(ra,sessionInfo);
		return i>0?true:false;
	}
	
	
	/**
	 * 收货地址设为默认
	 */
	@ResponseBody
	@RequestMapping(value="setDefault")
	public int setDefaultAddress(Integer id,Integer value,HttpSession session){
		int flag = pmreceivingAddressservice.setDefaultAddress(id,session,value);
		return flag;
	}
	/**
	 * 删除收货地址
	 */
	@ResponseBody
	@RequestMapping(value="deleteAddress")
	public boolean setDefaultAddress(Integer id){
		int i = pmreceivingAddressservice.deleteAddress(id);
		return i>0?true:false;
	}
}
