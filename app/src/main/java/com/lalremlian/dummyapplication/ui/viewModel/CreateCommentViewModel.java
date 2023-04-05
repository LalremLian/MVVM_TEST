package com.lalremlian.dummyapplication.ui.viewModel;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lalremlian.dummyapplication.data.model.CommentResponse;
import com.lalremlian.dummyapplication.data.model.ParamsComment;
import com.lalremlian.dummyapplication.data.model.Post;
import com.lalremlian.dummyapplication.data.network.RetroInstance;
import com.lalremlian.dummyapplication.data.repository.APIServices;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateCommentViewModel extends ViewModel {

    String token = "466698ae8de00830dddf9c15951f0b150b38b63f2ede0c4557aec3ae75f91c8a";
    private MutableLiveData<CommentResponse> comment;

    CommentResponse commentResponse;

    public CreateCommentViewModel(){
        comment =new MutableLiveData<>();
    }

    public MutableLiveData<CommentResponse> getCommentListObserver()
    {
        return comment;
    }

    public void makeApiCall(String id, String body)
    {
        ParamsComment paramsComment = new ParamsComment("Test", "dummy@gmail.com", body);

        Log.e("Params",paramsComment.toString());

        APIServices apiServices = RetroInstance.getRetroClient().create(APIServices.class);
        Call<CommentResponse> call = apiServices.storeComment("Bearer "+token,id,paramsComment);
        call.enqueue(new Callback<CommentResponse>() {
            @Override
            public void onResponse(@NonNull Call<CommentResponse> call, @NonNull Response<CommentResponse> response) {
                if(response.isSuccessful()){
                    commentResponse = response.body();
                    comment.postValue(commentResponse);
                    Log.e("Response","Data :: " + commentResponse.getBody().toString());
                }
                else{
                    Log.e("Response","Error :: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<CommentResponse> call, Throwable t) {
                comment.postValue(null);
                Log.e("Error :",t.getMessage().toString());
            }
        });

    }
}
