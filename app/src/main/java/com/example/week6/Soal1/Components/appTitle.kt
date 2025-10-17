package com.example.week6.Soal1.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.week6.R


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewAppTitle() {
    AppTitle("Taste the world at your Door Step!", R.drawable.pandabike)
}

@Composable
fun AppTitle(title: String, image: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            modifier = Modifier.weight(1f),
            fontSize = 28.sp,
            fontWeight = FontWeight.Light,
            color = Color.Black,
            textAlign = TextAlign.Start,
            lineHeight = 30.sp
        )
        Spacer(modifier = Modifier.width(40.dp))

        Image(
            painter = painterResource(id = image),
            contentDescription = "App Icon",
            modifier = Modifier
                .size(110.dp)
                .padding(start = 8.dp)
        )
    }
}