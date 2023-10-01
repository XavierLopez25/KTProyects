package com.example.lab7kt.mealsincategory.view

import com.example.lab7kt.navigation.NavigationState
import com.example.lab7kt.navigation.response.CategoryResponse
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.AnnotatedString
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController


@Composable
fun MealsInCategoryScreen(categoryId: String, navController: NavController) {
    val viewModel: MealsInCategoryViewModel = viewModel()
    val rememberedMeals: MutableState<List<CategoryResponse>> = remember { mutableStateOf(emptyList<CategoryResponse>()) }
    println("MealsInCategoryScreen Invoked with categoryId: $categoryId")

    viewModel.getMealsInCategory(categoryId) { response ->
        println("Response in Screen: $response")

        if (response != null) {
            rememberedMeals.value = response.categories.orEmpty()
            println("Updated rememberedMeals: ${rememberedMeals.value}")

        }
    }

    LazyColumn {
        items(rememberedMeals.value) { meal ->
            ClickableText(
                text = AnnotatedString(text = meal.name),
                onClick = { offset ->
                    navController.navigate("${NavigationState.Detail.route}/${meal.idmeal}")
                }
            )
        }
    }
}


