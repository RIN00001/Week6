package com.example.week6.Soal1

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.week6.Soal1.Models.ItemNav
import com.example.week6.Soal1.Models.ItemViewModel
import com.example.week6.Soal1.UIs.DeliveryScreen
import com.example.week6.Soal1.UIs.HomeScreen
import com.example.week6.Soal1.UIs.VeggieScreen

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainNav1(viewModel: ItemViewModel = viewModel()) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        containerColor = Color(0xFFF5F5F5),
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = ItemNav.HOME.title,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(ItemNav.HOME.title) {
                HomeScreen(
                    onNavigate = { route ->
                        navController.navigate(route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
            composable(ItemNav.DELIVERY.title) {
                DeliveryScreen(
                    onNavigate = { route ->
                        navController.navigate(route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
            composable(ItemNav.VEGETABLES.title) {
                VeggieScreen(
                    onNavigateBack = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}
