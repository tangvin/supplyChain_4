package cn.com.edzleft.controller.procurement.oder;

import cn.com.edzleft.entity.Contract;

import cn.com.edzleft.entity.Information;
import cn.com.edzleft.entity.Order;
import cn.com.edzleft.entity.ReceivingAddress;
import cn.com.edzleft.entity.SessionInfo;
import cn.com.edzleft.service.procurement.contractaward.PmContractWardService;
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

	@Autowired
	private PmOrderService pmOrderService;
	@Autowired
	private PmReceivingAddressService pmreceivingAddressservice;
	
	@Autowired
	private PmContractWardService pmContractWardService;
	
	@Autowired
	private PmHomePageService pmHomePageService;
	/**
	 * 查询订单列表
	 */
	@RequestMapping(value="/pmgetorder")
	@ResponseBody
	public DataGridJson letterSelect(String username,String fName,Integer aa,String orderCreatTime,String orderConfirmationTime,Integer pageNumber,Integer pageSize ,String entname,String orderStatus,String creditGrantor,HttpSession sessionInfo){
		SessionInfo session = (SessionInfo) sessionInfo.getAttribute("sessionInfo");
        Integer userId = session.getAdmin().getInformationId();
		PageUtil<Order> userPage = new PageUtil<>();
        HashMap<String,Object> whereMaps =new HashMap<>();
        whereMaps.put("entname",entname);
        whereMaps.put("orderStatus",orderStatus);
        whereMaps.put("fName",fName);
        whereMaps.put("username",username);
        whereMaps.put("creditGrantor",creditGrantor);
        whereMaps.put("userId",userId);
        whereMaps.put("orderConfirmationTime",orderConfirmationTime);
        whereMaps.put("orderCreatTime",orderCreatTime);
        whereMaps.put("aa",aa);
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
	public Map<String,Object> confirmOder(HttpServletRequest req,HttpSession sessionInfo){
		Map<String,Object> map = new HashMap<>();
		String telephone = req.getParameter("telephone");
		String receiver = req.getParameter("receiver");
		String receivingAddressId = req.getParameter("receivingAddressId");
		String orderAmount = req.getParameter("orderAmount");
		String principalOrderId = req.getParameter("principalOrderId");
		String applicationletter = req.getParameter("applicationletter");
		String goods = req.getParameter("goods");
		//根据关联合同查询合同
		Contract contract = pmContractWardService.getContract(principalOrderId);
		if(contract == null){
			map.put("msg", "合同名称错误");
			map.put("success", false);
		}else{
			Order o=new Order();
			o.setContactPhone(telephone);
			o.setPrincipalOrderId(contract.getContractId());
			o.setOrderCreatorTradeId(contract.getContractTraderId());
			o.setLogisticsName(receiver);
			o.setReceivingAddressId(Integer.parseInt(receivingAddressId));
			o.setOrderAmount(Double.parseDouble(orderAmount));
			o.setApplicationletter(applicationletter);
			o.setGoods(goods);
			o.setOrderStatus(0);
			SessionInfo sessionInfo1 = (SessionInfo) sessionInfo.getAttribute("sessionInfo");
			o.setOrderCreatorId(sessionInfo1.getAdmin().getInformationId());
			o.setOrderCreatTime(new Date());
			o.setOrderCreatorUserId(sessionInfo1.getAdmin().getUserId());
			int i = pmOrderService.insertSelective(o, sessionInfo);
			map.put("msg", "添加成功");
			map.put("success", true);
		}
		return map;
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
	@RequestMapping(value="addresshx",method ={RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public Map<String,Object> hxbj(HttpServletResponse response,HttpServletRequest request,HttpSession sessionInfo){
		/*跨域访问*/
		response.setContentType("text/plain");
		response.setHeader("Pragma", "No-cache");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setHeader("Access-Control-Allow-Origin", "*");//添加跨域访问
		SessionInfo session = (SessionInfo) sessionInfo.getAttribute("sessionInfo");
        Integer userId = session.getAdmin().getUserId();
		Map<String,Object> map = new HashMap<>();
		List<ReceivingAddress> rs = pmreceivingAddressservice.selectByPrimaryKey(userId);
		map.put("data", rs);
		return map;
	}



	/**
	 * 修改订单
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@RequestMapping(value="updateOrder",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> updataOreder(Order order,Integer rAddressId){
		Map<String,Object> map = new HashMap<>();
		System.out.println(order);
		System.out.println(rAddressId);
		Integer receivingAddressId = order.getReceivingAddressId();
		order.setReceivingAddressId(rAddressId);
		System.out.println(rAddressId+"======"+receivingAddressId);
		int i = pmOrderService.updataOreder(order);
		if(i>0){
			map.put("success", true);
			map.put("msg", "修改成功");
		}else{
			map.put("success", false);
			map.put("msg", "修改失败");
		}
		return map;
	}
	
	@RequestMapping(value="ddbjaa")
	public String ddbjaa(){
		return "proucrement/updOrder";
	}
	/**
	 * 模糊检索
	 */
	@RequestMapping(value = "/getMohujs",method= {RequestMethod.POST,RequestMethod.GET} ) 
	@ResponseBody
	public Map<String,Object>  getInfor(HttpServletResponse response,HttpServletRequest request,Integer entIdentity){
		response.setContentType("text/plain");
		response.setHeader("Pragma", "No-cache");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setHeader("Access-Control-Allow-Origin", "*");//添加跨域访问
		String jsonpCallback = request.getParameter("jsonpCallback");
		Map<String,Object> map = new HashMap<>();
		List<Information> infor = pmHomePageService.getInfor(entIdentity);
		map.put("data", infor);
		return map;
	}
	/**
	 * 根据ID查询对应的合同
	 * 
	 */
	@RequestMapping(value = "/getInforIdContract",method = {RequestMethod.POST,RequestMethod.GET}) 
	@ResponseBody
	public DataGridJson   getInforIdContract(HttpServletResponse response,HttpServletRequest request,String aid,HttpSession sessionInfo,Integer pageNumber,Integer pageSize,String creatTime,String endTime ){
		response.setContentType("text/plain");
		response.setHeader("Pragma", "No-cache");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setHeader("Access-Control-Allow-Origin", "*");//添加跨域访问
		String jsonpCallback = request.getParameter("jsonpCallback");
		PageUtil<Contract> userPage = new PageUtil<>();
		DataGridJson dj = new DataGridJson();
		SessionInfo session = (SessionInfo) sessionInfo.getAttribute("sessionInfo");
        Integer userId = session.getAdmin().getInformationId();
        Integer cid = Integer.valueOf(request.getParameter("aid"));
        HashMap<String,Object> whereMaps =new HashMap<>();
        whereMaps.put("cid", cid);
        whereMaps.put("userId", userId);
        whereMaps.put("creatTime", creatTime);
        whereMaps.put("endTime", endTime);
        userPage.setCpage(pageNumber);
        userPage.setPageSize(pageSize);
        userPage.setWhereMap(whereMaps);
        userPage = pmContractWardService.getInforIdContract(userPage);
		//map.put("data", contract);
		dj.setTotal(userPage.getTotalCount());
		dj.setRows(userPage.getList());
		return dj;
	}
}
