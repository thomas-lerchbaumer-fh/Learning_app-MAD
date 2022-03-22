package com.example.learning_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.learning_app.navigation.MovieNav
import com.example.learning_app.screens.movies.MovieScreen
import com.example.learning_app.ui.theme.Learning_appTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieNav()
        }
    }
}

