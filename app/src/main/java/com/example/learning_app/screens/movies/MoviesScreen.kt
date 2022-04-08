package com.example.learning_app.screens.movies

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.learning_app.Movie
import com.example.learning_app.getMovies
import com.example.learning_app.navigation.SCREENS
import com.example.learning_app.ui.theme.Learning_appTheme
import com.example.learning_app.viewmodels.FavouritesViewModel
import com.example.learning_app.widgets.MovieRow

@Composable
fun MovieScreen(navController: NavController, favViewModel : FavouritesViewModel) {
    Surface(
        color = MaterialTheme.colors.background
    ) {
        var showMenu by remember {
            mutableStateOf(false)
        }
        Scaffold(
            topBar = {
                TopAppBar(title = { Text(text = "Movies") },
                    actions = {
                        IconButton(onClick = { showMenu = !showMenu }) {
                            Icon(imageVector = Icons.Default.MoreVert, contentDescription = "more")
                        }
                        DropdownMenu(expanded = showMenu, onDismissRequest = { showMenu = false }) {
                            DropdownMenuItem(onClick = {
                                navController.navigate(route = "${SCREENS.Favourites}")
                            }) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {

                                    Icon(
                                        imageVector = Icons.Default.Favorite,
                                        contentDescription = "fav icon",
                                        modifier = Modifier.padding(2.dp)
                                    )
                                    Text(
                                        text = "Favourites", style = MaterialTheme.typography.h6,
                                        modifier = Modifier
                                            .padding(2.dp)
                                            .width(120.dp)
                                    )
                                }
                            }
                        }
                    })
            }
        ) {
            MainMovieTheme2(getMovies(), navController = navController, favViewModel);
        }
    }
}

@Composable
fun MainMovieTheme2(data: List<Movie>, navController: NavController, favViewModel: FavouritesViewModel, onFav : Boolean = false) {
    LazyColumn() {
        items(data) { item ->
            MovieRow(item,false,favViewModel, onFav) {
                    movieId ->
                navController.navigate(route = "${SCREENS.MovieDetails}/$movieId")

            }
        }
    }

}


