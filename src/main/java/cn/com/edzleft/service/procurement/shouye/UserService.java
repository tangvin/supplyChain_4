package cn.com.edzleft.service.procurement.shouye;

import cn.com.edzleft.entity.SessionInfo;

public interface UserService {

	SessionInfo findUserById(Integer userId);

	String updataPwd(Integer userId, String oldpwd, String newpwd, String confirm);

}
