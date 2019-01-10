package com.example.user.test.presentation.flow

import ru.terrakok.cicerone.commands.Command

/**
 * Created by Konstantin Tskhovrebov (aka @terrakok) on 10.01.18.
 */
class StartFlow(
    val screenKey: String,
    val transitionData: Any?
) : Command