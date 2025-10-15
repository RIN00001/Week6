package com.example.week5.Soal1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Whatshot
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun MyProfileCardPreview() {
    MyProfileCard(
        profile = Profile(
            name = "Jamier Tanuwijaya",
            height = 170,
            weight = 65,
            age = 21,
            workouts = emptyList(),
        )
    )
}

@Composable
fun MyProfileCard(profile: Profile) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE8F3FD)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .background(Color(0xFFAAD0F8), shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Profile icon",
                        tint = Color(0xFF232B33),
                        modifier = Modifier.size(40.dp)
                    )
                }
                Column {
                    Text(
                        text = "${profile.name}, ${profile.age}",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        ),                    )
                    Spacer(Modifier.height(4.dp))

                    Text(
                        text = "${profile.height} cm / ${profile.weight} kg",
                        style = MaterialTheme.typography.bodySmall.copy(color = Color.Gray)
                    )

                    Spacer(Modifier.height(8.dp))

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconText(Icons.Default.Whatshot, profile.calories, Color(0xFFFB8C00))
                        IconText(Icons.Default.People, profile.friendCount,Color(0xFF1976D2))
                    }
                }
            }

        }
    }
}

@Composable
private fun IconText(icon: ImageVector, value: Int,color: Color) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = color,
            modifier = Modifier.size(25.dp)
        )
        Spacer(Modifier.width(4.dp))
        Text(text = value.toString(), color = Color.Gray, style = MaterialTheme.typography.bodySmall)
    }
}
