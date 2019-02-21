package com.vinzaceto.mvptest.weather

import com.vinzaceto.mvptest.weather.WeatherMVP

class WeatherInteractor : WeatherMVP.Model {

    override fun getWeatherData(listener : WeatherMVP.Model.OnGetWeatherDataFinishedListener) {
        listener.onFinished("OK")
    }

}