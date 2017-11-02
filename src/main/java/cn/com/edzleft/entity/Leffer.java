package cn.com.edzleft.entity;

import java.util.Date;

/**用信表
 * gyl_letter
 */
public class Leffer {
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

    @Override
    public String toString() {
        return "Leffer{" +
                "id=" + id +
                ", letterName='" + letterName + '\'' +
                ", letterCredit=" + letterCredit +
                ", letterTime=" + letterTime +
                ", belongOrder='" + belongOrder + '\'' +
                ", belongMasterContract='" + belongMasterContract + '\'' +
                ", confirmPerson='" + confirmPerson + '\'' +
                ", confirmTime=" + confirmTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Leffer leffer = (Leffer) o;

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
        return confirmTime != null ? confirmTime.equals(leffer.confirmTime) : leffer.confirmTime == null;
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
        return result;
    }
}