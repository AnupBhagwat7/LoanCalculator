package com.anup.beans;

import java.util.Date;

public class RepaymentSchedule {

    private int month;
    private String date;
    private double emi;
    private double pricipal;
    private double interest;
    private double balance;

    public RepaymentSchedule(int month, String date, double emi, double pricipal, double interest, double balance) {
        this.month = month;
        this.date = date;
        this.emi = emi;
        this.pricipal = pricipal;
        this.interest = interest;
        this.balance = balance;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getEmi() {
        return emi;
    }

    public void setEmi(double emi) {
        this.emi = emi;
    }

    public double getPricipal() {
        return pricipal;
    }

    public void setPricipal(double pricipal) {
        this.pricipal = pricipal;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
