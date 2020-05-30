package com.dunzhixuan.reflex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import java.lang.reflect.Field

class MainActivity : AppCompatActivity() {

    private var url: String = "https://mobile.vipkid.com.cn/parents/course/courseschedule/?_tbc=h"
    private val TAG : String = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_reflex).setOnClickListener { getField() }
    }

    fun getField() {
        try {
            val clazz = Class.forName("com.dunzhixuan.reflex.MainActivity")
            var url : Field = clazz.getDeclaredField("url")
            Log.e(TAG, url.toString());
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
