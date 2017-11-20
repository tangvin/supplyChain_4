package cn.com.edzleft.dao.trade.homepage;

import cn.com.edzleft.entity.Account;
import org.springframework.stereotype.Repository;

/**
 * Created by ibmtech on 2017/11/16.
 */

public interface AccountMapper {

    /**
     * 根据账号查询用户信息
     */

    public Account findAccountByName(String  userName);


    /**
     *  添加一个用户账号信息
     */
    public void insertAccount(Account account);

}
