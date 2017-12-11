package cn.com.edzleft.service.procurement.bankAccount;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.com.edzleft.entity.BankAccount;

public interface PmBankAccountService {

	List<BankAccount> queryBankAccountByUserId(Integer userId);

	int addBankAcount(BankAccount bankAccount, HttpSession session);

	int cutBankAccountById(Integer id);

	int setbankAccount(Integer id, Integer value, HttpSession session);

}
