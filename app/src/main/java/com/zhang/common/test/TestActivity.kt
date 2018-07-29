package com.zhang.common.test

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import butterknife.BindView
import butterknife.OnClick
import com.zhang.common.R
import com.zhang.common.base.BaseActivity

/**
 * Created by zhang .
 * DATA: 2018/7/26 .
 * Description :
 */
class TestActivity: BaseActivity<TestPresenter, TestModel>(),TestContract.View{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @BindView(R.id.result_tv)
    lateinit var resultTv: TextView

    @BindView(R.id.request_button)
    lateinit var requestBtn: Button


    override fun getLayoutId(): Int {
        return R.layout.activity_test
    }

    override fun initPresenter() {
        mPresenter?.setVM(this,mModel!!)
    }

    override fun initView() {

    }


    @SuppressLint("SetTextI18n")
    override fun doWithData(data: TestBean) {
        resultTv.text = "name: ${data.name} \n url: ${data.url}"
    }

    @OnClick(R.id.request_button)
    fun onClick(view: View){
        when(view.id){
            R.id.request_button -> {mPresenter?.loadDataRequest()}
            else -> {}
        }
    }



    override fun showLoading(title: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun stopLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showErrorTip(msg: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}