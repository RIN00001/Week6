package com.example.week6.Soal1.Models

import androidx.lifecycle.ViewModel
import com.example.week6.R

enum class ItemNav(val title: String) {
    HOME("Home"),
    DELIVERY("Delivery"),
    VEGETABLES("Vegetables")
}

class ItemViewModel : ViewModel(){
    val fastfoods = listOf(
        Item("Zinger Burger","2", R.drawable.hamburger),
        Item("Roll Parantha","3",R.drawable.burrito),
        Item("Tomato Soup","2",R.drawable.soup),
        Item("Long Burger","5",R.drawable.sandwich),
        Item("Creamy Biscuit","5",R.drawable.macarons),
        Item("Fried Chicken", "4",R.drawable.cupcake)
    )

    val vegetables = listOf(
        Item("Fresh Peach","9",R.drawable.apple),
        Item("Avocado","7",R.drawable.avocado),
        Item("Pinapple","5",R.drawable.pinapple),
        Item("Fresh B rocolli","3",R.drawable.brocoli)
    )

    val filter = listOf(
        "Restaurant","Deals","Track Order"
    )
}