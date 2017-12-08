package cn.com.edzleft.dao.trade.bankAccount;

import cn.com.edzleft.entity.BankAccount;

import java.util.List;

/**
 * Created by ibmtech on 2017/12/6.
 */
public interface BankAccountMapper {

    /**
     * 根据用户id查询出账单的信息
     */
    public List<BankAccount> selectBankAccountByUserId(Integer id);

    /**
     *
     * @param bankAccount
     * @return
     */
    public int insertBankAcount(BankAccount bankAccount);

    /**
     * 根据id删除银行卡
     * @param id
     * @return
     */
    public int deleteBankAccountById(Integer id);

    /**
     * 修改银行卡信息
     * @param bankAccount
     * @return
     */
    public int updatebankAccount(BankAccount bankAccount);


    /**
     * 根据银行卡号查询出银行卡信息
     */
    public BankAccount selectBankAccountByNumber(String number);

}
