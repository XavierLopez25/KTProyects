package com.example.lab7kt.mealdetail.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab7kt.mealdetail.repository.MealDetailRepository
import com.example.lab7kt.networking.response.MealDetailResponse

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel responsible for providing meal detail data to the UI.
 * This ViewModel collaborates with the [MealDetailRepository] to fetch the data.
 *
 * @param repository an instance of [MealDetailRepository] for fetching meal details.
 * Defaults to a new instance of [MealDetailRepository] if not provided.
 */
class MealDetailViewModel(
    private val repository: MealDetailRepository = MealDetailRepository()) : ViewModel() {

    // Private MutableStateFlow to handle the state of the meal detail data internally
    private val _mealDetail = MutableStateFlow<MealDetailResponse?>(null)

    /**
     * Public read-only StateFlow to expose the meal detail data to the UI.
     * External classes can only observe this StateFlow but cannot modify its state.
     */
    val mealDetail: StateFlow<MealDetailResponse?> get() = _mealDetail

    /**
     * Fetches the details of a meal with the given ID and updates [_mealDetail] with the response.
     *
     * @param mealId the unique identifier of the meal whose details need to be fetched.
     */
    fun getMealDetail(mealId: String) {
        viewModelScope.launch {
            val response = repository.getMealDetail(mealId)
            _mealDetail.value = response
        }
    }
}