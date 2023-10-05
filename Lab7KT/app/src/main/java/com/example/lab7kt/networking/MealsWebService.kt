package com.example.lab7kt.networking

import com.example.lab7kt.networking.response.CategoriesResponse
import com.example.lab7kt.networking.response.MealDetailResponse
import com.example.lab7kt.networking.response.MealsCategoriesResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory

/**
 * A web service class for managing requests related to meals.
 * It uses Retrofit to perform API calls to "https://www.themealdb.com/api/json/v1/1/".
 */
class MealsWebService {

    // Interface representing the API endpoints
    private lateinit var api: MealsApi

    // Initializing the Retrofit instance with necessary configurations
    init {
        // Create a logging interceptor to log the details of network requests
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        // Configure OkHttpClient with the logging interceptor
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        // Build the Retrofit instance with the provided base URL and configurations
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create()) // Use Gson to convert JSON to POJO
            .client(client)
            .build()

        // Create an instance of the MealsApi interface using the Retrofit instance
        api = retrofit.create(MealsApi::class.java)
    }

    /**
     * Fetch a list of meals categories.
     *
     * @return Call object of type [MealsCategoriesResponse] for further execution.
     */
    fun getMeals(): Call<MealsCategoriesResponse> {
        return api.getMeals()
    }

    /**
     * Fetch meals under a specific category.
     *
     * @param categoryId The category ID for which the meals are to be fetched.
     * @return Call object of type [CategoriesResponse] for further execution.
     */
    fun getMealsInCategory(categoryId: String): Call<CategoriesResponse> {
        val url = "$categoryId"
        println("WebService getMealsInCategory Invoked with URL: $url")
        return api.getMealsInCategory("$categoryId")
    }

    /**
     * Fetch detailed information about a specific meal.
     *
     * @param mealId The meal ID for which the details are to be fetched.
     * @return A suspend function that returns an instance of [MealDetailResponse].
     */
    suspend fun getMealDetail(mealId: String): MealDetailResponse? {
        return api.getMealDetail(mealId)
    }
}