package com.example.week5.Soal1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.SelfImprovement
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable
fun WorkoutCardPreview() {
    WorkoutCardActive(
        workout = Workout("Morning Yoga", "300","Sports",icon = Icons.Default.SelfImprovement),
    )
}
@Composable
fun WorkoutCard(
    workout: Workout,
    onToggle: () -> Unit,
    ) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFFEDF9EF))
        , modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
            , horizontalArrangement = Arrangement.SpaceBetween
            , verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .background(Color(0xFFBDE6C2), shape = CircleShape),
                    contentAlignment = Alignment.Center
                ){
                    Icon(
                        imageVector = workout.icon,
                        contentDescription = null,
                        tint = Color(0xFF2E7D32),
                        modifier = Modifier.size(40.dp)
                    )
                }
                Spacer(Modifier.width(16.dp))

                Column {
                    Text(
                        text = workout.name,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        ),
                    )
                    Text(
                        text = "Calories ${workout.calories}",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = Color.Black,
                            fontWeight = FontWeight.Medium
                        ),
                    )
                    Text(
                        text = workout.type,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = Color.Black,
                            fontWeight = FontWeight.Light
                        ),
                    )
                }
            }

            IconButton(
                onClick = onToggle,
                modifier = Modifier
                    .size(32.dp)
                    .background(
                        color = if (workout.selected) Color(0xFFEB4D47) else Color(0xFF3D87F7),
                        shape = CircleShape
                    )
            ) {
                Icon(
                    imageVector = if (workout.selected) Icons.Default.Remove else Icons.Default.Add,
                    contentDescription = "Toggle Workout",
                    tint = Color.White
                )
            }
        }
    }
}
@Composable
fun WorkoutCardActive(
    workout: Workout
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFFEDF9EF))
        , modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
            , horizontalArrangement = Arrangement.SpaceBetween
            , verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .background(Color(0xFFBDE6C2), shape = CircleShape),
                    contentAlignment = Alignment.Center
                ){
                    Icon(
                        imageVector = workout.icon,
                        contentDescription = null,
                        tint = Color(0xFF2E7D32),
                        modifier = Modifier.size(40.dp)
                    )
                }
                Spacer(Modifier.width(16.dp))

                Column {
                    Text(
                        text = workout.name,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        ),
                    )
                    Text(
                        text = "Calories ${workout.calories}",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = Color.Black,
                        fontWeight = FontWeight.Medium
                    ),
                    )
                    Text(
                        text = workout.type,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = Color.Black,
                            fontWeight = FontWeight.Light
                    ),
                    )
                }
            }
        }
    }
}