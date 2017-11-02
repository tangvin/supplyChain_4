package cn.com.edzleft.entity;

import java.util.Date;

/**订单表
 * gyl_oreder
 */
public class Order {
    /**
     * 订单ID
     */
    private Integer orderId;
    /**
     * 订单编号
     */
    private String orederNumber;
    /**
     * 订单创建时间
     */
    private Date orederCreatTime;
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
    private Date orderConfirmationTime;
    /**
     * 订单状态
     */
    private Integer orderStatus;
    /**
     * 订单物流运货单位(关联到运货单位表)
     */
    private String logisticsUnit;
    /**
     * 订单物流运单编号(关联到运货单位表)
     */
    private String logisticsNum;
    /**
     * 收货地址(关联到收货地址表)
     */
    private String receivingAddress;
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
    private Integer principalOrder;
    /**
     * 订单所获授信(关联到授信表)
     */
    private Integer creditGet;
    /**
     * 订单所用授信(关联到用信表)
     */
    private Integer creditUse;
    /**
     * 授信人(关联到基本资料表)
     */
    private String creditGrantor;
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
    private String paymentAccount;
    /**
     * 支付时间(关联到三方账户表)
     */
    private Date paymentTime;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrederNumber() {
        return orederNumber;
    }

    public void setOrederNumber(String orederNumber) {
        this.orederNumber = orederNumber == null ? null : orederNumber.trim();
    }

    public Date getOrederCreatTime() {
        return orederCreatTime;
    }

