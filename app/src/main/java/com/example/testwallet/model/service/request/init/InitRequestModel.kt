package com.example.com.example.testwallet.data.model.service.request.init

data class InitRequestModel(
    val deviceFingerprint: String,
    val deviceName: String,
    val aesKey: String,
    val deviceId: String,
    val secureToken: String
)