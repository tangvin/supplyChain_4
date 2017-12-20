package cn.com.edzleft.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**合同表
 * gyl_contract
 */
public class Contract implements Serializable{
    private static final long serialVersionUID = 5213670568749427280L;
    /**
     * 合同id
     */
    private Integer contractId;


	/**
     * 合同编号
     */
    private String contractNumber;
    /**
     * 合同名称
     */
    private String contractName;
    /**
     * 合同签约采购方
     */
    private Integer contractBuyerId;
    /**
     * 合同签约贸易方
     */
    private Integer contractTraderId;
    /**
     * 合同开始时间
     */
    private Date creatTime;
    /**
     * 合同结束时间
     */
    private Date endTime;
    /**
     * 签约地  注意，三级联通菜单，只取用户选择的最后一级，存入表内
     */
    private String signingAddress;
    /**
     * 签约时间
     */
    private Date signingTime;
    /**
     * 贸易方签约人
     */
    private Integer tradeSignatoriesId;
    /**
     * 采购方签约人
     */
    private Integer buyerSignatoryId;
    /**
     * 合同附加辅合同  关联到合同辅表，可多个辅表内数据。
     */
    private Integer assistContractId;
    /**
     * 合同所属订单   关联到订单表
     */
    private Integer orderContractId;
    /**
     * 合同状态 0未生效、1正常、2已终止、3历史
     */
    private Integer contractStatus;
    /**
     * 合同授信人
     */
    private String contractLetterPerson;
    /**
     * 合同授信额
     */
    private Double contractCredit;
    /**
     * 合同用信额
     */
    private Double contractLetter;
    /**
     * 合同创建时间
     */
    private Date contractCreateTime;
    /**
     * 合同创建人
     */
    private String contractFounder;
    /**
     * 关联到附件表，多页取多条
     */
    private Integer contractElectronicsId;

    /**
     * 合同扫描件
     */
    private Integer contractScanner;
    /**
     * 融信申请（是与否）
     */
    private Integer letterApply;
    /**
     * 合同表别名
     <result column="procurementEntName" property="procurementEntName" jdbcType="VARCHAR" />
     <result column="buyerSignatory" property="buyerSignatory" jdbcType="VARCHAR" />
     <result column="tradeSignatory" property="tradeSignatory" jdbcType="VARCHAR" />
     <result column="assistName" property="assistName" jdbcType="VARCHAR" />
     <result column="assistContractNumber" property="assistContractNumber" jdbcType="VARCHAR" />
     <result column="assistContractAmount" property="assistContractAmount" jdbcType="INTEGER" />
     <result column="attachmentAmount" property="attachmentAmount" jdbcType="INTEGER" />

     */
    /**
     * 采购方企业名字
     */
    private String procurementEntName;
    /**
     * 贸易方企业名称
     */
    private String tradeEntName;
    /**
     * 采购方签约人
     */
    private String buyerSignatory;
    /**
     * 贸易方签约人
     */
    private  String tradeSignatory;
    /**
     * 辅合同名称
     */
    private String assistName;
    /**
     * 辅合同编号
     */
    private String assistContractNumber;
    /**
     * 辅合同数量
     */
    private Integer assistContractAmount;
    /**
     * 附件数量
     */
    private Integer attachmentAmount;

    /**
     * 未知
     * @return
     */
    private String entName;

    /**
     * 辅合同集合
     * @return
     */
    private List<AssistContract> assistContractList;

    public List<AssistContract> getAssistContractList() {
        return assistContractList;
    }

    public void setAssistContractList(List<AssistContract> assistContractList) {
        this.assistContractList = assistContractList;
    }

    public String getTradeEntName() {
        return tradeEntName;
    }

    public void setTradeEntName(String tradeEntName) {
        this.tradeEntName = tradeEntName;
    }

    public String getTradeSignatory() {
        return tradeSignatory;
    }

    public void setTradeSignatory(String tradeSignatory) {
        this.tradeSignatory = tradeSignatory;
    }

    public Integer getAttachmentAmount() {
        return attachmentAmount;
    }

    public void setAttachmentAmount(Integer attachmentAmount) {
        this.attachmentAmount = attachmentAmount;
    }

    public String getProcurementEntName() {
        return procurementEntName;
    }

    public void setProcurementEntName(String procurementEntName) {
        this.procurementEntName = procurementEntName;
    }

    public String getBuyerSignatory() {
        return buyerSignatory;
    }

    public void setBuyerSignatory(String buyerSignatory) {
        this.buyerSignatory = buyerSignatory;
    }

    public String getAssistName() {
        return assistName;
    }

    public void setAssistName(String assistName) {
        this.assistName = assistName;
    }

    public String getAssistContractNumber() {
        return assistContractNumber;
    }

