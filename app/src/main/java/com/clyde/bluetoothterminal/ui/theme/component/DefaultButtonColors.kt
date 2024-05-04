package com.clyde.bluetoothterminal.ui.theme.component

import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

val DefaultButtonColorsDark: ButtonColors
    @Composable
    get() = ButtonDefaults.buttonColors().copy(
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onPrimary
    )
val DefaultButtonColorsLight: ButtonColors
    @Composable
    get() = ButtonDefaults.buttonColors().copy(
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
        contentColor = MaterialTheme.colorScheme.surfaceVariant
    )
