package com.example.lab7kt.meals.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.lab7kt.networking.response.MealResponse


/**
 * This screen displays a list of meal categories using the Jetpack Compose UI toolkit.
 * When a meal category is clicked, it navigates to the details of that category.
 *
 * @param navController NavController to handle the navigation events within the app.
 */
@Composable
fun MealsCategoriesScreen(navController: NavController) {

    // Acquire the viewModel for fetching meals.
    val viewModel: MealsCategoriesViewModel = viewModel()

    // Initialize an empty list of meals that will be updated when data is fetched.
    val rememberedMeals: MutableState<List<MealResponse>> = remember { mutableStateOf(emptyList()) }

    // Fetch meals and update the rememberedMeals state once the data is retrieved.
    viewModel.getMeals { response ->
        val mealsFromTheApi = response?.categories
        rememberedMeals.value = mealsFromTheApi.orEmpty()
    }

    // Display the list of meals.
    LazyColumn {
        items(rememberedMeals.value) { meal ->
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        navController.navigate("Category/${meal.name}")
                    }
                    .padding(8.dp),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = rememberImagePainter(
                            data = meal.imageUrl,
                            builder = {
                                crossfade(true)
                            }
                        ),
                        contentDescription = "Meal Image",
                        modifier = Modifier
                            .size(50.dp)
                            .background(Color.Gray)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(
                            text = meal.name,
                            style = MaterialTheme.typography.headlineLarge,
                        )

                    }
                }
            }
        }
    }
}

