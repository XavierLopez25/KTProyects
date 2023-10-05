package com.example.lab7kt.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab7kt.meals.view.MealsCategoriesScreen
import com.example.lab7kt.mealsincategory.view.MealsInCategoryScreen
import com.example.lab7kt.mealdetail.view.MealDetailScreen

/**
 * Represents the main navigation component of the application.
 *
 * @param modifier An optional [Modifier] for the navigation host.
 */
@Composable
fun Navigation(modifier: Modifier = Modifier) {

    // Create a navigation controller to manage the navigation stack.
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavigationState.Home.route,
        modifier = modifier
    ) {
        // Define the composable destination for the Home route.
        composable(route = NavigationState.Home.route) {
            MealsCategoriesScreen(navController)
        }

        // Define the composable destination for the Category route.
        // This route expects a "categoryId" argument.
        composable(route = NavigationState.Category.route) { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getString("categoryId")
            if (categoryId != null) {
                MealsInCategoryScreen(categoryId, navController)
            }
        }

        // Define the composable destination for the Detail route.
        // This route expects a "mealId" argument.
        composable(route = "${NavigationState.Detail.route}/{mealId}") { backStackEntry ->
            val mealId = backStackEntry.arguments?.getString("mealId")
            if (mealId != null) {
                MealDetailScreen(mealId)
            }
        }
    }
}