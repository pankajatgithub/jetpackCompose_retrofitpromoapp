package com.example.jetpackcompose_retrofitpromoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.jetpackcompose_retrofitpromoapp.repository.CharacterRepo
import com.example.jetpackcompose_retrofitpromoapp.retrofit.Character
import com.example.jetpackcompose_retrofitpromoapp.retrofit.RetrofitInstance
import com.example.jetpackcompose_retrofitpromoapp.ui.theme.JetpackCompose_retrofitpromoappTheme
import com.example.jetpackcompose_retrofitpromoapp.viewmodel.CharacterViewModel

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
                    val characterApi =
                        RetrofitInstance.provideApi(RetrofitInstance.provideRetrofit())
                    val characterRepo = CharacterRepo(characterApi)
                    val characterViewModel = CharacterViewModel(characterRepo)
                    MainScreen(characterViewModel)
                }
            }
        }
    }
}

@Composable
fun MainScreen(viewModel: CharacterViewModel) {
    val characterZ by viewModel.state.collectAsState()
//filterring the actors and image only items, remove empty items

   val nonEmptyList = mutableListOf<Character>()
    characterZ.forEach{

        if (it.image != ""){
            nonEmptyList.add(it)
        }
    }

    ActorsList(charaterList = nonEmptyList)

}

@Composable
fun ActorsList(charaterList: List<Character>) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(8.dp)
    ) {
        items(items = charaterList) { item ->
            CardItem(character = item)
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CardItem(character: Character) {
    Column() {

        GlideImage(
            model = character.image,
            contentDescription = "character image",
            modifier = Modifier
                .padding(4.dp)
                .size(width = 140.dp, height = 180.dp)
        )

        Text(text = character.actor, fontSize = 20.sp)

    }
}