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
    private Integer contract_id;

    /**
     * 订单表id
     */
    private Integer order_id;

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

    public Integer getContract_id() {
        return contract_id;
    }

    public void setContract_id(Integer contract_id) {
        this.contract_id = contract_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    @Override
    public String toString() {
        return "Reject{" +
                "rejectId=" + rejectId +
                ", rejectReason='" + rejectReason + '\'' +
                ", bussinessType=" + bussinessType +
                ", contract_id=" + contract_id +
                ", order_id=" + order_id +
                '}';
    }
}
