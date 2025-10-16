package com.example.week6.Soal2.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Whatshot
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.week6.Soal2.Models.Screens

@Preview(showBackground = true)
@Composable
fun NavigationBarPreview() {
    NavigationBar(
        currentRoute = Screens.PROFILE.route,
        onNavigate = {}
    )
}

@Composable
fun NavigationBar(
    currentRoute: String,
    onNavigate: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF000000))
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        NavigationItem(
            icon = Icons.Default.Person,
            label = "Profile",
            isSelected = currentRoute == Screens.PROFILE.route,
            onClick = { onNavigate(Screens.PROFILE.route) }
        )
        NavigationItem(
            icon = Icons.Default.Whatshot,
            label = "Workouts",
            isSelected = currentRoute == Screens.WORKOUT.route,
            onClick = { onNavigate(Screens.WORKOUT.route) }
        )
        NavigationItem(
            icon = Icons.Default.People,
            label = "Friends",
            isSelected = currentRoute == Screens.FRIENDS.route,
            onClick = { onNavigate(Screens.FRIENDS.route) }
        )
    }
}

@Composable
fun NavigationItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onClick() }
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "$label Icon",
            tint = if (isSelected) Color(0xFF2196F3) else Color.Gray,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall.copy(
                color = if (isSelected) Color(0xFF2196F3) else Color.Gray,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
            )
        )
    }
}

