package com.example.week5.Soal1

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.week6.Soal2.DB.ProfileViewModel


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}



@Composable
fun ProfileScreen(viewModel: ProfileViewModel = viewModel()) {
    val profile = viewModel.profile
    val friends = viewModel.friends
    val workouts = viewModel.availableWorkouts

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Profile",
            style = MaterialTheme.typography.bodyLarge.copy(
                color = Color.Black,
                fontWeight = FontWeight.Bold
            ),
        )

        Spacer(Modifier.height(12.dp))

        MyProfileCard(profile = profile)

        Spacer(Modifier.height(16.dp))

        Text("Friend Suggestion",
            style = MaterialTheme.typography.bodyLarge.copy(
            color = Color.Black,
            fontWeight = FontWeight.Bold
        ),)
        Spacer(Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
        ) {
            friends.forEach { friend ->
                FriendCard(
                    friend = friend,
                    onToggleFriend = { name -> viewModel.toggleFriend(name) }
                )
            }
        }

        Spacer(Modifier.height(16.dp))

        Text("Workout List", style = MaterialTheme.typography.titleMedium)
        Spacer(Modifier.height(8.dp))

        LazyColumn {
            items(workouts) { workout ->
                WorkoutCard(
                    workout = workout,
                    onToggle = { viewModel.toggleWorkout(workout.name) }
                )
            }
        }
    }
}
