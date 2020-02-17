package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class NewActivity : BaseActivity() {
    val list = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)
        var a= list[34]

    }
}
