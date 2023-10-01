package com.example.lab7kt.navigation.response

import com.google.gson.annotations.SerializedName

data class MealDetailResponse(
    @SerializedName("meals") val meals: List<MealDetail>?
)

data class MealDetail(
    @SerializedName("idMeal") val idMeal: String,
    @SerializedName("strMeal") val strMeal: String,
    @SerializedName("strInstructions") val strInstructions: String
    // Puedes agregar aquí más campos conforme a la respuesta del API
)