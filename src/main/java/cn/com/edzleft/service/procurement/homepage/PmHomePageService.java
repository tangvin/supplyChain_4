package cn.com.edzleft.service.procurement.homepage;

import javax.servlet.http.HttpSession;

import cn.com.edzleft.entity.Information;
import cn.com.edzleft.entity.Order;

public interface PmHomePageService {

	Information homePageSelect(Integer userId);

	Order selectByPrimaryKey(String value);

	int updateInformation(Information information);

	Information selectByCreatorId(Integer userId);

	int insertSelective(Information information, HttpSession sessionInfo);
	

}
