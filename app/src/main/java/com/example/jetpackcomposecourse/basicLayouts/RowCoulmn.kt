package com.example.jetpackcomposecourse.basicLayouts

import com.example.jetpackcomposecourse.ui.theme.JetpackComposeCourseTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RowColumnDemo(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "Hello world!",
            fontSize = 40.sp,
            modifier = Modifier
                .width(150.dp)
                .alignBy(LastBaseline)
        )
        Text(
            text = "Hello world2!",
            fontSize = 20.sp,
            modifier = Modifier
                .alignByBaseline()
        )
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Red)
                .weight(1f)
        )
        Column(
            modifier = Modifier
                .weight(3f)
        ) {
            Box(
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .background(Color.Blue)
            )
            Box(
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .background(Color.Green)
            )
        }

    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFF,
    apiLevel = 34
)
@Composable
private fun RowColumnDemoPreview() {
    JetpackComposeCourseTheme {
        RowColumnDemo()
    }
}