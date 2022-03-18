package com.example.com.example.testwallet.data.model.service.response.init

import com.example.com.example.testwallet.data.model.service.response.generic.config.ConfigModel
import com.example.com.example.testwallet.data.model.service.response.generic.errorhandling.ErrorHandlingModel

data class InitResponseModel(
    var deviceId: String,
    var sessionId: String,
    var errorData: ErrorHandlingModel,
    var config: List<ConfigModel>?
)