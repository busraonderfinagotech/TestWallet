package com.example.testwallet.model

import com.example.com.example.testwallet.data.model.service.response.generic.config.ConfigModel
import com.example.com.example.testwallet.data.model.service.response.generic.errorhandling.ErrorHandlingModel
import com.google.gson.annotations.SerializedName

data class InitResponseModel(

    @SerializedName("deviceId")
    var deviceId: String,

    @SerializedName("sessionId")
    var sessionId: String,

    @SerializedName("errorData")
    var errorData: ErrorHandlingModel,

    @SerializedName("config")
    var config: List<ConfigModel>?
)

data class ServiceInitResponseModel(
    var encryptedData: String
)