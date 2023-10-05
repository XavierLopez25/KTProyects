package com.example.lab7kt.networking.response

import com.google.gson.annotations.SerializedName

/**
 * Data class representing the details of a particular meal.
 * This class maps the response to a list of meal details.
 */
data class MealDetailResponse(
    // Serialized name maps the JSON key "meals" to the 'meals' property.
    // It's nullable as the meals detail might not be present in some responses.
    @SerializedName("meals") val meals: List<MealDetail>?
)

/**
 * Data class representing a single meal's detailed information.
 * This contains details like ID, name, instructions, category, area, and image thumbnail of the meal.
 */
data class MealDetail(
    @SerializedName("idMeal") val idMeal: String,
    @SerializedName("strMeal") val strMeal: String,
    @SerializedName("strInstructions") val strInstructions: String,
    @SerializedName("strCategory") val strCategory: String,
    @SerializedName("strArea") val strArea: String,
    @SerializedName("strMealThumb") val strMealThumb: String,
)