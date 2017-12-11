package cn.com.edzleft.entity;

import java.util.Date;

public class Code {
    private Integer id;

    private String code;

    private Date creatTime;

    private Integer userId;
    
    private String userPhone;
    
 
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Code code1 = (Code) o;

        if (id != null ? !id.equals(code1.id) : code1.id != null) return false;
        if (code != null ? !code.equals(code1.code) : code1.code != null) return false;
        if (creatTime != null ? !creatTime.equals(code1.creatTime) : code1.creatTime != null) return false;
        return userId != null ? userId.equals(code1.userId) : code1.userId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (creatTime != null ? creatTime.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Code{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", creatTime='" + creatTime + '\'' +
                ", userId=" + userId +
                '}';
    }

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}


}