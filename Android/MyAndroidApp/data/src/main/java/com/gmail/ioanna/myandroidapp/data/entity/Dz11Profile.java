package com.gmail.ioanna.myandroidapp.data.entity;


import com.google.gson.annotations.SerializedName;

public class Dz11Profile implements DataModel {

    private String name;
    private String surname;
    private String country;
    private int age;

    @SerializedName("objectId")
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
