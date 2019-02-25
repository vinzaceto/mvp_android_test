package com.nttdata.pfmWhiteLabel.weather

import android.os.Bundle
import com.nttdata.pfmWhiteLabel.BaseActivity
import com.nttdata.pfmWhiteLabel.R

import kotlinx.android.synthetic.main.activity_weather.*
import kotlinx.android.synthetic.main.content_weather.*

class WeatherActivity : BaseActivity(), WeatherMVP.View {


    private lateinit var presenter : WeatherMVP.ViewPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initConfig()
        initView()
    }

    override fun initView() {
        setContentView(R.layout.activity_weather)
        setSupportActionBar(toolbar)

        setLoaderView()

        fab.setOnClickListener {
            super.showLoader()
            presenter.requestDataFromServer()
        }

    }

    override fun initConfig() {
        presenter = WeatherPresenter(this)
    }

    override fun setLoaderView() {
        loaderView = loader
    }

    override fun setWeatherData(data: String) {
        textView2.text = data
    }

}
