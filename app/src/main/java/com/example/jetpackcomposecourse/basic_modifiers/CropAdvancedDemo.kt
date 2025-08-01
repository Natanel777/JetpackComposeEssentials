package com.example.jetpackcomposecourse.basic_modifiers

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import com.example.jetpackcomposecourse.R
import com.example.jetpackcomposecourse.ui.theme.JetpackComposeCourseTheme


@Composable
fun ShapeModifiersDemo(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.android_peek),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .clip(TriangleShape)
    )
}

data object TriangleShape: Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            path = Path().apply {
                moveTo(
                    x = size.width / 2f,
                    y = 0f
                )
                lineTo(
                    x = 0f,
                    y = size.height
                )
                lineTo(
                    x = size.width,
                    y = size.height
                )
                close()
            }
        )
    }
}

@Preview(
    showBackground = true,
    apiLevel = 34
)
@Composable
private fun ShapeModifiersDemoPreview() {
    JetpackComposeCourseTheme {
        ShapeModifiersDemo()
    }
}