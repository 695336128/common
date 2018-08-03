package com.zhang.common.test

import com.google.gson.annotations.Expose
import com.zhang.common.baserx.BaseRespose
import java.io.Serializable

/**
 * Created by zhang .
 * DATA: 2018/7/27 .
 * Description :
 */
open class TestBean : Serializable,BaseRespose<TestBean>(){

    @Expose
    var name: String? = null

    @Expose
    var url: String? = null

    override fun toString(): String {
        return "TestBean(name=$name, url=$url)"
    }


}