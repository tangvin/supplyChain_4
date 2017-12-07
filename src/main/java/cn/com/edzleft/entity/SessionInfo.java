package cn.com.edzleft.entity;

import java.io.Serializable;

/**
 * Created by ASUS on 2017/6/2.
 */
public class SessionInfo implements Serializable {

    private static final long serialVersionUID = -4990366528213963606L;
    private Account account;
    private Information information;
    private Order order;
    private BankAccount bankAccount;

    @Override
    public String toString() {
        return "SessionInfo{" +
                "account=" + account +
                ", information=" + information +
                ", order=" + order +
                ", bankAccount=" + bankAccount +
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Information getInformation() {
        return information;
    }

    public void setInformation(Information information) {
        this.information = information;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
}
