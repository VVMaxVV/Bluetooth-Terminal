package com.clyde.bluetoothterminal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.clyde.bluetoothterminal.ui.theme.BluetoothTerminalTheme
import com.clyde.bluetoothterminal.util.navigation.LocalNavController
import com.clyde.bluetoothterminal.util.navigation.Route

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BluetoothTerminalTheme {
                CompositionLocalProvider(
                    LocalNavController provides rememberNavController()
                ) {
                    AppScreen()
                }
            }
        }
    }
}

@Composable
fun AppScreen() {
    NavHost(
        navController = LocalNavController.current,
        startDestination = Route.RequestPermissions.route
    ) {
        composable(Route.RequestPermissions.route) {
            Text("Request permissions screen")
        }
    }
}
