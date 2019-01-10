package com.example.user.test.presentation.base

import com.example.user.test.presentation.flow.StartFlow
import ru.terrakok.cicerone.Router

open class FlowRouter : Router() {

    fun startFlow(flowKey: String, data: Any? = null) {
        executeCommands(StartFlow(flowKey, data))
    }
}