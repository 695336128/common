package com.zhang.common.baserx

import android.content.Context
import com.zhang.common.commonutils.LoadingUtil
import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by zhang .
 * DATA: 2018/7/27 .
 * Description : 对Subscriber进行封装
 */
abstract class RxObserver<T>(context: Context, showDialog: Boolean) : Observer<T> {

    var mContext: Context? = null
    var showDialog = true

    init {
        this.mContext = context
        this.showDialog = showDialog
    }

    constructor(context: Context) : this(context, true)


    override fun onComplete() {
        LoadingUtil.hideLoading()

    }

    override fun onSubscribe(d: Disposable) {
        if (showDialog){
            try {
                LoadingUtil.showLoading(mContext!!)
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
        doOnSubscribe(d)
    }

    override fun onNext(t: T) {
        doOnNext(t)
    }

    override fun onError(e: Throwable) {
        doOnError(e.message!!)
    }

    fun addDisposable(mCompositeDisposable: CompositeDisposable) {
        mCompositeDisposable.add(mCompositeDisposable)
    }

    protected abstract fun doOnSubscribe(d: Disposable)

    protected abstract fun doOnNext(t: T)

    protected abstract fun doOnError(message: String)


}