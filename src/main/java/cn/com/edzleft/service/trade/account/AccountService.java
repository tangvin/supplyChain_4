package cn.com.edzleft.service.trade.account;

import cn.com.edzleft.entity.Account;

/**
 * Created by ibmtech on 2017/11/16.
 */
public interface AccountService {

    //根据账号查询
    public  Account queryAccountByName(String userName);

    //新增一个账号信息
    public void addAccount(Account account);
}
