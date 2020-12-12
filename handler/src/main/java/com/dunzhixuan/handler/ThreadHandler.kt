package com.dunzhixuan.handler

import android.os.Handler
import android.os.Looper
import android.os.Message
import java.sql.DriverManager.println

class ThreadHandler {
    companion object{
        val handler:Handler by lazy{

        }
    }
    private val name: String by lazy{"1111"}
    private fun threadB(){
        val thread = Thread(Runnable {
            Looper.prepare()

            Looper.loop()
        })
    }
    
    private fun threadA() {
        val thread:Thread = Thread(Runnable {
            val message = Message()
            message.obj = "1"
            handler.sendMessage(message)
        })
    }
}

class LazyLoadinigTest{

    private val name: String by lazy{"1111"}

    fun printName() {
        println(name)
    }
}