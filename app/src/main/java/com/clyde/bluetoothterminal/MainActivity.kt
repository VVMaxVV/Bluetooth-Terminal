package com.clyde.bluetoothterminal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.clyde.bluetoothterminal.ui.screen.RequestPermissionsScreen
import com.clyde.bluetoothterminal.ui.screen.SelectDeviceScreen
import com.clyde.bluetoothterminal.ui.theme.AppTheme
import com.clyde.bluetoothterminal.util.navigation.Route
import com.clyde.bluetoothterminal.util.ui.provider.LocalNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme(darkTheme = true, dynamicColor = false) {
                AppScreen()
            }
        }
    }
}

@Composable
fun AppScreen() {
    NavHost(
        navController = LocalNavController.current,
        startDestination = Route.SelectDevice.route
    ) {
        composable(Route.SelectDevice.route) {
            SelectDeviceScreen()
        }
        composable(Route.RequestPermissions.route) {
            RequestPermissionsScreen()
        }
    }
}
