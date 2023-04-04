package com.lalremlian.dummyapplication.ui.viewModel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lalremlian.dummyapplication.data.model.Comment;
import com.lalremlian.dummyapplication.data.network.RetroInstance;
import com.lalremlian.dummyapplication.data.repository.APIServices;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentsViewModel extends ViewModel {
    private MutableLiveData<List<Comment>> commentsList;

    public CommentsViewModel(){
        commentsList =new MutableLiveData<>();
    }

    public MutableLiveData<List<Comment>> getPostListObserver()
    {
        return commentsList;
    }

    public void makeApiCall(String id)
    {
        APIServices apiServices= RetroInstance.getRetroClient().create(APIServices.class);
        Call<List<Comment>> call=apiServices.getComments(id);
        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(@NonNull Call<List<Comment>> call, @NonNull Response<List<Comment>> response) {
                commentsList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                commentsList.postValue(null);
                Log.e("Error :",t.getMessage().toString());
            }
        });


    }
}
