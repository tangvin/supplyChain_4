package cn.com.edzleft.service.procurement.homepage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.edzleft.dao.procurement.homepage.PmHomePageMapper;
import cn.com.edzleft.entity.Account;
import cn.com.edzleft.entity.Information;

@Service
public class PmHomePageServiceImpl implements PmHomePageService{

	@Autowired
	private PmHomePageMapper pmHomePageMapper;

	@Override
	public Information homePageSelect(Integer userId) {
		return pmHomePageMapper.homePageSelect(userId);
	}

}
