package com.example.lab7kt.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab7kt.meals.view.MealsCategoriesScreen
import com.example.lab7kt.mealsincategory.view.MealsInCategoryScreen
import com.example.lab7kt.mealdetail.view.MealDetailScreen

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = NavigationState.Home.route,
        modifier = modifier) {
        composable(route = NavigationState.Home.route) {
            MealsCategoriesScreen(navController)
        }
        composable(route = NavigationState.Category.route) { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getString("categoryId")
            if (categoryId != null) {
                // Navigate to the appropriate screen
                MealsInCategoryScreen(categoryId, navController)
            }
        }
        composable(route = "${NavigationState.Detail.route}/{mealId}") { backStackEntry ->
            val mealId = backStackEntry.arguments?.getString("mealId")
            if (mealId != null) {
                MealDetailScreen(mealId)
            }
        }
    }
}