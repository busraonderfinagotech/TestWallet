package com.example.testwallet

import android.annotation.SuppressLint
import android.util.Log
import com.example.com.example.testwallet.data.model.service.request.init.ServiceInitRequestModel
import com.example.testwallet.model.ServiceInitResponseModel
import com.example.testwallet.service.RetrofitAPI
import com.example.testwallet.service.ServiceManager
import com.example.testwallet.service.security.SecurityManager1
import com.example.testwallet.service.utils.Constants
import com.morpara.wallet.nl.data.enum.EnumManager
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.flow.callbackFlow
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NetworkManager  {


    private val api = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
        .create(RetrofitAPI::class.java)

    @SuppressLint("LogNotTimber")
    fun getData(serviceInitRequestModel : ServiceInitRequestModel, callback: (ServiceInitResponseModel)->Unit) {

        var serviceInitResponseModel : ServiceInitResponseModel


        api.getInitRequest2(EnumManager.valueOf("SPLASH").url, serviceInitRequestModel)
            .subscribeOn(Schedulers.io()) // arka planda çalışacak
            .observeOn(AndroidSchedulers.mainThread()) //ana mainde
            .doOnSuccess{Log.i("Susccesss","success")}

            .subscribeWith(object : DisposableSingleObserver<ServiceInitResponseModel>(){
                override fun onSuccess(t: ServiceInitResponseModel) {
                    Log.i("Retrofit","onSuccess ")
                    callback(t)
                }

                override fun onError(e: Throwable) {
                    Log.i("Retrofit","onFailure ",e)

                }
            })



    }




    private fun updateM(it: ServiceInitResponseModel) : ServiceInitResponseModel {
        Log.i("Subscribe Sucsess",it.encryptedData);
        return it


    }

    private fun errorM(it: Throwable) {
        Log.i("Subscribe Error",it.message.toString());

    }
}




