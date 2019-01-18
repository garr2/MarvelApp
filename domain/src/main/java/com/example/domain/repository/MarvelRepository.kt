package com.example.domain.repository

import com.example.domain.entity.Characters
import com.example.domain.entity.RequestData
import io.reactivex.Observable

interface MarvelRepository {

    fun getList(requestData: RequestData): Observable<List<Characters>>
}