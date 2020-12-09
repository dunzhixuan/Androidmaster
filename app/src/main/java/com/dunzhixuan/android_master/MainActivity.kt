package com.dunzhixuan.android_master

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var container: LinearLayout;
    lateinit var btn_move:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        val ll: LinearLayout = findViewById(R.id.ll_view_layout);
        btn_move = findViewById(R.id.btn_move);
        val rightview = RightView(this)
        ll.addView(rightview)
        val scrollerView = findViewById<CustomScrollerView>(R.id.custom_scrollerView)
        btn_move.setOnClickListener {
            scrollerView.beginScroll()
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
    }
}