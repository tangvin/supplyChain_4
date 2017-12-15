package cn.com.edzleft.entity;

/**附件表
 * gyl_attachment
 */
public class Attachment {
    /**
     * id
     */
    private Integer attachmentId;
    /**
     * 附件url地址
     */
    private String attachmentUrl;
    /**
     * 来源/所属业务
     */
    private String attachmentSource;
    /**
     * 附件名称
     */
    private String attachmentName;
    /**
     * 关联合同id
     */
    private Integer attachmentCreditId;

    public Integer getAttachmentCreditId() {
        return attachmentCreditId;
    }

    public void setAttachmentCreditId(Integer attachmentCreditId) {
        this.attachmentCreditId = attachmentCreditId;
    }

    public Integer getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(Integer attachmentId) {
        this.attachmentId = attachmentId;
    }

    public String getAttachmentUrl() {
        return attachmentUrl;
    }

    public void setAttachmentUrl(String attachmentUrl) {
        this.attachmentUrl = attachmentUrl == null ? null : attachmentUrl.trim();
    }

    public String getAttachmentSource() {
        return attachmentSource;
    }

    public void setAttachmentSource(String attachmentSource) {
        this.attachmentSource = attachmentSource == null ? null : attachmentSource.trim();
    }

    public String getAttachmentName() {
        return attachmentName;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName == null ? null : attachmentName.trim();
    }

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attachment other = (Attachment) obj;
		if (attachmentCreditId == null) {
			if (other.attachmentCreditId != null)
				return false;
		} else if (!attachmentCreditId.equals(other.attachmentCreditId))
			return false;
		if (attachmentId == null) {
			if (other.attachmentId != null)
				return false;
		} else if (!attachmentId.equals(other.attachmentId))
			return false;
		if (attachmentName == null) {
			if (other.attachmentName != null)
				return false;
		} else if (!attachmentName.equals(other.attachmentName))
			return false;
		if (attachmentSource == null) {
			if (other.attachmentSource != null)
				return false;
		} else if (!attachmentSource.equals(other.attachmentSource))
			return false;
		if (attachmentUrl == null) {
			if (other.attachmentUrl != null)
				return false;
		} else if (!attachmentUrl.equals(other.attachmentUrl))
			return false;
		return true;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attachmentCreditId == null) ? 0 : attachmentCreditId.hashCode());
		result = prime * result + ((attachmentId == null) ? 0 : attachmentId.hashCode());
		result = prime * result + ((attachmentName == null) ? 0 : attachmentName.hashCode());
		result = prime * result + ((attachmentSource == null) ? 0 : attachmentSource.hashCode());
		result = prime * result + ((attachmentUrl == null) ? 0 : attachmentUrl.hashCode());
		return result;
	}

    @Override
	public String toString() {
		return "Attachment [attachmentId=" + attachmentId + ", attachmentUrl=" + attachmentUrl + ", attachmentSource="
				+ attachmentSource + ", attachmentName=" + attachmentName + ", attachmentCreditId=" + attachmentCreditId
				+ "]";
	}
}