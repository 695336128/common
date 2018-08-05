package com.zhang.common.test

import com.zhang.common.baserx.BaseRespose
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by zhang .
 * DATA: 2018/7/28 .
 * Description :
 */
interface Api{
    @GET("tools/mockapi/7249/getTest")
    fun getTest(): Observable<BaseRespose<TestBean>>

}