package com.chanel.android.brewery.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://api.openbrewerydb.org/breweries/"
object RetrofitInstance {

    val breweryAPI: BreweryAPI by lazy {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
            .baseUrl(BASE_URL)
            .build()
            .create(BreweryAPI::class.java)
    }

}