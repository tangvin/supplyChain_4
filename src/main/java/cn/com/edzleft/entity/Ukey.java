package cn.com.edzleft.entity;

import java.util.Date;

/**
 * gyl_ukey
 * 证书
 */
public class Ukey {
    private Integer ukeyId;
    /**
     * ukey及证书的类型
     */
    private String ukeyType;
    /**
     * 颁发人
     */
    private String issuedPeople;
    /**
     * 颁发时间
     */
    private Date issuedTime;
    /**
     * key及证书的状态
     */
    private String ukeyStatus;
    /**
     * ukey及证书名字
     */
    private String ukeyFilename;

    public Integer getUkeyId() {
        return ukeyId;
    }

    public void setUkeyId(Integer ukeyId) {
        this.ukeyId = ukeyId;
    }

    public String getUkeyType() {
        return ukeyType;
    }

    public void setUkeyType(String ukeyType) {
        this.ukeyType = ukeyType == null ? null : ukeyType.trim();
    }

    public String getIssuedPeople() {
        return issuedPeople;
    }

    public void setIssuedPeople(String issuedPeople) {
        this.issuedPeople = issuedPeople == null ? null : issuedPeople.trim();
    }

    public Date getIssuedTime() {
        return issuedTime;
    }

    public void setIssuedTime(Date issuedTime) {
        this.issuedTime = issuedTime;
    }

    public String getUkeyStatus() {
        return ukeyStatus;
    }

    public void setUkeyStatus(String ukeyStatus) {
        this.ukeyStatus = ukeyStatus == null ? null : ukeyStatus.trim();
    }

    public String getUkeyFilename() {
        return ukeyFilename;
    }

    public void setUkeyFilename(String ukeyFilename) {
        this.ukeyFilename = ukeyFilename == null ? null : ukeyFilename.trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ukey ukey = (Ukey) o;

        if (ukeyId != null ? !ukeyId.equals(ukey.ukeyId) : ukey.ukeyId != null) return false;
        if (ukeyType != null ? !ukeyType.equals(ukey.ukeyType) : ukey.ukeyType != null) return false;
        if (issuedPeople != null ? !issuedPeople.equals(ukey.issuedPeople) : ukey.issuedPeople != null) return false;
        if (issuedTime != null ? !issuedTime.equals(ukey.issuedTime) : ukey.issuedTime != null) return false;
        if (ukeyStatus != null ? !ukeyStatus.equals(ukey.ukeyStatus) : ukey.ukeyStatus != null) return false;
        return ukeyFilename != null ? ukeyFilename.equals(ukey.ukeyFilename) : ukey.ukeyFilename == null;
    }

    @Override
    public int hashCode() {
        int result = ukeyId != null ? ukeyId.hashCode() : 0;
        result = 31 * result + (ukeyType != null ? ukeyType.hashCode() : 0);
        result = 31 * result + (issuedPeople != null ? issuedPeople.hashCode() : 0);
        result = 31 * result + (issuedTime != null ? issuedTime.hashCode() : 0);
        result = 31 * result + (ukeyStatus != null ? ukeyStatus.hashCode() : 0);
        result = 31 * result + (ukeyFilename != null ? ukeyFilename.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ukey{" +
                "ukeyId=" + ukeyId +
                ", ukeyType='" + ukeyType + '\'' +
                ", issuedPeople='" + issuedPeople + '\'' +
                ", issuedTime=" + issuedTime +
                ", ukeyStatus='" + ukeyStatus + '\'' +
                ", ukeyFilename='" + ukeyFilename + '\'' +
                '}';
    }
}