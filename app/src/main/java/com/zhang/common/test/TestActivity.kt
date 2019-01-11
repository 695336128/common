package com.zhang.common.test

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatDelegate
import android.widget.Toast
import com.zhang.common.R
import com.zhang.common.base.BaseActivity
import com.zhang.common.commonutils.L
import com.zhang.common.retrofit.RetrofitUtils
import kotlinx.android.synthetic.main.activity_test.*

/**
 * Created by zhang .
 * DATA: 2018/7/26 .
 * Description :
 */
class TestActivity : BaseActivity<TestPresenter, TestModel>(), TestContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        RetrofitUtils.BASE_URL = "http://www.wanandroid.com/"
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_test
    }

    override fun initPresenter() {
        mPresenter?.setVM(this, mModel!!)
    }

    override fun initView() {
        request_button.setOnClickListener { mPresenter?.loadDataRequest() }
        theme_button.setOnClickListener { initTheme(AppCompatDelegate.MODE_NIGHT_YES) }
        jump_button.setOnClickListener { startActivity(TestAvtivity2::class.java) }
    }

    @SuppressLint("SetTextI18n")
    override fun doWithData(data: TestBean) {
        result_tv.text = "name: ${data.name} \n url: ${data.url}"
        L.d("name: ${data.name} \n url: ${data.url}")
    }

    override fun doWithEvent(data: TestBean) {
        Toast.makeText(mContext, "GetEvevt", Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        startProgressDialog()
    }

    override fun stopLoading() {
        stopProgressDialog()
    }

    override fun showErrorTip(msg: String) {
        showToast(msg)
    }
}