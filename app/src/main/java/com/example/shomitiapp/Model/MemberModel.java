package com.example.shomitiapp.Model;

public class MemberModel {
    String id;
    String name;
    String month;
    String fee;
    String fine;
    String date;

    public MemberModel(String id, String name, String month, String fee, String fine, String date) {
        this.id = id;
        this.name = name;
        this.month = month;
        this.fee = fee;
        this.fine = fine;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getFine() {
        return fine;
    }

    public void setFine(String fine) {
        this.fine = fine;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
