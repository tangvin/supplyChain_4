package cn.com.edzleft.service.procurement.tradefinance;

import cn.com.edzleft.entity.TradeFinancial;
import cn.com.edzleft.entity.TradeFinancial;
import cn.com.edzleft.util.page.PageUtil;

public interface PmTradeFinanceService {

	PageUtil<TradeFinancial> getTradeEntityList(PageUtil<TradeFinancial> userPage);

}
