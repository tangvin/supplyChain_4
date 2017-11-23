package cn.com.edzleft.util;

import cn.com.edzleft.dao.trade.homepage.AccountMapper;
import cn.com.edzleft.entity.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ibmtech on 2017/11/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:config/applicationContext.xml")
public class AccountTest {

    @Autowired
    private AccountMapper accountMapper;

    /**
     * 根据账号查询
     */
    @Test
    public void getAccountByName(){
        Account a = new Account();
        a.setUserName("zhangsan");
        Account account = accountMapper.findAccountByName("zhangsan");
            String user_name=account.getUserName();
            String user_pwd=account.getUserPwd();
        Integer accountType = account.getAccountType();
        System.out.println(account);
        //System.out.println(user_name+" "+user_pwd+"            "+accountType);
    }


    /**
     * 添加一个Account
     */
    @Test
    public void insertAccount(){
        Account a = new Account();
        a.setUserName("zhang1");
        a.setUserPwd("123");
        a.setAccountType(1);
        accountMapper.insertAccount(a);
        System.out.println("添加账户~~~ok");
    }

}
