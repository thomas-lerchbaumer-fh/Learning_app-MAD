package com.example.learning_app.screens.movies

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import com.example.learning_app.Movie
import com.example.learning_app.getMovies
import com.example.learning_app.navigation.SCREENS
import com.example.learning_app.widgets.MovieRow

@Composable
fun FavouriteScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back")
                    }
                    Text(text = "My Favourite Movies", style = MaterialTheme.typography.h6)
                }
            }
        }) {

        val movieList = listOf<Movie>(
            getMovies()[0],
            getMovies()[1],
        )
        MainMovieTheme2(movieList, navController = navController)
    }

}