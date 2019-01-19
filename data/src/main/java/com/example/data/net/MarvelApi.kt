package com.example.data.net

import com.example.data.entity.CharactersResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApi {

    @GET("/v1/public/characters")
    fun getListCharacters(
        @Query("ts") timeStamp: String,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): Observable<CharactersResponse>
}