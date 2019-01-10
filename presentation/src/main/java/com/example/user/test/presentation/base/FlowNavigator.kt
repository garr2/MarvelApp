package com.example.user.test.presentation.base

import android.app.Activity
import android.content.Intent
import android.support.v4.app.FragmentActivity
import android.widget.Toast
import com.example.user.test.presentation.flow.FinishFlow
import com.example.user.test.presentation.flow.StartFlow
import ru.terrakok.cicerone.android.SupportFragmentNavigator
import ru.terrakok.cicerone.commands.Command

abstract class FlowNavigator(val activity: FragmentActivity, containerId: Int) :
    SupportFragmentNavigator(activity.supportFragmentManager, containerId) {

    override fun applyCommand(command: Command?) {
        when (command) {
            is StartFlow -> startFlow(command.screenKey, command.transitionData)
            is FinishFlow -> finishFlow(command.transitionData)
            else -> super.applyCommand(command)
        }
    }

    override fun applyCommands(commands: Array<out Command>?) {
        if (commands != null) {
            for (command in commands) {
                when (command) {
                    is StartFlow -> startFlow(command.screenKey, command.transitionData)
                    is FinishFlow -> finishFlow(command.transitionData)

                }
            }
        }
    }

    protected open fun startFlow(flowKey: String, data: Any?) {
        createFlowIntent(flowKey, data)?.let { intent ->
            activity.startActivityForResult(intent, getRequestCodeForFlow(flowKey))
        }
    }

    protected open fun finishFlow(data: Any?) {
        activity.setResult(Activity.RESULT_OK, createFlowResult(data))
        activity.finish()
    }

    open fun getRequestCodeForFlow(flowKey: String): Int = -1

    open fun createFlowResult(data: Any?): Intent? = null


    override fun exit() {
        activity.setResult(Activity.RESULT_CANCELED)
        activity.finish()
    }

    override fun showSystemMessage(message: String?) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    open fun createFlowIntent(flowKey: String, data: Any?): Intent? {
        return null
    }
}