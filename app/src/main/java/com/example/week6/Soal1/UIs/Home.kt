package com.example.week6.Soal1.UIs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.week6.R
import com.example.week6.Soal1.Components.AppTitle
import com.example.week6.Soal1.Components.AppFilter
import com.example.week6.Soal1.Components.MenuChoice
import com.example.week6.Soal1.Components.RestaurantSection
import com.example.week6.Soal1.Components.SearchBarMenu
import com.example.week6.Soal1.Models.ItemViewModel

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomePreview() {
    HomeScreen()
}

@Composable
fun HomeScreen(
    onNavigate: (String) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        AppTitle("Taste the world at your Door Step!", R.drawable.pandaok)

        SearchBarMenu("What are you craving?")

        val viewModel: ItemViewModel = viewModel()
        var selectedFilter by remember { mutableStateOf("Restaurant") }
        AppFilter(
            filters = viewModel.filter,
            selectedFilter = selectedFilter,
            onFilterClick = { selectedFilter = it }
        )

        MenuChoice(onNavigate = onNavigate)

        RestaurantSection()
    }
}
