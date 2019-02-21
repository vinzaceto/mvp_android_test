package com.vinzaceto.mvptest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * NTT Data Italia S.p.A.
 * File created on 21/02/2019.
 *
 * @author Vincenzo Aceto - vincenzo.aceto@nttdata.com
 * @version 1.0
 */
class ApiClient {

    init {
        retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .build()
    }


    companion object {
        lateinit var retrofit: Retrofit
    }
}