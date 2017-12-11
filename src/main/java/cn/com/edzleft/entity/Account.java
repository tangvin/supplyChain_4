package cn.com.edzleft.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 账号表 gyl_account
 */
public class Account implements Serializable{

    private static final long serialVersionUID = 7077924598331970389L;
    /**
     * id
     */
    private Integer userId;
    /**
     * 账号
     */
    private String userName;
    /**
     * 密码  密码介于6-20位，区分大小写(密码需要密文)
     */
    private String userPwd;
    /**
     * 手机号  11位
     */
    private String userPhone;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建ip  25位以内的字符
     */
    private String createIp;
    /**
     * 登陆时间   格式：2017-08-02 12:13:15
     */
    private Date loginTime;
    /**
     * 登录ip   25位以内的字符
     */
    private String loginIp;
    /**
     * 密保邮箱   100位以内的字符
     */
    private String userEamil;
    /**
     * 账号类型  0采购方、1贸易方、2资方
     */
    private Integer accountType;
    /**
     * 账号状态 0正常、1待启用
     */
    private Integer accountState;
    /**
     * 证书颁发状态   0已颁发、1待颁发、2已作废
     */
    private Integer certificateState;
    /**
     * 证书类型  0CA、1OT
     */
    private Integer certificateType;
    /**
     * 邀请账号
     */
    private String inviteAccount;
    /**
     * 关联资料表
     */
    private Integer informationId;
    /**
     * 用戶联系人
     */
    private String userLinkman;


    public String getUserLinkman() {
		return userLinkman;
	}

	public void setUserLinkman(String userLinkman) {
		this.userLinkman = userLinkman;
	}

	public Integer getInformationId() {
        return informationId;
    }

    public void setInformationId(Integer informationId) {
        this.informationId = informationId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateIp() {
        return createIp;
    }

    public void setCreateIp(String createIp) {
        this.createIp = createIp == null ? null : createIp.trim();
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    public String getUserEamil() {
        return userEamil;
    }

    public void setUserEamil(String userEamil) {
        this.userEamil = userEamil == null ? null : userEamil.trim();
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public Integer getAccountState() {
        return accountState;
    }

    public void setAccountState(Integer accountState) {
        this.accountState = accountState;
    }

    public Integer getCertificateState() {
        return certificateState;
    }

    public void setCertificateState(Integer certificateState) {
        this.certificateState = certificateState;
    }

    public Integer getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(Integer certificateType) {
        this.certificateType = certificateType;
    }

    public String getInviteAccount() {
        return inviteAccount;
    }

    public void setInviteAccount(String inviteAccount) {
        this.inviteAccount = inviteAccount == null ? null : inviteAccount.trim();
    }

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountState == null) {
			if (other.accountState != null)
				return false;
		} else if (!accountState.equals(other.accountState))
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (certificateState == null) {
			if (other.certificateState != null)
				return false;
		} else if (!certificateState.equals(other.certificateState))
			return false;
		if (certificateType == null) {
			if (other.certificateType != null)
				return false;
		} else if (!certificateType.equals(other.certificateType))
			return false;
		if (createIp == null) {
			if (other.createIp != null)
				return false;
		} else if (!createIp.equals(other.createIp))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (informationId == null) {
			if (other.informationId != null)
				return false;
		} else if (!informationId.equals(other.informationId))
			return false;
		if (inviteAccount == null) {
			if (other.inviteAccount != null)
				return false;
		} else if (!inviteAccount.equals(other.inviteAccount))
			return false;
		if (loginIp == null) {
			if (other.loginIp != null)
				return false;
		} else if (!loginIp.equals(other.loginIp))
			return false;
		if (loginTime == null) {
			if (other.loginTime != null)
				return false;
		} else if (!loginTime.equals(other.loginTime))
			return false;
		if (userEamil == null) {
			if (other.userEamil != null)
				return false;
		} else if (!userEamil.equals(other.userEamil))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userLinkman == null) {
			if (other.userLinkman != null)
				return false;
		} else if (!userLinkman.equals(other.userLinkman))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userPhone == null) {
			if (other.userPhone != null)
				return false;
		} else if (!userPhone.equals(other.userPhone))
			return false;
		if (userPwd == null) {
			if (other.userPwd != null)
				return false;
		} else if (!userPwd.equals(other.userPwd))
			return false;
		return true;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountState == null) ? 0 : accountState.hashCode());
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		result = prime * result + ((certificateState == null) ? 0 : certificateState.hashCode());
		result = prime * result + ((certificateType == null) ? 0 : certificateType.hashCode());
		result = prime * result + ((createIp == null) ? 0 : createIp.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((informationId == null) ? 0 : informationId.hashCode());
		result = prime * result + ((inviteAccount == null) ? 0 : inviteAccount.hashCode());
		result = prime * result + ((loginIp == null) ? 0 : loginIp.hashCode());
		result = prime * result + ((loginTime == null) ? 0 : loginTime.hashCode());
		result = prime * result + ((userEamil == null) ? 0 : userEamil.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userLinkman == null) ? 0 : userLinkman.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userPhone == null) ? 0 : userPhone.hashCode());
		result = prime * result + ((userPwd == null) ? 0 : userPwd.hashCode());
		return result;
	}

    @Override
	public String toString() {
		return "Account [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", userPhone="
				+ userPhone + ", createTime=" + createTime + ", createIp=" + createIp + ", loginTime=" + loginTime
				+ ", loginIp=" + loginIp + ", userEamil=" + userEamil + ", accountType=" + accountType
				+ ", accountState=" + accountState + ", certificateState=" + certificateState + ", certificateType="
				+ certificateType + ", inviteAccount=" + inviteAccount + ", informationId=" + informationId
				+ ", userLinkman=" + userLinkman + "]";
	}
}