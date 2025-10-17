package com.example.week6.Soal1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.week6.Soal1.Components.MenuChoice
import com.example.week6.Soal1.Models.ItemNav
import com.example.week6.Soal1.Models.ItemViewModel


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainNav1(viewModel: ItemViewModel = viewModel()) {
    var currentRoute by remember { mutableStateOf(ItemNav.HOME.title) }

    Scaffold(
        containerColor = Color(0xFFF5F5F5),
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when (currentRoute) {
                ItemNav.HOME.title -> {
                    //Home(viewModel = viewModel)
                }
                ItemNav.DELIVERY.title -> {
                    //Delivery(viewModel = viewModel)
                }
                ItemNav.VEGETABLES.title -> {
                    //Veggie(viewModel = viewModel)
                }
            }
        }
    }
}
