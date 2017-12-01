package cn.com.edzleft.entity;

import java.util.Date;

/**
 * gyl_ukey
 * 证书
 */
public class Ukey {
    private Integer ukeyId;
    /**
     * ukey及证书的类型
     */
    private String ukeyType;
    /**
     * 颁发人
     */
    private String issuedPeople;
    /**
     * 颁发时间
     */
    private Date issuedTime;
    /**
     * key及证书的状态
     */
    private Integer ukeyStatus;
    /**
     * ukey及证书名字
     */
    private Integer ukeyFilename;
    /**
     * ukey及证书的用户id
     */
    private Integer userId;
    
    private String attachmentName;
    private String attachmentUrl;

    public String getAttachmentName() {
		return attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	public String getAttachmentUrl() {
		return attachmentUrl;
	}

	public void setAttachmentUrl(String attachmentUrl) {
		this.attachmentUrl = attachmentUrl;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUkeyId() {
        return ukeyId;
    }

    public void setUkeyId(Integer ukeyId) {
        this.ukeyId = ukeyId;
    }

    public String getUkeyType() {
        return ukeyType;
    }

    public void setUkeyType(String ukeyType) {
        this.ukeyType = ukeyType == null ? null : ukeyType.trim();
    }

    public String getIssuedPeople() {
        return issuedPeople;
    }

    public void setIssuedPeople(String issuedPeople) {
        this.issuedPeople = issuedPeople == null ? null : issuedPeople.trim();
    }

    public Date getIssuedTime() {
        return issuedTime;
    }

    public void setIssuedTime(Date issuedTime) {
        this.issuedTime = issuedTime;
    }

    public Integer getUkeyStatus() {
        return ukeyStatus;
    }

    public void setUkeyStatus(Integer ukeyStatus) {
        this.ukeyStatus = ukeyStatus == null ? null : ukeyStatus;
    }

    public Integer getUkeyFilename() {
        return ukeyFilename;
    }

    public void setUkeyFilename(Integer ukeyFilename) {
        this.ukeyFilename = ukeyFilename == null ? null : ukeyFilename;
    }

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ukey other = (Ukey) obj;
		if (attachmentName == null) {
			if (other.attachmentName != null)
				return false;
		} else if (!attachmentName.equals(other.attachmentName))
			return false;
		if (attachmentUrl == null) {
			if (other.attachmentUrl != null)
				return false;
		} else if (!attachmentUrl.equals(other.attachmentUrl))
			return false;
		if (issuedPeople == null) {
			if (other.issuedPeople != null)
				return false;
		} else if (!issuedPeople.equals(other.issuedPeople))
			return false;
		if (issuedTime == null) {
			if (other.issuedTime != null)
				return false;
		} else if (!issuedTime.equals(other.issuedTime))
			return false;
		if (ukeyFilename == null) {
			if (other.ukeyFilename != null)
				return false;
		} else if (!ukeyFilename.equals(other.ukeyFilename))
			return false;
		if (ukeyId == null) {
			if (other.ukeyId != null)
				return false;
		} else if (!ukeyId.equals(other.ukeyId))
			return false;
		if (ukeyStatus == null) {
			if (other.ukeyStatus != null)
				return false;
		} else if (!ukeyStatus.equals(other.ukeyStatus))
			return false;
		if (ukeyType == null) {
			if (other.ukeyType != null)
				return false;
		} else if (!ukeyType.equals(other.ukeyType))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attachmentName == null) ? 0 : attachmentName.hashCode());
		result = prime * result + ((attachmentUrl == null) ? 0 : attachmentUrl.hashCode());
		result = prime * result + ((issuedPeople == null) ? 0 : issuedPeople.hashCode());
		result = prime * result + ((issuedTime == null) ? 0 : issuedTime.hashCode());
		result = prime * result + ((ukeyFilename == null) ? 0 : ukeyFilename.hashCode());
		result = prime * result + ((ukeyId == null) ? 0 : ukeyId.hashCode());
		result = prime * result + ((ukeyStatus == null) ? 0 : ukeyStatus.hashCode());
		result = prime * result + ((ukeyType == null) ? 0 : ukeyType.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

    @Override
	public String toString() {
		return "Ukey [ukeyId=" + ukeyId + ", ukeyType=" + ukeyType + ", issuedPeople=" + issuedPeople + ", issuedTime="
				+ issuedTime + ", ukeyStatus=" + ukeyStatus + ", ukeyFilename=" + ukeyFilename + ", userId=" + userId
				+ ", attachmentName=" + attachmentName + ", attachmentUrl=" + attachmentUrl + "]";
	}
}