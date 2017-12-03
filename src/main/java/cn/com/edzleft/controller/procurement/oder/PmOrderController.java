package cn.com.edzleft.controller.procurement.oder;

import java.util.Date;
import java.util.HashMap;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

import cn.com.edzleft.entity.Information;
import cn.com.edzleft.entity.Order;
import cn.com.edzleft.entity.SessionInfo;
import cn.com.edzleft.service.procurement.oder.PmOrderService;
import cn.com.edzleft.util.page.DataGridJson;
import cn.com.edzleft.util.page.PageUtil;

@Controller
@RequestMapping("/pmorder")
public class PmOrderController {

	/**
	 * 查询订单列表
	 */
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
        String rAddressPhone=pmOrderService.insetOrder4(userId);
        Integer receivingAddressId=pmOrderService.insetOrder5(userId);
        String addr=area+" "+address;
        JSONObject obj=new JSONObject();
        obj.put("address", addr);
        obj.put("rAddressPerson", rAddressPerson);
        obj.put("rAddressPhone", rAddressPhone);
        obj.put("receivingAddressId", receivingAddressId);
        return obj;
	}
	/**
	 * 确认新增订单
	 */
	@RequestMapping(value="confirmOder")
	@ResponseBody
	public boolean confirmOder(HttpServletRequest req){
		String telephone = req.getParameter("telephone");
		String receiver = req.getParameter("receiver");
		//String address = req.getParameter("address");
		String receivingAddressId = req.getParameter("receivingAddressId");
		String orderAmount = req.getParameter("orderAmount");
		String principalOrderId = req.getParameter("principalOrderId");
		String applicationletter = req.getParameter("applicationletter");
		String orderCreatorTrade = req.getParameter("orderCreatorTrade");
		String goods = req.getParameter("goods");
		Order o=new Order();
		o.setContactPhone(Integer.parseInt(telephone));
		o.setOgisticsName(receiver);
		//o.setReceivingAddress(address);
		o.setReceivingAddressId(Integer.parseInt(receivingAddressId));
		o.setOrderAmount(Double.parseDouble(orderAmount));
		o.setPrincipalOrderId(Integer.parseInt(principalOrderId));
		o.setApplicationletter(applicationletter); 
		o.setGoods(goods);
		o.setOrderCreatorTrade(orderCreatorTrade);
		o.setOrderStatus(0);
		o.setOrderCreatTime(new Date());
		int i = pmOrderService.insertSelective(o);
		return i>0?true:false;
	}
	
	/**
	 * 改变状态
	 */
	@RequestMapping(value="cancelOrderStatus")
	@ResponseBody
	public boolean dqr(Integer id,Integer flag,Model model){
		int i = pmOrderService.updOrderStatus(id,flag);
		return i>0?true:false;
	}
	
	/**
	 * 申请用信
	 */
	@RequestMapping(value="sqyx")
	@ResponseBody
	public ModelAndView sqyx(Integer id,HttpServletRequest request){
		ModelAndView mv = new ModelAndView("procurement/order/order");
		Order order = pmOrderService.getSelectOrder(id);
        mv.addObject("order",order);
		return mv;
	}
	
	/**
	 * 提交申请用信
	 */
	@RequestMapping(value="commitSqyx")
	@ResponseBody
	public boolean commitSqyx(Integer id,Integer flag,String applicationletter){
		int i = pmOrderService.commitSqyx(id,flag,applicationletter);
		return i>0?true:false;
	}
	
}
