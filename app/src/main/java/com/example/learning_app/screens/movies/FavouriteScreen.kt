package com.example.learning_app.screens.movies

import android.content.res.Resources
import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.learning_app.Movie
import com.example.learning_app.getMovies
import com.example.learning_app.navigation.SCREENS
import com.example.learning_app.viewmodels.FavouritesViewModel
import com.example.learning_app.widgets.AddToFavourites
import com.example.learning_app.widgets.MovieRow

@Composable
fun FavouriteScreen(navController: NavController, favViewModel : FavouritesViewModel) {
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

        val movieList = favViewModel.favMovies
        if(!movieList.isEmpty()){
            LazyColumn() {
                items(movieList) { item ->
                    MovieRow(item, false, onItemClick = { movieId ->
                        navController.navigate(route = "${SCREENS.MovieDetails}/$movieId")
                    })

                }

            }
            //MainMovieTheme2(movieList, navController = navController,favViewModel,true)
        }
        else{
            Card(
                modifier = Modifier.fillMaxWidth()
                    .padding(top= 40.dp, start = 20.dp, end = 20.dp)
                    .height(200.dp),
                backgroundColor = MaterialTheme.colors.primary,
                shape = RoundedCornerShape(corner = CornerSize(16.dp))
                ,

            ) {
                Box(Modifier.wrapContentSize(Alignment.Center)) {
                    Text(
                        text = "Sorry your favourites are empty :(",
                        style = MaterialTheme.typography.body2
                    )
                }
            }

        }

    }

}