package cn.com.edzleft.service.procurement.bankAccount;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.com.edzleft.entity.Account;
import cn.com.edzleft.entity.BankAccount;

public interface PmBankAccountService {

	List<BankAccount> queryBankAccountByUserId(Integer userId);

	int addBankAcount(BankAccount bankAccount, HttpSession session);

	int cutBankAccountById(Integer id);

	int setbankAccount(Integer id, Integer value, HttpSession session);

	/*根据id查询账户信息*/
	Account queryAcountById(Integer userId);
	
	 //根据银行卡查询出当前绑定的手机号
    public  BankAccount queryBankAccountByNumber(String num);

}
