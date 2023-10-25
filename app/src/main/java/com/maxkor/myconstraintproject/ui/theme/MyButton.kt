package com.maxkor.myconstraintproject.ui.theme

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MyButton(text: String, modifier: Modifier = Modifier) {
    Button(
        onClick = { }, modifier = modifier
    ) {
        Text(text)
    }
}