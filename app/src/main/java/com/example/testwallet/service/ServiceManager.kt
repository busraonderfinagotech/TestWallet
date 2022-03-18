package com.example.testwallet.service

import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.com.example.testwallet.data.model.service.request.init.InitRequestModel
import com.example.com.example.testwallet.data.model.service.request.init.ServiceInitRequestModel
import com.example.com.example.testwallet.service.utils.DeviceInfo
import com.example.testwallet.NetworkManager
import com.example.testwallet.model.InitResponseModel
import com.example.testwallet.model.ServiceInitResponseModel
import com.example.testwallet.service.security.SecurityManager1
import com.example.testwallet.utils.Utils
import com.google.gson.Gson


class ServiceManager(var context: Context) {

    var newtworkManager = NetworkManager()

    @RequiresApi(Build.VERSION_CODES.O)
    fun setInitRequestModel(_context : Context)  {

        SecurityManager1.generateAESKey(context)
        val initRequestModel1 =
            InitRequestModel(
                DeviceInfo.getDeviceInfo(),
                DeviceInfo.deviceName(),
                SecurityManager1.getAESKey(context),
                "",
                ""
            )


        setServiceInitRequestModel(initRequestModel1,context)

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun setServiceInitRequestModel(initRequestModel: InitRequestModel,context: Context){
        /*
          val initRequestModelJson = Utils.encryptRequest(initRequestModel)
          val encryptedData = SecurityManager1.encryptWithRSA(initRequestModelJson)
          val serviceInitRequestModel1 = ServiceInitRequestModel(encryptedData)
          getDataFromAPI(serviceInitRequestModel1)
        */
        getDataFromAPI(ServiceInitRequestModel(Utils.encryptRequest(initRequestModel)),context)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private  fun getDataFromAPI(serviceInitRequestModel: ServiceInitRequestModel,context: Context) {

        var serviceInitResponseModel : ServiceInitResponseModel
        newtworkManager.getData(serviceInitRequestModel){
            id->
            var initResponseModel = Gson().fromJson(SecurityManager1.decryptWithAES(context,id.encryptedData),InitResponseModel::class.java)
            Log.e("Gel bakalım",initResponseModel.sessionId)
        }



    }






















}