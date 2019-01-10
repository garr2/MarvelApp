package com.example.user.test.presentation.flow

import ru.terrakok.cicerone.commands.Command

data class StartFlow(
    val screenKey: String,
    val transitionData: Any?
) : Command