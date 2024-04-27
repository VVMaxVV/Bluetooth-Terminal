package com.clyde.bluetoothterminal.util.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.clyde.bluetoothterminal.R
import com.clyde.bluetoothterminal.ui.theme.BluetoothTerminalTheme
import com.clyde.bluetoothterminal.util.premission.PermissionStatus

@Composable
fun RequiredPermissionCard(
    name: String,
    status: PermissionStatus,
    onRequestPermission: () -> Unit = { }
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(MaterialTheme.colorScheme.surface)
            .padding(
                vertical = dimensionResource(R.dimen.padding_1),
                horizontal = dimensionResource(R.dimen.padding_3)
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(SpanStyle()) {
                    append("$name: ")
                }
                withStyle(SpanStyle(status.color)) {
                    append(status.message)
                }
            }
        )
        if (status is PermissionStatus.Denied) {
            Button(
                onClick = {
                    onRequestPermission()
                }
            ) {
                ButtonText(
                    text = "Request",
                    maxLines = 1
                )
            }
        }
    }
}

@Preview(showBackground = false, backgroundColor = 0xFFFFFFFF)
@Composable
private fun ShowRequiredPermissionCard() {
    BluetoothTerminalTheme {
        RequiredPermissionCard(name = "Bluetooth", status = PermissionStatus.Denied)
    }
}
