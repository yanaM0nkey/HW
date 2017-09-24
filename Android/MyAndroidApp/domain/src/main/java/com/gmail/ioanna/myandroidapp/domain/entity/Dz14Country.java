package com.gmail.ioanna.myandroidapp.domain.entity;


import com.gmail.ioanna.myandroidapp.data.entity.DataModel;
import com.google.gson.annotations.SerializedName;

public class Dz14Country implements DomainModel {

    @SerializedName("name")
    private String name;

    @SerializedName("code")
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
