package com.example.testwallet.service

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.com.example.testwallet.data.model.service.request.init.InitRequestModel
import com.example.com.example.testwallet.data.model.service.request.init.ServiceInitRequestModel
import com.example.com.example.testwallet.service.utils.DeviceInfo
import com.example.testwallet.NetworkManager
import com.example.testwallet.service.security.SecurityManager1
import com.example.testwallet.utils.Utils


class ServiceManager() {

    var newtworkManager = NetworkManager()

    @RequiresApi(Build.VERSION_CODES.O)
    fun setInitRequestModel(context : Context)  {

        SecurityManager1.generateAESKey(context)
        val initRequestModel1 =
            InitRequestModel(
                DeviceInfo.getDeviceInfo(),
                DeviceInfo.deviceName(),
                SecurityManager1.getAESKey(context),
                "",
                ""
            )


        setServiceInitRequestModel(initRequestModel1)

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun setServiceInitRequestModel(initRequestModel: InitRequestModel){
        /*
          val initRequestModelJson = Utils.encryptRequest(initRequestModel)
          val encryptedData = SecurityManager1.encryptWithRSA(initRequestModelJson)
          val serviceInitRequestModel1 = ServiceInitRequestModel(encryptedData)
          getDataFromAPI(serviceInitRequestModel1)
        */
        getDataFromAPI(ServiceInitRequestModel(Utils.encryptRequest(initRequestModel)))
    }
    private  fun getDataFromAPI(serviceInitRequestModel: ServiceInitRequestModel){
        newtworkManager.getData(serviceInitRequestModel)
    }




















}