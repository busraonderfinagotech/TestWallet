package com.example.testwallet.service.security

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*

object SecurityManager1 {

    @RequiresApi(Build.VERSION_CODES.O)
    fun encryptWithAES(context: Context, data: String): String {
        return Base64.getEncoder().encodeToString(AESManager.encrypt(context, data))
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun decryptWithAES(context: Context, data: String): String? {
        return AESManager.decrypt(context, data)
    }

    fun generateAESKey(context: Context) {
        AESManager.generateKey(context)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getAESKey(context: Context): String {
        return AESManager.getSavedSecretKey(context)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun encryptWithRSA(data: String): String {
        return RSAManager.encrypt(data)
    }
}