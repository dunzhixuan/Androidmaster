package com.dunzhixuan.toastproblem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT

class MainActivity : AppCompatActivity() {

    lateinit var btn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.btn_toast)

        btn.setOnClickListener { Toast.makeText(this,"123", LENGTH_SHORT).show() }
    }
}
