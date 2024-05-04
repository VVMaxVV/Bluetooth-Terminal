package com.clyde.bluetoothterminal.util.extencion

import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice
import com.clyde.bluetoothterminal.model.device.SimpleDevice

@SuppressLint("MissingPermission")
fun BluetoothDevice.toSimpleDevice() = SimpleDevice(name)
