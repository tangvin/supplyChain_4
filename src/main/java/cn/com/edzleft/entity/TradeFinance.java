package cn.com.edzleft.entity;

import java.util.Date;

/**贸易方财务表
 * gyl_trade_finance
 */
public class TradeFinance {
    /**
     * 财务表主键id
     */
    private Integer id;
    /**
     * 财务编号
     */
    private String financialNumber;
    /**
     * 财务类型
     */
    private Integer financialType;
    /**
     * 金额
     */
    private Double amount;
    /**
     * 发生方（关联到采购方企业信息表）
     */
    private  Integer payerId;

    /**
     * 所属订单
     */
    private Integer belongOrderId;
    /**
     * 账单时间
     */
    private Date billTime;
    /**
     * 银行卡账户类型
     */
    private Integer bankAccountId;
    /**
     * 银行卡账户id(关联到银行表)
     * @return
     */
    private Integer bankCardId;

    /**
     * 企业信息id(关联到企业信息表)
     * @return
     */
    private Integer informationId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFinancialNumber() {
        return financialNumber;
    }

    public void setFinancialNumber(String financialNumber) {
        this.financialNumber = financialNumber;
    }

    public Integer getFinancialType() {
        return financialType;
    }

    public void setFinancialType(Integer financialType) {
        this.financialType = financialType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getPayerId() {
        return payerId;
    }

    public void setPayerId(Integer payerId) {
        this.payerId = payerId;
    }

    public Integer getBelongOrderId() {
        return belongOrderId;
    }

    public void setBelongOrderId(Integer belongOrderId) {
        this.belongOrderId = belongOrderId;
    }

    public Date getBillTime() {
        return billTime;
    }

    public void setBillTime(Date billTime) {
        this.billTime = billTime;
    }

    public Integer getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(Integer bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public Integer getBankCardId() {
        return bankCardId;
    }

    public void setBankCardId(Integer bankCardId) {
        this.bankCardId = bankCardId;
    }

    public Integer getInformationId() {
        return informationId;
    }

    public void setInformationId(Integer informationId) {
        this.informationId = informationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TradeFinance)) return false;

        TradeFinance that = (TradeFinance) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (financialNumber != null ? !financialNumber.equals(that.financialNumber) : that.financialNumber != null)
            return false;
        if (financialType != null ? !financialType.equals(that.financialType) : that.financialType != null)
            return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (payerId != null ? !payerId.equals(that.payerId) : that.payerId != null) return false;
        if (belongOrderId != null ? !belongOrderId.equals(that.belongOrderId) : that.belongOrderId != null)
            return false;
        if (billTime != null ? !billTime.equals(that.billTime) : that.billTime != null) return false;
        if (bankAccountId != null ? !bankAccountId.equals(that.bankAccountId) : that.bankAccountId != null)
            return false;
        if (bankCardId != null ? !bankCardId.equals(that.bankCardId) : that.bankCardId != null) return false;
        return informationId != null ? informationId.equals(that.informationId) : that.informationId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (financialNumber != null ? financialNumber.hashCode() : 0);
        result = 31 * result + (financialType != null ? financialType.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (payerId != null ? payerId.hashCode() : 0);
        result = 31 * result + (belongOrderId != null ? belongOrderId.hashCode() : 0);
        result = 31 * result + (billTime != null ? billTime.hashCode() : 0);
        result = 31 * result + (bankAccountId != null ? bankAccountId.hashCode() : 0);
        result = 31 * result + (bankCardId != null ? bankCardId.hashCode() : 0);
        result = 31 * result + (informationId != null ? informationId.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "TradeFinance{" +
                "id=" + id +
                ", financialNumber='" + financialNumber + '\'' +
                ", financialType=" + financialType +
                ", amount=" + amount +
                ", payerId=" + payerId +
                ", belongOrderId=" + belongOrderId +
                ", billTime=" + billTime +
                ", bankAccountId=" + bankAccountId +
                ", bankCardId=" + bankCardId +
                ", informationId=" + informationId +
                '}';
    }
}