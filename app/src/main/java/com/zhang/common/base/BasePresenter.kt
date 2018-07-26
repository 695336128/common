package com.zhang.common.base

import android.content.Context

/**
 * Created by zhang .
 * DATA: 2018/7/22 .
 * Description : 基类Presenter
 */
abstract class BasePresenter<T, E> {

    var mContext: Context? = null
    var mModel: E? = null
    var mView: T? = null

    fun setVM(v: T, m: E) {
        this.mModel = m
        this.mView = v
        this.onStart()
    }

    fun onStart() {}
    fun onDestroy(){}
}