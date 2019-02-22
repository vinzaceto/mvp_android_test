package com.vinzaceto.mvptest.weather

import android.util.Log
import com.vinzaceto.mvptest.BuildConfig
import com.vinzaceto.mvptest.weather.network.ApiClient
import com.vinzaceto.mvptest.weather.network.WeatherCity
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers


class WeatherInteractor : WeatherMVP.Model {


    private var apiClient = ApiClient.create()

    override fun getWeatherData(listener : WeatherMVP.Model.OnGetWeatherDataFinishedListener) {

        val weatherForCity: Observable<WeatherCity> = apiClient.getWeatherForCity(BuildConfig.API_KEY, "London,uk")

        val weatherForCity2: Observable<WeatherCity> = apiClient.getWeatherForCity(BuildConfig.API_KEY, "New York")

        /*
        weatherForCity2.mergeWith(weatherForCity).subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<WeatherCity>{
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: WeatherCity) {
                    listener.onFinished(t.name.toString())
                }

                override fun onError(e: Throwable) {
                    listener.onError(e)
                }

            });
            */


        weatherForCity.subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<WeatherCity>{
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: WeatherCity) {
                    listener.onFinished(t.name.toString())
                }

                override fun onError(e: Throwable) {
                    listener.onError(e)
                }

            });

//        apiClient.getWeatherForCity(BuildConfig.API_KEY, "London,uk").enqueue(object : Callback<WeatherCity> {
//            override fun onFailure(call: Call<WeatherCity>, t: Throwable) {
//                listener.onError(t)
//            }
//
//            override fun onResponse(call: Call<WeatherCity>, response: Response<WeatherCity>) {
//                listener.onFinished(response.body().toString())
//            }
//        })
    }

}