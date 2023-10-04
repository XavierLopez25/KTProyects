package com.example.lab7kt.meals.view

import androidx.lifecycle.ViewModel
import com.example.lab7kt.meals.repository.MealsRepository
import com.example.lab7kt.networking.response.MealsCategoriesResponse


class MealsCategoriesViewModel (private val repository: MealsRepository = MealsRepository()): ViewModel() {
    fun getMeals(successCallback: (response: MealsCategoriesResponse?) -> Unit) {
        repository.getMeals { response ->
            successCallback(response)
        }
    }
}