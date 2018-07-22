package com.zhang.common.base

import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.Window
import com.zhang.common.baseapp.AppManager
import com.zhang.common.commonutils.TUtil

/**
 * Created by zhang .
 * DATA: 2018/7/22 .
 * Description :
 */
abstract class BaseActivity<T : BasePresenter<T, E>, E : BaseModel> : AppCompatActivity() {
    var mPresenter: T? = null
    var mModel: E? = null
    var mContext: Context? = null
    var isConfigChange: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        isConfigChange = false
        setContentView(getLayoutId())
        mContext = this
        mPresenter = TUtil.getT<T>(this, 0)
        mModel = TUtil.getT(this,1)
        mPresenter?.context = this
        this.initPresenter()
        this.initView()
    }

    /**
     * 设置layout前配置
     */
    fun doBeforeSetcontentView(){
        TODO("设置昼夜主题")
        // 把Activity放到application栈中管理
        AppManager.instance?.addActivity(this)
        // 无标题设置
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        // 设置横屏(or 竖屏)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        TODO("默认着色状态栏")
    }

    /**************** 子类实现 *****************/
    //获取布局文件
    abstract fun getLayoutId():Int
    //简单页面无需mvp就不用管此方法即可,完美兼容各种实际场景的变通
    abstract fun initPresenter()
    //初始化view
    abstract fun initView()


}