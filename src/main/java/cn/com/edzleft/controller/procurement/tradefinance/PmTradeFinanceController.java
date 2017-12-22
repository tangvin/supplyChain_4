package cn.com.edzleft.controller.procurement.tradefinance;

import java.util.HashMap;


import cn.com.edzleft.entity.TradeFinancial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.edzleft.entity.TradeFinancial;
import cn.com.edzleft.service.procurement.tradefinance.PmTradeFinanceService;
import cn.com.edzleft.util.page.DataGridJson;
import cn.com.edzleft.util.page.PageUtil;

@Controller
@RequestMapping("/tradefinance")


/**
 * 财务管理列表展示
 * @author Administrator
 *
 */
public class PmTradeFinanceController {
	
	@Autowired
	private PmTradeFinanceService tradeFinanceService;

	@RequestMapping(value="/pmtradefinance")
	@ResponseBody
	public DataGridJson selectTrade(Integer pageNumber,Integer pageSize,String financialType,String billTime,String payer,String bankcardaccount){
		PageUtil<TradeFinancial> userPage = new PageUtil<>();
		HashMap<String, Object> wheremap = new HashMap<>();
		wheremap.put("financialType", financialType);
		wheremap.put("billTime", billTime);
		wheremap.put("payer", payer);
		wheremap.put("bankcardaccount", bankcardaccount);
		DataGridJson dgj = new DataGridJson();
		userPage.setCpage(pageNumber);
		userPage.setPageSize(pageSize);
		userPage.setWhereMap(wheremap);
		userPage = tradeFinanceService.getTradeEntityList(userPage);
        dgj.setTotal(userPage.getTotalCount());
        dgj.setRows(userPage.getList());
        return dgj;
	}
}
