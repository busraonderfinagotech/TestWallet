package com.example.testwallet.utils

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.com.example.testwallet.data.model.service.request.init.InitRequestModel
import com.example.testwallet.service.security.SecurityManager1
import com.google.gson.Gson

object  Utils {

    @RequiresApi(Build.VERSION_CODES.O)
    fun encryptRequest(initRequestModel: InitRequestModel): String {

        return SecurityManager1.encryptWithRSA(modelToJson(initRequestModel))
    }

    fun modelToJson(initRequestModel: InitRequestModel) : String{
        return Gson().toJson(initRequestModel)
    }




}