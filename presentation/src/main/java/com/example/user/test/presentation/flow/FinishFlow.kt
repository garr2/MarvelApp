package com.example.user.test.presentation.flow

import ru.terrakok.cicerone.commands.Command

data class FinishFlow(
    val transitionData: Any?
) : Command