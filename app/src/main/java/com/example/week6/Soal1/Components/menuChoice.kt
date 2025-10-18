package com.example.week6.Soal1.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.week6.R
import com.example.week6.Soal1.Models.ItemNav

@Preview(showBackground = true)
@Composable
fun MenuChoicePreview() {
    MenuChoice(onNavigate = {})
}

@Composable
fun MenuChoice(
    onNavigate: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        MenuCard(
            modifier = Modifier.weight(1f),
            title = "Food delivery",
            subtitle = "Delivery from 99 $",
            image = R.drawable.pandaburger,
            onClick = { onNavigate(ItemNav.DELIVERY.title) }
        )

        MenuCard(
            modifier = Modifier.weight(1f),
            title = "Pandamart",
            subtitle = "New users $10 off",
            image = R.drawable.pandacart,
            onClick = { onNavigate(ItemNav.VEGETABLES.title) }
        )
    }
}

@Composable
fun MenuCard(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    image: Int,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .height(230.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(12.dp)
                    .fillMaxWidth(0.6f)

            ) {
                Text(
                    text = title,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = subtitle,
                    fontSize = 10.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 2.dp)
                )
            }

            Image(
                painter = painterResource(id = image),
                contentDescription = title,
                modifier = Modifier
                    .size(160.dp)
                    .align(Alignment.BottomCenter)
                    .offset(y = 10.dp),
                contentScale = ContentScale.Fit
            )
        }
    }
}