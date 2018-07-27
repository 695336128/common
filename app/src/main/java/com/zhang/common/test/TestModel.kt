package com.zhang.common.test

import com.zhang.common.baserx.RxSchedulers
import io.reactivex.Observable

/**
 * Created by zhang .
 * DATA: 2018/7/27 .
 * Description :
 */
class TestModel: TestContract.Model{
    override fun loadData(): Observable<TestBean> {
        // 使用RxJava+Retrofit进行网络请求
        return Observable.create<TestBean>{
            subscriber ->
            var testBean: TestBean? = null
            testBean?.let { subscriber.onNext(it) }
            subscriber.onComplete()
        }.compose(RxSchedulers.io_main<TestBean>())
    }

}