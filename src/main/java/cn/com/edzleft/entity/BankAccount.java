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
    private String bankAccountNumber;
    /**
     * 银行账户表之创建时间
     */
    private Date bankAccountCreateTime;
    /**
     * 银行账户表之创建人
     */
    private String bankAccountCreatePeople;

    /**
     * 用户id
     * @return
     */
    private  Integer userId;

    /**
     * 是否设置默认
     * @return
     */
    private  Integer defaultId;

    public Integer getDefaultId() {
        return defaultId;
    }

    public void setDefaultId(Integer defaultId) {
        this.defaultId = defaultId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

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

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
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
        if (userId != null ? !userId.equals(that.userId) : that.userId != null)
            return false;
        if (defaultId != null ? !defaultId.equals(that.defaultId) : that.defaultId != null)
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
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (defaultId != null ? defaultId.hashCode() : 0);
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
                ", userId='" + userId + '\'' +
                ", defaultId='" + defaultId + '\'' +
                '}';
    }
}