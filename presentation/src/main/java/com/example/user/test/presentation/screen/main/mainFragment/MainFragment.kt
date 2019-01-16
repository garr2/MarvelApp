package com.example.user.test.presentation.screen.main.mainFragment

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.user.test.R
import com.example.user.test.presentation.app.MarvelApplication
import com.example.user.test.presentation.base.BaseFragment
import com.example.user.test.presentation.holder.LocalCiceroneHolder
import com.example.user.test.presentation.screen.main.mainFragment.characters.CharacterFragment
import com.example.user.test.presentation.screen.main.mainFragment.favorite.FavoriteFragment
import com.example.user.test.presentation.screen.main.mainFragment.profile.ProfileFragment
import kotlinx.android.synthetic.main.page_fragment.*
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

class MainFragment : BaseFragment(), MainFragmentView {

    companion object {
        private const val CONTAINER_NAME = "MainFragment"
    }

    override val layoutId: Int = R.layout.page_fragment

    private var navigator: Navigator? = null

    private val charactersFragment = CharacterFragment()
    private val favoriteFragment = FavoriteFragment()
    private val profileFragment = ProfileFragment()

    @Inject
    lateinit var ciceroneHolder: LocalCiceroneHolder

    @Inject
    @InjectPresenter
    lateinit var presenter: MainFragmentPresenter

    @ProvidePresenter
    fun providePresenter(): MainFragmentPresenter {
        return MainFragmentPresenter(ciceroneHolder.getCicerone(CONTAINER_NAME).router)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        MarvelApplication.appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bnvTabs.setOnNavigationItemSelectedListener(tabItemListener)
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

    override fun onResume() {
        super.onResume()

        getCicerone().navigatorHolder.setNavigator(getNavigator())
    }

    override fun onPause() {
        getCicerone().navigatorHolder.removeNavigator()
        super.onPause()
    }

    private fun getNavigator(): Navigator {
        if (navigator == null) {
            navigator = SupportAppNavigator(activity, childFragmentManager, R.id.flMainFragmentContainer)
        }

        return navigator as Navigator
    }

    private fun getCicerone(): Cicerone<Router> {
        return ciceroneHolder.getCicerone(CONTAINER_NAME)
    }

    fun replaceFragment(fragment: BaseFragment, addToBackStack: Boolean = false) {

        var fragmentTransition = childFragmentManager.beginTransaction()

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