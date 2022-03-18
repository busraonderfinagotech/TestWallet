package com.example.testwallet.service.security

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.testwallet.service.utils.Constants.PUBLIC_KEY
import com.example.testwallet.service.utils.Constants.RSA_ALGORITHM
import com.example.testwallet.service.utils.Constants.RSA_TRANSFORMATION
import timber.log.Timber
import java.security.*
import java.security.spec.X509EncodedKeySpec
import java.util.*
import javax.crypto.*

object RSAManager {
    lateinit var publicKey: PublicKey

    @RequiresApi(Build.VERSION_CODES.O)
    fun encrypt(data: String): String {
        Timber.tag("AAAA").e(data)
        val cipher = Cipher.getInstance(RSA_TRANSFORMATION)
        cipher.init(Cipher.ENCRYPT_MODE, getPublicKey(PUBLIC_KEY))
        val plaintext = Base64.getEncoder().encodeToString(cipher.doFinal(data.toByteArray()))
        Timber.tag("YYYY").e(plaintext)
        return plaintext
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun getPublicKey(base64PublicKey: String): PublicKey? {
        val keySpec =
            X509EncodedKeySpec(Base64.getDecoder().decode(base64PublicKey.toByteArray()))
        val keyFactory = KeyFactory.getInstance(RSA_ALGORITHM)
        publicKey = keyFactory.generatePublic(keySpec)
        return publicKey
    }

/*    @RequiresApi(Build.VERSION_CODES.O)
    @Throws(GeneralSecurityException::class, IOException::class)
    fun getPublicKey(stored: String): Key {
        val data: ByteArray = Base64.getDecoder().decode(stored.toByteArray())
        val spec = X509EncodedKeySpec(data)
        val fact = KeyFactory.getInstance(RSA_ALGORITHM)
        return fact.generatePublic(spec)
    }*/

}