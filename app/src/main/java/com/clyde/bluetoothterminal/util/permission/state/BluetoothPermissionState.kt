package com.clyde.bluetoothterminal.util.permission.state

import android.Manifest
import android.os.Build
import androidx.compose.runtime.Composable
import com.clyde.bluetoothterminal.util.navigation.Route
import com.clyde.bluetoothterminal.util.permission.rememberMultiplePermissionsStateSave
import com.clyde.bluetoothterminal.util.ui.provider.LocalNavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState

@OptIn(ExperimentalPermissionsApi::class)
val bluetoothPermissionState: MultiplePermissionsState
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

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MultiplePermissionsState.handle(
    onDenied: @Composable (shouldShowRationale: Boolean) -> Unit = {
        LocalNavController.current.navigate(Route.RequestPermissions.route)
    },
    onSuccess: @Composable () -> Unit = { }
) {
    if (allPermissionsGranted) onSuccess()
    else onDenied(shouldShowRationale)
}
