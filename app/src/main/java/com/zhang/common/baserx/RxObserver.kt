package com.zhang.common.baserx

import android.app.Application
import android.content.Context
import com.zhang.common.R
import com.zhang.common.baseapp.BaseApplication
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

    constructor(context: Context) : this(context, (BaseApplication.context as Application).getString(R.string.loading), true)

    constructor(context: Context, showDialog: Boolean) : this(context, (BaseApplication.context as Application).getString(R.string.loading), showDialog)

    override fun onComplete() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSubscribe(d: Disposable) {
        doOnSubscribe(d)
    }

    override fun onNext(t: T) {
        doOnNext(t)
    }

    override fun onError(e: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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