package com.example.lab7kt.mealdetail.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab7kt.mealdetail.repository.MealDetailRepository
import com.example.lab7kt.navigation.response.MealDetailResponse

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MealDetailViewModel(
    private val repository: MealDetailRepository = MealDetailRepository()
) : ViewModel() {

    private val _mealDetail = MutableStateFlow<MealDetailResponse?>(null)
    val mealDetail: StateFlow<MealDetailResponse?> get() = _mealDetail

    fun getMealDetail(mealId: String) {
        viewModelScope.launch {
            val response = repository.getMealDetail(mealId)
            _mealDetail.value = response
        }
    }
}