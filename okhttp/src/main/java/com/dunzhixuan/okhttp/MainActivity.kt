package com.dunzhixuan.okhttp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun connection() {
        Thread(Runnable {
            try {
                val url = URL("https://www.baidu.com/")
                //得到connection对象。
                val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
                //设置请求方式
                connection.setRequestMethod("GET")
                //连接
                connection.connect()
                //得到响应码
                val responseCode: Int = connection.getResponseCode()
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    //得到响应流
                    val inputStream: InputStream = connection.getInputStream()
                    //将响应流转换成字符串
//                    val result: String = is2String(inputStream) //将流转换为字符串。
//                    Log.d("kwwl", "result=============$result")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }).start()
    }
}
