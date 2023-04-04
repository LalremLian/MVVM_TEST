package com.lalremlian.dummyapplication.ui.viewModel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lalremlian.dummyapplication.data.repository.APIServices;
import com.lalremlian.dummyapplication.data.network.RetroInstance;
import com.lalremlian.dummyapplication.data.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostListViewModel extends ViewModel
{
    private MutableLiveData<List<Post>> postList;

    public PostListViewModel(){
        postList =new MutableLiveData<>();
    }

    public MutableLiveData<List<Post>> getPostListObserver()
    {
        return postList;
    }

    public void makeApiCall()
    {
        APIServices apiServices= RetroInstance.getRetroClient().create(APIServices.class);
        Call<List<Post>> call=apiServices.getAllPost();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(@NonNull Call<List<Post>> call, @NonNull Response<List<Post>> response) {
               postList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
            postList.postValue(null);
            Log.e("Error :",t.getMessage().toString());
            }
        });


    }
}
