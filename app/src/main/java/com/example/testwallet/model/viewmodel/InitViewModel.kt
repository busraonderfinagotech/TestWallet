package com.example.testwallet.model.viewmodel

import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.com.example.testwallet.data.model.service.request.init.InitRequestModel
import com.example.com.example.testwallet.data.model.service.request.init.ServiceInitRequestModel
import com.example.com.example.testwallet.data.model.service.response.generic.errorhandling.ErrorHandlingModel
import com.example.com.example.testwallet.service.utils.DeviceInfo
import com.example.testwallet.NetworkManager
import com.example.testwallet.model.InitResponseModel
import com.example.testwallet.model.ServiceInitResponseModel
import com.example.testwallet.service.ServiceManager
import com.example.testwallet.service.security.SecurityManager1
import com.example.testwallet.utils.Utils
import com.google.gson.Gson
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class InitViewModel : ViewModel() {

    var serviceManager = ServiceManager()

    @RequiresApi(Build.VERSION_CODES.O)
    fun callInit(context : Context){
        serviceManager.setInitRequestModel(context)
    }



}


