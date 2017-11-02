package cn.com.edzleft.entity;

import java.util.Date;

/**银行账户表
 * gyl_bank_account
 */
public class BankAccount {
    /**
     * 银行账户表之id
     */
    private Integer bankAccountId;
    /**
     * 银行账户表之开户行
     */
    private String bankAccountDepositBank;
    /**
     * 银行账户表之户主
     */
    private String bankAccountCreditHolder;
    /**
     * 银行账户表之账号
     */
    private Integer bankAccountNumber;
    /**
     * 银行账户表之创建时间
     */
    private Date bankAccountCreateTime;
    /**
     * 银行账户表之创建人
     */
    private String bankAccountCreatePeople;

    public Integer getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(Integer bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public String getBankAccountDepositBank() {
        return bankAccountDepositBank;
    }

    public void setBankAccountDepositBank(String bankAccountDepositBank) {
        this.bankAccountDepositBank = bankAccountDepositBank == null ? null : bankAccountDepositBank.trim();
    }

    public String getBankAccountCreditHolder() {
        return bankAccountCreditHolder;
    }

    public void setBankAccountCreditHolder(String bankAccountCreditHolder) {
        this.bankAccountCreditHolder = bankAccountCreditHolder == null ? null : bankAccountCreditHolder.trim();
    }

    public Integer getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(Integer bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public Date getBankAccountCreateTime() {
        return bankAccountCreateTime;
    }

    public void setBankAccountCreateTime(Date bankAccountCreateTime) {
        this.bankAccountCreateTime = bankAccountCreateTime;
    }

    public String getBankAccountCreatePeople() {
        return bankAccountCreatePeople;
    }

    public void setBankAccountCreatePeople(String bankAccountCreatePeople) {
        this.bankAccountCreatePeople = bankAccountCreatePeople == null ? null : bankAccountCreatePeople.trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankAccount that = (BankAccount) o;

        if (bankAccountId != null ? !bankAccountId.equals(that.bankAccountId) : that.bankAccountId != null)
            return false;
        if (bankAccountDepositBank != null ? !bankAccountDepositBank.equals(that.bankAccountDepositBank) : that.bankAccountDepositBank != null)
            return false;
        if (bankAccountCreditHolder != null ? !bankAccountCreditHolder.equals(that.bankAccountCreditHolder) : that.bankAccountCreditHolder != null)
            return false;
        if (bankAccountNumber != null ? !bankAccountNumber.equals(that.bankAccountNumber) : that.bankAccountNumber != null)
            return false;
        if (bankAccountCreateTime != null ? !bankAccountCreateTime.equals(that.bankAccountCreateTime) : that.bankAccountCreateTime != null)
            return false;
        return bankAccountCreatePeople != null ? bankAccountCreatePeople.equals(that.bankAccountCreatePeople) : that.bankAccountCreatePeople == null;
    }

    @Override
    public int hashCode() {
        int result = bankAccountId != null ? bankAccountId.hashCode() : 0;
        result = 31 * result + (bankAccountDepositBank != null ? bankAccountDepositBank.hashCode() : 0);
        result = 31 * result + (bankAccountCreditHolder != null ? bankAccountCreditHolder.hashCode() : 0);
        result = 31 * result + (bankAccountNumber != null ? bankAccountNumber.hashCode() : 0);
        result = 31 * result + (bankAccountCreateTime != null ? bankAccountCreateTime.hashCode() : 0);
        result = 31 * result + (bankAccountCreatePeople != null ? bankAccountCreatePeople.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "bankAccountId=" + bankAccountId +
                ", bankAccountDepositBank='" + bankAccountDepositBank + '\'' +
                ", bankAccountCreditHolder='" + bankAccountCreditHolder + '\'' +
                ", bankAccountNumber=" + bankAccountNumber +
                ", bankAccountCreateTime=" + bankAccountCreateTime +
                ", bankAccountCreatePeople='" + bankAccountCreatePeople + '\'' +
                '}';
    }
}