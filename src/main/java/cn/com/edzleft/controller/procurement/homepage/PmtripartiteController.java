package cn.com.edzleft.controller.procurement.homepage;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.edzleft.entity.Tripartite;
import cn.com.edzleft.service.procurement.tripartite.PmtripartiteService;
import cn.com.edzleft.util.page.DataGridJson;
import cn.com.edzleft.util.page.PageUtil;

@Controller
@RequestMapping("/tripartite")
public class PmtripartiteController {

	@Autowired
	private PmtripartiteService pmtripartiteService;
	@RequestMapping(value="pmtripartite")
	@ResponseBody
    public DataGridJson letterSelect(Integer pageNumber,Integer pageSize ,String tripartiteDepositBank,String tripartiteCreditHolderPurchaser){
        PageUtil<Tripartite> userPage = new PageUtil<>();
        HashMap<String,Object> whereMaps =new HashMap<>();
        whereMaps.put("tripartiteDepositBank",tripartiteDepositBank);
        whereMaps.put("tripartiteCreditHolderPurchaser",tripartiteCreditHolderPurchaser);
        DataGridJson dgj = new DataGridJson();
        userPage.setCpage(pageNumber);
        userPage.setPageSize(pageSize);
        userPage.setWhereMap(whereMaps);
        userPage = pmtripartiteService.getOrderList(userPage);
        dgj.setTotal(userPage.getTotalCount());
        dgj.setRows(userPage.getList());
        return dgj;
    } 
}
