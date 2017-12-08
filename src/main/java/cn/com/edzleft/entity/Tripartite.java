package cn.com.edzleft.entity;

import java.util.Date;

/**三方银行账户表
 * gyl_tripartite
 */
public class Tripartite {
    /**
     * 三方银行账户之id
     */
    private Integer tripartiteId;
    /**
     * 三方银行账户之开户行
     */
    private String tripartiteDepositBank;
    /**
     * 户主（贸方）
     */
    private String tripartiteCreditHolderTradeId;
    /**
     * 户主（采方）
     */
    private String tripartiteCreditHolderPurchaserId;
    /**
     * 户主(资方）
     */
    private String tripartiteCreditHolderCapitalId;
    /**
     * 三方银行账户之账号
     */
    private String tripartiteAccountNumber;
    /**
     * 三方银行账户之账号开通时间
     */
    private Date tripartiteAccountOpentime;
    /**
     * 三方银行账户之账号开通人
     */
    private String tripartiteAccountOpenpeople;
    /**
     * 三方银行账户之余额
     */
    private Integer tripartiteBalance;
    /**
     * 三方银行账户之可用余额
     */
    private Integer tripartiteAvailableBalance;
    /**
     * 三方银行账户之创建时间
     */
    private Date tripartiteAmountCreateTime;
    /**
     * 三方银行账户之创建人
     */
    private String tripartiteAmountCreatePeople;

    //业务字段
    /**
     * 户主（采购方）
     */
    private String entName;

    public String getTripartiteCreditHolderTradeId() {
        return tripartiteCreditHolderTradeId;
    }

    public void setTripartiteCreditHolderTradeId(String tripartiteCreditHolderTradeId) {
        this.tripartiteCreditHolderTradeId = tripartiteCreditHolderTradeId;
    }

    public String getTripartiteCreditHolderPurchaserId() {
        return tripartiteCreditHolderPurchaserId;
    }

    public void setTripartiteCreditHolderPurchaserId(String tripartiteCreditHolderPurchaserId) {
        this.tripartiteCreditHolderPurchaserId = tripartiteCreditHolderPurchaserId;
    }

    public String getTripartiteCreditHolderCapitalId() {
        return tripartiteCreditHolderCapitalId;
    }

    public void setTripartiteCreditHolderCapitalId(String tripartiteCreditHolderCapitalId) {
        this.tripartiteCreditHolderCapitalId = tripartiteCreditHolderCapitalId;
    }

    public String getEntName() {
        return entName;
    }

    public void setEntName(String entName) {
        this.entName = entName;
    }

    public Integer getTripartiteId() {
        return tripartiteId;
    }

    public void setTripartiteId(Integer tripartiteId) {
        this.tripartiteId = tripartiteId;
    }

    public String getTripartiteDepositBank() {
        return tripartiteDepositBank;
    }

    public void setTripartiteDepositBank(String tripartiteDepositBank) {
        this.tripartiteDepositBank = tripartiteDepositBank == null ? null : tripartiteDepositBank.trim();
    }


    public String getTripartiteAccountNumber() {
        return tripartiteAccountNumber;
    }

    public void setTripartiteAccountNumber(String tripartiteAccountNumber) {
        this.tripartiteAccountNumber = tripartiteAccountNumber;
    }

    public Date getTripartiteAccountOpentime() {
        return tripartiteAccountOpentime;
    }

    public void setTripartiteAccountOpentime(Date tripartiteAccountOpentime) {
        this.tripartiteAccountOpentime = tripartiteAccountOpentime;
    }

    public String getTripartiteAccountOpenpeople() {
        return tripartiteAccountOpenpeople;
    }

    public void setTripartiteAccountOpenpeople(String tripartiteAccountOpenpeople) {
        this.tripartiteAccountOpenpeople = tripartiteAccountOpenpeople == null ? null : tripartiteAccountOpenpeople.trim();
    }

    public Integer getTripartiteBalance() {
        return tripartiteBalance;
    }

    public void setTripartiteBalance(Integer tripartiteBalance) {
        this.tripartiteBalance = tripartiteBalance;
    }

    public Integer getTripartiteAvailableBalance() {
        return tripartiteAvailableBalance;
    }

    public void setTripartiteAvailableBalance(Integer tripartiteAvailableBalance) {
        this.tripartiteAvailableBalance = tripartiteAvailableBalance;
    }

    public Date getTripartiteAmountCreateTime() {
        return tripartiteAmountCreateTime;
    }

    public void setTripartiteAmountCreateTime(Date tripartiteAmountCreateTime) {
        this.tripartiteAmountCreateTime = tripartiteAmountCreateTime;
    }

    public String getTripartiteAmountCreatePeople() {
        return tripartiteAmountCreatePeople;
    }

    public void setTripartiteAmountCreatePeople(String tripartiteAmountCreatePeople) {
        this.tripartiteAmountCreatePeople = tripartiteAmountCreatePeople == null ? null : tripartiteAmountCreatePeople.trim();
    }

