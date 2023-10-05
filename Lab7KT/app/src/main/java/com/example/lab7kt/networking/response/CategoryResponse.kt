package com.example.lab7kt.networking.response

import com.google.gson.annotations.SerializedName

/**
 * Data class representing the response of meal categories.
 * This class maps the response to the categories list.
 */
data class CategoriesResponse(
    // Serialized name maps the JSON key "meals" to the 'categories' property.
    @SerializedName("meals") val categories: List<CategoryResponse>
)

/**
 * Data class representing a single category in the response.
 * This contains details like name, image thumbnail, and the ID of the meal.
 */
data class CategoryResponse(
    // Name of the meal.
    @SerializedName("strMeal") val name: String,

    // Thumbnail URL of the meal.
    @SerializedName("strMealThumb") val mealthumb: String,

    // Unique ID of the meal.
    @SerializedName("idMeal") val idmeal: String
)
