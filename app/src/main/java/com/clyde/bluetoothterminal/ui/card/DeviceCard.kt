package com.clyde.bluetoothterminal.ui.card

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.clyde.bluetoothterminal.R
import com.clyde.bluetoothterminal.model.device.SimpleDevice
import com.clyde.bluetoothterminal.ui.theme.AppTheme
import com.clyde.bluetoothterminal.util.ui.dimension
import com.clyde.bluetoothterminal.util.ui.drawable

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DeviceCard(device: SimpleDevice, modifier: Modifier = Modifier, onClick: () -> Unit = { }) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(dimension(R.dimen.padding_3)),
        onClick = onClick,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(
                horizontal = dimension(R.dimen.padding_3),
                vertical = dimension(R.dimen.padding_4)
            ),
        ) {
            Icon(
                painter = drawable(R.drawable.ic_bluetooth_24),
                contentDescription = null,
                modifier = Modifier.size(dimension(R.dimen.padding_5))
            )
            Text(
                text = device.deviceName,
                modifier = Modifier
                    .padding(horizontal = dimension(R.dimen.padding_1))
                    .basicMarquee(),
                maxLines = TEXT_MAX_LINE,
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}

private const val TEXT_MAX_LINE = 1

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun ShowDeviceCard() {
    AppTheme {
        DeviceCard(
            SimpleDevice("Device 1"),
            Modifier
                .fillMaxWidth()
                .padding(dimension(R.dimen.padding_2))
        )
    }
}
