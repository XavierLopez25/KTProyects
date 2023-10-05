package com.example.lab7kt.meals.view

import androidx.lifecycle.ViewModel
import com.example.lab7kt.meals.repository.MealsRepository
import com.example.lab7kt.networking.response.MealsCategoriesResponse

/**
 * ViewModel class for Meals Categories. This is responsible for providing data to the UI and
 * encapsulating the logic for data retrieval.
 *
 * @property repository An instance of MealsRepository. This interacts with the data source, which could be
 * a local database, or a remote server, etc.
 */
class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()) : ViewModel() {

    /**
     * Fetches the meals categories from the repository and passes the result to the provided success callback.
     *
     * @param successCallback A function that accepts a MealsCategoriesResponse (or null) and returns Unit (i.e., no return).
     * This function will be called when the data retrieval from the repository completes successfully.
     */
    fun getMeals(successCallback: (response: MealsCategoriesResponse?) -> Unit) {
        // Fetch meals from the repository
        repository.getMeals { response ->
            // Once the data retrieval completes, invoke the success callback
            successCallback(response)
        }
    }
}