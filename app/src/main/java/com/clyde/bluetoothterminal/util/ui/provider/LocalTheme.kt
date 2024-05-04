package com.clyde.bluetoothterminal.util.ui.provider

import androidx.compose.runtime.compositionLocalOf

val LocalTheme = compositionLocalOf { AppTheme() }

data class AppTheme(val darkColors: Boolean = true, val dynamicColors: Boolean = false)
