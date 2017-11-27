package cn.com.edzleft.dao.procurement.account;

import cn.com.edzleft.entity.Account;
import cn.com.edzleft.entity.SessionInfo;

public interface PmAccountMapper {

	SessionInfo findUserById(Integer userId);

	Account selectByPrimaryKey(Integer userId);

	Integer updateByPrimaryKeySelective(Account acc);

}
