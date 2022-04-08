package com.example.learning_app.widgets

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.learning_app.Movie


@Composable
fun AddToFavourites(
    movie: Movie, isFav: Boolean,
    onSaveClick: (Movie) -> Unit = {}
) {
    //icons.default.favourite
    Row(
        horizontalArrangement = Arrangement.End,
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 20.dp)
    ) {
        when (isFav) {
            true -> Icon(imageVector = Icons.Outlined.Favorite, contentDescription = "fav icon",
                tint = MaterialTheme.colors.primary,
                modifier = Modifier.clickable {
                    onSaveClick(movie)
                    Log.d("MovieList", "list ${isFav}")
                })
            false -> Icon(imageVector = Icons.Outlined.FavoriteBorder,
                contentDescription = "fav icon",
                tint = MaterialTheme.colors.primary,
                modifier = Modifier.clickable {
                    onSaveClick(movie)
                    Log.d("MovieList", "list1 ${isFav}")
                })
        }


    }


}