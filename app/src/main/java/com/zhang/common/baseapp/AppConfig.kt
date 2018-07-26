package com.zhang.common.baseapp

import android.Manifest

/**
 * Created by zhang .
 * DATA: 2018/7/26 .
 * Description : APP 相关参数配置
 */
object AppConfig {
    //需要申请的权限列表
    var PERMISSIONS = arrayOf(
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE)
}