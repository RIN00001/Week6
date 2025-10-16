package com.example.week6.Soal2.Models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AllInclusive
import androidx.compose.material.icons.filled.Blind
import androidx.compose.material.icons.filled.DirectionsBike
import androidx.compose.material.icons.filled.DirectionsRun
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.SelfImprovement
import androidx.compose.material.icons.filled.WheelchairPickup
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.ViewModel
import com.example.week5.Soal1.Profile
import com.example.week5.Soal1.Workout

enum class Screens(val route: String) {
    PROFILE("profile"),
    WORKOUT("workout"),
    FRIENDS("friends"),
}
class ProfileViewModel : ViewModel(){
    var profile by mutableStateOf(
        Profile(
            name = "Javier Tanuwijaya",
            height = 175,
            weight = 65,
            age = 21,
            workouts = listOf(),
            isFriended = false
        )
    )
        private set
/*
    Workout("Cardio Blast", type = "Cardio", calories = "302", icon = Icons.Default.DirectionsRun),
    Workout("Strength Training", type = "Strength", calories = "3123", icon = Icons.Default.FitnessCenter),
    Workout("Evening Run", type = "Cardio", calories = "200", icon = Icons.Default.DirectionsRun),
    Workout("Cycling", type = "Cycling", calories = "500", icon = Icons.Default.DirectionsBike)
 */
var availableWorkouts by mutableStateOf(listOf<Workout>())

    var friends by mutableStateOf(
        listOf(
            Profile("Evan M.", 180, 75, 29, emptyList()),
            Profile("Tanjung D.", 168, 60, 21, emptyList()),
            Profile("RudiTak", 170, 65, 18, emptyList())
        )
    )
        private set


    val IconsList = listOf(
        Icons.Default.SelfImprovement,
        Icons.Default.DirectionsRun,
        Icons.Default.FitnessCenter,
        Icons.Default.Blind,
        Icons.Default.DirectionsBike,
        Icons.Default.AllInclusive,
        Icons.Default.WheelchairPickup
    )
    fun toggleFriend(friendName: String) {
        var addedFriend = false
        var toggledFriend: Profile? = null

        friends = friends.map {
            if (it.name == friendName) {
                val newState = !it.isFriended
                if (newState) addedFriend = true
                val updatedFriend = it.copy(isFriended = newState)
                toggledFriend = updatedFriend
                updatedFriend
            } else it
        }

        profile = if (addedFriend && toggledFriend != null) {
            profile.copy(
                friends = profile.friends + toggledFriend!!,
                friendCount = profile.friendCount + 1
            )
        } else {
            profile.copy(
                friends = profile.friends.filter { it.name != friendName },
                friendCount = profile.friendCount - 1
            )
        }
    }


    fun toggleWorkout(name: String) {
        var added = false
        var toggledWorkout: Workout? = null

        availableWorkouts = availableWorkouts.map {
            if (it.name == name) {
                val newState = !it.selected
                if (newState) added = true
                val updatedWorkout = it.copy(selected = newState)
                toggledWorkout = updatedWorkout
                updatedWorkout
            } else it
        }

        profile = if (added && toggledWorkout != null) {
            profile.copy(
                workouts = profile.workouts + toggledWorkout!!,
                calories = profile.calories + 1
            )
        } else {
            profile.copy(
                workouts = profile.workouts.filter { it.name != name },
                calories = profile.calories - 1
            )
        }
    }

    fun addWorkout(name: String, type: String, calories: String, icon: ImageVector){
        val newWorkout = Workout(
            name = name,
            calories = calories,
            type = type,
            icon = icon,
            selected = false
        )
        availableWorkouts = availableWorkouts + newWorkout
    }


}