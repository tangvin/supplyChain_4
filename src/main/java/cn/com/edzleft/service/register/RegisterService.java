package cn.com.edzleft.service.register;

import cn.com.edzleft.entity.Account;

public interface RegisterService {
	int insert(Account account);
	int count(String userName);
}
