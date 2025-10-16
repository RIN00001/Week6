package com.example.week6.Soal2.UIs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.week5.Soal1.WorkoutCard
import com.example.week6.Soal2.Components.AddWorkout
import com.example.week6.Soal2.Models.ProfileViewModel


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WorkoutScreenPreview() {
    WorkoutScreen()
}
@Composable
fun WorkoutScreen(viewModel: ProfileViewModel = viewModel()) {
    val workouts = viewModel.availableWorkouts
    var showAddWorkoutDialog by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Workouts",
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                ),
                fontSize = 40.sp
            )
            Spacer(Modifier.height(16.dp))

            if (workouts.isEmpty()) {
                Text(
                    "No Workouts Available",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold
                    ),
                )
            } else {
                LazyColumn(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(workouts) { workout ->
                        WorkoutCard(
                            workout = workout,
                            onToggle = { viewModel.toggleWorkout(workout.name) }
                        )
                    }
                }
            }
        }

        FloatingActionButton(
            onClick = { showAddWorkoutDialog = true },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
            containerColor = Color.Blue
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add Workout",
                tint = Color(0xFFFFFFFF)
            )
        }

        if (showAddWorkoutDialog) {
            AddWorkout(
                onDismiss = { showAddWorkoutDialog = false },
                onSave = { title, type, calories, icon ->
                    viewModel.addWorkout(title, type, calories.toString(), icon)
                },
                viewModel = viewModel
            )
        }
    }
}