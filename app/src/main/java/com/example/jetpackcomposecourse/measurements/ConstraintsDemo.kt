package com.example.jetpackcomposecourse.measurements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecourse.ui.theme.JetpackComposeCourseTheme

// range between X width to Y width
private val boundedConstraints = Constraints(
    minWidth = 2000,
    maxWidth = 2500,
    minHeight = 0,
    maxHeight = 3000
)

// the range is from 0 to infinity
private val unboundedConstraints = Constraints()

// the range is accurate, fixed width
private val exactConstraints = Constraints(
    minWidth = 50,
    maxWidth = 50,
    minHeight = 100,
    maxHeight = 100
)

// combination between all the constrains above
private val combinedConstraints = Constraints(
    minWidth = 50,
    maxWidth = 50,
    minHeight = 50,
    maxHeight = Constraints.Infinity
)

@Composable
fun MeasurementsDemo(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .background(Color.Red)
            .padding(16.dp)
    ) {
        Text(
            text = "This is a text",
            modifier = Modifier
                .background(Color.Yellow)
        )
        Text(
            text = "This is another text",
            modifier = Modifier
                .background(Color.Green)
        )
    }
}

@Composable
fun MeasurementsDemoBox(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
            .background(Color.Red)

    ) {
        Box(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth(0.5f)
                .background(Color.Yellow)
        )
        Box(
            modifier = Modifier
                .height(100.dp)
                .width(900.dp)
                .background(Color.Green),
            contentAlignment = Alignment.Center
        ){
            Text(text = "Hello")
        }
    }
}

@Preview(apiLevel = 34)
@Composable
private fun MeasurementsDemoPreview() {
    JetpackComposeCourseTheme {
        MeasurementsDemoBox()
    }
}