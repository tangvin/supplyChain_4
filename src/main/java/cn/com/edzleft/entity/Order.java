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
    private Date orderCreatTime;
    /**
     * 订单创建者（采方）
     */
    private Integer orderCreatorId;
    /**
     * 订单确认者（贸方）
     */
    private Integer orderCreatorTradeId;
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
     * 收货地址(关联到收货地址表)
     */
    private Integer receivingAddressId;
    /**
     * 收货联系人
     */
    private String logisticsName;
    /**
     * 收货联系人手机
     */
    private String contactPhone;
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

    /**
     * 发票编号
     * @return
     */
    private String invoiceNum;
    /**
     * 申请用信状态 0已提交 1拒绝 2同意
     */
    private Integer letterStatus;

    public Integer getLetterStatus() {
        return letterStatus;
    }

    public void setLetterStatus(Integer letterStatus) {
        this.letterStatus = letterStatus;
    }

    public Integer getCreditGetId() {
        return creditGetId;
    }

    public void setCreditGetId(Integer creditGetId) {
        this.creditGetId = creditGetId;
    }

    public void setCreditUseId(Integer creditUseId) {
        this.creditUseId = creditUseId;
    }

    public void setCreditGrantorId(Integer creditGrantorId) {
        this.creditGrantorId = creditGrantorId;
    }

    public void setPaymentAccountId(Integer paymentAccountId) {
        this.paymentAccountId = paymentAccountId;
    }

    public Integer getFreightNumberId() {
        return freightNumberId;
    }

    public String getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(String invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

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

    public Integer getOrderCreatorId() {
        return orderCreatorId;
    }

    public void setOrderCreatorId(Integer orderCreatorId) {
        this.orderCreatorId = orderCreatorId == null ? null : orderCreatorId;
    }

    public Integer getOrderCreatorTradeId() {
        return orderCreatorTradeId;
    }

    public void setOrderCreatorTradeId(Integer orderCreatorTradeId) {
        this.orderCreatorTradeId = orderCreatorTradeId == null ? null : orderCreatorTradeId;
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


    public Integer getReceivingAddressId() {
        return receivingAddressId;
    }

    public void setReceivingAddressId(Integer receivingAddressId) {
        this.receivingAddressId = receivingAddressId == null ? null : receivingAddressId;
    }

    public String getLogisticsName() {
        return logisticsName;
    }

    public void setLogisticsName(String logisticsName) {
        this.logisticsName = logisticsName == null ? null : logisticsName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public Integer getPrincipalOrderId() {
        return principalOrderId;
    }

    public void setPrincipalOrderId(Integer principalOrderId) {
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
        if (orderCreatorId != null ? !orderCreatorId.equals(order.orderCreatorId) : order.orderCreatorId != null) return false;
        if (orderCreatorTradeId != null ? !orderCreatorTradeId.equals(order.orderCreatorTradeId) : order.orderCreatorTradeId != null)
            return false;
        if (orderConfirmationTime != null ? !orderConfirmationTime.equals(order.orderConfirmationTime) : order.orderConfirmationTime != null)
            return false;
        if (orderStatus != null ? !orderStatus.equals(order.orderStatus) : order.orderStatus != null) return false;
        if (receivingAddressId != null ? !receivingAddressId.equals(order.receivingAddressId) : order.receivingAddressId != null)
            return false;
        if (logisticsName != null ? !logisticsName.equals(order.logisticsName) : order.logisticsName != null)
            return false;
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
        if (freightNumberId != null ? !freightNumberId.equals(order.freightNumberId) : order.freightNumberId != null)
            return false;
        if (goods != null ? !goods.equals(order.goods) : order.goods != null) return false;
        if (applicationletter != null ? !applicationletter.equals(order.applicationletter) : order.applicationletter != null)
            return false;
        if (invoiceNum != null ? !invoiceNum.equals(order.invoiceNum) : order.invoiceNum != null) return false;
        return letterStatus != null ? letterStatus.equals(order.letterStatus) : order.letterStatus == null;
    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (orderNumber != null ? orderNumber.hashCode() : 0);
        result = 31 * result + (orderCreatTime != null ? orderCreatTime.hashCode() : 0);
        result = 31 * result + (orderCreatorId != null ? orderCreatorId.hashCode() : 0);
        result = 31 * result + (orderCreatorTradeId != null ? orderCreatorTradeId.hashCode() : 0);
        result = 31 * result + (orderConfirmationTime != null ? orderConfirmationTime.hashCode() : 0);
        result = 31 * result + (orderStatus != null ? orderStatus.hashCode() : 0);
        result = 31 * result + (receivingAddressId != null ? receivingAddressId.hashCode() : 0);
        result = 31 * result + (logisticsName != null ? logisticsName.hashCode() : 0);
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
        result = 31 * result + (goods != null ? goods.hashCode() : 0);
        result = 31 * result + (applicationletter != null ? applicationletter.hashCode() : 0);
        result = 31 * result + (invoiceNum != null ? invoiceNum.hashCode() : 0);
        result = 31 * result + (letterStatus != null ? letterStatus.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderNumber='" + orderNumber + '\'' +
                ", orderCreatTime=" + orderCreatTime +
                ", orderCreatorId='" + orderCreatorId + '\'' +
                ", orderCreatorTradeId='" + orderCreatorTradeId + '\'' +
                ", orderConfirmationTime=" + orderConfirmationTime +
                ", orderStatus=" + orderStatus +
                ", receivingAddressId=" + receivingAddressId +
                ", logisticsName='" + logisticsName + '\'' +
                ", contactPhone=" + contactPhone +
                ", principalOrderId=" + principalOrderId +
                ", creditGetId=" + creditGetId +
                ", creditUseId=" + creditUseId +
                ", creditGrantorId=" + creditGrantorId +
                ", orderAmount=" + orderAmount +
                ", amountPayable=" + amountPayable +
                ", amountActuallyPaid=" + amountActuallyPaid +
                ", paymentAccountId=" + paymentAccountId +
                ", paymentTime=" + paymentTime +
                ", invoice='" + invoice + '\'' +
                ", freightUnit='" + freightUnit + '\'' +
                ", freightNumberId=" + freightNumberId +
                ", goods='" + goods + '\'' +
                ", applicationletter='" + applicationletter + '\'' +
                ", invoiceNum='" + invoiceNum + '\'' +
                '}';
    }
}