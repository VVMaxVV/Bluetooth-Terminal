package com.clyde.bluetoothterminal.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.clyde.bluetoothterminal.util.ui.ExtendedColorScheme

val White = Color(0xFFFFFFFF)
val Black = Color(0xFF000000)

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val SuccessLight = Color(0xff5cb85c)

val SuccessDark = Color(0xFF408140)

internal val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80,
)

internal val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

val extendedDark = ExtendedColorScheme(
    success = SuccessDark,
    onSuccess = White
)

val extendedLight = ExtendedColorScheme(
    success = SuccessLight,
    onSuccess = White
)
