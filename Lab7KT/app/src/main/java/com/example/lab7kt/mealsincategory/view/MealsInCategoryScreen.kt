package com.example.lab7kt.mealsincategory.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import com.example.lab7kt.navigation.NavigationState
import com.example.lab7kt.networking.response.CategoryResponse
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter


// Composable function for the screen that displays meals in a given category.
@Composable
fun MealsInCategoryScreen(categoryId: String, navController: NavController) {
    // Obtains an instance of the ViewModel for this screen.
    val viewModel: MealsInCategoryViewModel = viewModel()

    // Remembered state for the meals list.
    val rememberedMeals: MutableState<List<CategoryResponse>> = remember { mutableStateOf(emptyList()) }

    // Request meals based on the category ID and update the remembered state.
    viewModel.getMealsInCategory(categoryId) { response ->
        val mealsFromTheApi = response?.categories
        rememberedMeals.value = mealsFromTheApi.orEmpty()
    }

    // LazyColumn to efficiently display a potentially large list of meals.
    LazyColumn {
        items(rememberedMeals.value) { meal ->
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        // Navigate to the details screen when a meal is clicked.
                        navController.navigate("${NavigationState.Detail.route}/${meal.idmeal}")
                    }
                    .padding(8.dp),
            ) {
                // Row layout for displaying each meal with its image on the left and name on the right.
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Display the meal's image.
                    Image(
                        painter = rememberImagePainter(
                            data = meal.mealthumb,
                            builder = {
                                crossfade(true)
                            }
                        ),
                        contentDescription = "Meal Image",
                        modifier = Modifier
                            .size(50.dp)
                            .background(Color.Gray)
                    )

                    // Spacer for adding space between the image and the text.
                    Spacer(modifier = Modifier.width(16.dp))

                    // Display the meal's name.
                    Text(
                        text = meal.name,
                        style = MaterialTheme.typography.headlineLarge,
                    )
                }
            }
        }
    }
}

