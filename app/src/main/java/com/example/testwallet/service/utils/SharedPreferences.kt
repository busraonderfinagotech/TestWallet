package com.example.com.example.testwallet.service.utils

import android.content.Context
import android.preference.PreferenceManager
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

object SharedPreferences {

    fun saveToSharedPreferences(context: Context, data: String, key: String) {
        val baos = ByteArrayOutputStream()
        val oos = ObjectOutputStream(baos)
        oos.writeObject(data)
        val strToSave =
            String(android.util.Base64.encode(baos.toByteArray(), android.util.Base64.DEFAULT))
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = sharedPref.edit()
        editor.putString(key, strToSave)
        editor.apply()
    }

    fun getFromSharedPreferences(context: Context, key: String): String {
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context)
        val strSecretKey = sharedPref.getString(key, "")
        val bytes = android.util.Base64.decode(strSecretKey, android.util.Base64.DEFAULT)
        val ois = ObjectInputStream(ByteArrayInputStream(bytes))
        val data = ois.readObject() as String
        return data
    }
}