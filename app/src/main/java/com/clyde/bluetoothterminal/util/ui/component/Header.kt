package com.clyde.bluetoothterminal.util.ui.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Header(text: String, modifier: Modifier = Modifier) {
    Text(text = text, modifier = modifier, style = MaterialTheme.typography.headlineMedium)
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun ShowHeader() {
    Header(text = "Hello world")
}
