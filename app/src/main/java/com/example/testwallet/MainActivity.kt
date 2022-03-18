package com.example.testwallet

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import com.example.testwallet.model.viewmodel.InitViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var initViewModel: InitViewModel

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewModel = ViewModelProvider(this).get(InitViewModel::class.java)

        initViewModel.callInit(this)

    }



}