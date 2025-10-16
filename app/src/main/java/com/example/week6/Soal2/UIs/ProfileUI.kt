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
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.week6.Soal2.Models.ProfileViewModel


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}



@Composable
fun ProfileScreen(viewModel: ProfileViewModel = viewModel()) {
    val profile = viewModel.profile

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
            fontSize = 27.sp
        )

        Spacer(Modifier.height(12.dp))

        MyProfileCard(profile = profile)

        Spacer(Modifier.height(16.dp))

        Text("My Friends",
            style = MaterialTheme.typography.bodyLarge.copy(
            color = Color.Black,
            fontWeight = FontWeight.Bold
        ),
            fontSize = 24.sp
        )
        Spacer(Modifier.height(8.dp))

        if (profile.friends.isEmpty()) {
            Text(
                text = "No friends added yet",
                style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray),
                modifier = Modifier.padding(30.dp)
            )
        } else {
            Row(
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
            ) {
                profile.friends.forEach { friend ->
                    FriendCardActive(friend = friend)
                }
            }
        }

        Spacer(Modifier.height(16.dp))

        Text("My Workouts",
            style = MaterialTheme.typography.bodyLarge.copy(
                color = Color.Black,
                fontWeight = FontWeight.Bold
            ),
            fontSize = 24.sp

        )
        Spacer(Modifier.height(8.dp))

        if (profile.workouts.isEmpty()) {
            Text(
                text = "No workouts added yet",
                style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray),
                modifier = Modifier.padding(30.dp)
            )
        } else {
            LazyColumn {
                items(profile.workouts) { workout ->
                    WorkoutCardActive(workout = workout)
                }
            }
        }
    }
}
