package com.zhang.common.test

import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by zhang .
 * DATA: 2018/7/28 .
 * Description :
 */
interface Api{
    @GET("tools/mockapi/7249/getTest")
    fun getTest(): Call<TestBean>

}