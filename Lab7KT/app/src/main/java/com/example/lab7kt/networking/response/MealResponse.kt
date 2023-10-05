package com.example.lab7kt.networking.response

import com.google.gson.annotations.SerializedName

/**
 * Data class representing the response of all meal categories.
 * This class maps the response to a list of meal responses.
 */
data class MealsCategoriesResponse(
    // List of meal responses.
    val categories: List<MealResponse>
)

/**
 * Data class representing a single meal category in the response.
 * This contains details like ID, name, description, and image URL of the category.
 */
data class MealResponse(
    // Unique ID of the category.
    @SerializedName("idCategory") val id: String,

    // Name of the category.
    @SerializedName("strCategory") val name: String,

    // Description of the category.
    @SerializedName("strCategoryDescription") val description: String,

    // Image URL of the category.
    @SerializedName("strCategoryThumb") val imageUrl: String
)