package com.clyde.bluetoothterminal.util.ui

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

val context: Context
    @Composable
    get() = LocalContext.current