    public void setOrederCreatTime(Date orederCreatTime) {
        this.orederCreatTime = orederCreatTime;
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

    public String getLogisticsUnit() {
        return logisticsUnit;
    }

    public void setLogisticsUnit(String logisticsUnit) {
        this.logisticsUnit = logisticsUnit == null ? null : logisticsUnit.trim();
    }

    public String getLogisticsNum() {
        return logisticsNum;
    }

    public void setLogisticsNum(String logisticsNum) {
        this.logisticsNum = logisticsNum == null ? null : logisticsNum.trim();
    }

    public String getReceivingAddress() {
        return receivingAddress;
    }

    public void setReceivingAddress(String receivingAddress) {
        this.receivingAddress = receivingAddress == null ? null : receivingAddress.trim();
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

    public Integer getPrincipalOrder() {
        return principalOrder;
    }

    public void setPrincipalOrder(Integer principalOrder) {
        this.principalOrder = principalOrder;
    }

    public Integer getCreditGet() {
        return creditGet;
    }

    public void setCreditGet(Integer creditGet) {
        this.creditGet = creditGet;
    }

    public Integer getCreditUse() {
        return creditUse;
    }

    public void setCreditUse(Integer creditUse) {
        this.creditUse = creditUse;
    }

    public String getCreditGrantor() {
        return creditGrantor;
    }

    public void setCreditGrantor(String creditGrantor) {
        this.creditGrantor = creditGrantor == null ? null : creditGrantor.trim();
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

    public String getPaymentAccount() {
        return paymentAccount;
    }

    public void setPaymentAccount(String paymentAccount) {
        this.paymentAccount = paymentAccount == null ? null : paymentAccount.trim();
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orederNumber='" + orederNumber + '\'' +
                ", orederCreatTime=" + orederCreatTime +
                ", orderCreator='" + orderCreator + '\'' +
                ", orderCreatorTrade='" + orderCreatorTrade + '\'' +
                ", orderConfirmationTime=" + orderConfirmationTime +
                ", orderStatus=" + orderStatus +
                ", logisticsUnit='" + logisticsUnit + '\'' +
                ", logisticsNum='" + logisticsNum + '\'' +
                ", receivingAddress='" + receivingAddress + '\'' +
                ", ogisticsName='" + ogisticsName + '\'' +
                ", contactPhone=" + contactPhone +
                ", principalOrder=" + principalOrder +
                ", creditGet=" + creditGet +
                ", creditUse=" + creditUse +
                ", creditGrantor='" + creditGrantor + '\'' +
                ", orderAmount=" + orderAmount +
                ", amountPayable=" + amountPayable +
                ", amountActuallyPaid=" + amountActuallyPaid +
                ", paymentAccount='" + paymentAccount + '\'' +
                ", paymentTime=" + paymentTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (orderId != null ? !orderId.equals(order.orderId) : order.orderId != null) return false;
        if (orederNumber != null ? !orederNumber.equals(order.orederNumber) : order.orederNumber != null) return false;
        if (orederCreatTime != null ? !orederCreatTime.equals(order.orederCreatTime) : order.orederCreatTime != null)
            return false;
        if (orderCreator != null ? !orderCreator.equals(order.orderCreator) : order.orderCreator != null) return false;
        if (orderCreatorTrade != null ? !orderCreatorTrade.equals(order.orderCreatorTrade) : order.orderCreatorTrade != null)
            return false;
        if (orderConfirmationTime != null ? !orderConfirmationTime.equals(order.orderConfirmationTime) : order.orderConfirmationTime != null)
            return false;
        if (orderStatus != null ? !orderStatus.equals(order.orderStatus) : order.orderStatus != null) return false;
        if (logisticsUnit != null ? !logisticsUnit.equals(order.logisticsUnit) : order.logisticsUnit != null)
            return false;
        if (logisticsNum != null ? !logisticsNum.equals(order.logisticsNum) : order.logisticsNum != null) return false;
        if (receivingAddress != null ? !receivingAddress.equals(order.receivingAddress) : order.receivingAddress != null)
            return false;
        if (ogisticsName != null ? !ogisticsName.equals(order.ogisticsName) : order.ogisticsName != null) return false;
        if (contactPhone != null ? !contactPhone.equals(order.contactPhone) : order.contactPhone != null) return false;
        if (principalOrder != null ? !principalOrder.equals(order.principalOrder) : order.principalOrder != null)
            return false;
        if (creditGet != null ? !creditGet.equals(order.creditGet) : order.creditGet != null) return false;
        if (creditUse != null ? !creditUse.equals(order.creditUse) : order.creditUse != null) return false;
        if (creditGrantor != null ? !creditGrantor.equals(order.creditGrantor) : order.creditGrantor != null)
            return false;
        if (orderAmount != null ? !orderAmount.equals(order.orderAmount) : order.orderAmount != null) return false;
        if (amountPayable != null ? !amountPayable.equals(order.amountPayable) : order.amountPayable != null)
            return false;
        if (amountActuallyPaid != null ? !amountActuallyPaid.equals(order.amountActuallyPaid) : order.amountActuallyPaid != null)
            return false;
        if (paymentAccount != null ? !paymentAccount.equals(order.paymentAccount) : order.paymentAccount != null)
            return false;
        return paymentTime != null ? paymentTime.equals(order.paymentTime) : order.paymentTime == null;
    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (orederNumber != null ? orederNumber.hashCode() : 0);
        result = 31 * result + (orederCreatTime != null ? orederCreatTime.hashCode() : 0);
        result = 31 * result + (orderCreator != null ? orderCreator.hashCode() : 0);
        result = 31 * result + (orderCreatorTrade != null ? orderCreatorTrade.hashCode() : 0);
        result = 31 * result + (orderConfirmationTime != null ? orderConfirmationTime.hashCode() : 0);
        result = 31 * result + (orderStatus != null ? orderStatus.hashCode() : 0);
        result = 31 * result + (logisticsUnit != null ? logisticsUnit.hashCode() : 0);
        result = 31 * result + (logisticsNum != null ? logisticsNum.hashCode() : 0);
        result = 31 * result + (receivingAddress != null ? receivingAddress.hashCode() : 0);
        result = 31 * result + (ogisticsName != null ? ogisticsName.hashCode() : 0);
        result = 31 * result + (contactPhone != null ? contactPhone.hashCode() : 0);
        result = 31 * result + (principalOrder != null ? principalOrder.hashCode() : 0);
        result = 31 * result + (creditGet != null ? creditGet.hashCode() : 0);
        result = 31 * result + (creditUse != null ? creditUse.hashCode() : 0);
        result = 31 * result + (creditGrantor != null ? creditGrantor.hashCode() : 0);
        result = 31 * result + (orderAmount != null ? orderAmount.hashCode() : 0);
        result = 31 * result + (amountPayable != null ? amountPayable.hashCode() : 0);
        result = 31 * result + (amountActuallyPaid != null ? amountActuallyPaid.hashCode() : 0);
        result = 31 * result + (paymentAccount != null ? paymentAccount.hashCode() : 0);
        result = 31 * result + (paymentTime != null ? paymentTime.hashCode() : 0);
        return result;
    }
}