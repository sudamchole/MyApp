package com.example.myapp
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.setDefaultUncaughtExceptionHandler(handleAppCrash);

    }
    private val handleAppCrash = Thread.UncaughtExceptionHandler { thread, ex ->
        Log.e("error here", ex.toString())
        //send email here
        sendCrash()
    }
    fun sendCrash(){

    }
}