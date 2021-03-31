package com.example.administrator.myretrofit.adapter;

public class MiaoShaBean {
    private String name;
    private String end_date;
    private String team_discount;//是否打折
    private String promote_price;//正常价格

    public MiaoShaBean(String name, String end_date, String team_discount, String promote_price) {
        this.name = name;
        this.end_date = end_date;
        this.team_discount = team_discount;
        this.promote_price = promote_price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getTeam_discount() {
        return team_discount;
    }

    public void setTeam_discount(String team_discount) {
        this.team_discount = team_discount;
    }

    public String getPromote_price() {
        return promote_price;
    }

    public void setPromote_price(String promote_price) {
        this.promote_price = promote_price;
    }
}
