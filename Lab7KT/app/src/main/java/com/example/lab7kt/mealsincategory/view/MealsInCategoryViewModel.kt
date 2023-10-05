package com.example.lab7kt.mealsincategory.view

import androidx.lifecycle.ViewModel
import com.example.lab7kt.mealsincategory.repository.MealsInCategoryRepository
import com.example.lab7kt.networking.response.CategoriesResponse

/**
 * ViewModel class for managing meals within a category.
 *
 * @param repository An instance of [MealsInCategoryRepository] which provides methods for data operations.
 */
class MealsInCategoryViewModel(private val repository: MealsInCategoryRepository = MealsInCategoryRepository()) : ViewModel() {

    /**
     * Fetches the meals in a given category.
     *
     * This function uses the repository to fetch meals for a particular category. Once fetched, the results
     * are passed to a callback for further handling.
     *
     * @param categoryId The ID of the category for which meals need to be fetched.
     * @param successCallback Callback function which will be invoked with the meals in the given category.
     */
    fun getMealsInCategory(categoryId: String, successCallback: (response: CategoriesResponse?) -> Unit) {
        println("ViewModel getMealsInCategory Invoked with categoryId: $categoryId")

        repository.getMealsInCategory(categoryId) { response ->
            successCallback(response)
        }
    }
}