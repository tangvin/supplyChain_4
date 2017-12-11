package cn.com.edzleft.controller.procurement.homepage;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.edzleft.entity.Account;
import cn.com.edzleft.entity.SessionInfo;
import cn.com.edzleft.entity.Tripartite;
import cn.com.edzleft.service.procurement.tripartite.PmtripartiteService;
import cn.com.edzleft.util.page.DataGridJson;
import cn.com.edzleft.util.page.PageUtil;
/**
 * 三方账户列表查询
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/tripartite")
public class PmtripartiteController {

	@Autowired
	private PmtripartiteService pmtripartiteService;
	@RequestMapping(value="pmtripartite" ,method=RequestMethod.POST)
	@ResponseBody
    public DataGridJson letterSelect(Integer pageNumber,Integer pageSize ,String caEntName,String trEntName,HttpSession session){
		DataGridJson dgj = new DataGridJson();
		PageUtil<Tripartite> userPage = new PageUtil<>();
        HashMap<String,Object> whereMaps =new HashMap<>();
        /*从session获取当前用户的信息*/
        SessionInfo sessionInfo = (SessionInfo) session.getAttribute("sessionInfo");
        Account sessionAccount=sessionInfo.getAdmin();
        Integer userId = sessionAccount.getUserId();
        System.out.println(sessionAccount);
        whereMaps.put("caEntName",caEntName);
        whereMaps.put("trEntName",trEntName);
        whereMaps.put("userId",userId);
       System.out.println("=========="+caEntName);
       System.out.println("=========="+trEntName);
       
        userPage.setCpage(pageNumber);
        userPage.setPageSize(pageSize);
        userPage.setWhereMap(whereMaps);
        userPage = pmtripartiteService.getOrderList(userPage);
        dgj.setTotal(userPage.getTotalCount());
        dgj.setRows(userPage.getList());
        return dgj;
    } 
}
