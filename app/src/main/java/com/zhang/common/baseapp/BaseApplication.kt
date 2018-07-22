package com.zhang.common.baseapp

import android.app.Application
import android.content.Context
import android.content.res.Resources
import android.support.multidex.MultiDex

/**
 * Created by zhang .
 * DATA: 2018/7/21 .
 * Description : APPLICATION
 */
class BaseApplication : Application(){

    val TAG = "FATE"

    val context by lazy { this } //这里使用了委托，表示只有使用到instance才会执行该段代码

    override fun onCreate() {
        super.onCreate()
    }

    fun getAppResources():Resources{
        return this.getAppResources()
    }

    override fun onTerminate() {
        super.onTerminate()
    }

    /**
     * 分包
     */
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }





}
