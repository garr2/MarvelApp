package com.example.user.test.presentation.base

import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

abstract class BaseRouter<A : AppCompatActivity>(val activity: A) {

    fun goBack() {
        activity.onBackPressed()
    }

    fun showError(e: Exception){
        Toast.makeText(activity,"Error: $e", Toast.LENGTH_SHORT).show()
    }

    fun replaceFragment(fragmentManager: FragmentManager,
                        fragment: BaseFragment<*,*>,
                        containerResId: Int, addToBackStack: Boolean = false) {

        var fragmentTransition = fragmentManager.beginTransaction()

        fragmentTransition.replace(containerResId, fragment,
                fragment::class.java.canonicalName)

        if(addToBackStack) {
            fragmentTransition.addToBackStack(null)
        }

        fragmentTransition.commit()
    }
}