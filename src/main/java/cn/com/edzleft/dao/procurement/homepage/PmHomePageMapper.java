package cn.com.edzleft.dao.procurement.homepage;

import java.util.List;

import cn.com.edzleft.entity.Information;

public interface PmHomePageMapper {

	Information homePageSelect(Integer userId);

	int updateInformation(Information information);

	int insertSelective(Information information);

	Information selectByCreatorId(Integer userId);

	List<Information> getInfor(Integer entIdentity);

	Information getInformationName(Integer userId);

	

}
