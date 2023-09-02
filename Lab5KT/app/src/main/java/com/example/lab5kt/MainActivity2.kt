package com.example.lab5kt

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import android.os.Bundle
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab5kt.ui.theme.Lab5KTTheme

class MainActivity2 : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab5KTTheme {
                RootView()
                DisplayConcerts()
            }
        }
    }
}

data class ConcertC(val name: String, val location: String)


@Preview
@Composable
fun DisplayConcerts() {
    val concertDetails = listOf(ConcertC("Concert A", "Location A"), ConcertC("Concert B", "Location B")) // Datos de ejemplo

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        LazyColumn(
            contentPadding = PaddingValues(12.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            items(concertDetails, key = { concert -> concert.name }) { singleConcert ->
                ConcertItem(singleConcert)
                AddDivider()
            }
        }
    }
}

@Composable
fun ConcertItem(concertInfo: ConcertC) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        Spacer(modifier = Modifier.width(2.dp))

        Box(
            modifier = Modifier
                .size(52.dp)
                .background(Color(0xFFE5DDFB), shape = CircleShape)
                .align(Alignment.CenterVertically),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "A",
                fontSize = 26.sp,
                color = Color(0xFF3A2F71),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .align(Alignment.CenterVertically)
        ) {
            Text(
                text = concertInfo.name,
                fontWeight = FontWeight.Bold,
                fontSize = 19.sp
            )
            Text(
                text = concertInfo.location,
                fontSize = 17.sp
            )
        }

        Icon(
            imageVector = Icons.Default.KeyboardArrowUp,
            contentDescription = null,
            modifier = Modifier
                .size(22.dp)
                .align(Alignment.CenterVertically)
        )

        Spacer(modifier = Modifier.width(18.dp))
    }
}

@Composable
fun AddDivider() {
    Spacer(modifier = Modifier.height(17.dp))
    Divider(
        color = Color.Gray,
        thickness = 1.dp,
        modifier = Modifier.padding(horizontal = 12.dp)
    )
}

