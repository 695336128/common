package com.zhang.common.commonutils

import android.app.Activity
import android.os.Build
import android.view.View
import android.view.WindowManager

/**
 * Created by zhang .
 * DATA: 2018/7/26 .
 * Description : 设备相关工具类
 */
object DeviceUtil {

    /**
     * 设置全屏显示
     */
    fun setFullScreen(act: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val decorView = act.window.decorView
            decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        }
    }

    /**
     * 设置屏幕常亮
     */
    fun setKeepScreenOn(act: Activity) {
        act.window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
    }

}