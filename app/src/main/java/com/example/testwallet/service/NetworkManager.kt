package com.example.testwallet.service

import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.disposables.CompositeDisposable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber
import java.util.concurrent.CountDownLatch
import javax.inject.Inject

class NetworkManager @Inject constructor(private val retrofitAPI: RetrofitAPI) {

    private  val disposable = CompositeDisposable()
/*
    val notEncryptedResponse = MutableLiveData<ServiceGenericResponseModel>()
    val notEncryptedGenericResponse = MutableLiveData<ServiceGenericResponseModel>()
    val notEncryptedInitResponse = MutableLiveData<ServiceInitResponseModel>()


    fun generic(
        requestUrl: String,
        serviceGenericRequestModel: ServiceGenericRequestModel
    ): MutableLiveData<ServiceGenericResponseModel> {

        val response = retrofitAPI.getGenericRequest(requestUrl, serviceGenericRequestModel)
        response.enqueue(object : Callback<ServiceGenericResponseModel> {
            override fun onFailure(call: Call<ServiceGenericResponseModel>, t: Throwable) {
                Timber.e("FAILED!")
            }

            override fun onResponse(
                call: Call<ServiceGenericResponseModel>,
                response: Response<ServiceGenericResponseModel>
            ) {
                notEncryptedGenericResponse.postValue(response.body())
                Timber.e("SUCCESS")
            }
        })

        return notEncryptedGenericResponse
    }

    fun init(
        requestUrl: String,
        serviceRequestModel: ServiceInitRequestModel
    ): MutableLiveData<ServiceInitResponseModel> {
        val response: Call<ServiceInitResponseModel> =
            retrofitAPI.getInitRequest(requestUrl, serviceRequestModel)

        response.enqueue(object : Callback<ServiceInitResponseModel> {
            override fun onFailure(call: Call<ServiceInitResponseModel>, t: Throwable) {
                Timber.e(t.message.toString())
                Timber.e("Hello")

            }

            override fun onResponse(
                call: Call<ServiceInitResponseModel>,
                response: Response<ServiceInitResponseModel>
            ) {
                notEncryptedInitResponse.postValue(response.body())
                Timber.e("Data Geldi!")
                Timber.e(response.body().toString())
            }
        })
        return notEncryptedInitResponse

    }

 */
}