package com.example.week6.Soal2

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.week5.Soal1.ProfileScreen
import com.example.week6.Soal2.Components.AddWorkout
import com.example.week6.Soal2.Components.NavigationBar
import com.example.week6.Soal2.Models.ProfileViewModel
import com.example.week6.Soal2.Models.Screens
import com.example.week6.Soal2.UIs.FriendScreen
import com.example.week6.Soal2.UIs.WorkoutScreen

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainNav(viewModel: ProfileViewModel = viewModel() ){
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: Screens.PROFILE.route

    Scaffold(
        containerColor = Color(0xFFFFFFFF),
        bottomBar = {
            NavigationBar(
                currentRoute = currentRoute,
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
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.PROFILE.route,
            modifier = Modifier.padding(paddingValues)
        ){
            composable(Screens.PROFILE.route){
                ProfileScreen(viewModel = viewModel)
            }
            composable(Screens.WORKOUT.route){
                WorkoutScreen(viewModel = viewModel)
            }
            composable(Screens.FRIENDS.route){
                FriendScreen(viewModel = viewModel)
            }
            }
        }
    }
