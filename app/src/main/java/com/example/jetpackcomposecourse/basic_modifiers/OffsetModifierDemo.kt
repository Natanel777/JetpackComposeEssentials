package com.example.jetpackcomposecourse.basic_modifiers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecourse.ui.theme.JetpackComposeCourseTheme

@Composable
fun OffsetModifierDemo(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .size(100.dp)
            .background(Color.Red)
    ) {
        Text(
            text = "Hello world",
            modifier = Modifier
                .offset(
                    x = 50.dp,
                    y = 20.dp
                )
                .background(Color.Green)
        )
        Text(
            text = "Hello world",
            modifier = Modifier
                .background(Color.Yellow)
        )
    }
}

@Preview(apiLevel = 34)
@Composable
private fun OffsetModifierDemoPreview() {
    JetpackComposeCourseTheme {
        OffsetModifierDemo()
    }
}