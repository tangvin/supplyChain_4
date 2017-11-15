package cn.com.edzleft.entity;

import java.io.Serializable;

/**
 * Created by ASUS on 2017/6/2.
 */
public class SessionInfo implements Serializable {

    private static final long serialVersionUID = -4990366528213963606L;
    private Account account;


    @Override
    public String toString() {
        return "SessionInfo{" +
                "admin=" + account +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Account getAdmin() {
        return account;
    }

    public void setAdmin(Account admin) {
        this.account = admin;
    }
}
