package com.example.week6.Soal2.DB

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsBike
import androidx.compose.material.icons.filled.DirectionsRun
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.SelfImprovement
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.week5.Soal1.Profile
import com.example.week5.Soal1.Workout

class ProfileViewModel : ViewModel(){
    var profile by mutableStateOf(
        Profile(
            name = "John Doe",
            height = 175,
            weight = 70,
            age = 25,
            workouts = listOf(),
            isFriended = false
        )
    )
        private set

    var availableWorkouts by mutableStateOf(
        listOf(
            Workout("Morning Yoga", icon = Icons.Default.SelfImprovement),
            Workout("Cardio Blast", icon = Icons.Default.DirectionsRun),
            Workout("Strength Training", icon = Icons.Default.FitnessCenter),
            Workout("Evening Run", icon = Icons.Default.DirectionsRun),
            Workout("Cycling", icon = Icons.Default.DirectionsBike)
        )
    )
        private set

    var friends = listOf(
        Profile("Evan M.", 180, 75, 29, emptyList()),
        Profile("Tanjung D.", 168, 60, 21, emptyList()),
        Profile("RudiTak", 170, 65, 18, emptyList())
    )

    fun toggleFriend(friendName: String) {
        var addedFriend = false

        friends = friends.map {
            if (it.name == friendName) {
                val newState = !it.isFriended
                if (newState) addedFriend = true
                it.copy(isFriended = newState)
            } else it
        }

        profile = profile.copy(
            friendCount = profile.friendCount + if (addedFriend) 1 else -1
        )
    }


    fun toggleWorkout(name: String) {
        var added = false

        availableWorkouts = availableWorkouts.map {
            if (it.name == name) {
                val newState = !it.selected
                if (newState) added = true
                it.copy(selected = newState)
            } else it
        }

        profile = profile.copy(
            calories = profile.calories + if (added) 1 else -1
        )
    }


}