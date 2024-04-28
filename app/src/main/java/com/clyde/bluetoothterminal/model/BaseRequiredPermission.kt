package com.clyde.bluetoothterminal.model

import androidx.compose.runtime.Composable
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState

abstract class BaseRequiredPermission(
    val name: String
) {
    @OptIn(ExperimentalPermissionsApi::class)
    @get:Composable
    abstract val permissionState: MultiplePermissionsState
}
