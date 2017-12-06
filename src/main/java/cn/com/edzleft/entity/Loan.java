package cn.com.edzleft.entity;

import java.io.Serializable;
import java.util.Date;

public class Loan implements Serializable{
    private static final long serialVersionUID = 8467910966277424430L;
    /**
     * 贷款表主键
     */
    private Integer loanId;
    /**
     * 贷款编号
     */
    private Integer loanNumber;
    /**
     * 贷款方
     */
    private String lender;
    /**
     * 授信主合同编号
     */
    private String creditMasterContractNum;
    /**
     * 用信订单编号
     */
    private String letterOrderNum;
    /**
     * 贷款额（用信额）
     */
    private Integer loanAmount;
    /**
     * 到期时间
     */
    private Date expirationTime;
    /**
     * 发生时间
     */
    private Date occurrenceTime;
    /**
     * 贷款状态（使用中）
     */
    private Integer loanStatus;
    /**
     * 发生账户类型
     */
    private Integer accountType;
    /**
     *发生账户（卡号）
     */
    private String account;

    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    public Integer getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(Integer loanNumber) {
        this.loanNumber = loanNumber;
    }

    public String getLender() {
        return lender;
    }

    public void setLender(String lender) {
        this.lender = lender == null ? null : lender.trim();
    }

    public String getCreditMasterContractNum() {
        return creditMasterContractNum;
    }

    public void setCreditMasterContractNum(String creditMasterContractNum) {
        this.creditMasterContractNum = creditMasterContractNum == null ? null : creditMasterContractNum.trim();
    }

    public String getLetterOrderNum() {
        return letterOrderNum;
    }

    public void setLetterOrderNum(String letterOrderNum) {
        this.letterOrderNum = letterOrderNum == null ? null : letterOrderNum.trim();
    }

    public Integer getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Integer loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Date getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }

    public Date getOccurrenceTime() {
        return occurrenceTime;
    }

    public void setOccurrenceTime(Date occurrenceTime) {
        this.occurrenceTime = occurrenceTime;
    }

    public Integer getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(Integer loanStatus) {
        this.loanStatus = loanStatus;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Loan loan = (Loan) o;

        if (loanId != null ? !loanId.equals(loan.loanId) : loan.loanId != null) return false;
        if (loanNumber != null ? !loanNumber.equals(loan.loanNumber) : loan.loanNumber != null) return false;
        if (lender != null ? !lender.equals(loan.lender) : loan.lender != null) return false;
        if (creditMasterContractNum != null ? !creditMasterContractNum.equals(loan.creditMasterContractNum) : loan.creditMasterContractNum != null)
            return false;
        if (letterOrderNum != null ? !letterOrderNum.equals(loan.letterOrderNum) : loan.letterOrderNum != null)
            return false;
        if (loanAmount != null ? !loanAmount.equals(loan.loanAmount) : loan.loanAmount != null) return false;
        if (expirationTime != null ? !expirationTime.equals(loan.expirationTime) : loan.expirationTime != null)
            return false;
        if (occurrenceTime != null ? !occurrenceTime.equals(loan.occurrenceTime) : loan.occurrenceTime != null)
            return false;
        if (loanStatus != null ? !loanStatus.equals(loan.loanStatus) : loan.loanStatus != null) return false;
        if (accountType != null ? !accountType.equals(loan.accountType) : loan.accountType != null) return false;
        return account != null ? account.equals(loan.account) : loan.account == null;
    }

    @Override
    public int hashCode() {
        int result = loanId != null ? loanId.hashCode() : 0;
        result = 31 * result + (loanNumber != null ? loanNumber.hashCode() : 0);
        result = 31 * result + (lender != null ? lender.hashCode() : 0);
        result = 31 * result + (creditMasterContractNum != null ? creditMasterContractNum.hashCode() : 0);
        result = 31 * result + (letterOrderNum != null ? letterOrderNum.hashCode() : 0);
        result = 31 * result + (loanAmount != null ? loanAmount.hashCode() : 0);
        result = 31 * result + (expirationTime != null ? expirationTime.hashCode() : 0);
        result = 31 * result + (occurrenceTime != null ? occurrenceTime.hashCode() : 0);
        result = 31 * result + (loanStatus != null ? loanStatus.hashCode() : 0);
        result = 31 * result + (accountType != null ? accountType.hashCode() : 0);
        result = 31 * result + (account != null ? account.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanId=" + loanId +
                ", loanNumber=" + loanNumber +
                ", lender='" + lender + '\'' +
                ", creditMasterContractNum='" + creditMasterContractNum + '\'' +
                ", letterOrderNum='" + letterOrderNum + '\'' +
                ", loanAmount=" + loanAmount +
                ", expirationTime=" + expirationTime +
                ", occurrenceTime=" + occurrenceTime +
                ", loanStatus=" + loanStatus +
                ", accountType=" + accountType +
                ", account='" + account + '\'' +
                '}';
    }
}