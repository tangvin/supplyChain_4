package cn.com.edzleft.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 账号表 gyl_account
 */
public class Account implements Serializable{

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
    private Date creatTime;
    /**
     * 创建ip  25位以内的字符
     */
    private String creatIp;
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

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public String getCreatIp() {
        return creatIp;
    }

    public void setCreatIp(String creatIp) {
        this.creatIp = creatIp == null ? null : creatIp.trim();
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (userId != null ? !userId.equals(account.userId) : account.userId != null) return false;
        if (userName != null ? !userName.equals(account.userName) : account.userName != null) return false;
        if (userPwd != null ? !userPwd.equals(account.userPwd) : account.userPwd != null) return false;
        if (userPhone != null ? !userPhone.equals(account.userPhone) : account.userPhone != null) return false;
        if (creatTime != null ? !creatTime.equals(account.creatTime) : account.creatTime != null) return false;
        if (creatIp != null ? !creatIp.equals(account.creatIp) : account.creatIp != null) return false;
        if (loginTime != null ? !loginTime.equals(account.loginTime) : account.loginTime != null) return false;
        if (loginIp != null ? !loginIp.equals(account.loginIp) : account.loginIp != null) return false;
        if (userEamil != null ? !userEamil.equals(account.userEamil) : account.userEamil != null) return false;
        if (accountType != null ? !accountType.equals(account.accountType) : account.accountType != null) return false;
        if (accountState != null ? !accountState.equals(account.accountState) : account.accountState != null)
            return false;
        if (certificateState != null ? !certificateState.equals(account.certificateState) : account.certificateState != null)
            return false;
        if (certificateType != null ? !certificateType.equals(account.certificateType) : account.certificateType != null)
            return false;
        return inviteAccount != null ? inviteAccount.equals(account.inviteAccount) : account.inviteAccount == null;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userPwd != null ? userPwd.hashCode() : 0);
        result = 31 * result + (userPhone != null ? userPhone.hashCode() : 0);
        result = 31 * result + (creatTime != null ? creatTime.hashCode() : 0);
        result = 31 * result + (creatIp != null ? creatIp.hashCode() : 0);
        result = 31 * result + (loginTime != null ? loginTime.hashCode() : 0);
        result = 31 * result + (loginIp != null ? loginIp.hashCode() : 0);
        result = 31 * result + (userEamil != null ? userEamil.hashCode() : 0);
        result = 31 * result + (accountType != null ? accountType.hashCode() : 0);
        result = 31 * result + (accountState != null ? accountState.hashCode() : 0);
        result = 31 * result + (certificateState != null ? certificateState.hashCode() : 0);
        result = 31 * result + (certificateType != null ? certificateType.hashCode() : 0);
        result = 31 * result + (inviteAccount != null ? inviteAccount.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", creatTime=" + creatTime +
                ", creatIp='" + creatIp + '\'' +
                ", loginTime=" + loginTime +
                ", loginIp='" + loginIp + '\'' +
                ", userEamil='" + userEamil + '\'' +
                ", accountType=" + accountType +
                ", accountState=" + accountState +
                ", certificateState=" + certificateState +
                ", certificateType=" + certificateType +
                ", inviteAccount='" + inviteAccount + '\'' +
                '}';
    }
}