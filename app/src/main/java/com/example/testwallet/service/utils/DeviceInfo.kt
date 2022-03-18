package com.example.com.example.testwallet.service.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.lang.Exception
import java.util.*
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

object DeviceInfo {
    @RequiresApi(Build.VERSION_CODES.O)
    fun getDeviceInfo(): String {
        val builder = StringBuilder()
        builder.append("RELEASE " + Build.VERSION.RELEASE + ",")
        builder.append("DEVICE " + Build.DEVICE + ",")
        builder.append("MODEL " + Build.MODEL + ",")
        builder.append("PRODUCT " + Build.PRODUCT + ",")
        builder.append("BRAND " + Build.BRAND + ",")
        builder.append("DISPLAY " + Build.DISPLAY + ",")
        builder.append("UNKNOWN " + Build.UNKNOWN + ",")
        builder.append("HARDWARE " + Build.HARDWARE + ",")
        builder.append("ID " + Build.ID + ",")
        builder.append("MANUFACTURER " + Build.MANUFACTURER + ",")
        builder.append("USER " + Build.USER + ",")
        builder.append("HOST " + Build.HOST + ",")
        val data = builder.toString()
        try {
            val secret = "init"
            val message = data
            val sha256_HMAC: Mac = Mac.getInstance("HmacSHA256")
            val secret_key = SecretKeySpec(secret.toByteArray(), "HmacSHA256")
            sha256_HMAC.init(secret_key)
            val hash: String =
                Base64.getEncoder().encodeToString(sha256_HMAC.doFinal(message.toByteArray()))
            println(hash)
            return hash
        } catch (e: Exception) {
            println("Error")
        }
        return data
    }

    fun deviceName(): String {
        return Build.DEVICE
    }
}