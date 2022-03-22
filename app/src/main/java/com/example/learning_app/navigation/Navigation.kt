package com.example.learning_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.learning_app.screens.movies.FavouriteScreen
import com.example.learning_app.screens.movies.MovieDetailsScreen
import com.example.learning_app.screens.movies.MovieScreen




@Composable
fun MovieNav(){

    val navController = rememberNavController()

   NavHost(navController = navController, startDestination = "${SCREENS.Home}"){

       composable("${SCREENS.Home}") {  MovieScreen(navController = navController) }
       //composable("MovieDetails"){ MovieDetails(navCon = navController )}


      composable("${SCREENS.Favourites}"){
           FavouriteScreen(navController = navController)
       }
       composable(
           route ="${SCREENS.MovieDetails}/{movieId}",
           arguments = listOf(
               navArgument(name = "movieId"){
                   type = NavType.StringType
               }
           )
       ){backStackEntry ->
           val movieId = backStackEntry.arguments?.getString("movieId")
               MovieDetailsScreen(movieId = movieId, navController = navController)

       }

   }
}