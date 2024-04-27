package com.clyde.bluetoothterminal.util.navigation

import com.clyde.bluetoothterminal.util.navigation.RouteConst.REQUEST_PERMISSIONS_SCREEN
import com.clyde.bluetoothterminal.util.navigation.RouteConst.SELECT_DEVICE_SCREEN

sealed class Route(val route: String) {
    data object RequestPermissions: Route(REQUEST_PERMISSIONS_SCREEN)
    data object SelectDevice: Route(SELECT_DEVICE_SCREEN)
}
