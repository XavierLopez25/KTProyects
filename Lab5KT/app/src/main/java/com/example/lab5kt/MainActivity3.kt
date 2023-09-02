package com.example.lab5kt

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.BlurEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab5kt.ui.theme.Lab5KTTheme

class MainActivity3 : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab5KTTheme {
                RootView()
                DisplayConcertDetail()
            }
        }
    }
}

data class ConcertInfo(
    val name: String,
    val location: String,
    val imageResource: Int,
    val date: String,
    val time: String,
    val description: String
)
@Preview
@Composable
fun DisplayConcertDetail() {
    val concert = ConcertInfo(
        "Point North", "Milwaukee, WI, United States", R.drawable.point_north_tour,
        "03/09/2023", "@ 5:30pm",
        "@The Rave / Eagles Club, Milwaukee, WI\n\nPoint North is an Alt band from Los Angeles, CA\n\n" +
                "Genres: Rock, Alternative\n\n" +
                "Band Members: Sage Weeber, Andy Hershey, Jon Lundin\n\n" +
                "City of Origin: Los Angeles, California"
    )


    ConcertLayout(concert)
}

@Composable
fun ConcertLayout(concert: ConcertInfo) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopImage(imageResource = concert.imageResource)
        ConcertInfoBox(concert)
    }
}

@Composable
fun TopImage(imageResource: Int) {
    Image(
        painter = painterResource(id = imageResource),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
        ,
        contentScale = ContentScale.Crop
    )
}

@Composable
fun ConcertInfoBox(concert: ConcertInfo) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Transparent)

    ) {
        BackgroundImage(imageResource = concert.imageResource)
        ConcertDetails(concert)
    }
}

@Composable
fun BackgroundImage(imageResource: Int) {
    Image(
        painter = painterResource(id = imageResource),
        contentDescription = null,
        modifier = Modifier
            .fillMaxSize()
            .alpha(0.9f)
            .graphicsLayer {
                renderEffect = BlurEffect(70f, 70f)
            },
        contentScale = ContentScale.Crop
    )
}

@Composable
fun ConcertDetails(concert: ConcertInfo) {
    // Wrap the Column in a Box to allow it to be on top of the background image
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                    .alpha(alpha = 100f),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            ConcertInfoTop(concert)
            ConcertInfoBottom()
        }
    }
}

@Composable
fun ConcertInfoTop(concert: ConcertInfo) {
    Column(
        modifier = Modifier
            .alpha(alpha = 100f),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text("Place: ${concert.location}", fontSize = 18.sp, color = Color.White)
        Text("${concert.name}", fontWeight = FontWeight.Bold,fontSize = 25.sp, color = Color.White)
        ConcertDateTime(concert)
        Text("About:", fontSize = 16.sp, color = Color.White)
        Text(concert.description, fontSize = 16.sp, color = Color.White)
    }
}

@Composable
fun ConcertDateTime(concert: ConcertInfo) {
    Row(

        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
                .alpha(alpha = 100f),
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Filled.Favorite, contentDescription = null, tint = Color.White)
            Text("  Date: ${concert.date}", fontSize = 16.sp, color = Color.White)
        }
        Text("Hour: ${concert.time}", fontSize = 16.sp, color = Color.White)
    }
}

@Composable
fun ConcertInfoBottom() {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
                .alpha(alpha = 100f),
    ) {
        ConcertButton("Favorite")
        Spacer(modifier = Modifier.width(16.dp))
        ConcertButton("Buy")
    }
}

@Composable
fun ConcertButton(label: String) {
    Button(
        onClick = { /* Do nothing */ },
        colors = ButtonDefaults.buttonColors(Color(0xFFFFCFC5), contentColor = Color.Black)
    ) {
        Text(label)
    }
}