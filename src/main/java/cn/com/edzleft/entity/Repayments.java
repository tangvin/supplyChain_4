package cn.com.edzleft.entity;

import java.io.Serializable;
import java.util.Date;

public class Repayments implements Serializable{
    private static final long serialVersionUID = -7568530000502876132L;
    /**
     * 还款主键
     */
    private Integer repaymentsId;
    /**
     * 还款编号
     */
    private String repaymentsNum;
    /**
     * 还款方
     */
    private String repaymentsPerson;
    /**
     * 还款金额
     */
    private Integer repaymentsAmount;
    /**
     * 贷款金额
     */
    private Integer loanAmount;
    /**
     * 还款状态（0全额还款、1部分还款）
     */
    private Integer repaymentsStatus;
    /**
     * 发生账户类型
     */
    private String accountType;
    /**
     * 发生账户（卡号）
     */
    private String account;
    /**
     * 还款时间
     */
    private Date repaymentsTime;
    /**
     * 授信表外键
     */
    private Integer creditId;
    /**
     * 订单外键
     */
    private Integer orderId;
    /**
     * 用信表外键
     */
    private Integer letterId;

    /**
     * 开始时间
     */
    private Date creatTime;
    /**
     * 结束时间
     */
    private Date endTime;

    public Integer getCreditId() {
        return creditId;
    }

    public void setCreditId(Integer creditId) {
        this.creditId = creditId;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getRepaymentsId() {
        return repaymentsId;
    }

    public void setRepaymentsId(Integer repaymentsId) {
        this.repaymentsId = repaymentsId;
    }

    public String getRepaymentsNum() {
        return repaymentsNum;
    }

    public void setRepaymentsNum(String repaymentsNum) {
        this.repaymentsNum = repaymentsNum == null ? null : repaymentsNum.trim();
    }

    public String getRepaymentsPerson() {
        return repaymentsPerson;
    }

    public void setRepaymentsPerson(String repaymentsPerson) {
        this.repaymentsPerson = repaymentsPerson == null ? null : repaymentsPerson.trim();
    }

    public Integer getRepaymentsAmount() {
        return repaymentsAmount;
    }

    public void setRepaymentsAmount(Integer repaymentsAmount) {
        this.repaymentsAmount = repaymentsAmount;
    }

    public Integer getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Integer loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Integer getRepaymentsStatus() {
        return repaymentsStatus;
    }

    public void setRepaymentsStatus(Integer repaymentsStatus) {
        this.repaymentsStatus = repaymentsStatus;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType == null ? null : accountType.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public Date getRepaymentsTime() {
        return repaymentsTime;
    }

    public void setRepaymentsTime(Date repaymentsTime) {
        this.repaymentsTime = repaymentsTime;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Repayments that = (Repayments) o;

        if (repaymentsId != null ? !repaymentsId.equals(that.repaymentsId) : that.repaymentsId != null) return false;
        if (repaymentsNum != null ? !repaymentsNum.equals(that.repaymentsNum) : that.repaymentsNum != null)
            return false;
        if (repaymentsPerson != null ? !repaymentsPerson.equals(that.repaymentsPerson) : that.repaymentsPerson != null)
            return false;
        if (repaymentsAmount != null ? !repaymentsAmount.equals(that.repaymentsAmount) : that.repaymentsAmount != null)
            return false;
        if (loanAmount != null ? !loanAmount.equals(that.loanAmount) : that.loanAmount != null) return false;
        if (repaymentsStatus != null ? !repaymentsStatus.equals(that.repaymentsStatus) : that.repaymentsStatus != null)
            return false;
        if (accountType != null ? !accountType.equals(that.accountType) : that.accountType != null) return false;
        if (account != null ? !account.equals(that.account) : that.account != null) return false;
        return repaymentsTime != null ? repaymentsTime.equals(that.repaymentsTime) : that.repaymentsTime == null;
    }

    @Override
    public int hashCode() {
        int result = repaymentsId != null ? repaymentsId.hashCode() : 0;
        result = 31 * result + (repaymentsNum != null ? repaymentsNum.hashCode() : 0);
        result = 31 * result + (repaymentsPerson != null ? repaymentsPerson.hashCode() : 0);
        result = 31 * result + (repaymentsAmount != null ? repaymentsAmount.hashCode() : 0);
        result = 31 * result + (loanAmount != null ? loanAmount.hashCode() : 0);
        result = 31 * result + (repaymentsStatus != null ? repaymentsStatus.hashCode() : 0);
        result = 31 * result + (accountType != null ? accountType.hashCode() : 0);
        result = 31 * result + (account != null ? account.hashCode() : 0);
        result = 31 * result + (repaymentsTime != null ? repaymentsTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Repayments{" +
                "repaymentsId=" + repaymentsId +
                ", repaymentsNum='" + repaymentsNum + '\'' +
                ", repaymentsPerson='" + repaymentsPerson + '\'' +
                ", repaymentsAmount=" + repaymentsAmount +
                ", loanAmount=" + loanAmount +
                ", repaymentsStatus=" + repaymentsStatus +
                ", accountType='" + accountType + '\'' +
                ", account='" + account + '\'' +
                ", repaymentsTime=" + repaymentsTime +
                '}';
    }
}