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

    @Override
    public String toString() {
        return "Freight{" +
                "freightId=" + freightId +
                ", freightName='" + freightName + '\'' +
                ", freightContactPerson='" + freightContactPerson + '\'' +
                ", freightContactPhone='" + freightContactPhone + '\'' +
                ", freightDefaultAddress=" + freightDefaultAddress +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Freight freight = (Freight) o;

        if (freightId != null ? !freightId.equals(freight.freightId) : freight.freightId != null) return false;
        if (freightName != null ? !freightName.equals(freight.freightName) : freight.freightName != null) return false;
        if (freightContactPerson != null ? !freightContactPerson.equals(freight.freightContactPerson) : freight.freightContactPerson != null)
            return false;
        if (freightContactPhone != null ? !freightContactPhone.equals(freight.freightContactPhone) : freight.freightContactPhone != null)
            return false;
        return freightDefaultAddress != null ? freightDefaultAddress.equals(freight.freightDefaultAddress) : freight.freightDefaultAddress == null;
    }

    @Override
    public int hashCode() {
        int result = freightId != null ? freightId.hashCode() : 0;
        result = 31 * result + (freightName != null ? freightName.hashCode() : 0);
        result = 31 * result + (freightContactPerson != null ? freightContactPerson.hashCode() : 0);
        result = 31 * result + (freightContactPhone != null ? freightContactPhone.hashCode() : 0);
        result = 31 * result + (freightDefaultAddress != null ? freightDefaultAddress.hashCode() : 0);
        return result;
    }
}