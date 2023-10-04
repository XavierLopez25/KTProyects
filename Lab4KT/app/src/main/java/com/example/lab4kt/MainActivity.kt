package com.example.lab4kt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.mutableStateListOf
import com.example.lab4kt.ui.theme.Lab4KTTheme

class MainActivity : ComponentActivity() {
    data class Item(val name: String, val imageUrl: String)

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab4KTTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        //TopAppBar for title
                        TopAppBar(
                            title = {
                                Text("Lab 4 - Food App")
                            }
                        )

                        //UI design
                        Column(
                            modifier = Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            val items = remember { mutableStateListOf<Item>() }
                            val addItem: (Item) -> Unit = { item -> items.add(item) }

                            LabelAndPlaceHolders(addItem)
                            MyLazyColumn(items)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun LabelAndPlaceHolders(addItem: (MainActivity.Item) -> Unit) {
    var text1 by remember { mutableStateOf(TextFieldValue("")) }
    var text2 by remember { mutableStateOf(TextFieldValue("")) }

    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        TextField(
            value = text1,
            onValueChange = { text1 = it },
            label = { Text(text = "Enter food element") },
            placeholder = { Text(text = "Enter food name") },
            modifier = Modifier.weight(1f)
        )

        TextField(
            value = text2,
            onValueChange = { text2 = it },
            label = { Text(text = "Image URL") },
            placeholder = { Text(text = "Enter URL") },
            modifier = Modifier.weight(1f)
        )
    }

    Button(onClick = {
        if (text1.text.isNotBlank() && text2.text.isNotBlank()) {
            addItem(MainActivity.Item(text1.text, text2.text))
            //text1 = TextFieldValue("")
            //text2 = TextFieldValue("")
        }
    }) {
        Text("Add Recipe")
    }
}

@Composable
fun MyLazyColumn(items: List<MainActivity.Item>) {
    LazyColumn {
        items(items) { item ->
            ItemCard(item)
        }
    }
}

@Composable
fun ItemCard(item: MainActivity.Item) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Image(
            painter = rememberImagePainter(item.imageUrl),
            contentDescription = null,  // Consider providing a proper content description
            modifier = Modifier.size(50.dp, 50.dp)
        )
        Text(text = item.name)
    }
}