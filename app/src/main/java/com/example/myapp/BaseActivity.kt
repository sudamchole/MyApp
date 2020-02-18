package com.example.myapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.google.gson.JsonObject
import okhttp3.OkHttpClient
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import com.google.gson.Gson
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit


abstract class BaseActivity : AppCompatActivity(), Callback<JsonObject> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.setDefaultUncaughtExceptionHandler(handleAppCrash);

    }

    private val handleAppCrash = Thread.UncaughtExceptionHandler { thread, ex ->
        Log.e("error here", ex.toString())
        //send email here
        logErrorAPI(ex.toString())
    }

    private fun logErrorAPI(error: String) {
        Log.e("called here", "xyz")
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(2, TimeUnit.MINUTES)
            .connectTimeout(2, TimeUnit.MINUTES)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(AppConstant.BASE_URL.BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        val apiInterface = retrofit.create(ApiInterface::class.java)

        // prepare call in Retrofit 2.0
        try {
            val paramObject = JSONObject()
            paramObject.put("ErrorDesc", error)
            val userCall = apiInterface.logErrorAPI(paramObject.toString())
            Log.e("param",paramObject.toString())
            userCall.enqueue(this)
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

    override fun onFailure(call: Call<JsonObject>, t: Throwable) {
        Log.e("response here", t.message)
    }

    override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
        Log.e("response here", response.body().toString())
    }
}