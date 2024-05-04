package com.clyde.bluetoothterminal.ui.screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.clyde.bluetoothterminal.R
import com.clyde.bluetoothterminal.model.permission.BaseRequiredPermission
import com.clyde.bluetoothterminal.model.permission.RequestBluetoothPermission
import com.clyde.bluetoothterminal.ui.card.RequiredPermissionCard
import com.clyde.bluetoothterminal.ui.theme.AppTheme
import com.clyde.bluetoothterminal.util.defaultValue.DefaultModifiers
import com.clyde.bluetoothterminal.util.extencion.mainButtonColors
import com.clyde.bluetoothterminal.util.extencion.showToast
import com.clyde.bluetoothterminal.util.ui.component.ButtonLabel
import com.clyde.bluetoothterminal.util.ui.component.Header
import com.clyde.bluetoothterminal.util.ui.context
import com.clyde.bluetoothterminal.util.ui.provider.LocalNavController
import com.clyde.bluetoothterminal.util.ui.string
import com.google.accompanist.permissions.ExperimentalPermissionsApi

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun RequestPermissionsScreen() {
    val context = context
    val navController = LocalNavController.current
    val requiredPermissionToastMessage = string(R.string.requre_premission_toast)
    BackHandler {
        context.showToast(requiredPermissionToastMessage)
    }
    Column(modifier = DefaultModifiers.screen, horizontalAlignment = Alignment.CenterHorizontally) {
        Header(
            text = stringResource(R.string.required_permissions_lb),
            modifier = Modifier.padding(vertical = dimensionResource(R.dimen.padding_4))
        )
        LazyColumn(
            userScrollEnabled = false,
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(horizontal = dimensionResource(R.dimen.padding_2)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_2))
        ) {
            items(listPermissions) { item ->
                RequiredPermissionCard(
                    name = item.name,
                    permissionsState = item.permissionState
                )
            }
        }
        Button(
            enabled = listPermissions.all { it.permissionState.allPermissionsGranted },
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier
                .padding(
                    horizontal = dimensionResource(R.dimen.padding_2),
                    vertical = dimensionResource(R.dimen.padding_3)
                )
                .align(Alignment.End),
            colors = MaterialTheme.mainButtonColors
        ) {
            ButtonLabel(
                text = stringResource(R.string.continue_lb),
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(
                    vertical = dimensionResource(R.dimen.padding_1)
                )
            )
        }
    }
}

private val listPermissions: List<BaseRequiredPermission> = listOf(
    RequestBluetoothPermission("Bluetooth")
)

@Preview
@Composable
private fun PreviewRequestPermissionsScreen() {
    AppTheme(darkTheme = true, dynamicColor = false) {
        RequestPermissionsScreen()
    }
}
