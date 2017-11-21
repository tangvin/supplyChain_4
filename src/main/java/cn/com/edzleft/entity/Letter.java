package cn.com.edzleft.entity;

import java.util.Date;

/**用信表
 * gyl_letter
 */
public class Letter {
    /**
     * id
     */
    private Integer id;
    /**
     * 用信人（采方）
     */
    private String letterName;
    /**
     * 用信额
     */
    private Double letterCredit;
    /**
     * 用信时间
     */
    private Date letterTime;
    /**
     * 所属订单
     */
    private String belongOrder;
    /**
     * 所属主合同
     */
    private String belongMasterContract;
    /**
     * 确认人
     */
    private String confirmPerson;
    /**
     * 确认时间
     */
    private Date confirmTime;
    /**
     * 用信状态
     */
    private Integer letterStatus;
    /**
     * 所属授信
     */
    private String belongCredit;
    /**
     * 合同（用信方）
     */
    private String letterContract;
    /**
     *订单主键
     */
    private String orderId;
    /**
     * 申请人（采方企业名称）
     */
    private String applicant;
    /**
     * 申请时间
     */
    private Date applicationTime;
    /**
     * 批准时间
     */
    private Date approvalTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLetterName() {
        return letterName;
    }

    public void setLetterName(String letterName) {
        this.letterName = letterName == null ? null : letterName.trim();
    }

    public Double getLetterCredit() {
        return letterCredit;
    }

    public void setLetterCredit(Double letterCredit) {
        this.letterCredit = letterCredit;
    }

    public Date getLetterTime() {
        return letterTime;
    }

    public void setLetterTime(Date letterTime) {
        this.letterTime = letterTime;
    }

    public String getBelongOrder() {
        return belongOrder;
    }

    public void setBelongOrder(String belongOrder) {
        this.belongOrder = belongOrder == null ? null : belongOrder.trim();
    }

    public String getBelongMasterContract() {
        return belongMasterContract;
    }

    public void setBelongMasterContract(String belongMasterContract) {
        this.belongMasterContract = belongMasterContract == null ? null : belongMasterContract.trim();
    }

    public String getConfirmPerson() {
        return confirmPerson;
    }

    public void setConfirmPerson(String confirmPerson) {
        this.confirmPerson = confirmPerson == null ? null : confirmPerson.trim();
    }

    public Date getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }

    public Integer getLetterStatus() {
        return letterStatus;
    }

    public void setLetterStatus(Integer letterStatus) {
        this.letterStatus = letterStatus;
    }

    public String getBelongCredit() {
        return belongCredit;
    }

    public void setBelongCredit(String belongCredit) {
        this.belongCredit = belongCredit;
    }

    public String getLetterContract() {
        return letterContract;
    }

    public void setLetterContract(String letterContract) {
        this.letterContract = letterContract;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public Date getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }

    public Date getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(Date approvalTime) {
        this.approvalTime = approvalTime;
    }

    @Override
    public String toString() {
        return "Letter{" +
                "id=" + id +
                ", letterName='" + letterName + '\'' +
                ", letterCredit=" + letterCredit +
                ", letterTime=" + letterTime +
                ", belongOrder='" + belongOrder + '\'' +
                ", belongMasterContract='" + belongMasterContract + '\'' +
                ", confirmPerson='" + confirmPerson + '\'' +
                ", confirmTime=" + confirmTime +
                ", letterStatus=" + letterStatus +
                ", belongCredit='" + belongCredit + '\'' +
                ", letterContract='" + letterContract + '\'' +
                ", letterOrder='" + orderId + '\'' +
                ", applicant='" + applicant + '\'' +
                ", applicationTime=" + applicationTime +
                ", approvalTime=" + approvalTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Letter leffer = (Letter) o;

        if (id != null ? !id.equals(leffer.id) : leffer.id != null) return false;
        if (letterName != null ? !letterName.equals(leffer.letterName) : leffer.letterName != null) return false;
        if (letterCredit != null ? !letterCredit.equals(leffer.letterCredit) : leffer.letterCredit != null)
            return false;
        if (letterTime != null ? !letterTime.equals(leffer.letterTime) : leffer.letterTime != null) return false;
        if (belongOrder != null ? !belongOrder.equals(leffer.belongOrder) : leffer.belongOrder != null) return false;
        if (belongMasterContract != null ? !belongMasterContract.equals(leffer.belongMasterContract) : leffer.belongMasterContract != null)
            return false;
        if (confirmPerson != null ? !confirmPerson.equals(leffer.confirmPerson) : leffer.confirmPerson != null)
            return false;
        if (confirmTime != null ? !confirmTime.equals(leffer.confirmTime) : leffer.confirmTime != null) return false;
        if (letterStatus != null ? !letterStatus.equals(leffer.letterStatus) : leffer.letterStatus != null)
            return false;
        if (belongCredit != null ? !belongCredit.equals(leffer.belongCredit) : leffer.belongCredit != null)
            return false;
        if (letterContract != null ? !letterContract.equals(leffer.letterContract) : leffer.letterContract != null)
            return false;
        if (orderId != null ? !orderId.equals(leffer.orderId) : leffer.orderId != null) return false;
        if (applicant != null ? !applicant.equals(leffer.applicant) : leffer.applicant != null) return false;
        if (applicationTime != null ? !applicationTime.equals(leffer.applicationTime) : leffer.applicationTime != null)
            return false;
        return approvalTime != null ? approvalTime.equals(leffer.approvalTime) : leffer.approvalTime == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (letterName != null ? letterName.hashCode() : 0);
        result = 31 * result + (letterCredit != null ? letterCredit.hashCode() : 0);
        result = 31 * result + (letterTime != null ? letterTime.hashCode() : 0);
        result = 31 * result + (belongOrder != null ? belongOrder.hashCode() : 0);
        result = 31 * result + (belongMasterContract != null ? belongMasterContract.hashCode() : 0);
        result = 31 * result + (confirmPerson != null ? confirmPerson.hashCode() : 0);
        result = 31 * result + (confirmTime != null ? confirmTime.hashCode() : 0);
        result = 31 * result + (letterStatus != null ? letterStatus.hashCode() : 0);
        result = 31 * result + (belongCredit != null ? belongCredit.hashCode() : 0);
        result = 31 * result + (letterContract != null ? letterContract.hashCode() : 0);
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (applicant != null ? applicant.hashCode() : 0);
        result = 31 * result + (applicationTime != null ? applicationTime.hashCode() : 0);
        result = 31 * result + (approvalTime != null ? approvalTime.hashCode() : 0);
        return result;
    }
}