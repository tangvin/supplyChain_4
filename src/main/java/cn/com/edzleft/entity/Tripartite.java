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
    private Integer tripartiteCreditHolderTradeId;
    /**
     * 户主（采方）
     */
    private Integer tripartiteCreditHolderPurchaserId;
    /**
     * 户主(资方）
     */
    private Integer tripartiteCreditHolderCapitalId;
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
    private String pmEntName;
    /**
     * （贸易商）
     */
    private String trEntName;
    /**
     * （资方）
     */
    private String caEntName;
//户主  采购方
    private String entName;


    public String getEntName() {
        return entName;
    }

    public void setEntName(String entName) {
        this.entName = entName;
    }
    public Integer getTripartiteCreditHolderTradeId() {
		return tripartiteCreditHolderTradeId;
	}

	public void setTripartiteCreditHolderTradeId(Integer tripartiteCreditHolderTradeId) {
		this.tripartiteCreditHolderTradeId = tripartiteCreditHolderTradeId;
	}

	public Integer getTripartiteCreditHolderPurchaserId() {
		return tripartiteCreditHolderPurchaserId;
	}

	public void setTripartiteCreditHolderPurchaserId(Integer tripartiteCreditHolderPurchaserId) {
		this.tripartiteCreditHolderPurchaserId = tripartiteCreditHolderPurchaserId;
	}

	public Integer getTripartiteCreditHolderCapitalId() {
		return tripartiteCreditHolderCapitalId;
	}

	public void setTripartiteCreditHolderCapitalId(Integer tripartiteCreditHolderCapitalId) {
		this.tripartiteCreditHolderCapitalId = tripartiteCreditHolderCapitalId;
	}

	public String getPmEntName() {
		return pmEntName;
	}

	public void setPmEntName(String pmEntName) {
		this.pmEntName = pmEntName;
	}

	public String getTrEntName() {
		return trEntName;
	}

	public void setTrEntName(String trEntName) {
		this.trEntName = trEntName;
	}

	public String getCaEntName() {
		return caEntName;
	}

	public void setCaEntName(String caEntName) {
		this.caEntName = caEntName;
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
		return "Tripartite [tripartiteId=" + tripartiteId + ", tripartiteDepositBank=" + tripartiteDepositBank
				+ ", tripartiteCreditHolderTradeId=" + tripartiteCreditHolderTradeId
				+ ", tripartiteCreditHolderPurchaserId=" + tripartiteCreditHolderPurchaserId
				+ ", tripartiteCreditHolderCapitalId=" + tripartiteCreditHolderCapitalId + ", tripartiteAccountNumber="
				+ tripartiteAccountNumber + ", tripartiteAccountOpentime=" + tripartiteAccountOpentime
				+ ", tripartiteAccountOpenpeople=" + tripartiteAccountOpenpeople + ", tripartiteBalance="
				+ tripartiteBalance + ", tripartiteAvailableBalance=" + tripartiteAvailableBalance
				+ ", tripartiteAmountCreateTime=" + tripartiteAmountCreateTime + ", tripartiteAmountCreatePeople="
				+ tripartiteAmountCreatePeople + ", pmEntName=" + pmEntName + ", trEntName=" + trEntName
				+ ", caEntName=" + caEntName + "]";
	}


    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((caEntName == null) ? 0 : caEntName.hashCode());
		result = prime * result + ((pmEntName == null) ? 0 : pmEntName.hashCode());
		result = prime * result + ((trEntName == null) ? 0 : trEntName.hashCode());
		result = prime * result + ((tripartiteAccountNumber == null) ? 0 : tripartiteAccountNumber.hashCode());
		result = prime * result + ((tripartiteAccountOpenpeople == null) ? 0 : tripartiteAccountOpenpeople.hashCode());
		result = prime * result + ((tripartiteAccountOpentime == null) ? 0 : tripartiteAccountOpentime.hashCode());
		result = prime * result
				+ ((tripartiteAmountCreatePeople == null) ? 0 : tripartiteAmountCreatePeople.hashCode());
		result = prime * result + ((tripartiteAmountCreateTime == null) ? 0 : tripartiteAmountCreateTime.hashCode());
		result = prime * result + ((tripartiteAvailableBalance == null) ? 0 : tripartiteAvailableBalance.hashCode());
		result = prime * result + ((tripartiteBalance == null) ? 0 : tripartiteBalance.hashCode());
		result = prime * result
				+ ((tripartiteCreditHolderCapitalId == null) ? 0 : tripartiteCreditHolderCapitalId.hashCode());
		result = prime * result
				+ ((tripartiteCreditHolderPurchaserId == null) ? 0 : tripartiteCreditHolderPurchaserId.hashCode());
		result = prime * result
				+ ((tripartiteCreditHolderTradeId == null) ? 0 : tripartiteCreditHolderTradeId.hashCode());
		result = prime * result + ((tripartiteDepositBank == null) ? 0 : tripartiteDepositBank.hashCode());
		result = prime * result + ((tripartiteId == null) ? 0 : tripartiteId.hashCode());
		return result;
	}
}