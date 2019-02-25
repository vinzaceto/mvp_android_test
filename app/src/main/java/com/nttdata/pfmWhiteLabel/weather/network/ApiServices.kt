package com.vinzaceto.mvptest.weather.network

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * NTT Data Italia S.p.A.
 * File created on 21/02/2019.
 *
 * @author Vincenzo Aceto - vincenzo.aceto@nttdata.com
 * @version 1.0
 */
interface ApiServices {
    @GET("weather")
    fun getWeatherForCity(@Query("APPID") apiKey : String, @Query("q") city: String) : Observable<WeatherCity>
}