package cn.com.edzleft.dao.trade.homepage;

import cn.com.edzleft.entity.Account;

public interface RegisterMapper {
	int insert(Account account);
	int count(String userName);
}
