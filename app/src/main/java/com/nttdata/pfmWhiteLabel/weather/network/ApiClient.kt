package com.vinzaceto.mvptest.weather.network

import com.vinzaceto.mvptest.BuildConfig
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * NTT Data Italia S.p.A.
 * File created on 21/02/2019.
 *
 * @author Vincenzo Aceto - vincenzo.aceto@nttdata.com
 * @version 1.0
 */
class ApiClient {

    companion object {
        fun create(): ApiServices {

            val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

            return retrofit.create(ApiServices::class.java)
        }
    }
}