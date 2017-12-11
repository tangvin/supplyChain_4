package cn.com.edzleft.service.procurement.tradefinance;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.edzleft.dao.procurement.tradefinance.PmTradeFinanceMapper;
import cn.com.edzleft.entity.TradeFinance;
import cn.com.edzleft.util.page.PageUtil;

@Service
public class PmTradeFinanceServiceImpl implements PmTradeFinanceService{

	@Autowired
	private PmTradeFinanceMapper tradeFinanceMapper;

	@Override
	public PageUtil<TradeFinance> getTradeEntityList(PageUtil<TradeFinance> userPage) {
		//查询总条数
        int totalCount = tradeFinanceMapper.getTradeEntityCounts(userPage);
        //查询集合
        List<TradeFinance> userList = tradeFinanceMapper.getTradeEntityList(userPage);
        userPage.setTotalCount(totalCount);
        userPage.setList(userList);
        return userPage;
	}
	
	
}
