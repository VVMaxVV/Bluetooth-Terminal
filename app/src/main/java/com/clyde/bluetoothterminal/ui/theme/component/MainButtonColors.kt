package com.clyde.bluetoothterminal.ui.theme.component

import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

val MainButtonColorsDark: ButtonColors
    @Composable
    get() = ButtonColors(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        disabledContainerColor = MaterialTheme.colorScheme.onSurface.copy(alpha = .12f),
        disabledContentColor = MaterialTheme.colorScheme.onSurface.copy(alpha = .38f)
    )

val MainButtonColorsLight: ButtonColors
    @Composable
    get() = ButtonColors(
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
        contentColor = MaterialTheme.colorScheme.onSurfaceVariant,
        disabledContainerColor = MaterialTheme.colorScheme.onSurface.copy(alpha = .12f),
        disabledContentColor = MaterialTheme.colorScheme.onSurface.copy(alpha = .38f)
    )
