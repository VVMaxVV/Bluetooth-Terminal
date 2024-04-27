package com.clyde.bluetoothterminal.util.defaultValue

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

object DefaultModifiers {
    val screen: Modifier
        @Composable
        get() = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
}
