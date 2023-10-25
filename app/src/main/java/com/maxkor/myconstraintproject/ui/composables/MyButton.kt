package com.maxkor.myconstraintproject.ui.composables

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun MyButton(text: String, modifier: Modifier = Modifier) {
    Button(
        onClick = { }, modifier = modifier
    ) {
        Text(text, fontSize = 24.sp)
    }
}