package cn.com.edzleft.entity;

import java.util.Date;

/**授信表
 * gyl_credit_table
 */
public class CreditTable {
    /**
     * id
     */
    private Integer id;
    /**
     * 授信人（资方）
     */
    private String creditGrantor;
    /**
     * 授信时间
     */
    private Date creditTime;
    /**
     * 授信额
     */
    private Double creditAmount;
    /**
     * 授信主合同
     */
    private String creditMasterContract;
    /**
     * 采购方基本资料附件
     */
    private String buyerInformationAttachment;
    /**
     * 贸易方基本资料附件
     */
    private String tradeInformationAttachment;
    /**
     * 0申请授信、1主动授信（默认申请授信）
     */
    private Integer creditWay;
    /**
     * 授信编号
     */
    private String creditNumber;
    /**
     * 授信状态
     */
    private Integer creditStatus;
    /**
     * 申请人
     */
    private String applicant;
    /**
     * 申请时间
     */
    private Date applicationTime;
    /**
     * 批准时间
     */
    private Date approvalTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreditGrantor() {
        return creditGrantor;
    }

    public void setCreditGrantor(String creditGrantor) {
        this.creditGrantor = creditGrantor == null ? null : creditGrantor.trim();
    }

    public Date getCreditTime() {
        return creditTime;
    }

    public void setCreditTime(Date creditTime) {
        this.creditTime = creditTime;
    }

    public Double getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(Double creditAmount) {
        this.creditAmount = creditAmount;
    }

    public String getCreditMasterContract() {
        return creditMasterContract;
    }

    public void setCreditMasterContract(String creditMasterContract) {
        this.creditMasterContract = creditMasterContract == null ? null : creditMasterContract.trim();
    }

    public String getBuyerInformationAttachment() {
        return buyerInformationAttachment;
    }

    public void setBuyerInformationAttachment(String buyerInformationAttachment) {
        this.buyerInformationAttachment = buyerInformationAttachment == null ? null : buyerInformationAttachment.trim();
    }

    public String getTradeInformationAttachment() {
        return tradeInformationAttachment;
    }

    public void setTradeInformationAttachment(String tradeInformationAttachment) {
        this.tradeInformationAttachment = tradeInformationAttachment == null ? null : tradeInformationAttachment.trim();
    }

    public Integer getCreditWay() {
        return creditWay;
    }

    public void setCreditWay(Integer creditWay) {
        this.creditWay = creditWay;
    }

    public String getCreditNumber() {
        return creditNumber;
    }

    public void setCreditNumber(String creditNumber) {
        this.creditNumber = creditNumber == null ? null : creditNumber.trim();
    }

    public Integer getCreditStatus() {
        return creditStatus;
    }

    public void setCreditStatus(Integer creditStatus) {
        this.creditStatus = creditStatus;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public Date getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }

    public Date getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(Date approvalTime) {
        this.approvalTime = approvalTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreditTable that = (CreditTable) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (creditGrantor != null ? !creditGrantor.equals(that.creditGrantor) : that.creditGrantor != null)
            return false;
        if (creditTime != null ? !creditTime.equals(that.creditTime) : that.creditTime != null) return false;
        if (creditAmount != null ? !creditAmount.equals(that.creditAmount) : that.creditAmount != null) return false;
        if (creditMasterContract != null ? !creditMasterContract.equals(that.creditMasterContract) : that.creditMasterContract != null)
            return false;
        if (buyerInformationAttachment != null ? !buyerInformationAttachment.equals(that.buyerInformationAttachment) : that.buyerInformationAttachment != null)
            return false;
        if (tradeInformationAttachment != null ? !tradeInformationAttachment.equals(that.tradeInformationAttachment) : that.tradeInformationAttachment != null)
            return false;
        if (creditWay != null ? !creditWay.equals(that.creditWay) : that.creditWay != null) return false;
        if (creditNumber != null ? !creditNumber.equals(that.creditNumber) : that.creditNumber != null) return false;
        if (creditStatus != null ? !creditStatus.equals(that.creditStatus) : that.creditStatus != null) return false;
        if (applicant != null ? !applicant.equals(that.applicant) : that.applicant != null) return false;
        if (applicationTime != null ? !applicationTime.equals(that.applicationTime) : that.applicationTime != null)
            return false;
        return approvalTime != null ? approvalTime.equals(that.approvalTime) : that.approvalTime == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (creditGrantor != null ? creditGrantor.hashCode() : 0);
        result = 31 * result + (creditTime != null ? creditTime.hashCode() : 0);
        result = 31 * result + (creditAmount != null ? creditAmount.hashCode() : 0);
        result = 31 * result + (creditMasterContract != null ? creditMasterContract.hashCode() : 0);
        result = 31 * result + (buyerInformationAttachment != null ? buyerInformationAttachment.hashCode() : 0);
        result = 31 * result + (tradeInformationAttachment != null ? tradeInformationAttachment.hashCode() : 0);
        result = 31 * result + (creditWay != null ? creditWay.hashCode() : 0);
        result = 31 * result + (creditNumber != null ? creditNumber.hashCode() : 0);
        result = 31 * result + (creditStatus != null ? creditStatus.hashCode() : 0);
        result = 31 * result + (applicant != null ? applicant.hashCode() : 0);
        result = 31 * result + (applicationTime != null ? applicationTime.hashCode() : 0);
        result = 31 * result + (approvalTime != null ? approvalTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CreditTable{" +
                "id=" + id +
                ", creditGrantor='" + creditGrantor + '\'' +
                ", creditTime=" + creditTime +
                ", creditAmount=" + creditAmount +
                ", creditMasterContract='" + creditMasterContract + '\'' +
                ", buyerInformationAttachment='" + buyerInformationAttachment + '\'' +
                ", tradeInformationAttachment='" + tradeInformationAttachment + '\'' +
                ", creditWay=" + creditWay +
                ", creditNumber='" + creditNumber + '\'' +
                ", creditStatus=" + creditStatus +
                ", applicant='" + applicant + '\'' +
                ", applicationTime=" + applicationTime +
                ", approvalTime=" + approvalTime +
                '}';
    }
}