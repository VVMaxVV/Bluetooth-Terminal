package com.clyde.bluetoothterminal.util.ui.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign

@Composable
fun ButtonText(
    text: String,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = TextStyle.Default
) {
    Text(
        text = text,
        modifier = modifier,
        color = MaterialTheme.colorScheme.onPrimary,
        maxLines = maxLines,
        style = style,
        textAlign = TextAlign.Center
    )
}
