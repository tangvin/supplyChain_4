package cn.com.edzleft.dao.procurement.tradefinance;

import java.util.List;

import cn.com.edzleft.entity.TradeFinancial;
import cn.com.edzleft.util.page.PageUtil;

public interface PmTradeFinanceMapper {

	int getTradeEntityCounts(PageUtil<TradeFinancial> userPage);

	List<TradeFinancial> getTradeEntityList(PageUtil<TradeFinancial> userPage);

}
