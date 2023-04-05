package com.lalremlian.dummyapplication.data.repository;

import com.lalremlian.dummyapplication.data.model.Comment;
import com.lalremlian.dummyapplication.data.model.CommentResponse;
import com.lalremlian.dummyapplication.data.model.ParamsComment;
import com.lalremlian.dummyapplication.data.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIServices
{
    @GET("posts")
    Call<List<Post>> getAllPost();

    @GET("posts/{id}")
    Call<Post> getDetails(@Path("id") String id);

    @GET("posts/{id}/comments")
    Call<List<Comment>> getComments(@Path("id") String id);

    @POST("posts/{id}/comments")
    Call<CommentResponse> storeComment(
            @Header ("Authorization") String token,
            @Path("id") String id,
            @Body ParamsComment paramsComment
    );
}
