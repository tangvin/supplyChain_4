package cn.com.edzleft.service.trade.account;

import cn.com.edzleft.dao.trade.homepage.AccountMapper;
import cn.com.edzleft.entity.Account;
import cn.com.edzleft.entity.BankAccount;
import cn.com.edzleft.util.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.util.Date;

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
     * @param userName
     * @return
     */
    public Account queryAccountByName(String userName) {
        Account a = accountMapper.findAccountByName(userName);
        InetAddress ia=null;
        try {
            ia=ia.getLocalHost();

            String localname=ia.getHostName();
            String localip=ia.getHostAddress();
            System.out.println("本机名称是："+ localname);
            System.out.println("本机的ip是 ："+localip);
            a.setLoginIp(localip);
            a.setLoginTime(new Date());

            accountMapper.updateMessage(a);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

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
                    int t = accountMapper.updateMessage(account);
                    if(t==1){
                        return new ResultBean(1,"修改成功");
                    }
                }
            }else {
                    return new ResultBean(-1,"密码输入错误");
            }
                     return new ResultBean(-1,"请重新登录");
    }

    /*根据id查询账号信息*/
    public Account queryAcountById(Integer id){
        Account a = accountMapper.selectAccountById(id);
        return a;
    }

	@Override
	public Integer findByName(String userName) {
		return accountMapper.findByName(userName);
	}

	@Override
	public Integer insert(Account account) {
		return accountMapper.insert(account);
	}
}
