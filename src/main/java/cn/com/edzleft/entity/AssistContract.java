package cn.com.edzleft.entity;

import java.util.Date;

/**合同附加辅表
 * gyl_assist_contract
 */
public class AssistContract {
    /**
     * id
     */
    private Integer assistId;
    /**
     * 辅合同编号
     */
    private String contractNumber;
    /**
     * 辅合同名称
     */
    private String assistName;
    /**
     * 辅合同创建时间
     */
    private Date assistCreatTime;
    /**
     * 辅合同创建人(关联到用户表)
     */
    private Integer assistFounderId;
    /**
     * 对应主合同外键
     */
    private Integer contractId;
    /**
     * 辅合同电子档
     */
    private String assistRecord;
    /**
     * 辅合同签约采购方
     */
    private Integer assistBuyerId;
    /**
     * 辅合同签约贸易方
     */
    private Integer assistTradeId;
    /**
     * 辅合同签约地点
     */
    private String assistSite;
    /**
     * 辅合同签约时间
     */
    private Date assistTime;

    /**
     * 辅合同状态
     * @return
     */
    private Integer  assistStatus;

    /**
     * 辅合同附件id（关联到附件表）
     * @return
     */
    private  Integer assistAttachmentId;

    /**
     * 是否申请融信
     * @return
     */
    private Integer assistLetterApply;

    /* <result column="buyerEntName" property="buyerEntName" jdbcType="VARCHAR" />
    <result column="buyerName" property="buyerName" jdbcType="VARCHAR" />
    <result column="assistAttachmentAmount" property="assistAttachmentAmount" jdbcType="INTEGER" />
    <result column="assistRejectAmount" property="assistRejectAmount" jdbcType="INTEGER" />*/


    /**
     * 别名
     */
    private String buyerEntName;
    private String buyerName;
    private String assistAttachmentAmount;
    private String assistRejectAmount;

    public String getBuyerEntName() {
        return buyerEntName;
    }

