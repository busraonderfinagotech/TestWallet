package com.example.testwallet.service

import com.example.com.example.testwallet.data.model.service.request.init.ServiceInitRequestModel
import com.example.testwallet.model.ServiceInitResponseModel
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Url

interface RetrofitAPI {

    @POST
    fun getInitRequest(
        @Url url: String,
        @Body serviceInitRequestModel: ServiceInitRequestModel
    ): Call<ServiceInitResponseModel>


    @POST
    fun getInitRequest2(
        @Url url: String,
        @Body serviceInitRequestModel: ServiceInitRequestModel
    ): Single<ServiceInitResponseModel>

}