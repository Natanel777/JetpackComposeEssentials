package com.example.jetpackcomposecourse.measurements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecourse.ui.theme.JetpackComposeCourseTheme

@Composable
fun IntrinsicSizeDemo(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .width(IntrinsicSize.Min)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.Red)
        ) {
            Text("Hello world")
        }
    }
}

@Composable
fun IntrinsicSizeDemoCheckBox(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .width(IntrinsicSize.Max)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Option 1"
            )
            Checkbox(
                checked = true,
                onCheckedChange = {}
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Option 1, but in longer"
            )
            Checkbox(
                checked = false,
                onCheckedChange = {}
            )
        }
    }
}

@Preview(
    showBackground = true,
    apiLevel = 34
)
@Composable
private fun IntrinsicSizeDemoPreview() {
    JetpackComposeCourseTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            IntrinsicSizeDemoCheckBox()
        }
    }
}