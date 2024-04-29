package com.clyde.bluetoothterminal.model

import android.Manifest
import android.os.Build
import androidx.compose.runtime.Composable
import com.clyde.bluetoothterminal.util.ui.rememberMultiplePermissionsStateSave
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState

@OptIn(ExperimentalPermissionsApi::class)
class RequestBluetoothPermission(
    name: String
) : BaseRequiredPermission(name) {
    override val permissionState: MultiplePermissionsState
        @Composable
        get() = rememberMultiplePermissionsStateSave(
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S)
                listOf(
                    Manifest.permission.BLUETOOTH_SCAN,
                    Manifest.permission.BLUETOOTH_CONNECT,
                    Manifest.permission.BLUETOOTH_ADVERTISE,
                )
            else listOf(
                Manifest.permission.BLUETOOTH,
                Manifest.permission.BLUETOOTH_ADMIN
            )
        )
}
