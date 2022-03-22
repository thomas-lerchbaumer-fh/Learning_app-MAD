package com.example.learning_app.widgets

import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.learning_app.Movie
import com.example.learning_app.R


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MovieRow(movie: Movie, showDetails: Boolean = false, onItemClick: (String) -> Unit) {
    var showDetails by remember {
        mutableStateOf(showDetails)
    }
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .clickable { onItemClick(movie.id) },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = 6.dp,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier
                    .size(120.dp)
                    .padding(12.dp)
                    .clip(CircleShape),
                elevation = 6.dp,

                ) {
                //Icon(imageVector = Icons.Default.AccountBox , contentDescription ="movie image" )
                AsyncImage(
                    model = "${movie.images[0]}",
                    contentDescription = "${movie.title}",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.clip(CircleShape)
                )
            }
            Column(
                modifier = Modifier.align(alignment = Alignment.CenterVertically)
            ) {
                Text(text = movie.title, style = MaterialTheme.typography.h6)
                Text(text = "Director: ${movie.director}", style = MaterialTheme.typography.body2)
                Text(text = "Released: ${movie.year}", style = MaterialTheme.typography.body2)
                AnimatedVisibility(
                    visible = showDetails,
                    enter = fadeIn(),
                    exit = slideOutHorizontally() + shrinkVertically() + fadeOut()
                ) {
                    MovieDetails(movie)
                }
                when (showDetails) {
                    true -> Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "arrow down",
                        modifier = Modifier.clickable { showDetails = !showDetails })
                    false -> Icon(
                        imageVector = Icons.Default.KeyboardArrowUp,
                        contentDescription = "arrow down",
                        modifier = Modifier.clickable { showDetails = !showDetails })
                }

            }

        }
    }
}

@Composable
fun MovieDetails(movie: Movie) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Column() {
            Text(text = "Plot: ${movie.plot}", style = MaterialTheme.typography.body2)
            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.padding(top = 2.dp, bottom = 2.dp)
            )
            Text(text = "Genre: ${movie.genre}", style = MaterialTheme.typography.body2)
            Text(text = "Actor: ${movie.actors}", style = MaterialTheme.typography.body2)
            Text(text = "Rating: ${movie.rating}", style = MaterialTheme.typography.body2)
        }

    }
}