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
     * 辅合同创建人
     */
    private String assistFounder;
    /**
     * 对应主合同外键
     */
    private String contractId;
    /**
     * 辅合同电子档
     */
    private String assistRecord;
    /**
     * 辅合同签约采购方
     */
    private String assistBuyer;
    /**
     * 辅合同签约贸易方
     */
    private String assistTrade;
    /**
     * 辅合同签约地点
     */
    private String assistSite;
    /**
     * 辅合同签约时间
     */
    private Date assistTime;

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
        this.contractNumber = contractNumber == null ? null : contractNumber.trim();
    }

    public String getAssistName() {
        return assistName;
    }

    public void setAssistName(String assistName) {
        this.assistName = assistName == null ? null : assistName.trim();
    }

    public Date getAssistCreatTime() {
        return assistCreatTime;
    }

    public void setAssistCreatTime(Date assistCreatTime) {
        this.assistCreatTime = assistCreatTime;
    }

    public String getAssistFounder() {
        return assistFounder;
    }

    public void setAssistFounder(String assistFounder) {
        this.assistFounder = assistFounder == null ? null : assistFounder.trim();
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public String getAssistRecord() {
        return assistRecord;
    }

    public void setAssistRecord(String assistRecord) {
        this.assistRecord = assistRecord == null ? null : assistRecord.trim();
    }

    public String getAssistBuyer() {
        return assistBuyer;
    }

    public void setAssistBuyer(String assistBuyer) {
        this.assistBuyer = assistBuyer == null ? null : assistBuyer.trim();
    }

    public String getAssistTrade() {
        return assistTrade;
    }

    public void setAssistTrade(String assistTrade) {
        this.assistTrade = assistTrade == null ? null : assistTrade.trim();
    }

    public String getAssistSite() {
        return assistSite;
    }

    public void setAssistSite(String assistSite) {
        this.assistSite = assistSite == null ? null : assistSite.trim();
    }

    public Date getAssistTime() {
        return assistTime;
    }

    public void setAssistTime(Date assistTime) {
        this.assistTime = assistTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AssistContract that = (AssistContract) o;

        if (assistId != null ? !assistId.equals(that.assistId) : that.assistId != null) return false;
        if (contractNumber != null ? !contractNumber.equals(that.contractNumber) : that.contractNumber != null)
            return false;
        if (assistName != null ? !assistName.equals(that.assistName) : that.assistName != null) return false;
        if (assistCreatTime != null ? !assistCreatTime.equals(that.assistCreatTime) : that.assistCreatTime != null)
            return false;
        if (assistFounder != null ? !assistFounder.equals(that.assistFounder) : that.assistFounder != null)
            return false;
        if (contractId != null ? !contractId.equals(that.contractId) : that.contractId != null) return false;
        if (assistRecord != null ? !assistRecord.equals(that.assistRecord) : that.assistRecord != null) return false;
        if (assistBuyer != null ? !assistBuyer.equals(that.assistBuyer) : that.assistBuyer != null) return false;
        if (assistTrade != null ? !assistTrade.equals(that.assistTrade) : that.assistTrade != null) return false;
        if (assistSite != null ? !assistSite.equals(that.assistSite) : that.assistSite != null) return false;
        return assistTime != null ? assistTime.equals(that.assistTime) : that.assistTime == null;
    }

    @Override
    public int hashCode() {
        int result = assistId != null ? assistId.hashCode() : 0;
        result = 31 * result + (contractNumber != null ? contractNumber.hashCode() : 0);
        result = 31 * result + (assistName != null ? assistName.hashCode() : 0);
        result = 31 * result + (assistCreatTime != null ? assistCreatTime.hashCode() : 0);
        result = 31 * result + (assistFounder != null ? assistFounder.hashCode() : 0);
        result = 31 * result + (contractId != null ? contractId.hashCode() : 0);
        result = 31 * result + (assistRecord != null ? assistRecord.hashCode() : 0);
        result = 31 * result + (assistBuyer != null ? assistBuyer.hashCode() : 0);
        result = 31 * result + (assistTrade != null ? assistTrade.hashCode() : 0);
        result = 31 * result + (assistSite != null ? assistSite.hashCode() : 0);
        result = 31 * result + (assistTime != null ? assistTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AssistContract{" +
                "assistId=" + assistId +
                ", contractNumber='" + contractNumber + '\'' +
                ", assistName='" + assistName + '\'' +
                ", assistCreatTime=" + assistCreatTime +
                ", assistFounder='" + assistFounder + '\'' +
                ", contractId='" + contractId + '\'' +
                ", assistRecord='" + assistRecord + '\'' +
                ", assistBuyer='" + assistBuyer + '\'' +
                ", assistTrade='" + assistTrade + '\'' +
                ", assistSite='" + assistSite + '\'' +
                ", assistTime=" + assistTime +
                '}';
    }
}