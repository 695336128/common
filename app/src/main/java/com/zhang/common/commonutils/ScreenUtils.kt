package com.zhang.common.commonutils

import android.app.Activity
import android.content.Context
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Build
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowManager

/**
 * Created by zhang .
 * DATA: 2018/8/9 .
 * Description : 屏幕相关工具类
 */
object ScreenUtils {
    /**
     * 获取屏幕宽度
     */
    fun getScreenWidth(context: Context): Int {
        val wm: WindowManager? = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        if (wm == null) {
            return context.resources.displayMetrics.widthPixels
        }
        val outMetrics = DisplayMetrics()
        wm.defaultDisplay.getRealMetrics(outMetrics)
        return outMetrics.widthPixels
    }

    /**
     * 获取屏幕高度
     */
    fun getScreenHeight(context: Context): Int {
        val wm: WindowManager? = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        if (wm == null) {
            return context.resources.displayMetrics.widthPixels
        }
        val outMetrics = DisplayMetrics()
        wm.defaultDisplay.getRealMetrics(outMetrics)
        return outMetrics.heightPixels
    }

    /**
     * Return the density of screen.
     *
     * @return the density of screen
     */
    fun getScreenDensity(context: Context): Float {
        return context.resources.displayMetrics.density
    }

    /**
     * Return the screen density expressed as dots-per-inch.
     *
     * @return the screen density expressed as dots-per-inch
     */
    fun getScreenDensityDpi(context: Context): Int {
        return context.resources.displayMetrics.densityDpi
    }

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

    /**
     * 设置屏幕为横屏
     */
    fun setLandscape(activity: Activity){
        activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    }

    /**
     * 设置屏幕为竖屏
     */
    fun setPortrait(activity: Activity){
        activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    /**
     * 判断是否横屏
     */
    fun isLandscape(context: Context): Boolean{
        return context.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
    }

    /**
     * 判断是否竖屏
     */
    fun isPortrait(context: Context): Boolean{
        return context.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT
    }

    // TODO:screenShot         : 截屏
    // TODO:isTablet           : 判断是否是平板


}