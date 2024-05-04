package com.clyde.bluetoothterminal.ui.screen

import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.clyde.bluetoothterminal.R
import com.clyde.bluetoothterminal.ui.card.DeviceCard
import com.clyde.bluetoothterminal.ui.theme.AppTheme
import com.clyde.bluetoothterminal.util.defaultValue.DefaultModifiers
import com.clyde.bluetoothterminal.util.extencion.showToast
import com.clyde.bluetoothterminal.util.extencion.toSimpleDevice
import com.clyde.bluetoothterminal.util.permission.state.bluetoothPermissionState
import com.clyde.bluetoothterminal.util.permission.state.handle
import com.clyde.bluetoothterminal.util.ui.component.Header
import com.clyde.bluetoothterminal.util.ui.context
import com.clyde.bluetoothterminal.util.ui.dimension
import com.google.accompanist.permissions.ExperimentalPermissionsApi

@SuppressLint("MissingPermission")
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun SelectDeviceScreen() {
    val context = context
    bluetoothPermissionState.handle {
        Column(modifier = DefaultModifiers.screen) {
            Header(
                text = stringResource(R.string.select_device_lb),
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 40.dp)
            )
            val devices: List<BluetoothDevice> = try {
                val bluetoothManager =
                    context.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
                val bluetoothAdapter = bluetoothManager.adapter
                bluetoothAdapter.bondedDevices.toList()
            } catch (e: AssertionError) {
                Log.d("SelectDeviceScreen", "Error: ${e.message}", e)
                emptyList()
            }
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(horizontal = dimension(R.dimen.padding_2)),
                verticalArrangement = Arrangement.spacedBy(dimension(R.dimen.padding_2))
            ) {
                items(devices) {
                    DeviceCard(device = it.toSimpleDevice(), modifier = Modifier.fillMaxWidth()) {
                        context.showToast("Connect to : ${it.name}")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun ShowSelectDeviceScreen() {
    AppTheme {
        SelectDeviceScreen()
    }
}
