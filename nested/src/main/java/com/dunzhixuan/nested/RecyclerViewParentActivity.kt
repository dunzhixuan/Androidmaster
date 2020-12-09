package com.dunzhixuan.nested

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewParentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_parent)

        val recyclerViewParent : RecyclerViewParent = findViewById(R.id.recyclerViewParent)
        recyclerViewParent.layoutManager = LinearLayoutManager(this)

        recyclerViewParent.adapter = ParentAdapter()

        recyclerViewParent.addOnItemTouchListener(object : RecyclerView.SimpleOnItemTouchListener() {
            override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {


                val childView : View? = rv.findChildViewUnder(e.x, e.y)
                val position = childView?.let { rv.getChildLayoutPosition(it) }
                if (position == 1){
                    return true
                }

                return false
            }

            override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {

                val childView : View? = rv.findChildViewUnder(e.x, e.y)
                childView?.let {rvChild ->
                    val location = intArrayOf(e.x.toInt(), e.y.toInt())
                    childView.getLocationInWindow(location)
                    Log.d("liufeng1", " Y==" + e.y + "  location==" + location[1])

                    e.offsetLocation(e.x - location[0],e.y - location[1])

                    rvChild.onTouchEvent(e)
                }

            }
        })
    }

    class ParentAdapter : RecyclerView.Adapter<VH>(){

        override fun getItemViewType(position: Int): Int {
            if (position == 0){
                return 0
            } else {
                return 1
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
            if (viewType == 0){
                val textView : TextView = TextView(parent.context)
                textView.text = "Header"
                val lp = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 500)
                textView.layoutParams = lp
                return VH(textView)
            } else {
                val recyclerView = RecyclerView(parent.context)
                val lp = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1500)
                recyclerView.layoutParams = lp
                recyclerView.layoutManager = LinearLayoutManager(parent.context)
                recyclerView.adapter = MyAdapter()

                return VH(recyclerView)
            }
        }

        override fun getItemCount(): Int {
            return 2
        }

        override fun onBindViewHolder(holder: VH, position: Int) {

        }

    }

    class MyAdapter : RecyclerView.Adapter<VH>(){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
            val textView : TextView = TextView(parent.context)
            val lp = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200)
            textView.layoutParams = lp
            return VH(textView)
        }

        override fun getItemCount(): Int {
            return 20
        }

        override fun onBindViewHolder(holder: VH, position: Int) {

            val color = when (position % 3) {
                0 -> Color.RED
                1 -> Color.YELLOW
                else -> Color.GREEN
            }

            val textView  : TextView = holder.itemView as TextView
            textView.setBackgroundColor(color)
            textView.text = (position + 1).toString()
        }
    }

    class VH(view : View) : RecyclerView.ViewHolder(view){}

}