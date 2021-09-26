package com.example.grandhotel;



public class Booking {

    private String no_r_23;
    private String no_r_22;
    private String no_r_21;
    private String no_r_32;
    private String no_r_31;
    private String no_r_41;
    private String no_r_42;
    private String Date;
    private String Email;


    public Booking() {
    }

    public Booking(String no_r_23, String no_r_22, String no_r_21, String no_r_32, String no_r_31, String no_r_41, String no_r_42, String date, String email) {
        this.no_r_23 = no_r_23;
        no_r_22 = no_r_22;
        this.no_r_21 = no_r_21;
        no_r_32 = no_r_32;
        this.no_r_31 = no_r_31;
        this.no_r_41 = no_r_41;
        no_r_42 = no_r_42;
        Date = date;
        Email = email;
    }

    public String getno_r_23() {
        return no_r_23;
    }

    public String getno_r_22() {
        return no_r_22;
    }

    public String getno_r_21() {
        return no_r_21;
    }

    public String getno_r_32() {
        return no_r_32;
    }

    public String getno_r_31() {
        return no_r_31;
    }

    public String getno_r_41() {
        return no_r_41;
    }

    public String getno_r_42() {
        return no_r_42;
    }

    public String getDate() {
        return Date;
    }

    public String getEmail() {
        return Email;
    }


    public void setno_r_23(String no_r_23) {
        this.no_r_23 = no_r_23;
    }

    public void setno_r_22(String no_r_22) {
        no_r_22 = no_r_22;
    }

    public void setno_r_21(String no_r_21) {
        this.no_r_21 = no_r_21;
    }

    public void setno_r_32(String no_r_32) {
        no_r_32 = no_r_32;
    }

    public void setno_r_31(String no_r_31) {
        this.no_r_31 = no_r_31;
    }

    public void setno_r_41(String no_r_41) {
        this.no_r_41 = no_r_41;
    }

    public void setno_r_42(String no_r_42) {
        no_r_42 = no_r_42;
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
