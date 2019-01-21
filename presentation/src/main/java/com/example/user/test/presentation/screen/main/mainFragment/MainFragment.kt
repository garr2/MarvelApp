package com.example.user.test.presentation.screen.main.mainFragment

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.user.test.R
import com.example.user.test.presentation.app.MarvelApplication
import com.example.user.test.presentation.base.BaseFragment
import com.example.user.test.presentation.screen.main.mainFragment.characters.CharacterFragment
import com.example.user.test.presentation.screen.main.mainFragment.favorite.FavoriteFragment
import com.example.user.test.presentation.screen.main.mainFragment.profile.ProfileFragment
import kotlinx.android.synthetic.main.page_fragment.*
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MainFragment : BaseFragment(), MainFragmentView {


    override val layoutId: Int = R.layout.page_fragment

    private val charactersFragment = CharacterFragment()
    private val favoriteFragment = FavoriteFragment()
    private val profileFragment = ProfileFragment()

    @Inject
    lateinit var router: Router

    @InjectPresenter
    lateinit var presenter: MainFragmentPresenter

    @ProvidePresenter
    fun providePresenter(): MainFragmentPresenter {
        return MainFragmentPresenter(router)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        MarvelApplication.appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bnvTabs.setOnNavigationItemSelectedListener(tabItemListener)
        if (savedInstanceState == null) replaceFragment(charactersFragment)
    }

    private val tabItemListener = BottomNavigationView.OnNavigationItemSelectedListener {
        it.isChecked = true
        when (it.itemId) {
            R.id.action_characters -> replaceFragment(charactersFragment)
            R.id.action_favorites -> replaceFragment(favoriteFragment)
            R.id.action_profile -> replaceFragment(profileFragment)
        }
        return@OnNavigationItemSelectedListener false
    }

    private fun replaceFragment(fragment: BaseFragment, addToBackStack: Boolean = false) {

        val fragmentTransition = childFragmentManager.beginTransaction()

        fragmentTransition.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_in_right)

        fragmentTransition.replace(
            R.id.flMainFragmentContainer, fragment,
            fragment::class.java.canonicalName
        )

        if (addToBackStack) {
            fragmentTransition.addToBackStack(null)
        }

        fragmentTransition.commit()
    }
}