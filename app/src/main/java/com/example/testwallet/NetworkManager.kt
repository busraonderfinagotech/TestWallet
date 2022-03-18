package com.example.testwallet

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.com.example.testwallet.data.model.service.request.init.ServiceInitRequestModel
import com.example.testwallet.model.ServiceInitResponseModel
import com.example.testwallet.service.RetrofitAPI
import com.example.testwallet.service.utils.Constants
import com.morpara.wallet.nl.data.enum.EnumManager
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NetworkManager  {

    lateinit var serviceInitResponseModel : ServiceInitResponseModel


    private val api = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
        .create(RetrofitAPI::class.java)

    fun getData(serviceInitRequestModel : ServiceInitRequestModel){
        api.getInitRequest2(EnumManager.valueOf("SPLASH").url, serviceInitRequestModel)
            .subscribeOn(AndroidSchedulers.mainThread()) // arka planda çalışacak
            .observeOn(AndroidSchedulers.mainThread()) //ana mainde gözlemlenecek
            .subscribeWith(object : DisposableSingleObserver<ServiceInitResponseModel>(){
                override fun onSuccess(t: ServiceInitResponseModel) {
                    serviceInitResponseModel = t
                    Log.i("Retrofit","onSuccess  "+t.encryptedData)
                }

                override fun onError(e: Throwable) {
                    Log.i("Retrofit","onFailure ",e)                    }
            })
    }
}