    public void setBuyerEntName(String buyerEntName) {
        this.buyerEntName = buyerEntName;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getAssistAttachmentAmount() {
        return assistAttachmentAmount;
    }

    public void setAssistAttachmentAmount(String assistAttachmentAmount) {
        this.assistAttachmentAmount = assistAttachmentAmount;
    }

    public String getAssistRejectAmount() {
        return assistRejectAmount;
    }

    public void setAssistRejectAmount(String assistRejectAmount) {
        this.assistRejectAmount = assistRejectAmount;
    }

    public Integer getAssistId() {
        return assistId;
    }

    public void setAssistId(Integer assistId) {
        this.assistId = assistId;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getAssistName() {
        return assistName;
    }

    public void setAssistName(String assistName) {
        this.assistName = assistName;
    }

    public Date getAssistCreatTime() {
        return assistCreatTime;
    }

    public void setAssistCreatTime(Date assistCreatTime) {
        this.assistCreatTime = assistCreatTime;
    }

    public Integer getAssistFounderId() {
        return assistFounderId;
    }

    public void setAssistFounderId(Integer assistFounderId) {
        this.assistFounderId = assistFounderId;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getAssistRecord() {
        return assistRecord;
    }

    public void setAssistRecord(String assistRecord) {
        this.assistRecord = assistRecord;
    }

    public Integer getAssistBuyerId() {
        return assistBuyerId;
    }

    public void setAssistBuyerId(Integer assistBuyerId) {
        this.assistBuyerId = assistBuyerId;
    }

    public Integer getAssistTradeId() {
        return assistTradeId;
    }

    public void setAssistTradeId(Integer assistTradeId) {
        this.assistTradeId = assistTradeId;
    }

    public String getAssistSite() {
        return assistSite;
    }

    public void setAssistSite(String assistSite) {
        this.assistSite = assistSite;
    }

    public Date getAssistTime() {
        return assistTime;
    }

    public void setAssistTime(Date assistTime) {
        this.assistTime = assistTime;
    }

    public Integer getAssistStatus() {
        return assistStatus;
    }

    public void setAssistStatus(Integer assistStatus) {
        this.assistStatus = assistStatus;
    }

    public Integer getAssistAttachmentId() {
        return assistAttachmentId;
    }

    public void setAssistAttachmentId(Integer assistAttachmentId) {
        this.assistAttachmentId = assistAttachmentId;
    }

    public Integer getAssistLetterApply() {
        return assistLetterApply;
    }

    public void setAssistLetterApply(Integer assistLetterApply) {
        this.assistLetterApply = assistLetterApply;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AssistContract)) return false;

        AssistContract that = (AssistContract) o;

        if (assistId != null ? !assistId.equals(that.assistId) : that.assistId != null) return false;
        if (contractNumber != null ? !contractNumber.equals(that.contractNumber) : that.contractNumber != null)
            return false;
        if (assistName != null ? !assistName.equals(that.assistName) : that.assistName != null) return false;
        if (assistCreatTime != null ? !assistCreatTime.equals(that.assistCreatTime) : that.assistCreatTime != null)
            return false;
        if (assistFounderId != null ? !assistFounderId.equals(that.assistFounderId) : that.assistFounderId != null)
            return false;
        if (contractId != null ? !contractId.equals(that.contractId) : that.contractId != null) return false;
        if (assistRecord != null ? !assistRecord.equals(that.assistRecord) : that.assistRecord != null) return false;
        if (assistBuyerId != null ? !assistBuyerId.equals(that.assistBuyerId) : that.assistBuyerId != null)
            return false;
        if (assistTradeId != null ? !assistTradeId.equals(that.assistTradeId) : that.assistTradeId != null)
            return false;
        if (assistSite != null ? !assistSite.equals(that.assistSite) : that.assistSite != null) return false;
        if (assistTime != null ? !assistTime.equals(that.assistTime) : that.assistTime != null) return false;
        if (assistStatus != null ? !assistStatus.equals(that.assistStatus) : that.assistStatus != null) return false;
        if (assistAttachmentId != null ? !assistAttachmentId.equals(that.assistAttachmentId) : that.assistAttachmentId != null)
            return false;
        if (assistLetterApply != null ? !assistLetterApply.equals(that.assistLetterApply) : that.assistLetterApply != null)
            return false;
        if (buyerEntName != null ? !buyerEntName.equals(that.buyerEntName) : that.buyerEntName != null) return false;
        if (buyerName != null ? !buyerName.equals(that.buyerName) : that.buyerName != null) return false;
        if (assistAttachmentAmount != null ? !assistAttachmentAmount.equals(that.assistAttachmentAmount) : that.assistAttachmentAmount != null)
            return false;
        return assistRejectAmount != null ? assistRejectAmount.equals(that.assistRejectAmount) : that.assistRejectAmount == null;
    }

    @Override
    public int hashCode() {
        int result = assistId != null ? assistId.hashCode() : 0;
        result = 31 * result + (contractNumber != null ? contractNumber.hashCode() : 0);
        result = 31 * result + (assistName != null ? assistName.hashCode() : 0);
        result = 31 * result + (assistCreatTime != null ? assistCreatTime.hashCode() : 0);
        result = 31 * result + (assistFounderId != null ? assistFounderId.hashCode() : 0);
        result = 31 * result + (contractId != null ? contractId.hashCode() : 0);
        result = 31 * result + (assistRecord != null ? assistRecord.hashCode() : 0);
        result = 31 * result + (assistBuyerId != null ? assistBuyerId.hashCode() : 0);
        result = 31 * result + (assistTradeId != null ? assistTradeId.hashCode() : 0);
        result = 31 * result + (assistSite != null ? assistSite.hashCode() : 0);
        result = 31 * result + (assistTime != null ? assistTime.hashCode() : 0);
        result = 31 * result + (assistStatus != null ? assistStatus.hashCode() : 0);
        result = 31 * result + (assistAttachmentId != null ? assistAttachmentId.hashCode() : 0);
        result = 31 * result + (assistLetterApply != null ? assistLetterApply.hashCode() : 0);
        result = 31 * result + (buyerEntName != null ? buyerEntName.hashCode() : 0);
        result = 31 * result + (buyerName != null ? buyerName.hashCode() : 0);
        result = 31 * result + (assistAttachmentAmount != null ? assistAttachmentAmount.hashCode() : 0);
        result = 31 * result + (assistRejectAmount != null ? assistRejectAmount.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AssistContract{" +
                "assistId=" + assistId +
                ", contractNumber='" + contractNumber + '\'' +
                ", assistName='" + assistName + '\'' +
                ", assistCreatTime=" + assistCreatTime +
                ", assistFounderId=" + assistFounderId +
                ", contractId=" + contractId +
                ", assistRecord='" + assistRecord + '\'' +
                ", assistBuyerId=" + assistBuyerId +
                ", assistTradeId=" + assistTradeId +
                ", assistSite='" + assistSite + '\'' +
                ", assistTime=" + assistTime +
                ", assistStatus=" + assistStatus +
                ", assistAttachmentId=" + assistAttachmentId +
                ", assistLetterApply=" + assistLetterApply +
                ", buyerEntName='" + buyerEntName + '\'' +
                ", buyerName='" + buyerName + '\'' +
                ", assistAttachmentAmount='" + assistAttachmentAmount + '\'' +
                ", assistRejectAmount='" + assistRejectAmount + '\'' +
                '}';
    }
}