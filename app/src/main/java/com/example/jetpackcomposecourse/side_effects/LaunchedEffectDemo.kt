package com.plcoding.jetpackcomposemasterclass.side_effects

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposecourse.ui.theme.JetpackComposeCourseTheme
import kotlinx.coroutines.launch

@Composable
fun LaunchedEffectDemo(modifier: Modifier = Modifier) {
    var counter by remember {
        mutableIntStateOf(0)
    }
    val snackbarHostState = remember {
        SnackbarHostState()
    }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->

    }
    LaunchedEffect(Unit) {
        launcher.launch(Manifest.permission.RECORD_AUDIO)
    }
    LaunchedEffect(counter) {
        if(counter % 2 == 0) {
            snackbarHostState.showSnackbar(
                "The count is even!"
            )
        }
    }
    val scope = rememberCoroutineScope()
    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        snackbarHost = {
            SnackbarHost(
                hostState = snackbarHostState
            )
        }
    ) { innerPadding ->
        Button(
            onClick = {
                counter++
                if(counter % 2 == 0) {
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            "The number is even!"
                        )
                    }
                }
            },
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .wrapContentSize()
        ) {
            Text("Counter: $counter")
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun LaunchedEffectDemoPreview() {
    JetpackComposeCourseTheme {
        LaunchedEffectDemo()
    }
}