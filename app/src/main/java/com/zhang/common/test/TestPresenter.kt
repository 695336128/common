package com.zhang.common.test

import com.zhang.common.baserx.RxObserver
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer

/**
 * Created by zhang .
 * DATA: 2018/7/26 .
 * Description :
 */
class TestPresenter : TestContract.Presenter() {

    override fun onStart(){
        mRxManage.onEvent(TestBean::class.java, Consumer { println("收到了RxBus") })
    }

    override fun loadDataRequest() {
        // 处理在Model中的请求返回值
        mModel?.loadData()?.subscribe(object : RxObserver<TestBean>(){
            override fun doOnSubscribe(d: Disposable) {
                mView?.showLoading()
                mRxManage.add(d)
            }

            override fun doOnNext(t: TestBean) {
                mView?.doWithData(t)
                mRxManage.post(t)
            }

            override fun doOnError(message: String) {
                mView?.stopLoading()
                mView?.showErrorTip(message)
            }
        })

    }

}