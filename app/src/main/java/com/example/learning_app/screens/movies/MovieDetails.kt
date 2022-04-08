package com.example.learning_app.screens.movies

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.learning_app.Movie
import com.example.learning_app.getMovies
import com.example.learning_app.navigation.SCREENS
import com.example.learning_app.viewmodels.FavouritesViewModel
import com.example.learning_app.widgets.AddToFavourites
import com.example.learning_app.widgets.MovieRow


@Composable
fun MovieDetailsScreen(
    movieId: String?,
    navController: NavController,
    favViewModel: FavouritesViewModel
) {

    val movie: Movie = getMovies().single { movie -> movie.id == movieId }
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
                    Text(text = "${movie.title}", style = MaterialTheme.typography.h6)
                }
            }
        }) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MovieRow(movie = movie, true) {
                AddToFavourites(movie = movie, isFav = favViewModel.movieExists(movie)) {
                    favViewModel.addMovie(movie)
                }
            }
            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.padding(top = 10.dp, bottom = 2.dp)
            )
            Text(
                text = "Movie Images",
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(4.dp)
            )
            imageSlider(images = movie.images)
        }

    }
}

@Composable
fun imageSlider(images: List<String>) {
    LazyRow(Modifier.fillMaxHeight()) {
        items(images) { image ->
            Card(
                modifier = Modifier
                    .padding(4.dp)
                    .size(250.dp)
            ) {
                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(image)
                        .crossfade(true)
                        .build(),
                    contentDescription = "movie image",
                    contentScale = ContentScale.Crop
                )
            }

        }
    }
}