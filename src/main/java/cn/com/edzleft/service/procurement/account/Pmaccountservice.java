package cn.com.edzleft.service.procurement.account;

import cn.com.edzleft.entity.SessionInfo;

public interface Pmaccountservice {

	SessionInfo findUserById(Integer userId);

	String updataPwd(Integer userId, String oldpwd, String newpwd, String confirm);

}
