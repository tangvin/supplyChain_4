package cn.com.edzleft.dao.procurement.shouye;

import cn.com.edzleft.entity.Account;
import cn.com.edzleft.entity.SessionInfo;

public interface UserMapper {

	SessionInfo findUserById();

	Account selectByPrimaryKey(Integer userId);

	Integer updateByPrimaryKeySelective(Account acc);

}
