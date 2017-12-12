package cn.com.edzleft.dao.procurement.homepage;

import cn.com.edzleft.entity.Information;

public interface PmHomePageMapper {

	Information homePageSelect(Integer userId);

	int updateInformation(Information information);

	int addInformation(Information information);

	

}
