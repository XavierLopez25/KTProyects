package com.example.lab7kt.mealdetail.repository

import com.example.lab7kt.networking.MealsWebService
import com.example.lab7kt.networking.response.MealDetailResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class MealDetailRepository(private val webService: MealsWebService = MealsWebService()) {

    suspend fun getMealDetail(mealId: String): MealDetailResponse? {

        return withContext(Dispatchers.IO) {
            try {
                val response = webService.getMealDetail(mealId)
                println("Response: $response")
                response
            } catch (e: Exception) {
                println("Error: ${e.localizedMessage}")
                null
            }
        }
    }
}