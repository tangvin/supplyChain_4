package cn.com.edzleft.service.procurement.homepage;

import cn.com.edzleft.entity.Information;
import cn.com.edzleft.entity.Order;

public interface PmHomePageService {

	Information homePageSelect(Integer userId);

	Order selectByPrimaryKey(String value);

	int updateInformation(Information information);


}
