package com.example.jetpackcomposecourse.side_effects

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner

@Composable
fun DisposableEffectDemo(modifier: Modifier = Modifier) {
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(lifecycleOwner.lifecycle) {
        val observer = LifecycleEventObserver { _, event ->
            when(event) {
                Lifecycle.Event.ON_START -> { println("OnStart was called!") }
                Lifecycle.Event.ON_CREATE -> { println("OnCreate was called!") }
                else -> Unit
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            println("Observer was disposed!")
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
}