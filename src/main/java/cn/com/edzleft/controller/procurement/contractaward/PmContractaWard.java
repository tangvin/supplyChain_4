package cn.com.edzleft.controller.procurement.contractaward;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.edzleft.entity.Account;
import cn.com.edzleft.entity.Contract;
import cn.com.edzleft.entity.SessionInfo;
import cn.com.edzleft.service.procurement.contractaward.PmContractWardService;
import cn.com.edzleft.util.page.DataGridJson;
import cn.com.edzleft.util.page.PageUtil;

@Controller
@RequestMapping("/pmcontract")
public class PmContractaWard {

	/**
	 * 查询合同列表
	 */
	@Autowired
	private PmContractWardService pmContractWardService;
	@RequestMapping(value = "/contractShow",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public DataGridJson queryByPage(HttpServletRequest request, HttpServletResponse response, Integer pageNumber, Integer pageSize , String contractStatus, String creatTime, String endTime, String buyerSigning, HttpSession session){
	        //远程调用
	        response.setContentType("text/plain");
	        response.setHeader("Pragma", "No-cache");
	        response.setCharacterEncoding("UTF-8");
	        response.setHeader("Cache-Control", "no-cache");
	        response.setDateHeader("Expires", 0);
	        response.setHeader("Access-Control-Allow-Origin", "*");//添加跨域访问
	        String jsonpCallback = request.getParameter("jsonpCallback");

	        PageUtil<Contract> pageUtil = new PageUtil<>();
	        HashMap<String,Object> whereMaps =new HashMap<>();

	        whereMaps.put("contractStatus",contractStatus);
	        whereMaps.put("creatTime",creatTime);
	        whereMaps.put("endTime",endTime);
	        whereMaps.put("buyerSigning",buyerSigning);

	        SessionInfo sessionInfo = (SessionInfo) session.getAttribute("sessionInfo");
	        Account sessionAccount=sessionInfo.getAdmin();

	        DataGridJson dgj = new DataGridJson();
	        pageUtil.setCpage(pageNumber);
	        pageUtil.setPageSize(pageSize);
	        pageUtil.setWhereMap(whereMaps);

	        pageUtil=pmContractWardService.queryAllContract(pageUtil);
	        dgj.setTotal(pageUtil.getTotalCount());
	        dgj.setRows(pageUtil.getList());
	        return dgj;
	    }
}
