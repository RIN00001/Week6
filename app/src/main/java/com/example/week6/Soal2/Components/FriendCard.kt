package com.example.week5.Soal1
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



@Preview(showBackground = true)
@Composable
fun FriendCardPreview() {
    FriendCard(
        friend = Profile(
            name = "Evan M.",
            height = 180,
            weight = 75,
            age = 29,
            isFriended = false
        ),
        onToggleFriend = {}
    )
}




@Composable
fun FriendCard(friend: Profile, onToggleFriend: (String) -> Unit) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE8F7FB)),
        modifier = Modifier
            .width(150.dp)
            .padding(end = 8.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .background(Color(0xFFAEE3F2), shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Friend Avatar",
                    tint = Color(0xFF242F32),
                    modifier = Modifier.size(40.dp)
                )
            }

            Spacer(Modifier.height(8.dp))

            Text(
                text = friend.name,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                color = Color.Black
            )
            Text(
                text = "${friend.age} years old",
                style = MaterialTheme.typography.bodySmall.copy(color = Color.Gray)
            )

            Spacer(Modifier.height(8.dp))

            Button(
                onClick = { onToggleFriend(friend.name) },
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (friend.isFriended) Color.Gray else Color(0xFF58B4FF)
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = if (friend.isFriended) "Added" else "Add Friend",
                    color = Color.White
                )
            }
        }
    }
}
