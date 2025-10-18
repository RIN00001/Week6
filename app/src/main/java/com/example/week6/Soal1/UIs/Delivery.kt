package com.example.week6.Soal1.UIs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.week6.R
import com.example.week6.Soal1.Components.AppTitle
import com.example.week6.Soal1.Components.SearchBarDelivery
import com.example.week6.Soal1.Components.TopBanner
import com.example.week6.Soal1.Components.FoodCard
import com.example.week6.Soal1.Models.ItemViewModel

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DeliveryPreview() {
    DeliveryScreen()
}

@Composable
fun DeliveryScreen(
    onNavigate: (String) -> Unit = {}
) {
    val viewModel: ItemViewModel = viewModel()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        AppTitle("Find Your Favourite Food", R.drawable.pandabike)

        SearchBarDelivery("Search for Food")

        TopBanner()

        FoodCard("Popular Menu", viewModel.fastfoods)
    }
}
