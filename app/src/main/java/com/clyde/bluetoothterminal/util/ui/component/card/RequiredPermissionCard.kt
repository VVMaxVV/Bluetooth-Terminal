@file:OptIn(ExperimentalPermissionsApi::class)

package com.clyde.bluetoothterminal.util.ui.component.card

import android.content.Intent
import android.net.Uri
import android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.clyde.bluetoothterminal.R
import com.clyde.bluetoothterminal.ui.theme.AppTheme
import com.clyde.bluetoothterminal.util.extencion.customColorsScheme
import com.clyde.bluetoothterminal.util.ui.component.ButtonLabel
import com.clyde.bluetoothterminal.util.ui.rememberMultiplePermissionsStateSave
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RequiredPermissionCard(
    name: String,
    permissionsState: MultiplePermissionsState,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    Card(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(
                    vertical = dimensionResource(R.dimen.padding_1),
                    horizontal = dimensionResource(R.dimen.padding_3)
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                modifier = Modifier
                    .weight(2f)
                    .padding(end = 20.dp)
                    .basicMarquee()
            )
            if (permissionsState.allPermissionsGranted) {
                Icon(
                    painter = painterResource(R.drawable.ic_done_24),
                    contentDescription = "Permission granted",
                    tint = MaterialTheme.customColorsScheme.success
                )
            } else {
                Button(
                    onClick = {
                        when (permissionsState.shouldShowRationale) {
                            true -> permissionsState.launchMultiplePermissionRequest()
                            else -> {
                                val intent =
                                    Intent(ACTION_APPLICATION_DETAILS_SETTINGS)
                                val uri = Uri.fromParts("package", context.packageName, null)
                                intent.setData(uri)
                                startActivity(context, intent, null)
                            }
                        }
                        permissionsState.launchMultiplePermissionRequest()
                    },
                    Modifier.weight(1f)
                ) {
                    ButtonLabel(
                        text = stringResource(R.string.grunt_lb),
                        maxLines = 1
                    )
                }
            }
        }
    }
}

@Preview(showBackground = false, backgroundColor = 0xFFFFFFFF)
@Composable
private fun ShowRequiredPermissionCard() {
    AppTheme {
        RequiredPermissionCard(
            name = "Bluetooth",
            permissionsState = rememberMultiplePermissionsStateSave(listOf())
        )
    }
}
