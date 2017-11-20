package cn.com.edzleft.service.trade.account;

import cn.com.edzleft.dao.trade.homepage.AccountMapper;
import cn.com.edzleft.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ibmtech on 2017/11/16.
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;


    /**
     * 根据账号查询账户信息
     * @param account
     * @return
     */
    public Account queryAccountByName(String userName) {
        Account a = accountMapper.findAccountByName(userName);
        return a;
    }

    /**
     * 新增一个账号
     * @param account
     */
    @Override
    public void addAccount(Account account) {
        accountMapper.insertAccount(account);

    }
}
