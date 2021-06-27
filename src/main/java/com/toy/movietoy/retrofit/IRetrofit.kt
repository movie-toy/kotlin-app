package com.toy.movietoy.retrofit

import com.google.gson.JsonElement
import com.toy.movietoy.utils.API
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IRetrofit {

    @GET(API.SEARCH_PHOTOS)
    fun searchPhoto(@Query("query") searchTerm: String) : Call<JsonElement>

    @GET(API.SEARCH_USERS)
    fun searchUser(@Query("query") searchTerm: String) : Call<JsonElement>
}