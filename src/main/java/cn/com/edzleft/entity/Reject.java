package cn.com.edzleft.entity;

/**
 * Created by ibmtech on 2017/12/7.
 */
public class Reject {

    /**
     * 驳回表主键id
     */
    private Integer rejectId;

    /**
     * 驳回理由
     */
    private String rejectReason;

    /**
     * 业务类型
     */
    private Integer bussinessType;

    /**
     * 合同表id
     */
    private Integer contractId;

    /**
     * 订单表id
     */
    private Integer orderId;


    public Integer getRejectId() {
        return rejectId;
    }

    public void setRejectId(Integer rejectId) {
        this.rejectId = rejectId;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public Integer getBussinessType() {
        return bussinessType;
    }

    public void setBussinessType(Integer bussinessType) {
        this.bussinessType = bussinessType;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Reject{" +
                "rejectId=" + rejectId +
                ", rejectReason='" + rejectReason + '\'' +
                ", bussinessType=" + bussinessType +
                ", contractId=" + contractId +
                ", orderId=" + orderId +
                '}';
    }
}
