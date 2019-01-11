package com.zhang.common.baserx

import com.zhang.common.R
import com.zhang.common.commonutils.L
import com.zhang.common.commonutils.LoadingUtil
import com.zhang.common.commonutils.NetUtil
import com.zhang.common.test.MyApplication
import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeoutException

/**
 * Created by zhang .
 * DATA: 2018/7/27 .
 * Description : 对Subscriber进行封装
 */
abstract class RxObserver<T>() : Observer<T> {

    override fun onComplete() {
        LoadingUtil.hideLoading()

    }

    override fun onSubscribe(d: Disposable) {
        doOnSubscribe(d)
    }

    override fun onNext(t: T) {
        doOnNext(t)
    }

    override fun onError(e: Throwable) {
        e.printStackTrace()
        L.d(e.message?:"_onError")
        if (!NetUtil.isConnected(MyApplication.instance())){
            // 网络问题
            doOnError(MyApplication.instance().getString(R.string.no_net))
        }else if (e is ServerException){
            // 服务器
            doOnError(e.message?:"ServerException")
        }else if (e is TimeoutException){
            // 超时
            doOnError(MyApplication.instance().getString(R.string.net_time_out))
        }else{
            doOnError(MyApplication.instance().getString(R.string.net_error))
        }
    }

    fun addDisposable(mCompositeDisposable: CompositeDisposable) {
        mCompositeDisposable.add(mCompositeDisposable)
    }

    protected abstract fun doOnSubscribe(d: Disposable)

    protected abstract fun doOnNext(t: T)

    protected abstract fun doOnError(message: String)


}