package com.dunzhixuan.nested

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NestedScrollViewTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nested_scroll_view_test)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyAdapter()
    }

    class MyAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val textView = TextView(parent.context)
            textView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300)
            return MyViewHolder(textView)
        }
//        val a : ScrollView

        override fun getItemCount(): Int {
            return 20
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            Log.d("liufeng1", "onBindViewHolder: position = " + position)
            val color = when (position % 3) {
                0 -> Color.RED
                1 -> Color.YELLOW
                else -> Color.GREEN
            }
            val textView : TextView = holder.itemView as TextView
            textView.setBackgroundColor(color)
            textView.setText(position.toString())
        }

        class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    }
}