    public void setAssistContractNumber(String assistContractNumber) {
        this.assistContractNumber = assistContractNumber;
    }

    public Integer getAssistContractAmount() {
        return assistContractAmount;
    }

    public void setAssistContractAmount(Integer assistContractAmount) {
        this.assistContractAmount = assistContractAmount;
    }




    public String getEntName() {
        return entName;
    }

    public void setEntName(String entName) {
        this.entName = entName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber == null ? null : contractNumber.trim();
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName == null ? null : contractName.trim();
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

    public String getSigningAddress() {
        return signingAddress;
    }

    public void setSigningAddress(String signingAddress) {
        this.signingAddress = signingAddress == null ? null : signingAddress.trim();
    }

    public Date getSigningTime() {
        return signingTime;
    }

    public void setSigningTime(Date signingTime) {
        this.signingTime = signingTime;
    }

    public Integer getTradeSignatoriesId() {
        return tradeSignatoriesId;
    }

    public void setTradeSignatoriesId(Integer tradeSignatoriesId) {
        this.tradeSignatoriesId = tradeSignatoriesId;
    }

    public Integer getBuyerSignatoryId() {
        return buyerSignatoryId;
    }

    public void setBuyerSignatoryId(Integer buyerSignatoryId) {
        this.buyerSignatoryId = buyerSignatoryId;
    }

    public Integer getAssistContractId() {
        return assistContractId;
    }

    public void setAssistContractId(Integer assistContractId) {
        this.assistContractId = assistContractId;
    }

    public Integer getOrderContractId() {
        return orderContractId;
    }

    public void setOrderContractId(Integer orderContractId) {
        this.orderContractId = orderContractId;
    }

    public Integer getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(Integer contractStatus) {
        this.contractStatus = contractStatus;
    }

    public String getContractLetterPerson() {
        return contractLetterPerson;
    }

    public void setContractLetterPerson(String contractLetterPerson) {
        this.contractLetterPerson = contractLetterPerson == null ? null : contractLetterPerson.trim();
    }

    public Double getContractCredit() {
        return contractCredit;
    }

    public void setContractCredit(Double contractCredit) {
        this.contractCredit = contractCredit;
    }

    public Double getContractLetter() {
        return contractLetter;
    }

    public void setContractLetter(Double contractLetter) {
        this.contractLetter = contractLetter;
    }

    public Date getContractCreateTime() {
        return contractCreateTime;
    }

    public void setContractCreateTime(Date contractCreateTime) {
        this.contractCreateTime = contractCreateTime;
    }

    public String getContractFounder() {
        return contractFounder;
    }

    public void setContractFounder(String contractFounder) {
        this.contractFounder = contractFounder == null ? null : contractFounder.trim();
    }

    public Integer getContractElectronicsId() {
        return contractElectronicsId;
    }

    public void setContractElectronicsId(Integer contractElectronicsId) {
        this.contractElectronicsId = contractElectronicsId;
    }

    public Integer getContractScanner() {
        return contractScanner;
    }

    public void setContractScanner(Integer contractScanner) {
        this.contractScanner = contractScanner;
    }

    public Integer getLetterApply() {
        return letterApply;
    }

    public void setLetterApply(Integer letterApply) {
        this.letterApply = letterApply;
    }


	public static long getSerialversionuid() {
		return serialVersionUID;
	}



    public Integer getContractBuyerId() {
		return contractBuyerId;
	}

	public void setContractBuyerId(Integer contractBuyerId) {
		this.contractBuyerId = contractBuyerId;
	}

	public Integer getContractTraderId() {
		return contractTraderId;
	}

	public void setContractTraderId(Integer contractTraderId) {
		this.contractTraderId = contractTraderId;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contract contract = (Contract) o;

        if (contractId != null ? !contractId.equals(contract.contractId) : contract.contractId != null) return false;
        if (contractNumber != null ? !contractNumber.equals(contract.contractNumber) : contract.contractNumber != null)
            return false;
        if (contractName != null ? !contractName.equals(contract.contractName) : contract.contractName != null)
            return false;
        if (contractBuyerId != null ? !contractBuyerId.equals(contract.contractBuyerId) : contract.contractBuyerId != null)
            return false;
        if (contractTraderId != null ? !contractTraderId.equals(contract.contractTraderId) : contract.contractTraderId != null)
            return false;
        if (creatTime != null ? !creatTime.equals(contract.creatTime) : contract.creatTime != null) return false;
        if (endTime != null ? !endTime.equals(contract.endTime) : contract.endTime != null) return false;
        if (signingAddress != null ? !signingAddress.equals(contract.signingAddress) : contract.signingAddress != null)
            return false;
        if (signingTime != null ? !signingTime.equals(contract.signingTime) : contract.signingTime != null)
            return false;
        if (tradeSignatoriesId != null ? !tradeSignatoriesId.equals(contract.tradeSignatoriesId) : contract.tradeSignatoriesId != null)
            return false;
        if (buyerSignatoryId != null ? !buyerSignatoryId.equals(contract.buyerSignatoryId) : contract.buyerSignatoryId != null)
            return false;
        if (assistContractId != null ? !assistContractId.equals(contract.assistContractId) : contract.assistContractId != null)
            return false;
        if (orderContractId != null ? !orderContractId.equals(contract.orderContractId) : contract.orderContractId != null)
            return false;
        if (contractStatus != null ? !contractStatus.equals(contract.contractStatus) : contract.contractStatus != null)
            return false;
        if (contractLetterPerson != null ? !contractLetterPerson.equals(contract.contractLetterPerson) : contract.contractLetterPerson != null)
            return false;
        if (contractCredit != null ? !contractCredit.equals(contract.contractCredit) : contract.contractCredit != null)
            return false;
        if (contractLetter != null ? !contractLetter.equals(contract.contractLetter) : contract.contractLetter != null)
            return false;
        if (contractCreateTime != null ? !contractCreateTime.equals(contract.contractCreateTime) : contract.contractCreateTime != null)
            return false;
        if (contractFounder != null ? !contractFounder.equals(contract.contractFounder) : contract.contractFounder != null)
            return false;
        if (contractElectronicsId != null ? !contractElectronicsId.equals(contract.contractElectronicsId) : contract.contractElectronicsId != null)
            return false;
        if (contractScanner != null ? !contractScanner.equals(contract.contractScanner) : contract.contractScanner != null)
            return false;
        return letterApply != null ? letterApply.equals(contract.letterApply) : contract.letterApply == null;
    }

    @Override
    public int hashCode() {
        int result = contractId != null ? contractId.hashCode() : 0;
        result = 31 * result + (contractNumber != null ? contractNumber.hashCode() : 0);
        result = 31 * result + (contractName != null ? contractName.hashCode() : 0);
        result = 31 * result + (contractBuyerId != null ? contractBuyerId.hashCode() : 0);
        result = 31 * result + (contractTraderId != null ? contractTraderId.hashCode() : 0);
        result = 31 * result + (creatTime != null ? creatTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (signingAddress != null ? signingAddress.hashCode() : 0);
        result = 31 * result + (signingTime != null ? signingTime.hashCode() : 0);
        result = 31 * result + (tradeSignatoriesId != null ? tradeSignatoriesId.hashCode() : 0);
        result = 31 * result + (buyerSignatoryId != null ? buyerSignatoryId.hashCode() : 0);
        result = 31 * result + (assistContractId != null ? assistContractId.hashCode() : 0);
        result = 31 * result + (orderContractId != null ? orderContractId.hashCode() : 0);
        result = 31 * result + (contractStatus != null ? contractStatus.hashCode() : 0);
        result = 31 * result + (contractLetterPerson != null ? contractLetterPerson.hashCode() : 0);
        result = 31 * result + (contractCredit != null ? contractCredit.hashCode() : 0);
        result = 31 * result + (contractLetter != null ? contractLetter.hashCode() : 0);
        result = 31 * result + (contractCreateTime != null ? contractCreateTime.hashCode() : 0);
        result = 31 * result + (contractFounder != null ? contractFounder.hashCode() : 0);
        result = 31 * result + (contractElectronicsId != null ? contractElectronicsId.hashCode() : 0);
        result = 31 * result + (contractScanner != null ? contractScanner.hashCode() : 0);
        result = 31 * result + (letterApply != null ? letterApply.hashCode() : 0);
        return result;
    }

	@Override
	public String toString() {
		return "Contract [contractId=" + contractId + ", contractNumber=" + contractNumber + ", contractName="
				+ contractName + ", contractBuyerId=" + contractBuyerId + ", contractTraderId=" + contractTraderId
				+ ", creatTime=" + creatTime + ", endTime=" + endTime + ", signingAddress=" + signingAddress
				+ ", signingTime=" + signingTime + ", tradeSignatoriesId=" + tradeSignatoriesId + ", buyerSignatoryId="
				+ buyerSignatoryId + ", assistContractId=" + assistContractId + ", orderContractId=" + orderContractId
				+ ", contractStatus=" + contractStatus + ", contractLetterPerson=" + contractLetterPerson
				+ ", contractCredit=" + contractCredit + ", contractLetter=" + contractLetter + ", contractCreateTime="
				+ contractCreateTime + ", contractFounder=" + contractFounder + ", contractElectronicsId="
				+ contractElectronicsId + ", contractScanner=" + contractScanner + ", letterApply=" + letterApply + "]";
	}
}