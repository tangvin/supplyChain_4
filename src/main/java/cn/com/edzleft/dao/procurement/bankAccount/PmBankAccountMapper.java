package cn.com.edzleft.dao.procurement.bankAccount;

import java.util.List;

import cn.com.edzleft.entity.BankAccount;

public interface PmBankAccountMapper {

	List<BankAccount> selectBankAccountByUserId(Integer id);

	int updatebankAccount(BankAccount account);

	int insertBankAcount(BankAccount bankAccount);

	int deleteBankAccountById(Integer id);

}
