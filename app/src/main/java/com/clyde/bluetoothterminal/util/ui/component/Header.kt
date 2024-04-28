package com.clyde.bluetoothterminal.util.ui.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.clyde.bluetoothterminal.ui.theme.AppTheme

@Composable
fun Header(text: String, modifier: Modifier = Modifier) {
    Text(text = text, modifier = modifier, style = MaterialTheme.typography.headlineMedium, color = MaterialTheme.colorScheme.onBackground)
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun ShowHeader() {
    AppTheme {
        Header(text = "Hello world")
    }
}
