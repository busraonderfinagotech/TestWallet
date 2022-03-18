package com.example.testwallet.service.security

import android.content.Context
import android.os.Build
import android.preference.PreferenceManager
import java.util.Base64
import androidx.annotation.RequiresApi
import com.example.testwallet.service.utils.Constants.AES_ALGORITHM
import com.example.testwallet.service.utils.Constants.AES_TRANSFORMATION
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.lang.Exception
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec


object AESManager {

    @RequiresApi(Build.VERSION_CODES.O)
    fun encrypt(context: Context, strToEncrypt: String): ByteArray {
        val plainText = strToEncrypt.toByteArray(Charsets.UTF_8)
        val cipher = Cipher.getInstance(AES_TRANSFORMATION)
        val decodedKey = Base64.getDecoder().decode(getSavedSecretKey(context))
        val key = SecretKeySpec(decodedKey, 0, decodedKey.size, "AES")
        cipher.init(Cipher.ENCRYPT_MODE, key)
        val cipherText = cipher.doFinal(plainText)

        val sb = StringBuilder()
        for (b in cipherText) {
            sb.append(b.toChar())
        }
        return cipherText
    }


/*    @RequiresApi(Build.VERSION_CODES.O)
    fun decrypt(context: Context, dataToDecrypt: ByteArray): ByteArray {
        val cipher = Cipher.getInstance(AES_TRANSFORMATION)
        val ivSpec = IvParameterSpec(getSavedInitializationVector(context))
        val decodedKey = Base64.getDecoder().decode(getSavedSecretKey(context))
        cipher.init(
            Cipher.DECRYPT_MODE,
            SecretKeySpec(decodedKey, 0, decodedKey.size, "AES"),
            ivSpec
        )
        val cipherText = cipher.doFinal(dataToDecrypt)
        val sb = StringBuilder()
        for (b in cipherText) {
            sb.append(b.toChar())
        }
        return cipherText
    }*/

    @RequiresApi(Build.VERSION_CODES.O)
    fun decrypt(context: Context, strToDecrypt: String): String? {
        try {
            val cipher = Cipher.getInstance(AES_TRANSFORMATION)
            val decodedKey = Base64.getDecoder().decode(getSavedSecretKey(context))
            cipher.init(Cipher.DECRYPT_MODE, SecretKeySpec(decodedKey, 0, decodedKey.size, "AES"))
            return String(
                cipher.doFinal(Base64.getDecoder().decode(strToDecrypt))
            )
        } catch (e: Exception) {
            println("Error while decrypting: $e")
        }
        return null
    }


    fun saveSecretKey(context: Context, secretKey: SecretKey) {
        val baos = ByteArrayOutputStream()
        val oos = ObjectOutputStream(baos)
        oos.writeObject(secretKey)
        val strToSave =
            String(android.util.Base64.encode(baos.toByteArray(), android.util.Base64.DEFAULT))
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = sharedPref.edit()
        editor.putString("secret_key", strToSave)
        editor.apply()
    }

    fun generateKey(context: Context): SecretKey {
        val keygen = KeyGenerator.getInstance(AES_ALGORITHM)
        keygen.init(256)
        val key = keygen.generateKey()
        saveSecretKey(context, key)
        return key
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun getSavedSecretKey(context: Context): String {
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context)
        val strSecretKey = sharedPref.getString("secret_key", "")
        val bytes = android.util.Base64.decode(strSecretKey, android.util.Base64.DEFAULT)
        val ois = ObjectInputStream(ByteArrayInputStream(bytes))
        val secretKey = ois.readObject() as SecretKey
        return Base64.getEncoder().encodeToString(secretKey.encoded)
    }

}