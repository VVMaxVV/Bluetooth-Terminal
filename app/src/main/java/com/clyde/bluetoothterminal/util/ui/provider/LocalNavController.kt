package com.clyde.bluetoothterminal.util.ui.provider

import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController

val LocalNavController = compositionLocalOf<NavHostController> {
    error("No LocalNavController provided")
}
