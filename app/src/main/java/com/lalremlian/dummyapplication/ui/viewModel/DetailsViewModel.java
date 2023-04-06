package com.lalremlian.dummyapplication.ui.viewModel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lalremlian.dummyapplication.data.model.Post;
import com.lalremlian.dummyapplication.data.network.RetroInstance;
import com.lalremlian.dummyapplication.data.repository.APIServices;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsViewModel extends ViewModel {
    private MutableLiveData<Post> postList;

    public DetailsViewModel() {
        postList = new MutableLiveData<>();
    }

    public MutableLiveData<Post> getPostListObserver() {
        return postList;
    }

    public void makeApiCall(String id) {
        APIServices apiServices = RetroInstance.getRetroClient().create(APIServices.class);
        Call<Post> call = apiServices.getDetails(id);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(@NonNull Call<Post> call, @NonNull Response<Post> response) {

                if (response.isSuccessful()) {
                    postList.postValue(response.body());
                } else {
                    Log.e("Response", response.body().toString());
                }

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                postList.postValue(null);
                Log.e("Error :", t.getMessage().toString());
            }
        });


    }
}
