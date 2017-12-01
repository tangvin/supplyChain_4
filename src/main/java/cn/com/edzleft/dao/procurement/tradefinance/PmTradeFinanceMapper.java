package cn.com.edzleft.dao.procurement.tradefinance;

import java.util.List;

import cn.com.edzleft.entity.TradeFinance;
import cn.com.edzleft.util.page.PageUtil;

public interface PmTradeFinanceMapper {

	int getTradeEntityCounts(PageUtil<TradeFinance> userPage);

	List<TradeFinance> getTradeEntityList(PageUtil<TradeFinance> userPage);

}
