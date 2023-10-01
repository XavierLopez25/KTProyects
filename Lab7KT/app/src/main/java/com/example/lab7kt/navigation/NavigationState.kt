package com.example.lab7kt.navigation

sealed class NavigationState(val route: String) {
    object Home: NavigationState("Home")
    object Category: NavigationState("Category/{categoryId}")
    object Detail: NavigationState("MealDetail/{mealId}")

}