package com.example.user.test.presentation.screen.main.mainFragment.characters

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.domain.entity.Characters
import com.example.domain.entity.RequestData
import com.example.domain.useCase.CharacterListUseCase
import com.example.user.test.R
import com.example.user.test.presentation.app.MarvelApplication
import com.example.user.test.presentation.base.BaseFragment
import com.example.user.test.presentation.screen.main.mainFragment.characters.adapter.CharactersAdapter
import kotlinx.android.synthetic.main.characters_fragment.*
import ru.terrakok.cicerone.Router
import java.net.SocketTimeoutException
import javax.inject.Inject

class CharacterFragment : BaseFragment(), CharacterView {

    override val layoutId: Int = R.layout.characters_fragment

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var requestData: RequestData

    @Inject
    lateinit var characterListUseCase: CharacterListUseCase

    @InjectPresenter
    lateinit var presenter: CharacterPresenter

    @ProvidePresenter
    fun providePresenter(): CharacterPresenter {
        return CharacterPresenter(router, requestData, characterListUseCase)
    }

    private val adapter =
        CharactersAdapter {
            //FIXME do some work
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        MarvelApplication.appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvList.layoutManager =
                LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        rvList.adapter = adapter

        btnTryAgain.setOnClickListener {
            presenter.tryAgain()
        }
    }

    override fun setList(list: List<Characters>) {
        adapter.list = list
        adapter.notifyDataSetChanged()
    }

    override fun setTryAgainButtonVisibility(visibility: Int) {
        btnTryAgain.visibility = visibility
    }

    override fun showErrorMessage(t: Throwable) {
        Toast.makeText(activity, "Error: ${getMessage(t)}", Toast.LENGTH_SHORT).show()
    }

    private fun getMessage(t: Throwable): String{
       return when (t){
            is SocketTimeoutException -> "Server not available. Try again"
           else -> {
               "Unknown error."
           }
       }
    }
}