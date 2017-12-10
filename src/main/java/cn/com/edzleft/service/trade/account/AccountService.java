package cn.com.edzleft.service.trade.account;

import cn.com.edzleft.entity.Account;
import cn.com.edzleft.entity.BankAccount;
import cn.com.edzleft.util.ResultBean;

import javax.servlet.http.HttpSession;

/**
 * Created by ibmtech on 2017/11/16.
 */
public interface AccountService {

    //根据账号查询
    public  Account queryAccountByName(String userName);

    //新增一个账号信息
    public void addAccount(Account account);

    //修改账户密码
    public ResultBean updatePassword(HttpSession session, String oldPwd, String newPwd,String confirmPwd);


    //根据id 查看账户信息
    public Account queryAcountById(Integer id);

}
