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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attachment that = (Attachment) o;

        if (attachmentId != null ? !attachmentId.equals(that.attachmentId) : that.attachmentId != null) return false;
        if (attachmentUrl != null ? !attachmentUrl.equals(that.attachmentUrl) : that.attachmentUrl != null)
            return false;
        if (attachmentSource != null ? !attachmentSource.equals(that.attachmentSource) : that.attachmentSource != null)
            return false;
        return attachmentName != null ? attachmentName.equals(that.attachmentName) : that.attachmentName == null;
    }

    @Override
    public int hashCode() {
        int result = attachmentId != null ? attachmentId.hashCode() : 0;
        result = 31 * result + (attachmentUrl != null ? attachmentUrl.hashCode() : 0);
        result = 31 * result + (attachmentSource != null ? attachmentSource.hashCode() : 0);
        result = 31 * result + (attachmentName != null ? attachmentName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "attachmentId=" + attachmentId +
                ", attachmentUrl='" + attachmentUrl + '\'' +
                ", attachmentSource='" + attachmentSource + '\'' +
                ", attachmentName='" + attachmentName + '\'' +
                '}';
    }
}