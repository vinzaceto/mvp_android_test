package com.vinzaceto.mvptest.weather

import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.view.View
import com.vinzaceto.mvptest.R

import kotlinx.android.synthetic.main.activity_weather.*

class WeatherActivity : AppCompatActivity(), WeatherMVP.View {

    private lateinit var presenter : WeatherMVP.ViewPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        setSupportActionBar(toolbar)

        presenter = WeatherPresenter(this)

        fab.setOnClickListener(View.OnClickListener { presenter.requestDataFromServer() })
    }

    override fun setWeatherData(data: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoader() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoader() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
