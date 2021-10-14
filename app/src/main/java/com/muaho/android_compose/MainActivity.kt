package com.muaho.android_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Check
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.muaho.android_compose.ui.theme.MuaHoTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MuaHoTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Home("Android")
                }
            }
        }
    }
}

@Composable
fun Home(name: String) {
    Column(
        Modifier.padding(all = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Greeting(name = name)
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        ButtonWidget()

        HelloContent()
    }
}


@Composable
fun Greeting(name: String) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth(),
    ) {
        Text(text = "Hello, ")
        Text(text = "$name!")
        Icon(
            Icons.Outlined.Check,
            contentDescription = "Favorite",
            modifier = Modifier.size(ButtonDefaults.IconSize),
            tint = Color.Red,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MuaHoTheme {
        Greeting("Android")
    }
}

@Composable
fun ButtonWidget() {
    Button(
        onClick = { /* ... */ },
        contentPadding = PaddingValues(
            start = 20.dp,
            top = 12.dp,
            end = 20.dp,
            bottom = 12.dp
        )
    ) {
        // Inner content including an icon and a text label
        Icon(
            Icons.Filled.Favorite,
            contentDescription = "Favorite",
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text("Say Hi!")
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonPreview() {
    MuaHoTheme {
        ButtonWidget()
    }
}



@Composable
fun HelloContent() {
    Column(modifier = Modifier.padding(16.dp)) {
        var textValue by remember {
            mutableStateOf("")
        }

        if (textValue.isNotEmpty()) {
            Text(
                text = "Hello, $textValue!",
                modifier = Modifier.padding(bottom = 8.dp),
                style = MaterialTheme.typography.h5
            )
        }
        OutlinedTextField(
            value = textValue,
            onValueChange = { textValue = it },
            label = { Text("Name") }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HelloContentPreview() {
    MuaHoTheme {
        HelloContent()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomePreview() {
    MuaHoTheme {
        Home("Android")
    }
}