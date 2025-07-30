package com.example.jetpackcomposecourse.state_management.assignment_1

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TodoListViewmodel: ViewModel() {
    private val _todoStateState = MutableStateFlow(TodoState())
    val todoState = _todoStateState.asStateFlow()

    fun onCheckedChange(){
        _todoStateState.update { it.copy(
            isChecked = !it.isChecked
        ) }
    }
}