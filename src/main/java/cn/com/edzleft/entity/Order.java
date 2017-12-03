package cn.com.edzleft.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**订单表
 * gyl_order
 */
public class Order {
    /**
     * 订单ID
     */
    private Integer orderId;
    /**
     * 订单编号
     */
    private String orderNumber;
    /**
     * 订单创建时间
     */
    @JSONField(format="yyyy-MM-dd")
    private Date orderCreatTime;
    /**
     * 订单创建者（采方）
     */
    private String orderCreator;
    /**
     * 订单确认者（贸方）
     */
    private String orderCreatorTrade;
    /**
     * 订单确认时间
     */
    @JSONField(format="yyyy-MM-dd")
    private Date orderConfirmationTime;
    /**
     * 订单状态
     */
    private Integer orderStatus;
    /**
     * 订单物流运货单位(关联到运货单位表)
     */
    private Integer logisticsUnitId;
    /**
     * 订单物流运单编号(关联到运货单位表)
     */
    private String logisticsNum;
    /**
     * 收货地址(关联到收货地址表)
     */
    private Integer receivingAddressId;
    /**
     * 收货联系人
     */
    private String ogisticsName;
    /**
     * 收货联系人手机
     */
    private Integer contactPhone;
    /**
     * 订单所属主合同(关联到合同表)
     */
    private Integer principalOrderId;
    /**
     * 订单所获授信(关联到授信表)
     */
    private Integer creditGetId;
    /**
     * 订单所用授信(关联到用信表)
     */
    private Integer creditUseId;
    /**
     * 授信人(关联到基本资料表)
     */
    private Integer creditGrantorId;
    /**
     * 订单金额
     */
    private Double orderAmount;
    /**
     * 应付金额
     */
    private Double amountPayable;
    /**
     * 实付金额
     */
    private Integer amountActuallyPaid;
    /**
     * 支付账号(关联到三方账户表)
     */
    private Integer paymentAccountId;
    /**
     * 支付时间(关联到三方账户表)
     */
    @JSONField(format="yyyy-MM-dd")
    private Date paymentTime;
    /**
     * 发票
     */
    private String invoice;
    /**
     * 货运单位
     */
    private String freightUnit;
    /**
     * 货运单号
     */
    private Integer freightNumberId;
    /**
     * 货物商品
     */
    private String goods;
    
    /**
     * 申请用信
     * @return
     */

    private String applicationletter;
    
    public String getApplicationletter() {
		return applicationletter;
	}

