package com.intelliarts.model;

import java.text.SimpleDateFormat;
import java.util.Date;


public class PaymentEntry {
    private Date date;
    private Double cost;
    private Currency currency;
    private String name;

    public PaymentEntry(Date date, Double cost, Currency currency, String name) {
        this.date = date;
        this.cost = cost;
        this.currency = currency;
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "PaymentEntry{" +
                "date=" + sdf.format(date) +
                ", cost=" + cost +
                ", currency=" + currency +
                ", name='" + name + '\'' +
                '}';
    }
}
