package com.clyde.bluetoothterminal.ui.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.clyde.bluetoothterminal.R
import com.clyde.bluetoothterminal.model.RequiredPermission
import com.clyde.bluetoothterminal.util.defaultValue.DefaultModifiers
import com.clyde.bluetoothterminal.util.premission.PermissionStatus
import com.clyde.bluetoothterminal.util.ui.component.ButtonText
import com.clyde.bluetoothterminal.util.ui.component.Header
import com.clyde.bluetoothterminal.util.ui.component.RequiredPermissionCard

@Composable
fun RequestPermissionsScreen() {
    val context = LocalContext.current
    Column(modifier = DefaultModifiers.screen, horizontalAlignment = Alignment.CenterHorizontally) {
        Header(
            text = stringResource(R.string.required_permissions_lb),
            modifier = Modifier.padding(vertical = dimensionResource(R.dimen.padding_4))
        )
        LazyColumn(userScrollEnabled = false, modifier = Modifier.weight(1f)) {
            items(listPermissions) { item ->
                RequiredPermissionCard(name = item.name, status = item.status.value) {
                    item.granted()
                }
            }
        }
        Button(
            enabled = listPermissions.all { it.status.value is PermissionStatus.Granted },
            onClick = {
                Toast.makeText(context, "Navigate to next screen", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier
                .padding(
                    horizontal = dimensionResource(R.dimen.padding_2),
                    vertical = dimensionResource(id = R.dimen.padding_3)
                )
                .fillMaxWidth()
        ) {
            ButtonText(
                text = "Continue",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(
                    vertical = dimensionResource(
                        id = R.dimen.padding_1
                    )
                )
            )
        }
    }
}

private val listPermissions = listOf(
    RequiredPermission("Bluetooth"),
    RequiredPermission("Bluetooth"),
    RequiredPermission("Bluetooth")
)

@Preview
@Composable
private fun PreviewRequestPermissionsScreen() {
    RequestPermissionsScreen()
}
