package com.clyde.bluetoothterminal.util.premission

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.clyde.bluetoothterminal.R
import com.clyde.bluetoothterminal.util.extencion.customColorsScheme

sealed class PermissionStatus {
    @get:Composable
    abstract val color: Color

    @get:Composable
    abstract val message: String

    data object Granted : PermissionStatus() {
        override val color: Color
            @Composable
            get() = MaterialTheme.customColorsScheme.success

        override val message: String
            @Composable
            get() = stringResource(R.string.status_granted_lb)
    }

    data object Denied : PermissionStatus() {
        override val color: Color
            @Composable
            get() = MaterialTheme.colorScheme.error

        override val message: String
            @Composable
            get() = stringResource(R.string.status_denied_lb)
    }

}
