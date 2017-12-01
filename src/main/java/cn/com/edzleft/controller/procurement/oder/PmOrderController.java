package cn.com.edzleft.controller.procurement.oder;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import cn.com.edzleft.entity.Order;
import cn.com.edzleft.entity.SessionInfo;
import cn.com.edzleft.service.procurement.oder.PmOrderService;
import cn.com.edzleft.util.page.DataGridJson;
import cn.com.edzleft.util.page.PageUtil;

@Controller
@RequestMapping("/pmorder")
public class PmOrderController {

	@Autowired
	private PmOrderService pmOrderService;
	@RequestMapping(value="/pmgetorder")
	@ResponseBody
	public DataGridJson letterSelect(Integer pageNumber,Integer pageSize ,String orderCreatorTrade,String orderStatus,String creditGrantor){
		PageUtil<Order> userPage = new PageUtil<>();
        HashMap<String,Object> whereMaps =new HashMap<>();
        whereMaps.put("orderCreatorTrade",orderCreatorTrade);
        whereMaps.put("orderStatus",orderStatus);
        whereMaps.put("creditGrantor",creditGrantor);
        DataGridJson dgj = new DataGridJson();
        userPage.setCpage(pageNumber);
        userPage.setPageSize(pageSize);
        userPage.setWhereMap(whereMaps);
        userPage = pmOrderService.getOrderEntityList(userPage);
        dgj.setTotal(userPage.getTotalCount());
        dgj.setRows(userPage.getList());
        return dgj;
    }
	/**
	 * 查询默认地址
	 * @param pageNumber
	 * @param pageSize
	 * @param orderCreatorTrade
	 * @param orderStatus
	 * @param creditGrantor
	 * @return
	 */
	@RequestMapping(value="/insetOrder")
	@ResponseBody
	public Object insetOrder(HttpSession sessionInfo){
		SessionInfo session = (SessionInfo) sessionInfo.getAttribute("sessionInfo");
        Integer userId = session.getAdmin().getUserId();
        String address=pmOrderService.insetOrder(userId);
        String area=pmOrderService.insetOrder2(userId);
        String rAddressPerson=pmOrderService.insetOrder3(userId);
        Integer rAddressPhone=pmOrderService.insetOrder4(userId);
        String addr=area+" "+address;
        JSONObject obj=new JSONObject();
        obj.put("address", addr);
        obj.put("rAddressPerson", rAddressPerson);
        obj.put("rAddressPhone", rAddressPhone);
        return obj;
	}
	/**
	 * 确认新增订单
	 */
	@RequestMapping(value="confirmOder")
	@ResponseBody
	public boolean confirmOder(Order o){
		int i = pmOrderService.insertSelective(o);
		return i>0?true:false;
	}
	
	/**
	 * 订单状态
	 */
	
	
}
