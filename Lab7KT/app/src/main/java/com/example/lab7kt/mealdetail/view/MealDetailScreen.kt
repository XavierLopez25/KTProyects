package com.example.lab7kt.mealdetail.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter


/**
 * Composable screen to display detailed information about a specific meal.
 *
 * @param mealId The ID of the meal to fetch and display details for.
 */
@Composable
fun MealDetailScreen(mealId: String) {

    // Initialize the view model
    val viewModel: MealDetailViewModel = viewModel()

    // Use LaunchedEffect to execute side-effecting code (fetching the meal details)
    // only once when the mealId changes.
    LaunchedEffect(mealId) {
        viewModel.getMealDetail(mealId)
    }

    // Observe the meal detail from the view model
    val mealDetail by viewModel.mealDetail.collectAsState(null)

    // Surface provides a container, useful for background, elevation, etc.
    Surface(modifier = Modifier.fillMaxSize()) {
        if (mealDetail != null) {
            val meal = mealDetail!!.meals?.first()
            meal?.let {
                // Card provides a styled surface, often used for UI items with elevation
                Card(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {

                        // Display the meal's image with a crossfade effect
                        Image(
                            painter = rememberImagePainter(
                                data = meal.strMealThumb,
                                builder = {
                                    crossfade(true)
                                }
                            ),
                            contentDescription = "Meal Image",
                            modifier = Modifier.size(50.dp).background(Color.Gray)
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        // Display the name of the meal
                        Text(
                            text = it.strMeal,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        // Display the category and area of the meal in a row
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = "Category: ${it.strCategory}")
                            Text(text = "Area: ${it.strArea}")
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        // Display cooking instructions
                        Text(
                            text = "Instructions:",
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = it.strInstructions,
                            textAlign = TextAlign.Justify,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }
            }
        } else {
            // Display a loading indicator if meal details aren't yet available
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
    }
}