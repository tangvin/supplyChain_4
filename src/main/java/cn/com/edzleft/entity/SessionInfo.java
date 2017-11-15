package com.mxp.pojo;

import java.io.Serializable;

/**
 * Created by ASUS on 2017/6/2.
 */
public class SessionInfo implements Serializable{

    private static final long serialVersionUID = -4990366528213963606L;
    private Admins admin;


    @Override
    public String toString() {
        return "SessionInfo{" +
                "admin=" + admin +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Admins getAdmin() {
        return admin;
    }

    public void setAdmin(Admins admin) {
        this.admin = admin;
    }
}
