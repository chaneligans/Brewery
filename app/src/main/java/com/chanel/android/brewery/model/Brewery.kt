package com.chanel.android.brewery.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Brewery(
    val id: String,
    val name: String,
    val brewery_type: String,
    val street: String?,
    val address_2: String?,
    val address_3: String?,
    val city: String,
    val state: String?,
    val postal_code: String,
    val country: String,
    val county_province: String?,
    val latitude: String?,
    val longitude: String?,
    val phone: String?,
    val website_url: String?,
    val created_at: String,
    val updated_at: String,
)