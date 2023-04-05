package com.lalremlian.dummyapplication.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ParamsComment {
    @SerializedName("name")
    @Expose
    String name;
    @SerializedName("email")
    @Expose
    String email;
    @SerializedName("body")
    @Expose

    String body;

    public ParamsComment(String name, String email, String body) {
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "ParamsComment{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
