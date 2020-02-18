package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class NewActivity : BaseActivity() {
    val list = ArrayList<String>()
    lateinit var btnClick:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)
        //btnClick=findViewById(R.id.btnClick)
        btnClick.setOnClickListener(View.OnClickListener {

        })


    }
}
