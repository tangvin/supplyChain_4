package cn.com.edzleft.controller.trade.certificate;

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
import cn.com.edzleft.entity.Ukey;
import cn.com.edzleft.service.trade.certificate.TraCertificateService;
import cn.com.edzleft.util.page.DataGridJson;
import cn.com.edzleft.util.page.PageUtil;

/**
 * 
 * @author yhs
 * @日期 2017年11月29日
 */
@Controller
@RequestMapping("/tracertificate")
public class TraCertificateController {
	
	@Autowired
	private TraCertificateService traCertificateService;
	
	/**
	 * ukey与证书
	 * @param pageNumber 开始页数
	 * @param pageSize 每页条数
	 * @param userId 用户id
	 * @param issuedPeople 颁发人
	 * @param ukeyStatus ukey状态
	 * @return
	 */
	@RequestMapping(value = "/ukeyList",method = RequestMethod.POST)
    @ResponseBody
    public DataGridJson ukeyList(HttpSession session,Integer pageNumber,Integer pageSize,String issuedPeople,String ukeyStatus) {
		DataGridJson dgj = new DataGridJson();
		
		PageUtil<Ukey> userPage = new PageUtil<>();
		HashMap<String, Object> whereMaps = new HashMap<>();
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute("sessionInfo");
		Account sessionAccount=sessionInfo.getAdmin();
		Integer userId=sessionAccount.getUserId();
		whereMaps.put("userId", userId);
		whereMaps.put("issuedPeople", issuedPeople);
		whereMaps.put("ukeyStatus", ukeyStatus);
		
		userPage.setCpage(pageNumber);
		userPage.setPageSize(pageSize);
        userPage.setWhereMap(whereMaps);
        
        userPage = traCertificateService.getUkeyEntityListByConditions(userPage);
        
        dgj.setTotal(userPage.getTotalCount());
        dgj.setRows(userPage.getList());
		return dgj;
	}
	
	/**
	 * 根据userId查询ukey、ukey条数
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/getByUserId", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getByUserId(HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute("sessionInfo");
		Account sessionAccount=sessionInfo.getAdmin();
		map =traCertificateService.getByUserId(sessionAccount.getUserId());
		return map;
	}
	
}
