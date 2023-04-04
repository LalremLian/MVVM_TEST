package com.lalremlian.dummyapplication.apis;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroInstance
{
    public static String baseurl="https://gorest.co.in/public/v2/";
    private static Retrofit retrofit;

    public static Retrofit getRetroClient()
    {
         if(retrofit==null)
         {
             retrofit= new Retrofit.Builder()
                           .baseUrl(baseurl)
                           .addConverterFactory(GsonConverterFactory.create())
                           .build();
         }
         return retrofit;
    }
}
