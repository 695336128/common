package com.zhang.common.test

import com.zhang.common.baserx.RxSchedulers
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by zhang .
 * DATA: 2018/7/27 .
 * Description :
 */
class TestModel: TestContract.Model{
    override fun loadData(): Observable<TestBean> {
        // 使用RxJava+Retrofit进行网络请求
        return Observable.create<TestBean>{
            emmitter ->
            var testBean: TestBean? = null
            val retrofit:Retrofit = Retrofit.Builder()
                    .baseUrl("http://www.wanandroid.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            val ipService = retrofit.create(Api::class.java)
            testBean = ipService.getTest().execute().body()
            testBean?.let { emmitter.onNext(it) }
//            emmitter.onComplete()
        }.compose(RxSchedulers.io_main<TestBean>())
    }

}