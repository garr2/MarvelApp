package com.example.user.test.presentation.screen.main.pageFragment

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.user.test.presentation.screen.main.pageFragment.characters.CharacterFragment
import com.example.user.test.presentation.screen.main.pageFragment.favorite.FavoriteFragment
import com.example.user.test.presentation.screen.main.pageFragment.profile.ProfileFragment

class FragmentPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {

    companion object {
        private const val PAGE_COUNT = 3
        private val TAB_TITLES = listOf("Characters", "Favorite", "Profile")
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                CharacterFragment()
            }
            1 -> {
                FavoriteFragment()
            }
            2 -> {
                ProfileFragment()
            }
            else -> {
                throw Exception("Invalid position")
            }
        }
    }

    override fun getCount(): Int {
        return PAGE_COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return TAB_TITLES[position]
    }
}