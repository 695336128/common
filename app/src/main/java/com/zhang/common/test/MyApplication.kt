package com.zhang.common.test

import com.zhang.common.baseapp.BaseApplication
import com.zhang.common.commonutils.LoggerUtil

/**
 * Created by zhang .
 * DATA: 2018/8/8 .
 * Description :
 */
class MyApplication: BaseApplication() {
    override fun onCreate() {
        super.onCreate()
        LoggerUtil.init(true)
    }
}