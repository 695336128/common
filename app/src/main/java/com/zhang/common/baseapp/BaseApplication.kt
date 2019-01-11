package com.zhang.common.baseapp

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex

/**
 * Created by zhang .
 * DATA: 2018/7/21 .
 * Description : APPLICATION
 */
open class BaseApplication : Application(){

    val TAG = "FATE"

    override fun onCreate() {
        super.onCreate()
    }

    /**
     * 分包
     */
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }





}
