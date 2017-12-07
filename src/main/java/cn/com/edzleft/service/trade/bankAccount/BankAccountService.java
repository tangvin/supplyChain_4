package cn.com.edzleft.service.trade.bankAccount;

import cn.com.edzleft.entity.BankAccount;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by ibmtech on 2017/12/6.
 */
public interface BankAccountService {

    /**
     * 根据用户id查询出银行卡的信息
     */
    public List<BankAccount> queryBankAccountByUserId(Integer id);

    /**
     *添加银行卡
     * @param bankAccount
     * @return
     */
    public int addBankAcount(BankAccount bankAccount, HttpSession session);

    /**
     * 根据id删除银行卡
     * @param id
     * @return
     */
    public int cutBankAccountById(Integer id);

    /**
     * 修改银行卡信息
     * @param
     * @return
     */
    public int setbankAccount(Integer id,Integer value,HttpSession session);
}
