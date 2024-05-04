package com.clyde.bluetoothterminal.util.ui.component

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.clyde.bluetoothterminal.ui.theme.AppTheme

@Composable
fun ButtonLabel(
    text: String,
    modifier: Modifier = Modifier,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = TextStyle.Default
) {
    Text(
        text = text,
        modifier = modifier,
        maxLines = maxLines,
        style = style,
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun ShowButtonLabel() {
    AppTheme(darkTheme = true, dynamicColor = false) {
        Button(onClick = { }) {
            ButtonLabel("Hello world!")
        }
    }
}
