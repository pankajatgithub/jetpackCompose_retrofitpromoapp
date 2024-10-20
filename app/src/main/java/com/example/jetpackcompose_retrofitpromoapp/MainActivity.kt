package com.example.jetpackcompose_retrofitpromoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcompose_retrofitpromoapp.ui.theme.JetpackCompose_retrofitpromoappTheme
//https://hp-api.onrender.com/api/characters - api response
//https://square.github.io/retrofit/  - retrofit library details, GSON is popular but moshi converter is good for jetpack compose,
//https://github.com/square/moshi
//https://github.com/square/retrofit  - retrofit latest version
//get data from internet
//https://developer.android.com/codelabs/basic-android-kotlin-compose-getting-data-internet?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-5-pathway-1%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-getting-data-internet#5
//load data from internet
//https://developer.android.com/courses/pathways/android-basics-compose-unit-5-pathway-2
//https://developer.android.com/kotlin/coroutines#kts - kotlin coroutine
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackCompose_retrofitpromoappTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackCompose_retrofitpromoappTheme {
        Greeting("Android")
    }
}