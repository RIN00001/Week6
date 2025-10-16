package com.example.week5.Soal1

import androidx.compose.ui.graphics.vector.ImageVector

data class Workout(
    val name: String,
    val calories: String,
    val type: String,
    val icon: ImageVector,
    val selected: Boolean = false
)

data class Profile(
    val name: String,
    val height: Int,
    val weight: Int,
    val age: Int,
    var workouts: List<Workout> = emptyList(),
    var friends: List<Profile> = emptyList(),
    var isFriended: Boolean = false,
    var calories: Int = 0,
    var friendCount: Int = 0,
)