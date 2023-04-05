package com.lalremlian.dummyapplication.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CommentResponse {
    @SerializedName("id")
    @Expose
    String id;
    @SerializedName("post_id")
    @Expose
    String post_id;
    @SerializedName("name")
    @Expose
    String name;
    @SerializedName("email")
    @Expose
    String email;
    @SerializedName("body")
    @Expose
    String body;

    public CommentResponse(String id, String post_id, String name, String email, String body) {
        this.id = id;
        this.post_id = post_id;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
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
        return "CommentResponse{" +
                "id='" + id + '\'' +
                ", post_id='" + post_id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
