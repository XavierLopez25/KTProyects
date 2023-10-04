package com.example.lab7kt.mealsincategory.repository

import com.example.lab7kt.networking.MealsWebService

import com.example.lab7kt.networking.response.CategoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsInCategoryRepository(private val webService: MealsWebService = MealsWebService()) {
    fun getMealsInCategory(categoryId: String, successCallback: (response: CategoriesResponse?) -> Unit) {

        return webService.getMealsInCategory(categoryId).enqueue(object : Callback<CategoriesResponse> {
            override fun onResponse(call: Call<CategoriesResponse>, response: Response<CategoriesResponse>) {

                if (response.isSuccessful)
                    successCallback(response.body())
            }

            override fun onFailure(call: Call<CategoriesResponse>, t: Throwable) {
            }
        })
    }
}