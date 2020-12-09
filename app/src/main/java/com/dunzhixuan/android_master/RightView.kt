package com.dunzhixuan.android_master

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import android.widget.Scroller

class RightView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : FrameLayout(context, attrs, defStyleAttr) {

    var downX = 0
    var downY = 0

    override fun onTouchEvent(event: MotionEvent): Boolean {
        var x = event.x.toInt()
        var y = event.y.toInt()
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                downX = event.x.toInt()
                downY = event.y.toInt()
            }
            MotionEvent.ACTION_MOVE -> {
                //通过计算x、y方向移动的距离和原有位置来计算出新的位置
                var offx = x - downX
                var offy = y - downY
//                layout(left + offx, top + offy, right + offx, bottom + offy)

//                offsetLeftAndRight(offx)
//                offsetTopAndBottom(offy)

                //为何要加(parent as View)，不加无效：虽然移动的是子view是相对于父布局移动父View的offx、offy的距离
                (parent as View).scrollBy(-offx, -offy)
            }
            else -> Log.d("TBG", "else")
        }
        return true
    }

    var mScroller: Scroller = Scroller(context)
    fun zoomIn() {
//        mScroller.forceFinished(true)

        mScroller.startScroll(-300, -100, 100, 0, 1000)
        invalidate()

        //View.Y ??
    }


    override fun computeScroll() {
        super.computeScroll()
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.currX, 100)
            invalidate()
        }
    }
}