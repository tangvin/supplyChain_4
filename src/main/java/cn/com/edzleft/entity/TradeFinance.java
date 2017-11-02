package cn.com.edzleft.entity;

import java.util.Date;

/**贸易方财务表
 * gyl_trade_finance
 */
public class TradeFinance {
    /**
     * id
     */
    private Integer financialId;
    /**
     * 财务编号
     */
    private String financialNumbers;
    /**
     * 财务类型
     */
    private Integer financialType;
    /**
     * 金额
     */
    private Double amount;
    /**
     * 支方
     */
    private String payer;
    /**
     * 收方
     */
    private String receivingSide;
    /**
     * 所属订单
     */
    private String belongOrder;
    /**
     * 账单时间
     */
    private Date billTime;

    public Integer getFinancialId() {
        return financialId;
    }

    public void setFinancialId(Integer financialId) {
        this.financialId = financialId;
    }

    public String getFinancialNumbers() {
        return financialNumbers;
    }

    public void setFinancialNumbers(String financialNumbers) {
        this.financialNumbers = financialNumbers == null ? null : financialNumbers.trim();
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

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer == null ? null : payer.trim();
    }

    public String getReceivingSide() {
        return receivingSide;
    }

    public void setReceivingSide(String receivingSide) {
        this.receivingSide = receivingSide == null ? null : receivingSide.trim();
    }

    public String getBelongOrder() {
        return belongOrder;
    }

    public void setBelongOrder(String belongOrder) {
        this.belongOrder = belongOrder == null ? null : belongOrder.trim();
    }

    public Date getBillTime() {
        return billTime;
    }

    public void setBillTime(Date billTime) {
        this.billTime = billTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TradeFinance that = (TradeFinance) o;

        if (financialId != null ? !financialId.equals(that.financialId) : that.financialId != null) return false;
        if (financialNumbers != null ? !financialNumbers.equals(that.financialNumbers) : that.financialNumbers != null)
            return false;
        if (financialType != null ? !financialType.equals(that.financialType) : that.financialType != null)
            return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (payer != null ? !payer.equals(that.payer) : that.payer != null) return false;
        if (receivingSide != null ? !receivingSide.equals(that.receivingSide) : that.receivingSide != null)
            return false;
        if (belongOrder != null ? !belongOrder.equals(that.belongOrder) : that.belongOrder != null) return false;
        return billTime != null ? billTime.equals(that.billTime) : that.billTime == null;
    }

    @Override
    public int hashCode() {
        int result = financialId != null ? financialId.hashCode() : 0;
        result = 31 * result + (financialNumbers != null ? financialNumbers.hashCode() : 0);
        result = 31 * result + (financialType != null ? financialType.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (payer != null ? payer.hashCode() : 0);
        result = 31 * result + (receivingSide != null ? receivingSide.hashCode() : 0);
        result = 31 * result + (belongOrder != null ? belongOrder.hashCode() : 0);
        result = 31 * result + (billTime != null ? billTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TradeFinance{" +
                "financialId=" + financialId +
                ", financialNumbers='" + financialNumbers + '\'' +
                ", financialType=" + financialType +
                ", amount=" + amount +
                ", payer='" + payer + '\'' +
                ", receivingSide='" + receivingSide + '\'' +
                ", belongOrder='" + belongOrder + '\'' +
                ", billTime=" + billTime +
                '}';
    }
}