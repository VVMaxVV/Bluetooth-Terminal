package com.clyde.bluetoothterminal.util.extencion

import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import com.clyde.bluetoothterminal.ui.theme.component.DefaultButtonColorsDark
import com.clyde.bluetoothterminal.ui.theme.component.DefaultButtonColorsLight
import com.clyde.bluetoothterminal.ui.theme.component.DefaultCardColorsDark
import com.clyde.bluetoothterminal.ui.theme.component.DefaultCardColorsLight
import com.clyde.bluetoothterminal.ui.theme.component.MainButtonColorsDark
import com.clyde.bluetoothterminal.ui.theme.component.MainButtonColorsLight
import com.clyde.bluetoothterminal.util.ui.provider.CustomColorShame
import com.clyde.bluetoothterminal.util.ui.provider.LocalTheme
import com.clyde.bluetoothterminal.util.ui.shame.ExtendedColorScheme

val MaterialTheme.customColorsScheme: ExtendedColorScheme
    @Composable
    @ReadOnlyComposable
    get() = CustomColorShame.current

val MaterialTheme.mainButtonColors: ButtonColors
    @Composable
    get() = if (LocalTheme.current.darkColors) MainButtonColorsDark else MainButtonColorsLight

val MaterialTheme.defaultButtonColors: ButtonColors
    @Composable
    get() = if (LocalTheme.current.darkColors) DefaultButtonColorsDark else DefaultButtonColorsLight

val MaterialTheme.defaultCardColors: CardColors
    @Composable
    get() = if (LocalTheme.current.darkColors) DefaultCardColorsDark else DefaultCardColorsLight
