package cn.com.edzleft.service.procurement.homepage;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.com.edzleft.entity.Information;
import cn.com.edzleft.entity.Order;

public interface PmHomePageService {

	Information homePageSelect(Integer userId);

	Order selectByPrimaryKey(String value);

	int updateInformation(Information information);

	Information selectByCreatorId(Integer userId);

	int insertSelective(Information information, HttpSession sessionInfo);

	List<Information> getInfor(Integer entIdentity);

	//根据当前用户的id查到公司名称
	Information getInformationName(Integer userId);
	

}
