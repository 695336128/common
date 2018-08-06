package com.zhang.common.commonutils

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by zhang .
 * DATA: 2018/8/6 .
 * Description : SharedPreferences相关
 */
 class SPUtil private constructor(context: Context){

    private val FILE_NAME = "share_date"
    private var sp: SharedPreferences? = null
    private var editor: SharedPreferences.Editor? = null

    init {
        sp = context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE)
        editor = sp?.edit()
    }

    companion object {
        @Volatile
        var instance: SPUtil? = null
        fun getInstance(context: Context): SPUtil{
            if (instance == null){
                synchronized(SPUtil::class.java){
                    if (instance == null){
                        instance = SPUtil(context)
                    }
                }
            }
            return instance!!
        }
    }


    fun putInt(key: String,value: Int){
        sp!!.edit().putInt(key,value).apply()
    }

    fun getInt(key: String): Int? {
        return sp?.getInt(key,-1)
    }


}