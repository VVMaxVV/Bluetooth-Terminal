package com.clyde.bluetoothterminal.util.permission

import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalInspectionMode
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.PermissionStatus
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.accompanist.permissions.shouldShowRationale

@ExperimentalPermissionsApi
@Composable
fun rememberMultiplePermissionsStateSave(
    permissions: List<String>,
    onPermissionResult: (Map<String, Boolean>) -> Unit = {}
) =
    when {
        LocalInspectionMode.current -> remember {
            object : MultiplePermissionsState {
                override val allPermissionsGranted: Boolean by derivedStateOf {
                    this.permissions.all { it.status.isGranted }
                    revokedPermissions.isEmpty()
                }

                override val permissions: List<PermissionState> =
                    permissions.map {
                        object : PermissionState {
                            override val permission = it
                            override val status = PermissionStatus.Granted
                            override fun launchPermissionRequest() = Unit
                        }
                    }

                override val revokedPermissions: List<PermissionState> by derivedStateOf {
                    this.permissions.filter { it.status != PermissionStatus.Granted }
                }

                override val shouldShowRationale: Boolean by derivedStateOf {
                    this.permissions.any { it.status.shouldShowRationale }
                }

                override fun launchMultiplePermissionRequest() {
                    this.permissions.map { it.permission }.toTypedArray()
                }


            }
        }

        else -> rememberMultiplePermissionsState(permissions, onPermissionResult)
    }