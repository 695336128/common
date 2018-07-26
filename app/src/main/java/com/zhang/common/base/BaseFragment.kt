package com.zhang.common.base

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import butterknife.Unbinder
import com.zhang.common.commonutils.TUtil

/**
 * Created by zhang .
 * DATA: 2018/7/26 .
 * Description :
 */
abstract class BaseFragment<T: BasePresenter<*,*>,E: BaseModel> : Fragment() {
    var rootView: View? = null
    var mPresenter: T? = null
    var mModel: E? = null
    var unbinder: Unbinder? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (rootView == null){
            rootView = inflater?.inflate(getLayoutResource(),container,false)
        }
        unbinder = ButterKnife.bind(this, rootView!!)
        mPresenter = TUtil.getT(this,0)
        mModel = TUtil.getT(this,1)
        if (mPresenter != null){
            mPresenter!!.mContext = this.activity
        }
        initPresenter()
        initView()
        return rootView
    }

    // 获取布局文件
    protected abstract fun getLayoutResource(): Int
    // 初始化Presenter
    protected abstract fun initPresenter()
    // 初始化View
    protected abstract fun initView()

    /**
     * 通过Class跳转界面
     */
    fun startActivity(cls: Class<*>) {
        startActivity(cls, null)
    }

    /**
     * 通过Class跳转界面
     */
    fun startActivityForResult(cls: Class<*>, requestCode: Int) {
        startActivityForResult(cls, null, requestCode)
    }

    /**
     * 含有Bundle通过Class跳转界面
     */
    fun startActivityForResult(cls: Class<*>, bundle: Bundle?,
                               requestCode: Int) {
        val intent = Intent()
        intent.setClass(activity, cls)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivityForResult(intent, requestCode)
    }

    /**
     * 含有Bundle通过Class跳转界面
     */
    fun startActivity(cls: Class<*>, bundle: Bundle?) {
        val intent = Intent()
        intent.setClass(activity, cls)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivity(intent)
    }

    // TODO: 显示or隐藏加载进度条
    // TODO: 显示or隐藏Toast
    // TODO: 显示or隐藏网络信息

    override fun onDestroyView() {
        super.onDestroyView()
        unbinder?.unbind()
        if (mPresenter != null){
            mPresenter!!.onDestroy()
        }
    }

}