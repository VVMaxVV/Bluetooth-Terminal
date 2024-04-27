//package com.clyde.bluetoothterminal.util.bluetooth
//
//import android.Manifest
//import android.annotation.SuppressLint
//import android.app.Activity
//import android.bluetooth.BluetoothAdapter
//import android.bluetooth.BluetoothManager
//import android.content.Context
//import android.content.Intent
//import android.content.pm.PackageManager
//import android.os.Build
//import androidx.activity.ComponentActivity
//import androidx.core.app.ActivityCompat
//import com.clyde.bluetoothterminal.MainActivity
//import com.clyde.bluetoothterminal.util.permission.RequestMultiplePermissions
//
//class BluetoothHelper {
//    private var bluetoothManager: BluetoothManager? = null
////    private val requestMultiplePermissions = RequestMultiplePermissions(this)
//
//    fun requestEnableBluetooth(activity: Activity) {
//        val enableBluetoothIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
//
//        ActivityCompat.startActivityForResult(
//            activity,
//            enableBluetoothIntent,
//            REQUEST_ENABLE_BLUETOOTH,
//            null
//        )
//    }
//
//    fun checkBluetoothPermission(activity: ComponentActivity): BluetoothStatus {
//        bluetoothManager?.let {
//            bluetoothManager =
//                activity.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
//        }
//        RequestMultiplePermissions(activity)
//
//        return when (true) {
//            bluetoothManager?.adapter?.isEnabled -> {
//                BluetoothStatus.BLUETOOTH_DISABLED
//            }
//
//            (activity.baseContext
//                .checkCallingOrSelfPermission(Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) -> {
//                BluetoothStatus.PERMISSION_DENIED
//            }
//
//            else -> {
//                BluetoothStatus.SUCCESS
//            }
//        }
//    }
//
//    @SuppressLint("MissingPermission")
//    fun requestBluetoothPermission(activity: Activity) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
//            activity.requestPermissions(
//                arrayOf(
//                    Manifest.permission.BLUETOOTH_SCAN,
//                    Manifest.permission.BLUETOOTH_CONNECT
//                ), REQUEST_BLUETOOTH_PERMISSION
//            )
//        } else {
//            val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
//            activity.startActivity(enableBtIntent)
//        }
//    }
//
//
//    enum class BluetoothStatus {
//        BLUETOOTH_DISABLED, PERMISSION_DENIED, SUCCESS;
//    }
//
//    companion object {
//        private const val REQUEST_ENABLE_BLUETOOTH = 1
//        private const val REQUEST_BLUETOOTH_PERMISSION = 1
//    }
//}