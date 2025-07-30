package com.example.jetpackcomposecourse.state_management.assignment_1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun TodoListScreenRoot(modifier: Modifier = Modifier) {
    val viewmodel = viewModel<TodoListViewmodel>()
    val state by viewmodel.todoState.collectAsStateWithLifecycle()

    TodoListScreen(
        modifier = modifier,
        state = state,
        onCheckedChange = { viewmodel.onCheckedChange() }
    )
}

@Composable
fun TodoListScreen(
    modifier: Modifier = Modifier,
    state: TodoState,
    onCheckedChange: (Boolean) -> Unit
) {
    Box(
        modifier = modifier.background(Color.LightGray)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                Text(
                    text = state.title,
                    fontWeight = FontWeight.Bold,
                    textDecoration = if (state.isChecked) TextDecoration.LineThrough else TextDecoration.None
                )
                Text(
                    text = state.description,
                    textDecoration = if (state.isChecked) TextDecoration.LineThrough else TextDecoration.None
                )
            }

            Checkbox(
                checked = state.isChecked,
                onCheckedChange = onCheckedChange
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TodoListScreenPreview() {
    TodoListScreen(state = TodoState(), onCheckedChange = {})
}