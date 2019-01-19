package com.example.data.net

import com.example.data.entity.CharactersResponse
import com.example.data.net.base.RestService
import io.reactivex.Observable

class MarvelRestService(baseUrl: String) : RestService(baseUrl) {

    private lateinit var restApi: MarvelApi

    override fun buildApiClass() {
        restApi = retrofit.create(MarvelApi::class.java)
    }

    fun getCharectersList(timeStamp: String, apiKey: String, hash: String): Observable<CharactersResponse> {
        return restApi.getListCharacters(timeStamp, apiKey, hash)
    }
}