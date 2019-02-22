package com.vinzaceto.mvptest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.vinzaceto.mvptest.weather.utils.LoaderView

abstract class BaseActivity : AppCompatActivity() {

    lateinit var loaderView : LoaderView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loaderView = LoaderView(this)
    }

    fun showLoader(){
        loaderView.showLoader()
        loaderView.visibility = View.VISIBLE
    }

    fun hideLoader(){
        loaderView.hideLoader()
        loaderView.visibility = View.GONE
    }

    abstract fun setLoaderView()

    abstract fun initView()

    abstract fun initConfig()
}
