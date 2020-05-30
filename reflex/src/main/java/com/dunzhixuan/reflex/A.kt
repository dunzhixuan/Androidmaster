package com.dunzhixuan.reflex

class A {

    private fun a() {
        try {
            val clazz = Class.forName("com.dunzhixuan.reflex.MainActivity")
            clazz.getDeclaredField("url")
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}
