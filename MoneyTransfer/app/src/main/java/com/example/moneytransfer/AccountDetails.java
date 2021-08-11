package com.example.moneytransfer;

public class AccountDetails {
    String name ;
    String accountNo ;
    int amount;

    public AccountDetails(String name, String accountNo, int amount) {
        this.name = name;
        this.accountNo = accountNo;
        this.amount = amount;
    }
    public AccountDetails(){
        amount = 100;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
