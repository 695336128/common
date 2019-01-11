package com.zhang.common.test

import android.app.Application
import android.content.res.Resources
import com.zhang.common.baseapp.BaseApplication
import com.zhang.common.commonutils.L

/**
 * Created by zhang .
 * DATA: 2018/8/8 .
 * Description :
 */
class MyApplication: BaseApplication() {

    companion object {
        private var instance: Application? = null

        fun instance() = instance!!

        fun getAppResources(): Resources {
            return instance?.resources!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        L.init(true)
    }


}