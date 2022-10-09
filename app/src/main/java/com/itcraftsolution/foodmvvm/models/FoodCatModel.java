package com.itcraftsolution.foodmvvm.models;

public class FoodCatModel {
    private String name, img, date;
    private int id, status;

    public FoodCatModel() {
    }

    public FoodCatModel(String name, String img, String date, int id, int status) {
        this.name = name;
        this.img = img;
        this.date = date;
        this.id = id;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
