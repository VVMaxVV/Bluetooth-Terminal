package com.clyde.bluetoothterminal.util

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun showToast(text: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(LocalContext.current, text, duration).show()
}
