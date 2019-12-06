package com.employeemanagement.ApiInterface;

import com.employeemanagement.Model.Data;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface
{
    @GET("5ddc504d340000919deae273")
    Call<Data> fetchdata();

//    @POST("forgetPassword")
//    @FormUrlEncoded
//    Call<ResetRec> resetrec(@Field("email") String email);
}
