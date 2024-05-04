package com.clyde.bluetoothterminal.ui.theme.component

import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

val DefaultCardColorsDark: CardColors
    @Composable
    get() = CardDefaults.cardColors().copy(
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
        contentColor = MaterialTheme.colorScheme.onPrimaryContainer
    )

val DefaultCardColorsLight: CardColors
    @Composable
    get() = CardDefaults.cardColors().copy(
        containerColor = MaterialTheme.colorScheme.surfaceContainer,
        contentColor = MaterialTheme.colorScheme.onPrimaryContainer
    )
