package cn.com.edzleft.entity;

import java.util.Date;

/**资方财务表
 * gyl_financial
 */
public class Financial {
    /**
     * id
     */
    private Integer id;
    /**
     * 财务编号
     */
    private String financialNumbers;
    /**
     * 财务类型  0贷款、1还款
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
     * 所属订单(有改动)
     */
    private Integer  belongOrderId;
    /**
     * 账单时间
     */
    private Date billTime;
    /**
     * 贸易商名称
     */
    private String tradeName;
    /**
     * 资金方名称
     */
    private String capitalName;
    /**
     * 发生的银行账户类型
     */
    private Integer bankAcountType;
    /**
     * 发生的银行账户(有改动)
     */
    private Integer bankAccountId;

    /**
     * 发生方账号
     * @return
     */
    private String bankCard;

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getBelongOrderId() {
        return belongOrderId;
    }

    public void setBelongOrderId(Integer belongOrderId) {
        this.belongOrderId = belongOrderId == null ? null : belongOrderId;
    }

    public Date getBillTime() {
        return billTime;
    }

    public void setBillTime(Date billTime) {
        this.billTime = billTime;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getCapitalName() {
        return capitalName;
    }

    public void setCapitalName(String capitalName) {
        this.capitalName = capitalName;
    }

    public Integer getBankAcountType() {
        return bankAcountType;
    }



	public void setBankAcountType(Integer bankAcountType) {
        this.bankAcountType = bankAcountType;
    }

    public Integer getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccount(Integer bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Financial financial = (Financial) o;

        if (id != null ? !id.equals(financial.id) : financial.id != null) return false;
        if (financialNumbers != null ? !financialNumbers.equals(financial.financialNumbers) : financial.financialNumbers != null)
            return false;
        if (financialType != null ? !financialType.equals(financial.financialType) : financial.financialType != null)
            return false;
        if (amount != null ? !amount.equals(financial.amount) : financial.amount != null) return false;
        if (payer != null ? !payer.equals(financial.payer) : financial.payer != null) return false;
        if (receivingSide != null ? !receivingSide.equals(financial.receivingSide) : financial.receivingSide != null)
            return false;
        if (belongOrderId != null ? !belongOrderId.equals(financial.belongOrderId) : financial.belongOrderId != null)
            return false;
        if (billTime != null ? !billTime.equals(financial.billTime) : financial.billTime != null) return false;
        if (tradeName != null ? !tradeName.equals(financial.tradeName) : financial.tradeName != null) return false;
        if (capitalName != null ? !capitalName.equals(financial.capitalName) : financial.capitalName != null)
            return false;
        if (bankAcountType != null ? !bankAcountType.equals(financial.bankAcountType) : financial.bankAcountType != null)
            return false;
        if (bankCard != null ? !bankCard.equals(financial.bankCard) : financial.bankCard != null) return false;
        return bankAccountId != null ? bankAccountId.equals(financial.bankAccountId) : financial.bankAccountId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (financialNumbers != null ? financialNumbers.hashCode() : 0);
        result = 31 * result + (financialType != null ? financialType.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (payer != null ? payer.hashCode() : 0);
        result = 31 * result + (receivingSide != null ? receivingSide.hashCode() : 0);
        result = 31 * result + (belongOrderId != null ? belongOrderId.hashCode() : 0);
        result = 31 * result + (billTime != null ? billTime.hashCode() : 0);
        result = 31 * result + (tradeName != null ? tradeName.hashCode() : 0);
        result = 31 * result + (capitalName != null ? capitalName.hashCode() : 0);
        result = 31 * result + (bankAcountType != null ? bankAcountType.hashCode() : 0);
        result = 31 * result + (bankCard != null ? bankCard.hashCode() : 0);
        result = 31 * result + (bankAccountId != null ? bankAccountId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Financial{" +
                "id=" + id +
                ", financialNumbers='" + financialNumbers + '\'' +
                ", financialType=" + financialType +
                ", amount=" + amount +
                ", payer='" + payer + '\'' +
                ", receivingSide='" + receivingSide + '\'' +
                ", belongOrder='" + belongOrderId + '\'' +
                ", belongOrderId='" + belongOrderId + '\'' +
                ", billTime=" + billTime +
                ", tradeName='" + tradeName + '\'' +
                ", capitalName='" + capitalName + '\'' +
                ", bankAcountType=" + bankAcountType +
                ", bankAccount='" + bankAccountId + '\'' +
                ", bankCard=" + bankCard +
                ", bankAccountId='" + bankAccountId + '\'' +
                '}';
    }
}