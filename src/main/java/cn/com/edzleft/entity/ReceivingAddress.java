package cn.com.edzleft.entity;

/**收货地址表（
 * gyl_receiving_address
 */
public class ReceivingAddress {
    /**
     * id
     */
    private Integer rAddressId;
    /**
     * 收货区域
     */
    private String rAddressArea;
    /**
     * 收货地址
     */
    private String rAddressAddress;
    /**
     * 邮编
     */
    private String rAddressZipcode;
    /**
     * 收货人
     */
    private Integer rAddressPerson;
    /**
     * 收货人手机
     */
    private Integer rAddressPhone;
    /**
     * 是否默认收货地址
     */
	private Integer rAddressDefault;
	/**
     * 用户ID
     */
    private Integer unionID ;
    
    public Integer getUnionID() {
		return unionID;
	}

	public void setUnionID(Integer unionID) {
		this.unionID = unionID;
	}
    public Integer getrAddressId() {
        return rAddressId;
    }

    public void setrAddressId(Integer rAddressId) {
        this.rAddressId = rAddressId;
    }

    public String getrAddressArea() {
        return rAddressArea;
    }

    public void setrAddressArea(String rAddressArea) {
        this.rAddressArea = rAddressArea == null ? null : rAddressArea.trim();
    }

    public String getrAddressAddress() {
        return rAddressAddress;
    }

    public void setrAddressAddress(String rAddressAddress) {
        this.rAddressAddress = rAddressAddress == null ? null : rAddressAddress.trim();
    }

    public String getrAddressZipcode() {
        return rAddressZipcode;
    }

    public void setrAddressZipcode(String rAddressZipcode) {
        this.rAddressZipcode = rAddressZipcode == null ? null : rAddressZipcode.trim();
    }


    public Integer getrAddressPerson() {
		return rAddressPerson;
	}

	public void setrAddressPerson(Integer rAddressPerson) {
		this.rAddressPerson = rAddressPerson;
	}


    public Integer getrAddressPhone() {
		return rAddressPhone;
	}

	public void setrAddressPhone(Integer rAddressPhone) {
		this.rAddressPhone = rAddressPhone;
	}

	public Integer getrAddressDefault() {
		return rAddressDefault;
	}

	public void setrAddressDefault(Integer rAddressDefault) {
		this.rAddressDefault = rAddressDefault;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReceivingAddress that = (ReceivingAddress) o;

        if (rAddressId != null ? !rAddressId.equals(that.rAddressId) : that.rAddressId != null) return false;
        if (rAddressArea != null ? !rAddressArea.equals(that.rAddressArea) : that.rAddressArea != null) return false;
        if (rAddressAddress != null ? !rAddressAddress.equals(that.rAddressAddress) : that.rAddressAddress != null)
            return false;
        if (rAddressZipcode != null ? !rAddressZipcode.equals(that.rAddressZipcode) : that.rAddressZipcode != null)
            return false;
        if (rAddressPerson != null ? !rAddressPerson.equals(that.rAddressPerson) : that.rAddressPerson != null)
            return false;
        if (rAddressPhone != null ? !rAddressPhone.equals(that.rAddressPhone) : that.rAddressPhone != null)
            return false;
        return rAddressDefault != null ? rAddressDefault.equals(that.rAddressDefault) : that.rAddressDefault == null;
    }

    @Override
    public int hashCode() {
        int result = rAddressId != null ? rAddressId.hashCode() : 0;
        result = 31 * result + (rAddressArea != null ? rAddressArea.hashCode() : 0);
        result = 31 * result + (rAddressAddress != null ? rAddressAddress.hashCode() : 0);
        result = 31 * result + (rAddressZipcode != null ? rAddressZipcode.hashCode() : 0);
        result = 31 * result + (rAddressPerson != null ? rAddressPerson.hashCode() : 0);
        result = 31 * result + (rAddressPhone != null ? rAddressPhone.hashCode() : 0);
        result = 31 * result + (rAddressDefault != null ? rAddressDefault.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ReceivingAddress{" +
                "rAddressId=" + rAddressId +
                ", rAddressArea='" + rAddressArea + '\'' +
                ", rAddressAddress='" + rAddressAddress + '\'' +
                ", rAddressZipcode='" + rAddressZipcode + '\'' +
                ", rAddressPerson='" + rAddressPerson + '\'' +
                ", rAddressPhone='" + rAddressPhone + '\'' +
                ", rAddressDefault='" + rAddressDefault + '\'' +
                '}';
    }
}