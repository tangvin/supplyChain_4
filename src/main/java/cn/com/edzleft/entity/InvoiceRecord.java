package cn.com.edzleft.entity;

import java.util.Date;

/**发票记录表
 * gyl_invoice_record
 */
public class InvoiceRecord {
    /**
     * id
     */
    private Integer id;
    /**
     * 发票编号
     */
    private String invoiceNumber;
    /**
     * 发票开票人（贸方）
     */
    private String invoiceDrawer;
    /**
     * 发票上传时间
     */
    private Date invoiceUploadTime;
    /**
     * 发票电子档附件
     */
    private String invoiceFileAttachment;
    /**
     * 发票抬头（采方名称）
     */
    private String invoiceTitle;
    /**
     * 税号（采方）
     */
    private String taxNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber == null ? null : invoiceNumber.trim();
    }

    public String getInvoiceDrawer() {
        return invoiceDrawer;
    }

    public void setInvoiceDrawer(String invoiceDrawer) {
        this.invoiceDrawer = invoiceDrawer == null ? null : invoiceDrawer.trim();
    }

    public Date getInvoiceUploadTime() {
        return invoiceUploadTime;
    }

    public void setInvoiceUploadTime(Date invoiceUploadTime) {
        this.invoiceUploadTime = invoiceUploadTime;
    }

    public String getInvoiceFileAttachment() {
        return invoiceFileAttachment;
    }

    public void setInvoiceFileAttachment(String invoiceFileAttachment) {
        this.invoiceFileAttachment = invoiceFileAttachment == null ? null : invoiceFileAttachment.trim();
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle == null ? null : invoiceTitle.trim();
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber == null ? null : taxNumber.trim();
    }

    @Override
    public String toString() {
        return "InvoiceRecord{" +
                "id=" + id +
                ", invoiceNumber='" + invoiceNumber + '\'' +
                ", invoiceDrawer='" + invoiceDrawer + '\'' +
                ", invoiceUploadTime=" + invoiceUploadTime +
                ", invoiceFileAttachment='" + invoiceFileAttachment + '\'' +
                ", invoiceTitle='" + invoiceTitle + '\'' +
                ", taxNumber='" + taxNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvoiceRecord that = (InvoiceRecord) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (invoiceNumber != null ? !invoiceNumber.equals(that.invoiceNumber) : that.invoiceNumber != null)
            return false;
        if (invoiceDrawer != null ? !invoiceDrawer.equals(that.invoiceDrawer) : that.invoiceDrawer != null)
            return false;
        if (invoiceUploadTime != null ? !invoiceUploadTime.equals(that.invoiceUploadTime) : that.invoiceUploadTime != null)
            return false;
        if (invoiceFileAttachment != null ? !invoiceFileAttachment.equals(that.invoiceFileAttachment) : that.invoiceFileAttachment != null)
            return false;
        if (invoiceTitle != null ? !invoiceTitle.equals(that.invoiceTitle) : that.invoiceTitle != null) return false;
        return taxNumber != null ? taxNumber.equals(that.taxNumber) : that.taxNumber == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (invoiceNumber != null ? invoiceNumber.hashCode() : 0);
        result = 31 * result + (invoiceDrawer != null ? invoiceDrawer.hashCode() : 0);
        result = 31 * result + (invoiceUploadTime != null ? invoiceUploadTime.hashCode() : 0);
        result = 31 * result + (invoiceFileAttachment != null ? invoiceFileAttachment.hashCode() : 0);
        result = 31 * result + (invoiceTitle != null ? invoiceTitle.hashCode() : 0);
        result = 31 * result + (taxNumber != null ? taxNumber.hashCode() : 0);
        return result;
    }
}