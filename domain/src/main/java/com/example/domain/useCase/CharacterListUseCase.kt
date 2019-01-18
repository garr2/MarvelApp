package com.example.domain.useCase

import com.example.domain.entity.Characters
import com.example.domain.entity.RequestData
import com.example.domain.executor.PostExecutorThread
import com.example.domain.repository.MarvelRepository
import io.reactivex.Observable
import javax.inject.Inject

class CharacterListUseCase @Inject constructor(
    postExecutorThread: PostExecutorThread,
    private val marvelRepository: MarvelRepository
) : BaseUseCase(postExecutorThread) {

    fun getList(requestData: RequestData): Observable<List<Characters>> {
        return marvelRepository.getList(requestData)
            .observeOn(postExecutorThread)
            .subscribeOn(workExecutorThread)
    }
}