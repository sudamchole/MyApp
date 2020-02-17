package com.example.myapp

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText

import kotlinx.android.synthetic.main.activity_main.*
import java.sql.Array
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T




class MainActivity : BaseActivity() {
    lateinit var editText: EditText
    lateinit var btnClick:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText=findViewById(R.id.editTextHello)
        btnClick=findViewById(R.id.btn_click_me)
        btnClick.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, NewActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE,editText.text.toString())
            }
            startActivity(intent)
        })
    }

}
