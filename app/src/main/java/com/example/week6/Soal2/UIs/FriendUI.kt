package com.example.week6.Soal2.UIs
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import com.example.week5.Soal1.FriendCard
import com.example.week6.Soal2.Models.ProfileViewModel

@Preview
@Composable
fun FriendScreenPreview() {
    FriendScreen()
}

@Composable
fun FriendScreen(viewModel: ProfileViewModel = viewModel()) {
    val friends = viewModel.friends

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Friends",
            style = MaterialTheme.typography.bodyLarge.copy(
                color = Color.Black,
                fontWeight = FontWeight.Bold
            ),
            fontSize = 24.sp
        )
        Spacer(Modifier.height(16.dp))

        if (friends.isEmpty()) {
            Text(
                text = "No Friends Available",
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold
                ),
            )
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(friends) { friend ->
                    FriendCard(
                        friend = friend,
                        onToggleFriend = { viewModel.toggleFriend(friend.name) }
                    )
                }
            }
        }
    }
}
