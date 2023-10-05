package com.example.lab7kt.networking

import com.example.lab7kt.networking.response.CategoriesResponse
import com.example.lab7kt.networking.response.MealDetailResponse
import com.example.lab7kt.networking.response.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Interface for the Meals API endpoints.
 *
 * This interface defines the API calls related to meals, including getting meal categories,
 * meals in a particular category, and details of a specific meal.
 */
interface MealsApi {

    /**
     * Fetches a list of all meal categories.
     *
     * Endpoint: categories.php
     *
     * @return [Call] containing [MealsCategoriesResponse] which represents the list of meal categories.
     */
    @GET("categories.php")
    fun getMeals(): Call<MealsCategoriesResponse>

    /**
     * Fetches a list of meals that belong to a specified category.
     *
     * Endpoint: filter.php
     *
     * @param categoryId The ID of the category to filter by.
     * @return [Call] containing [CategoriesResponse] which represents the list of meals in the specified category.
     */
    @GET("filter.php")
    fun getMealsInCategory(@Query("c") categoryId: String): Call<CategoriesResponse>

    /**
     * Fetches the details of a specific meal.
     *
     * Endpoint: lookup.php
     *
     * @param mealId The ID of the meal to retrieve details for.
     * @return [MealDetailResponse] containing details of the specified meal or null if not found.
     */
    @GET("lookup.php")
    suspend fun getMealDetail(@Query("i") mealId: String): MealDetailResponse?
}