	public void setApplicationletter(String applicationletter) {
		this.applicationletter = applicationletter;
	}

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}

	public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public Date getOrderCreatTime() {
        return orderCreatTime;
    }

    public void setOrderCreatTime(Date orderCreatTime) {
        this.orderCreatTime = orderCreatTime;
    }

    public String getOrderCreator() {
        return orderCreator;
    }

    public void setOrderCreator(String orderCreator) {
        this.orderCreator = orderCreator == null ? null : orderCreator.trim();
    }

    public String getOrderCreatorTrade() {
        return orderCreatorTrade;
    }

    public void setOrderCreatorTrade(String orderCreatorTrade) {
        this.orderCreatorTrade = orderCreatorTrade == null ? null : orderCreatorTrade.trim();
    }

    public Date getOrderConfirmationTime() {
        return orderConfirmationTime;
    }

    public void setOrderConfirmationTime(Date orderConfirmationTime) {
        this.orderConfirmationTime = orderConfirmationTime;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getLogisticsUnitId() {
        return logisticsUnitId;
    }

    public void setLogisticsUnitId(Integer logisticsUnitId) {
        this.logisticsUnitId = logisticsUnitId == null ? null : logisticsUnitId;
    }

    public String getLogisticsNum() {
        return logisticsNum;
    }

    public void setLogisticsNum(Integer logisticsNumId) {
        this.logisticsNum = logisticsNum == null ? null : logisticsNum;
    }

   

    public Integer getReceivingAddressId() {
		return receivingAddressId;
	}

	public void setReceivingAddressId(Integer receivingAddressId) {
		this.receivingAddressId = receivingAddressId;
	}

	public String getOgisticsName() {
        return ogisticsName;
    }

    public void setOgisticsName(String ogisticsName) {
        this.ogisticsName = ogisticsName == null ? null : ogisticsName.trim();
    }

    public Integer getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(Integer contactPhone) {
        this.contactPhone = contactPhone;
    }

    public Integer getPrincipalOrderId() {
        return principalOrderId;
    }

    public void setPrincipalOrderId(Integer principalOrder) {
        this.principalOrderId = principalOrderId;
    }

    public Integer getCreditGet() {
        return creditGetId;
    }

    public void setCreditGet(Integer creditGet) {
        this.creditGetId = creditGetId;
    }

    public Integer getCreditUseId() {
        return creditUseId;
    }

    public void setCreditUse(Integer creditUse) {
        this.creditUseId = creditUseId;
    }

    public Integer getCreditGrantorId() {
        return creditGrantorId;
    }

    public void setCreditGrantor(Integer creditGrantor) {
        this.creditGrantorId = creditGrantorId == null ? null : creditGrantorId;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Double getAmountPayable() {
        return amountPayable;
    }

    public void setAmountPayable(Double amountPayable) {
        this.amountPayable = amountPayable;
    }

    public Integer getAmountActuallyPaid() {
        return amountActuallyPaid;
    }

    public void setAmountActuallyPaid(Integer amountActuallyPaid) {
        this.amountActuallyPaid = amountActuallyPaid;
    }

    public Integer getPaymentAccountId() {
        return paymentAccountId;
    }

    public void setPaymentAccount(String paymentAccount) {
        this.paymentAccountId = paymentAccountId == null ? null : paymentAccountId;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getFreightUnit() {
        return freightUnit;
    }

    public void setFreightUnit(String freightUnit) {
        this.freightUnit = freightUnit;
    }

    public Integer getFreightNumber() {
        return freightNumberId;
    }

    public void setFreightNumberId(Integer freightNumberId) {
        this.freightNumberId = freightNumberId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (orderId != null ? !orderId.equals(order.orderId) : order.orderId != null) return false;
        if (orderNumber != null ? !orderNumber.equals(order.orderNumber) : order.orderNumber != null) return false;
        if (orderCreatTime != null ? !orderCreatTime.equals(order.orderCreatTime) : order.orderCreatTime != null)
            return false;
        if (orderCreator != null ? !orderCreator.equals(order.orderCreator) : order.orderCreator != null) return false;
        if (orderCreatorTrade != null ? !orderCreatorTrade.equals(order.orderCreatorTrade) : order.orderCreatorTrade != null)
            return false;
        if (orderConfirmationTime != null ? !orderConfirmationTime.equals(order.orderConfirmationTime) : order.orderConfirmationTime != null)
            return false;
        if (orderStatus != null ? !orderStatus.equals(order.orderStatus) : order.orderStatus != null) return false;
        if (logisticsUnitId != null ? !logisticsUnitId.equals(order.logisticsUnitId) : order.logisticsUnitId != null)
            return false;
        if (logisticsNum != null ? !logisticsNum.equals(order.logisticsNum) : order.logisticsNum != null) return false;
        if (receivingAddressId != null ? !receivingAddressId.equals(order.receivingAddressId) : order.receivingAddressId != null)
            return false;
        if (ogisticsName != null ? !ogisticsName.equals(order.ogisticsName) : order.ogisticsName != null) return false;
        if (contactPhone != null ? !contactPhone.equals(order.contactPhone) : order.contactPhone != null) return false;
        if (principalOrderId != null ? !principalOrderId.equals(order.principalOrderId) : order.principalOrderId != null)
            return false;
            if (creditGetId != null ? !creditGetId.equals(order.creditGetId) : order.creditGetId != null) return false;
        if (creditUseId != null ? !creditUseId.equals(order.creditUseId) : order.creditUseId != null) return false;
        if (creditGrantorId != null ? !creditGrantorId.equals(order.creditGrantorId) : order.creditGrantorId != null)
            return false;
        if (orderAmount != null ? !orderAmount.equals(order.orderAmount) : order.orderAmount != null) return false;
        if (amountPayable != null ? !amountPayable.equals(order.amountPayable) : order.amountPayable != null)
            return false;
        if (amountActuallyPaid != null ? !amountActuallyPaid.equals(order.amountActuallyPaid) : order.amountActuallyPaid != null)
            return false;
        if (paymentAccountId != null ? !paymentAccountId.equals(order.paymentAccountId) : order.paymentAccountId != null)
            return false;
        if (paymentTime != null ? !paymentTime.equals(order.paymentTime) : order.paymentTime != null) return false;
        if (invoice != null ? !invoice.equals(order.invoice) : order.invoice != null) return false;
        if (freightUnit != null ? !freightUnit.equals(order.freightUnit) : order.freightUnit != null) return false;
        return freightNumberId != null ? freightNumberId.equals(order.freightNumberId) : order.freightNumberId == null;
    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (orderNumber != null ? orderNumber.hashCode() : 0);
        result = 31 * result + (orderCreatTime != null ? orderCreatTime.hashCode() : 0);
        result = 31 * result + (orderCreator != null ? orderCreator.hashCode() : 0);
        result = 31 * result + (orderCreatorTrade != null ? orderCreatorTrade.hashCode() : 0);
        result = 31 * result + (orderConfirmationTime != null ? orderConfirmationTime.hashCode() : 0);
        result = 31 * result + (orderStatus != null ? orderStatus.hashCode() : 0);
        result = 31 * result + (logisticsUnitId != null ? logisticsUnitId.hashCode() : 0);
        result = 31 * result + (logisticsNum != null ? logisticsNum.hashCode() : 0);
        result = 31 * result + (receivingAddressId != null ? receivingAddressId.hashCode() : 0);
        result = 31 * result + (ogisticsName != null ? ogisticsName.hashCode() : 0);
        result = 31 * result + (contactPhone != null ? contactPhone.hashCode() : 0);
        result = 31 * result + (principalOrderId != null ? principalOrderId.hashCode() : 0);
        result = 31 * result + (creditGetId != null ? creditGetId.hashCode() : 0);
        result = 31 * result + (creditUseId != null ? creditUseId.hashCode() : 0);
        result = 31 * result + (creditGrantorId != null ? creditGrantorId.hashCode() : 0);
        result = 31 * result + (orderAmount != null ? orderAmount.hashCode() : 0);
        result = 31 * result + (amountPayable != null ? amountPayable.hashCode() : 0);
        result = 31 * result + (amountActuallyPaid != null ? amountActuallyPaid.hashCode() : 0);
        result = 31 * result + (paymentAccountId != null ? paymentAccountId.hashCode() : 0);
        result = 31 * result + (paymentTime != null ? paymentTime.hashCode() : 0);
        result = 31 * result + (invoice != null ? invoice.hashCode() : 0);
        result = 31 * result + (freightUnit != null ? freightUnit.hashCode() : 0);
        result = 31 * result + (freightNumberId != null ? freightNumberId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderNumber='" + orderNumber + '\'' +
                ", orderCreatTime=" + orderCreatTime +
                ", orderCreator='" + orderCreator + '\'' +
                ", orderCreatorTrade='" + orderCreatorTrade + '\'' +
                ", orderConfirmationTime=" + orderConfirmationTime +
                ", orderStatus=" + orderStatus +
                ", logisticsUnitId='" + logisticsUnitId + '\'' +
                ", logisticsNum='" + logisticsNum + '\'' +
                ", receivingAddressId='" + receivingAddressId + '\'' +
                ", ogisticsName='" + ogisticsName + '\'' +
                ", contactPhone=" + contactPhone +
                ", principalOrderId=" + principalOrderId +
                ", creditGetId=" + creditGetId +
                ", creditUseId=" + creditUseId +
                ", creditGrantorId='" + creditGrantorId + '\'' +
                ", orderAmount=" + orderAmount +
                ", amountPayable=" + amountPayable +
                ", amountActuallyPaid=" + amountActuallyPaid +
                ", paymentAccountId='" + paymentAccountId + '\'' +
                ", paymentTime=" + paymentTime +
                ", invoice='" + invoice + '\'' +
                ", freightUnit='" + freightUnit + '\'' +
                ", freightNumberId='" + freightNumberId + '\'' +
                '}';
    }


}