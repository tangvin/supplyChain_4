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
     * 发票编号(自动生成)
     */
    private String invoiceNumber;
    /**
     * 发票开票人（贸方）id
     */
    private Integer userId;
   
	/**
     * 发票创建时间
     */
    private Date createTime;
    /**
     * 发票电子档附件
     */
    private Integer invoiceFileAttachment;
    /**
     * 发票号码
     */
    private String invoiceNo;
    /**
     * 所属订单id
     */
    private Integer orderId;
    /**
     * 收票人(采方)
     */
    private Integer invoiceUserId;
    
    private String drawer;
    private String checkTaker;
    private String orderNumber;
    private String attachmentUrl;
    
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
		this.invoiceNumber = invoiceNumber;
	}
	public Integer getUserId() {
			return userId;
		}
	public void setUserId(Integer userId) {
			this.userId = userId;
		}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getInvoiceFileAttachment() {
		return invoiceFileAttachment;
	}
	public void setInvoiceFileAttachment(Integer invoiceFileAttachment) {
		this.invoiceFileAttachment = invoiceFileAttachment;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	public Integer getInvoiceUserId() {
		return invoiceUserId;
	}
	public void setInvoiceUserId(Integer invoiceUserId) {
		this.invoiceUserId = invoiceUserId;
	}
	
	public String getDrawer() {
		return drawer;
	}
	public void setDrawer(String drawer) {
		this.drawer = drawer;
	}
	public String getCheckTaker() {
		return checkTaker;
	}
	public void setCheckTaker(String checkTaker) {
		this.checkTaker = checkTaker;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getAttachmentUrl() {
		return attachmentUrl;
	}
	public void setAttachmentUrl(String attachmentUrl) {
		this.attachmentUrl = attachmentUrl;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attachmentUrl == null) ? 0 : attachmentUrl.hashCode());
		result = prime * result + ((checkTaker == null) ? 0 : checkTaker.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((drawer == null) ? 0 : drawer.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((invoiceFileAttachment == null) ? 0 : invoiceFileAttachment.hashCode());
		result = prime * result + ((invoiceNo == null) ? 0 : invoiceNo.hashCode());
		result = prime * result + ((invoiceNumber == null) ? 0 : invoiceNumber.hashCode());
		result = prime * result + ((invoiceUserId == null) ? 0 : invoiceUserId.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((orderNumber == null) ? 0 : orderNumber.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceRecord other = (InvoiceRecord) obj;
		if (attachmentUrl == null) {
			if (other.attachmentUrl != null)
				return false;
		} else if (!attachmentUrl.equals(other.attachmentUrl))
			return false;
		if (checkTaker == null) {
			if (other.checkTaker != null)
				return false;
		} else if (!checkTaker.equals(other.checkTaker))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (drawer == null) {
			if (other.drawer != null)
				return false;
		} else if (!drawer.equals(other.drawer))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (invoiceFileAttachment == null) {
			if (other.invoiceFileAttachment != null)
				return false;
		} else if (!invoiceFileAttachment.equals(other.invoiceFileAttachment))
			return false;
		if (invoiceNo == null) {
			if (other.invoiceNo != null)
				return false;
		} else if (!invoiceNo.equals(other.invoiceNo))
			return false;
		if (invoiceNumber == null) {
			if (other.invoiceNumber != null)
				return false;
		} else if (!invoiceNumber.equals(other.invoiceNumber))
			return false;
		if (invoiceUserId == null) {
			if (other.invoiceUserId != null)
				return false;
		} else if (!invoiceUserId.equals(other.invoiceUserId))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (orderNumber == null) {
			if (other.orderNumber != null)
				return false;
		} else if (!orderNumber.equals(other.orderNumber))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "InvoiceRecord [id=" + id + ", invoiceNumber=" + invoiceNumber + ", userId=" + userId + ", createTime="
				+ createTime + ", invoiceFileAttachment=" + invoiceFileAttachment + ", invoiceNo=" + invoiceNo
				+ ", orderId=" + orderId + ", invoiceUserId=" + invoiceUserId + ", drawer=" + drawer + ", checkTaker="
				+ checkTaker + ", orderNumber=" + orderNumber + ", attachmentUrl=" + attachmentUrl + "]";
	}
   
}