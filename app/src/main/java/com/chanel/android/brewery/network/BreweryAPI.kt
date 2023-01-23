package com.chanel.android.brewery.network

import com.chanel.android.brewery.model.Brewery
import io.reactivex.Single
import retrofit2.http.GET

interface BreweryAPI {

    @GET("breweries")
    fun getBreweries(): Single<List<Brewery>>

}