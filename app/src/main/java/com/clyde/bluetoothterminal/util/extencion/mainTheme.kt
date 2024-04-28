package com.clyde.bluetoothterminal.util.extencion

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import com.clyde.bluetoothterminal.util.ui.provider.CustomColorShame
import com.clyde.bluetoothterminal.util.ui.shame.ExtendedColorScheme

val MaterialTheme.customColorsScheme: ExtendedColorScheme
    @Composable
    @ReadOnlyComposable
    get() = CustomColorShame.current
