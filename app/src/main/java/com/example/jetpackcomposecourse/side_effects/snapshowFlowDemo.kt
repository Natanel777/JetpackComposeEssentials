package com.plcoding.jetpackcomposemasterclass.side_effects

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn

class MyViewModel: ViewModel() {

    var state by mutableIntStateOf(0)
        private set

    private val myStateAsFlow = snapshotFlow {
        state
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        0
    )

//    private val _state = MutableStateFlow(0)
//    val state = _state.asStateFlow()
}

@Composable
fun MyComposable(modifier: Modifier = Modifier) {
//    val viewModel = viewModel<MyViewModel>()
//    val state by viewModel.state.collectAsStateWithLifecycle()
}