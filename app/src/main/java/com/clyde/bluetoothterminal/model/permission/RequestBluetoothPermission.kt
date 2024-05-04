package com.clyde.bluetoothterminal.model.permission

import androidx.compose.runtime.Composable
import com.clyde.bluetoothterminal.util.permission.state.bluetoothPermissionState
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState

@OptIn(ExperimentalPermissionsApi::class)
class RequestBluetoothPermission(
    name: String
) : BaseRequiredPermission(name) {
    override val permissionState: MultiplePermissionsState
        @Composable
        get() = bluetoothPermissionState
}
