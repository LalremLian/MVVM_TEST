package com.lalremlian.dummyapplication.data.repository;

import com.lalremlian.dummyapplication.data.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIServices
{
    @GET("posts")
    Call<List<Post>> getAllPost();
}
