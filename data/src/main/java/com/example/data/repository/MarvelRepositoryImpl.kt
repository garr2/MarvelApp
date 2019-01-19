package com.example.data.repository

import com.example.data.entity.transformToCharacter
import com.example.data.net.MarvelRestService
import com.example.domain.entity.Characters
import com.example.domain.entity.RequestData
import com.example.domain.repository.MarvelRepository
import io.reactivex.Observable

class MarvelRepositoryImpl(private val restService: MarvelRestService) : MarvelRepository {

    override fun getList(requestData: RequestData): Observable<List<Characters>> {
        return restService.getCharectersList(requestData.timeStamp, requestData.apiKey, requestData.hash)
            .flatMap {
                Observable.just(
                    it.data.results.map {
                        it.transformToCharacter()
                    })
            }
    }
}