package cn.com.edzleft.service.trade.bankAccount;

import cn.com.edzleft.dao.trade.bankAccount.BankAccountMapper;
import cn.com.edzleft.entity.BankAccount;
import cn.com.edzleft.entity.SessionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.print.BackgroundLookupListener;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by ibmtech on 2017/12/6.
 */
@Service
@Transactional
public class BankAccountServiceImpl implements BankAccountService {
    @Autowired
    private BankAccountMapper bankAccountMapper;

    /**
     * 查询当前用户的所有的银行卡
     * @param id
     * @return
     */
    @Override
    public List<BankAccount> queryBankAccountByUserId(Integer id) {
        List<BankAccount> bankAccounts = bankAccountMapper.selectBankAccountByUserId(id);
        return bankAccounts;
    }

    /**
     * 添加银行账户+设置默认
     * @param bankAccount
     * @return
     */
    @Override
    public int addBankAcount(BankAccount bankAccount,HttpSession session) {
        //获取当前登录的用户id
        SessionInfo sessions = (SessionInfo) session.getAttribute("sessionInfo");
        Integer userId = sessions.getAdmin().getUserId();
        //根据id查询出所有的银行卡
        List<BankAccount> bankAccounts = bankAccountMapper.selectBankAccountByUserId(userId);
        //判断当前的银行卡是否设置了默认
        if(bankAccount.getDefaultId()==1){
            //将设置为默认的银行卡取消默认
            for (BankAccount account : bankAccounts) {
                if(account.getDefaultId() == 1){
                    account.setDefaultId(0);
                    bankAccountMapper.updatebankAccount(account);
                }
            }
        }
        bankAccount.setUserId(userId);
        int i = bankAccountMapper.insertBankAcount(bankAccount);
        return i;
    }

    /**
     * 根据id删除银行卡
     * @param id
     * @return
     */
    @Override
    public int cutBankAccountById(Integer id) {
        int i = bankAccountMapper.deleteBankAccountById(id);
        return i;
    }


    /**
     * 设置默认银行卡
     * @param id
     * @param session
     * @param value
     * @return
     */
    @Override
    public int setbankAccount(Integer id,HttpSession session,Integer value) {
        SessionInfo sessions = (SessionInfo) session.getAttribute("sessionInfo");
        Integer userId = sessions.getAdmin().getUserId();
        //查询出为默认地址的所有货运单位
        List<BankAccount> list = bankAccountMapper.selectBankAccountByUserId(userId);
        //判断是否为默认地址
        if(value == 1){
            //将当前所有默认地址修改为不默认
            for (BankAccount acc : list) {
                if(acc.getDefaultId() == 1){
                    acc.setDefaultId(0);
                    bankAccountMapper.updatebankAccount(acc);
                }
            }
        }
        //设置当前操作的银行卡为默认卡
        BankAccount bankAcc = new BankAccount();
        bankAcc.setUserId(id);
        bankAcc.setDefaultId(value);
        int i = bankAccountMapper.updatebankAccount(bankAcc);
        return i;
    }
}
