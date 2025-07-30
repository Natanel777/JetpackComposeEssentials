package com.example.jetpackcomposecourse.basicLayouts.finalUI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import com.example.jetpackcomposecourse.R

/*
    instead of use windowClassSize everywhere we can once use it like this:

    val fontSizeMultiplier = when(windowClass.windowWidthSizeClass) {
        WindowWidthSizeClass.COMPACT -> 1f
        WindowWidthSizeClass.MEDIUM -> 1.2f
        WindowWidthSizeClass.EXPANDED -> 1.5f
        else -> 1f
    }

     fontSize = 20.sp * fontSizeMultiplier

 */

private val tags = listOf(
    "City Center",
    "Luxury",
    "Instant Booking",
    "Exclusive Deal",
    "Early Bird Discount",
    "Romantic Gateway",
    "24/7 Support",
)

private val offers = mapOf(
    R.drawable.bed to "2 Bed",
    R.drawable.breakfast to "Breakfast",
    R.drawable.cutlery to "Cutlery",
    R.drawable.pawprint to "Pet Friendly",
    R.drawable.serving_dish to "Dinner",
    R.drawable.snowflake to "Air Conditioning",
    R.drawable.television to "TV",
    R.drawable.wi_fi_icon to "Wifi",
)

@Composable
fun HotelBookingScreen(modifier: Modifier = Modifier) {
    val windowClassSize = currentWindowAdaptiveInfo().windowSizeClass

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(White),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(max = 300.dp),
                    painter = painterResource(R.drawable.living_room),
                    contentDescription = "Living room",
                    contentScale = ContentScale.Crop
                )

                HotelFadedBanner(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(alignment = Alignment.BottomEnd),
                    windowClassSize = windowClassSize
                )
            }
        }

        item {
            HorizontalDivider(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 32.dp)
                    .background(color = Black)
            )
        }
        // Not Mine --------------------------------------------------------
        item {
            FlowRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
            ) {
                tags.forEach { tag ->
                    AssistChip(
                        onClick = {},
                        label = {
                            Text(text = tag)
                        }
                    )
                }
            }
        }
        item {
            HorizontalDivider(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            )
        }
        item {
            Text(
                text = """
                    The advertisement features a vibrant and inviting design, showcasing the Hotel California Strawberry nestled in the heart of Los Angeles. Surrounded by the iconic Hollywood Sign, Griffith Park, and stunning beaches, the hotel is perfectly located for guests to explore L.A.’s best attractions.
                """.trimIndent(),
                fontSize = 13.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                textAlign = TextAlign.Justify // justify to the end of the screen
            )
        }
        item {
            Text(
                text = "What we offer",
                fontSize = 18.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        }
        item {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
            ) {
                items(offers.entries.toList()) { (drawableResId, label) ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .background(Color.Gray.copy(alpha = 0.3f))
                            .padding(8.dp)
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(drawableResId),
                            contentDescription = label,
                            modifier = Modifier.size(36.dp)
                        )
                        Text(
                            text = label,
                            fontSize = 13.sp
                        )
                    }
                }
            }
        }
        item {
            Button(
                onClick = {},
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .widthIn(
                        max = 400.dp
                    )
                    .fillMaxWidth()
            ) {
                Text(text = "Book now!")
            }
        }
}
}

@Composable
fun HotelFadedBanner(
    modifier: Modifier = Modifier,
    windowClassSize: WindowSizeClass
) {
    Box(
        modifier = modifier
            .background(Color.LightGray.copy(alpha = 0.8f))
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .alignBy(LastBaseline)
                    .weight(1f)
            ) {
                Text(
                    text = "Hotel California Strawberry",
                    fontSize = when (windowClassSize.windowWidthSizeClass) {
                        WindowWidthSizeClass.COMPACT -> 20.sp
                        WindowWidthSizeClass.MEDIUM -> 24.sp
                        WindowWidthSizeClass.EXPANDED -> 34.sp
                        else -> 20.sp
                    },
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                LabeledIcon(
                    icon = Icons.Default.LocationOn,
                    iconTint = Color.DarkGray,
                    text = "Los Angeles, California",
                    windowClassSize = windowClassSize
                )

                LabeledIcon(
                    icon = Icons.Rounded.Star,
                    iconTint = Color.Yellow,
                    text = "4.9 (14K reviews)",
                    windowClassSize = windowClassSize
                )
            }

            Text(
                modifier = Modifier.alignBy(LastBaseline),
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = when (windowClassSize.windowWidthSizeClass) {
                                WindowWidthSizeClass.COMPACT -> 20.sp
                                WindowWidthSizeClass.MEDIUM -> 24.sp
                                WindowWidthSizeClass.EXPANDED -> 34.sp
                                else -> 20.sp
                            },
                        )
                    ) {
                        append("420$/")
                    }

                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.SemiBold,
                            fontSize = when (windowClassSize.windowWidthSizeClass) {
                                WindowWidthSizeClass.COMPACT -> 16.sp
                                WindowWidthSizeClass.MEDIUM -> 20.sp
                                WindowWidthSizeClass.EXPANDED -> 30.sp
                                else -> 20.sp
                            },
                        )
                    ) {
                        append("night")
                    }
                },
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Composable
fun LabeledIcon(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    iconTint: Color,
    text: String,
    windowClassSize: WindowSizeClass
) {
    Row(
        modifier = modifier.padding(top = 5.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = iconTint,
        )
        Text(
            modifier = Modifier.padding(start = 5.dp),
            text = text,
            fontSize = when (windowClassSize.windowWidthSizeClass) {
                WindowWidthSizeClass.COMPACT -> 15.sp
                WindowWidthSizeClass.MEDIUM -> 20.sp
                WindowWidthSizeClass.EXPANDED -> 25.sp
                else -> 20.sp
            },
        )
    }
}

@Preview(showSystemUi = true, apiLevel = 34)
@Composable
private fun HotelBookingScreenCOMPACTPreview() {
    HotelBookingScreen()
}

@Preview(showSystemUi = true, apiLevel = 34, device = Devices.FOLDABLE)
@Composable
private fun HotelBookingScreenMEDIUMPreview() {
    HotelBookingScreen()
}

@Preview(showSystemUi = true, apiLevel = 34, device = Devices.NEXUS_9)
@Composable
private fun HotelBookingScreenEXPENDEDPreview() {
    HotelBookingScreen()
}