    @Override
    public String toString() {
        return "Tripartite{" +
                "tripartiteId=" + tripartiteId +
                ", tripartiteDepositBank='" + tripartiteDepositBank + '\'' +
                ", tripartiteCreditHolderTradeId='" + tripartiteCreditHolderTradeId + '\'' +
                ", tripartiteCreditHolderPurchaserId='" + tripartiteCreditHolderPurchaserId + '\'' +
                ", tripartiteCreditHolderCapitalId='" + tripartiteCreditHolderCapitalId + '\'' +
                ", tripartiteAccountNumber=" + tripartiteAccountNumber +
                ", tripartiteAccountOpentime=" + tripartiteAccountOpentime +
                ", tripartiteAccountOpenpeople='" + tripartiteAccountOpenpeople + '\'' +
                ", tripartiteBalance=" + tripartiteBalance +
                ", tripartiteAvailableBalance=" + tripartiteAvailableBalance +
                ", tripartiteAmountCreateTime=" + tripartiteAmountCreateTime +
                ", tripartiteAmountCreatePeople='" + tripartiteAmountCreatePeople + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tripartite that = (Tripartite) o;

        if (tripartiteId != null ? !tripartiteId.equals(that.tripartiteId) : that.tripartiteId != null) return false;
        if (tripartiteDepositBank != null ? !tripartiteDepositBank.equals(that.tripartiteDepositBank) : that.tripartiteDepositBank != null)
            return false;
        if (tripartiteCreditHolderTradeId != null ? !tripartiteCreditHolderTradeId.equals(that.tripartiteCreditHolderTradeId) : that.tripartiteCreditHolderTradeId != null)
            return false;
        if (tripartiteCreditHolderPurchaserId != null ? !tripartiteCreditHolderPurchaserId.equals(that.tripartiteCreditHolderPurchaserId) : that.tripartiteCreditHolderPurchaserId != null)
            return false;
        if (tripartiteCreditHolderCapitalId != null ? !tripartiteCreditHolderCapitalId.equals(that.tripartiteCreditHolderCapitalId) : that.tripartiteCreditHolderCapitalId != null)
            return false;
        if (tripartiteAccountNumber != null ? !tripartiteAccountNumber.equals(that.tripartiteAccountNumber) : that.tripartiteAccountNumber != null)
            return false;
        if (tripartiteAccountOpentime != null ? !tripartiteAccountOpentime.equals(that.tripartiteAccountOpentime) : that.tripartiteAccountOpentime != null)
            return false;
        if (tripartiteAccountOpenpeople != null ? !tripartiteAccountOpenpeople.equals(that.tripartiteAccountOpenpeople) : that.tripartiteAccountOpenpeople != null)
            return false;
        if (tripartiteBalance != null ? !tripartiteBalance.equals(that.tripartiteBalance) : that.tripartiteBalance != null)
            return false;
        if (tripartiteAvailableBalance != null ? !tripartiteAvailableBalance.equals(that.tripartiteAvailableBalance) : that.tripartiteAvailableBalance != null)
            return false;
        if (tripartiteAmountCreateTime != null ? !tripartiteAmountCreateTime.equals(that.tripartiteAmountCreateTime) : that.tripartiteAmountCreateTime != null)
            return false;
        return tripartiteAmountCreatePeople != null ? tripartiteAmountCreatePeople.equals(that.tripartiteAmountCreatePeople) : that.tripartiteAmountCreatePeople == null;
    }

    @Override
    public int hashCode() {
        int result = tripartiteId != null ? tripartiteId.hashCode() : 0;
        result = 31 * result + (tripartiteDepositBank != null ? tripartiteDepositBank.hashCode() : 0);
        result = 31 * result + (tripartiteCreditHolderTradeId != null ? tripartiteCreditHolderTradeId.hashCode() : 0);
        result = 31 * result + (tripartiteCreditHolderPurchaserId != null ? tripartiteCreditHolderPurchaserId.hashCode() : 0);
        result = 31 * result + (tripartiteCreditHolderCapitalId != null ? tripartiteCreditHolderCapitalId.hashCode() : 0);
        result = 31 * result + (tripartiteAccountNumber != null ? tripartiteAccountNumber.hashCode() : 0);
        result = 31 * result + (tripartiteAccountOpentime != null ? tripartiteAccountOpentime.hashCode() : 0);
        result = 31 * result + (tripartiteAccountOpenpeople != null ? tripartiteAccountOpenpeople.hashCode() : 0);
        result = 31 * result + (tripartiteBalance != null ? tripartiteBalance.hashCode() : 0);
        result = 31 * result + (tripartiteAvailableBalance != null ? tripartiteAvailableBalance.hashCode() : 0);
        result = 31 * result + (tripartiteAmountCreateTime != null ? tripartiteAmountCreateTime.hashCode() : 0);
        result = 31 * result + (tripartiteAmountCreatePeople != null ? tripartiteAmountCreatePeople.hashCode() : 0);
        return result;
    }
}