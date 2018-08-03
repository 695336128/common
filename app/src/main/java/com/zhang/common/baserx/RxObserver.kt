package com.zhang.common.baserx

import android.content.Context
import com.zhang.common.R
import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by zhang .
 * DATA: 2018/7/27 .
 * Description : 对Subscriber进行封装
 */
abstract class RxObserver<T>(context: Context, msg: String, showDialog: Boolean) : Observer<T> {

    var mContext: Context? = null
    var msg: String? = null
    var showDialog = true

    constructor(context: Context) : this(context, context.applicationContext.getString(R.string.loading), true)

    constructor(context: Context, showDialog: Boolean) : this(context, context.applicationContext.getString(R.string.loading), showDialog)

    override fun onComplete() {

    }

    override fun onSubscribe(d: Disposable) {
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

    /**
     * 显示浮动dialog
     */
    fun showDialog() {
        this.showDialog = true
    }

    /**
     * 隐藏浮动dialog
     */
    fun hideDialog() {
        this.showDialog = true
    }

}