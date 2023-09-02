package com.example.lab5kt

import android.os.Bundle
import android.annotation.SuppressLint
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab5kt.ui.theme.Lab5KTTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab5KTTheme {
                RootView()
            }
        }
    }
}

@Composable
fun RootView() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        MainColumn()
    }
}

@Composable
fun MainColumn() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        TitleText("Todos los Eventos")
        ShowConcerts()
    }
}

@Composable
fun TitleText(title: String) {
    Text(
        text = title,
        style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.onSurface
        ),
        modifier = Modifier.padding(16.dp)
    )
}
@Preview
@Composable
fun ShowConcerts() {
    val sampleConcerts = exampleConcerts()
    val allConcerts = allExampleConcerts()

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        FavoritesHeader()
        Spacer(modifier = Modifier.height(16.dp))

        Box(modifier = Modifier.weight(1f)) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2), // Number of columns
                contentPadding = PaddingValues(16.dp)
            ) {
                items(sampleConcerts) { concert ->
                    Column {
                        DisplayConcertCard(concert)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
        }

        TitleText("Todos los Conciertos")
        Spacer(modifier = Modifier.height(16.dp))

        Box(modifier = Modifier.weight(1f)) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2), // Number of columns
                contentPadding = PaddingValues(16.dp)
            ) {
                items(allConcerts) { concert ->
                    Column {
                        DisplayConcertCard(concert)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun DisplayConcertCard(concert: Concert) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
    ) {
        Column(

            modifier = Modifier.fillMaxSize().padding(start = 1.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Image(
                painter = painterResource(id = concert.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            InfoText(concert.name, FontWeight.Bold, 18.sp)
            InfoText(concert.location, FontWeight.Normal, 16.sp)
        }
    }
}

@Composable
fun InfoText(text: String, weight: FontWeight, size: TextUnit) {
    Text(
        text = text,
        fontWeight = weight,
        fontSize = size,
        modifier = Modifier.padding(4.dp)
    )
}

@Composable
fun FavoritesHeader() {
    TitleText("Tus Favoritos")
    Spacer(modifier = Modifier.height(20.dp))
}

@Composable
fun exampleConcerts(): List<Concert> = listOf(
    Concert("Concierto 1", "Lugar 1", R.drawable.concert1),
    Concert("Concierto 2", "Lugar 2", R.drawable.concert2),
    Concert("Concierto 2", "Lugar 2", R.drawable.concert3),
    Concert("Concierto 2", "Lugar 2", R.drawable.concert4)
)

@Composable
fun allExampleConcerts(): List<Concert> = listOf(
    Concert("Concierto A", "Lugar 1", R.drawable.concert1),
    Concert("Concierto B", "Lugar 2", R.drawable.concert2),
    Concert("Concierto A", "Lugar 1", R.drawable.concert3),
    Concert("Concierto A", "Lugar 1", R.drawable.concert4)
)

data class Concert(val name: String, val location: String, val imageRes: Int)

