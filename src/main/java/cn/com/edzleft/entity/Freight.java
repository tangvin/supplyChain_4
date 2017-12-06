package cn.com.edzleft.entity;

/**货运单位表（贸方维护）
 * gyl_freight
 */
public class Freight {
    /**
     * id
     */
    private Integer freightId;
    /**
     * 货运单位名称
     */
    private String freightName;
    /**
     * 货运方联系人
     */
    private String freightContactPerson;
    /**
     * 货运方联系人手机
     */
    private String freightContactPhone;
    /**
     * 是否默认货运单位
     */
    private Integer freightDefaultAddress;
    /**
     * 货运单号
     */
    private String freightNumber;

    /**
     * 用户id
     */
    public Integer accountId;


    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getFreightId() {
        return freightId;
    }

    public void setFreightId(Integer freightId) {
        this.freightId = freightId;
    }

    public String getFreightName() {
        return freightName;
    }

    public void setFreightName(String freightName) {
        this.freightName = freightName == null ? null : freightName.trim();
    }

    public String getFreightContactPerson() {
        return freightContactPerson;
    }

    public void setFreightContactPerson(String freightContactPerson) {
        this.freightContactPerson = freightContactPerson == null ? null : freightContactPerson.trim();
    }

    public String getFreightContactPhone() {
        return freightContactPhone;
    }

    public void setFreightContactPhone(String freightContactPhone) {
        this.freightContactPhone = freightContactPhone == null ? null : freightContactPhone.trim();
    }

    public Integer getFreightDefaultAddress() {
        return freightDefaultAddress;
    }

    public void setFreightDefaultAddress(Integer freightDefaultAddress) {
        this.freightDefaultAddress = freightDefaultAddress;
    }

    public String getFreightNumber() {
        return freightNumber;
    }

    public void setFreightNumber(String freightNumber) {
        this.freightNumber = freightNumber;
    }

    @Override
    public String toString() {
        return "Freight{" +
                "freightId=" + freightId +
                ", freightName='" + freightName + '\'' +
                ", freightContactPerson='" + freightContactPerson + '\'' +
                ", freightContactPhone='" + freightContactPhone + '\'' +
                ", freightDefaultAddress=" + freightDefaultAddress +
                ", freightNumber='" + freightNumber + '\'' +
                ", accountId='" + accountId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Freight freight = (Freight) o;

        if (freightId != null ? !freightId.equals(freight.freightId) : freight.freightId != null) return false;
        if (freightName != null ? !freightName.equals(freight.freightName) : freight.freightName != null) return false;
        if (accountId != null ? !accountId.equals(freight.accountId) : freight.accountId != null) return false;
        if (freightContactPerson != null ? !freightContactPerson.equals(freight.freightContactPerson) : freight.freightContactPerson != null)
            return false;
        if (freightContactPhone != null ? !freightContactPhone.equals(freight.freightContactPhone) : freight.freightContactPhone != null)
            return false;
        if (freightDefaultAddress != null ? !freightDefaultAddress.equals(freight.freightDefaultAddress) : freight.freightDefaultAddress != null)
            return false;
        return freightNumber != null ? freightNumber.equals(freight.freightNumber) : freight.freightNumber == null;
    }

    @Override
    public int hashCode() {
        int result = freightId != null ? freightId.hashCode() : 0;
        result = 31 * result + (freightName != null ? freightName.hashCode() : 0);
        result = 31 * result + (freightContactPerson != null ? freightContactPerson.hashCode() : 0);
        result = 31 * result + (freightContactPhone != null ? freightContactPhone.hashCode() : 0);
        result = 31 * result + (freightDefaultAddress != null ? freightDefaultAddress.hashCode() : 0);
        result = 31 * result + (freightNumber != null ? freightNumber.hashCode() : 0);
        result = 31 * result + (accountId != null ? accountId.hashCode() : 0);
        return result;
    }
}