package com.example.lab7kt.mealdetail.repository

import com.example.lab7kt.networking.MealsWebService
import com.example.lab7kt.networking.response.MealDetailResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * This class provides methods to fetch detailed information about a meal.
 *
 * @param webService an instance of the MealsWebService to handle API requests.
 * By default, it uses a new instance of MealsWebService.
 */
class MealDetailRepository(private val webService: MealsWebService = MealsWebService()) {

    /**
     * Fetches the detail of a specific meal by its mealId.
     *
     * This function performs the network request on the IO dispatcher
     * to ensure it doesn't block the main thread.
     *
     * @param mealId the ID of the meal whose details are to be fetched.
     * @return the details of the specified meal wrapped in a MealDetailResponse object.
     * If any error occurs, it prints the error and returns null.
     */
    suspend fun getMealDetail(mealId: String): MealDetailResponse? {
        return withContext(Dispatchers.IO) {
            try {
                // Make the network request
                val response = webService.getMealDetail(mealId)

                // Print the received response for debugging purposes
                println("Response: $response")

                response
            } catch (e: Exception) {
                // Print the error message if the request fails
                println("Error: ${e.localizedMessage}")
                null
            }
        }
    }
}
