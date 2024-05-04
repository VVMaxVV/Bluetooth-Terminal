package com.clyde.bluetoothterminal.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.clyde.bluetoothterminal.util.ui.shame.ExtendedColorScheme

val White = Color(0xFFFFFFFF)
val Black = Color(0xFF000000)
val Dark = Color(0xFF1F1F1F)

// Dark
val Purple80 = Color(0xFFD0BCFF)
val Purple20 = Color(0xB3B9AAE2)
val PurpleGrey80 = Color(0xFFDBD1EC)
val Pink80 = Color(0xFFEFB8C8)
val SuccessDark = Color(0xFF408140)
val SurfaceDark = Color(0xFFB38A96)
val OnSurfaceDark = Color(0xFF695A8D)
val OnPrimaryDark = Color(0xFF1A0F35)
val TextColorDark = Color(0xF28D80AC)

// Light
val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)
val SuccessLight = Color(0xff5cb85c)
val SurfaceLight = Color(0xFFD6DBD6)
//val TextColorLight = Color()

internal val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    onPrimary = OnPrimaryDark,
    secondary = PurpleGrey80,
    tertiary = Pink80,
    surface = Purple20,
    onSurface = OnSurfaceDark
)

internal val LightColorScheme = lightColorScheme(
    primary = Purple40,
//    onPrimary = ,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    surface = SurfaceLight
)

val extendedDark = ExtendedColorScheme(
    success = SuccessDark,
    onSuccess = White
)

val extendedLight = ExtendedColorScheme(
    success = SuccessLight,
    onSuccess = White
)
