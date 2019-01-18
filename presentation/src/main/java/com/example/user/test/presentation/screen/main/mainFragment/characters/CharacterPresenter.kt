package com.example.user.test.presentation.screen.main.mainFragment.characters

import android.view.View
import com.arellomobile.mvp.InjectViewState
import com.example.domain.entity.RequestData
import com.example.domain.useCase.CharacterListUseCase
import com.example.user.test.presentation.base.BasePresenter
import com.example.user.test.presentation.inject.API_PUBLIC_KEY
import com.example.user.test.presentation.inject.GENERATED_HASH
import io.reactivex.rxkotlin.subscribeBy
import ru.terrakok.cicerone.Router
import javax.inject.Inject
import javax.inject.Named

@InjectViewState
class CharacterPresenter (
    val router: Router
    , val requestData: RequestData
    , val characterListUseCase: CharacterListUseCase
) : BasePresenter<CharacterView>() {

    companion object {
        const val API_PUBLIC_KEY = "4da5fb7588e305bad17943c6cb84f0ae"
        const val API_PRIVATE_KEY = "d0b688c49968cdbf07df63db58c15aeff68fb19b"
    }

    private val timeStamp = System.currentTimeMillis().toString()
    private val md5 = timeStamp + API_PRIVATE_KEY + API_PUBLIC_KEY

    init {
        getList()
    }

    fun tryAgain() {
        getList()
    }

    private fun getList() {
        val disposable = characterListUseCase.getList(requestData)
            .subscribeBy(
                onNext = {
                    viewState.setList(it)
                    viewState.setTryAgainButtonVisibility(View.GONE)
                },
                onError = {
                    viewState.showErrorMessage(it)
                    viewState.setTryAgainButtonVisibility(View.VISIBLE)
                }
            )

        addToDisposable(disposable)
    }
}