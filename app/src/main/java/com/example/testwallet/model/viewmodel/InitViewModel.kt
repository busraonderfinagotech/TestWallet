package com.example.testwallet.model.viewmodel

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.example.testwallet.service.ServiceManager

class InitViewModel : ViewModel() {



    @RequiresApi(Build.VERSION_CODES.O)
    fun callInit(context : Context){
        var serviceManager = ServiceManager(context)
        serviceManager.setInitRequestModel(context)
    }



}


