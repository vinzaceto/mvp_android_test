package com.vinzaceto.mvptest.weather

import com.vinzaceto.mvptest.BuildConfig
import com.vinzaceto.mvptest.weather.network.ApiClient
import com.vinzaceto.mvptest.weather.network.WeatherCity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class WeatherInteractor : WeatherMVP.Model {


    private var apiClient = ApiClient.create()

    override fun getWeatherData(listener : WeatherMVP.Model.OnGetWeatherDataFinishedListener) {

        apiClient.getWeatherForCity(BuildConfig.API_KEY, "London,uk").enqueue(object : Callback<WeatherCity> {
            override fun onFailure(call: Call<WeatherCity>, t: Throwable) {
                listener.onError(t)
            }

            override fun onResponse(call: Call<WeatherCity>, response: Response<WeatherCity>) {
                listener.onFinished(response.body().toString())
            }
        })
    }

}