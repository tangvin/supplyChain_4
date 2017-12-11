package cn.com.edzleft.service.procurement.tradefinance;

import cn.com.edzleft.entity.TradeFinance;
import cn.com.edzleft.util.page.PageUtil;

public interface PmTradeFinanceService {

	PageUtil<TradeFinance> getTradeEntityList(PageUtil<TradeFinance> userPage);

}
