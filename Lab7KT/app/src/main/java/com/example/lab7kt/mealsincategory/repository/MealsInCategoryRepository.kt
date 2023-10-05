package com.example.lab7kt.mealsincategory.repository

import com.example.lab7kt.networking.MealsWebService

import com.example.lab7kt.networking.response.CategoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Repository class responsible for fetching meals in a given category from a web service.
 *
 * @param webService An instance of the MealsWebService. If not provided, a default instance is used.
 */
class MealsInCategoryRepository(private val webService: MealsWebService = MealsWebService()) {

    /**
     * Fetches meals for a specific category and invokes the provided callback on successful API response.
     *
     * @param categoryId The identifier of the meal category.
     * @param successCallback The callback to be invoked on successful API response. It is passed the CategoriesResponse.
     */
    fun getMealsInCategory(categoryId: String, successCallback: (response: CategoriesResponse?) -> Unit) {
        webService.getMealsInCategory(categoryId).enqueue(object : Callback<CategoriesResponse> {

            /**
             * Callback method to be invoked when the API call is successful and receives a response.
             *
             * @param call The original call.
             * @param response The received response.
             */
            override fun onResponse(call: Call<CategoriesResponse>, response: Response<CategoriesResponse>) {
                // Check if the response is successful
                if (response.isSuccessful) {
                    // Pass the response body to the provided success callback
                    successCallback(response.body())
                }
            }

            /**
             * Callback method to be invoked when the API call fails.
             *
             * @param call The original call.
             * @param t The exception/error that caused the failure.
             */
            override fun onFailure(call: Call<CategoriesResponse>, t: Throwable) {
                // TODO: Handle the failure scenario, e.g., invoking another callback, logging the error, etc.
            }
        })
    }
}