package com.namshi.sharukh2

import android.app.Activity
import android.app.Application
import android.util.DisplayMetrics
import android.util.Size
import androidx.annotation.ColorRes
import androidx.core.content.res.ResourcesCompat


class App : Application() {

    companion object {

        @get:Synchronized
        lateinit var instance: App
            private set
    }


    override fun onCreate() {
        super.onCreate()
        instance = this

    }


}

fun color(@ColorRes id: Int): Int = ResourcesCompat.getColor(App.instance.resources, id, null)

fun screenSize(activity: Activity): Size {
    val displayMetrics = DisplayMetrics()
    activity.windowManager.defaultDisplay.getMetrics(displayMetrics)
    val height = displayMetrics.heightPixels
    val width = displayMetrics.widthPixels
    return Size(width, height)
}