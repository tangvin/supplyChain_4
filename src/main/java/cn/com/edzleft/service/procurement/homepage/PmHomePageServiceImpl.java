package cn.com.edzleft.service.procurement.homepage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.edzleft.dao.procurement.homepage.PmHomePageMapper;
import cn.com.edzleft.dao.procurement.oder.PmOrderMapper;
import cn.com.edzleft.entity.Account;
import cn.com.edzleft.entity.Information;
import cn.com.edzleft.entity.Order;

@Service
public class PmHomePageServiceImpl implements PmHomePageService{

	@Autowired
	private PmHomePageMapper pmHomePageMapper;
	
	@Autowired
	private PmOrderMapper pmOrderMapper;

	@Override
	public Information homePageSelect(Integer userId) {
		return pmHomePageMapper.homePageSelect(userId);
	}
	/**
	 * 订单查看
	 */
	@Override
	public Order selectByPrimaryKey(String value) {
		// TODO Auto-generated method stub
		return pmOrderMapper.selectOrder(value);
	}
	/**
	 * 确认修改基础资料
	 */
	@Override
	public int updateInformation(Information information) {
		int i =pmHomePageMapper.updateInformation(information);
		return i;
	}

}
