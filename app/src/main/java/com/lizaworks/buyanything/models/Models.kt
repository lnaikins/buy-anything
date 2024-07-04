package com.lizaworks.buyanything.models

import androidx.compose.ui.graphics.Color
import com.lizaworks.buyanything.R


data class Categories(val image: Int, val title: String) {
    companion object {
        val data = listOf(
            Categories(
                image = R.drawable.fruits,
                title = "Fruits",
            ),
            Categories(
                image = R.drawable.tech,
                title = "Tech",
            ),
            Categories(
                image = R.drawable.car,
                title = "Vehicles",
            ),
            Categories(
                image = R.drawable.drinks,
                title = "Drinks",
            ),
            Categories(
                image = R.drawable.network,
                title = "Internet",
            ),
            Categories(
                image = R.drawable.fashion,
                title = "Fashion",
            ),
            Categories(
                image = R.drawable.food,
                title = "Food",
            ),
            Categories(
                image = R.drawable.more,
                title = "More",
            ),

            )
    }
}

data class Promos(
    val title: String,
    val description: String,
    val backgroundColor: Color,
    val timeline: String,
    val image: Int
) {
    companion object {
        val data = listOf(
            Promos(
                title = "Christmas Promo",
                description = "Do we need to say more?",
                timeline = "20th - 31st December.", backgroundColor = Color(0xFFAE2E44),
                image = R.drawable.gift
            ),
            Promos(
                title = "Discount Code",
                description = "Use this promo to get 20% off on your purchases.",
                timeline = "24th - 27th December.", backgroundColor = Color(0xFF396EA3),
                image = R.drawable.gift
            ),
            Promos(
                title = "Christmas Promo",
                description = "Do we need to say more?",
                timeline = "20th - 31st December.", backgroundColor = Color(0xFFAE2E44),
                image = R.drawable.gift
            )
        )

    }
}

data class Price(val title: String, val currency: String, val price: String, val image: Int) {
    companion object {
        val data = listOf(
            Price(
                title = "50\" Christmas Tree \n w/ bells",
                currency = "GHs",
                price = "240",
                image = R.drawable.christmas_tree
            ),
            Price(
                title = "Christmas String \n light outdoor",
                currency = "GHs",
                price = "3000",
                image = R.drawable.wreath
            ),
        )
    }
}