package cn.com.edzleft.controller.procurement.oder;

import cn.com.edzleft.entity.Order;
import cn.com.edzleft.entity.ReceivingAddress;
import cn.com.edzleft.entity.SessionInfo;
import cn.com.edzleft.service.procurement.homepage.PmHomePageService;
import cn.com.edzleft.service.procurement.oder.PmOrderService;
import cn.com.edzleft.service.procurement.receivingaddress.PmReceivingAddressService;
import cn.com.edzleft.util.page.DataGridJson;
import cn.com.edzleft.util.page.PageUtil;
import com.alibaba.fastjson.JSONObject;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/pmorder")
public class PmOrderController {

	/**
	 * 查询订单列表
	 */
	@Autowired
	private PmOrderService pmOrderService;
	@Autowired
	private PmReceivingAddressService pmreceivingAddressservice;
	
	@Autowired
	private PmHomePageService pmHomePageService;

	@Autowired
	private  HttpSession session;

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
	public boolean confirmOder(HttpServletRequest req,HttpSession sessionInfo){
		String telephone = req.getParameter("telephone");
		String receiver = req.getParameter("receiver");
		String receivingAddressId = req.getParameter("receivingAddressId");
		String orderAmount = req.getParameter("orderAmount");
		String principalOrderId = req.getParameter("principalOrderId");
		String applicationletter = req.getParameter("applicationletter");
		String orderCreatorTrade = req.getParameter("orderCreatorTrade");
		String goods = req.getParameter("goods");
		Order o=new Order();
		o.setContactPhone(telephone);
		o.setLogisticsName(receiver);
		o.setReceivingAddressId(Integer.parseInt(receivingAddressId));
		o.setOrderAmount(Double.parseDouble(orderAmount));
		o.setPrincipalOrderId(Integer.parseInt(principalOrderId));
		o.setApplicationletter(applicationletter); 
		o.setGoods(goods);
		o.setOrderCreatorTrade(orderCreatorTrade);
		o.setOrderStatus(0);
		o.setOrderCreatTime(new Date());
		int i = pmOrderService.insertSelective(o, sessionInfo);
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
	
	/**
	 * 回显订单
	 */
	@RequestMapping(value="ddbj")
	public ModelAndView ddbj(Integer orderId){
		ModelAndView mv = new ModelAndView("/procurement/order/updOrder");
		Order order  = pmOrderService.ddbj(orderId);
		Integer receivingAddressId = order.getReceivingAddressId();
		ReceivingAddress ra = pmreceivingAddressservice.queryReceivingAddress(receivingAddressId);
		mv.addObject("order", order);
		mv.addObject("ra",ra);
		return mv;
	}
	

	/**
	 * 返回地址集合
	 */
	@RequestMapping(value="addresshx",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> hxbj(HttpServletResponse response,HttpServletRequest request){
		/*跨域访问*/
		response.setContentType("text/plain");
		response.setHeader("Pragma", "No-cache");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setHeader("Access-Control-Allow-Origin", "*");//添加跨域访问
		Map<String,Object> map = new HashMap<>();
		List<ReceivingAddress> rs = pmreceivingAddressservice.selectByPrimaryKey(5);
		System.err.println("");
		map.put("data", rs);
		return map;
	}



	/**
	 * 修改订单
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@RequestMapping(value="updateOrder")
	@ResponseBody
	public boolean updataOreder(Order order,Integer rAddressId){
		System.out.println(order);
		System.out.println(rAddressId);
		Integer receivingAddressId = order.getReceivingAddressId();
		order.setReceivingAddressId(rAddressId);
		System.out.println(rAddressId+"======"+receivingAddressId);
		int i = pmOrderService.updataOreder(order);
		return i>0?true:false;
	}
	
	@RequestMapping(value="ddbjaa")
	public String ddbjaa(){
		return "proucrement/updOrder";
	}
	/**
	 * 模糊检索
	 */
	/*@RequestMapping(value = "/get") 
	@ResponseBody
	public Object getJson(String value) {
			List<E>
	       Map<String, Object> map = new HashMap<String,Object>();
	       map.put("name", "dhweicheng");
	       return map;
	}
	*/
}
