package com.clyde.bluetoothterminal.util.ui

import android.widget.Toast
import androidx.compose.runtime.Composable

@Composable
fun ShowToast(text: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, text, duration).show()
}
