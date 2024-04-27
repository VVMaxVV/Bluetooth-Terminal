package com.clyde.bluetoothterminal.model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.clyde.bluetoothterminal.util.premission.PermissionStatus

class RequiredPermission(val name: String) {
    private val _status = mutableStateOf<PermissionStatus>(PermissionStatus.Denied)
    val status: State<PermissionStatus> get() = _status

    fun granted() {
        _status.value = PermissionStatus.Granted
    }
}
