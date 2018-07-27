package com.zhang.common.baserx

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


/**
 * Created by zhang .
 * DATA: 2018/7/27 .
 * Description : 用于管理单个presenter的RxBus的事件和Rxjava相关代码的生命周期处理
 */
class RxManager {
    val mObservables: Map<String, Observable<*>> = HashMap()
    // 管理Observables 和 Subscribers订阅
    val mCompositeDisposable = CompositeDisposable()

    /**
     * 订阅者管理
     */
    fun add(disposable: Disposable) {
        mCompositeDisposable.add(disposable)
    }

    /**
     * 单个presenter生命周期结束，取消订阅和所有rxbus观察
     */
    fun clear() {
        mCompositeDisposable.clear()
    }
}