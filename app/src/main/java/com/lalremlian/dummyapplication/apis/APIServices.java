package com.lalremlian.dummyapplication.apis;

import com.lalremlian.dummyapplication.models.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIServices
{
    @GET("posts")
    Call<List<Post>> getAllPost();
}
