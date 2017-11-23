package cn.com.edzleft.service.trade.account;

import cn.com.edzleft.dao.trade.homepage.AccountMapper;
import cn.com.edzleft.entity.Account;
import cn.com.edzleft.util.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

/**
 * Created by ibmtech on 2017/11/16.
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;


    /**
     * 根据账号(userName)查询账户信息
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


    /**
     * 修改账户密码
     * @param session
     * @param oldPwd
     * @param newPwd
     * @param confirmPwd
     * @return
     */
    @Override
    public ResultBean updatePassword(HttpSession session, String oldPwd, String newPwd,String confirmPwd) {
        cn.com.edzleft.entity.SessionInfo sessionInfo=(cn.com.edzleft.entity.SessionInfo) session.getAttribute("sessionInfo");
            if(sessionInfo!=null){
                String queryPwd = sessionInfo.getAdmin().getUserPwd();
                if(queryPwd.equals(oldPwd) && newPwd.equals(confirmPwd)) {
                    Account account = new Account();
                    account.setUserPwd(newPwd);
                    int t = accountMapper.updatePassword(account);
                    if(t==1){
                        return new ResultBean(1,"修改成功");
                    }
                }
            }else {
                    return new ResultBean(-1,"密码输入错误");
            }
                     return new ResultBean(-1,"请重新登录");
    }
}
