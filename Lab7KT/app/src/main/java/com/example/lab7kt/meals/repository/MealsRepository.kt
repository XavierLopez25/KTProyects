package com.example.lab7kt.meals.repository

import com.example.lab7kt.networking.MealsWebService
import com.example.lab7kt.networking.response.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Repository class for managing meal-related data operations.
 *
 * @property webService An instance of [MealsWebService]. Default value is a new instance of [MealsWebService].
 */
class MealsRepository(private val webService: MealsWebService = MealsWebService()) {

    /**
     * Fetches the meals and informs the caller via a callback.
     *
     * @param successCallback Callback to be invoked when the meals are successfully fetched.
     * It provides the [MealsCategoriesResponse] object to the caller.
     */
    fun getMeals(successCallback: (response: MealsCategoriesResponse?) -> Unit) {
        webService.getMeals().enqueue(object : Callback<MealsCategoriesResponse> {

            /**
             * Invoked when a network response is received.
             *
             * @param call The original call.
             * @param response The response received.
             */
            override fun onResponse(
                call: Call<MealsCategoriesResponse>,
                response: Response<MealsCategoriesResponse>
            ) {
                if (response.isSuccessful)
                    successCallback(response.body())
            }

            /**
             * Invoked when a network exception occurs talking to the server or when an unexpected exception
             * occurs creating the request or processing the response.
             *
             * @param call The original call.
             * @param t The error occurred.
             */
            override fun onFailure(call: Call<MealsCategoriesResponse>, t: Throwable) {
                // TODO treat failure
            }
        })
    }
}