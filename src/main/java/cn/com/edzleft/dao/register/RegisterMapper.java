package cn.com.edzleft.dao.register;

import cn.com.edzleft.entity.Account;

public interface RegisterMapper {
	int insert(Account account);
	int count(String userName);
}
