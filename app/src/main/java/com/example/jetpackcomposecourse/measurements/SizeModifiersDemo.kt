package com.plcoding.jetpackcomposemasterclass.measurements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecourse.ui.theme.JetpackComposeCourseTheme
import com.example.jetpackcomposecourse.measurements.utillity.printConstraints


@Composable
fun SizeModifiersDemo(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .height(100.dp)
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Box(
            modifier = Modifier
                .height(100.dp)
                .printConstraints("Before 1. fillMaxWidth")
                .requiredWidth(300.dp)
                .background(Color.Green)
                .wrapContentWidth(
                    align = Alignment.CenterHorizontally
                )
                .printConstraints("After 1. fillMaxWidth")
                .background(Color.Yellow),
        ) {
            Text("Hello")
        }
    }
}

@Preview
@Composable
private fun SizeModifiersDemoPreview() {
    JetpackComposeCourseTheme {
        SizeModifiersDemo()
    }
}