package com.example.lab7kt.mealsincategory.view

import androidx.lifecycle.ViewModel
import com.example.lab7kt.mealsincategory.repository.MealsInCategoryRepository
import com.example.lab7kt.navigation.response.CategoriesResponse

class MealsInCategoryViewModel(private val repository: MealsInCategoryRepository = MealsInCategoryRepository()): ViewModel() {
    fun getMealsInCategory(categoryId: String, successCallback: (response: CategoriesResponse?) -> Unit) {
        println("ViewModel getMealsInCategory Invoked with categoryId: $categoryId")

        repository.getMealsInCategory(categoryId) { response ->
            successCallback(response)
        }
    }
}