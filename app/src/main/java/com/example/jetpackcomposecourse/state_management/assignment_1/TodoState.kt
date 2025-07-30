package com.example.jetpackcomposecourse.state_management.assignment_1

data class TodoState(
    val title: String = "Bring out the trash",
    val description: String = "Better do this before wife comes home",
    val isChecked: Boolean = false
)