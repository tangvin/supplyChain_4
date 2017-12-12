package cn.com.edzleft.service.procurement.account;

import cn.com.edzleft.entity.Account;
import cn.com.edzleft.entity.SessionInfo;

import java.util.Date;

public interface Pmaccountservice {

	SessionInfo findUserById(Integer userId);

	String updataPwd(Integer userId,String newpwd, String confirm,String senCode,String code,Date creatDate);

	Account accountSelect(Integer userId);

	int updatePassword(Account account);



}
